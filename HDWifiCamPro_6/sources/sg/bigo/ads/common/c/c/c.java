package sg.bigo.ads.common.c.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.k.a;

public final class c {
    public static long a(String str) {
        a.a(0, 3, "TrackerDbHelper", "delete:".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a((List<String>) arrayList);
    }

    private static long a(List<String> list) {
        a.a(0, 3, "TrackerDbHelper", "delete:" + list.size());
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        int i = 0;
        while (i < list.size()) {
            sb.append(i == 0 ? "?" : ",?");
            i++;
        }
        sb.append(")");
        long b = (long) sg.bigo.ads.common.c.a.a.b("tb_tracker", sb.toString(), (String[]) list.toArray(new String[0]));
        a.a(0, 3, "TrackerDbHelper", "delTrackerInfo count = ".concat(String.valueOf(b)));
        return b;
    }

    public static long a(sg.bigo.ads.common.c.b.c cVar) {
        a.a(0, 3, "TrackerDbHelper", "insert:" + cVar.toString());
        return sg.bigo.ads.common.c.a.a.a("tb_tracker", d(cVar));
    }

    public static Cursor a(long j) {
        Cursor a = sg.bigo.ads.common.c.a.a.a("tb_tracker", "last_retry_ts < " + (System.currentTimeMillis() - j), (String[]) null, "last_retry_ts", 10);
        if (a != null) {
            a.a(0, 3, "TrackerDbHelper", "getList: count = " + a.getCount());
        }
        return a;
    }

    private static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            sb.append(strArr[0]);
            sb.append("=? ");
        }
        return sb.toString();
    }

    public static long b(long j) {
        a.a(0, 3, "TrackerDbHelper", "clearTrackerInfo");
        long b = (long) sg.bigo.ads.common.c.a.a.b("tb_tracker", "ctime < ".concat(String.valueOf(j)), (String[]) null);
        a.a(0, 3, "TrackerDbHelper", "clearTrackerInfo count = ".concat(String.valueOf(b)));
        return b;
    }

    public static long b(sg.bigo.ads.common.c.b.c cVar) {
        a.a(0, 3, "TrackerDbHelper", "update: " + cVar.toString());
        cVar.g = System.currentTimeMillis();
        String a = a(new String[]{"_id"});
        return (long) sg.bigo.ads.common.c.a.a.a("tb_tracker", d(cVar), a, new String[]{String.valueOf(cVar.a)});
    }

    public static boolean c(sg.bigo.ads.common.c.b.c cVar) {
        a.a(0, 3, "TrackerDbHelper", "exist:" + cVar.toString());
        Cursor a = sg.bigo.ads.common.c.a.a.a("tb_tracker", a(new String[]{"_id"}), new String[]{String.valueOf(cVar.a)});
        if (a == null) {
            return false;
        }
        boolean moveToNext = a.moveToNext();
        a.close();
        return moveToNext;
    }

    private static ContentValues d(sg.bigo.ads.common.c.b.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_data", cVar.a());
        contentValues.put("tracker_imp", cVar.b());
        contentValues.put("tracker_cli", cVar.c());
        contentValues.put("tracker_nurl", cVar.d());
        contentValues.put("tracker_lurl", cVar.e());
        contentValues.put("last_retry_ts", Long.valueOf(cVar.f()));
        contentValues.put("ext", cVar.e);
        contentValues.put("ctime", Long.valueOf(cVar.f == 0 ? System.currentTimeMillis() : cVar.f));
        contentValues.put("mtime", Long.valueOf(cVar.g == 0 ? System.currentTimeMillis() : cVar.g));
        return contentValues;
    }
}
