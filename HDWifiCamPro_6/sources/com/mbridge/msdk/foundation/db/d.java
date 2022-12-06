package com.mbridge.msdk.foundation.db;

/* compiled from: CampaignClickTimeDao */
public final class d extends a<com.mbridge.msdk.foundation.entity.d> {
    private static d a;

    private d(f fVar) {
        super(fVar);
    }

    public static synchronized d a(f fVar) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(fVar);
            }
            dVar = a;
        }
        return dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0130, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0133, code lost:
        if (r1 != null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0141, code lost:
        if (r1 != null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0145, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0149 A[SYNTHETIC, Splitter:B:40:0x0149] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.d> a(int r28) {
        /*
            r27 = this;
            r0 = r28
            monitor-enter(r27)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x014d }
            r1.<init>()     // Catch:{ all -> 0x014d }
            java.lang.String r2 = "select * from click_time LIMIT "
            r1.append(r2)     // Catch:{ all -> 0x014d }
            r1.append(r0)     // Catch:{ all -> 0x014d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x014d }
            android.database.sqlite.SQLiteDatabase r2 = r27.getWritableDatabase()     // Catch:{ all -> 0x014d }
            r3 = 0
            if (r2 != 0) goto L_0x001d
            monitor-exit(r27)
            return r3
        L_0x001d:
            android.database.sqlite.SQLiteDatabase r2 = r27.getWritableDatabase()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            android.database.Cursor r1 = r2.rawQuery(r1, r3)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            if (r1 == 0) goto L_0x0133
            int r2 = r1.getCount()     // Catch:{ Exception -> 0x0131 }
            if (r2 <= 0) goto L_0x0133
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0131 }
            r2.<init>()     // Catch:{ Exception -> 0x0131 }
            r4 = 0
            r5 = r4
        L_0x0034:
            boolean r6 = r1.moveToNext()     // Catch:{ Exception -> 0x0131 }
            if (r6 == 0) goto L_0x012a
            if (r5 < r0) goto L_0x003e
            goto L_0x012a
        L_0x003e:
            int r5 = r5 + 1
            java.lang.String r6 = "id"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0131 }
            int r6 = r1.getInt(r6)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "campaignId"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r11 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "click_type"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            int r19 = r1.getInt(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "click_duration"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r12 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "last_url"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r13 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "type"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            int r18 = r1.getInt(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "code"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            int r14 = r1.getInt(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "header"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r16 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "exception"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r15 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "content"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r17 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "unit_id"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r20 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "rid"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r9 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "rid_n"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r10 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "landing_type"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            int r21 = r1.getInt(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "link_type"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            int r22 = r1.getInt(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "network_type"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            int r24 = r1.getInt(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "network_str"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r26 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "market_result"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            int r25 = r1.getInt(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r7 = "click_time"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r23 = r1.getString(r7)     // Catch:{ Exception -> 0x0131 }
            com.mbridge.msdk.foundation.entity.d r7 = new com.mbridge.msdk.foundation.entity.d     // Catch:{ Exception -> 0x0131 }
            r8 = r7
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x0131 }
            r2.add(r7)     // Catch:{ Exception -> 0x0131 }
            android.database.sqlite.SQLiteDatabase r7 = r27.getWritableDatabase()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r8 = "click_time"
            java.lang.String r9 = "id = ?"
            r10 = 1
            java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ Exception -> 0x0131 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0131 }
            r11.<init>()     // Catch:{ Exception -> 0x0131 }
            r11.append(r6)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r6 = ""
            r11.append(r6)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r6 = r11.toString()     // Catch:{ Exception -> 0x0131 }
            r10[r4] = r6     // Catch:{ Exception -> 0x0131 }
            r7.delete(r8, r9, r10)     // Catch:{ Exception -> 0x0131 }
            goto L_0x0034
        L_0x012a:
            if (r1 == 0) goto L_0x012f
            r1.close()     // Catch:{ all -> 0x014d }
        L_0x012f:
            monitor-exit(r27)
            return r2
        L_0x0131:
            r0 = move-exception
            goto L_0x013e
        L_0x0133:
            if (r1 == 0) goto L_0x0144
        L_0x0135:
            r1.close()     // Catch:{ all -> 0x014d }
            goto L_0x0144
        L_0x0139:
            r0 = move-exception
            r1 = r3
            goto L_0x0147
        L_0x013c:
            r0 = move-exception
            r1 = r3
        L_0x013e:
            r0.printStackTrace()     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x0144
            goto L_0x0135
        L_0x0144:
            monitor-exit(r27)
            return r3
        L_0x0146:
            r0 = move-exception
        L_0x0147:
            if (r1 == 0) goto L_0x014c
            r1.close()     // Catch:{ all -> 0x014d }
        L_0x014c:
            throw r0     // Catch:{ all -> 0x014d }
        L_0x014d:
            r0 = move-exception
            monitor-exit(r27)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.a(int):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r0 == 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r0 != 0) goto L_0x001b;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from click_time"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x0021 }
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x0019
            boolean r2 = r0.moveToFirst()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0019
            int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x0021 }
        L_0x0019:
            if (r0 == 0) goto L_0x0028
        L_0x001b:
            r0.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0028
        L_0x001f:
            r1 = move-exception
            goto L_0x002a
        L_0x0021:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0028
            goto L_0x001b
        L_0x0028:
            monitor-exit(r4)
            return r1
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ all -> 0x0030 }
        L_0x002f:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.a():int");
    }
}
