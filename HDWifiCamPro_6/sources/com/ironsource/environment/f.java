package com.ironsource.environment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class f extends SQLiteOpenHelper {
    public f(Context context) {
        super(context, "reports", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.Cursor a(int r4) {
        /*
            com.ironsource.environment.f r0 = new com.ironsource.environment.f
            com.ironsource.environment.e r1 = com.ironsource.environment.e.a()
            android.content.Context r1 = r1.a
            r0.<init>(r1)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "SELECT * FROM REPORTSWHERE id= "
            r2.<init>(r3)     // Catch:{ all -> 0x002d }
            r2.append(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r4 = ";"
            r2.append(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x002d }
            android.database.Cursor r4 = r0.rawQuery(r4, r1)     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x002c
            r0.close()
        L_0x002c:
            return r4
        L_0x002d:
            r4 = move-exception
            goto L_0x0031
        L_0x002f:
            r4 = move-exception
            r0 = r1
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            r0.close()
        L_0x0036:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.f.a(int):android.database.Cursor");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.ironsource.environment.c> a() {
        /*
            com.ironsource.environment.f r0 = new com.ironsource.environment.f
            com.ironsource.environment.e r1 = com.ironsource.environment.e.a()
            android.content.Context r1 = r1.a
            r0.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "SELECT * FROM REPORTS ;"
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ all -> 0x004e }
            android.database.Cursor r2 = r0.rawQuery(r2, r3)     // Catch:{ all -> 0x004c }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x0043
        L_0x0021:
            r3 = 0
            int r3 = r2.getInt(r3)     // Catch:{ all -> 0x004c }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x004c }
            r5 = 2
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x004c }
            r6 = 3
            java.lang.String r6 = r2.getString(r6)     // Catch:{ all -> 0x004c }
            com.ironsource.environment.c r7 = new com.ironsource.environment.c     // Catch:{ all -> 0x004c }
            r7.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x004c }
            r1.add(r7)     // Catch:{ all -> 0x004c }
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x0021
        L_0x0043:
            r2.close()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004b
            r0.close()
        L_0x004b:
            return r1
        L_0x004c:
            r1 = move-exception
            goto L_0x0050
        L_0x004e:
            r1 = move-exception
            r0 = r3
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            r0.close()
        L_0x0055:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.f.a():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.ironsource.environment.c r6) {
        /*
            com.ironsource.environment.f r0 = new com.ironsource.environment.f
            com.ironsource.environment.e r1 = com.ironsource.environment.e.a()
            android.content.Context r1 = r1.a
            r0.<init>(r1)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0046 }
            r0.beginTransaction()     // Catch:{ all -> 0x0044 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r6.a()     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = r6.b()     // Catch:{ all -> 0x0044 }
            java.lang.String r6 = r6.c()     // Catch:{ all -> 0x0044 }
            java.lang.String r5 = "stack_trace"
            r2.put(r5, r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = "crash_date"
            r2.put(r3, r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = "crashType"
            r2.put(r3, r6)     // Catch:{ all -> 0x0044 }
            java.lang.String r6 = "REPORTS"
            r0.insert(r6, r1, r2)     // Catch:{ all -> 0x0044 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0043
            r0.endTransaction()
            r0.close()
        L_0x0043:
            return
        L_0x0044:
            r6 = move-exception
            goto L_0x0048
        L_0x0046:
            r6 = move-exception
            r0 = r1
        L_0x0048:
            if (r0 == 0) goto L_0x0050
            r0.endTransaction()
            r0.close()
        L_0x0050:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.f.a(com.ironsource.environment.c):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.Cursor b() {
        /*
            com.ironsource.environment.f r0 = new com.ironsource.environment.f
            com.ironsource.environment.e r1 = com.ironsource.environment.e.a()
            android.content.Context r1 = r1.a
            r0.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r1 = "SELECT * FROM REPORTS;"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ all -> 0x0023 }
            android.database.Cursor r1 = r0.rawQuery(r1, r2)     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0020
            r0.close()
        L_0x0020:
            return r1
        L_0x0021:
            r1 = move-exception
            goto L_0x0025
        L_0x0023:
            r1 = move-exception
            r0 = r2
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()
        L_0x002a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.f.b():android.database.Cursor");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c() {
        /*
            com.ironsource.environment.f r0 = new com.ironsource.environment.f
            com.ironsource.environment.e r1 = com.ironsource.environment.e.a()
            android.content.Context r1 = r1.a
            r0.<init>(r1)
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "DELETE FROM REPORTS WHERE id >= 0;"
            r0.execSQL(r1)     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0019
            r0.close()
        L_0x0019:
            return
        L_0x001a:
            r1 = move-exception
            goto L_0x001e
        L_0x001c:
            r1 = move-exception
            r0 = 0
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()
        L_0x0023:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.f.c():void");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS REPORTS(id INTEGER PRIMARY KEY AUTOINCREMENT , stack_trace TEXT NOT NULL, crash_date TEXT NOT NULL,crashType TEXT NOT NULL );");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
