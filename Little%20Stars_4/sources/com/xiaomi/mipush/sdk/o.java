package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.channel.commonutils.string.c;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.ac;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.p;
import com.xiaomi.xmpush.thrift.t;
import java.util.ArrayList;
import java.util.Iterator;

public class o {
    private static o b;
    private static final ArrayList<a> e = new ArrayList<>();
    private boolean a = false;
    /* access modifiers changed from: private */
    public Context c;
    private String d;
    private Intent f = null;
    /* access modifiers changed from: private */
    public Integer g = null;

    static class a<T extends org.apache.thrift.a<T, ?>> {
        T a;
        com.xiaomi.xmpush.thrift.a b;
        boolean c;

        a() {
        }
    }

    private o(Context context) {
        this.c = context.getApplicationContext();
        this.d = null;
        this.a = g();
    }

    public static o a(Context context) {
        if (b == null) {
            b = new o(context);
        }
        return b;
    }

    private void a(Intent intent) {
        try {
            this.c.startService(intent);
        } catch (Exception e2) {
            b.a((Throwable) e2);
        }
    }

    private boolean g() {
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Exception unused) {
            return false;
        }
    }

    private Intent h() {
        Intent intent = new Intent();
        String packageName = this.c.getPackageName();
        if (!b() || "com.xiaomi.xmsf".equals(packageName)) {
            k();
            intent.setComponent(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
        } else {
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", i());
            intent.putExtra("mipush_app_package", packageName);
            j();
        }
        return intent;
    }

    private String i() {
        try {
            return this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private void j() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 1, 1);
        } catch (Throwable unused) {
        }
    }

    private boolean l() {
        String packageName = this.c.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.c.getApplicationInfo().flags & 1) != 0;
    }

    public void a() {
        a(h());
    }

    public void a(int i) {
        Intent h = h();
        h.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        h.putExtra(aa.y, this.c.getPackageName());
        h.putExtra(aa.z, i);
        a(h);
    }

    public final void a(com.xiaomi.xmpush.thrift.aa aaVar) {
        Intent h = h();
        byte[] a2 = ae.a(k.a(this.c, aaVar, com.xiaomi.xmpush.thrift.a.UnRegistration));
        if (a2 == null) {
            b.a("unregister fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        h.putExtra("mipush_app_id", a.a(this.c).c());
        h.putExtra("mipush_payload", a2);
        a(h);
    }

    public final void a(t tVar, boolean z) {
        this.f = null;
        Intent h = h();
        byte[] a2 = ae.a(k.a(this.c, tVar, com.xiaomi.xmpush.thrift.a.Registration));
        if (a2 == null) {
            b.a("register fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.REGISTER_APP");
        h.putExtra("mipush_app_id", a.a(this.c).c());
        h.putExtra("mipush_payload", a2);
        h.putExtra("mipush_session", this.d);
        h.putExtra("mipush_env_chanage", z);
        h.putExtra("mipush_env_type", a.a(this.c).m());
        if (!d.d(this.c) || !f()) {
            this.f = h;
        } else {
            a(h);
        }
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, i iVar) {
        a(t, aVar, !aVar.equals(com.xiaomi.xmpush.thrift.a.Registration), iVar);
    }

    public <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z) {
        a aVar2 = new a();
        aVar2.a = t;
        aVar2.b = aVar;
        aVar2.c = z;
        synchronized (e) {
            e.add(aVar2);
            if (e.size() > 10) {
                e.remove(0);
            }
        }
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, i iVar) {
        a(t, aVar, z, true, iVar, true);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, i iVar, boolean z2) {
        a(t, aVar, z, true, iVar, z2);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, i iVar, boolean z3) {
        a(t, aVar, z, z2, iVar, z3, this.c.getPackageName(), a.a(this.c).c());
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, i iVar, boolean z3, String str, String str2) {
        if (a.a(this.c).i()) {
            Intent h = h();
            p a2 = k.a(this.c, t, aVar, z, str, str2);
            if (iVar != null) {
                a2.a(iVar);
            }
            byte[] a3 = ae.a(a2);
            if (a3 == null) {
                b.a("send message fail, because msgBytes is null.");
                return;
            }
            h.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            h.putExtra("mipush_payload", a3);
            h.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            a(h);
        } else if (z2) {
            a(t, aVar, z);
        } else {
            b.a("drop the message before initialization.");
        }
    }

    public void b(int i) {
        Intent h = h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(aa.y, this.c.getPackageName());
        h.putExtra(aa.A, i);
        String str = aa.C;
        h.putExtra(str, c.b(this.c.getPackageName() + i));
        a(h);
    }

    public boolean b() {
        return this.a && 1 == a.a(this.c).m();
    }

    public void c() {
        Intent intent = this.f;
        if (intent != null) {
            a(intent);
            this.f = null;
        }
    }

    public void d() {
        synchronized (e) {
            Iterator<a> it = e.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.a, next.b, next.c, false, (i) null, true);
            }
            e.clear();
        }
    }

    public void e() {
        Intent h = h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(aa.y, this.c.getPackageName());
        h.putExtra(aa.C, c.b(this.c.getPackageName()));
        a(h);
    }

    public boolean f() {
        if (!b() || !l()) {
            return true;
        }
        if (this.g == null) {
            this.g = Integer.valueOf(ac.a(this.c).b());
            if (this.g.intValue() == 0) {
                this.c.getContentResolver().registerContentObserver(ac.a(this.c).c(), false, new p(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.g.intValue() != 0;
    }
}
