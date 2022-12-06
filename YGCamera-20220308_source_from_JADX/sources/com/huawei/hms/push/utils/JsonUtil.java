package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    /* renamed from: a */
    public static void m1327a(JSONObject jSONObject, String str, Object obj, Bundle bundle) {
        if (obj == null) {
            HMSLog.m1380w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
        } else if (obj instanceof String) {
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            bundle.putString(str, getString(jSONObject, str, str2));
        } else if (obj instanceof Integer) {
            bundle.putInt(str, getInt(jSONObject, str, ((Integer) obj).intValue()));
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr.length == 0) {
                iArr = null;
            }
            bundle.putIntArray(str, getIntArray(jSONObject, str, iArr));
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            if (jArr.length == 0) {
                jArr = null;
            }
            bundle.putLongArray(str, getLongArray(jSONObject, str, jArr));
        } else if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            if (strArr.length == 0) {
                strArr = null;
            }
            bundle.putStringArray(str, getStringArray(jSONObject, str, strArr));
        } else {
            HMSLog.m1380w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null) {
            return i;
        }
        try {
            if (jSONObject.has(str)) {
                return jSONObject.getInt(str);
            }
            return i;
        } catch (JSONException unused) {
            HMSLog.m1380w("JsonUtil", "JSONException: get " + str + " error.");
            return i;
        }
    }

    public static int[] getIntArray(JSONObject jSONObject, String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    iArr2 = new int[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        iArr2[i] = ((Integer) jSONArray.get(i)).intValue();
                    }
                }
            } catch (JSONException unused) {
                HMSLog.m1380w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return iArr2 == null ? iArr : iArr2;
    }

    public static JSONArray getIntJsonArray(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(iArr == null || iArr.length == 0)) {
            for (int put : iArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(JSONObject jSONObject, String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    jArr2 = new long[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        jArr2[i] = jSONArray.getLong(i);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.m1380w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return jArr2 == null ? jArr : jArr2;
    }

    public static JSONArray getLongJsonArray(long[] jArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(jArr == null || jArr.length == 0)) {
            for (long put : jArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return str2;
        }
        try {
            if (!jSONObject.has(str) || jSONObject.get(str) == null) {
                return str2;
            }
            return String.valueOf(jSONObject.get(str));
        } catch (JSONException unused) {
            HMSLog.m1380w("JsonUtil", "JSONException: get " + str + " error.");
            return str2;
        }
    }

    public static String[] getStringArray(JSONObject jSONObject, String str, String[] strArr) {
        String[] strArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = (String) jSONArray.get(i);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.m1380w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return strArr2;
    }

    public static JSONArray getStringJsonArray(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(strArr == null || strArr.length == 0)) {
            for (String put : strArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> hashMap) {
        for (Map.Entry next : hashMap.entrySet()) {
            m1327a(jSONObject, (String) next.getKey(), next.getValue(), bundle);
        }
    }
}
