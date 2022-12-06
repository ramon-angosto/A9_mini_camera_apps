package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.Map;

/* renamed from: com.xiaomi.push.az */
public class C1640az implements C1633at {

    /* renamed from: a */
    private static volatile C1640az f1827a;

    /* renamed from: a */
    private int f1828a = C1639ay.f1826a;

    /* renamed from: a */
    private C1633at f1829a;

    private C1640az(Context context) {
        this.f1829a = C1639ay.m2598a(context);
        C1524b.m2141a("create id manager is: " + this.f1828a);
    }

    /* renamed from: a */
    public static C1640az m2599a(Context context) {
        if (f1827a == null) {
            synchronized (C1640az.class) {
                if (f1827a == null) {
                    f1827a = new C1640az(context.getApplicationContext());
                }
            }
        }
        return f1827a;
    }

    /* renamed from: a */
    private String m2600a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public String mo17232a() {
        return m2600a(this.f1829a.mo17232a());
    }

    /* renamed from: a */
    public void m2602a() {
    }

    /* renamed from: a */
    public void mo17240a(Map<String, String> map) {
        if (map != null) {
            String a = mo17232a();
            if (!TextUtils.isEmpty(a)) {
                map.put("udid", a);
            }
            String b = mo17233b();
            if (!TextUtils.isEmpty(b)) {
                map.put("oaid", b);
            }
            String c = mo17234c();
            if (!TextUtils.isEmpty(c)) {
                map.put("vaid", c);
            }
            String d = mo17235d();
            if (!TextUtils.isEmpty(d)) {
                map.put("aaid", d);
            }
            map.put("oaid_type", String.valueOf(this.f1828a));
        }
    }

    /* renamed from: a */
    public boolean m2604a() {
        return this.f1829a.mo17232a();
    }

    /* renamed from: b */
    public String mo17233b() {
        return m2600a(this.f1829a.mo17233b());
    }

    /* renamed from: c */
    public String mo17234c() {
        return m2600a(this.f1829a.mo17234c());
    }

    /* renamed from: d */
    public String mo17235d() {
        return m2600a(this.f1829a.mo17235d());
    }
}
