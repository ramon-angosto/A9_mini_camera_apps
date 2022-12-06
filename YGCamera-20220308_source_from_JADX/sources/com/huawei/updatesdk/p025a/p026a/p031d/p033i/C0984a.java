package com.huawei.updatesdk.p025a.p026a.p031d.p033i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.huawei.updatesdk.a.a.d.i.a */
public class C0984a {

    /* renamed from: a */
    private static ConnectivityManager f1325a;

    /* renamed from: a */
    public static int m1751a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (1 == type || 13 == type) {
                return 1;
            }
            if (type == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static NetworkInfo m1752a(Context context) {
        ConnectivityManager b = m1753b(context);
        if (b != null) {
            return b.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: b */
    private static ConnectivityManager m1753b(Context context) {
        if (f1325a == null) {
            f1325a = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return f1325a;
    }

    /* renamed from: c */
    public static int m1754c(Context context) {
        return m1751a(m1752a(context));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = (r0 = m1753b(r0)).getActiveNetworkInfo();
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1755d(android.content.Context r0) {
        /*
            if (r0 == 0) goto L_0x0016
            android.net.ConnectivityManager r0 = m1753b(r0)
            if (r0 == 0) goto L_0x0016
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0016
            r0 = 1
            return r0
        L_0x0016:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p025a.p026a.p031d.p033i.C0984a.m1755d(android.content.Context):boolean");
    }
}
