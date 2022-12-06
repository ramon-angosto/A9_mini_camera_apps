package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.xiaomi.push.au */
class C1634au implements C1633at, InvocationHandler {

    /* renamed from: a */
    private static final String[][] f1797a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a */
    private volatile int f1798a = 0;

    /* renamed from: a */
    private volatile long f1799a = 0;

    /* renamed from: a */
    private Context f1800a;

    /* renamed from: a */
    private volatile C1635a f1801a = null;

    /* renamed from: a */
    private Class f1802a = null;

    /* renamed from: a */
    private final Object f1803a = new Object();

    /* renamed from: a */
    private Method f1804a = null;

    /* renamed from: b */
    private Class f1805b = null;

    /* renamed from: b */
    private Method f1806b = null;

    /* renamed from: c */
    private Method f1807c = null;

    /* renamed from: d */
    private Method f1808d = null;

    /* renamed from: e */
    private Method f1809e = null;

    /* renamed from: f */
    private Method f1810f = null;

    /* renamed from: g */
    private Method f1811g = null;

    /* renamed from: com.xiaomi.push.au$a */
    private class C1635a {

        /* renamed from: a */
        Boolean f1813a;

        /* renamed from: a */
        String f1814a;

        /* renamed from: b */
        String f1815b;

        /* renamed from: c */
        String f1816c;

        /* renamed from: d */
        String f1817d;

        private C1635a() {
            this.f1813a = null;
            this.f1814a = null;
            this.f1815b = null;
            this.f1816c = null;
            this.f1817d = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo17239a() {
            if (!TextUtils.isEmpty(this.f1814a) || !TextUtils.isEmpty(this.f1815b) || !TextUtils.isEmpty(this.f1816c) || !TextUtils.isEmpty(this.f1817d)) {
                this.f1813a = true;
            }
            return this.f1813a != null;
        }
    }

    public C1634au(Context context) {
        this.f1800a = context.getApplicationContext();
        m2577a(context);
        m2580b(context);
    }

    /* renamed from: a */
    private static Class<?> m2573a(Context context, String str) {
        try {
            return C2087u.m5373a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static <T> T m2574a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static Method m2575a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mo17232a() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f1803a
            monitor-enter(r0)
            java.lang.Object r1 = r2.f1803a     // Catch:{ Exception -> 0x000b }
            r1.notifyAll()     // Catch:{ Exception -> 0x000b }
            goto L_0x000b
        L_0x0009:
            r1 = move-exception
            goto L_0x000d
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1634au.mo17232a():void");
    }

    /* renamed from: a */
    private void m2577a(Context context) {
        Class<?> a = m2573a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = f1797a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> a2 = m2573a(context, strArr2[0]);
            Class<?> a3 = m2573a(context, strArr2[1]);
            if (a2 != null && a3 != null) {
                m2581b("found class in index " + i);
                Class<?> cls3 = a2;
                cls2 = a3;
                cls = cls3;
                break;
            }
            i++;
            Class<?> cls4 = a2;
            cls2 = a3;
            cls = cls4;
        }
        this.f1802a = a;
        this.f1804a = m2575a(a, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f1805b = cls;
        this.f1806b = m2575a(cls2, "getUDID", (Class<?>[]) new Class[0]);
        this.f1807c = m2575a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f1808d = m2575a(cls2, "getVAID", (Class<?>[]) new Class[0]);
        this.f1809e = m2575a(cls2, "getAAID", (Class<?>[]) new Class[0]);
        this.f1810f = m2575a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.f1811g = m2575a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|31|(2:33|34)|35|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008f */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2578a(java.lang.String r12) {
        /*
            r11 = this;
            com.xiaomi.push.au$a r0 = r11.f1801a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            long r0 = r11.f1799a
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = java.lang.Math.abs(r0)
            long r2 = r2 - r4
            int r4 = r11.f1798a
            r5 = 3000(0xbb8, double:1.482E-320)
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0057
            r7 = 3
            if (r4 >= r7) goto L_0x0057
            java.lang.Object r7 = r11.f1803a
            monitor-enter(r7)
            long r8 = r11.f1799a     // Catch:{ all -> 0x0054 }
            int r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x0052
            int r8 = r11.f1798a     // Catch:{ all -> 0x0054 }
            if (r8 != r4) goto L_0x0052
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r0.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = "retry, current count is "
            r0.append(r1)     // Catch:{ all -> 0x0054 }
            r0.append(r4)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0054 }
            m2581b((java.lang.String) r0)     // Catch:{ all -> 0x0054 }
            int r0 = r11.f1798a     // Catch:{ all -> 0x0054 }
            int r0 = r0 + 1
            r11.f1798a = r0     // Catch:{ all -> 0x0054 }
            android.content.Context r0 = r11.f1800a     // Catch:{ all -> 0x0054 }
            r11.m2580b((android.content.Context) r0)     // Catch:{ all -> 0x0054 }
            long r0 = r11.f1799a     // Catch:{ all -> 0x0054 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0054 }
            long r8 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0054 }
            long r2 = r2 - r8
        L_0x0052:
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            r12 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            throw r12
        L_0x0057:
            com.xiaomi.push.au$a r4 = r11.f1801a
            if (r4 != 0) goto L_0x0094
            r7 = 0
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 < 0) goto L_0x0094
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0094
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0094
            java.lang.Object r0 = r11.f1803a
            monitor-enter(r0)
            com.xiaomi.push.au$a r1 = r11.f1801a     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x008f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            r1.<init>()     // Catch:{ Exception -> 0x008f }
            r1.append(r12)     // Catch:{ Exception -> 0x008f }
            java.lang.String r12 = " wait..."
            r1.append(r12)     // Catch:{ Exception -> 0x008f }
            java.lang.String r12 = r1.toString()     // Catch:{ Exception -> 0x008f }
            m2581b((java.lang.String) r12)     // Catch:{ Exception -> 0x008f }
            java.lang.Object r12 = r11.f1803a     // Catch:{ Exception -> 0x008f }
            r12.wait(r5)     // Catch:{ Exception -> 0x008f }
        L_0x008f:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            goto L_0x0094
        L_0x0091:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r12
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1634au.m2578a(java.lang.String):void");
    }

    /* renamed from: a */
    private static boolean m2579a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    /* renamed from: b */
    private void m2580b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.f1805b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                Object newProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{this.f1805b}, this);
                m2574a(this.f1804a, this.f1802a.newInstance(), context, newProxyInstance);
            } catch (Throwable th) {
                m2581b("call init sdk error:" + th);
            }
            this.f1799a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f1799a = elapsedRealtime;
    }

