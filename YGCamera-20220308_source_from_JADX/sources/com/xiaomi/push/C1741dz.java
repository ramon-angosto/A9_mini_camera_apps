package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.service.C1995at;

/* renamed from: com.xiaomi.push.dz */
public abstract class C1741dz extends C1618ak.C1619a {

    /* renamed from: a */
    protected int f2083a;

    /* renamed from: a */
    protected Context f2084a;

    public C1741dz(Context context, int i) {
        this.f2083a = i;
        this.f2084a = context;
    }

    /* renamed from: a */
    public static void m3060a(Context context, C1876hw hwVar) {
        C1732dr a = C1733ds.mo17399a().mo17399a();
        String a2 = a == null ? "" : a.mo17202a();
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(hwVar.mo17812a())) {
            m3061a(context, hwVar, a2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.nio.channels.FileLock} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:32|33|38|39|(0)|46|47|23|48|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|(3:16|17|(2:19|20))|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:50|51|52|(2:56|57)|58|59|60) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0090 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00a4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087 A[SYNTHETIC, Splitter:B:41:0x0087] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x0090=Splitter:B:46:0x0090, B:38:0x0082=Splitter:B:38:0x0082, B:21:0x0064=Splitter:B:21:0x0064, B:58:0x00a4=Splitter:B:58:0x00a4} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m3061a(android.content.Context r6, com.xiaomi.push.C1876hw r7, java.lang.String r8) {
        /*
            byte[] r7 = com.xiaomi.push.C1905iy.m4543a(r7)
            byte[] r7 = com.xiaomi.push.C1735du.m3047b(r8, r7)
            if (r7 == 0) goto L_0x00ae
            int r8 = r7.length
            if (r8 != 0) goto L_0x000f
            goto L_0x00ae
        L_0x000f:
            java.lang.Object r8 = com.xiaomi.push.C1736dv.f2075a
            monitor-enter(r8)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x007f, all -> 0x007b }
            java.io.File r2 = r6.getExternalFilesDir(r0)     // Catch:{ IOException -> 0x007f, all -> 0x007b }
            java.lang.String r3 = "push_cdata.lock"
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x007f, all -> 0x007b }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r1)     // Catch:{ IOException -> 0x007f, all -> 0x007b }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x007f, all -> 0x007b }
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x007f, all -> 0x007b }
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch:{ IOException -> 0x0078, all -> 0x0075 }
            java.nio.channels.FileLock r1 = r1.lock()     // Catch:{ IOException -> 0x0078, all -> 0x0075 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0071, all -> 0x006f }
            java.io.File r6 = r6.getExternalFilesDir(r0)     // Catch:{ IOException -> 0x0071, all -> 0x006f }
            java.lang.String r4 = "push_cdata.data"
            r3.<init>(r6, r4)     // Catch:{ IOException -> 0x0071, all -> 0x006f }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0071, all -> 0x006f }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0071, all -> 0x006f }
            r5 = 1
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x0071, all -> 0x006f }
            r6.<init>(r4)     // Catch:{ IOException -> 0x0071, all -> 0x006f }
            int r0 = r7.length     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            byte[] r0 = com.xiaomi.push.C1612ae.m2509a((int) r0)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r6.write(r0)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r6.write(r7)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r6.flush()     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r4 = 0
            r3.setLastModified(r4)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            if (r1 == 0) goto L_0x0064
            boolean r7 = r1.isValid()     // Catch:{ all -> 0x00ab }
            if (r7 == 0) goto L_0x0064
            r1.release()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r6)     // Catch:{ all -> 0x00ab }
        L_0x0067:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)     // Catch:{ all -> 0x00ab }
            goto L_0x0094
        L_0x006b:
            r7 = move-exception
            goto L_0x0098
        L_0x006d:
            r7 = move-exception
            goto L_0x0073
        L_0x006f:
            r7 = move-exception
            goto L_0x0099
        L_0x0071:
            r7 = move-exception
            r6 = r0
        L_0x0073:
            r0 = r1
            goto L_0x0082
        L_0x0075:
            r7 = move-exception
            r1 = r0
            goto L_0x0099
        L_0x0078:
            r7 = move-exception
            r6 = r0
            goto L_0x0082
        L_0x007b:
            r7 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0099
        L_0x007f:
            r7 = move-exception
            r6 = r0
            r2 = r6
        L_0x0082:
            r7.printStackTrace()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0090
            boolean r7 = r0.isValid()     // Catch:{ all -> 0x00ab }
            if (r7 == 0) goto L_0x0090
            r0.release()     // Catch:{ IOException -> 0x0090 }
        L_0x0090:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r6)     // Catch:{ all -> 0x00ab }
            goto L_0x0067
        L_0x0094:
            monitor-exit(r8)     // Catch:{ all -> 0x00ab }
            return
        L_0x0096:
            r7 = move-exception
            r1 = r0
        L_0x0098:
            r0 = r6
        L_0x0099:
            if (r1 == 0) goto L_0x00a4
            boolean r6 = r1.isValid()     // Catch:{ all -> 0x00ab }
            if (r6 == 0) goto L_0x00a4
            r1.release()     // Catch:{ IOException -> 0x00a4 }
        L_0x00a4:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r0)     // Catch:{ all -> 0x00ab }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)     // Catch:{ all -> 0x00ab }
            throw r7     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r6 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00ab }
            throw r6
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1741dz.m3061a(android.content.Context, com.xiaomi.push.hw, java.lang.String):void");
    }

    /* renamed from: c */
    private String mo17405c() {
        return "dc_job_result_time_" + mo16986a();
    }

    /* renamed from: d */
    private String m3063d() {
        return "dc_job_result_" + mo16986a();
    }

    /* renamed from: a */
    public abstract C1870hq mo16986a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m3065a() {
        return C1735du.m3045a(this.f2084a, String.valueOf(mo16986a()), (long) this.f2083a);
    }

    /* renamed from: b */
    public abstract String mo17404b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean m3067b() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean m3068c() {
        return false;
    }

    public void run() {
        String b = mo17404b();
        if (!TextUtils.isEmpty(b)) {
            if (mo16986a()) {
                C1524b.m2141a("DC run job mutual: " + mo16986a());
                return;
            }
            C1732dr a = C1733ds.mo17399a().mo17399a();
            String a2 = a == null ? "" : a.mo17202a();
            if (!TextUtils.isEmpty(a2) && mo17404b()) {
                if (mo17405c()) {
                    SharedPreferences sharedPreferences = this.f2084a.getSharedPreferences("mipush_extra", 0);
                    if (C1663bo.m2727a(b).equals(sharedPreferences.getString(m3063d(), (String) null))) {
                        long j = sharedPreferences.getLong(mo17405c(), 0);
                        int a3 = C1995at.m5047a(this.f2084a).mo18465a(C1873ht.DCJobUploadRepeatedInterval.mo17806a(), 604800);
                        if ((System.currentTimeMillis() - j) / 1000 >= ((long) this.f2083a)) {
                            if ((System.currentTimeMillis() - j) / 1000 < ((long) a3)) {
                                b = "same_" + j;
                            }
                        } else {
                            return;
                        }
                    }
                }
                C1876hw hwVar = new C1876hw();
                hwVar.mo17811a(b);
                hwVar.mo17809a(System.currentTimeMillis());
                hwVar.mo17810a(mo16986a());
                m3061a(this.f2084a, hwVar, a2);
            }
        }
    }
}
