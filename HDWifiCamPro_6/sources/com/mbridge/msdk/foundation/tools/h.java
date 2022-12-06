package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonUtils */
public final class h {
    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    public static String a(int i, int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Sucess");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rotateAngle", i);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TtmlNode.LEFT, i2);
            jSONObject3.put(TtmlNode.RIGHT, i3);
            jSONObject3.put("top", i4);
            jSONObject3.put("bottom", i5);
            jSONObject2.put("cutoutInfo", jSONObject3);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
        } catch (Exception e) {
            q.d("JSONUtils", e.getMessage());
        } catch (Throwable th) {
            q.d("JSONUtils", th.getMessage());
            try {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Fail");
            } catch (JSONException e2) {
                q.d("JSONUtils", e2.getMessage());
            }
        }
        return jSONObject.toString();
    }
}
