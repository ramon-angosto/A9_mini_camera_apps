package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.foundation.same.report.BatchReportMessage;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class BatchReportDao extends a<BatchReportMessage> implements NoProGuard, Serializable {
    private static volatile BatchReportDao instance;

    protected BatchReportDao(f fVar) {
        super(fVar);
    }

    public static BatchReportDao getInstance(f fVar) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(fVar);
                }
            }
        }
        return instance;
    }

    public static BatchReportDao getInstance(Context context) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(g.a(context));
                }
            }
        }
        return instance;
    }

    public void addReportMessage(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("report_message", str);
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("uuid", UUID.randomUUID().toString().replace("-", ""));
                contentValues.put("report_state", 0);
                writableDatabase.insert("batch_report", (String) null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0072, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007a, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007b, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a8, code lost:
        if (r3 != null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00aa, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ad, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.mbridge.msdk.foundation.same.report.BatchReportMessage> getBatchReportMessages(long r13) {
        /*
            r12 = this;
            android.database.sqlite.SQLiteDatabase r0 = r12.getReadableDatabase()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "SELECT * FROM "
            r3.append(r4)
            java.lang.String r4 = "batch_report"
            r3.append(r4)
            java.lang.String r5 = " WHERE "
            r3.append(r5)
            java.lang.String r5 = "time"
            r3.append(r5)
            java.lang.String r6 = " <= "
            r3.append(r6)
            r3.append(r13)
            java.lang.String r6 = " AND "
            r3.append(r6)
            java.lang.String r6 = "report_state"
            r3.append(r6)
            java.lang.String r7 = " = 0"
            r3.append(r7)
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007d }
            android.database.Cursor r3 = r0.rawQuery(r3, r1)     // Catch:{ Exception -> 0x007d }
            if (r3 == 0) goto L_0x0074
        L_0x0047:
            boolean r7 = r3.moveToNext()     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            if (r7 == 0) goto L_0x0074
            com.mbridge.msdk.foundation.same.report.BatchReportMessage r7 = new com.mbridge.msdk.foundation.same.report.BatchReportMessage     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            java.lang.String r8 = "uuid"
            int r8 = r3.getColumnIndex(r8)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            java.lang.String r8 = r3.getString(r8)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            java.lang.String r9 = "report_message"
            int r9 = r3.getColumnIndex(r9)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            java.lang.String r9 = r3.getString(r9)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            int r10 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            long r10 = r3.getLong(r10)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            r7.<init>(r8, r9, r10)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            r2.add(r7)     // Catch:{ Exception -> 0x007d, all -> 0x0072 }
            goto L_0x0047
        L_0x0072:
            r13 = move-exception
            goto L_0x00a8
        L_0x0074:
            if (r3 == 0) goto L_0x0081
            r3.close()
            goto L_0x0081
        L_0x007a:
            r13 = move-exception
            r3 = r1
            goto L_0x00a8
        L_0x007d:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x007a }
        L_0x0081:
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x00a3 }
            r3.<init>()     // Catch:{ Exception -> 0x00a3 }
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a3 }
            r3.put(r6, r5)     // Catch:{ Exception -> 0x00a3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a3 }
            r5.<init>()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r6 = "time <= "
            r5.append(r6)     // Catch:{ Exception -> 0x00a3 }
            r5.append(r13)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r13 = r5.toString()     // Catch:{ Exception -> 0x00a3 }
            r0.update(r4, r3, r13, r1)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r13 = move-exception
            r13.printStackTrace()
        L_0x00a7:
            return r2
        L_0x00a8:
            if (r3 == 0) goto L_0x00ad
            r3.close()
        L_0x00ad:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.BatchReportDao.getBatchReportMessages(long):java.util.ArrayList");
    }

    public void updateMessagesReportState(ArrayList<BatchReportMessage> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (arrayList != null && arrayList.size() != 0 && writableDatabase != null) {
            Iterator<BatchReportMessage> it = arrayList.iterator();
            while (it.hasNext()) {
                BatchReportMessage next = it.next();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("report_state", 0);
                    writableDatabase.update("batch_report", contentValues, "uuid = '" + next.getUuid() + "'", (String[]) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteBatchReportMessagesByTimestamp(long j) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase != null) {
            try {
                readableDatabase.rawQuery("delete from " + "batch_report" + " where " + "time" + " <= " + j, (String[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
