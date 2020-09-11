package com.htc.vita.mod.android.io;

import android.content.Context;
import com.htc.vita.core.log.Logger;
import com.htc.vita.mod.android.app.ApplicationContextProxy;

import java.io.File;

public class PathUtils {
    public static File getAppRootDir() {
        File appRoot = getAppRootDirViaDataDir();
        if (appRoot == null) {
            appRoot = getAppRootDirViaFilesDir();
        }
        if (appRoot == null) {
            appRoot = getAppRootDirViaCacheDir();
        }
        if (appRoot == null) {
            Logger.getInstance(PathUtils.class.getSimpleName()).error("Can not find app root dir");
        }
        return appRoot;
    }

    private static File getAppRootDirViaCacheDir() {
        Context context = ApplicationContextProxy.getInstance().getApplicationContext();
        if (context == null) {
            return null;
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        File result = cacheDir.getParentFile();
        if (result == null || !result.isDirectory()) {
            return null;
        }
        return result;
    }

    private static File getAppRootDirViaDataDir() {
        Context context = ApplicationContextProxy.getInstance().getApplicationContext();
        if (context == null) {
            return null;
        }
        File dataDir = null;
        try {
            dataDir = context.getDataDir();
        } catch (Exception e) {
            // Skip
        }
        return dataDir;
    }

    private static File getAppRootDirViaFilesDir() {
        Context context = ApplicationContextProxy.getInstance().getApplicationContext();
        if (context == null) {
            return null;
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return null;
        }
        File result = filesDir.getParentFile();
        if (result == null || !result.isDirectory()) {
            return null;
        }
        return result;
    }

    public static File getSharedPreferencesDir() {
        File appRootDir = getAppRootDir();
        if (appRootDir == null) {
            return null;
        }

        return new File(appRootDir, "shared_prefs");
    }
}
