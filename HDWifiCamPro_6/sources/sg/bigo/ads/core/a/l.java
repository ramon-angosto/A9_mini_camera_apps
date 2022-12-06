package sg.bigo.ads.core.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.c.a.a;
import sg.bigo.ads.common.utils.r;

public final class l {
    private static final boolean a = true;

    static {
        r.a();
    }

    public static int a(long j) {
        int b = a.b("tb_report", "mtime < " + j + " AND valid_date_ts = 0", (String[]) null);
        r.a();
        return b;
    }

    private static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String append : strArr) {
            sb.append(append);
            i++;
            sb.append(i < strArr.length ? "=? AND " : "=? ");
        }
        return sb.toString();
    }

    public static List<m> a() {
        return a(a(new String[]{"status"}), new String[]{"1"});
    }

    public static List<m> a(int i) {
        return a(a(new String[]{"status", "source"}), new String[]{MBridgeConstans.ENDCARD_URL_TYPE_PL, String.valueOf(i)});
    }

    private static List<m> a(String str, String[] strArr) {
        Cursor a2 = a.a("tb_report", str, strArr, "mtime DESC", 30);
        ArrayList arrayList = new ArrayList();
        if (a2 == null) {
            return arrayList;
        }
        while (a2.moveToNext()) {
            arrayList.add(a(a2));
        }
        a2.close();
        r.a();
        return arrayList;
    }

    private static m a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("pkg_name"));
        if (a) {
            string = new String(Base64.decode(string, 0));
        }
        m mVar = new m(string, cursor.getInt(cursor.getColumnIndex("status")), cursor.getInt(cursor.getColumnIndex("source")));
        mVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
        mVar.e = cursor.getLong(cursor.getColumnIndex("check_ts"));
        mVar.f = cursor.getInt(cursor.getColumnIndex(IronSourceConstants.EVENTS_RESULT));
        mVar.g = cursor.getLong(cursor.getColumnIndex("install_ts"));
        mVar.h = cursor.getLong(cursor.getColumnIndex("valid_date_ts"));
        mVar.j = cursor.getLong(cursor.getColumnIndex("sid"));
        mVar.k = cursor.getString(cursor.getColumnIndex("ad_id"));
        mVar.l = cursor.getString(cursor.getColumnIndex("dsp"));
        mVar.i = cursor.getLong(cursor.getColumnIndex("mtime"));
        return mVar;
    }

    public static void a(List<m> list) {
        a.b();
        SQLiteDatabase a2 = a.a();
        if (a2 != null) {
            try {
                a2.beginTransaction();
                for (m next : list) {
                    if (next.a()) {
                        next.i = System.currentTimeMillis();
                        a2.updateWithOnConflict("tb_report", b(next), a(new String[]{"_id"}), new String[]{String.valueOf(next.a)}, 5);
                    } else {
                        next.a = a2.insertWithOnConflict("tb_report", (String) null, b(next), 5);
                    }
                    r.a();
                }
                a2.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                a2.endTransaction();
            }
        }
    }

    public static void a(m mVar) {
        mVar.a = a.a("tb_report", b(mVar));
        r.a();
    }

    public static int b(List<m> list) {
        int i = 0;
        if (list.isEmpty()) {
            return 0;
        }
        String[] strArr = new String[list.size()];
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        while (i < list.size()) {
            sb.append(i == 0 ? "?" : ",?");
            strArr[i] = String.valueOf(list.get(i).a);
            i++;
        }
        sb.append(")");
        r.a();
        return a.b("tb_report", sb.toString(), strArr);
    }

    private static ContentValues b(m mVar) {
        ContentValues contentValues = new ContentValues();
        String str = mVar.b;
        if (a) {
            str = Base64.encodeToString(str.getBytes(), 0);
        }
        contentValues.put("pkg_name", str);
        contentValues.put("status", Integer.valueOf(mVar.c));
        contentValues.put("source", Integer.valueOf(mVar.d));
        contentValues.put("check_ts", Long.valueOf(mVar.e));
        contentValues.put(IronSourceConstants.EVENTS_RESULT, Integer.valueOf(mVar.f));
        contentValues.put("install_ts", Long.valueOf(mVar.g));
        contentValues.put("valid_date_ts", Long.valueOf(mVar.h));
        contentValues.put("sid", Long.valueOf(mVar.j));
        contentValues.put("ad_id", mVar.k);
        contentValues.put("dsp", mVar.l);
        contentValues.put("mtime", Long.valueOf(mVar.i == 0 ? System.currentTimeMillis() : mVar.i));
        return contentValues;
    }
}
