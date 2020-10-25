package com.htc.vita.mod.android.auth;

import com.htc.vita.core.auth.OAuth2AuthorizationCodeReceiver;
import com.htc.vita.core.auth.OAuth2AuthorizationCodeReceiverFactory;
import com.htc.vita.core.concurrent.CancellationToken;

import java.util.Map;

public class    AndroidOAuth2AuthorizationCodeReceiverFactory extends OAuth2AuthorizationCodeReceiverFactory {
    @Override
    protected OAuth2AuthorizationCodeReceiver onGetReceiver(
            Map<String, String> options,
            CancellationToken cancellationToken) {
        return new AndroidOAuth2AuthorizationCodeReceiver().initialize(
                options,
                cancellationToken
        );
    }
}
