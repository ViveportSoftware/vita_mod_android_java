package com.htc.vita.mod.android.json;

import android.support.test.runner.AndroidJUnit4;

import com.htc.vita.core.json.JsonArray;
import com.htc.vita.core.json.JsonFactory;
import com.htc.vita.core.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AndroidJsonFactoryTest  {
    @Test
    public void android_0_getInstance() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        Assert.assertTrue(jsonFactory instanceof AndroidJsonFactory);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        Assert.assertTrue(jsonFactory instanceof AndroidJsonFactory);
    }

    @Test
    public void android_1_createJsonArray() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals("[]", jsonArray.toString());

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals("[]", jsonArray.toString());
    }

    @Test
    public void android_2_createJsonObject() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals("{}", jsonObject.toString());

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals("{}", jsonObject.toString());
    }

    @Test
    public void android_3_getJsonArray() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.getJsonArray("[]");
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals("[]", jsonArray.toString());

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.getJsonArray("[]");
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals("[]", jsonArray.toString());
    }

    @Test
    public void android_4_getJsonObject() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.getJsonObject("{}");
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals("{}", jsonObject.toString());

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.getJsonObject("{}");
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals("{}", jsonObject.toString());
    }

    @Test
    public void jsonArray_00_size() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0, jsonArray.size());

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0, jsonArray.size());
    }

    @Test
    public void jsonArray_01_parseBoolean() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(false, jsonArray.parseBoolean(0));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(false, jsonArray.parseBoolean(0));
    }

    @Test
    public void jsonArray_01_parseBoolean_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(true, jsonArray.parseBoolean(0, true));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(true, jsonArray.parseBoolean(0, true));
    }

    @Test
    public void jsonArray_02_parseDouble() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0.0D, jsonArray.parseDouble(0), 0.00001D);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0.0D, jsonArray.parseDouble(0), 0.00001D);
    }

    @Test
    public void jsonArray_02_parseDouble_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1.0D, jsonArray.parseDouble(0, 1.0D), 0.00001D);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1.0D, jsonArray.parseDouble(0, 1.0D), 0.00001D);
    }

    @Test
    public void jsonArray_03_parseFloat() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0.0f, jsonArray.parseFloat(0), 0.00001f);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0.0f, jsonArray.parseFloat(0), 0.00001f);
    }

    @Test
    public void jsonArray_03_parseFloat_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1.0f, jsonArray.parseFloat(0, 1.0f), 0.00001f);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1.0f, jsonArray.parseFloat(0, 1.0f), 0.00001f);
    }

    @Test
    public void jsonArray_04_parseInt() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0, jsonArray.parseInt(0));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0, jsonArray.parseInt(0));
    }

    @Test
    public void jsonArray_04_parseInt_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1, jsonArray.parseInt(0, 1));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1, jsonArray.parseInt(0, 1));
    }

    @Test
    public void jsonArray_05_parseLong() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0L, jsonArray.parseLong(0));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(0L, jsonArray.parseLong(0));
    }

    @Test
    public void jsonArray_05_parseLong_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1L, jsonArray.parseLong(0, 1L));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(1L, jsonArray.parseLong(0, 1L));
    }

    @Test
    public void jsonArray_06_parseString() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(null, jsonArray.parseString(0));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(null, jsonArray.parseString(0));
    }

    @Test
    public void jsonArray_06_parseString_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals("test", jsonArray.parseString(0, "test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals("test", jsonArray.parseString(0, "test"));
    }

    @Test
    public void jsonArray_07_parseJsonArray() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(null, jsonArray.parseJsonArray(0));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(null, jsonArray.parseJsonArray(0));
    }

    @Test
    public void jsonArray_08_parseJsonObject() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(null, jsonArray.parseJsonObject(0));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertEquals(null, jsonArray.parseJsonObject(0));
    }

    @Test
    public void jsonArray_09_append() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertNotNull(jsonArray.append(true));
        Assert.assertNotNull(jsonArray.append(0.1D));
        Assert.assertNotNull(jsonArray.append(0.1f));
        Assert.assertNotNull(jsonArray.append(1));
        Assert.assertNotNull(jsonArray.append(2L));
        Assert.assertNotNull(jsonArray.append("test"));
        JsonArray jsonArray2 = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray.append(jsonArray2));
        JsonObject jsonObject2 = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonArray.append(jsonObject2));
        Assert.assertEquals(true, jsonArray.parseBoolean(0));
        Assert.assertEquals(0.1D, jsonArray.parseDouble(1), 0.00001D);
        Assert.assertEquals(0.1f, jsonArray.parseFloat(2), 0.00001f);
        Assert.assertEquals(1, jsonArray.parseInt(3));
        Assert.assertEquals(2L, jsonArray.parseLong(4));
        Assert.assertEquals("test", jsonArray.parseString(5));
        Assert.assertNotNull(jsonArray.parseJsonArray(6));
        Assert.assertNotNull(jsonArray.parseJsonObject(7));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertNotNull(jsonArray.append(true));
        Assert.assertNotNull(jsonArray.append(0.1D));
        Assert.assertNotNull(jsonArray.append(0.1f));
        Assert.assertNotNull(jsonArray.append(1));
        Assert.assertNotNull(jsonArray.append(2L));
        Assert.assertNotNull(jsonArray.append("test"));
        jsonArray2 = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray.append(jsonArray2));
        jsonObject2 = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonArray.append(jsonObject2));
        Assert.assertEquals(true, jsonArray.parseBoolean(0));
        Assert.assertEquals(0.1D, jsonArray.parseDouble(1), 0.00001D);
        Assert.assertEquals(0.1f, jsonArray.parseFloat(2), 0.00001f);
        Assert.assertEquals(1, jsonArray.parseInt(3));
        Assert.assertEquals(2L, jsonArray.parseLong(4));
        Assert.assertEquals("test", jsonArray.parseString(5));
        Assert.assertNotNull(jsonArray.parseJsonArray(6));
        Assert.assertNotNull(jsonArray.parseJsonObject(7));
    }

    @Test
    public void jsonArray_10_insert() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonArray jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertNotNull(jsonArray.insert(0,true));
        Assert.assertNotNull(jsonArray.insert(0,0.1D));
        Assert.assertNotNull(jsonArray.insert(0,0.1f));
        Assert.assertNotNull(jsonArray.insert(0,1));
        Assert.assertNotNull(jsonArray.insert(0,2L));
        Assert.assertNotNull(jsonArray.insert(0,"test"));
        JsonArray jsonArray2 = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray.insert(0, jsonArray2));
        JsonObject jsonObject2 = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonArray.insert(0, jsonObject2));
        Assert.assertEquals(true, jsonArray.parseBoolean(7));
        Assert.assertEquals(0.1D, jsonArray.parseDouble(6), 0.00001D);
        Assert.assertEquals(0.1f, jsonArray.parseFloat(5), 0.00001f);
        Assert.assertEquals(1, jsonArray.parseInt(4));
        Assert.assertEquals(2L, jsonArray.parseLong(3));
        Assert.assertEquals("test", jsonArray.parseString(2));
        Assert.assertNotNull(jsonArray.parseJsonArray(1));
        Assert.assertNotNull(jsonArray.parseJsonObject(0));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonArray = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray);
        Assert.assertNotNull(jsonArray.insert(0,true));
        Assert.assertNotNull(jsonArray.insert(0,0.1D));
        Assert.assertNotNull(jsonArray.insert(0,0.1f));
        Assert.assertNotNull(jsonArray.insert(0,1));
        Assert.assertNotNull(jsonArray.insert(0,2L));
        Assert.assertNotNull(jsonArray.insert(0,"test"));
        jsonArray2 = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonArray.insert(0, jsonArray2));
        jsonObject2 = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonArray.insert(0, jsonObject2));
        Assert.assertEquals(true, jsonArray.parseBoolean(7));
        Assert.assertEquals(0.1D, jsonArray.parseDouble(6), 0.00001D);
        Assert.assertEquals(0.1f, jsonArray.parseFloat(5), 0.00001f);
        Assert.assertEquals(1, jsonArray.parseInt(4));
        Assert.assertEquals(2L, jsonArray.parseLong(3));
        Assert.assertEquals("test", jsonArray.parseString(2));
        Assert.assertNotNull(jsonArray.parseJsonArray(1));
        Assert.assertNotNull(jsonArray.parseJsonObject(0));
    }

    @Test
    public void jsonObject_00_hasKey() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertFalse(jsonObject.hasKey("test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertFalse(jsonObject.hasKey("test"));
    }

    @Test
    public void jsonObject_01_parseBoolean() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(false, jsonObject.parseBoolean("test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(false, jsonObject.parseBoolean("test"));
    }

    @Test
    public void jsonObject_01_parseBoolean_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(true, jsonObject.parseBoolean("test", true));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(true, jsonObject.parseBoolean("test", true));
    }

    @Test
    public void jsonObject_02_parseDouble() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0.0D, jsonObject.parseDouble("test"), 0.00001D);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0.0D, jsonObject.parseDouble("test"), 0.00001D);
    }

    @Test
    public void jsonObject_02_parseDouble_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1.0D, jsonObject.parseDouble("test", 1.0D), 0.00001D);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1.0D, jsonObject.parseDouble("test", 1.0D), 0.00001D);
    }

    @Test
    public void jsonObject_03_parseFloat() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0.0f, jsonObject.parseFloat("test"), 0.00001f);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0.0f, jsonObject.parseFloat("test"), 0.00001f);
    }

    @Test
    public void jsonObject_03_parseFloat_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1.0f, jsonObject.parseFloat("test", 1.0f), 0.00001f);

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1.0f, jsonObject.parseFloat("test", 1.0f), 0.00001f);
    }

    @Test
    public void jsonObject_04_parseInt() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0, jsonObject.parseInt("test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0, jsonObject.parseInt("test"));
    }

    @Test
    public void jsonObject_04_parseInt_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1, jsonObject.parseInt("test", 1));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1, jsonObject.parseInt("test", 1));
    }

    @Test
    public void jsonObject_05_parseLong() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0L, jsonObject.parseLong("test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0L, jsonObject.parseLong("test"));
    }

    @Test
    public void jsonObject_05_parseLong_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1L, jsonObject.parseLong("test", 1L));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1L, jsonObject.parseLong("test", 1L));
    }

    @Test
    public void jsonObject_06_parseString() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(null, jsonObject.parseString("test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(null, jsonObject.parseString("test"));
    }

    @Test
    public void jsonObject_06_parseString_withDefault() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals("test", jsonObject.parseString("test", "test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals("test", jsonObject.parseString("test", "test"));
    }

    @Test
    public void jsonObject_07_parseJsonArray() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(null, jsonObject.parseJsonArray("test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(null, jsonObject.parseJsonArray("test"));
    }

    @Test
    public void jsonObject_08_parseJsonObject() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(null, jsonObject.parseJsonObject("test"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(null, jsonObject.parseJsonObject("test"));
    }

    @Test
    public void jsonObject_09_put() {
        JsonFactory.register(AndroidJsonFactory.class);
        JsonFactory jsonFactory = JsonFactory.getInstance();
        Assert.assertNotNull(jsonFactory);
        JsonObject jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertNotNull(jsonObject.put("test0", true));
        Assert.assertNotNull(jsonObject.put("test1", 0.1D));
        Assert.assertNotNull(jsonObject.put("test2", 0.1f));
        Assert.assertNotNull(jsonObject.put("test3", 1));
        Assert.assertNotNull(jsonObject.put("test4", 2L));
        Assert.assertNotNull(jsonObject.put("test5", "test"));
        JsonArray jsonArray2 = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonObject.put("test6", jsonArray2));
        JsonObject jsonObject2 = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject.put("test7", jsonObject2));
        Assert.assertEquals(true, jsonObject.parseBoolean("test0"));
        Assert.assertEquals(0.1D, jsonObject.parseDouble("test1"), 0.00001D);
        Assert.assertEquals(0.1f, jsonObject.parseFloat("test2"), 0.00001f);
        Assert.assertEquals(1, jsonObject.parseInt("test3"));
        Assert.assertEquals(2L, jsonObject.parseLong("test4"));
        Assert.assertEquals("test", jsonObject.parseString("test5"));
        Assert.assertNotNull(jsonObject.parseJsonArray("test6"));
        Assert.assertNotNull(jsonObject.parseJsonObject("test7"));

        jsonFactory = JsonFactory.getInstance(AndroidJsonFactory.class);
        Assert.assertNotNull(jsonFactory);
        jsonObject = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject);
        Assert.assertNotNull(jsonObject.put("test0", true));
        Assert.assertNotNull(jsonObject.put("test1", 0.1D));
        Assert.assertNotNull(jsonObject.put("test2", 0.1f));
        Assert.assertNotNull(jsonObject.put("test3", 1));
        Assert.assertNotNull(jsonObject.put("test4", 2L));
        Assert.assertNotNull(jsonObject.put("test5", "test"));
        jsonArray2 = jsonFactory.createJsonArray();
        Assert.assertNotNull(jsonObject.put("test6", jsonArray2));
        jsonObject2 = jsonFactory.createJsonObject();
        Assert.assertNotNull(jsonObject.put("test7", jsonObject2));
        Assert.assertEquals(true, jsonObject.parseBoolean("test0"));
        Assert.assertEquals(0.1D, jsonObject.parseDouble("test1"), 0.00001D);
        Assert.assertEquals(0.1f, jsonObject.parseFloat("test2"), 0.00001f);
        Assert.assertEquals(1, jsonObject.parseInt("test3"));
        Assert.assertEquals(2L, jsonObject.parseLong("test4"));
        Assert.assertEquals("test", jsonObject.parseString("test5"));
        Assert.assertNotNull(jsonObject.parseJsonArray("test6"));
        Assert.assertNotNull(jsonObject.parseJsonObject("test7"));
    }
}
