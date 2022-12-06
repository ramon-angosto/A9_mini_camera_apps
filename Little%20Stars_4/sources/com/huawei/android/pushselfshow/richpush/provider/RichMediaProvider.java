package com.huawei.android.pushselfshow.richpush.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.a.b;

public class RichMediaProvider extends ContentProvider {
    private static final UriMatcher b = new UriMatcher(-1);
    b a = null;

    public static class a {
        public static final Uri a = Uri.parse("content://com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider/support_porvider");
        public static final Uri b = Uri.parse("content://com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider/insert_bmp");
        public static final Uri c = Uri.parse("content://com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider/update_bmp");
        public static final Uri d = Uri.parse("content://com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider/query_bmp");
        public static final Uri e = Uri.parse("content://com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider/insert_msg");
        public static final Uri f = Uri.parse("content://com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider/query_msg");
        public static final Uri g = Uri.parse("content://com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider/delete_msg");
    }

    static {
        b.addURI("com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider", "support_porvider", 1);
        b.addURI("com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider", "insert_bmp", 2);
        b.addURI("com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider", "update_bmp", 3);
        b.addURI("com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider", "query_bmp", 4);
        b.addURI("com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider", "insert_msg", 5);
        b.addURI("com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider", "query_msg", 6);
        b.addURI("com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider", "delete_msg", 7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r0 = r2;
        r10 = r14;
        r14 = r13;
        r13 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        r13 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:9:0x002f, B:21:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.net.Uri a(android.database.sqlite.SQLiteDatabase r12, java.lang.String r13, android.content.ContentValues r14, android.net.Uri r15) {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "enter insertToDb, table is:"
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PushSelfShowLog_RichMediaProvider"
            com.huawei.android.pushagent.c.a.e.a(r1, r0)
            r0 = 0
            if (r12 != 0) goto L_0x001f
            java.lang.String r12 = "db is null"
            com.huawei.android.pushagent.c.a.e.d(r1, r12)
            return r0
        L_0x001f:
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            r3 = r13
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0076 }
            if (r2 != 0) goto L_0x003b
            java.lang.String r13 = "cursor is null"
            com.huawei.android.pushagent.c.a.e.d(r1, r13)     // Catch:{ Exception -> 0x006f, all -> 0x006d }
            if (r2 == 0) goto L_0x0037
            r2.close()
        L_0x0037:
            r12.close()
            return r0
        L_0x003b:
            int r3 = r2.getCount()     // Catch:{ Exception -> 0x006f, all -> 0x006d }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 >= r4) goto L_0x0063
            long r13 = r12.insert(r13, r0, r14)     // Catch:{ Exception -> 0x006f, all -> 0x006d }
            r3 = 0
            int r5 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0063
            android.net.Uri r13 = android.content.ContentUris.withAppendedId(r15, r13)     // Catch:{ Exception -> 0x006f, all -> 0x006d }
            android.content.Context r14 = r11.getContext()     // Catch:{ Exception -> 0x005d, all -> 0x006d }
            android.content.ContentResolver r14 = r14.getContentResolver()     // Catch:{ Exception -> 0x005d, all -> 0x006d }
            r14.notifyChange(r13, r0)     // Catch:{ Exception -> 0x005d, all -> 0x006d }
            goto L_0x0064
        L_0x005d:
            r14 = move-exception
            r0 = r2
            r10 = r14
            r14 = r13
            r13 = r10
            goto L_0x0078
        L_0x0063:
            r13 = r0
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            r12.close()
            goto L_0x0088
        L_0x006d:
            r13 = move-exception
            goto L_0x009d
        L_0x006f:
            r13 = move-exception
            r14 = r0
            r0 = r2
            goto L_0x0078
        L_0x0073:
            r13 = move-exception
            r2 = r0
            goto L_0x009d
        L_0x0076:
            r13 = move-exception
            r14 = r0
        L_0x0078:
            java.lang.String r15 = r13.toString()     // Catch:{ all -> 0x0073 }
            com.huawei.android.pushagent.c.a.e.c(r1, r15, r13)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0084
            r0.close()
        L_0x0084:
            r12.close()
            r13 = r14
        L_0x0088:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "resultUri is:"
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.huawei.android.pushagent.c.a.e.a(r1, r12)
            return r13
        L_0x009d:
            if (r2 == 0) goto L_0x00a2
            r2.close()
        L_0x00a2:
            r12.close()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider.a(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, android.net.Uri):android.net.Uri");
    }

    private boolean a(String str) {
        if (str == null || str.length() == 0 || !str.contains("'")) {
            return false;
        }
        e.d("PushSelfShowLog_RichMediaProvider", str + " can be reject, should check sql");
        return true;
    }

    private boolean a(String[] strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            for (String a2 : strArr) {
                if (a(a2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String str2;
        int match = b.match(uri);
        e.a("PushSelfShowLog_RichMediaProvider", "uri is:" + uri + ",match result: " + match);
        b bVar = this.a;
        int i = 0;
        if (bVar == null) {
            str2 = "dbHelper is null";
        } else if (match != 7) {
            str2 = "uri not match!";
        } else {
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                str2 = "db is null";
            } else {
                try {
                    i = writableDatabase.delete("pushmsg", "_id = ?", strArr);
                    getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
                } catch (Exception e) {
                    e.c("PushSelfShowLog_RichMediaProvider", e.toString(), e);
                } catch (Throwable th) {
                    writableDatabase.close();
                    throw th;
                }
                writableDatabase.close();
                return i;
            }
        }
        e.d("PushSelfShowLog_RichMediaProvider", str2);
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase;
        String str;
        String str2;
        int match = b.match(uri);
        e.a("PushSelfShowLog_RichMediaProvider", "uri is:" + uri + ",match result: " + match);
        b bVar = this.a;
        if (bVar == null) {
            str2 = "dbHelper is null";
        } else {
            if (match == 2) {
                writableDatabase = bVar.getWritableDatabase();
                str = "notify";
            } else if (match != 5) {
                str2 = "uri not match!";
            } else {
                writableDatabase = bVar.getWritableDatabase();
                str = "pushmsg";
            }
            return a(writableDatabase, str, contentValues, uri);
        }
        e.d("PushSelfShowLog_RichMediaProvider", str2);
        return null;
    }

    public boolean onCreate() {
        e.a("PushSelfShowLog_RichMediaProvider", "onCreate");
        this.a = b.a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        Uri uri2 = uri;
        String str4 = str;
        if (a(str4) || a(strArr)) {
            str3 = "in query selection:" + str4 + " or projection is invalied";
        } else {
            int match = b.match(uri2);
            e.a("PushSelfShowLog_RichMediaProvider", "uri is:" + uri2 + ",match result: " + match);
            b bVar = this.a;
            if (bVar == null) {
                str3 = "dbHelper is null";
            } else {
                SQLiteDatabase readableDatabase = bVar.getReadableDatabase();
                if (readableDatabase == null) {
                    str3 = "db is null";
                } else if (match != 1) {
                    if (match == 4) {
                        String[] strArr3 = strArr2;
                        try {
                            return readableDatabase.query("notify", new String[]{"bmp"}, "url = ?", strArr2, (String) null, (String) null, str2, (String) null);
                        } catch (Exception e) {
                            e.c("PushSelfShowLog_RichMediaProvider", e.toString(), e);
                        }
                    } else if (match != 6) {
                        e.d("PushSelfShowLog_RichMediaProvider", "uri not match!");
                    } else {
                        try {
                            return readableDatabase.rawQuery("SELECT pushmsg._id,pushmsg.msg,pushmsg.token,pushmsg.url,notify.bmp  FROM pushmsg LEFT OUTER JOIN notify ON pushmsg.url = notify.url and pushmsg.url = ? order by pushmsg._id desc limit 1000;", strArr2);
                        } catch (Exception e2) {
                            Exception exc = e2;
                            e.c("PushSelfShowLog_RichMediaProvider", exc.toString(), exc);
                        }
                    }
                    return null;
                } else {
                    MatrixCursor matrixCursor = new MatrixCursor(new String[]{"isSupport"});
                    matrixCursor.addRow(new Integer[]{1});
                    return matrixCursor;
                }
            }
        }
        e.d("PushSelfShowLog_RichMediaProvider", str3);
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        int match = b.match(uri);
        e.a("PushSelfShowLog_RichMediaProvider", "uri is:" + uri + ",match result: " + match);
        b bVar = this.a;
        int i = 0;
        if (bVar == null) {
            str2 = "dbHelper is null";
        } else if (match != 3) {
            str2 = "uri not match!";
        } else {
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                str2 = "db is null";
            } else {
                try {
                    i = writableDatabase.update("notify", contentValues, "url = ?", strArr);
                    getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
                } catch (Exception e) {
                    e.c("PushSelfShowLog_RichMediaProvider", e.toString(), e);
                } catch (Throwable th) {
                    writableDatabase.close();
                    throw th;
                }
                writableDatabase.close();
                return i;
            }
        }
        e.d("PushSelfShowLog_RichMediaProvider", str2);
        return 0;
    }
}
