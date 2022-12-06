package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;

/* compiled from: UnitIDDao */
public final class n extends a<g> {
    private static n a;

    private n(f fVar) {
        super(fVar);
    }

    public static synchronized n a(f fVar) {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new n(fVar);
            }
            nVar = a;
        }
        return nVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.List<com.mbridge.msdk.foundation.entity.h>] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A[SYNTHETIC, Splitter:B:31:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071 A[SYNTHETIC, Splitter:B:37:0x0071] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.h> a(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r0.<init>()     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = "select * from unit_id WHERE ad_type = "
            r0.append(r1)     // Catch:{ all -> 0x0075 }
            r0.append(r6)     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0075 }
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x0062 }
            android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x0062 }
            if (r0 == 0) goto L_0x0059
            int r2 = r0.getCount()     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            if (r2 <= 0) goto L_0x0059
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            int r3 = r0.getCount()     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
        L_0x002c:
            boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            if (r1 == 0) goto L_0x004f
            java.lang.String r1 = "placement_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            java.lang.String r3 = "unitId"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            com.mbridge.msdk.foundation.entity.h r4 = new com.mbridge.msdk.foundation.entity.h     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            r4.<init>(r1, r3, r6)     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            r2.add(r4)     // Catch:{ Exception -> 0x0051, all -> 0x0053 }
            goto L_0x002c
        L_0x004f:
            r1 = r2
            goto L_0x0059
        L_0x0051:
            r6 = move-exception
            goto L_0x0057
        L_0x0053:
            r6 = move-exception
            goto L_0x006f
        L_0x0055:
            r6 = move-exception
            r2 = r1
        L_0x0057:
            r1 = r0
            goto L_0x0064
        L_0x0059:
            if (r0 == 0) goto L_0x006d
            r0.close()     // Catch:{ all -> 0x0075 }
            goto L_0x006d
        L_0x005f:
            r6 = move-exception
            r0 = r1
            goto L_0x006f
        L_0x0062:
            r6 = move-exception
            r2 = r1
        L_0x0064:
            r6.printStackTrace()     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x006c
            r1.close()     // Catch:{ all -> 0x0075 }
        L_0x006c:
            r1 = r2
        L_0x006d:
            monitor-exit(r5)
            return r1
        L_0x006f:
            if (r0 == 0) goto L_0x0074
            r0.close()     // Catch:{ all -> 0x0075 }
        L_0x0074:
            throw r6     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(int):java.util.List");
    }

    public final synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public final synchronized void a(String str, String str2, int i) {
        if (getWritableDatabase() != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", str);
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
            contentValues.put("ad_type", Integer.valueOf(i));
            getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, (String) null, contentValues);
        }
    }
}
