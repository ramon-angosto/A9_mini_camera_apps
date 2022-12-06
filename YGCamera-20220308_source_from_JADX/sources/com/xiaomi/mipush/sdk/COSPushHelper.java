package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C1524b;

public class COSPushHelper {

    /* renamed from: a */
    private static long f1615a = 0;

    /* renamed from: a */
    private static volatile boolean f1616a = false;

    public static void convertMessage(Intent intent) {
        C1586i.m2437a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f1615a;
            if (j <= 0 || j + Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL <= elapsedRealtime) {
                f1615a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f1616a;
    }

    public static boolean hasNetwork(Context context) {
        return C1586i.m2430a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a = C1583f.m2419a(context).mo17188a(C1582e.ASSEMBLE_PUSH_COS);
        if (a != null) {
            C1524b.m2141a("ASSEMBLE_PUSH :  register cos when network change!");
            a.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f1616a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        C1586i.m2436a(context, C1582e.ASSEMBLE_PUSH_COS, str);
    }
}
