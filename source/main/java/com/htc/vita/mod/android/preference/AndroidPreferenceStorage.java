package com.htc.vita.mod.android.preference;

import android.content.Context;
import android.content.SharedPreferences;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.preference.PreferenceStorage;
import com.htc.vita.core.util.StringUtils;
import com.htc.vita.mod.android.app.ApplicationContextProxy;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AndroidPreferenceStorage extends PreferenceStorage {
    private static SharedPreferences getSharedPreferences(
            String category,
            String label) {
        Context context = ApplicationContextProxy.getInstance().getApplicationContext();
        if (context == null) {
            return null;
        }

        String key = String.format(
                Locale.ROOT,
                "htc_%s_%s",
                category,
                label
        );
        return context.getSharedPreferences(
                key,
                Context.MODE_PRIVATE
        );
    }

    @Override
    protected Map<String, String> onLoad() {
        Map<String, String> result = new HashMap<String, String>();
        SharedPreferences sharedPreferences = getSharedPreferences(
                getCategory(),
                getLabel()
        );
        if (sharedPreferences == null) {
            Logger.getInstance(AndroidPreferenceStorage.class.getSimpleName()).error("Can not get shared preferences");
            return result;
        }

        Map<String, ?> itemMap = sharedPreferences.getAll();
        if (itemMap == null) {
            return result;
        }

        for (String key : itemMap.keySet()) {
            if (StringUtils.isNullOrWhiteSpace(key)) {
                continue;
            }
            Object value = itemMap.get(key);
            if (value == null) {
                result.put(
                        key,
                        null
                );
            } else {
                result.put(
                        key,
                        "" + value
                );
            }
        }
        return result;
    }

    @Override
    protected boolean onSave(Map<String, String> data) {
        if (data == null) {
            return false;
        }

        SharedPreferences sharedPreferences = getSharedPreferences(
                getCategory(),
                getLabel()
        );
        if (sharedPreferences == null) {
            Logger.getInstance(AndroidPreferenceStorage.class.getSimpleName()).error("Can not get shared preferences");
            return false;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (editor == null) {
            Logger.getInstance(AndroidPreferenceStorage.class.getSimpleName()).error("Can not get shared preferences editor");
            return false;
        }

        editor.clear();
        for (String key : data.keySet()) {
            if (StringUtils.isNullOrWhiteSpace(key)) {
                continue;
            }
            editor.putString(
                    key,
                    data.get(key)
            );
        }
        return editor.commit();
    }
}
