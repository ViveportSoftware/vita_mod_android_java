package com.htc.vita.mod.android.auth;

import android.annotation.SuppressLint;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.net.HttpUtils;
import com.htc.vita.core.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* package */ class AndroidOAuth2AuthorizationCodeWebViewClient extends WebViewClient {
    /* package */ static final Map<String, String> AUTHORIZATION_CODE_MAP = new HashMap<>();

    private static final String REQUEST_QUERY_PARAM_CODE = "code";

    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private final Map<String, String> mJavaScriptActionMap = new HashMap<>();

    private boolean doShouldOverrideUrlLoading(String url) {
        Logger.getInstance(AndroidOAuth2AuthorizationCodeWebViewClient.class.getSimpleName()).debug(StringUtils.rootLocaleFormat(
                "load \"%s\"",
                url
        ));
        try {
            String queryString = new URL(url).getQuery();
            if (!StringUtils.isNullOrWhiteSpace(queryString)) {
                Map<String, String> queryParams = HttpUtils.toQueryParams(queryString);
                if (queryParams.containsKey(REQUEST_QUERY_PARAM_CODE)) {
                    AUTHORIZATION_CODE_MAP.put(
                            url.substring(0, url.indexOf(queryString) - 1),
                            queryParams.get(REQUEST_QUERY_PARAM_CODE)
                    );
                    mCountDownLatch.countDown();
                }
            }
        } catch (MalformedURLException e) {
            Logger.getInstance(AndroidOAuth2AuthorizationCodeWebViewClient.class.getSimpleName()).error(e.toString());
        }
        return false;
    }

    @Override
    public void onPageFinished(
            WebView webView,
            String url) {
        super.onPageFinished(
                webView,
                url
        );
        String javaScriptAction = null;
        for (String urlPrefix : mJavaScriptActionMap.keySet()) {
            if (StringUtils.isNullOrWhiteSpace(urlPrefix)) {
                continue;
            }
            if (url.startsWith(urlPrefix)) {
                javaScriptAction = mJavaScriptActionMap.get(urlPrefix);
                break;
            }
        }
        if (!StringUtils.isNullOrWhiteSpace(javaScriptAction)) {
            Logger.getInstance(AndroidOAuth2AuthorizationCodeWebViewClient.class.getSimpleName()).info(StringUtils.rootLocaleFormat(
                    "load javascript action on page \"%s\" finished",
                    url
            ));
            webView.loadUrl(javaScriptAction);
        }
    }

    public AndroidOAuth2AuthorizationCodeWebViewClient setJavaScriptActionOnPageFinished(
            String urlPrefix,
            String javaScriptAction) {
        if (StringUtils.isNullOrWhiteSpace(urlPrefix) || StringUtils.isNullOrWhiteSpace(javaScriptAction)) {
            return this;
        }
        Logger.getInstance(AndroidOAuth2AuthorizationCodeWebViewClient.class.getSimpleName()).info("add javascript action");
        mJavaScriptActionMap.put(
                urlPrefix,
                javaScriptAction
        );
        return this;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(
            WebView webView,
            String url) {
        return doShouldOverrideUrlLoading(
                url
        );
    }

    @SuppressLint("NewApi")
    @Override
    public boolean shouldOverrideUrlLoading(
            WebView webView,
            WebResourceRequest request) {
        return doShouldOverrideUrlLoading(
                request.getUrl().toString()
        );
    }
}
