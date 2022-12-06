package com.mbridge.msdk.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HandlerH5MessageManager */
public final class b {
    int a;
    int b;
    private String c;

    /* compiled from: HandlerH5MessageManager */
    private static final class a {
        /* access modifiers changed from: private */
        public static b a = new b();
    }

    private b() {
        this.c = "handlerNativeResult";
        this.a = 0;
        this.b = 1;
    }

    public static b a() {
        return a.a;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String optString = jSONObject.optString("uniqueIdentifier");
                    String optString2 = jSONObject.optString("name");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!TextUtils.isEmpty(optString2)) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
                            JSONObject optJSONObject = jSONObject.optJSONObject(IronSourceConstants.EVENTS_RESULT);
                            int i = 0;
                            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.toString())) {
                                i = optJSONObject.optInt("type", 0);
                            }
                            a(this.a, "receivedMessage", obj);
                            if (optString.equalsIgnoreCase("reporter")) {
                                com.mbridge.msdk.mbsignalcommon.a.a.a().a(obj, optString2, optJSONArray, i);
                                return;
                            } else if (optString.equalsIgnoreCase("MediaPlayer")) {
                                a.a().a(obj, optString2, optJSONArray, i);
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    a(this.b, "module or method is null", obj);
                    return;
                }
            } catch (Exception e) {
                q.a("HandlerH5MessageManager", e.getMessage());
                a(this.b, e.getMessage(), obj);
                return;
            } catch (Throwable th) {
                q.a("HandlerH5MessageManager", th.getMessage());
                a(this.b, th.getMessage(), obj);
                return;
            }
        }
        a(this.b, "params is null", obj);
    }

    private void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            q.a("HandlerH5MessageManager", e.getMessage());
        } catch (Throwable th) {
            q.a("HandlerH5MessageManager", th.getMessage());
        }
    }
}
