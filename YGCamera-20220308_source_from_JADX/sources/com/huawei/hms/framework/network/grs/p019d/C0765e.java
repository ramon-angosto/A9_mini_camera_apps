package com.huawei.hms.framework.network.grs.p019d;

import com.huawei.hms.framework.common.Logger;

/* renamed from: com.huawei.hms.framework.network.grs.d.e */
public class C0765e {

    /* renamed from: a */
    private static final String f584a = "e";

    /* renamed from: a */
    public static boolean m677a(Long l) {
        if (l == null) {
            Logger.m476v(f584a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - System.currentTimeMillis() >= 0) {
                Logger.m476v(f584a, "isSpExpire false.");
                return false;
            }
            Logger.m476v(f584a, "isSpExpire true.");
            return true;
        } catch (NumberFormatException unused) {
            Logger.m476v(f584a, "isSpExpire spValue NumberFormatException.");
        }
    }

    /* renamed from: a */
    public static boolean m678a(Long l, long j) {
        if (l == null) {
            Logger.m476v(f584a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - (System.currentTimeMillis() + j) >= 0) {
                Logger.m476v(f584a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.m476v(f584a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
