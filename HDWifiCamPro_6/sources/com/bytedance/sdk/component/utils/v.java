package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTNetworkUtils */
public class v {
    private static final Object a = new Object();
    private static final Map<a, Object> b = new ConcurrentHashMap();
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static volatile int d = -1;
    private static volatile long e = 0;
    private static volatile int f = 60000;
    private static p g = null;
    /* access modifiers changed from: private */
    public static final AtomicBoolean h = new AtomicBoolean(false);

    /* compiled from: TTNetworkUtils */
    public interface a {
        void a(Context context, Intent intent, boolean z);
    }

    public static int a(Context context, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (e + j <= elapsedRealtime) {
            return a(context);
        }
        if (d == -1) {
            return a(context);
        }
        if (elapsedRealtime - e >= ((long) f)) {
            c(context);
        }
        return d;
    }

    private static void c(final Context context) {
        if (h.compareAndSet(false, true)) {
            e.a((g) new g("getNetworkType") {
                public void run() {
                    v.a(context);
                    v.h.set(false);
                }
            });
        }
    }

    public static int a(Context context) {
        d = b(context);
        e = SystemClock.elapsedRealtime();
        return d;
    }

    public static int b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (!activeNetworkInfo.isAvailable()) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
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
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        if (g == null || !g.a(context, telephonyManager)) {
                            return 5;
                        }
                        return 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (TextUtils.isEmpty(subtypeName) || (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000"))) {
                            return 1;
                        }
                        return 3;
                }
            } else if (type != 1) {
                return 1;
            } else {
                return 4;
            }
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void a(a aVar, Context context) {
        if (aVar != null) {
            if (!c.get()) {
                try {
                    context.registerReceiver(new b(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    c.set(true);
                } catch (Throwable unused) {
                }
            }
            b.put(aVar, a);
        }
    }

    public static void a(a aVar) {
        if (aVar != null) {
            b.remove(aVar);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, Intent intent) {
        c(context);
        boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
        if (booleanExtra) {
            d = 0;
        }
        Map<a, Object> map = b;
        if (map != null && map.size() > 0) {
            for (a next : b.keySet()) {
                if (next != null) {
                    next.a(context, intent, !booleanExtra);
                }
            }
        }
    }

    /* compiled from: TTNetworkUtils */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        public void onReceive(Context context, Intent intent) {
            v.b(context, intent);
        }
    }
}
