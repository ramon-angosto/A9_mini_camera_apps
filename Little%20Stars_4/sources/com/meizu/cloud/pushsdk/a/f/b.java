package com.meizu.cloud.pushsdk.a.f;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.meizu.cloud.pushsdk.a.c.a;
import com.meizu.cloud.pushsdk.a.d.c;
import com.meizu.cloud.pushsdk.a.d.e;
import com.meizu.cloud.pushsdk.a.d.i;
import com.meizu.cloud.pushsdk.a.d.j;
import com.meizu.cloud.pushsdk.a.d.k;
import java.io.File;
import java.io.IOException;

public final class b {
    public static String a;

    public static k a(com.meizu.cloud.pushsdk.a.a.b bVar) throws a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            int c = bVar.c();
            if (c == 0) {
                a2 = a2.a();
            } else if (c == 1) {
                a2 = a2.a(bVar.q());
            } else if (c == 2) {
                a2 = a2.c(bVar.q());
            } else if (c == 3) {
                a2 = a2.b(bVar.q());
            } else if (c == 4) {
                a2 = a2.b();
            } else if (c == 5) {
                a2 = a2.d(bVar.q());
            }
            bVar.a((com.meizu.cloud.pushsdk.a.d.a) new e(a2.c()));
            return bVar.n().a();
        } catch (IOException e) {
            throw new a((Throwable) e);
        }
    }

    public static k b(com.meizu.cloud.pushsdk.a.a.b bVar) throws a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            bVar.a((com.meizu.cloud.pushsdk.a.d.a) new e(a2.a().c()));
            k a3 = bVar.n().a();
            com.meizu.cloud.pushsdk.a.i.b.a(a3, bVar.l(), bVar.m());
            return a3;
        } catch (IOException e) {
            try {
                File file = new File(bVar.l() + File.separator + bVar.m());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new a((Throwable) e);
        }
    }

    public static k c(com.meizu.cloud.pushsdk.a.a.b bVar) throws a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            bVar.a((com.meizu.cloud.pushsdk.a.d.a) new e(a2.a((j) new d(bVar.r(), bVar.k())).c()));
            return bVar.n().a();
        } catch (IOException e) {
            throw new a((Throwable) e);
        }
    }

    public static void a(i.a aVar, com.meizu.cloud.pushsdk.a.a.b bVar) {
        if (bVar.i() != null) {
            aVar.a(HttpHeaders.USER_AGENT, bVar.i());
        } else {
            String str = a;
            if (str != null) {
                bVar.a(str);
                aVar.a(HttpHeaders.USER_AGENT, a);
            }
        }
        c s = bVar.s();
        if (s != null) {
            aVar.a(s);
            if (bVar.i() != null && !s.b().contains(HttpHeaders.USER_AGENT)) {
                aVar.a(HttpHeaders.USER_AGENT, bVar.i());
            }
        }
    }
}
