package com.adcolony.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.adcolony.sdk.e0;

class p {
    static void a(String str, ContentValues contentValues, SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.insertOrThrow(str, (String) null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            try {
                e0.a aVar = new e0.a();
                e0.a a = aVar.a("Exception on insert to " + str + ", db version:").a(sQLiteDatabase.getVersion());
                a.a(". Values: " + contentValues.toString() + " caused: ").a(e.toString()).a(e0.g);
            } catch (Throwable th) {
                e0.a aVar2 = new e0.a();
                e0.a a2 = aVar2.a("Error on insert to " + str + ", db version:").a(sQLiteDatabase.getVersion());
                a2.a(". Values: " + contentValues.toString() + " caused: ").a(th.toString()).a(e0.i);
                return;
            }
        }
        sQLiteDatabase.endTransaction();
    }

    static void a(int i, long j, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            if (str == null) {
                str = "rowid";
                j = -1;
            }
            if (i >= 0) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select " + str + " from " + str2 + " order by " + str + " desc limit 1 offset " + i, (String[]) null);
                if (rawQuery.moveToFirst()) {
                    j = Math.max(j, rawQuery.getLong(0));
                }
                rawQuery.close();
            }
            if (j >= 0) {
                sQLiteDatabase.execSQL("delete from " + str2 + " where " + str + " <= " + j);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            try {
                new e0.a().a("Exception on deleting excessive rows:").a(e.toString()).a(e0.g);
            } catch (Throwable th) {
                new e0.a().a("Error on deleting excessive rows:").a(th.toString()).a(e0.i);
                return;
            }
        }
        sQLiteDatabase.endTransaction();
    }
}
