package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.service.C1995at;

/* renamed from: com.xiaomi.push.dw */
public class C1737dw {

    /* renamed from: a */
    private static volatile C1737dw f2078a;

    /* renamed from: a */
    private Context f2079a;

    /* renamed from: a */
    private C1738a f2080a;

    /* renamed from: com.xiaomi.push.dw$a */
    public interface C1738a {
        /* renamed from: a */
        void mo17402a();
    }

    private C1737dw(Context context) {
        this.f2079a = context;
    }

    /* renamed from: a */
    public static int m3048a(int i) {
        return Math.max(60, i);
    }

    /* renamed from: a */
    public static C1737dw m3049a(Context context) {
        if (f2078a == null) {
            synchronized (C1737dw.class) {
                if (f2078a == null) {
                    f2078a = new C1737dw(context);
                }
            }
        }
        return f2078a;
    }

    /* renamed from: a */
    private void m3051a(C1995at atVar, C1618ak akVar, boolean z) {
        if (atVar.mo18472a(C1873ht.UploadSwitch.mo17806a(), true)) {
            C1744eb ebVar = new C1744eb(this.f2079a);
            if (z) {
                akVar.mo17215a((C1618ak.C1619a) ebVar, m3048a(atVar.mo18465a(C1873ht.UploadFrequency.mo17806a(), (int) RemoteMessageConst.DEFAULT_TTL)));
            } else {
                akVar.mo17214a((C1618ak.C1619a) ebVar);
            }
        }
    }

    /* renamed from: a */
    private boolean mo17401a() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                ((Application) (this.f2079a instanceof Application ? this.f2079a : this.f2079a.getApplicationContext())).registerActivityLifecycleCallbacks(new C1731dq(this.f2079a, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3053b() {
        C1738a aVar;
        C1618ak a = C1618ak.m2518a(this.f2079a);
        C1995at a2 = C1995at.m5047a(this.f2079a);
        SharedPreferences sharedPreferences = this.f2079a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) >= 172800000) {
            m3051a(a2, a, false);
            if (a2.mo18472a(C1873ht.StorageCollectionSwitch.mo17806a(), true)) {
                int a3 = m3048a(a2.mo18465a(C1873ht.StorageCollectionFrequency.mo17806a(), (int) RemoteMessageConst.DEFAULT_TTL));
                a.mo17216a(new C1743ea(this.f2079a, a3), a3, 0);
            }
            boolean a4 = a2.mo18472a(C1873ht.AppIsInstalledCollectionSwitch.mo17806a(), false);
            String a5 = a2.mo18467a(C1873ht.AppIsInstalledList.mo17806a(), (String) null);
            if (a4 && !TextUtils.isEmpty(a5)) {
                int a6 = m3048a(a2.mo18465a(C1873ht.AppIsInstalledCollectionFrequency.mo17806a(), (int) RemoteMessageConst.DEFAULT_TTL));
                a.mo17216a(new C1740dy(this.f2079a, a6, a5), a6, 0);
            }
            if (C1938m.m4714a(this.f2079a) && (aVar = this.f2080a) != null) {
                aVar.mo17402a();
            }
            if (a2.mo18472a(C1873ht.ActivityTSSwitch.mo17806a(), false)) {
                mo17401a();
            }
            m3051a(a2, a, true);
        }
    }

    /* renamed from: a */
    public void m3054a() {
        C1618ak.m2518a(this.f2079a).mo17212a((Runnable) new C1739dx(this));
    }
}
