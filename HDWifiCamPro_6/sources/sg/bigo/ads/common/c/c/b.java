package sg.bigo.ads.common.c.c;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.utils.r;

public final class b {
    public static long a(List<String> list) {
        a.a(0, 3, "StatsDbHelper", "delStatInfo:" + list.size());
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        int i = 0;
        while (i < list.size()) {
            sb.append(i == 0 ? "?" : ",?");
            i++;
        }
        sb.append(")");
        long b = (long) sg.bigo.ads.common.c.a.a.b("tb_stat", sb.toString(), (String[]) list.toArray(new String[0]));
        a.a(0, 3, "StatsDbHelper", "delStatInfo count = ".concat(String.valueOf(b)));
        return b;
    }

    public static List<sg.bigo.ads.common.c.b.b> a(int i) {
        Cursor a = sg.bigo.ads.common.c.a.a.a("tb_stat", (String) null, (String[]) null, "mtime DESC", i);
        ArrayList arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        a.a(0, 3, "StatsDbHelper", "getStatInfoList: count = " + a.getCount());
        while (a.moveToNext()) {
            arrayList.add(new sg.bigo.ads.common.c.b.b(a));
            r.a();
        }
        a.close();
        return arrayList;
    }
}
