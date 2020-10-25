package com.htc.vita.mod.android.auth;

import com.htc.vita.core.auth.OAuth2AuthorizationCodeReceiver;
import com.htc.vita.core.concurrent.CancellationToken;
import com.htc.vita.core.internal.TaskRunner;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.util.StringUtils;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AndroidOAuth2AuthorizationCodeReceiver extends OAuth2AuthorizationCodeReceiver {
    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private final Object mLock = new Object();

    private String mAuthorizationCode = null;
    private CancellationToken mCancellationToken;
    private boolean mIsClosed;
    private String mRedirectUri;

    @Override
    public void close() {
        mCountDownLatch.countDown();
        mIsClosed = true;
    }

    @Override
    protected OAuth2AuthorizationCodeReceiver onInitialize(
            Map<String, String> options,
            CancellationToken cancellationToken) {
        mCancellationToken = cancellationToken;
        mRedirectUri = options.get(OPTION_REDIRECT_URI);
        if (StringUtils.isNullOrWhiteSpace(mRedirectUri)) {
            return this;
        }

        TaskRunner.execute(new Runnable() {
                @Override
                public void run() {
                    while (!AndroidOAuth2AuthorizationCodeWebViewClient.AUTHORIZATION_CODE_MAP.containsKey(mRedirectUri)) {
                        if (mCancellationToken.isCancellationRequested()) {
                            return;
                        }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            Logger.getInstance(AndroidOAuth2AuthorizationCodeReceiver.class.getSimpleName()).error(e.toString());
                        }
                    }
                    mAuthorizationCode = AndroidOAuth2AuthorizationCodeWebViewClient.AUTHORIZATION_CODE_MAP.remove(mRedirectUri);
                    mCountDownLatch.countDown();
                }
        });
        return this;
    }

    @Override
    protected ReceiveResult onReceive() {
        synchronized (mLock) {
            throwIfClosed();

            if (StringUtils.isNullOrWhiteSpace(mRedirectUri)) {
                return new ReceiveResult()
                        .setStatus(ReceiveStatus.UnsupportedReceiver);
            }
            if (mCancellationToken.isCancellationRequested()) {
                return new ReceiveResult()
                        .setStatus(ReceiveStatus.CancelledReceiving);
            }
            try {
                mCountDownLatch.await();
                if (mCancellationToken.isCancellationRequested()) {
                    return new ReceiveResult()
                            .setStatus(ReceiveStatus.CancelledReceiving);
                }
                if (StringUtils.isNullOrWhiteSpace(mAuthorizationCode)) {
                    return new ReceiveResult()
                            .setStatus(ReceiveStatus.InvalidAuthorizationCode);
                }
                return new ReceiveResult()
                        .setStatus(ReceiveStatus.Ok)
                        .setCode(mAuthorizationCode);
            } catch (InterruptedException e) {
                Logger.getInstance(AndroidOAuth2AuthorizationCodeReceiver.class.getSimpleName()).error(e.toString());
            }
            return new ReceiveResult()
                    .setStatus(ReceiveStatus.CancelledReceiving);
        }
    }

    private void throwIfClosed() {
        if (mIsClosed) {
            throw new IllegalStateException(String.format(
                    "%s is already closed",
                    AndroidOAuth2AuthorizationCodeReceiver.class.getSimpleName()
            ));
        }
    }
}
