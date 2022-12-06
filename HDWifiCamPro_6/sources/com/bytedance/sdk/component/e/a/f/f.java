package com.bytedance.sdk.component.e.a.f;

import android.content.ContentValues;
import android.content.Context;
import com.bytedance.sdk.component.e.a.a.a.c;

/* compiled from: TrackRetryRepertoryImpl */
public class f implements e {
    private Context a;

    public f(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        if (r1 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r1 != null) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.bytedance.sdk.component.e.a.f.d> a() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x006b }
            r0.<init>()     // Catch:{ all -> 0x006b }
            android.content.Context r1 = r9.a     // Catch:{ all -> 0x006b }
            java.lang.String r2 = "trackurl"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.e.a.a.a.c.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0069
        L_0x0016:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0052
            java.lang.String r2 = "id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = "url"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "replaceholder"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ all -> 0x0058 }
            int r4 = r1.getInt(r4)     // Catch:{ all -> 0x0058 }
            if (r4 <= 0) goto L_0x003e
            r4 = 1
            goto L_0x003f
        L_0x003e:
            r4 = 0
        L_0x003f:
            java.lang.String r5 = "retry"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ all -> 0x0058 }
            int r5 = r1.getInt(r5)     // Catch:{ all -> 0x0058 }
            com.bytedance.sdk.component.e.a.f.d r6 = new com.bytedance.sdk.component.e.a.f.d     // Catch:{ all -> 0x0058 }
            r6.<init>(r2, r3, r4, r5)     // Catch:{ all -> 0x0058 }
            r0.add(r6)     // Catch:{ all -> 0x0058 }
            goto L_0x0016
        L_0x0052:
            if (r1 == 0) goto L_0x0069
        L_0x0054:
            r1.close()     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x0058:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ all -> 0x005f }
            r1 = 0
            goto L_0x0066
        L_0x005f:
            r0 = move-exception
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ all -> 0x006b }
        L_0x0065:
            throw r0     // Catch:{ all -> 0x006b }
        L_0x0066:
            if (r1 == 0) goto L_0x0069
            goto L_0x0054
        L_0x0069:
            monitor-exit(r9)
            return r0
        L_0x006b:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.f.f.a():java.util.List");
    }

    public synchronized void a(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.a());
        contentValues.put("url", dVar.b());
        contentValues.put("replaceholder", Integer.valueOf(dVar.c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(dVar.d()));
        c.a(this.a, "trackurl", contentValues);
    }

    public synchronized void b(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.a());
        contentValues.put("url", dVar.b());
        contentValues.put("replaceholder", Integer.valueOf(dVar.c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(dVar.d()));
        c.a(this.a, "trackurl", contentValues, "id=?", new String[]{dVar.a()});
    }

    public synchronized void c(d dVar) {
        c.a(this.a, "trackurl", "id=?", new String[]{dVar.a()});
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS " + "trackurl" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + "url" + " TEXT ," + "replaceholder" + " INTEGER default 0, " + "retry" + " INTEGER default 0" + ")";
    }
}
