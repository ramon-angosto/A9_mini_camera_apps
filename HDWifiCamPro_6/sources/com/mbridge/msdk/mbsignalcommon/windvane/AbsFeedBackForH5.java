package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;

public abstract class AbsFeedBackForH5 extends h {
    private static int e = 0;
    private static int f = 1;
    private String d = "AbsFeedBackForH5";

    public void feedbackOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                b.a().a(jSONObject.optString("key", ""), optInt == 1 ? 8 : 0, (ViewGroup) aVar.a);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        Object obj2 = obj;
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj2;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("width", -1);
                int optInt2 = jSONObject.optInt("height", -1);
                int optInt3 = jSONObject.optInt(TtmlNode.LEFT, -1);
                int optInt4 = jSONObject.optInt("top", -1);
                double optDouble = jSONObject.optDouble("opacity", 1.0d);
                int optInt5 = jSONObject.optInt("radius", 20);
                String optString = jSONObject.optString("fontColor", "");
                String optString2 = jSONObject.optString("bgColor", "");
                String optString3 = jSONObject.optString("key", "");
                double optDouble2 = jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, -1.0d);
                float f2 = (float) optDouble;
                float f3 = (float) optDouble2;
                b.a().a(optString3, optInt, optInt2, optInt5, (float) optInt3, (float) optInt4, f2, optString, optString2, f3, jSONObject.optJSONArray("padding"));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj2, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                b.a().a(jSONObject.optString("key", ""), optInt);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", e);
            jSONObject.put("message", "");
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            q.a(this.d, e2.getMessage());
        }
    }

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            q.a(this.d, e2.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", e);
            jSONObject2.put("message", "");
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            q.a(this.d, e2.getMessage());
        }
    }
}
