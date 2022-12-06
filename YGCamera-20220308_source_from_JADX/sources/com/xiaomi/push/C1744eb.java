package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.service.C1995at;
import java.io.File;
import java.util.List;

/* renamed from: com.xiaomi.push.eb */
public class C1744eb extends C1618ak.C1619a {

    /* renamed from: a */
    private Context f2085a;

    /* renamed from: a */
    private SharedPreferences f2086a;

    /* renamed from: a */
    private C1995at f2087a;

    public C1744eb(Context context) {
        this.f2085a = context;
        this.f2086a = context.getSharedPreferences("mipush_extra", 0);
        this.f2087a = C1995at.m5047a(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:46|45|61|63|64|65|66|29|67|68) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|(3:15|16|(2:73|18)(2:19|(1:74)(4:30|31|(1:75)(2:33|(2:35|76)(2:36|77))|72)))|(3:22|23|(2:25|26))|27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:43|44|(0)|55|56|57) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00a2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00b6 */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0099 A[SYNTHETIC, Splitter:B:50:0x0099] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x00a2=Splitter:B:55:0x00a2, B:27:0x0066=Splitter:B:27:0x0066, B:65:0x00b6=Splitter:B:65:0x00b6} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.xiaomi.push.C1876hw> m3081a(java.io.File r11) {
        /*
            r10 = this;
            com.xiaomi.push.ds r0 = com.xiaomi.push.C1733ds.mo17399a()
            com.xiaomi.push.dr r0 = r0.mo17399a()
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = ""
            goto L_0x0011
        L_0x000d:
            java.lang.String r0 = r0.mo17202a()
        L_0x0011:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0019
            return r2
        L_0x0019:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3 = 4
            byte[] r4 = new byte[r3]
            java.lang.Object r5 = com.xiaomi.push.C1736dv.f2075a
            monitor-enter(r5)
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            android.content.Context r7 = r10.f2085a     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.io.File r7 = r7.getExternalFilesDir(r2)     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.lang.String r8 = "push_cdata.lock"
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r6)     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.lang.String r8 = "rw"
            r7.<init>(r6, r8)     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.nio.channels.FileChannel r6 = r7.getChannel()     // Catch:{ Exception -> 0x0092, all -> 0x008f }
            java.nio.channels.FileLock r6 = r6.lock()     // Catch:{ Exception -> 0x0092, all -> 0x008f }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008d, all -> 0x008b }
            r8.<init>(r11)     // Catch:{ Exception -> 0x008d, all -> 0x008b }
        L_0x0048:
            int r11 = r8.read(r4)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            if (r11 == r3) goto L_0x004f
            goto L_0x005b
        L_0x004f:
            int r11 = com.xiaomi.push.C1612ae.m2508a((byte[]) r4)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            int r9 = r8.read(r2)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            if (r9 == r11) goto L_0x006d
        L_0x005b:
            if (r6 == 0) goto L_0x0066
            boolean r11 = r6.isValid()     // Catch:{ all -> 0x00bc }
            if (r11 == 0) goto L_0x0066
            r6.release()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r8)     // Catch:{ all -> 0x00bc }
        L_0x0069:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r7)     // Catch:{ all -> 0x00bc }
            goto L_0x00ba
        L_0x006d:
            byte[] r11 = com.xiaomi.push.C1735du.m3046a(r0, r2)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            if (r11 == 0) goto L_0x0048
            int r2 = r11.length     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            if (r2 != 0) goto L_0x0077
            goto L_0x0048
        L_0x0077:
            com.xiaomi.push.hw r2 = new com.xiaomi.push.hw     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r2.<init>()     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            com.xiaomi.push.C1905iy.m4542a(r2, (byte[]) r11)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r1.add(r2)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r10.m3083a((com.xiaomi.push.C1876hw) r2)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            goto L_0x0048
        L_0x0086:
            r11 = move-exception
            r2 = r8
            goto L_0x0097
        L_0x0089:
            r2 = r8
            goto L_0x00ab
        L_0x008b:
            r11 = move-exception
            goto L_0x0097
        L_0x008d:
            goto L_0x00ab
        L_0x008f:
            r11 = move-exception
            r6 = r2
            goto L_0x0097
        L_0x0092:
            r6 = r2
            goto L_0x00ab
        L_0x0094:
            r11 = move-exception
            r6 = r2
            r7 = r6
        L_0x0097:
            if (r6 == 0) goto L_0x00a2
            boolean r0 = r6.isValid()     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x00a2
            r6.release()     // Catch:{ IOException -> 0x00a2 }
        L_0x00a2:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)     // Catch:{ all -> 0x00bc }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r7)     // Catch:{ all -> 0x00bc }
            throw r11     // Catch:{ all -> 0x00bc }
        L_0x00a9:
            r6 = r2
            r7 = r6
        L_0x00ab:
            if (r6 == 0) goto L_0x00b6
            boolean r11 = r6.isValid()     // Catch:{ all -> 0x00bc }
            if (r11 == 0) goto L_0x00b6
            r6.release()     // Catch:{ IOException -> 0x00b6 }
        L_0x00b6:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)     // Catch:{ all -> 0x00bc }
            goto L_0x0069
        L_0x00ba:
            monitor-exit(r5)     // Catch:{ all -> 0x00bc }
            return r1
        L_0x00bc:
            r11 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00bc }
            goto L_0x00c0
        L_0x00bf:
            throw r11
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1744eb.m3081a(java.io.File):java.util.List");
    }

    /* renamed from: a */
    private void mo16986a() {
        SharedPreferences.Editor edit = this.f2086a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a */
    private void m3083a(C1876hw hwVar) {
        if (hwVar.f2890a == C1870hq.AppInstallList && !hwVar.f2891a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f2086a.edit();
            edit.putLong("dc_job_result_time_4", hwVar.f2889a);
            edit.putString("dc_job_result_4", C1663bo.m2727a(hwVar.f2891a));
            edit.commit();
        }
    }

    /* renamed from: a */
    private boolean m3084a() {
        if (C1653bi.m2688e(this.f2085a)) {
            return false;
        }
        if ((C1653bi.m2690g(this.f2085a) || C1653bi.m2689f(this.f2085a)) && !m3086c()) {
            return true;
        }
        return (C1653bi.m2691h(this.f2085a) && !m3085b()) || C1653bi.m2692i(this.f2085a);
    }

    /* renamed from: b */
    private boolean m3085b() {
        if (!this.f2087a.mo18472a(C1873ht.Upload3GSwitch.mo17806a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f2086a.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f2087a.mo18465a(C1873ht.Upload3GFrequency.mo17806a(), 432000)));
    }

    /* renamed from: c */
    private boolean m3086c() {
        if (!this.f2087a.mo18472a(C1873ht.Upload4GSwitch.mo17806a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f2086a.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f2087a.mo18465a(C1873ht.Upload4GFrequency.mo17806a(), 259200)));
    }

    /* renamed from: a */
    public String m3087a() {
        return "1";
    }

    public void run() {
        File file = new File(this.f2085a.getExternalFilesDir((String) null), "push_cdata.data");
        if (!C1653bi.m2687d(this.f2085a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!mo16986a() && file.exists()) {
            List<C1876hw> a = m3081a(file);
            if (!C1613af.m2510a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                C1888ih ihVar = new C1888ih();
                ihVar.mo17995a(a);
                byte[] a2 = C1608aa.m2497a(C1905iy.m4543a(ihVar));
                C1894in inVar = new C1894in("-1", false);
                inVar.mo18087c(C1878hy.DataCollection.f2959a);
                inVar.mo18082a(a2);
                C1732dr a3 = C1733ds.mo17399a().mo17399a();
                if (a3 != null) {
                    a3.mo17203a(inVar, C1868ho.Notification, (C1882ib) null);
                }
                mo16986a();
            }
            file.delete();
        }
    }
}
