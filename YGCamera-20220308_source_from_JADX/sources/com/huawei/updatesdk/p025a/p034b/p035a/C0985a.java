package com.huawei.updatesdk.p025a.p034b.p035a;

import android.content.Context;

/* renamed from: com.huawei.updatesdk.a.b.a.a */
public class C0985a {

    /* renamed from: b */
    private static final Object f1326b = new Object();

    /* renamed from: c */
    private static C0985a f1327c;

    /* renamed from: a */
    private Context f1328a;

    public C0985a(Context context) {
        this.f1328a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static void m1756a(Context context) {
        synchronized (f1326b) {
            if (f1327c == null) {
                f1327c = new C0985a(context);
            }
        }
    }

    /* renamed from: c */
    public static C0985a m1757c() {
        C0985a aVar;
        synchronized (f1326b) {
            aVar = f1327c;
        }
        return aVar;
    }

    /* renamed from: a */
    public Context mo14892a() {
        return this.f1328a;
    }

    /* renamed from: b */
    public String mo14893b() {
        Context context = this.f1328a;
        return (context == null || context.getFilesDir() == null) ? "" : this.f1328a.getFilesDir().getAbsolutePath();
    }
}