    /* renamed from: b */
    private static void m2581b(String str) {
        C1524b.m2141a("mdid:" + str);
    }

    /* renamed from: a */
    public String m2582a() {
        m2578a("getUDID");
        if (this.f1801a == null) {
            return null;
        }
        return this.f1801a.f1814a;
    }

    /* renamed from: a */
    public boolean m2583a() {
        m2578a("isSupported");
        return this.f1801a != null && Boolean.TRUE.equals(this.f1801a.f1813a);
    }

    /* renamed from: b */
    public String mo17233b() {
        m2578a("getOAID");
        if (this.f1801a == null) {
            return null;
        }
        return this.f1801a.f1815b;
    }

    /* renamed from: c */
    public String mo17234c() {
        m2578a("getVAID");
        if (this.f1801a == null) {
            return null;
        }
        return this.f1801a.f1816c;
    }

    /* renamed from: d */
    public String mo17235d() {
        m2578a("getAAID");
        if (this.f1801a == null) {
            return null;
        }
        return this.f1801a.f1817d;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f1799a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            C1635a aVar = new C1635a();
            int length = objArr.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !m2579a(obj2)) {
                    aVar.f1814a = (String) m2574a(this.f1806b, obj2, new Object[0]);
                    aVar.f1815b = (String) m2574a(this.f1807c, obj2, new Object[0]);
                    aVar.f1816c = (String) m2574a(this.f1808d, obj2, new Object[0]);
                    aVar.f1817d = (String) m2574a(this.f1809e, obj2, new Object[0]);
                    aVar.f1813a = (Boolean) m2574a(this.f1810f, obj2, new Object[0]);
                    m2574a(this.f1811g, obj2, new Object[0]);
                    if (aVar.mo17239a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        if (this.f1801a != null) {
                            z = true;
                        }
                        sb.append(z);
                        m2581b(sb.toString());
                        synchronized (C1634au.class) {
                            if (this.f1801a == null) {
                                this.f1801a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        mo17232a();
        return null;
    }
}
