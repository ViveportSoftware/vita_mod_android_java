package com.htc.vita.mod.android.json;

import com.htc.vita.core.json.JsonArray;
import com.htc.vita.core.json.JsonObject;
import com.htc.vita.core.log.Logger;
import com.htc.vita.core.util.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AndroidJsonObject extends JsonObject {
    private final JSONObject mJSONObject;

    public AndroidJsonObject(JSONObject jsonObject) {
        mJSONObject = jsonObject;
    }

    public JSONObject getInnerInstance() {
        return mJSONObject;
    }

    @Override
    protected Set<String> onAllKeys() {
        if (mJSONObject == null) {
            return new HashSet<String>();
        }
        Set<String> result = new HashSet<String>();
        for (Iterator<String> it = mJSONObject.keys(); it.hasNext(); ) {
            String key = it.next();
            if (StringUtils.isNullOrWhiteSpace(key)) {
                continue;
            }
            result.add(key);
        }
        return result;
    }

    @Override
    protected boolean onHasKey(String key) {
        if (mJSONObject == null) {
            return false;
        }
        return mJSONObject.has(key);
    }

    @Override
    protected boolean onParseBoolean(String key, boolean defaultValue) {
        boolean result = defaultValue;
        if (mJSONObject == null) {
            return result;
        }
        try {
            result = mJSONObject.getBoolean(key);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse boolean value by key: " + key);
        }
        return result;
    }

    @Override
    protected double onParseDouble(String key, double defaultValue) {
        double result = defaultValue;
        if (mJSONObject == null) {
            return result;
        }
        try {
            result = mJSONObject.getDouble(key);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse double value by key: " + key);
        }
        return result;
    }

    @Override
    protected float onParseFloat(String key, float defaultValue) {
        float result = defaultValue;
        if (mJSONObject == null) {
            return result;
        }
        try {
            result = (float) mJSONObject.getDouble(key);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse float value by key: " + key);
        }
        return result;
    }

    @Override
    protected int onParseInt(String key, int defaultValue) {
        int result = defaultValue;
        if (mJSONObject == null) {
            return result;
        }
        try {
            result = mJSONObject.getInt(key);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse int value by key: " + key);
        }
        return result;
    }

    @Override
    protected long onParseLong(String key, long defaultValue) {
        long result = defaultValue;
        if (mJSONObject == null) {
            return result;
        }
        try {
            result = mJSONObject.getLong(key);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse long value by key: " + key);
        }
        return result;
    }

    @Override
    protected String onParseString(String key, String defaultValue) {
        String result = defaultValue;
        if (mJSONObject == null) {
            return result;
        }
        try {
            result = mJSONObject.getString(key);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse String value by key: " + key);
        }
        return result;
    }

    @Override
    protected JsonArray onParseJsonArray(String key) {
        if (mJSONObject == null) {
            return null;
        }
        try {
            JSONArray jsonArray = mJSONObject.getJSONArray(key);
            if (jsonArray != null) {
                return new AndroidJsonArray(jsonArray);
            }
        } catch (Exception e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse JsonArray value by key: " + key);
        }
        return null;
    }

    @Override
    protected JsonObject onParseJsonObject(String key) {
        if (mJSONObject == null) {
            return null;
        }
        try {
            JSONObject jsonObject = mJSONObject.getJSONObject(key);
            if (jsonObject != null) {
                return new AndroidJsonObject(jsonObject);
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error("Can not parse JsonObject value by key: " + key);
        }
        return null;
    }

    @Override
    protected JsonObject onPutBoolean(String key, boolean value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put boolean value %s into JsonObject value by key: %s",
                    value,
                    key
            ));
        }
        return this;
    }

    @Override
    protected JsonObject onPutDouble(String key, double value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put double value %s into JsonObject value by key: %s",
                    value,
                    key
            ));
        }
        return this;
    }

    @Override
    protected JsonObject onPutFloat(String key, float value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put float value %s into JsonObject value by key: %s",
                    value,
                    key
            ));
        }
        return this;
    }

    @Override
    protected JsonObject onPutInt(String key, int value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put int value %s into JsonObject value by key: %s",
                    value,
                    key
            ));
        }
        return this;
    }

    @Override
    protected JsonObject onPutLong(String key, long value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put long value %s into JsonObject value by key: %s",
                    value,
                    key
            ));
        }
        return this;
    }

    @Override
    protected JsonObject onPutString(String key, String value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put String value %s into JsonObject value by key: %s",
                    value,
                    key
            ));
        }
        return this;
    }

    @Override
    protected JsonObject onPutJsonArray(String key, JsonArray value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, ((AndroidJsonArray)value).getInnerInstance());
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put JsonArray value into JsonObject value by key: %s",
                    key
            ));
        }
        return this;
    }

    @Override
    protected JsonObject onPutJsonObject(String key, JsonObject value) {
        if (mJSONObject == null) {
            return this;
        }
        try {
            mJSONObject.put(key, ((AndroidJsonObject)value).getInnerInstance());
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonObject.class.getSimpleName()).error(String.format(
                    "Can not put JsonObject value into JsonObject value by key: %s",
                    key
            ));
        }
        return this;
    }

    @Override
    protected String onToPrettyString() {
        if (mJSONObject == null) {
            return "";
        }
        try {
            return mJSONObject.toString(2);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error("Can not output pretty string");
        }
        return "";
    }

    @Override
    public String toString() {
        if (mJSONObject == null) {
            return "";
        }
        return mJSONObject.toString();
    }
}
