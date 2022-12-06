package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1797fn;

/* renamed from: com.xiaomi.push.fk */
class C1794fk {

    /* renamed from: a */
    private static final boolean f2389a = Log.isLoggable("BCompressed", 3);

    /* renamed from: a */
    static byte[] m3557a(C1793fj fjVar, byte[] bArr) {
        try {
            byte[] a = C1797fn.C1798a.m3575a(bArr);
            if (f2389a) {
                C1524b.m2144a("BCompressed", "decompress " + bArr.length + " to " + a.length + " for " + fjVar);
                if (fjVar.f2384a == 1) {
                    C1524b.m2144a("BCompressed", "decompress not support upStream");
                }
            }
            return a;
        } catch (Exception e) {
            C1524b.m2144a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
