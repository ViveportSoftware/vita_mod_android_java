package com.htc.vita.mod.android.log;

import android.util.Log;
import com.htc.vita.core.log.Logger;

public class AndroidLogger extends Logger {
    protected AndroidLogger(String name) {
        super(name);
    }

    @Override
    protected void onDebug(String tag, String message) {
        Log.d(tag, message);
    }

    @Override
    protected void onDebug(String tag, String message, Exception exception) {
        if (exception == null) {
            Log.d(tag, message);
        } else {
            Log.d(tag, message, exception);
        }
    }

    @Override
    protected void onError(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    protected void onError(String tag, String message, Exception exception) {
        if (exception == null) {
            Log.e(tag, message);
        } else {
            Log.e(tag, message, exception);
        }
    }

    @Override
    protected void onFatal(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    protected void onFatal(String tag, String message, Exception exception) {
        if (exception == null) {
            Log.wtf(tag, message);
        } else {
            Log.wtf(tag, message, exception);
        }
    }

    @Override
    protected void onInfo(String tag, String message) {
        Log.i(tag, message);
    }

    @Override
    protected void onInfo(String tag, String message, Exception exception) {
        if (exception == null) {
            Log.i(tag, message);
        } else {
            Log.i(tag, message, exception);
        }
    }

    @Override
    protected void onShutdown() {
        System.err.println("Shutdown the logger ...");
    }

    @Override
    protected void onTrace(String tag, String message) {
        Log.v(tag, message);
    }

    @Override
    protected void onTrace(String tag, String message, Exception exception) {
        if (exception == null) {
            Log.v(tag, message);
        } else {
            Log.v(tag, message, exception);
        }
    }

    @Override
    protected void onWarn(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    protected void onWarn(String tag, String message, Exception exception) {
        if (exception == null) {
            Log.w(tag, message);
        } else {
            Log.w(tag, message, exception);
        }
    }
}
