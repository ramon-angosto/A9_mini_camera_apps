package sg.bigo.ads.core.e.a;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.c.c.c;

public final class f {

    static class a {
        public static f a = new f((byte) 0);
    }

    private f() {
    }

    /* synthetic */ f(byte b) {
        this();
    }

    public static List<e> a(long j, o oVar) {
        c.b(System.currentTimeMillis() - 86400000);
        Cursor a2 = c.a(j);
        ArrayList arrayList = new ArrayList();
        if (a2 == null) {
            return arrayList;
        }
        while (a2.moveToNext()) {
            e eVar = new e(oVar, a2);
            arrayList.add(eVar);
            sg.bigo.ads.common.k.a.a(0, 3, "TrackerManager", "getList:" + eVar.toString());
        }
        a2.close();
        return arrayList;
    }

    public static void a(e eVar) {
        if (c.c(eVar)) {
            c.b((sg.bigo.ads.common.c.b.c) eVar);
        } else {
            eVar.a = c.a((sg.bigo.ads.common.c.b.c) eVar);
        }
    }

    public static void b(e eVar) {
        if (eVar.g()) {
            c(eVar);
        } else {
            c.b((sg.bigo.ads.common.c.b.c) eVar);
        }
    }

    private static void c(e eVar) {
        c.a(String.valueOf(eVar.a));
    }
}
