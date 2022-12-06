package com.huawei.android.pushselfshow.richpush.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.huawei.android.pushselfshow.utils.a.b;

public class e implements a {
    private String a;

    public e() {
        this.a = null;
        this.a = null;
    }

    protected e(String str) {
        this.a = null;
        this.a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r1 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006f, code lost:
        if (r1 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0071, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0074, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0077, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r9, android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, android.content.ContentValues r12) throws java.lang.Exception {
        /*
            java.lang.String r0 = "PushSelfShowLog"
            if (r9 != 0) goto L_0x000a
            java.lang.String r9 = "context is null"
        L_0x0006:
            com.huawei.android.pushagent.c.a.e.d(r0, r9)
            return
        L_0x000a:
            if (r10 != 0) goto L_0x000f
            java.lang.String r9 = "db is null"
            goto L_0x0006
        L_0x000f:
            boolean r9 = android.text.TextUtils.isEmpty(r11)
            if (r9 == 0) goto L_0x0018
            java.lang.String r9 = "table is null"
            goto L_0x0006
        L_0x0018:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r1 = r10
            r2 = r11
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0065, all -> 0x0061 }
            if (r1 != 0) goto L_0x0035
            java.lang.String r9 = "cursor is null"
            com.huawei.android.pushagent.c.a.e.d(r0, r9)     // Catch:{ Exception -> 0x005f }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            r10.close()
            return
        L_0x0035:
            int r2 = r1.getCount()     // Catch:{ Exception -> 0x005f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f }
            r3.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "queryAndInsert, exist rowNumber:"
            r3.append(r4)     // Catch:{ Exception -> 0x005f }
            r3.append(r2)     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x005f }
            com.huawei.android.pushagent.c.a.e.a(r0, r3)     // Catch:{ Exception -> 0x005f }
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 >= r3) goto L_0x0055
            r10.insert(r11, r9, r12)     // Catch:{ Exception -> 0x005f }
            goto L_0x005a
        L_0x0055:
            java.lang.String r9 = "queryAndInsert failed"
            com.huawei.android.pushagent.c.a.e.d(r0, r9)     // Catch:{ Exception -> 0x005f }
        L_0x005a:
            if (r1 == 0) goto L_0x0074
            goto L_0x0071
        L_0x005d:
            r9 = move-exception
            goto L_0x0078
        L_0x005f:
            r9 = move-exception
            goto L_0x0068
        L_0x0061:
            r11 = move-exception
            r1 = r9
            r9 = r11
            goto L_0x0078
        L_0x0065:
            r11 = move-exception
            r1 = r9
            r9 = r11
        L_0x0068:
            java.lang.String r11 = r9.toString()     // Catch:{ all -> 0x005d }
            com.huawei.android.pushagent.c.a.e.c(r0, r11, r9)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0074
        L_0x0071:
            r1.close()
        L_0x0074:
            r10.close()
            return
        L_0x0078:
            if (r1 == 0) goto L_0x007d
            r1.close()
        L_0x007d:
            r10.close()
            goto L_0x0082
        L_0x0081:
            throw r9
        L_0x0082:
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.a.e.a(android.content.Context, android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues):void");
    }

    public Cursor a(Context context, Uri uri, String str, String[] strArr) throws Exception {
        SQLiteDatabase readableDatabase = a(context).getReadableDatabase();
        if (readableDatabase == null) {
            return null;
        }
        try {
            return readableDatabase.rawQuery(str, strArr);
        } catch (Exception e) {
            com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", e.toString(), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public b a(Context context) {
        String str = this.a;
        return str == null ? b.a(context) : b.a(context, str);
    }

    public void a(Context context, Uri uri, String str, ContentValues contentValues) throws Exception {
        a(context, a(context).getWritableDatabase(), str, contentValues);
    }

    public void a(Context context, Uri uri, String str, String str2, String[] strArr) throws Exception {
        SQLiteDatabase writableDatabase = a(context).getWritableDatabase();
        if (writableDatabase != null) {
            try {
                writableDatabase.delete(str, str2, strArr);
            } catch (Exception e) {
                com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", e.toString(), e);
            } catch (Throwable th) {
                writableDatabase.close();
                throw th;
            }
            writableDatabase.close();
        }
    }
}
