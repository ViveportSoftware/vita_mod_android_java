package com.htc.vita.mod.android.preference;

import android.content.Context;
import android.content.SharedPreferences;
import com.htc.vita.core.internal.TaskRunner;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.preference.PreferenceStorage;
import com.htc.vita.core.util.StringUtils;
import com.htc.vita.mod.android.app.ApplicationContextProxy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class AndroidPreferenceStorage extends PreferenceStorage {
    private Map<String, String> doLoad(
            String category,
            String label) {
        Map<String, String> result = new HashMap<>();
        SharedPreferences sharedPreferences = getSharedPreferences(
                category,
                label
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

    private boolean doSave(
            String category,
            String label,
            Map<String, String> data) {
        if (data == null) {
            return false;
        }

        SharedPreferences sharedPreferences = getSharedPreferences(
                category,
                label
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

    private static SharedPreferences getSharedPreferences(
            String category,
            String label) {
        Context context = ApplicationContextProxy.getInstance().getApplicationContext();
        if (context == null) {
            return null;
        }

        String key = StringUtils.rootLocaleFormat(
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
    protected Map<String, String> onLoad(
            String category,
            String label) {
        return doLoad(
                category,
                label
        );
    }

    @Override
    protected Future<Map<String, String>> onLoadAsync(
            final String category,
            final String label) {
        return TaskRunner.submit(new Callable<Map<String, String>>() {
                @Override
                public Map<String, String> call() {
                    return doLoad(
                            category,
                            label
                    );
                }
        });
    }

    @Override
    protected boolean onSave(
            String category,
            String label,
            Map<String, String> data) {
        return doSave(
                category,
                label,
                data
        );
    }

    @Override
    protected Future<Boolean> onSaveAsync(
            final String category,
            final String label,
            final Map<String, String> data) {
        return TaskRunner.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() {
                    return doSave(
                            category,
                            label,
                            Collections.unmodifiableMap(data)
                    );
                }
        });
    }
}
