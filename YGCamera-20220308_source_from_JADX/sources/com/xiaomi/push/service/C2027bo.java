package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1623an;
import com.xiaomi.push.C1675c;
import com.xiaomi.push.C1745ec;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.C1845gx;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C2087u;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.bo */
public class C2027bo {

    /* renamed from: a */
    private static C2027bo f3831a = new C2027bo();

    /* renamed from: a */
    private static String f3832a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1623an.C1625b f3833a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1745ec.C1746a f3834a;

    /* renamed from: a */
    private List<C2028a> f3835a = new ArrayList();

    /* renamed from: com.xiaomi.push.service.bo$a */
    public static abstract class C2028a {
        /* renamed from: a */
        public void mo18499a(C1745ec.C1746a aVar) {
        }

        /* renamed from: a */
        public void mo17758a(C1747ed.C1749b bVar) {
        }
    }

    private C2027bo() {
    }

    /* renamed from: a */
    public static C2027bo mo18506a() {
        return f3831a;
    }

    /* renamed from: a */
    public static synchronized String m5150a() {
        String str;
        synchronized (C2027bo.class) {
            if (f3832a == null) {
                SharedPreferences sharedPreferences = C2087u.m5371a().getSharedPreferences("XMPushServiceConfig", 0);
                f3832a = sharedPreferences.getString("DeviceUUID", (String) null);
                if (f3832a == null) {
                    f3832a = C1907j.m4554a(C2087u.m5371a(), false);
                    if (f3832a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f3832a).commit();
                    }
                }
            }
            str = f3832a;
        }
        return str;
    }

    /* renamed from: b */
    private void m5153b() {
        if (this.f3834a == null) {
            m5155d();
        }
    }

    /* renamed from: c */
    private void m5154c() {
        if (this.f3833a == null) {
            this.f3833a = new C2029bp(this);
            C1845gx.m3805a(this.f3833a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5155d() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.C2087u.m5371a()     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ Exception -> 0x002b }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x002b }
            r2.<init>(r1)     // Catch:{ Exception -> 0x002b }
            com.xiaomi.push.b r0 = com.xiaomi.push.C1641b.m2608a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            com.xiaomi.push.ec$a r0 = com.xiaomi.push.C1745ec.C1746a.m3089b((com.xiaomi.push.C1641b) r0)     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            r4.f3834a = r0     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            goto L_0x0047
        L_0x0021:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x0053
        L_0x0025:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x002c
        L_0x0029:
            r1 = move-exception
            goto L_0x0053
        L_0x002b:
            r1 = move-exception
        L_0x002c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0029 }
            r2.<init>()     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = "load config failure: "
            r2.append(r3)     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0029 }
            r2.append(r1)     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0029 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r1)     // Catch:{ all -> 0x0029 }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r0)
        L_0x0047:
            com.xiaomi.push.ec$a r0 = r4.f3834a
            if (r0 != 0) goto L_0x0052
            com.xiaomi.push.ec$a r0 = new com.xiaomi.push.ec$a
            r0.<init>()
            r4.f3834a = r0
        L_0x0052:
            return
        L_0x0053:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2027bo.m5155d():void");
    }

    /* renamed from: e */
    private void m5156e() {
        try {
            if (this.f3834a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C2087u.m5371a().openFileOutput("XMCloudCfg", 0));
                C1675c a = C1675c.m2788a((OutputStream) bufferedOutputStream);
                this.f3834a.mo17411a(a);
                a.mo17279a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            C1524b.m2141a("save config failure: " + e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int m5157a() {
        m5153b();
        C1745ec.C1746a aVar = this.f3834a;
        if (aVar != null) {
            return aVar.mo17420c();
        }
        return 0;
    }

    /* renamed from: a */
    public C1745ec.C1746a m5158a() {
        m5153b();
        return this.f3834a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m5159a() {
        this.f3835a.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18507a(C1747ed.C1749b bVar) {
        C2028a[] aVarArr;
        if (bVar.mo17449d() && bVar.mo17449d() > mo18506a()) {
            m5154c();
        }
        synchronized (this) {
            aVarArr = (C2028a[]) this.f3835a.toArray(new C2028a[this.f3835a.size()]);
        }
        for (C2028a a : aVarArr) {
            a.mo17758a(bVar);
        }
    }

    /* renamed from: a */
    public synchronized void mo18508a(C2028a aVar) {
        this.f3835a.add(aVar);
    }
}
