package com.huawei.android.pushselfshow.utils.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;

public class a {
    public static ArrayList a(Context context, String str) {
        Cursor a;
        ArrayList arrayList = new ArrayList();
        try {
            String c = c(context, "hwpushApp.db");
            if (TextUtils.isEmpty(c)) {
                e.a("PushSelfShowLog", "database is null,can't queryAppinfo");
                return arrayList;
            }
            e.a("PushSelfShowLog", "dbName path is " + c);
            if (d.a().a(c, "openmarket")) {
                a = d.a().a(c, "select * from openmarket where package = ?;", new String[]{str});
                if (a == null) {
                    e.a("PushSelfShowLog", "cursor is null.");
                    return arrayList;
                }
                try {
                    if (a.getCount() > 0) {
                        do {
                            String string = a.getString(a.getColumnIndex("msgid"));
                            arrayList.add(string);
                            e.a("TAG", "msgid and packageName is  " + string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                        } while (a.moveToNext());
                    }
                    try {
                        a.close();
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e.c("TAG", "queryAppinfo error " + e2.toString(), e2);
                    try {
                        a.close();
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
            }
            return arrayList;
            e.d("PushSelfShowLog", "cursor.close() ", e);
            return arrayList;
        } catch (Exception e4) {
            e.d("PushSelfShowLog", "queryAppinfo error", e4);
        } catch (Throwable th) {
            try {
                a.close();
            } catch (Exception e5) {
                e.d("PushSelfShowLog", "cursor.close() ", e5);
            }
            throw th;
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (!context.getDatabasePath("hwpushApp.db").exists()) {
                context.openOrCreateDatabase("hwpushApp.db", 0, (SQLiteDatabase.CursorFactory) null);
            }
            String c = c(context, "hwpushApp.db");
            if (TextUtils.isEmpty(c)) {
                e.d("PushSelfShowLog", "database is null,can't insert appinfo into db");
                return;
            }
            e.a("PushSelfShowLog", "dbName path is " + c);
            if (!d.a().a(c, "openmarket")) {
                d.a().a(context, c, "create table openmarket(    _id INTEGER PRIMARY KEY AUTOINCREMENT,     msgid  TEXT,    package TEXT);");
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", str);
            contentValues.put("package", str2);
            d.a().a(context, c, "openmarket", contentValues);
        } catch (Exception e) {
            e.d("PushSelfShowLog", "insertAppinfo error", e);
        }
    }

    public static void b(Context context, String str) {
        try {
            String c = c(context, "hwpushApp.db");
            if (TextUtils.isEmpty(c)) {
                e.d("PushSelfShowLog", "database is null,can't delete appinfo");
                return;
            }
            e.a("PushSelfShowLog", "dbName path is " + c);
            if (d.a().a(c, "openmarket")) {
                d.a().a(c, "openmarket", "package = ?", new String[]{str});
            }
        } catch (Exception e) {
            e.d("PushSelfShowLog", "Delete Appinfo error", e);
        }
    }

    private static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        File databasePath = context.getDatabasePath("hwpushApp.db");
        return databasePath.exists() ? databasePath.getAbsolutePath() : "";
    }
}
