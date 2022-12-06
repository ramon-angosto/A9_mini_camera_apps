package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.Map;

public class FTOSPushHelper {

    /* renamed from: a */
    private static long f1617a = 0;

    /* renamed from: a */
    private static volatile boolean f1618a = false;

    /* renamed from: a */
    private static void m2227a(Context context) {
        AbstractPushManager a = C1583f.m2419a(context).mo17188a(C1582e.ASSEMBLE_PUSH_FTOS);
        if (a != null) {
            C1524b.m2141a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f1617a;
            if (j <= 0 || j + Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL <= elapsedRealtime) {
                f1617a = elapsedRealtime;
                m2227a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f1618a;
    }

    public static boolean hasNetwork(Context context) {
        return C1586i.m2430a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        if (map != null && map.containsKey("pushMsg")) {
            String str = map.get("pushMsg");
            if (!TextUtils.isEmpty(str) && (a = C1586i.m2430a(context)) != null) {
                MiPushMessage a2 = C1586i.m2429a(str);
                if (!a2.getExtra().containsKey("notify_effect")) {
                    a.onNotificationMessageClicked(context, a2);
                }
            }
        }
    }

    public static void setNeedRegister(boolean z) {
        f1618a = z;
    }

    public static void uploadToken(Context context, String str) {
        C1586i.m2436a(context, C1582e.ASSEMBLE_PUSH_FTOS, str);
    }
}
