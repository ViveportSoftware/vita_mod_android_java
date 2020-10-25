package com.htc.vita.mod.android.auth;

import android.support.test.runner.AndroidJUnit4;
import com.htc.vita.core.auth.OAuth2AuthorizationCodeReceiver;
import com.htc.vita.core.auth.OAuth2AuthorizationCodeReceiverFactory;
import com.htc.vita.core.concurrent.CancellationToken;
import com.htc.vita.core.util.MapBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class AndroidOAuth2AuthorizationCodeReceiverTest {
    @Test
    public void android_0_getInstance() {
        OAuth2AuthorizationCodeReceiverFactory.register(AndroidOAuth2AuthorizationCodeReceiverFactory.class);
        OAuth2AuthorizationCodeReceiverFactory oAuth2AuthorizationCodeReceiverFactory = OAuth2AuthorizationCodeReceiverFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiverFactory);
        Assert.assertTrue(oAuth2AuthorizationCodeReceiverFactory instanceof AndroidOAuth2AuthorizationCodeReceiverFactory);

        oAuth2AuthorizationCodeReceiverFactory = OAuth2AuthorizationCodeReceiverFactory.getInstance(AndroidOAuth2AuthorizationCodeReceiverFactory.class);
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiverFactory);
        Assert.assertTrue(oAuth2AuthorizationCodeReceiverFactory instanceof AndroidOAuth2AuthorizationCodeReceiverFactory);
    }

    @Test
    public void android_1_getReceiver() {
        OAuth2AuthorizationCodeReceiverFactory.register(AndroidOAuth2AuthorizationCodeReceiverFactory.class);
        OAuth2AuthorizationCodeReceiverFactory oAuth2AuthorizationCodeReceiverFactory = OAuth2AuthorizationCodeReceiverFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiverFactory);
        OAuth2AuthorizationCodeReceiver oAuth2AuthorizationCodeReceiver = oAuth2AuthorizationCodeReceiverFactory.getReceiver();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiver);
    }

    @Test
    public void oAuth2AuthorizationCodeReceiver_0_receive() {
        OAuth2AuthorizationCodeReceiverFactory.register(AndroidOAuth2AuthorizationCodeReceiverFactory.class);
        OAuth2AuthorizationCodeReceiverFactory oAuth2AuthorizationCodeReceiverFactory = OAuth2AuthorizationCodeReceiverFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiverFactory);
        OAuth2AuthorizationCodeReceiver oAuth2AuthorizationCodeReceiver = oAuth2AuthorizationCodeReceiverFactory.getReceiver();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiver);

        OAuth2AuthorizationCodeReceiver.ReceiveResult receiveResult = oAuth2AuthorizationCodeReceiver.receive();
        OAuth2AuthorizationCodeReceiver.ReceiveStatus receiveStatus = receiveResult.getStatus();
        Assert.assertEquals(OAuth2AuthorizationCodeReceiver.ReceiveStatus.UnsupportedReceiver, receiveStatus);
    }

    @Test
    public void oAuth2AuthorizationCodeReceiver_0_receive_withRedirectUriAndCode() {
        OAuth2AuthorizationCodeReceiverFactory.register(AndroidOAuth2AuthorizationCodeReceiverFactory.class);
        OAuth2AuthorizationCodeReceiverFactory oAuth2AuthorizationCodeReceiverFactory = OAuth2AuthorizationCodeReceiverFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiverFactory);

        String redirectUriString = "http://localhost:12345/";
        String code = "testCode";
        AndroidOAuth2AuthorizationCodeWebViewClient.AUTHORIZATION_CODE_MAP.put(redirectUriString, code);
        OAuth2AuthorizationCodeReceiver oAuth2AuthorizationCodeReceiver = oAuth2AuthorizationCodeReceiverFactory.getReceiver(
                new MapBuilder<String, String>().put(
                        OAuth2AuthorizationCodeReceiver.OPTION_REDIRECT_URI,
                        redirectUriString
                ).toMap(),
                CancellationToken.NONE
        );
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiver);

        OAuth2AuthorizationCodeReceiver.ReceiveResult receiveResult = oAuth2AuthorizationCodeReceiver.receive();
        OAuth2AuthorizationCodeReceiver.ReceiveStatus receiveStatus = receiveResult.getStatus();
        Assert.assertEquals(OAuth2AuthorizationCodeReceiver.ReceiveStatus.Ok, receiveStatus);
    }

    @Test
    public void oAuth2AuthorizationCodeReceiver_1_close() throws IOException {
        OAuth2AuthorizationCodeReceiverFactory.register(AndroidOAuth2AuthorizationCodeReceiverFactory.class);
        OAuth2AuthorizationCodeReceiverFactory oAuth2AuthorizationCodeReceiverFactory = OAuth2AuthorizationCodeReceiverFactory.getInstance();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiverFactory);
        OAuth2AuthorizationCodeReceiver oAuth2AuthorizationCodeReceiver = oAuth2AuthorizationCodeReceiverFactory.getReceiver();
        Assert.assertNotNull(oAuth2AuthorizationCodeReceiver);

        OAuth2AuthorizationCodeReceiver.ReceiveResult receiveResult = oAuth2AuthorizationCodeReceiver.receive();
        OAuth2AuthorizationCodeReceiver.ReceiveStatus receiveStatus = receiveResult.getStatus();
        Assert.assertEquals(OAuth2AuthorizationCodeReceiver.ReceiveStatus.UnsupportedReceiver, receiveStatus);
        oAuth2AuthorizationCodeReceiver.close();
        Exception exception = null;
        try {
            oAuth2AuthorizationCodeReceiver.receive();
        } catch (Exception e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    }
}
