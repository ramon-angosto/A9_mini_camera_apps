package com.huawei.android.pushagent.c.b;

import com.huawei.android.pushagent.c.a.e;

public class d implements a {
    private static d a;

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    private static Object b() {
        try {
            Class<?> cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            e.e("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + e.toString());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(int r8) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "getDeviceId exception:"
            java.lang.String r2 = "mutiCardMTKImpl"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]
            java.lang.Class r5 = java.lang.Integer.TYPE
            r6 = 0
            r4[r6] = r5
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r3[r6] = r8
            java.lang.Object r8 = b()     // Catch:{ NoSuchMethodException -> 0x0057, IllegalAccessException -> 0x0049, IllegalArgumentException -> 0x003b, InvocationTargetException -> 0x002d }
            if (r8 == 0) goto L_0x006e
            java.lang.Class r5 = r8.getClass()     // Catch:{ NoSuchMethodException -> 0x0057, IllegalAccessException -> 0x0049, IllegalArgumentException -> 0x003b, InvocationTargetException -> 0x002d }
            java.lang.String r6 = "getDeviceId"
            java.lang.reflect.Method r4 = r5.getMethod(r6, r4)     // Catch:{ NoSuchMethodException -> 0x0057, IllegalAccessException -> 0x0049, IllegalArgumentException -> 0x003b, InvocationTargetException -> 0x002d }
            java.lang.Object r8 = r4.invoke(r8, r3)     // Catch:{ NoSuchMethodException -> 0x0057, IllegalAccessException -> 0x0049, IllegalArgumentException -> 0x003b, InvocationTargetException -> 0x002d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NoSuchMethodException -> 0x0057, IllegalAccessException -> 0x0049, IllegalArgumentException -> 0x003b, InvocationTargetException -> 0x002d }
            goto L_0x006f
        L_0x002d:
            r8 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r8 = r8.toString()
            goto L_0x0064
        L_0x003b:
            r8 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r8 = r8.toString()
            goto L_0x0064
        L_0x0049:
            r8 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r8 = r8.toString()
            goto L_0x0064
        L_0x0057:
            r8 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r8 = r8.toString()
        L_0x0064:
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            com.huawei.android.pushagent.c.a.e.e(r2, r8)
        L_0x006e:
            r8 = r0
        L_0x006f:
            if (r8 != 0) goto L_0x0072
            r8 = r0
        L_0x0072:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.b.d.a(int):java.lang.String");
    }
}
