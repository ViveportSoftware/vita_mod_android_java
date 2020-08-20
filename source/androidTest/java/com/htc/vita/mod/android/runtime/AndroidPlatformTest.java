package com.htc.vita.mod.android.runtime;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import com.htc.vita.core.runtime.Platform;
import com.htc.vita.core.util.StringUtils;
import com.htc.vita.mod.android.app.ApplicationContextProxy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AndroidPlatformTest {

    static {
        ApplicationContextProxy.getInstance().apply(InstrumentationRegistry.getContext());
    }

    @Test
    public void default_0_getInstance() {
        Platform.register(AndroidPlatform.class);
        Platform platform = Platform.getInstance();
        Assert.assertNotNull(platform);
        Assert.assertTrue(platform instanceof AndroidPlatform);

        platform = Platform.getInstance(AndroidPlatform.class);
        Assert.assertNotNull(platform);
        Assert.assertTrue(platform instanceof AndroidPlatform);
    }

    @Test
    public void default_1_getInstance() {
        Platform.register(AndroidPlatform.class);
        Platform platform = Platform.getInstance();
        Assert.assertNotNull(platform);

        String machineId = platform.getMachineId();
        Assert.assertFalse(StringUtils.isNullOrWhiteSpace(machineId));
        Assert.assertFalse(AndroidPlatform.UNKNOWN_MACHINE_ID.equals(machineId));
    }
}
