package com.htc.vita.mod.android.log;

import android.util.Log;
import com.htc.vita.core.log.Logger;

public class AndroidLogger extends Logger {
    public AndroidLogger(String name) {
        super(name);
    }

    @Override
    protected void onDebug(
            String tag,
            String message) {
        onDebug(
                tag,
                message,
                null
        );
    }

    @Override
    protected void onDebug(
            String tag,
            String message,
            Exception exception) {
        if (exception == null) {
            Log.d(
                    getName(),
                    "[" + tag + "] " + message
            );
        } else {
            Log.d(
                    getName(),
                    "[" + tag + "] " + message,
                    exception
            );
        }
    }

    @Override
    protected void onError(
            String tag,
            String message) {
        onError(
                tag,
                message,
                null
        );
    }

    @Override
    protected void onError(
            String tag,
            String message,
            Exception exception) {
        if (exception == null) {
            Log.e(
                    getName(),
                    "[" + tag + "] " + message
            );
        } else {
            Log.e(
                    getName(),
                    "[" + tag + "] " + message,
                    exception
            );
        }
    }

    @Override
    protected void onFatal(
            String tag,
            String message) {
        onFatal(
                tag,
                message,
                null
        );
    }

    @Override
    protected void onFatal(
            String tag,
            String message,
            Exception exception) {
        if (exception == null) {
            Log.wtf(
                    getName(),
                    "[" + tag + "] " + message
            );
        } else {
            Log.wtf(
                    getName(),
                    "[" + tag + "] " + message,
                    exception
            );
        }
    }

    @Override
    protected void onInfo(
            String tag,
            String message) {
        onInfo(
                tag,
                message,
                null
        );
    }

    @Override
    protected void onInfo(
            String tag,
            String message,
            Exception exception) {
        if (exception == null) {
            Log.i(
                    getName(),
                    "[" + tag + "] " + message
            );
        } else {
            Log.i(
                    getName(),
                    "[" + tag + "] " + message,
                    exception
            );
        }
    }

    @Override
    protected void onShutdown() {
        System.err.println("Shutdown the logger ...");
    }

    @Override
    protected void onTrace(
            String tag,
            String message) {
        onTrace(
                tag,
                message,
                null
        );
    }

    @Override
    protected void onTrace(
            String tag,
            String message,
            Exception exception) {
        if (exception == null) {
            Log.v(
                    getName(),
                    "[" + tag + "] " + message
            );
        } else {
            Log.v(
                    getName(),
                    "[" + tag + "] " + message,
                    exception
            );
        }
    }

    @Override
    protected void onWarn(
            String tag,
            String message) {
        onWarn(
                tag,
                message,
                null
        );
    }

    @Override
    protected void onWarn(
            String tag,
            String message,
            Exception exception) {
        if (exception == null) {
            Log.w(
                    getName(),
                    "[" + tag + "] " + message
            );
        } else {
            Log.w(
                    getName(),
                    "[" + tag + "] " + message,
                    exception
            );
        }
    }
}
