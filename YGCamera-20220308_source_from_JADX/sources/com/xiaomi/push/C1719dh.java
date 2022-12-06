package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.dh */
class C1719dh {

    /* renamed from: a */
    private Context f2022a;

    /* renamed from: a */
    private SharedPreferences f2023a;

    public C1719dh(Context context) {
        this.f2022a = context.getApplicationContext();
        String str = "mipush_scr_file";
        try {
            String a = C1816g.m3664a(context);
            if (a != null) {
                str = str + "_" + a.hashCode();
            }
        } catch (Throwable unused) {
        }
        this.f2023a = context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    private JSONArray m2988a(boolean z) {
        String string = this.f2023a.getString("k_e", "");
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray2 = new JSONArray(string);
                if (z) {
                    try {
                        String b = C1720di.m3000b(this.f2022a);
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            jSONArray2.getJSONObject(i).put(C1714dc.f2002e, b);
                        }
                    } catch (Throwable unused) {
                    }
                }
                jSONArray = jSONArray2;
            } catch (Throwable unused2) {
            }
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    /* renamed from: a */
    public long mo17383a() {
        return this.f2023a.getLong("k_t", 0);
    }

    /* renamed from: a */
    public JSONArray m2990a() {
        return m2988a(true);
    }

    /* renamed from: a */
    public void m2991a() {
        try {
            C1524b.m2158b("scr delete");
            this.f2023a.edit().remove("k_e").putLong("k_t", System.currentTimeMillis()).commit();
        } catch (Throwable th) {
            C1524b.m2141a("scr delete error " + th);
        }
    }

    /* renamed from: a */
    public void mo17384a(String str, int i) {
        try {
            JSONArray a = m2988a(false);
            if (a.length() >= 20) {
                C1524b.m2141a("scr too max count, ignore this ex");
                return;
            }
            JSONObject jSONObject = null;
            int i2 = 0;
            while (true) {
                if (i2 >= a.length()) {
                    break;
                }
                JSONObject jSONObject2 = a.getJSONObject(i2);
                if (str.equalsIgnoreCase(jSONObject2.optString(C1714dc.f2005h, ""))) {
                    jSONObject2.put(C1714dc.f2006i, jSONObject2.optInt(C1714dc.f2006i, 1) + 1);
                    jSONObject2.put(C1714dc.f2009l, System.currentTimeMillis());
                    C1524b.m2158b("scr update");
                    jSONObject = jSONObject2;
                    break;
                }
                i2++;
            }
            if (jSONObject == null) {
                C1524b.m2158b("scr insert");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(C1714dc.f1997a, 30809);
                jSONObject3.put(C1714dc.f1999b, C1720di.m2995a(this.f2022a));
                jSONObject3.put(C1714dc.f2000c, C1720di.m2993a());
                jSONObject3.put(C1714dc.f2001d, C1720di.m2993a());
                jSONObject3.put(C1714dc.f2003f, 0);
                jSONObject3.put(C1714dc.f2004g, i);
                jSONObject3.put(C1714dc.f2005h, str);
                jSONObject3.put(C1714dc.f2006i, 1);
                jSONObject3.put(C1714dc.f2007j, C1720di.m2996a(str));
                jSONObject3.put(C1714dc.f2008k, System.currentTimeMillis());
                jSONObject3.put(C1714dc.f2009l, System.currentTimeMillis());
                a.put(jSONObject3);
            }
            this.f2023a.edit().putString("k_e", a.toString()).commit();
        } catch (Throwable th) {
            C1524b.m2141a("scr insert error " + th);
        }
    }
}
