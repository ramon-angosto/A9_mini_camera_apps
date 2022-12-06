package sg.bigo.ads.controller.c;

import android.database.Cursor;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.common.utils.r;

public final class a {
    public static c a(g gVar, h hVar) {
        String[] strArr = {"slot"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            sb.append(strArr[0]);
            sb.append("=? ");
        }
        Cursor a = sg.bigo.ads.common.c.a.a.a("tb_addata", sb.toString(), new String[]{String.valueOf(gVar.k())}, (String) null, 1);
        if (a != null) {
            if (a.moveToNext()) {
                long j = a.getLong(a.getColumnIndex("log_id"));
                String string = a.getString(a.getColumnIndex("ad_data"));
                long j2 = a.getLong(a.getColumnIndex("end_time"));
                b a2 = b.a(j, hVar, gVar, string);
                if (a2 != null) {
                    a2.L();
                    a2.a(j2);
                    return a2;
                }
            }
            a.close();
        }
        return null;
    }

    public static boolean a(String str) {
        int b = sg.bigo.ads.common.c.a.a.b("tb_addata", "slot = '" + str + "'", (String[]) null);
        r.a();
        return b > 0;
    }
}
