package com.htc.vita.mod.android.auth;

import com.htc.vita.core.auth.OAuth2AuthorizationCodeUserAgent;
import com.htc.vita.core.auth.OAuth2AuthorizationCodeUserAgentFactory;
import com.htc.vita.core.concurrent.CancellationToken;

import java.util.Map;

public class AndroidOAuth2AuthorizationCodeUserAgentFactory extends OAuth2AuthorizationCodeUserAgentFactory {
    @Override
    protected OAuth2AuthorizationCodeUserAgent onGetUserAgent(
            Map<String, Object> options,
            CancellationToken cancellationToken) {
        return new AndroidOAuth2AuthorizationCodeUserAgent().initialize(
                options,
                cancellationToken
        );
    }
}
