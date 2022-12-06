package sg.bigo.ads.common.c.c;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.utils.r;

public final class a {
    public static long a(List<String> list) {
        sg.bigo.ads.common.k.a.a(0, 3, "EventDbHelper", "delEventInfo:" + list.size());
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        int i = 0;
        while (i < list.size()) {
            sb.append(i == 0 ? "?" : ",?");
            i++;
        }
        sb.append(")");
        long b = (long) sg.bigo.ads.common.c.a.a.b("tb_event", sb.toString(), (String[]) list.toArray(new String[0]));
        sg.bigo.ads.common.k.a.a(0, 3, "EventDbHelper", "delEventInfo count = ".concat(String.valueOf(b)));
        return b;
    }

    public static List<sg.bigo.ads.common.c.b.a> a(int i) {
        Cursor a = sg.bigo.ads.common.c.a.a.a("tb_event", (String) null, (String[]) null, "mtime DESC", i);
        ArrayList arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "EventDbHelper", "getEventInfoList: count = " + a.getCount());
        while (a.moveToNext()) {
            arrayList.add(new sg.bigo.ads.common.c.b.a(a));
            r.a();
        }
        a.close();
        return arrayList;
    }
}
