package com.htc.vita.mod.android.json;

import com.htc.vita.core.json.JsonArray;
import com.htc.vita.core.json.JsonFactory;
import com.htc.vita.core.json.JsonObject;
import com.htc.vita.core.log.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class AndroidJsonFactory extends JsonFactory {
    @Override
    protected JsonArray onCreateJsonArray() {
        return new AndroidJsonArray(new JSONArray());
    }

    @Override
    protected JsonObject onCreateJsonObject() {
        return new AndroidJsonObject(new JSONObject());
    }

    @Override
    protected <T> T onDeserializeObject(
            String content,
            Class<T> aClass) {
        Logger.getInstance(AndroidJsonFactory.class.getSimpleName()).error(
                "This implementation of JsonFactory does not support object deserialization!!"
        );
        return null;
    }

    @Override
    protected JsonArray onGetJsonArray(String content) {
        try {
            return new AndroidJsonArray(new JSONArray(content));
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonFactory.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not get JsonArray from content: %s",
                    content
            ));
        }
        return new AndroidJsonArray(new JSONArray());
    }

    @Override
    protected JsonObject onGetJsonObject(String content) {
        try {
            return new AndroidJsonObject(new JSONObject(content));
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonFactory.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not get JsonObject from content: %s",
                    content
            ));
        }
        return new AndroidJsonObject(new JSONObject());
    }

    @Override
    protected String onSerializeObject(Object content) {
        Logger.getInstance(AndroidJsonFactory.class.getSimpleName()).error(
                "This implementation of JsonFactory does not support object serialization!!"
        );
        return null;
    }
}
