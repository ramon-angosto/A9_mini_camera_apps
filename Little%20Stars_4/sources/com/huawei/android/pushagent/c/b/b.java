package com.huawei.android.pushagent.c.b;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.b.a;
import java.lang.reflect.Field;

public class b {
    private static a.C0036a a = a.C0036a.MODE_SUPPORT_UNKNOWN;
    private static a b;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            b();
            b = a == a.C0036a.MODE_SUPPORT_MTK_GEMINI ? d.a() : c.a();
            aVar = b;
        }
        return aVar;
    }

    private static synchronized void a(a.C0036a aVar) {
        synchronized (b.class) {
            a = aVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (a != com.huawei.android.pushagent.c.b.a.C0036a.MODE_SUPPORT_MTK_GEMINI) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean b() {
        /*
            java.lang.Class<com.huawei.android.pushagent.c.b.b> r0 = com.huawei.android.pushagent.c.b.b.class
            monitor-enter(r0)
            r1 = 0
            com.huawei.android.pushagent.c.b.a$a r2 = a     // Catch:{ all -> 0x006b }
            com.huawei.android.pushagent.c.b.a$a r3 = com.huawei.android.pushagent.c.b.a.C0036a.MODE_SUPPORT_UNKNOWN     // Catch:{ all -> 0x006b }
            r4 = 1
            if (r2 == r3) goto L_0x0019
            com.huawei.android.pushagent.c.b.a$a r2 = a     // Catch:{ all -> 0x006b }
            com.huawei.android.pushagent.c.b.a$a r3 = com.huawei.android.pushagent.c.b.a.C0036a.MODE_SUPPORT_HW_GEMINI     // Catch:{ all -> 0x006b }
            if (r2 == r3) goto L_0x0017
            com.huawei.android.pushagent.c.b.a$a r2 = a     // Catch:{ all -> 0x006b }
            com.huawei.android.pushagent.c.b.a$a r3 = com.huawei.android.pushagent.c.b.a.C0036a.MODE_SUPPORT_MTK_GEMINI     // Catch:{ all -> 0x006b }
            if (r2 != r3) goto L_0x0069
        L_0x0017:
            r1 = 1
            goto L_0x0069
        L_0x0019:
            boolean r2 = d()     // Catch:{ Exception -> 0x0050, Error -> 0x0034 }
            if (r2 == 0) goto L_0x0025
            com.huawei.android.pushagent.c.b.a$a r2 = com.huawei.android.pushagent.c.b.a.C0036a.MODE_SUPPORT_MTK_GEMINI     // Catch:{ Exception -> 0x0050, Error -> 0x0034 }
        L_0x0021:
            a(r2)     // Catch:{ Exception -> 0x0050, Error -> 0x0034 }
            goto L_0x0017
        L_0x0025:
            boolean r2 = c()     // Catch:{ Exception -> 0x0050, Error -> 0x0034 }
            if (r2 == 0) goto L_0x002e
            com.huawei.android.pushagent.c.b.a$a r2 = com.huawei.android.pushagent.c.b.a.C0036a.MODE_SUPPORT_HW_GEMINI     // Catch:{ Exception -> 0x0050, Error -> 0x0034 }
            goto L_0x0021
        L_0x002e:
            com.huawei.android.pushagent.c.b.a$a r2 = com.huawei.android.pushagent.c.b.a.C0036a.MODE_NOT_SUPPORT_GEMINI     // Catch:{ Exception -> 0x0050, Error -> 0x0034 }
            a(r2)     // Catch:{ Exception -> 0x0050, Error -> 0x0034 }
            goto L_0x0069
        L_0x0034:
            r2 = move-exception
            java.lang.String r3 = "mutiCardFactory"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r4.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ all -> 0x006b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x006b }
            r4.append(r2)     // Catch:{ all -> 0x006b }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x006b }
        L_0x004c:
            com.huawei.android.pushagent.c.a.e.d(r3, r2)     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x0050:
            r2 = move-exception
            java.lang.String r3 = "mutiCardFactory"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r4.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r5 = " "
            r4.append(r5)     // Catch:{ all -> 0x006b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x006b }
            r4.append(r2)     // Catch:{ all -> 0x006b }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x006b }
            goto L_0x004c
        L_0x0069:
            monitor-exit(r0)
            return r1
        L_0x006b:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x006f
        L_0x006e:
            throw r1
        L_0x006f:
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.b.b.b():boolean");
    }

    public static boolean c() {
        StringBuilder sb;
        String str;
        boolean z = false;
        try {
            Object b2 = c.b();
            if (b2 != null) {
                z = ((Boolean) b2.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(b2, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            sb = new StringBuilder();
            sb.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()?");
            str = e.toString();
            sb.append(str);
            e.d("mutiCardFactory", sb.toString());
            e.b("mutiCardFactory", "isHwGeminiSupport1 " + z);
            return z;
        } catch (Error e2) {
            sb = new StringBuilder();
            sb.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()");
            str = e2.toString();
            sb.append(str);
            e.d("mutiCardFactory", sb.toString());
            e.b("mutiCardFactory", "isHwGeminiSupport1 " + z);
            return z;
        }
        e.b("mutiCardFactory", "isHwGeminiSupport1 " + z);
        return z;
    }

    private static boolean d() {
        boolean z;
        StringBuilder sb;
        String str;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean((Object) null);
        } catch (Exception e) {
            sb = new StringBuilder();
            sb.append("FeatureOption.MTK_GEMINI_SUPPORT");
            str = e.toString();
            sb.append(str);
            e.d("mutiCardFactory", sb.toString());
            z = false;
            e.b("mutiCardFactory", "isMtkGeminiSupport " + z);
            return z;
        } catch (Error e2) {
            sb = new StringBuilder();
            sb.append("FeatureOption.MTK_GEMINI_SUPPORT");
            str = e2.toString();
            sb.append(str);
            e.d("mutiCardFactory", sb.toString());
            z = false;
            e.b("mutiCardFactory", "isMtkGeminiSupport " + z);
            return z;
        }
        e.b("mutiCardFactory", "isMtkGeminiSupport " + z);
        return z;
    }
}
