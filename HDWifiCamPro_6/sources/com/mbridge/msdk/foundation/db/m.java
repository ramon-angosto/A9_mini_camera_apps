package com.mbridge.msdk.foundation.db;

/* compiled from: ReportErrorDao */
public class m extends a {
    private static m a;

    private m(f fVar) {
        super(fVar);
    }

    public static m a(f fVar) {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m(fVar);
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r0 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r0 == null) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = " count(*) "
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch:{ all -> 0x003c }
            r0 = 0
            r9 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ Exception -> 0x002d }
            java.lang.String r2 = "reporterror"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x0025
            boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x002d }
            if (r1 == 0) goto L_0x0025
            int r1 = r0.getInt(r9)     // Catch:{ Exception -> 0x002d }
            r9 = r1
        L_0x0025:
            if (r0 == 0) goto L_0x0034
        L_0x0027:
            r0.close()     // Catch:{ all -> 0x003c }
            goto L_0x0034
        L_0x002b:
            r1 = move-exception
            goto L_0x0036
        L_0x002d:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0034
            goto L_0x0027
        L_0x0034:
            monitor-exit(r10)
            return r9
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ all -> 0x003c }
        L_0x003b:
            throw r1     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = -1
            java.lang.String r1 = "url=?"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            r3 = 0
            r2[r3] = r5     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            if (r5 != 0) goto L_0x0012
            monitor-exit(r4)
            return r0
        L_0x0012:
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            java.lang.String r3 = "reporterror"
            int r5 = r5.delete(r3, r1, r2)     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            monitor-exit(r4)
            return r5
        L_0x001e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0021:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a(java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(java.lang.String r4, java.lang.String r5, long r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = -1
            if (r4 != 0) goto L_0x0006
            java.lang.String r4 = ""
        L_0x0006:
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            if (r1 != 0) goto L_0x000e
            monitor-exit(r3)
            return r0
        L_0x000e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r1.<init>()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r2 = "DELETE from reporterror where url='"
            r1.append(r2)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r1.append(r5)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r5 = "' and "
            r1.append(r5)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r5 = "data"
            r1.append(r5)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r5 = "='"
            r1.append(r5)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r1.append(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = "' and "
            r1.append(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = "time_stamp"
            r1.append(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = "="
            r1.append(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r1.append(r6)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = " or "
            r1.append(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = "count"
            r1.append(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = " > 5 "
            r1.append(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            android.database.sqlite.SQLiteDatabase r5 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r6 = 0
            android.database.Cursor r4 = r5.rawQuery(r4, r6)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            int r4 = r4.getCount()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            monitor-exit(r3)
            return r4
        L_0x0061:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0064:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a(java.lang.String, java.lang.String, long):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int b(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r0.<init>()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            java.lang.String r1 = "DELETE from reporterror where count >= "
            r0.append(r1)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r0.append(r3)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 0
            android.database.Cursor r3 = r0.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            int r3 = r3.getCount()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            monitor-exit(r2)
            return r3
        L_0x0021:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0024:
            r3 = -1
            monitor-exit(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.b(int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r0 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        if (r0 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int b() {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 0
            r1 = 0
            java.lang.String r2 = " count(*) "
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ all -> 0x0034 }
            android.database.sqlite.SQLiteDatabase r3 = r12.getReadableDatabase()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = "reporterror"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0025 }
            int r1 = r0.getCount()     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x002c
        L_0x001f:
            r0.close()     // Catch:{ all -> 0x0034 }
            goto L_0x002c
        L_0x0023:
            r1 = move-exception
            goto L_0x002e
        L_0x0025:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x002c
            goto L_0x001f
        L_0x002c:
            monitor-exit(r12)
            return r1
        L_0x002e:
            if (r0 == 0) goto L_0x0033
            r0.close()     // Catch:{ all -> 0x0034 }
        L_0x0033:
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.b():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008f, code lost:
        if (r13 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009f, code lost:
        if (r13 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A[SYNTHETIC, Splitter:B:31:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.k> a(int r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 5
            r1 = 0
            r12.b(r0)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            android.database.sqlite.SQLiteDatabase r2 = r12.getReadableDatabase()     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            java.lang.String r3 = "reporterror"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            r0.<init>()     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            r0.append(r13)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            java.lang.String r13 = ""
            r0.append(r13)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
            if (r13 == 0) goto L_0x008e
            int r0 = r13.getCount()     // Catch:{ Exception -> 0x0089 }
            if (r0 <= 0) goto L_0x008e
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0089 }
            r0.<init>()     // Catch:{ Exception -> 0x0089 }
        L_0x0034:
            boolean r1 = r13.moveToNext()     // Catch:{ Exception -> 0x0087 }
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = "url"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = "data"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r3 = "method"
            int r3 = r13.getColumnIndex(r3)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r3 = r13.getString(r3)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r4 = "unitId"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r4 = r13.getString(r4)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r5 = "count"
            int r5 = r13.getColumnIndex(r5)     // Catch:{ Exception -> 0x0087 }
            int r5 = r13.getInt(r5)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = "time_stamp"
            int r6 = r13.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087 }
            long r6 = r13.getLong(r6)     // Catch:{ Exception -> 0x0087 }
            com.mbridge.msdk.foundation.entity.k r8 = new com.mbridge.msdk.foundation.entity.k     // Catch:{ Exception -> 0x0087 }
            r8.<init>(r1, r3, r2, r4)     // Catch:{ Exception -> 0x0087 }
            int r5 = r5 + 1
            r8.a((int) r5)     // Catch:{ Exception -> 0x0087 }
            r8.a((long) r6)     // Catch:{ Exception -> 0x0087 }
            r0.add(r8)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0034
        L_0x0087:
            r1 = move-exception
            goto L_0x009c
        L_0x0089:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
            goto L_0x009c
        L_0x008e:
            r0 = r1
        L_0x008f:
            if (r13 == 0) goto L_0x00a2
        L_0x0091:
            r13.close()     // Catch:{ all -> 0x00ab }
            goto L_0x00a2
        L_0x0095:
            r0 = move-exception
            r13 = r1
            goto L_0x00a5
        L_0x0098:
            r13 = move-exception
            r0 = r1
            r1 = r13
            r13 = r0
        L_0x009c:
            r1.printStackTrace()     // Catch:{ all -> 0x00a4 }
            if (r13 == 0) goto L_0x00a2
            goto L_0x0091
        L_0x00a2:
            monitor-exit(r12)
            return r0
        L_0x00a4:
            r0 = move-exception
        L_0x00a5:
            if (r13 == 0) goto L_0x00aa
            r13.close()     // Catch:{ all -> 0x00ab }
        L_0x00aa:
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0054, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(java.lang.String r4, java.lang.String r5, long r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            if (r4 != 0) goto L_0x0006
            java.lang.String r4 = ""
        L_0x0006:
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x0057 }
            if (r1 != 0) goto L_0x000e
            monitor-exit(r3)
            return r0
        L_0x000e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057 }
            r1.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "select * from reporterror where url='"
            r1.append(r2)     // Catch:{ Exception -> 0x0057 }
            r1.append(r5)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = "' and "
            r1.append(r5)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = "data"
            r1.append(r5)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = "='"
            r1.append(r5)     // Catch:{ Exception -> 0x0057 }
            r1.append(r4)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r4 = "' and "
            r1.append(r4)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r4 = "time_stamp"
            r1.append(r4)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r4 = "="
            r1.append(r4)     // Catch:{ Exception -> 0x0057 }
            r1.append(r6)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0057 }
            android.database.sqlite.SQLiteDatabase r5 = r3.getReadableDatabase()     // Catch:{ Exception -> 0x0057 }
            r6 = 0
            android.database.Cursor r4 = r5.rawQuery(r4, r6)     // Catch:{ Exception -> 0x0057 }
            int r4 = r4.getCount()     // Catch:{ Exception -> 0x0057 }
            if (r4 <= 0) goto L_0x0053
            r0 = 1
        L_0x0053:
            monitor-exit(r3)
            return r0
        L_0x0055:
            r4 = move-exception
            goto L_0x005d
        L_0x0057:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0055 }
            monitor-exit(r3)
            return r0
        L_0x005d:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.b(java.lang.String, java.lang.String, long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d7, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(com.mbridge.msdk.foundation.entity.k r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = -1
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.<init>()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "url"
            java.lang.String r4 = r8.b()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "method"
            java.lang.String r4 = r8.c()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "data"
            java.lang.String r4 = r8.d()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "unitId"
            java.lang.String r4 = r8.a()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "time_stamp"
            long r4 = r8.f()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            android.database.sqlite.SQLiteDatabase r3 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            if (r3 != 0) goto L_0x0041
            monitor-exit(r7)
            return r0
        L_0x0041:
            java.lang.String r3 = r8.d()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r4 = r8.b()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            long r5 = r8.f()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            boolean r3 = r7.b(r3, r4, r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r4 = 0
            if (r3 == 0) goto L_0x00ba
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.<init>()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "UPDATE reporterror SET count = "
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            int r3 = r8.e()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = " where "
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "url"
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "='"
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = r8.b()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "' and "
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "data"
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "='"
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = r8.d()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "' and "
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "time_stamp"
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "="
            r2.append(r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            long r5 = r8.f()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.append(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            android.database.sqlite.SQLiteDatabase r2 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            android.database.Cursor r8 = r2.rawQuery(r8, r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            int r8 = r8.getCount()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            long r0 = (long) r8
            monitor-exit(r7)
            return r0
        L_0x00ba:
            java.lang.String r3 = "count"
            int r8 = r8.e()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            r2.put(r3, r8)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            android.database.sqlite.SQLiteDatabase r8 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            java.lang.String r3 = "reporterror"
            long r0 = r8.insert(r3, r4, r2)     // Catch:{ Exception -> 0x00d6, all -> 0x00d3 }
            monitor-exit(r7)
            return r0
        L_0x00d3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x00d6:
            monitor-exit(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a(com.mbridge.msdk.foundation.entity.k):long");
    }
}
