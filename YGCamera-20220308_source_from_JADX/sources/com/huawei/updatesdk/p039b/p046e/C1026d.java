package com.huawei.updatesdk.p039b.p046e;

import android.os.AsyncTask;

/* renamed from: com.huawei.updatesdk.b.e.d */
public class C1026d extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    private String f1386a = null;

    /* renamed from: b */
    private String f1387b;

    public C1026d(String str, String str2) {
        this.f1386a = str;
        this.f1387b = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A[SYNTHETIC, Splitter:B:17:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008b A[SYNTHETIC, Splitter:B:26:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098 A[SYNTHETIC, Splitter:B:34:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doInBackground(java.lang.Void... r11) {
        /*
            r10 = this;
            java.lang.String r11 = "cursor Execption"
            java.lang.String r0 = "GetAccountZoneTask"
            java.lang.String r1 = r10.f1386a
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r1 = r10.f1386a
            android.net.Uri r4 = android.net.Uri.parse(r1)
            com.huawei.updatesdk.a.b.a.a r1 = com.huawei.updatesdk.p025a.p034b.p035a.C0985a.m1757c()     // Catch:{ Exception -> 0x006f }
            android.content.Context r1 = r1.mo14892a()     // Catch:{ Exception -> 0x006f }
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch:{ Exception -> 0x006f }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x006f }
            if (r1 == 0) goto L_0x005f
            boolean r3 = r1.moveToFirst()     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            if (r3 == 0) goto L_0x005f
            java.lang.String r3 = "homecountry"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            java.lang.String r2 = r1.getString(r3)     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            com.huawei.updatesdk.service.otaupdate.f r3 = com.huawei.updatesdk.service.otaupdate.C1085f.m2106f()     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            r3.mo15202a(r2)     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            com.huawei.updatesdk.b.b.a r3 = com.huawei.updatesdk.p039b.p043b.C1003a.m1831d()     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            java.lang.String r4 = r10.f1387b     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            r3.mo14957a((java.lang.String) r4, (long) r5)     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            com.huawei.updatesdk.b.b.a r3 = com.huawei.updatesdk.p039b.p043b.C1003a.m1831d()     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            java.lang.String r4 = r10.f1387b     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            r3.mo14961b(r4, r2)     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
            goto L_0x0064
        L_0x0058:
            r2 = move-exception
            goto L_0x0096
        L_0x005a:
            r3 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
            goto L_0x0071
        L_0x005f:
            java.lang.String r3 = "cursor == null: "
            com.huawei.updatesdk.p025a.p026a.C0964a.m1666a(r0, r3)     // Catch:{ Exception -> 0x005a, all -> 0x0058 }
        L_0x0064:
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ Exception -> 0x0090 }
            goto L_0x0095
        L_0x006a:
            r1 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
            goto L_0x0096
        L_0x006f:
            r3 = move-exception
            r1 = r2
        L_0x0071:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r4.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "close cursor error: "
            r4.append(r5)     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006a }
            r4.append(r3)     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x006a }
            com.huawei.updatesdk.p025a.p026a.C0964a.m1666a(r0, r3)     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ Exception -> 0x008f }
            goto L_0x0094
        L_0x008f:
            r2 = r1
        L_0x0090:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r0, r11)
            goto L_0x0095
        L_0x0094:
            r2 = r1
        L_0x0095:
            return r2
        L_0x0096:
            if (r1 == 0) goto L_0x009f
            r1.close()     // Catch:{ Exception -> 0x009c }
            goto L_0x009f
        L_0x009c:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r0, r11)
        L_0x009f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p039b.p046e.C1026d.doInBackground(java.lang.Void[]):java.lang.String");
    }
}
