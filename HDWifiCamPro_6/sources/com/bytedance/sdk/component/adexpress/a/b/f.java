package com.bytedance.sdk.component.adexpress.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.a.c.a;
import com.bytedance.sdk.component.utils.e;
import java.io.File;

/* compiled from: Version */
public class f {
    private static a a;

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC, Splitter:B:27:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a() {
        /*
            java.lang.String r0 = "Version"
            r1 = 0
            java.io.File r2 = com.bytedance.sdk.component.adexpress.a.b.c.f()     // Catch:{ all -> 0x0077 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "temp_pkg_info.json"
            r3.<init>(r2, r4)     // Catch:{ all -> 0x0077 }
            long r4 = r3.length()     // Catch:{ all -> 0x0077 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0077 }
            long r4 = r2.longValue()     // Catch:{ all -> 0x0077 }
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x006c
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0077 }
            if (r4 == 0) goto L_0x006c
            boolean r4 = r3.isFile()     // Catch:{ all -> 0x0077 }
            if (r4 == 0) goto L_0x006c
            int r2 = r2.intValue()     // Catch:{ all -> 0x0077 }
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0077 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0077 }
            r4.<init>(r3)     // Catch:{ all -> 0x0077 }
            r4.read(r2)     // Catch:{ all -> 0x006a }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "utf-8"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x006a }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
            r2.<init>(r1)     // Catch:{ all -> 0x006a }
            com.bytedance.sdk.component.adexpress.a.c.a r1 = com.bytedance.sdk.component.adexpress.a.c.a.a((org.json.JSONObject) r2)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0068
            a = r1     // Catch:{ all -> 0x006a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r1.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r2 = "old version read success: "
            r1.append(r2)     // Catch:{ all -> 0x006a }
            com.bytedance.sdk.component.adexpress.a.c.a r2 = a     // Catch:{ all -> 0x006a }
            java.lang.String r2 = r2.b()     // Catch:{ all -> 0x006a }
            r1.append(r2)     // Catch:{ all -> 0x006a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006a }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x006a }
        L_0x0068:
            r1 = r4
            goto L_0x0071
        L_0x006a:
            r1 = move-exception
            goto L_0x007a
        L_0x006c:
            java.lang.String r2 = "version pkg json file does not exist"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0077 }
        L_0x0071:
            if (r1 == 0) goto L_0x0084
            r1.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0084
        L_0x0077:
            r2 = move-exception
            r4 = r1
            r1 = r2
        L_0x007a:
            java.lang.String r2 = "version init error"
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r0, (java.lang.String) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0085 }
            if (r4 == 0) goto L_0x0084
            r4.close()     // Catch:{ IOException -> 0x0084 }
        L_0x0084:
            return
        L_0x0085:
            r0 = move-exception
            if (r4 == 0) goto L_0x008b
            r4.close()     // Catch:{ IOException -> 0x008b }
        L_0x008b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.b.f.a():void");
    }

    public static synchronized a b() {
        a aVar;
        synchronized (f.class) {
            aVar = a;
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (f.class) {
            if (aVar != null) {
                if (aVar.f()) {
                    a = aVar;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c() {
        /*
            com.bytedance.sdk.component.adexpress.a.c.a r0 = a
            java.lang.String r1 = "Version"
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = "version save error1"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            return
        L_0x000c:
            java.lang.String r0 = r0.g()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x001c
            java.lang.String r0 = "version save error2"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            return
        L_0x001c:
            java.io.File r2 = com.bytedance.sdk.component.adexpress.a.b.c.f()
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "temp_pkg_info.json"
            r3.<init>(r2, r4)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r5 = ".tmp"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.<init>(r4)
            boolean r4 = r2.exists()
            if (r4 == 0) goto L_0x0046
            r2.delete()
        L_0x0046:
            r4 = 0
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0067 }
            r5.<init>(r2)     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = "utf-8"
            byte[] r0 = r0.getBytes(r4)     // Catch:{ all -> 0x0065 }
            r5.write(r0)     // Catch:{ all -> 0x0065 }
            boolean r0 = r3.exists()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x005e
            r3.delete()     // Catch:{ all -> 0x0065 }
        L_0x005e:
            r2.renameTo(r3)     // Catch:{ all -> 0x0065 }
        L_0x0061:
            r5.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0071
        L_0x0065:
            r0 = move-exception
            goto L_0x0069
        L_0x0067:
            r0 = move-exception
            r5 = r4
        L_0x0069:
            java.lang.String r2 = "version save error3"
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0072 }
            if (r5 == 0) goto L_0x0071
            goto L_0x0061
        L_0x0071:
            return
        L_0x0072:
            r0 = move-exception
            if (r5 == 0) goto L_0x0078
            r5.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.b.f.c():void");
    }

    public static a.C0025a a(String str) {
        if (!TextUtils.isEmpty(str) && b() != null && b().e() != null && b().f()) {
            for (a.C0025a next : b().e()) {
                if (next.a() != null && next.a().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean b(String str) {
        try {
            if (b() != null) {
                if (!TextUtils.isEmpty(b().b())) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    String b = b().b();
                    String[] split = str.split("\\.");
                    String[] split2 = b.split("\\.");
                    int min = Math.min(split.length, split2.length);
                    int i = 0;
                    while (i < min) {
                        int length = split[i].length() - split2[i].length();
                        if (length == 0) {
                            int compareTo = split[i].compareTo(split2[i]);
                            if (compareTo > 0) {
                                return true;
                            }
                            if (compareTo < 0) {
                                return false;
                            }
                            if (i != min - 1) {
                                i++;
                            } else if (split.length > split2.length) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (length > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        a b = b();
        if (b != null) {
            File f = c.f();
            try {
                new File(f, "temp_pkg_info.json").delete();
            } catch (Throwable unused) {
            }
            if (b.e() != null) {
                for (a.C0025a a2 : b.e()) {
                    try {
                        new File(f, e.a(a2.a())).delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
            a = null;
        }
    }
}
