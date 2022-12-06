package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Campaign;

/* compiled from: DailyPlayCapDao */
public class h extends a<Campaign> {
    private static final String a = h.class.getName();
    private static h b = null;

    private h(f fVar) {
        super(fVar);
    }

    public static synchronized h a(f fVar) {
        h hVar;
        synchronized (h.class) {
            if (b == null) {
                b = new h(fVar);
            }
            hVar = b;
        }
        return hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r0 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r0 == null) goto L_0x007a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r2.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r3 = "SELECT * FROM dailyplaycap where unit_id ='"
            r2.append(r3)     // Catch:{ all -> 0x006d }
            r2.append(r11)     // Catch:{ all -> 0x006d }
            java.lang.String r3 = "'"
            r2.append(r3)     // Catch:{ all -> 0x006d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x006d }
            monitor-enter(r10)     // Catch:{ all -> 0x006d }
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch:{ all -> 0x006a }
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch:{ all -> 0x006a }
            monitor-exit(r10)     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0064
            int r2 = r0.getCount()     // Catch:{ all -> 0x006d }
            if (r2 <= 0) goto L_0x0064
            boolean r2 = r0.moveToFirst()     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x0064
            java.lang.String r2 = "first_insert_timestamp"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x006d }
            long r2 = r0.getLong(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r4 = "play_time"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ all -> 0x006d }
            int r4 = r0.getInt(r4)     // Catch:{ all -> 0x006d }
            long r4 = (long) r4     // Catch:{ all -> 0x006d }
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0064
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006d }
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            long r6 = r6 - r8
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x005b
            r10.b(r11)     // Catch:{ all -> 0x006d }
            goto L_0x0064
        L_0x005b:
            if (r12 <= 0) goto L_0x0064
            long r11 = (long) r12
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 < 0) goto L_0x0064
            r11 = 1
            r1 = r11
        L_0x0064:
            if (r0 == 0) goto L_0x007a
        L_0x0066:
            r0.close()     // Catch:{ all -> 0x007a }
            goto L_0x007a
        L_0x006a:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x006a }
            throw r11     // Catch:{ all -> 0x006d }
        L_0x006d:
            r11 = move-exception
            java.lang.String r12 = a     // Catch:{ all -> 0x007b }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x007b }
            com.mbridge.msdk.foundation.tools.q.b(r12, r11)     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x007a
            goto L_0x0066
        L_0x007a:
            return r1
        L_0x007b:
            r11 = move-exception
            if (r0 == 0) goto L_0x0081
            r0.close()     // Catch:{ all -> 0x0081 }
        L_0x0081:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.a(java.lang.String, int):boolean");
    }

    private synchronized void b(String str) {
        try {
            if (getWritableDatabase() != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("first_insert_timestamp", 0);
                contentValues.put("play_time", 0);
                getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", (String[]) null);
            } else {
                return;
            }
        } catch (Throwable th) {
            q.b(a, th.getMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cc, code lost:
        if (r1 != null) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d8, code lost:
        if (r1 != null) goto L_0x00ce;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e2 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078 A[Catch:{ Exception -> 0x006f, all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00df A[SYNTHETIC, Splitter:B:45:0x00df] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r17
            monitor-enter(r16)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r16.getWritableDatabase()     // Catch:{ Exception -> 0x00d4 }
            if (r2 != 0) goto L_0x000c
            monitor-exit(r16)
            return
        L_0x000c:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x00d4 }
            r2.<init>()     // Catch:{ Exception -> 0x00d4 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00d4 }
            boolean r5 = r16.c(r17)     // Catch:{ Exception -> 0x00d4 }
            r6 = 1
            if (r5 == 0) goto L_0x00ac
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            r5.<init>()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r8 = "SELECT * FROM dailyplaycap where unit_id ='"
            r5.append(r8)     // Catch:{ Exception -> 0x00d4 }
            r5.append(r0)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r8 = "'"
            r5.append(r8)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00d4 }
            android.database.sqlite.SQLiteDatabase r8 = r16.getReadableDatabase()     // Catch:{ Exception -> 0x00d4 }
            android.database.Cursor r5 = r8.rawQuery(r5, r1)     // Catch:{ Exception -> 0x00d4 }
            r8 = 0
            if (r5 == 0) goto L_0x0072
            int r10 = r5.getCount()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            if (r10 <= 0) goto L_0x0072
            r5.moveToFirst()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r10 = "first_insert_timestamp"
            int r10 = r5.getColumnIndex(r10)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            long r10 = r5.getLong(r10)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r12 = "play_time"
            int r12 = r5.getColumnIndex(r12)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            int r12 = r5.getInt(r12)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            long r12 = (long) r12     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r14 = 86400000(0x5265c00, double:4.2687272E-316)
            long r14 = r3 - r14
            int r14 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r14 <= 0) goto L_0x0074
            r16.b(r17)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r12 = r8
            goto L_0x0074
        L_0x006b:
            r0 = move-exception
            r1 = r5
            goto L_0x00dd
        L_0x006f:
            r0 = move-exception
            r1 = r5
            goto L_0x00d5
        L_0x0072:
            r10 = r8
            r12 = r10
        L_0x0074:
            int r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0081
            java.lang.String r8 = "first_insert_timestamp"
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r2.put(r8, r3)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
        L_0x0081:
            java.lang.String r3 = "play_time"
            long r12 = r12 + r6
            java.lang.Long r4 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r3.<init>()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r4 = "unit_id = '"
            r3.append(r4)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r3.append(r0)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r0 = "'"
            r3.append(r0)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            android.database.sqlite.SQLiteDatabase r3 = r16.getWritableDatabase()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r4 = "dailyplaycap"
            r3.update(r4, r2, r0, r1)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r1 = r5
            goto L_0x00cc
        L_0x00ac:
            java.lang.String r5 = "first_insert_timestamp"
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00d4 }
            r2.put(r5, r3)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = "play_time"
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00d4 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = "unit_id"
            r2.put(r3, r0)     // Catch:{ Exception -> 0x00d4 }
            android.database.sqlite.SQLiteDatabase r0 = r16.getWritableDatabase()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = "dailyplaycap"
            r0.insert(r3, r1, r2)     // Catch:{ Exception -> 0x00d4 }
        L_0x00cc:
            if (r1 == 0) goto L_0x00db
        L_0x00ce:
            r1.close()     // Catch:{ all -> 0x00db }
            goto L_0x00db
        L_0x00d2:
            r0 = move-exception
            goto L_0x00dd
        L_0x00d4:
            r0 = move-exception
        L_0x00d5:
            r0.printStackTrace()     // Catch:{ all -> 0x00d2 }
            if (r1 == 0) goto L_0x00db
            goto L_0x00ce
        L_0x00db:
            monitor-exit(r16)
            return
        L_0x00dd:
            if (r1 == 0) goto L_0x00e2
            r1.close()     // Catch:{ all -> 0x00e2 }
        L_0x00e2:
            throw r0     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r0 = move-exception
            r1 = r0
            monitor-exit(r16)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r1.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = "SELECT play_time FROM dailyplaycap WHERE unit_id='"
            r1.append(r2)     // Catch:{ all -> 0x0036 }
            r1.append(r4)     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = "'"
            r1.append(r4)     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0036 }
            android.database.sqlite.SQLiteDatabase r1 = r3.getReadableDatabase()     // Catch:{ all -> 0x0036 }
            r2 = 0
            android.database.Cursor r4 = r1.rawQuery(r4, r2)     // Catch:{ all -> 0x0036 }
            if (r4 == 0) goto L_0x002f
            int r1 = r4.getCount()     // Catch:{ all -> 0x0036 }
            if (r1 <= 0) goto L_0x002f
            r4.close()     // Catch:{ all -> 0x0036 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x002f:
            if (r4 == 0) goto L_0x0034
            r4.close()     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r3)
            return r0
        L_0x0036:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.c(java.lang.String):boolean");
    }
}
