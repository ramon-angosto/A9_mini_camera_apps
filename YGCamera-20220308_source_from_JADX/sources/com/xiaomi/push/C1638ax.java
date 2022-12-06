package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.lang.reflect.Method;

/* renamed from: com.xiaomi.push.ax */
class C1638ax implements C1633at {

    /* renamed from: a */
    private Context f1819a;

    /* renamed from: a */
    private Class<?> f1820a;

    /* renamed from: a */
    private Object f1821a;

    /* renamed from: a */
    private Method f1822a = null;

    /* renamed from: b */
    private Method f1823b = null;

    /* renamed from: c */
    private Method f1824c = null;

    /* renamed from: d */
    private Method f1825d = null;

    public C1638ax(Context context) {
        this.f1819a = context;
        m2591a(context);
    }

    /* renamed from: a */
    private String m2590a(Context context, Method method) {
        Object obj = this.f1821a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, new Object[]{context});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            C1524b.m2154a("miui invoke error", (Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    private void m2591a(Context context) {
        try {
            this.f1820a = C2087u.m5373a(context, "com.android.id.impl.IdProviderImpl");
            this.f1821a = this.f1820a.newInstance();
            this.f1822a = this.f1820a.getMethod("getUDID", new Class[]{Context.class});
            this.f1823b = this.f1820a.getMethod("getOAID", new Class[]{Context.class});
            this.f1824c = this.f1820a.getMethod("getVAID", new Class[]{Context.class});
            this.f1825d = this.f1820a.getMethod("getAAID", new Class[]{Context.class});
        } catch (Exception e) {
            C1524b.m2154a("miui load class error", (Throwable) e);
        }
    }

    /* renamed from: a */
    public static boolean m2592a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    /* renamed from: a */
    public String mo17232a() {
        return null;
    }

    /* renamed from: a */
    public boolean m2594a() {
        return (this.f1820a == null || this.f1821a == null) ? false : true;
    }

    /* renamed from: b */
    public String mo17233b() {
        return m2590a(this.f1819a, this.f1823b);
    }

    /* renamed from: c */
    public String mo17234c() {
        return m2590a(this.f1819a, this.f1824c);
    }

    /* renamed from: d */
    public String mo17235d() {
        return m2590a(this.f1819a, this.f1825d);
    }
}
