package com.htc.vita.mod.android.json;

import com.htc.vita.core.json.JsonArray;
import com.htc.vita.core.json.JsonObject;
import com.htc.vita.core.log.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class AndroidJsonArray extends JsonArray {
    private final JSONArray mJSONArray;

    public AndroidJsonArray(JSONArray jsonArray) {
        mJSONArray = jsonArray;
    }

    public JSONArray getInnerInstance(){
        return mJSONArray;
    }

    @Override
    protected JsonArray onAppendBoolean(boolean value) {
        if (mJSONArray != null) {
            mJSONArray.put(value);
        }
        return this;
    }

    @Override
    protected JsonArray onAppendDouble(double value) {
        if (mJSONArray != null) {
            try {
                mJSONArray.put(value);
            } catch (JSONException e) {
                Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
            }
        }
        return this;
    }

    @Override
    protected JsonArray onAppendFloat(float value) {
        if (mJSONArray != null) {
            try {
                mJSONArray.put(value);
            } catch (JSONException e) {
                Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
            }
        }
        return this;
    }

    @Override
    protected JsonArray onAppendInt(int value) {
        if (mJSONArray != null) {
            mJSONArray.put(value);
        }
        return this;
    }

    @Override
    protected JsonArray onAppendLong(long value) {
        if (mJSONArray != null) {
            mJSONArray.put(value);
        }
        return this;
    }

    @Override
    protected JsonArray onAppendString(String value) {
        if (mJSONArray != null) {
            mJSONArray.put(value);
        }
        return this;
    }

    @Override
    protected JsonArray onAppendJsonArray(JsonArray value) {
        if (mJSONArray == null) {
            return this;
        }
        mJSONArray.put(((AndroidJsonArray)value).getInnerInstance());
        return this;
    }

    @Override
    protected JsonArray onAppendJsonObject(JsonObject value) {
        if (mJSONArray == null) {
            return this;
        }
        mJSONArray.put(((AndroidJsonObject)value).getInnerInstance());
        return this;
    }

    @Override
    protected JsonArray onInsertBoolean(
            int index,
            boolean value) {
        if (mJSONArray == null) {
            return this;
        }
        try {
            if (mJSONArray.length() <= index) {
                mJSONArray.put(value);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                    for (int i = length - 1; i > index; i--) {
                        boolean temp = mJSONArray.getBoolean(i - 1);
                        mJSONArray.put(
                                i,
                                temp
                        );
                    }
                    mJSONArray.put(
                            index,
                            value
                    );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected JsonArray onInsertDouble(
            int index,
            double value) {
        if (mJSONArray == null) {
            return this;
        }
        try {
            if (mJSONArray.length() <= index) {
                mJSONArray.put(value);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                for (int i = length - 1; i > index; i--) {
                    Object temp = mJSONArray.get(i - 1);
                    mJSONArray.put(
                            i,
                            temp
                    );
                }
                mJSONArray.put(
                        index,
                        value
                );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected JsonArray onInsertFloat(
            int index,
            float value) {
        if (mJSONArray == null) {
            return this;
        }
        try {
            if (mJSONArray.length() <= index) {
                mJSONArray.put(value);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                for (int i = length - 1; i > index; i--) {
                    Object temp = mJSONArray.get(i - 1);
                    mJSONArray.put(
                            i,
                            temp
                    );
                }
                mJSONArray.put(
                        index,
                        value
                );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected JsonArray onInsertInt(
            int index,
            int value) {
        if (mJSONArray == null) {
            return this;
        }
        try {
            if (mJSONArray.length() <= index) {
                mJSONArray.put(value);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                for (int i = length - 1; i > index; i--) {
                    Object temp = mJSONArray.get(i - 1);
                    mJSONArray.put(
                            i,
                            temp
                    );
                }
                mJSONArray.put(
                        index,
                        value
                );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected JsonArray onInsertLong(
            int index,
            long value) {
        if (mJSONArray == null) {
            return this;
        }
        try {
            if (mJSONArray.length() <= index) {
                mJSONArray.put(value);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                for (int i = length - 1; i > index; i--) {
                    Object temp = mJSONArray.get(i - 1);
                    mJSONArray.put(
                            i,
                            temp
                    );
                }
                mJSONArray.put(
                        index,
                        value
                );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected JsonArray onInsertString(
            int index,
            String value) {
        if (mJSONArray == null) {
            return this;
        }
        try {
            if (mJSONArray.length() <= index) {
                mJSONArray.put(value);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                for (int i = length - 1; i > index; i--) {
                    Object temp = mJSONArray.get(i - 1);
                    mJSONArray.put(
                            i,
                            temp
                    );
                }
                mJSONArray.put(
                        index,
                        value
                );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected JsonArray onInsertJsonArray(
            int index,
            JsonArray value) {
        if (mJSONArray == null || value == null) {
            return this;
        }
        try {
            JSONArray jsonArray = ((AndroidJsonArray)value).getInnerInstance();
            if (mJSONArray.length() <= index) {
                mJSONArray.put(jsonArray);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                for (int i = length - 1; i > index; i--) {
                    Object temp = mJSONArray.get(i - 1);
                    mJSONArray.put(
                            i,
                            temp
                    );
                }
                mJSONArray.put(
                        index,
                        jsonArray
                );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected JsonArray onInsertJsonObject(
            int index,
            JsonObject value) {
        if (mJSONArray == null || value == null) {
            return this;
        }
        try {
            JSONObject jsonObject = ((AndroidJsonObject)value).getInnerInstance();
            if (mJSONArray.length() <= index) {
                mJSONArray.put(jsonObject);
            } else {
                mJSONArray.put(value);
                int length = mJSONArray.length();
                for (int i = length - 1; i > index; i--) {
                    Object temp = mJSONArray.get(i - 1);
                    mJSONArray.put(
                            i,
                            temp
                    );
                }
                mJSONArray.put(
                        index,
                        jsonObject
                );
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(e.toString());
        }
        return this;
    }

    @Override
    protected boolean onParseBoolean(
            int index,
            boolean defaultValue) {
        boolean result = defaultValue;
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return result;
        }
        try {
            result = mJSONArray.getBoolean(index);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse boolean value by index: %d",
                    index
            ));
        }
        return result;
    }

    @Override
    protected double onParseDouble(
            int index,
            double defaultValue) {
        double result = defaultValue;
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return result;
        }
        try {
            result = mJSONArray.getDouble(index);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse double value by index: %d",
                    index
            ));
        }
        return result;
    }

    @Override
    protected float onParseFloat(
            int index,
            float defaultValue) {
        float result = defaultValue;
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return result;
        }
        try {
            result = (float) mJSONArray.getDouble(index);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse float value by index: %d",
                    index
            ));
        }
        return result;
    }

    @Override
    protected int onParseInt(
            int index,
            int defaultValue) {
        int result = defaultValue;
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return result;
        }
        try {
            result = mJSONArray.getInt(index);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse int value by index: %d",
                    index
            ));
        }
        return result;
    }

    @Override
    protected long onParseLong(
            int index,
            long defaultValue) {
        long result = defaultValue;
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return result;
        }
        try {
            result = mJSONArray.getLong(index);
        } catch (Exception e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse long value by index: %d",
                    index
            ));
        }
        return result;
    }

    @Override
    protected String onParseString(
            int index,
            String defaultValue) {
        String result = defaultValue;
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return result;
        }
        try {
            result = mJSONArray.getString(index);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse String value by index: %d",
                    index
            ));
        }
        return result;
    }

    @Override
    protected JsonArray onParseJsonArray(int index) {
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return null;
        }
        try {
            JSONArray jsonArray = mJSONArray.getJSONArray(index);
            if (jsonArray != null) {
                return new AndroidJsonArray(jsonArray);
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse JavaArray value by index: %d",
                    index
            ));
        }
        return null;
    }

    @Override
    protected JsonObject onParseJsonObject(int index) {
        if (mJSONArray == null || mJSONArray.length() <= index) {
            return null;
        }
        try {
            JSONObject jsonObject = mJSONArray.getJSONObject(index);
            if (jsonObject != null) {
                return new AndroidJsonObject(jsonObject);
            }
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error(String.format(
                    Locale.ROOT,
                    "Can not parse JavaObject value by index: %d",
                    index
            ));
        }
        return null;
    }

    @Override
    protected int onSize() {
        if (mJSONArray != null) {
            return mJSONArray.length();
        }
        return 0;
    }

    @Override
    protected String onToPrettyString() {
        if (mJSONArray == null) {
            return "";
        }
        try {
            return mJSONArray.toString(2);
        } catch (JSONException e) {
            Logger.getInstance(AndroidJsonArray.class.getSimpleName()).error("Can not output pretty string");
        }
        return "";
    }

    @Override
    public String toString() {
        if (mJSONArray == null) {
            return "";
        }
        return mJSONArray.toString();
    }
}
