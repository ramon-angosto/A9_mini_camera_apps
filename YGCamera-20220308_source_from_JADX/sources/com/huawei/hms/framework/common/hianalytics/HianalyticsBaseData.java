package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HianalyticsBaseData {
    protected static final String SDK_NAME = "sdk_name";
    private static final String SDK_TYPE = "sdk_type";
    private static final String TAG = "HianalyticsBaseData";
    private LinkedHashMap<String, String> data = new LinkedHashMap<>();

    public HianalyticsBaseData() {
        this.data.put(SDK_TYPE, "UxPP");
        this.data.put(SDK_NAME, "Restclient");
    }

    public LinkedHashMap<String, String> get() {
        return this.data;
    }

    public HianalyticsBaseData put(String str, long j) {
        if (str == null) {
            Logger.m476v(TAG, "key = null : value = " + j);
        } else {
            LinkedHashMap<String, String> linkedHashMap = this.data;
            linkedHashMap.put(str, "" + j);
        }
        return this;
    }

    public HianalyticsBaseData put(String str, String str2) {
        if (str == null || str2 == null) {
            Logger.m476v(TAG, "key = " + str + " : value = " + str2);
        } else {
            this.data.put(str, str2);
        }
        return this;
    }

    public HianalyticsBaseData put(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            Logger.m476v(TAG, "data is null");
        } else {
            this.data.putAll(linkedHashMap);
        }
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : get().entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        } catch (JSONException e) {
            Logger.m479w(TAG, "catch JSONException", (Throwable) e);
        }
        return jSONObject.toString();
    }
}
