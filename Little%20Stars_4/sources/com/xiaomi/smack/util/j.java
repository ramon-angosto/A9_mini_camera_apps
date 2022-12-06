package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.service.XMPushService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class j {
    private static f a = new f(true);
    private static int b = -1;
    /* access modifiers changed from: private */
    public static final Object c = new Object();
    /* access modifiers changed from: private */
    public static List<a> d = Collections.synchronizedList(new ArrayList());
    private static String e = "";
    private static com.xiaomi.push.providers.a f = null;

    static class a {
        public String a = "";
        public long b = 0;
        public int c = -1;
        public int d = -1;
        public String e = "";
        public long f = 0;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.a = str;
            this.b = j;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.f = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.a, this.a) && TextUtils.equals(aVar.e, this.e) && aVar.c == this.c && aVar.d == this.d && Math.abs(aVar.b - this.b) <= 5000;
        }
    }

    private static int a(Context context) {
        if (b == -1) {
            b = b(context);
        }
        return b;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static long a(int i, long j) {
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    public static void a(XMPushService xMPushService, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (xMPushService != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
            String str2 = str;
            if (!"com.xiaomi.xmsf".equals(str) && -1 != (a2 = a((Context) xMPushService))) {
                synchronized (c) {
                    isEmpty = d.isEmpty();
                    String c2 = a2 == 0 ? c(xMPushService) : "";
                    a(new a(str, j2, a2, z ? 1 : 0, c2, a(a2, j)));
                }
                if (isEmpty) {
                    a.a((f.b) new k(xMPushService), 5000);
                }
            }
        }
    }

    private static void a(a aVar) {
        for (a next : d) {
            if (next.a(aVar)) {
                next.f += aVar.f;
                return;
            }
        }
        d.add(aVar);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(android.content.Context r2) {
        /*
            r0 = -1
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch:{ Exception -> 0x0018 }
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ Exception -> 0x0018 }
            if (r2 != 0) goto L_0x000c
            return r0
        L_0x000c:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch:{  }
            if (r2 != 0) goto L_0x0013
            return r0
        L_0x0013:
            int r2 = r2.getType()
            return r2
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.util.j.b(android.content.Context):int");
    }

    /* access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.a) {
                SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a next : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", next.a);
                        contentValues.put("message_ts", Long.valueOf(next.b));
                        contentValues.put("network_type", Integer.valueOf(next.c));
                        contentValues.put("bytes", Long.valueOf(next.f));
                        contentValues.put("rcv", Integer.valueOf(next.d));
                        contentValues.put("imsi", next.e);
                        writableDatabase.insert("traffic", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e2) {
            b.a((Throwable) e2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|(1:12)|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String c(android.content.Context r2) {
        /*
            java.lang.Class<com.xiaomi.smack.util.j> r0 = com.xiaomi.smack.util.j.class
            monitor-enter(r0)
            java.lang.String r1 = e     // Catch:{ all -> 0x0023 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x000f
            java.lang.String r2 = e     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return r2
        L_0x000f:
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch:{ Exception -> 0x001f }
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x001f }
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = r2.getSubscriberId()     // Catch:{ Exception -> 0x001f }
            e = r2     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            java.lang.String r2 = e     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return r2
        L_0x0023:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.util.j.c(android.content.Context):java.lang.String");
    }

    private static com.xiaomi.push.providers.a d(Context context) {
        com.xiaomi.push.providers.a aVar = f;
        if (aVar != null) {
            return aVar;
        }
        f = new com.xiaomi.push.providers.a(context);
        return f;
    }
}
