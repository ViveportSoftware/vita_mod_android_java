package com.htc.vita.mod.android.config;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import com.htc.vita.core.config.Config;
import com.htc.vita.core.util.StringUtils;
import com.htc.vita.mod.android.app.ApplicationContextProxy;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

@RunWith(AndroidJUnit4.class)
public class AndroidConfigTest {
    static {
        ApplicationContextProxy.getInstance().apply(InstrumentationRegistry.getContext());
    }

    @Test
    public void default_0_getInstance() {
        Config.register(AndroidConfig.class);
        Config config = Config.getInstance();
        Assert.assertNotNull(config);
        Assert.assertTrue(config instanceof AndroidConfig);

        config = Config.getInstance(AndroidConfig.class);
        Assert.assertNotNull(config);
        Assert.assertTrue(config instanceof AndroidConfig);
    }

    @Ignore("PredefinedGlobalDataNeeded")
    @Test
    public void default_1_allKeys() {
        Config.register(AndroidConfig.class);
        Config config = Config.getInstance();
        Assert.assertNotNull(config);

        Set<String> allKeys = config.allKeys();
        Assert.assertNotNull(allKeys);
        Assert.assertTrue(allKeys.size() > 0);
        for (String key : allKeys) {
            Assert.assertFalse(StringUtils.isNullOrWhiteSpace(key));
            Assert.assertTrue(config.hasKey(key));
            Assert.assertFalse(StringUtils.isNullOrWhiteSpace(config.get(key)));
        }
    }
}
