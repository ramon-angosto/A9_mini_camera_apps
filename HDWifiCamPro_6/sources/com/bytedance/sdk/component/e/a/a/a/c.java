package com.bytedance.sdk.component.e.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: DBMultiUtils */
public class c {
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r2, java.lang.String r3, android.content.ContentValues r4) {
        /*
            java.lang.Class<com.bytedance.sdk.component.e.a.a.a.c> r0 = com.bytedance.sdk.component.e.a.a.a.c.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0023
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0023
        L_0x000c:
            com.bytedance.sdk.component.e.a.a.a.a r2 = com.bytedance.sdk.component.e.a.a.a.a.a(r2)     // Catch:{ all -> 0x0019 }
            com.bytedance.sdk.component.e.a.a.a.b$b r2 = r2.a()     // Catch:{ all -> 0x0019 }
            r1 = 0
            r2.a((java.lang.String) r3, (java.lang.String) r1, (android.content.ContentValues) r4)     // Catch:{ all -> 0x0019 }
            goto L_0x001e
        L_0x0019:
            java.lang.String r2 = "insert ignore"
            com.bytedance.sdk.component.e.a.c.c.a(r2)     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)
            return
        L_0x0020:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x0023:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.c.a(android.content.Context, java.lang.String, android.content.ContentValues):void");
    }

    public static synchronized int a(Context context, String str, String str2, String[] strArr) {
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                com.bytedance.sdk.component.e.a.c.c.a("DBMultiUtils  delete start");
                int a = a.a(context).a().a(str, str2, strArr);
                return a;
            } catch (Throwable unused) {
                com.bytedance.sdk.component.e.a.c.c.a("delete ignore");
                return 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0026, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int a(android.content.Context r3, java.lang.String r4, android.content.ContentValues r5, java.lang.String r6, java.lang.String[] r7) {
        /*
            java.lang.Class<com.bytedance.sdk.component.e.a.a.a.c> r0 = com.bytedance.sdk.component.e.a.a.a.c.class
            monitor-enter(r0)
            r1 = 0
            if (r5 == 0) goto L_0x0025
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x000d
            goto L_0x0025
        L_0x000d:
            com.bytedance.sdk.component.e.a.a.a.a r3 = com.bytedance.sdk.component.e.a.a.a.a.a(r3)     // Catch:{ all -> 0x001b }
            com.bytedance.sdk.component.e.a.a.a.b$b r3 = r3.a()     // Catch:{ all -> 0x001b }
            int r3 = r3.a(r4, r5, r6, r7)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return r3
        L_0x001b:
            java.lang.String r3 = "update ignore"
            com.bytedance.sdk.component.e.a.c.c.a(r3)     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x0025:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.c.a(android.content.Context, java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public static synchronized Cursor a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Cursor a = a.a(context).a().a(str, strArr, str2, strArr2, (String) null, (String) null, str5);
                return a;
            } catch (Throwable unused) {
                com.bytedance.sdk.component.e.a.c.c.a("query ignore");
                return null;
            }
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (c.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    a.a(context).a().a(Uri.decode(str));
                } catch (Throwable unused) {
                    com.bytedance.sdk.component.e.a.c.c.a("execSQL ignore");
                }
            } else {
                return;
            }
        }
        return;
    }
}
