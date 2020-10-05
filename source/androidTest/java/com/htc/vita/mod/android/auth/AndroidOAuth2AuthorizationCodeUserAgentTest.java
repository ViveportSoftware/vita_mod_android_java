package com.htc.vita.mod.android.auth;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.support.test.runner.AndroidJUnit4;
import android.webkit.WebView;
import com.htc.vita.core.auth.OAuth2AuthorizationCodeUserAgent;
import com.htc.vita.core.auth.OAuth2AuthorizationCodeUserAgentFactory;
import com.htc.vita.core.concurrent.CancellationToken;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.util.MapBuilder;
import com.htc.vita.mod.android.app.ApplicationContextProxy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@RunWith(AndroidJUnit4.class)
public class AndroidOAuth2AuthorizationCodeUserAgentTest {
    @Test
    public void android_0_getInstance() {
        OAuth2AuthorizationCodeUserAgentFactory.register(AndroidOAuth2AuthorizationCodeUserAgentFactory.class);
        OAuth2AuthorizationCodeUserAgentFactory oAuth2AuthorizationCodeUserAgentFactory = OAuth2AuthorizationCodeUserAgentFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgentFactory);
        Assert.assertTrue(oAuth2AuthorizationCodeUserAgentFactory instanceof AndroidOAuth2AuthorizationCodeUserAgentFactory);

