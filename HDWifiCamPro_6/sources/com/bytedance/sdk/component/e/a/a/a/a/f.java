package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.b.d;
import com.bytedance.sdk.component.e.a.c.b;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.b.a;
import com.bytedance.sdk.component.e.a.i;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: StatsLogEventRepoImpl */
public class f {
    protected List<String> a = new ArrayList();
    private final Context b;
    private a c;

    public byte a() {
        return 1;
    }

    public byte b() {
        return 2;
    }

    public f(Context context, a aVar) {
        this.b = context;
        this.c = aVar;
        if (this.c == null) {
            this.c = a.c();
        }
    }

    public Context e() {
        return this.b;
    }

    public String c() {
        return i.e().b().d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (0 == 0) goto L_0x002f;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int f() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.e()     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = r10.c()     // Catch:{ all -> 0x0026 }
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ all -> 0x0026 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = com.bytedance.sdk.component.e.a.a.a.c.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0023
            r0.moveToFirst()     // Catch:{ all -> 0x0026 }
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x0026 }
        L_0x0023:
            if (r0 == 0) goto L_0x002f
            goto L_0x0028
        L_0x0026:
            if (r0 == 0) goto L_0x002f
        L_0x0028:
            r0.close()     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            goto L_0x002f
        L_0x002c:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x002f:
            monitor-exit(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.a.f.f():int");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:26|(3:28|29|(1:31))|32|33) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00dc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0051 A[LOOP:0: B:9:0x0051->B:40:0x0051, LOOP_START, SYNTHETIC, Splitter:B:9:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.bytedance.sdk.component.e.a.d.a> a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            android.content.Context r0 = r8.e()     // Catch:{ all -> 0x00df }
            long r0 = com.bytedance.sdk.component.e.a.b.a.a(r9, r0)     // Catch:{ all -> 0x00df }
            r9 = 0
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x002a
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00df }
            if (r2 != 0) goto L_0x002a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r9.<init>()     // Catch:{ all -> 0x00df }
            r9.append(r10)     // Catch:{ all -> 0x00df }
            java.lang.String r10 = " DESC limit "
            r9.append(r10)     // Catch:{ all -> 0x00df }
            r9.append(r0)     // Catch:{ all -> 0x00df }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00df }
        L_0x002a:
            r7 = r9
            java.util.LinkedList r9 = new java.util.LinkedList     // Catch:{ all -> 0x00df }
            r9.<init>()     // Catch:{ all -> 0x00df }
            java.util.List<java.lang.String> r10 = r8.a     // Catch:{ all -> 0x00df }
            r10.clear()     // Catch:{ all -> 0x00df }
            android.content.Context r0 = r8.e()     // Catch:{ all -> 0x00df }
            java.lang.String r1 = r8.c()     // Catch:{ all -> 0x00df }
            java.lang.String r10 = "id"
            java.lang.String r2 = "value"
            java.lang.String r3 = "encrypt"
            java.lang.String[] r2 = new java.lang.String[]{r10, r2, r3}     // Catch:{ all -> 0x00df }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = com.bytedance.sdk.component.e.a.a.a.c.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00df }
            if (r10 == 0) goto L_0x00dd
        L_0x0051:
            boolean r0 = r10.moveToNext()     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x00ac
            java.lang.String r0 = "id"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "encrypt"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0051 }
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x0051 }
            r3 = 1
            if (r2 != r3) goto L_0x0084
            com.bytedance.sdk.component.e.a.i r2 = com.bytedance.sdk.component.e.a.i.e()     // Catch:{ all -> 0x0051 }
            com.bytedance.sdk.component.e.a.f r2 = r2.m()     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r2.a((java.lang.String) r1)     // Catch:{ all -> 0x0051 }
        L_0x0084:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x0090
            java.util.List<java.lang.String> r1 = r8.a     // Catch:{ all -> 0x0051 }
            r1.add(r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0051
        L_0x0090:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0051 }
            r2.<init>(r1)     // Catch:{ all -> 0x0051 }
            com.bytedance.sdk.component.e.a.d.a.a r1 = new com.bytedance.sdk.component.e.a.d.a.a     // Catch:{ all -> 0x0051 }
            r1.<init>((java.lang.String) r0, (org.json.JSONObject) r2)     // Catch:{ all -> 0x0051 }
            byte r0 = r8.b()     // Catch:{ all -> 0x0051 }
            r1.b((byte) r0)     // Catch:{ all -> 0x0051 }
            byte r0 = r8.a()     // Catch:{ all -> 0x0051 }
            r1.a((byte) r0)     // Catch:{ all -> 0x0051 }
            r9.add(r1)     // Catch:{ all -> 0x0051 }
            goto L_0x0051
        L_0x00ac:
            if (r10 == 0) goto L_0x00dd
            r10.close()     // Catch:{ Exception -> 0x00dd }
            java.util.List<java.lang.String> r10 = r8.a     // Catch:{ Exception -> 0x00dd }
            boolean r10 = r10.isEmpty()     // Catch:{ Exception -> 0x00dd }
            if (r10 != 0) goto L_0x00dd
            java.util.List<java.lang.String> r10 = r8.a     // Catch:{ Exception -> 0x00dd }
            r8.a((java.util.List<java.lang.String>) r10)     // Catch:{ Exception -> 0x00dd }
            java.util.List<java.lang.String> r10 = r8.a     // Catch:{ Exception -> 0x00dd }
            r10.clear()     // Catch:{ Exception -> 0x00dd }
            goto L_0x00dd
        L_0x00c4:
            r9 = move-exception
            if (r10 == 0) goto L_0x00dc
            r10.close()     // Catch:{ Exception -> 0x00dc }
            java.util.List<java.lang.String> r10 = r8.a     // Catch:{ Exception -> 0x00dc }
            boolean r10 = r10.isEmpty()     // Catch:{ Exception -> 0x00dc }
            if (r10 != 0) goto L_0x00dc
            java.util.List<java.lang.String> r10 = r8.a     // Catch:{ Exception -> 0x00dc }
            r8.a((java.util.List<java.lang.String>) r10)     // Catch:{ Exception -> 0x00dc }
            java.util.List<java.lang.String> r10 = r8.a     // Catch:{ Exception -> 0x00dc }
            r10.clear()     // Catch:{ Exception -> 0x00dc }
        L_0x00dc:
            throw r9     // Catch:{ all -> 0x00df }
        L_0x00dd:
            monitor-exit(r8)
            return r9
        L_0x00df:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.a.f.a(int, java.lang.String):java.util.List");
    }

    /* access modifiers changed from: protected */
    public synchronized void a(List<String> list) {
        c.a("states repo delete: " + list.size());
        com.bytedance.sdk.component.e.a.a.a.c.a(e(), "DELETE FROM " + c() + " WHERE " + a("id", list, 1000, true));
        b.a(d.d.Y(), list.size());
    }

    public synchronized List<com.bytedance.sdk.component.e.a.d.a> a(String str) {
        if (this.c == null) {
            return new ArrayList();
        }
        return a(this.c.b(), str);
    }

    public synchronized void a(com.bytedance.sdk.component.e.a.d.a aVar) {
        JSONObject g = aVar.g();
        if (g != null && !TextUtils.isEmpty(aVar.c())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", aVar.c());
            String b2 = i.e().m().b(g.toString());
            if (!TextUtils.isEmpty(b2)) {
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, b2);
                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("retry", 0);
                contentValues.put("encrypt", 1);
                com.bytedance.sdk.component.e.a.a.a.c.a(e(), c(), contentValues);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(java.util.List<com.bytedance.sdk.component.e.a.d.a> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x005c
            int r0 = r5.size()     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x000a
            goto L_0x005c
        L_0x000a:
            java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x0059 }
            r0.<init>()     // Catch:{ all -> 0x0059 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0059 }
        L_0x0013:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x0059 }
            com.bytedance.sdk.component.e.a.d.a r1 = (com.bytedance.sdk.component.e.a.d.a) r1     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = r1.c()     // Catch:{ all -> 0x0059 }
            r0.add(r2)     // Catch:{ all -> 0x0059 }
            com.bytedance.sdk.component.e.a.c.a.j(r1)     // Catch:{ all -> 0x0059 }
            goto L_0x0013
        L_0x002a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r5.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "DELETE FROM "
            r5.append(r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r4.c()     // Catch:{ all -> 0x0059 }
            r5.append(r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = " WHERE "
            r5.append(r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "id"
            r2 = 1000(0x3e8, float:1.401E-42)
            r3 = 1
            java.lang.String r0 = a(r1, r0, r2, r3)     // Catch:{ all -> 0x0059 }
            r5.append(r0)     // Catch:{ all -> 0x0059 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0059 }
            android.content.Context r0 = r4.e()     // Catch:{ all -> 0x0059 }
            com.bytedance.sdk.component.e.a.a.a.c.a(r0, r5)     // Catch:{ all -> 0x0059 }
            monitor-exit(r4)
            return
        L_0x0059:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x005c:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.a.f.b(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.bytedance.sdk.component.e.a.d.b.a r3 = r2.c     // Catch:{ all -> 0x0017 }
            r0 = 0
            if (r3 != 0) goto L_0x0008
            monitor-exit(r2)
            return r0
        L_0x0008:
            int r3 = r2.f()     // Catch:{ all -> 0x0017 }
            com.bytedance.sdk.component.e.a.d.b.a r1 = r2.c     // Catch:{ all -> 0x0017 }
            int r1 = r1.a()     // Catch:{ all -> 0x0017 }
            if (r3 < r1) goto L_0x0015
            r0 = 1
        L_0x0015:
            monitor-exit(r2)
            return r0
        L_0x0017:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.a.f.a(int):boolean");
    }

    public static String g() {
        return "CREATE TABLE IF NOT EXISTS " + i.e().b().d() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + AppMeasurementSdk.ConditionalUserProperty.VALUE + " TEXT ," + "gen_time" + " TEXT , " + "retry" + " INTEGER default 0 , " + "encrypt" + " INTEGER default 0" + ")";
    }

    private static String a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String a2 = a(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a2);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return a(sb2, str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
