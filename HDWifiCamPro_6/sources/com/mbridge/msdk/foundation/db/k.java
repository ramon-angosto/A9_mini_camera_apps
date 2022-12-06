package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;

/* compiled from: LoadTimeDao */
public final class k extends a<g> {
    private static k a;

    private k(f fVar) {
        super(fVar);
    }

    public static synchronized k a(f fVar) {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k(fVar);
            }
            kVar = a;
        }
        return kVar;
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
            java.lang.String r2 = "select count(*) from load_stat"
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a():int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.List<com.mbridge.msdk.foundation.entity.g>] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c9, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cb, code lost:
        r15 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cc, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00df A[SYNTHETIC, Splitter:B:36:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e7 A[SYNTHETIC, Splitter:B:42:0x00e7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.g> a(int r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
            r0.<init>()     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "select * from load_stat LIMIT "
            r0.append(r1)     // Catch:{ all -> 0x00eb }
            r0.append(r15)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00eb }
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r14.getReadableDatabase()     // Catch:{ Exception -> 0x00d8 }
            android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x00d8 }
            if (r0 == 0) goto L_0x00cf
            int r2 = r0.getCount()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r2 <= 0) goto L_0x00cf
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r2.<init>()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r1 = 0
            r3 = r1
        L_0x002a:
            boolean r4 = r0.moveToNext()     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            if (r4 == 0) goto L_0x00c5
            if (r3 < r15) goto L_0x0034
            goto L_0x00c5
        L_0x0034:
            int r3 = r3 + 1
            java.lang.String r4 = "ad_source_id"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            int r6 = r0.getInt(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "time"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r7 = r0.getString(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "adNum"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            int r8 = r0.getInt(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "unitId"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r9 = r0.getString(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "fb"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            int r10 = r0.getInt(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "timeout"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            int r11 = r0.getInt(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "network_type"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            int r12 = r0.getInt(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "hb"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            int r4 = r0.getInt(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            com.mbridge.msdk.foundation.entity.g r13 = new com.mbridge.msdk.foundation.entity.g     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            r5 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            r13.a((int) r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            r2.add(r13)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = "id"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            int r4 = r0.getInt(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            android.database.sqlite.SQLiteDatabase r5 = r14.getWritableDatabase()     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            if (r5 == 0) goto L_0x002a
            android.database.sqlite.SQLiteDatabase r5 = r14.getWritableDatabase()     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r6 = "load_stat"
            java.lang.String r7 = "id = ?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            r9.<init>()     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            r9.append(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = ""
            r9.append(r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            java.lang.String r4 = r9.toString()     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            r8[r1] = r4     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            r5.delete(r6, r7, r8)     // Catch:{ Exception -> 0x00c7, all -> 0x00c9 }
            goto L_0x002a
        L_0x00c5:
            r1 = r2
            goto L_0x00cf
        L_0x00c7:
            r15 = move-exception
            goto L_0x00cd
        L_0x00c9:
            r15 = move-exception
            goto L_0x00e5
        L_0x00cb:
            r15 = move-exception
            r2 = r1
        L_0x00cd:
            r1 = r0
            goto L_0x00da
        L_0x00cf:
            if (r0 == 0) goto L_0x00e3
            r0.close()     // Catch:{ all -> 0x00eb }
            goto L_0x00e3
        L_0x00d5:
            r15 = move-exception
            r0 = r1
            goto L_0x00e5
        L_0x00d8:
            r15 = move-exception
            r2 = r1
        L_0x00da:
            r15.printStackTrace()     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00e2
            r1.close()     // Catch:{ all -> 0x00eb }
        L_0x00e2:
            r1 = r2
        L_0x00e3:
            monitor-exit(r14)
            return r1
        L_0x00e5:
            if (r0 == 0) goto L_0x00ea
            r0.close()     // Catch:{ all -> 0x00eb }
        L_0x00ea:
            throw r15     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a(int):java.util.List");
    }

    public final synchronized void a(g gVar) {
        if (getWritableDatabase() != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", gVar.c());
            contentValues.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, Integer.valueOf(gVar.b()));
            contentValues.put("adNum", Integer.valueOf(gVar.d()));
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, gVar.e());
            contentValues.put("fb", Integer.valueOf(gVar.f()));
            contentValues.put(CampaignEx.JSON_KEY_HB, Integer.valueOf(gVar.a()));
            contentValues.put("timeout", Integer.valueOf(gVar.g()));
            contentValues.put("network_type", Integer.valueOf(gVar.h()));
            getWritableDatabase().insert("load_stat", (String) null, contentValues);
        }
    }
}
