package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1907j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mipush.sdk.b */
public class C1578b {

    /* renamed from: a */
    private static volatile C1578b f1694a;

    /* renamed from: a */
    private Context f1695a;

    /* renamed from: a */
    private C1579a f1696a;

    /* renamed from: a */
    String f1697a;

    /* renamed from: a */
    private Map<String, C1579a> f1698a;

    /* renamed from: com.xiaomi.mipush.sdk.b$a */
    public static class C1579a {

        /* renamed from: a */
        public int f1699a = 1;

        /* renamed from: a */
        private Context f1700a;

        /* renamed from: a */
        public String f1701a;

        /* renamed from: a */
        public boolean f1702a = true;

        /* renamed from: b */
        public String f1703b;

        /* renamed from: b */
        public boolean f1704b = false;

        /* renamed from: c */
        public String f1705c;

        /* renamed from: d */
        public String f1706d;

        /* renamed from: e */
        public String f1707e;

        /* renamed from: f */
        public String f1708f;

        /* renamed from: g */
        public String f1709g;

        /* renamed from: h */
        public String f1710h;

        public C1579a(Context context) {
            this.f1700a = context;
        }

        /* renamed from: a */
        public static C1579a m2401a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C1579a aVar = new C1579a(context);
                aVar.f1701a = jSONObject.getString("appId");
                aVar.f1703b = jSONObject.getString("appToken");
                aVar.f1705c = jSONObject.getString("regId");
                aVar.f1706d = jSONObject.getString("regSec");
                aVar.f1708f = jSONObject.getString("devId");
                aVar.f1707e = jSONObject.getString("vName");
                aVar.f1702a = jSONObject.getBoolean("valid");
                aVar.f1704b = jSONObject.getBoolean("paused");
                aVar.f1699a = jSONObject.getInt("envType");
                aVar.f1709g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                C1524b.m2155a(th);
                return null;
            }
        }

        /* renamed from: a */
        private String mo17177a() {
            Context context = this.f1700a;
            return C1816g.m3659a(context, context.getPackageName());
        }

        /* renamed from: a */
        public static String m2403a(C1579a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f1701a);
                jSONObject.put("appToken", aVar.f1703b);
                jSONObject.put("regId", aVar.f1705c);
                jSONObject.put("regSec", aVar.f1706d);
                jSONObject.put("devId", aVar.f1708f);
                jSONObject.put("vName", aVar.f1707e);
                jSONObject.put("valid", aVar.f1702a);
                jSONObject.put("paused", aVar.f1704b);
                jSONObject.put("envType", aVar.f1699a);
                jSONObject.put("regResource", aVar.f1709g);
                return jSONObject.toString();
            } catch (Throwable th) {
                C1524b.m2155a(th);
                return null;
            }
        }

        /* renamed from: a */
        public void m2404a() {
            C1578b.m2373a(this.f1700a).edit().clear().commit();
            this.f1701a = null;
            this.f1703b = null;
            this.f1705c = null;
            this.f1706d = null;
            this.f1708f = null;
            this.f1707e = null;
            this.f1702a = false;
            this.f1704b = false;
            this.f1710h = null;
            this.f1699a = 1;
        }

        /* renamed from: a */
        public void mo17178a(int i) {
            this.f1699a = i;
        }

        /* renamed from: a */
        public void mo17179a(String str, String str2) {
            this.f1705c = str;
            this.f1706d = str2;
            this.f1708f = C1907j.m4581l(this.f1700a);
            this.f1707e = mo17177a();
            this.f1702a = true;
        }

        /* renamed from: a */
        public void mo17180a(String str, String str2, String str3) {
            this.f1701a = str;
            this.f1703b = str2;
            this.f1709g = str3;
            SharedPreferences.Editor edit = C1578b.m2373a(this.f1700a).edit();
            edit.putString("appId", this.f1701a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        /* renamed from: a */
        public void mo17181a(boolean z) {
            this.f1704b = z;
        }

        /* renamed from: a */
        public boolean m2409a() {
            return mo17179a(this.f1701a, this.f1703b);
        }

        /* renamed from: a */
        public boolean m2410a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f1701a, str);
            boolean equals2 = TextUtils.equals(this.f1703b, str2);
            boolean z = !TextUtils.isEmpty(this.f1705c);
            boolean z2 = !TextUtils.isEmpty(this.f1706d);
            boolean z3 = TextUtils.equals(this.f1708f, C1907j.m4581l(this.f1700a)) || TextUtils.equals(this.f1708f, C1907j.m4580k(this.f1700a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                C1524b.m2161e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", new Object[]{Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}));
            }
            return z4;
        }

        /* renamed from: b */
        public void mo17182b() {
            this.f1702a = false;
            C1578b.m2373a(this.f1700a).edit().putBoolean("valid", this.f1702a).commit();
        }

        /* renamed from: b */
        public void mo17183b(String str, String str2, String str3) {
            this.f1705c = str;
            this.f1706d = str2;
            this.f1708f = C1907j.m4581l(this.f1700a);
            this.f1707e = mo17177a();
            this.f1702a = true;
            this.f1710h = str3;
            SharedPreferences.Editor edit = C1578b.m2373a(this.f1700a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f1708f);
            edit.putString("vName", mo17177a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        /* renamed from: c */
        public void mo17184c(String str, String str2, String str3) {
            this.f1701a = str;
            this.f1703b = str2;
            this.f1709g = str3;
        }
    }

    private C1578b(Context context) {
        this.f1695a = context;
        mo17173c();
    }

    /* renamed from: a */
    public static SharedPreferences m2373a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a */
    public static C1578b m2374a(Context context) {
        if (f1694a == null) {
            synchronized (C1578b.class) {
                if (f1694a == null) {
                    f1694a = new C1578b(context);
                }
            }
        }
        return f1694a;
    }

    /* renamed from: c */
    private void mo17173c() {
        this.f1696a = new C1579a(this.f1695a);
        this.f1698a = new HashMap();
        SharedPreferences a = m2373a(this.f1695a);
        this.f1696a.f1701a = a.getString("appId", (String) null);
        this.f1696a.f1703b = a.getString("appToken", (String) null);
        this.f1696a.f1705c = a.getString("regId", (String) null);
        this.f1696a.f1706d = a.getString("regSec", (String) null);
        this.f1696a.f1708f = a.getString("devId", (String) null);
        if (!TextUtils.isEmpty(this.f1696a.f1708f) && C1907j.m4549a(this.f1696a.f1708f)) {
            this.f1696a.f1708f = C1907j.m4581l(this.f1695a);
            a.edit().putString("devId", this.f1696a.f1708f).commit();
        }
        this.f1696a.f1707e = a.getString("vName", (String) null);
        this.f1696a.f1702a = a.getBoolean("valid", true);
        this.f1696a.f1704b = a.getBoolean("paused", false);
        this.f1696a.f1699a = a.getInt("envType", 1);
        this.f1696a.f1709g = a.getString("regResource", (String) null);
        this.f1696a.f1710h = a.getString("appRegion", (String) null);
    }

    /* renamed from: a */
    public int mo17163a() {
        return this.f1696a.f1699a;
    }

    /* renamed from: a */
    public C1579a mo17164a(String str) {
        if (this.f1698a.containsKey(str)) {
            return this.f1698a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a = m2373a(this.f1695a);
        if (!a.contains(str2)) {
            return null;
        }
        C1579a a2 = C1579a.m2401a(this.f1695a, a.getString(str2, ""));
        this.f1698a.put(str2, a2);
        return a2;
    }

    /* renamed from: a */
    public String m2378a() {
        return this.f1696a.f1701a;
    }

    /* renamed from: a */
    public void m2379a() {
        this.f1696a.mo17177a();
    }

    /* renamed from: a */
    public void mo17165a(int i) {
        this.f1696a.mo17178a(i);
        m2373a(this.f1695a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a */
    public void m2381a(String str) {
        SharedPreferences.Editor edit = m2373a(this.f1695a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f1696a.f1707e = str;
    }

    /* renamed from: a */
    public void mo17166a(String str, C1579a aVar) {
        this.f1698a.put(str, aVar);
        String a = C1579a.m2403a(aVar);
        m2373a(this.f1695a).edit().putString("hybrid_app_info_" + str, a).commit();
    }

    /* renamed from: a */
    public void mo17167a(String str, String str2, String str3) {
        this.f1696a.mo17180a(str, str2, str3);
    }

    /* renamed from: a */
    public void mo17168a(boolean z) {
        this.f1696a.mo17181a(z);
        m2373a(this.f1695a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a */
    public boolean m2385a() {
        Context context = this.f1695a;
        return !TextUtils.equals(C1816g.m3659a(context, context.getPackageName()), this.f1696a.f1707e);
    }

    /* renamed from: a */
    public boolean mo17169a(String str, String str2) {
        return this.f1696a.mo17179a(str, str2);
    }

    /* renamed from: a */
    public boolean m2387a(String str, String str2, String str3) {
        C1579a a = mo17164a(str3);
        return a != null && TextUtils.equals(str, a.f1701a) && TextUtils.equals(str2, a.f1703b);
    }

    /* renamed from: b */
    public String mo17170b() {
        return this.f1696a.f1703b;
    }

    /* renamed from: b */
    public void m2389b() {
        this.f1696a.mo17182b();
    }

    /* renamed from: b */
    public void mo17171b(String str) {
        this.f1698a.remove(str);
        m2373a(this.f1695a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* renamed from: b */
    public void mo17172b(String str, String str2, String str3) {
        this.f1696a.mo17183b(str, str2, str3);
    }

    /* renamed from: b */
    public boolean m2392b() {
        if (this.f1696a.mo17177a()) {
            return true;
        }
        C1524b.m2141a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c */
    public String m2393c() {
        return this.f1696a.f1705c;
    }

    /* renamed from: c */
    public boolean m2394c() {
        return this.f1696a.mo17177a();
    }

    /* renamed from: d */
    public String mo17174d() {
        return this.f1696a.f1706d;
    }

    /* renamed from: d */
    public boolean m2396d() {
        return !TextUtils.isEmpty(this.f1696a.f1701a) && !TextUtils.isEmpty(this.f1696a.f1703b) && !TextUtils.isEmpty(this.f1696a.f1705c) && !TextUtils.isEmpty(this.f1696a.f1706d);
    }

    /* renamed from: e */
    public String mo17175e() {
        return this.f1696a.f1709g;
    }

    /* renamed from: e */
    public boolean m2398e() {
        return this.f1696a.f1704b;
    }

    /* renamed from: f */
    public String mo17176f() {
        return this.f1696a.f1710h;
    }

    /* renamed from: f */
    public boolean m2400f() {
        return !this.f1696a.f1702a;
    }
}
