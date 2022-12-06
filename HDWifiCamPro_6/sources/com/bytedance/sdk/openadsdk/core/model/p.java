package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PlayableModel */
public class p {
    private boolean a;
    private int b;
    private String c;
    private String d;
    private int e;

    public static boolean e(n nVar) {
        return false;
    }

    public p(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("playable");
            if (optJSONObject != null) {
                this.d = optJSONObject.optString("playable_url", "");
                this.e = optJSONObject.optInt("playable_orientation", 0);
            }
            this.a = jSONObject.optBoolean("is_playable");
            this.b = jSONObject.optInt("playable_type", 0);
            this.c = jSONObject.optString("playable_style");
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.d)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.d);
                jSONObject2.put("playable_orientation", this.e);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        try {
            jSONObject.put("playable_type", this.b);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("playable_style", this.c);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    private static p k(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.e();
    }

    public static boolean a(n nVar) {
        p k = k(nVar);
        if (k != null && k.a && !TextUtils.isEmpty(d(nVar))) {
            return true;
        }
        return false;
    }

    private static int l(n nVar) {
        p k = k(nVar);
        if (k == null) {
            return 0;
        }
        return k.b;
    }

    public static String b(n nVar) {
        p k = k(nVar);
        if (k == null) {
            return null;
        }
        return k.c;
    }

    public static String c(n nVar) {
        p k = k(nVar);
        if (k == null) {
            return null;
        }
        return k.d;
    }

    public static String d(n nVar) {
        if (nVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(c(nVar))) {
            return c(nVar);
        }
        if (nVar.J() != null) {
            return nVar.J().j();
        }
        return null;
    }

    public static boolean f(n nVar) {
        if (((nVar == null || nVar.J() == null) ? 0 : nVar.J().r()) != 1) {
            return true;
        }
        return false;
    }

    public static boolean g(n nVar) {
        if (nVar == null || nVar.J() == null || nVar.J().r() != 1) {
            return false;
        }
        return true;
    }

    public static int h(n nVar) {
        p k = k(nVar);
        if (k == null) {
            return 0;
        }
        return k.e;
    }

    public static boolean i(n nVar) {
        return a(nVar) && l(nVar) == 1;
    }

    public static boolean j(n nVar) {
        return a(nVar) && l(nVar) == 0;
    }
}
