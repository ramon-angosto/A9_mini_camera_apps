package com.bytedance.sdk.component.e.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.e.a.a.a.a.a;
import com.bytedance.sdk.component.e.a.a.a.a.e;
import com.bytedance.sdk.component.e.a.a.a.a.f;
import com.bytedance.sdk.component.e.a.c.c;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DatabaseHelper */
public class d extends SQLiteOpenHelper {
    final Context a;

    public d(Context context) {
        super(context, "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.a = context;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            a(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        c.a(IDatabaseHelper.TAG, "initDB........");
        sQLiteDatabase.execSQL(a.f());
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.e.a.a.a.a.c.g());
        sQLiteDatabase.execSQL(f.g());
        sQLiteDatabase.execSQL(e.d());
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.e.a.f.f.b());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            c.a(IDatabaseHelper.TAG, "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
            if (i > i2) {
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                c.a(IDatabaseHelper.TAG, "onUpgrade...Reverse installation Database reset - create table.....");
                return;
            }
            a(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> c = c(sQLiteDatabase);
        if (c != null && c.size() > 0) {
            Iterator<String> it = c.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", new Object[]{it.next()}));
            }
        }
    }

    private ArrayList<String> c(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", (String[]) null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                rawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
