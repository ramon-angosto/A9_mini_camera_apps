package com.bytedance.mobsec.metasec.ov;

import android.content.Context;
import ms.bd.o.Pgl.l0;

public final class PglMSManagerUtils {
    private PglMSManagerUtils() {
    }

    public static synchronized PglMSManager get(String str) {
        PglMSManager pglMSManager;
        synchronized (PglMSManagerUtils.class) {
            l0.pgla a = l0.a(str);
            pglMSManager = a != null ? new PglMSManager(a) : null;
        }
        return pglMSManager;
    }

    public static synchronized boolean init(Context context, PglMSConfig pglMSConfig) {
        boolean a;
        synchronized (PglMSManagerUtils.class) {
            a = l0.a(context, pglMSConfig.a(), "Pglmetasec_ov", "ms_sensor_ov");
        }
        return a;
    }

    public static String versionInfo() {
        return l0.a();
    }
}
