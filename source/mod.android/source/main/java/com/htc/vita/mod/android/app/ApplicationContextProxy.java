package com.htc.vita.mod.android.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.util.StringUtils;

import java.lang.reflect.Method;

public class ApplicationContextProxy {
    private static ApplicationContextProxy sInstance = null;

    private Context mApplicationContext = null;

    public void apply(Context context) {
        if (mApplicationContext != null) {
            return;
        }
        if (context == null) {
            return;
        }
        mApplicationContext = context.getApplicationContext();
    }

    public Context getApplicationContext() {
        if (mApplicationContext != null) {
            return mApplicationContext;
        }
        Application application = getApplicationFromActivityThread();
        if (application != null) {
            mApplicationContext = application.getApplicationContext();
        }
        if (mApplicationContext == null) {
            Logger.getInstance(ApplicationContextProxy.class.getSimpleName()).error(StringUtils.join(
                    " ",
                    "Can not find available application context.",
                    "Please apply context via \"ApplicationContextProxy.getInstance().apply(Context context)\" when your application start.",
                    "Application instance is a good place to apply context."
            ));
        }
        return mApplicationContext;
    }

    @SuppressLint("PrivateApi")
    private Application getApplicationFromActivityThread() {
        try {
            Class<?> clazz = Class.forName("android.app.ActivityThread");
            if (clazz == null) {
                return null;
            }
            Method method = clazz.getMethod("currentApplication");
            if (method == null) {
                return null;
            }
            return (Application) method.invoke(
                    null,
                    (Object[]) null
            );
        } catch (Exception e) {
            Logger.getInstance(ApplicationContextProxy.class.getSimpleName()).error(StringUtils.rootLocaleFormat(
                    "Can not get application from ActivityThread: %s",
                    e
            ));
        }
        return null;
    }

    public static ApplicationContextProxy getInstance() {
        if (sInstance == null) {
            synchronized (ApplicationContextProxy.class) {
                if (sInstance == null) {
                    sInstance = new ApplicationContextProxy();
                }
            }
        }
        return sInstance;
    }
}
