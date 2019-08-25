package com.htc.vita.mod.android.log;

import com.htc.vita.core.log.Logger;

public class AndroidLogger extends Logger {
    protected AndroidLogger(String name) {
        super(name);
    }

    @Override
    protected void onDebug(String tag, String message) {
        android.util.Log.d(tag, message);
    }

    @Override
    protected void onDebug(String tag, String message, Exception exception) {
        if (exception == null) {
            android.util.Log.d(tag, message);
        } else {
            android.util.Log.d(tag, message, exception);
        }
    }

    @Override
    protected void onError(String tag, String message) {
        android.util.Log.e(tag, message);
    }

    @Override
    protected void onError(String tag, String message, Exception exception) {
        if (exception == null) {
            android.util.Log.e(tag, message);
        } else {
            android.util.Log.e(tag, message, exception);
        }
    }

    @Override
    protected void onFatal(String tag, String message) {
        android.util.Log.e(tag, message);
    }

    @Override
    protected void onFatal(String tag, String message, Exception exception) {
        if (exception == null) {
            android.util.Log.wtf(tag, message);
        } else {
            android.util.Log.wtf(tag, message, exception);
        }
    }

    @Override
    protected void onInfo(String tag, String message) {
        android.util.Log.i(tag, message);
    }

    @Override
    protected void onInfo(String tag, String message, Exception exception) {
        if (exception == null) {
            android.util.Log.i(tag, message);
        } else {
            android.util.Log.i(tag, message, exception);
        }
    }

    @Override
    protected void onShutdown() {
        System.err.println("Shutdown the logger ...");
    }

    @Override
    protected void onTrace(String tag, String message) {
        android.util.Log.v(tag, message);
    }

    @Override
    protected void onTrace(String tag, String message, Exception exception) {
        if (exception == null) {
            android.util.Log.v(tag, message);
        } else {
            android.util.Log.v(tag, message, exception);
        }
    }

    @Override
    protected void onWarn(String tag, String message) {
        android.util.Log.w(tag, message);
    }

    @Override
    protected void onWarn(String tag, String message, Exception exception) {
        if (exception == null) {
            android.util.Log.w(tag, message);
        } else {
            android.util.Log.w(tag, message, exception);
        }
    }
}
