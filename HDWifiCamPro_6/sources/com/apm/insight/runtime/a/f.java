package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.b;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.a;
import com.apm.insight.h;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class f {
    private static volatile f a;
    private Context b;
    private Map<CrashType, c> c = new HashMap();
    private b d;
    private d e;

    private f(Context context) {
        this.b = context;
        try {
            this.d = b.d();
            this.e = new d(this.b);
        } catch (Throwable th) {
            b.a().a("NPTH_CATCH", th);
        }
    }

    private c a(CrashType crashType) {
        c cVar = this.c.get(crashType);
        if (cVar != null) {
            return cVar;
        }
        switch (crashType) {
            case JAVA:
                cVar = new j(this.b, this.d, this.e);
                break;
            case LAUNCH:
                cVar = new k(this.b, this.d, this.e);
                break;
            case NATIVE:
                cVar = new l(this.b, this.d, this.e);
                break;
            case ANR:
                cVar = new a(this.b, this.d, this.e);
                break;
            case DART:
                cVar = new h(this.b, this.d, this.e);
                break;
            case CUSTOM_JAVA:
                cVar = new g(this.b, this.d, this.e);
                break;
            case BLOCK:
                cVar = new e(this.b, this.d, this.e);
                break;
            case ENSURE:
                cVar = new i(this.b, this.d, this.e);
                break;
        }
        if (cVar != null) {
            this.c.put(crashType, cVar);
        }
        return cVar;
    }

    public static f a() {
        if (a == null) {
            Context g = h.g();
            if (g != null) {
                a = new f(g);
            } else {
                throw new IllegalArgumentException("NpthBus not init");
            }
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r3 = a(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.apm.insight.entity.a a(com.apm.insight.CrashType r3, com.apm.insight.entity.a r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return r4
        L_0x0003:
            com.apm.insight.runtime.a.c r3 = r2.a(r3)
            if (r3 == 0) goto L_0x0010
            r0 = 0
            r1 = 0
            com.apm.insight.entity.a r3 = r3.a(r4, r0, r1)
            return r3
        L_0x0010:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.a.f.a(com.apm.insight.CrashType, com.apm.insight.entity.a):com.apm.insight.entity.a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = a(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.apm.insight.entity.a a(com.apm.insight.CrashType r1, com.apm.insight.entity.a r2, com.apm.insight.runtime.a.c.a r3, boolean r4) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            return r2
        L_0x0003:
            com.apm.insight.runtime.a.c r1 = r0.a(r1)
            if (r1 == 0) goto L_0x000e
            com.apm.insight.entity.a r1 = r1.a(r2, r3, r4)
            return r1
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.a.f.a(com.apm.insight.CrashType, com.apm.insight.entity.a, com.apm.insight.runtime.a.c$a, boolean):com.apm.insight.entity.a");
    }

    public a a(List<a> list, JSONArray jSONArray) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        a aVar = new a();
        JSONArray jSONArray2 = new JSONArray();
        for (a h : list) {
            jSONArray2.put(h.h());
        }
        aVar.a(DataSchemeDataSource.SCHEME_DATA, (Object) jSONArray2);
        aVar.a("all_data", (Object) jSONArray);
        Header a2 = Header.a(this.b);
        Header.a(a2);
        a2.c();
        a2.d();
        a2.e();
        Header.b(a2);
        aVar.a(a2);
        return aVar;
    }
}
