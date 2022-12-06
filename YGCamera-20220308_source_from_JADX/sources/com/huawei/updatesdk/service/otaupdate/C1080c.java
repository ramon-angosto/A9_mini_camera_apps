package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p039b.p049h.C1037b;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.updatesdk.service.otaupdate.c */
public class C1080c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f1469a;

    /* renamed from: com.huawei.updatesdk.service.otaupdate.c$a */
    public interface C1081a {
        /* renamed from: a */
        void mo15165a(Boolean bool);
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.c$b */
    private static class C1082b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a */
        C1081a f1470a;

        public C1082b(C1081a aVar) {
            this.f1470a = aVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x006d, code lost:
            if (r1 != null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
            if (r1 == null) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b("AutoUpdateUtil", "cursor Execption");
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.Void... r12) {
            /*
                r11 = this;
                java.lang.String r12 = "cursor Execption"
                java.lang.String r0 = "AutoUpdateUtil"
                r1 = 0
                r2 = 0
                com.huawei.updatesdk.a.b.a.a r3 = com.huawei.updatesdk.p025a.p034b.p035a.C0985a.m1757c()     // Catch:{ Exception -> 0x0075 }
                android.content.Context r3 = r3.mo14892a()     // Catch:{ Exception -> 0x0075 }
                java.lang.String r4 = com.huawei.updatesdk.service.otaupdate.C1080c.f1469a     // Catch:{ Exception -> 0x0075 }
                android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0075 }
                android.content.ContentResolver r5 = r3.getContentResolver()     // Catch:{ Exception -> 0x0075 }
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                android.database.Cursor r1 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0075 }
                if (r1 == 0) goto L_0x0068
                boolean r3 = r1.moveToFirst()     // Catch:{ Exception -> 0x0075 }
                if (r3 == 0) goto L_0x0068
                java.lang.String r3 = "isagree"
                int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x0075 }
                java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x0075 }
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0075 }
                boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x0075 }
                java.lang.String r4 = "isopenautoupdate"
                int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x0075 }
                java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x0075 }
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0075 }
                boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x0075 }
                java.lang.String r5 = "isneverreminder"
                int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x0075 }
                java.lang.String r5 = r1.getString(r5)     // Catch:{ Exception -> 0x0075 }
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0075 }
                boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x0075 }
                if (r3 == 0) goto L_0x006d
                if (r4 != 0) goto L_0x006d
                if (r5 != 0) goto L_0x006d
                r2 = 1
                goto L_0x006d
            L_0x0068:
                java.lang.String r3 = "cursor == null"
                com.huawei.updatesdk.p025a.p026a.C0964a.m1666a(r0, r3)     // Catch:{ Exception -> 0x0075 }
            L_0x006d:
                if (r1 == 0) goto L_0x0094
            L_0x006f:
                r1.close()     // Catch:{ Exception -> 0x0091 }
                goto L_0x0094
            L_0x0073:
                r2 = move-exception
                goto L_0x0099
            L_0x0075:
                r3 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r4.<init>()     // Catch:{ all -> 0x0073 }
                java.lang.String r5 = "close cursor error: "
                r4.append(r5)     // Catch:{ all -> 0x0073 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0073 }
                r4.append(r3)     // Catch:{ all -> 0x0073 }
                java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0073 }
                com.huawei.updatesdk.p025a.p026a.C0964a.m1666a(r0, r3)     // Catch:{ all -> 0x0073 }
                if (r1 == 0) goto L_0x0094
                goto L_0x006f
            L_0x0091:
                com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r0, r12)
            L_0x0094:
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r2)
                return r12
            L_0x0099:
                if (r1 == 0) goto L_0x00a2
                r1.close()     // Catch:{ Exception -> 0x009f }
                goto L_0x00a2
            L_0x009f:
                com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r0, r12)
            L_0x00a2:
                goto L_0x00a4
            L_0x00a3:
                throw r2
            L_0x00a4:
                goto L_0x00a3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.service.otaupdate.C1080c.C1082b.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            C1081a aVar = this.f1470a;
            if (aVar != null) {
                aVar.mo15165a(bool);
            }
        }
    }

    /* renamed from: a */
    public void mo15184a(Context context, String str, C1081a aVar) {
        if (!C1037b.m1965e(context, str) || !C1085f.m2106f().mo15208d()) {
            aVar.mo15165a(false);
            return;
        }
        C1082b bVar = new C1082b(aVar);
        bVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
        try {
            f1469a = String.format(Locale.ROOT, "content://%s.commondata/item/4", new Object[]{str});
            bVar.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            bVar.cancel(true);
            C0964a.m1666a("AutoUpdateUtil", "init AutoUpdateInfo error: " + e.toString());
            aVar.mo15165a(false);
        }
    }
}
