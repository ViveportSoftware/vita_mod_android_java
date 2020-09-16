package com.htc.vita.mod.android.preference;

import com.htc.vita.core.json.JsonFactory;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.preference.PreferenceFactory;
import com.htc.vita.core.preference.PreferenceStorage;
import com.htc.vita.core.preference.Preferences;
import com.htc.vita.mod.android.io.FileUtils;
import com.htc.vita.mod.android.io.PathUtils;
import com.htc.vita.mod.android.json.AndroidJsonFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.Future;

public class AndroidPreferenceStorageTest {
    @Test
    public void android_0_getInstance() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
    }

    @Test
    public void android_1_loadPreferences() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences0 = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences0);
        Preferences preferences1 = preferenceFactory.loadPreferences("customLabel");
        Assert.assertNotNull(preferences1);
        Assert.assertNotEquals(preferences0, preferences1);
    }

    @Test
    public void android_1_loadPreferencesAsync() throws Exception {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Future<Preferences> preferencesFuture0 = preferenceFactory.loadPreferencesAsync();
        Assert.assertNotNull(preferencesFuture0);
        Future<Preferences> preferencesFuture1 = preferenceFactory.loadPreferencesAsync("customLabel");
        Assert.assertNotNull(preferencesFuture1);
        Assert.assertNotEquals(preferencesFuture0, preferencesFuture1);
        Assert.assertNotEquals(preferencesFuture0.get(), preferencesFuture1.get());
    }

    @Test
    public void preferences_00_put_withBoolean() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("booleanKey0", true));
    }

    @Test
    public void preferences_01_put_withDouble() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("doubleKey0", 1.1D));
    }

    @Test
    public void preferences_02_put_withFloat() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("floatKey0", 2.2F));
    }

    @Test
    public void preferences_03_put_withInt() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("intKey0", 3));
    }

    @Test
    public void preferences_04_put_withLong() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("longKey0", 100000000000L));
    }

    @Test
    public void preferences_05_put_withString() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("stringKey0", "test"));
    }

    @Test
    public void preferences_06_parseBoolean() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("booleanKey0", true));
        Assert.assertTrue(preferences.parseBoolean("booleanKey0"));
        Assert.assertNotNull(preferences.put("booleanKey1", "true"));
        Assert.assertTrue(preferences.parseBoolean("booleanKey1"));
    }

    @Test
    public void preferences_06_parseBoolean_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("booleanKey0", true));
        Assert.assertTrue(preferences.parseBoolean("booleanKey0"));
        Assert.assertFalse(preferences.parseBoolean("booleanKey1"));
        Assert.assertTrue(preferences.parseBoolean("booleanKey2", true));
    }

    @Test
    public void preferences_07_parseDouble() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("doubleKey0", 1.1D));
        Assert.assertEquals(1.1D, preferences.parseDouble("doubleKey0"), 0.000000001D);
        Assert.assertNotNull(preferences.put("doubleKey1", 2.2D));
        Assert.assertEquals(2.2D, preferences.parseDouble("doubleKey1"), 0.000000001D);
    }

    @Test
    public void preferences_07_parseDouble_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("doubleKey0", 1.1D));
        Assert.assertEquals(1.1D, preferences.parseDouble("doubleKey0"), 0.000000001D);
        Assert.assertEquals(0.0D, preferences.parseDouble("doubleKey1"), 0.000000001D);
        Assert.assertEquals(2.2D, preferences.parseDouble("doubleKey2", 2.2D), 0.000000001D);
    }

    @Test
    public void preferences_08_parseFloat() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("floatKey0", 1.1F));
        Assert.assertEquals(1.1F, preferences.parseFloat("floatKey0"), 0.000000001F);
        Assert.assertNotNull(preferences.put("floatKey1", 2.2F));
        Assert.assertEquals(2.2F, preferences.parseFloat("floatKey1"), 0.000000001F);
    }

    @Test
    public void preferences_08_parseFloat_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("floatKey0", 1.1F));
        Assert.assertEquals(1.1F, preferences.parseFloat("floatKey0"), 0.000000001F);
        Assert.assertEquals(0.0F, preferences.parseFloat("floatKey1"), 0.000000001F);
        Assert.assertEquals(2.2F, preferences.parseFloat("floatKey2", 2.2F), 0.000000001F);
    }

    @Test
    public void preferences_09_parseInt() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("intKey0", 1));
        Assert.assertEquals(1, preferences.parseInt("intKey0"));
        Assert.assertNotNull(preferences.put("intKey1", 2));
        Assert.assertEquals(2, preferences.parseInt("intKey1"));
    }

    @Test
    public void preferences_09_parseInt_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("intKey0", 1));
        Assert.assertEquals(1, preferences.parseInt("intKey0"));
        Assert.assertEquals(0, preferences.parseInt("intKey1"));
        Assert.assertEquals(2, preferences.parseInt("intKey2", 2));
    }

    @Test
    public void preferences_10_parseLong() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("longKey0", 100000000000L));
        Assert.assertEquals(100000000000L, preferences.parseLong("longKey0"));
        Assert.assertNotNull(preferences.put("longKey1", 200000000000L));
        Assert.assertEquals(200000000000L, preferences.parseLong("longKey1"));
    }

    @Test
    public void preferences_10_parseLong_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("longKey0", 100000000000L));
        Assert.assertEquals(100000000000L, preferences.parseLong("longKey0"));
        Assert.assertEquals(0, preferences.parseLong("longKey1"));
        Assert.assertEquals(200000000000L, preferences.parseLong("longKey2", 200000000000L));
    }

    @Test
    public void preferences_11_parseString() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("stringKey0", "stringValue0"));
        Assert.assertEquals("stringValue0", preferences.parseString("stringKey0"));
        Assert.assertNotNull(preferences.put("stringKey1", "stringValue1"));
        Assert.assertEquals("stringValue1", preferences.parseString("stringKey1"));
    }

    @Test
    public void preferences_11_parseString_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.put("stringKey0", "stringValue0"));
        Assert.assertEquals("stringValue0", preferences.parseString("stringKey0"));
        Assert.assertNull(preferences.parseString("stringKey1"));
        Assert.assertEquals("stringValue2", preferences.parseString("stringKey2", "stringValue2"));
    }

    @Test
    public void preferences_12_commit() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences0 = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences0);
        Assert.assertNotNull(preferences0.put("customKey0", "stringValue0"));
        Assert.assertNotNull(preferences0.put("customKey1", 1));
        Assert.assertNotNull(preferences0.put("customKey2", 2.2D));
        Assert.assertNotNull(preferences0.put("customKey3", true));
        Assert.assertTrue(preferences0.commit());

        Preferences preferences1 = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences1);
        Assert.assertEquals("stringValue0", preferences1.parseString("customKey0"));
        Assert.assertEquals(1, preferences1.parseInt("customKey1"));
        Assert.assertEquals(2.2D, preferences1.parseDouble("customKey2"), 0.000000001D);
        Assert.assertTrue(preferences1.parseBoolean("customKey3"));
    }

    @Test
    public void preferences_12_commit_withFileCheck() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences0 = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences0);
        Assert.assertNotNull(preferences0.put("customKey0", "stringValue0"));
        Assert.assertNotNull(preferences0.put("customKey1", 1));
        Assert.assertNotNull(preferences0.put("customKey2", 2.2D));
        Assert.assertNotNull(preferences0.put("customKey3", true));
        Assert.assertTrue(preferences0.commit());

        File sharedPreferencesDir = PathUtils.getSharedPreferencesDir();
        Assert.assertNotNull(sharedPreferencesDir);
        Logger.getInstance(AndroidPreferenceStorage.class.getSimpleName()).info("sharedPreferencesDir: " + sharedPreferencesDir.getAbsolutePath());
        Assert.assertTrue(sharedPreferencesDir.exists());
        Assert.assertTrue(sharedPreferencesDir.isDirectory());

        File[] sharedPreferencesFiles = sharedPreferencesDir.listFiles();
        int index = 0;
        for (File sharedPreferencesFile : sharedPreferencesFiles) {
            Logger.getInstance(AndroidPreferenceStorage.class.getSimpleName()).info("sharedPreferencesFile[" + index + "].getAbsolutePath() " + sharedPreferencesFile.getAbsolutePath());
            if (!sharedPreferencesFile.getName().contains("htc_")) {
                continue;
            }
            String allText = FileUtils.readAllText(sharedPreferencesFile);
            Logger.getInstance(AndroidPreferenceStorage.class.getSimpleName()).info("sharedPreferencesFile[" + index + "].allText: " + allText);
        }
    }

    @Test
    public void preferences_12_commit_withUnicode() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences0 = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences0);
        Assert.assertNotNull(preferences0.put("customKey0", "\u6E2C\u8A66")); // \u6E2C\u8A66 is Unicode escaped string for "測試"
        Assert.assertTrue(preferences0.commit());
    }

    @Test
    public void preferences_13_clear() {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Preferences preferences0 = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences0);
        Assert.assertNotNull(preferences0.put("customKey0", "stringValue0"));
        Assert.assertNotNull(preferences0.put("customKey1", 1));
        Assert.assertNotNull(preferences0.put("customKey2", 2.2D));
        Assert.assertNotNull(preferences0.put("customKey3", true));
        Assert.assertNotNull(preferences0.clear());
        Assert.assertTrue(preferences0.commit());

        Preferences preferences1 = preferenceFactory.loadPreferences();
        Assert.assertNotNull(preferences1);
        Assert.assertNull(preferences1.parseString("customKey0"));
        Assert.assertEquals(0, preferences1.parseInt("customKey1"));
        Assert.assertEquals(0.0D, preferences1.parseDouble("customKey2"), 0.000000001D);
        Assert.assertFalse(preferences1.parseBoolean("customKey3"));
    }

    @Test
    public void preferences_14_commitAsync() throws Exception {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Future<Preferences> preferencesFuture = preferenceFactory.loadPreferencesAsync();
        Assert.assertNotNull(preferencesFuture);
        Preferences preferences = preferencesFuture.get();
        Assert.assertNotNull(preferences);
        Assert.assertTrue(preferences.commitAsync().get());
    }

    @Test
    public void preferences_15_initializeAsync() throws Exception {
        JsonFactory.register(AndroidJsonFactory.class);
        PreferenceStorage.register(AndroidPreferenceStorage.class);
        PreferenceFactory preferenceFactory = PreferenceFactory.getInstance();
        Assert.assertNotNull(preferenceFactory);
        Future<Preferences> preferencesFuture = preferenceFactory.loadPreferencesAsync();
        Assert.assertNotNull(preferencesFuture);
        Preferences preferences = preferencesFuture.get();
        Assert.assertNotNull(preferences);
        Assert.assertNotNull(preferences.initializeAsync().get());
    }
}
