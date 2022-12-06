package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.mbridge.msdk.MBridgeConstans;
import org.json.JSONObject;

/* compiled from: SpCache */
class n {
    private String a;
    private Context b;

    n(Context context, String str) {
        this.b = context;
        this.a = TextUtils.isEmpty(str) ? "" : str;
    }

    private Context b() {
        Context context = this.b;
        return context == null ? m.a() : context;
    }

    private SharedPreferences f(String str) {
        try {
            if (b() != null) {
                return b().getSharedPreferences(str, 0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = MBridgeConstans.ENDCARD_URL_TYPE_PL;
        }
        return this.a + "_cache_" + str;
    }

    private String c() {
        return this.a + "_adslot";
    }

    private String d() {
        return this.a + "_adslot_preload";
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        try {
            if (b.c()) {
                return a.b(g(str), "material_data", (String) null);
            }
            SharedPreferences f = f(g(str));
            if (f != null) {
                return f.getString("material_data", (String) null);
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public long b(String str) {
        try {
            if (b.c()) {
                return a.a(g(str), "create_time", 0);
            }
            SharedPreferences f = f(g(str));
            if (f != null) {
                return f.getLong("create_time", 0);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        try {
            if (b.c()) {
                return a.a(g(str), "has_played", true);
            }
            SharedPreferences f = f(g(str));
            if (f != null) {
                return f.getBoolean("has_played", true);
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            if (b.c()) {
                a.a(g(str), "has_played", (Boolean) false);
                a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                a.a(g(str), "material_data", str2);
                return;
            }
            SharedPreferences f = f(g(str));
            if (f != null) {
                f.edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        try {
            if (b.c()) {
                a.a(g(str));
                return;
            }
            SharedPreferences f = f(g(str));
            if (f != null) {
                f.edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public AdSlot e(String str) {
        String str2;
        try {
            if (b.c()) {
                str2 = a.b(c(), str, (String) null);
            } else {
                SharedPreferences f = f(c());
                str2 = f != null ? f.getString(str, (String) null) : null;
            }
            return AdSlot.getSlot(str2 != null ? new JSONObject(str2) : null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String jSONObject = adSlot.toJsonObj().toString();
                    if (b.c()) {
                        a.a(c(), adSlot.getCodeId(), jSONObject);
                        return;
                    }
                    SharedPreferences f = f(c());
                    if (f != null) {
                        f.edit().putString(adSlot.getCodeId(), jSONObject).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String jSONObject = adSlot.toJsonObj().toString();
                    if (b.c()) {
                        a.a(d(), "preload_data", jSONObject);
                        return;
                    }
                    SharedPreferences f = f(d());
                    if (f != null) {
                        f.edit().putString("preload_data", jSONObject).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public AdSlot a() {
        String str;
        try {
            if (b.c()) {
                str = a.b(d(), "preload_data", (String) null);
                a.a(d());
            } else {
                SharedPreferences f = f(d());
                if (f != null) {
                    String string = f.getString("preload_data", (String) null);
                    f.edit().clear().apply();
                    str = string;
                } else {
                    str = null;
                }
            }
            return AdSlot.getSlot(str != null ? new JSONObject(str) : null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
