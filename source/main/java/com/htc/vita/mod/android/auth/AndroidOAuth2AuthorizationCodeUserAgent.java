package com.htc.vita.mod.android.auth;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.htc.vita.core.auth.OAuth2AuthorizationCodeUserAgent;
import com.htc.vita.core.concurrent.CancellationToken;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class AndroidOAuth2AuthorizationCodeUserAgent extends OAuth2AuthorizationCodeUserAgent {
    private final Object mLock = new Object();

    private WebView mAndroidOAuth2WebView;
    private AndroidOAuth2AuthorizationCodeWebViewClient mAndroidOAuth2WebViewClient;
    private URI mAuthorizationUri;
    private CancellationToken mCancellationToken;
    private boolean mIsClosed;
    private boolean mShouldEnableJavascriptInWebView = false;

    @Override
    public void close() {
        mIsClosed = true;
        mAndroidOAuth2WebView = null;
        mAndroidOAuth2WebViewClient = null;
    }

    @Override
    protected OAuth2AuthorizationCodeUserAgent onInitialize(
            Map<String, Object> options,
            CancellationToken cancellationToken) {
        synchronized (mLock) {
            throwIfClosed();

            mAuthorizationUri = parseAuthorizationUri(options);
            mCancellationToken = cancellationToken;
            Map<?, ?> androidJavascriptActionMapOnUrlPrefixFinished = null;
            Object androidJavascriptActionMapOnUrlPrefixFinishedAsObject = options.get(OPTION_ANDROID_JAVASCRIPT_ACTION_MAP_ON_URL_PREFIX_FINISHED);
            if (androidJavascriptActionMapOnUrlPrefixFinishedAsObject instanceof Map<?, ?>) {
                androidJavascriptActionMapOnUrlPrefixFinished = (Map<?, ?>) androidJavascriptActionMapOnUrlPrefixFinishedAsObject;
            }
            if (androidJavascriptActionMapOnUrlPrefixFinished != null) {
                for (Object itemKey : androidJavascriptActionMapOnUrlPrefixFinished.keySet()) {
                    if (!(itemKey instanceof String)) {
                        continue;
                    }
                    Object itemValue = androidJavascriptActionMapOnUrlPrefixFinished.get(itemKey);
                    if (!(itemValue instanceof String)) {
                        continue;
                    }
                    String key = (String) itemKey;
                    String value = (String) itemValue;
                    if (!StringUtils.isNullOrWhiteSpace(value)) {
                        mShouldEnableJavascriptInWebView = true;
                    }
                    mAndroidOAuth2WebViewClient = new AndroidOAuth2AuthorizationCodeWebViewClient()
                            .setJavaScriptActionOnPageFinished(
                                    key,
                                    value
                            );
                }
            }
            WebView androidWebviewInstance = null;
            Object androidWebviewInstanceAsObject = options.get(OBJECT_ANDROID_WEBVIEW_INSTANCE);
            if (androidWebviewInstanceAsObject instanceof WebView) {
                androidWebviewInstance = (WebView) androidWebviewInstanceAsObject;
            }
            mAndroidOAuth2WebView = androidWebviewInstance;
        }
        return this;
    }

    @Override
    protected LaunchResult onLaunch() {
        synchronized (mLock) {
            throwIfClosed();

            if (mAuthorizationUri == null) {
                return new LaunchResult()
                        .setStatus(LaunchStatus.InvalidAuthorizationUri);
            }
            if (mCancellationToken.isCancellationRequested()) {
                return new LaunchResult()
                        .setStatus(LaunchStatus.CancelledLaunching);
            }
            String scheme = mAuthorizationUri.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                Logger.getInstance(AndroidOAuth2AuthorizationCodeUserAgent.class.getSimpleName()).error(StringUtils.rootLocaleFormat(
                        "Can not find valid scheme: %s",
                        scheme
                ));
                return new LaunchResult()
                        .setStatus(LaunchStatus.InvalidAuthorizationUri);
            }

            if (mAndroidOAuth2WebView == null) {
                return new LaunchResult()
                        .setStatus(LaunchStatus.UnsupportedUserAgent);
            }
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                    @SuppressLint("SetJavaScriptEnabled")
                    @Override
                    public void run() {
                            try {
                                mAndroidOAuth2WebView.setWebViewClient(mAndroidOAuth2WebViewClient);
                                WebSettings webSettings = mAndroidOAuth2WebView.getSettings();
                                if (!webSettings.getJavaScriptEnabled() && mShouldEnableJavascriptInWebView) {
                                    Logger.getInstance(AndroidOAuth2AuthorizationCodeUserAgent.class.getSimpleName()).warn("Enable Javascript in WebView for auth");
                                    webSettings.setJavaScriptEnabled(true);
                                }
                                // CookieManager.getInstance().removeAllCookie();
                                mAndroidOAuth2WebView.loadUrl(mAuthorizationUri.toString());
                            } catch (Exception e) {
                                Logger.getInstance(AndroidOAuth2AuthorizationCodeUserAgent.class.getSimpleName()).error(e.toString());
                            }
                    }
            });
            return new LaunchResult()
                    .setStatus(LaunchStatus.Ok);
        }
    }

    private static URI parseAuthorizationUri(Map<String, Object> options) {
        if (options == null || options.isEmpty()) {
            return null;
        }
        Object authorizationUriAsObject = options.get(OPTION_AUTHORIZATION_URL);
        if (authorizationUriAsObject == null) {
            return null;
        }
        String authorizationUriString = null;
        if (authorizationUriAsObject instanceof String) {
            authorizationUriString = (String) authorizationUriAsObject;
        }
        if (StringUtils.isNullOrWhiteSpace(authorizationUriString)) {
            return null;
        }

        try {
            return new URI(authorizationUriString);
        } catch (URISyntaxException e) {
            Logger.getInstance(AndroidOAuth2AuthorizationCodeUserAgent.class.getSimpleName()).error(e.toString());
        }
        return null;
    }

    private void throwIfClosed() {
        if (mIsClosed) {
            throw new IllegalStateException(String.format(
                    "%s is already closed",
                    AndroidOAuth2AuthorizationCodeUserAgent.class.getSimpleName()
            ));
        }
    }
}
