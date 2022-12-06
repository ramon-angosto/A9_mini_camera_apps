package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1891ik;

/* renamed from: com.xiaomi.push.service.aa */
public class C1967aa {

    /* renamed from: a */
    private static C1968a f3655a;

    /* renamed from: a */
    private static C1969b f3656a;

    /* renamed from: com.xiaomi.push.service.aa$a */
    public interface C1968a {
        /* renamed from: a */
        boolean mo18440a(C1891ik ikVar);
    }

    /* renamed from: com.xiaomi.push.service.aa$b */
    public interface C1969b {
        /* renamed from: a */
        void mo18441a(C1891ik ikVar);

        /* renamed from: a */
        void mo18442a(String str);

        /* renamed from: a */
        boolean m4876a(C1891ik ikVar);
    }

    /* renamed from: a */
    public static void m4869a(C1891ik ikVar) {
        C1969b bVar = f3656a;
        if (bVar == null || ikVar == null) {
            C1524b.m2141a("pepa clearMessage is null");
        } else {
            bVar.mo18441a(ikVar);
        }
    }

    /* renamed from: a */
    public static void m4870a(String str) {
        C1969b bVar = f3656a;
        if (bVar == null || str == null) {
            C1524b.m2141a("pepa clearMessage is null");
        } else {
            bVar.mo18442a(str);
        }
    }

    /* renamed from: a */
    public static boolean m4871a(C1891ik ikVar) {
        C1968a aVar = f3655a;
        if (aVar != null && ikVar != null) {
            return aVar.mo18440a(ikVar);
        }
        C1524b.m2141a("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: b */
    public static boolean m4872b(C1891ik ikVar) {
        C1969b bVar = f3656a;
        if (bVar != null && ikVar != null) {
            return bVar.mo18441a(ikVar);
        }
        C1524b.m2141a("pepa handleReceiveMessage is null");
        return false;
    }
}
