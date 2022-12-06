package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1915jg;
import com.xiaomi.push.C1926jq;

/* renamed from: com.xiaomi.push.iy */
public class C1905iy {
    /* renamed from: a */
    public static short m4541a(Context context, C1891ik ikVar) {
        int i = 0;
        int a = C1816g.m3663a(context, ikVar.f3195b, false).mo17676a() + 0 + (C1617aj.m2516b(context) ? 4 : 0);
        if (C1617aj.m2515a(context)) {
            i = 8;
        }
        return (short) (a + i);
    }

    /* renamed from: a */
    public static <T extends C1906iz<T, ?>> void m4542a(T t, byte[] bArr) {
        if (bArr != null) {
            new C1912jd(new C1926jq.C1927a(true, true, bArr.length)).mo18330a(t, bArr);
            return;
        }
        throw new C1913je("the message byte is empty.");
    }

    /* renamed from: a */
    public static <T extends C1906iz<T, ?>> byte[] m4543a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new C1914jf(new C1915jg.C1916a()).mo18331a(t);
        } catch (C1913je e) {
            C1524b.m2154a("convertThriftObjectToBytes catch TException.", (Throwable) e);
            return null;
        }
    }
}