        oAuth2AuthorizationCodeUserAgentFactory = OAuth2AuthorizationCodeUserAgentFactory.getInstance(AndroidOAuth2AuthorizationCodeUserAgentFactory.class);
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgentFactory);
        Assert.assertTrue(oAuth2AuthorizationCodeUserAgentFactory instanceof AndroidOAuth2AuthorizationCodeUserAgentFactory);
    }

    @Test
    public void android_1_getUserAgent() {
        OAuth2AuthorizationCodeUserAgentFactory.register(AndroidOAuth2AuthorizationCodeUserAgentFactory.class);
        OAuth2AuthorizationCodeUserAgentFactory oAuth2AuthorizationCodeUserAgentFactory = OAuth2AuthorizationCodeUserAgentFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgentFactory);
        OAuth2AuthorizationCodeUserAgent oAuth2AuthorizationCodeUserAgent = oAuth2AuthorizationCodeUserAgentFactory.getUserAgent();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgent);
    }

    @Test
    public void oAuth2AuthorizationCodeUserAgent_0_launch() {
        OAuth2AuthorizationCodeUserAgentFactory.register(AndroidOAuth2AuthorizationCodeUserAgentFactory.class);
        OAuth2AuthorizationCodeUserAgentFactory oAuth2AuthorizationCodeUserAgentFactory = OAuth2AuthorizationCodeUserAgentFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgentFactory);
        OAuth2AuthorizationCodeUserAgent oAuth2AuthorizationCodeUserAgent = oAuth2AuthorizationCodeUserAgentFactory.getUserAgent();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgent);

        OAuth2AuthorizationCodeUserAgent.LaunchResult launchResult = oAuth2AuthorizationCodeUserAgent.launch();
        OAuth2AuthorizationCodeUserAgent.LaunchStatus launchStatus = launchResult.getStatus();
        Assert.assertEquals(OAuth2AuthorizationCodeUserAgent.LaunchStatus.InvalidAuthorizationUri, launchStatus);
    }

    @Test
    public void oAuth2AuthorizationCodeUserAgent_0_launch_withAuthorizationUri() {
        OAuth2AuthorizationCodeUserAgentFactory.register(AndroidOAuth2AuthorizationCodeUserAgentFactory.class);
        OAuth2AuthorizationCodeUserAgentFactory oAuth2AuthorizationCodeUserAgentFactory = OAuth2AuthorizationCodeUserAgentFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgentFactory);

        String fullAuthorizationUriString = "http://localhost/authorize";
        OAuth2AuthorizationCodeUserAgent oAuth2AuthorizationCodeUserAgent = oAuth2AuthorizationCodeUserAgentFactory.getUserAgent(
                new MapBuilder<String, Object>().put(
                        OAuth2AuthorizationCodeUserAgent.OPTION_AUTHORIZATION_URL,
                        fullAuthorizationUriString
                ).toMap(),
                CancellationToken.NONE
        );
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgent);

        OAuth2AuthorizationCodeUserAgent.LaunchResult launchResult = oAuth2AuthorizationCodeUserAgent.launch();
        OAuth2AuthorizationCodeUserAgent.LaunchStatus launchStatus = launchResult.getStatus();
        Assert.assertEquals(OAuth2AuthorizationCodeUserAgent.LaunchStatus.UnsupportedUserAgent, launchStatus);
    }

    @Test
    public void oAuth2AuthorizationCodeUserAgent_0_launch_withAuthorizationUriAndWebView() throws InterruptedException {
        OAuth2AuthorizationCodeUserAgentFactory.register(AndroidOAuth2AuthorizationCodeUserAgentFactory.class);
        OAuth2AuthorizationCodeUserAgentFactory oAuth2AuthorizationCodeUserAgentFactory = OAuth2AuthorizationCodeUserAgentFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgentFactory);

        String fullAuthorizationUriString = "http://localhost/authorize";
        final CountDownLatch webViewLatch = new CountDownLatch(1);
        final WebView[] webviewList = new WebView[]{ null };
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
                @SuppressLint("SetJavaScriptEnabled")
                @Override
                public void run() {
                        try {
                            webviewList[0] = new WebView(ApplicationContextProxy.getInstance().getApplicationContext());
                            webviewList[0].getSettings().setJavaScriptEnabled(true);
                            webviewList[0].clearFormData();
                            webviewList[0].clearHistory();
                            // CookieManager.getInstance().removeAllCookie();
                        } catch (Exception e) {
                            Logger.getInstance(AndroidOAuth2AuthorizationCodeUserAgentTest.class.getSimpleName()).error(e.toString());
                        }
                        webViewLatch.countDown();
                }
        });
        webViewLatch.await();
        OAuth2AuthorizationCodeUserAgent oAuth2AuthorizationCodeUserAgent = oAuth2AuthorizationCodeUserAgentFactory.getUserAgent(
                new MapBuilder<String, Object>().putIfNotNull(
                        OAuth2AuthorizationCodeUserAgent.OPTION_AUTHORIZATION_URL,
                        fullAuthorizationUriString
                ).putIfNotNull(
                        OAuth2AuthorizationCodeUserAgent.OBJECT_ANDROID_WEBVIEW_INSTANCE,
                        webviewList[0]
                ).toMap(),
                CancellationToken.NONE
        );
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgent);

        OAuth2AuthorizationCodeUserAgent.LaunchResult launchResult = oAuth2AuthorizationCodeUserAgent.launch();
        OAuth2AuthorizationCodeUserAgent.LaunchStatus launchStatus = launchResult.getStatus();
        Assert.assertEquals(OAuth2AuthorizationCodeUserAgent.LaunchStatus.Ok, launchStatus);
    }

    @Test
    public void oAuth2AuthorizationCodeUserAgent_1_close() throws IOException {
        OAuth2AuthorizationCodeUserAgentFactory.register(AndroidOAuth2AuthorizationCodeUserAgentFactory.class);
        OAuth2AuthorizationCodeUserAgentFactory oAuth2AuthorizationCodeUserAgentFactory = OAuth2AuthorizationCodeUserAgentFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgentFactory);
        OAuth2AuthorizationCodeUserAgent oAuth2AuthorizationCodeUserAgent = oAuth2AuthorizationCodeUserAgentFactory.getUserAgent();
        Assert.assertNotNull(oAuth2AuthorizationCodeUserAgent);

        OAuth2AuthorizationCodeUserAgent.LaunchResult launchResult = oAuth2AuthorizationCodeUserAgent.launch();
        OAuth2AuthorizationCodeUserAgent.LaunchStatus launchStatus = launchResult.getStatus();
        Assert.assertEquals(OAuth2AuthorizationCodeUserAgent.LaunchStatus.InvalidAuthorizationUri, launchStatus);
        oAuth2AuthorizationCodeUserAgent.close();
        Exception exception = null;
        try {
            oAuth2AuthorizationCodeUserAgent.launch();
        } catch (Exception e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    }
}
