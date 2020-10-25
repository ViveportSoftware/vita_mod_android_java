package com.htc.vita.mod.android.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.htc.vita.core.config.Config;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.util.StringUtils;
import com.htc.vita.mod.android.app.ApplicationContextProxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AndroidConfig extends Config {
    private final Map<String, String> mConfigMap;

    public AndroidConfig() {
        mConfigMap = createMapFromPackage(
                ApplicationContextProxy.getInstance().getApplicationContext()
        );
    }

    @Override
    protected Set<String> onAllKeys() {
        if (mConfigMap == null) {
            return new HashSet<>();
        }
        return mConfigMap.keySet();
    }

    private static Map<String, String> createMapFromPackage(
            Context context) {
        Map<String, String> result = new HashMap<>();
        if (context == null) {
            return result;
        }

        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return result;
        }

        String currentPackageName = context.getPackageName();
        if (StringUtils.isNullOrWhiteSpace(currentPackageName)) {
            return result;
        }

        String configPackageName = currentPackageName + ".config";

        Resources configResources = null;
        try {
            ApplicationInfo configApplicationInfo = packageManager.getApplicationInfo(
                    configPackageName,
                    0
            );
            if (configApplicationInfo != null
                    && configApplicationInfo.enabled) {
                configResources = packageManager.getResourcesForApplication(configPackageName);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.getInstance(AndroidConfig.class.getSimpleName()).error("Can not find config package");
        }
        if (configResources == null) {
            return result;
        }

        int configKeyArrayId = configResources.getIdentifier(
                "htc_vita_config_keys",
                "array",
                configPackageName
        );
        String[] configKeyArray = null;
        try {
            configKeyArray = configResources.getStringArray(configKeyArrayId);
        } catch (Exception e) {
            Logger.getInstance(AndroidConfig.class.getSimpleName()).error("Can not find config key array");
        }
        if (configKeyArray == null || configKeyArray.length <= 0) {
            return result;
        }

        for (String configKey : configKeyArray) {
            int configKeyId = configResources.getIdentifier(
                    configKey,
                    "string",
                    configPackageName
            );
            String configValue = null;
            try {
                configValue = configResources.getString(configKeyId);
            } catch (Exception e) {
                Logger.getInstance(AndroidConfig.class.getSimpleName()).error(StringUtils.rootLocaleFormat(
                        "Can not find config value for key: %s",
                        configKey
                ));
            }
            if (configValue == null) {
                continue;
            }
            result.put(
                    configKey,
                    configValue
            );
        }
        return result;
    }

    @Override
    protected String onGet(String key) {
        String result = null;
        if (mConfigMap != null && mConfigMap.containsKey(key)) {
            result = mConfigMap.get(key);
        }
        return result;
    }

    @Override
    protected boolean onHasKey(String key) {
        return mConfigMap != null && mConfigMap.containsKey(key);
    }
}
