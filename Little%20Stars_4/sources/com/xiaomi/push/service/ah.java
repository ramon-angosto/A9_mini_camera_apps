package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.android.i;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.smack.util.h;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ah {
    private static String a;
    private static ah e = new ah();
    /* access modifiers changed from: private */
    public List<a> b = new ArrayList();
    /* access modifiers changed from: private */
    public a.C0052a c;
    /* access modifiers changed from: private */
    public f.b d;

    public static abstract class a {
        public void a(a.C0052a aVar) {
        }

        public void a(b.a aVar) {
        }
    }

    private ah() {
    }

    public static ah a() {
        return e;
    }

    public static synchronized String e() {
        String str;
        synchronized (ah.class) {
            if (a == null) {
                SharedPreferences sharedPreferences = i.a().getSharedPreferences("XMPushServiceConfig", 0);
                a = sharedPreferences.getString("DeviceUUID", (String) null);
                if (a == null) {
                    a = i.b();
                    if (a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", a).commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    private void f() {
        if (this.c == null) {
            h();
        }
    }

    private void g() {
        if (this.d == null) {
            this.d = new ai(this);
            h.a(this.d);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.channel.commonutils.android.i.a()     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ Exception -> 0x002b }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x002b }
            r2.<init>(r1)     // Catch:{ Exception -> 0x002b }
            com.google.protobuf.micro.a r0 = com.google.protobuf.micro.a.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            com.xiaomi.push.protobuf.a$a r0 = com.xiaomi.push.protobuf.a.C0052a.c(r0)     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            r4.c = r0     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0025, all -> 0x0021 }
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r2)
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
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)     // Catch:{ all -> 0x0029 }
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r0)
        L_0x0047:
            com.xiaomi.push.protobuf.a$a r0 = r4.c
            if (r0 != 0) goto L_0x0052
            com.xiaomi.push.protobuf.a$a r0 = new com.xiaomi.push.protobuf.a$a
            r0.<init>()
            r4.c = r0
        L_0x0052:
            return
        L_0x0053:
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ah.h():void");
    }

    /* access modifiers changed from: private */
    public void i() {
        try {
            if (this.c != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(i.a().openFileOutput("XMCloudCfg", 0));
                com.google.protobuf.micro.b a2 = com.google.protobuf.micro.b.a((OutputStream) bufferedOutputStream);
                this.c.a(a2);
                a2.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("save config failure: " + e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b.a aVar) {
        a[] aVarArr;
        if (aVar.h() && aVar.g() > c()) {
            g();
        }
        synchronized (this) {
            aVarArr = (a[]) this.b.toArray(new a[this.b.size()]);
        }
        for (a a2 : aVarArr) {
            a2.a(aVar);
        }
    }

    public synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        this.b.clear();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        f();
        a.C0052a aVar = this.c;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    public a.C0052a d() {
        f();
        return this.c;
    }
}
