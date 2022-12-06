package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1623an;
import com.xiaomi.push.providers.C1942a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.push.gz */
public class C1847gz {

    /* renamed from: a */
    private static volatile int f2596a = -1;

    /* renamed from: a */
    private static long f2597a = System.currentTimeMillis();

    /* renamed from: a */
    private static C1623an f2598a = new C1623an(true);

    /* renamed from: a */
    private static C1942a f2599a = null;

    /* renamed from: a */
    private static final Object f2600a = new Object();

    /* renamed from: a */
    private static String f2601a = "";

    /* renamed from: a */
    private static List<C1848a> f2602a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.xiaomi.push.gz$a */
    static class C1848a {

        /* renamed from: a */
        public int f2603a = -1;

        /* renamed from: a */
        public long f2604a = 0;

        /* renamed from: a */
        public String f2605a = "";

        /* renamed from: b */
        public int f2606b = -1;

        /* renamed from: b */
        public long f2607b = 0;

        /* renamed from: b */
        public String f2608b = "";

        public C1848a(String str, long j, int i, int i2, String str2, long j2) {
            this.f2605a = str;
            this.f2604a = j;
            this.f2603a = i;
            this.f2606b = i2;
            this.f2608b = str2;
            this.f2607b = j2;
        }

        /* renamed from: a */
        public boolean mo17748a(C1848a aVar) {
            return TextUtils.equals(aVar.f2605a, this.f2605a) && TextUtils.equals(aVar.f2608b, this.f2608b) && aVar.f2603a == this.f2603a && aVar.f2606b == this.f2606b && Math.abs(aVar.f2604a - this.f2604a) <= 5000;
        }
    }

    /* renamed from: a */
    public static int m3809a(Context context) {
        if (f2596a == -1) {
            f2596a = m3822b(context);
        }
        return f2596a;
    }

    /* renamed from: a */
    public static int m3810a(String str) {
        try {
            return str.getBytes(Key.STRING_CHARSET_NAME).length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    /* renamed from: a */
    private static long m3811a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f2597a;
            f2597a = j2;
            if (j2 - j3 > 30000 && j > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                return j * 2;
            }
        }
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    /* renamed from: a */
    private static C1942a m3812a(Context context) {
        C1942a aVar = f2599a;
        if (aVar != null) {
            return aVar;
        }
        f2599a = new C1942a(context);
        return f2599a;
    }

    /* renamed from: a */
    private static synchronized String m3814a(Context context) {
        synchronized (C1847gz.class) {
            if (TextUtils.isEmpty(f2601a)) {
                return "";
            }
            String str = f2601a;
            return str;
        }
    }

    /* renamed from: a */
    public static void m3816a(Context context) {
        f2596a = m3822b(context);
    }

    /* renamed from: a */
    private static void m3817a(Context context, String str, long j, boolean z, long j2) {
        int a;
        boolean isEmpty;
        if (context != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            String str2 = str;
            if (!"com.xiaomi.xmsf".equals(str) && -1 != (a = m3809a(context))) {
                synchronized (f2600a) {
                    isEmpty = f2602a.isEmpty();
                    m3820a(new C1848a(str, j2, a, z ? 1 : 0, a == 0 ? m3809a(context) : "", j));
                }
                if (isEmpty) {
                    f2598a.mo17224a((C1623an.C1625b) new C1850ha(context), 5000);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m3818a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        m3817a(context, str, m3811a(m3809a(context), j, z, j2, z2), z, j2);
    }

    /* renamed from: a */
    private static void m3820a(C1848a aVar) {
        for (C1848a next : f2602a) {
            if (next.mo17748a(aVar)) {
                next.f2607b += aVar.f2607b;
                return;
            }
        }
        f2602a.add(aVar);
    }

    /* renamed from: a */
    public static synchronized void m3821a(String str) {
        synchronized (C1847gz.class) {
            if (!C1938m.m4731d() && !TextUtils.isEmpty(str)) {
                f2601a = str;
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m3822b(android.content.Context r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1847gz.m3822b(android.content.Context):int");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m3823b(Context context, List<C1848a> list) {
        try {
            synchronized (C1942a.f3571a) {
                SQLiteDatabase writableDatabase = m3809a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (C1848a next : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.PACKAGE_NAME, next.f2605a);
                        contentValues.put("message_ts", Long.valueOf(next.f2604a));
                        contentValues.put("network_type", Integer.valueOf(next.f2603a));
                        contentValues.put("bytes", Long.valueOf(next.f2607b));
                        contentValues.put("rcv", Integer.valueOf(next.f2606b));
                        contentValues.put("imsi", next.f2608b);
                        writableDatabase.insert("traffic", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e) {
            C1524b.m2155a((Throwable) e);
        }
    }
}
