package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import java.util.List;

/* compiled from: BidReplaceCampignDao */
public class b extends a {
    private static volatile b a;

    private b(f fVar) {
        super(fVar);
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(g.a(context));
                }
            }
        }
        return a;
    }

    public final void a(String str, List<CampaignEx> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            try {
                String requestId = list.get(0).getRequestId();
                String encryptPrice = list.get(0).getEncryptPrice();
                String campaignUnitId = list.get(0).getCampaignUnitId();
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("bid_unit_id", campaignUnitId);
                    contentValues.put("expect_bid_token", str);
                    contentValues.put("expect_encrypt_price", "");
                    contentValues.put("real_request_id", requestId);
                    contentValues.put("real_encrypt_price", encryptPrice);
                    contentValues.put("real_token_rule", 1);
                    contentValues.put("is_replace", 0);
                    writableDatabase.insert("bid_replace_campaign", (String) null, contentValues);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_replace", 1);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id" + " = '" + str2 + "' AND " + "expect_bid_token" + " = '" + str + "'", (String[]) null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final int a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expect_encrypt_price", str3);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id" + " = '" + str2 + "' AND " + "expect_bid_token" + " = '" + str + "'", (String[]) null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: type inference failed for: r9v5, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r9v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c7, code lost:
        if (r9 != 0) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00de, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.entity.c> b(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L_0x0013
            return r0
        L_0x0013:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT * FROM bid_replace_campaign WHERE "
            r1.append(r2)
            java.lang.String r2 = "bid_unit_id"
            r1.append(r2)
            java.lang.String r2 = " = '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = "' AND "
            r1.append(r9)
            java.lang.String r9 = "real_request_id"
            r1.append(r9)
            java.lang.String r9 = " = '"
            r1.append(r9)
            r1.append(r10)
            java.lang.String r9 = "'"
            r1.append(r9)
            r9 = 0
            java.lang.Object r10 = new java.lang.Object     // Catch:{ Exception -> 0x00cf }
            r10.<init>()     // Catch:{ Exception -> 0x00cf }
            monitor-enter(r10)     // Catch:{ Exception -> 0x00cf }
            android.database.sqlite.SQLiteDatabase r2 = r8.getReadableDatabase()     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ca }
            android.database.Cursor r9 = r2.rawQuery(r1, r9)     // Catch:{ all -> 0x00ca }
            monitor-exit(r10)     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x00c7
            int r10 = r9.getCount()     // Catch:{ Exception -> 0x00cf }
            if (r10 <= 0) goto L_0x00c7
        L_0x005d:
            boolean r10 = r9.moveToNext()     // Catch:{ Exception -> 0x00cf }
            if (r10 == 0) goto L_0x00c7
            com.mbridge.msdk.foundation.entity.c r10 = new com.mbridge.msdk.foundation.entity.c     // Catch:{ Exception -> 0x00cf }
            r10.<init>()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = "bid_unit_id"
            int r1 = r9.getColumnIndex(r1)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r2 = "expect_bid_token"
            int r2 = r9.getColumnIndex(r2)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r3 = "expect_encrypt_price"
            int r3 = r9.getColumnIndex(r3)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = "real_request_id"
            int r4 = r9.getColumnIndex(r4)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r5 = "real_encrypt_price"
            int r5 = r9.getColumnIndex(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r6 = "real_token_rule"
            int r6 = r9.getColumnIndex(r6)     // Catch:{ Exception -> 0x00cf }
            int r6 = r9.getInt(r6)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r7 = "is_replace"
            int r7 = r9.getColumnIndex(r7)     // Catch:{ Exception -> 0x00cf }
            int r7 = r9.getInt(r7)     // Catch:{ Exception -> 0x00cf }
            r10.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00cf }
            r10.b((java.lang.String) r2)     // Catch:{ Exception -> 0x00cf }
            r10.c(r3)     // Catch:{ Exception -> 0x00cf }
            r10.d(r4)     // Catch:{ Exception -> 0x00cf }
            r10.e(r5)     // Catch:{ Exception -> 0x00cf }
            r10.a((int) r6)     // Catch:{ Exception -> 0x00cf }
            r10.b((int) r7)     // Catch:{ Exception -> 0x00cf }
            r0.add(r10)     // Catch:{ Exception -> 0x00cf }
            goto L_0x005d
        L_0x00c7:
            if (r9 == 0) goto L_0x00de
            goto L_0x00db
        L_0x00ca:
            r1 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00ca }
            throw r1     // Catch:{ Exception -> 0x00cf }
        L_0x00cd:
            r10 = move-exception
            goto L_0x00df
        L_0x00cf:
            r10 = move-exception
            java.lang.String r1 = "BidReplaceCampaignDao"
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x00cd }
            com.mbridge.msdk.foundation.tools.q.d(r1, r10)     // Catch:{ all -> 0x00cd }
            if (r9 == 0) goto L_0x00de
        L_0x00db:
            r9.close()
        L_0x00de:
            return r0
        L_0x00df:
            if (r9 == 0) goto L_0x00e4
            r9.close()
        L_0x00e4:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.b.b(java.lang.String, java.lang.String):java.util.List");
    }

    public final int a(String str) {
        try {
            String str2 = "real_request_id = '" + str + "' AND " + "is_replace" + " = " + 1;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", str2, (String[]) null);
        } catch (Exception e) {
            q.d("BidReplaceCampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }

    public final int a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "is_replace = 0", (String[]) null);
        } catch (Exception e) {
            q.d("BidReplaceCampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }
}
