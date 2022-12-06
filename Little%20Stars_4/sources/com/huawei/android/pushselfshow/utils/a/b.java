package com.huawei.android.pushselfshow.utils.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.android.pushagent.c.a.e;
import com.xiaomi.mipush.sdk.Constants;

public class b extends SQLiteOpenHelper {
    private static b a;
    private static b b;

    private b(Context context) {
        super(context, "push.db", (SQLiteDatabase.CursorFactory) null, 1);
        e.a("PushSelfShowLog", "DBHelper instance, version is 1");
    }

    private b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        e.a("PushSelfShowLog", "DBHelper instance, version is 1");
    }

    public static synchronized b a(Context context) {
        synchronized (b.class) {
            if (a != null) {
                b bVar = a;
                return bVar;
            }
            a = new b(context);
            b bVar2 = a;
            return bVar2;
        }
    }

    public static synchronized b a(Context context, String str) {
        synchronized (b.class) {
            if (b != null) {
                b bVar = b;
                return bVar;
            }
            b = new b(context, str);
            b bVar2 = b;
            return bVar2;
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        e.a("PushSelfShowLog", "updateVersionFrom0To1");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.EXTRA_KEY_TOKEN, " ".getBytes("UTF-8"));
            sQLiteDatabase.update("pushmsg", contentValues, (String) null, (String[]) null);
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r12 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r12 == null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "(tbl_name='"
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = "')"
            r1.append(r12)
            java.lang.String r5 = r1.toString()
            r12 = 0
            java.lang.String r3 = "sqlite_master"
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0041 }
            if (r12 == 0) goto L_0x0039
            r12.moveToFirst()     // Catch:{ Exception -> 0x0041 }
            int r11 = r12.getCount()     // Catch:{ Exception -> 0x0041 }
            if (r11 <= 0) goto L_0x0033
            r0 = 1
        L_0x0033:
            if (r12 == 0) goto L_0x0038
            r12.close()
        L_0x0038:
            return r0
        L_0x0039:
            if (r12 == 0) goto L_0x004e
        L_0x003b:
            r12.close()
            goto L_0x004e
        L_0x003f:
            r11 = move-exception
            goto L_0x004f
        L_0x0041:
            r11 = move-exception
            java.lang.String r1 = "PushSelfShowLog"
            java.lang.String r2 = r11.toString()     // Catch:{ all -> 0x003f }
            com.huawei.android.pushagent.c.a.e.c(r1, r2, r11)     // Catch:{ all -> 0x003f }
            if (r12 == 0) goto L_0x004e
            goto L_0x003b
        L_0x004e:
            return r0
        L_0x004f:
            if (r12 == 0) goto L_0x0054
            r12.close()
        L_0x0054:
            goto L_0x0056
        L_0x0055:
            throw r11
        L_0x0056:
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.b.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        e.a("PushSelfShowLog", "onCreate");
        if (a(sQLiteDatabase, "pushmsg")) {
            e.a("PushSelfShowLog", "old table is exist");
            onUpgrade(sQLiteDatabase, 0, 1);
            return;
        }
        try {
            sQLiteDatabase.execSQL("create table notify(url  TEXT  PRIMARY KEY , bmp  BLOB );");
            sQLiteDatabase.execSQL("create table pushmsg( _id INTEGER PRIMARY KEY AUTOINCREMENT, url  TEXT  , token  BLOB ,msg  BLOB );");
        } catch (SQLException e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e.a("PushSelfShowLog", "onDowngrade,oldVersion:" + i + ",newVersion:" + i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e.a("PushSelfShowLog", "onUpgrade,oldVersion:" + i + ",newVersion:" + i2);
        if (i == 0) {
            a(sQLiteDatabase);
        }
    }
}
