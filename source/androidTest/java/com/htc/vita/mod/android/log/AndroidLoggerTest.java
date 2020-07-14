package com.htc.vita.mod.android.log;

import android.support.test.runner.AndroidJUnit4;
import com.htc.vita.core.log.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AndroidLoggerTest {
    @Test
    public void default_0_debug() {
        Logger.register(AndroidLogger.class);
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).debug("log message from debug");
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).debug("log message from debug", new Exception("log exception from debug"));
    }

    @Test
    public void default_1_error() {
        Logger.register(AndroidLogger.class);
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).error("log message from error");
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).error("log message from error", new Exception("log exception from error"));
    }

    @Test
    public void default_2_fatal() {
        Logger.register(AndroidLogger.class);
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).fatal("log message from fatal");
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).fatal("log message from fatal", new Exception("log exception from fatal"));
    }

    @Test
    public void default_3_info() {
        Logger.register(AndroidLogger.class);
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).info("log message from info");
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).info("log message from info", new Exception("log exception from info"));
    }

    @Test
    public void default_4_trace() {
        Logger.register(AndroidLogger.class);
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).trace("log message from trace");
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).trace("log message from trace", new Exception("log exception from trace"));
    }

    @Test
    public void default_5_warn() {
        Logger.register(AndroidLogger.class);
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).trace("log message from warn");
        Logger.getInstance(AndroidLoggerTest.class.getSimpleName()).trace("log message from warn", new Exception("log exception from warn"));
    }
}
