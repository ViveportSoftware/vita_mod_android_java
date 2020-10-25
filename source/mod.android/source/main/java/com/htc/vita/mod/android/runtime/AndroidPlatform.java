package com.htc.vita.mod.android.runtime;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.runtime.Platform;
import com.htc.vita.core.util.StringUtils;
import com.htc.vita.mod.android.app.ApplicationContextProxy;

public class AndroidPlatform extends Platform {
    public static final String UNKNOWN_MACHINE_ID = "UNKNOWN-ANDROID-MACHINE-ID";

    @Override
    protected String onGetMachineId() {
        String machineId = onOverrideGetMachineId();
        if (!StringUtils.isNullOrWhiteSpace(machineId)) {
            return machineId;
        }
        Logger.getInstance(AndroidPlatform.class.getSimpleName()).error("Can not find valid machine id");
        return UNKNOWN_MACHINE_ID;
    }

    protected String onOverrideGetMachineId() {
        Context context = ApplicationContextProxy.getInstance().getApplicationContext();
        if (context == null) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        @SuppressLint("HardwareIds")
        String androidId = Settings.Secure.getString(
                contentResolver,
                Settings.Secure.ANDROID_ID
        );
        return androidId;
    }
}
