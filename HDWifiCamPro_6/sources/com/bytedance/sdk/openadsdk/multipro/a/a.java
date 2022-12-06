package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DBMultiAdapter */
public class a {
    public static g a;
    private static final ConcurrentHashMap<String, Object> b = new ConcurrentHashMap<>();

    public static g a(Context context) {
        if (context == null) {
            try {
                context = m.a();
            } catch (Throwable unused) {
                y.h("binder error");
            }
        }
        if (a == null) {
            if (b.c()) {
                a = f.a(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(context).a(5));
            } else {
                a = f.b();
            }
        }
        return a;
    }

    private static String a() {
        return d.b + "/" + "t_db" + "/" + "ttopensdk.db" + "/";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(1:15)|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3, java.lang.String r4, android.content.ContentValues r5) {
        /*
            if (r5 == 0) goto L_0x0047
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0009
            goto L_0x0047
        L_0x0009:
            java.lang.Object r0 = a((java.lang.String) r4)
            monitor-enter(r0)
            boolean r1 = com.bytedance.sdk.openadsdk.multipro.b.c()     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0022
            com.bytedance.sdk.openadsdk.core.e r3 = com.bytedance.sdk.openadsdk.core.e.a(r3)     // Catch:{ all -> 0x0042 }
            com.bytedance.sdk.openadsdk.core.f$c r3 = r3.a()     // Catch:{ all -> 0x0042 }
            r1 = 0
            r3.a((java.lang.String) r4, (java.lang.String) r1, (android.content.ContentValues) r5)     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x0022:
            com.bytedance.sdk.component.e.a.g r3 = a((android.content.Context) r3)     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0042
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r1.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = a()     // Catch:{ all -> 0x0042 }
            r1.append(r2)     // Catch:{ all -> 0x0042 }
            r1.append(r4)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0042 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x0042 }
            r3.a(r4, r5)     // Catch:{ all -> 0x0042 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r3
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.a.a(android.content.Context, java.lang.String, android.content.ContentValues):void");
    }

    public static int a(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (a(str)) {
            try {
                if (!b.c()) {
                    int a2 = e.a(context).a().a(str, str2, strArr);
                    return a2;
                }
                g a3 = a(context);
                if (a3 != null) {
                    int a4 = a3.a(Uri.parse(a() + str), str2, strArr);
                    return a4;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (a(str)) {
            try {
                if (!b.c()) {
                    int a2 = e.a(context).a().a(str, contentValues, str2, strArr);
                    return a2;
                }
                g a3 = a(context);
                if (a3 != null) {
                    int a4 = a3.a(Uri.parse(a() + str), contentValues, str2, strArr);
                    return a4;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Map<String, List<String>> a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (a(str)) {
            try {
                if (!b.c()) {
                    Map<String, List<String>> a2 = a(e.a(context).a().a(str, strArr, str2, strArr2, str3, str4, str5));
                    return a2;
                }
                g a3 = a(context);
                if (a3 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a());
                    String str6 = str;
                    sb.append(str);
                    Map<String, List<String>> a4 = a3.a(Uri.parse(sb.toString()), strArr, str2, strArr2, str5);
                    return a4;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Map<String, List<String>> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (cursor != null) {
            String[] columnNames = cursor.getColumnNames();
            while (cursor.getCount() > 0 && cursor.moveToNext()) {
                for (String str : columnNames) {
                    if (!hashMap.containsKey(str)) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(cursor.getString(cursor.getColumnIndex(str)));
                }
            }
            cursor.close();
        }
        return hashMap;
    }

    private static Object a(String str) {
        Object obj = b.get(str);
        if (obj == null) {
            synchronized (a.class) {
                obj = b.get(str);
                if (obj == null) {
                    obj = new Object();
                    b.put(str, obj);
                }
            }
        }
        return obj;
    }
}
