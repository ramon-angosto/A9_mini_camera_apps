package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C2087u;

/* renamed from: com.xiaomi.push.service.e */
public class C2055e {

    /* renamed from: a */
    private static C2056a f3883a;

    /* renamed from: a */
    private static C2057b f3884a;

    /* renamed from: com.xiaomi.push.service.e$a */
    public interface C2056a {
        /* renamed from: a */
        boolean mo18520a(C1894in inVar);
    }

    /* renamed from: com.xiaomi.push.service.e$b */
    public interface C2057b {
    }

    /* renamed from: a */
    public static void m5213a(C2057b bVar) {
        f3884a = bVar;
    }

    /* renamed from: a */
    public static boolean m5214a(C1894in inVar) {
        String str;
        if (f3883a == null || inVar == null) {
            str = "rc params is null, not cpra";
        } else if (C1938m.m4714a(C2087u.m5371a())) {
            return f3883a.mo18520a(inVar);
        } else {
            str = "rc app not permission to cpra";
        }
        C1524b.m2141a(str);
        return false;
    }
}
