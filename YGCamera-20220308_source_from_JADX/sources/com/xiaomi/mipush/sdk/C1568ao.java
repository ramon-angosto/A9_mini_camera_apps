package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.C1662bn;
import com.xiaomi.push.C1712da;
import com.xiaomi.push.C1776eu;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1869hp;
import com.xiaomi.push.C1872hs;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1895io;
import com.xiaomi.push.C1901iu;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1906iz;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.C1999aw;
import com.xiaomi.push.service.C2014bd;
import com.xiaomi.push.service.C2019bg;
import com.xiaomi.push.service.C2055e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.ao */
public class C1568ao {

    /* renamed from: a */
    private static C1568ao f1665a = null;

    /* renamed from: a */
    private static final ArrayList<C1569a> f1666a = new ArrayList<>();

    /* renamed from: b */
    private static boolean f1667b = false;

    /* renamed from: a */
    private Context f1668a;

    /* renamed from: a */
    private Intent f1669a = null;

    /* renamed from: a */
    private Handler f1670a = null;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Messenger f1671a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Integer f1672a = null;

    /* renamed from: a */
    private String f1673a;

    /* renamed from: a */
    private List<Message> f1674a = new ArrayList();

    /* renamed from: a */
    private boolean f1675a = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f1676c = false;

    /* renamed from: com.xiaomi.mipush.sdk.ao$a */
    static class C1569a<T extends C1906iz<T, ?>> {

        /* renamed from: a */
        C1868ho f1677a;

        /* renamed from: a */
        T f1678a;

        /* renamed from: a */
        boolean f1679a;

        C1569a() {
        }
    }

    private C1568ao(Context context) {
        this.f1668a = context.getApplicationContext();
        this.f1673a = null;
        this.f1675a = mo17155c();
        f1667b = mo17156d();
        this.f1670a = new C1570ap(this, Looper.getMainLooper());
        if (C1938m.m4714a(context)) {
            C2055e.m5213a((C2055e.C2057b) new C1571aq(this));
        }
        Intent b = mo17153b();
        if (b != null) {
            m2326b(b);
        }
    }

    /* renamed from: a */
    private synchronized int mo17133a() {
        return this.f1668a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a */
    private Intent m2313a() {
        return (!mo17133a() || "com.xiaomi.xmsf".equals(this.f1668a.getPackageName())) ? mo17157e() : mo17156d();
    }

    /* renamed from: a */
    private Message mo17137a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a */
    public static synchronized C1568ao m2317a(Context context) {
        C1568ao aoVar;
        synchronized (C1568ao.class) {
            if (f1665a == null) {
                f1665a = new C1568ao(context);
            }
            aoVar = f1665a;
        }
        return aoVar;
    }

    /* renamed from: a */
    private String m2320a() {
        try {
            return this.f1668a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2323a(String str, C1575au auVar, boolean z, HashMap<String, String> hashMap) {
        C1894in inVar;
        String str2;
        if (C1578b.m2373a(this.f1668a).mo17170b() && C1653bi.m2685b(this.f1668a)) {
            C1894in inVar2 = new C1894in();
            inVar2.mo18081a(true);
            Intent a = mo17133a();
            if (TextUtils.isEmpty(str)) {
                str = C1999aw.m5064a();
                inVar2.mo18078a(str);
                inVar = z ? new C1894in(str, true) : null;
                synchronized (C1559af.class) {
                    C1559af.m2278a(this.f1668a).mo17125a(str);
                }
            } else {
                inVar2.mo18078a(str);
                inVar = z ? new C1894in(str, true) : null;
            }
            switch (C1574at.f1684a[auVar.ordinal()]) {
                case 1:
                    inVar2.mo18087c(C1878hy.DisablePushMessage.f2959a);
                    inVar.mo18087c(C1878hy.DisablePushMessage.f2959a);
                    if (hashMap != null) {
                        inVar2.mo18080a((Map<String, String>) hashMap);
                        inVar.mo18080a((Map<String, String>) hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    break;
                case 2:
                    inVar2.mo18087c(C1878hy.EnablePushMessage.f2959a);
                    inVar.mo18087c(C1878hy.EnablePushMessage.f2959a);
                    if (hashMap != null) {
                        inVar2.mo18080a((Map<String, String>) hashMap);
                        inVar.mo18080a((Map<String, String>) hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    inVar2.mo18087c(C1878hy.ThirdPartyRegUpdate.f2959a);
                    if (hashMap != null) {
                        inVar2.mo18080a((Map<String, String>) hashMap);
                        break;
                    }
                    break;
            }
            a.setAction(str2);
            C1524b.m2161e("type:" + auVar + ", " + str);
            inVar2.mo18084b(C1578b.m2373a(this.f1668a).mo17163a());
            inVar2.mo18091d(this.f1668a.getPackageName());
            mo17143a(inVar2, C1868ho.Notification, false, (C1882ib) null);
            if (z) {
                inVar.mo18084b(C1578b.m2373a(this.f1668a).mo17163a());
                inVar.mo18091d(this.f1668a.getPackageName());
                byte[] a2 = C1905iy.m4543a(C1562ai.m2287a(this.f1668a, inVar, C1868ho.Notification, false, this.f1668a.getPackageName(), C1578b.m2373a(this.f1668a).mo17163a()));
                if (a2 != null) {
                    C1712da.m2971a(this.f1668a.getPackageName(), this.f1668a, inVar, C1868ho.Notification, a2.length);
                    a.putExtra("mipush_payload", a2);
                    a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    a.putExtra("mipush_app_id", C1578b.m2373a(this.f1668a).mo17163a());
                    a.putExtra("mipush_app_token", C1578b.m2373a(this.f1668a).mo17170b());
                    m2329c(a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f1670a.sendMessageDelayed(obtain, 5000);
        }
    }

    /* renamed from: b */
    private Intent mo17153b() {
        if (!"com.xiaomi.xmsf".equals(this.f1668a.getPackageName())) {
            return mo17155c();
        }
        C1524b.m2159c("pushChannel xmsf create own channel");
        return mo17157e();
    }

    /* renamed from: b */
    private void m2326b(Intent intent) {
        try {
            if (C1938m.m4713a() || Build.VERSION.SDK_INT < 26) {
                this.f1668a.startService(intent);
            } else {
                m2332d(intent);
            }
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    /* renamed from: c */
    private Intent mo17155c() {
        if (mo17133a()) {
            C1524b.m2159c("pushChannel app start miui china channel");
            return mo17156d();
        }
        C1524b.m2159c("pushChannel app start  own channel");
        return mo17157e();
    }

    /* renamed from: c */
    private synchronized void m2328c(int i) {
        this.f1668a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    /* renamed from: c */
    private void m2329c(Intent intent) {
        int a = C1995at.m5047a(this.f1668a).mo18465a(C1873ht.ServiceBootMode.mo17806a(), C1869hp.START.mo17767a());
        int a2 = mo17133a();
        boolean z = a == C1869hp.BIND.mo17767a() && f1667b;
        int a3 = (z ? C1869hp.BIND : C1869hp.START).mo17767a();
        if (a3 != a2) {
            mo17134a(a3);
        }
        if (z) {
            m2332d(intent);
        } else {
            m2326b(intent);
        }
    }

    /* renamed from: c */
    private boolean m2330c() {
        try {
            PackageInfo packageInfo = this.f1668a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: d */
    private Intent mo17156d() {
        Intent intent = new Intent();
        String packageName = this.f1668a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", mo17133a());
        intent.putExtra("mipush_app_package", packageName);
        m2336f();
        return intent;
    }

    /* renamed from: d */
    private synchronized void m2332d(Intent intent) {
        if (this.f1676c) {
            Message a = mo17137a(intent);
            if (this.f1674a.size() >= 50) {
                this.f1674a.remove(0);
            }
            this.f1674a.add(a);
            return;
        } else if (this.f1671a == null) {
            Context context = this.f1668a;
            C1573as asVar = new C1573as(this);
            Context context2 = this.f1668a;
            context.bindService(intent, asVar, 1);
            this.f1676c = true;
            this.f1674a.clear();
            this.f1674a.add(mo17137a(intent));
        } else {
            try {
                this.f1671a.send(mo17137a(intent));
            } catch (RemoteException unused) {
                this.f1671a = null;
                this.f1676c = false;
            }
        }
        return;
    }

    /* renamed from: d */
    private boolean m2333d() {
        if (mo17133a()) {
            try {
                return this.f1668a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: e */
    private Intent mo17157e() {
        Intent intent = new Intent();
        String packageName = this.f1668a.getPackageName();
        m2337g();
        intent.setComponent(new ComponentName(this.f1668a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e */
    private boolean m2335e() {
        String packageName = this.f1668a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f1668a.getApplicationInfo().flags & 1) != 0;
    }

    /* renamed from: f */
    private void m2336f() {
        try {
            PackageManager packageManager = this.f1668a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f1668a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private void m2337g() {
        try {
            PackageManager packageManager = this.f1668a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f1668a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m2338a() {
        m2326b(mo17133a());
    }

    /* renamed from: a */
    public void mo17134a(int i) {
        mo17135a(i, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17135a(int i, int i2) {
        Intent a = mo17133a();
        a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a.putExtra(C2014bd.f3769A, this.f1668a.getPackageName());
        a.putExtra(C2014bd.f3770B, i);
        a.putExtra(C2014bd.f3771C, i2);
        m2329c(a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17136a(int i, String str) {
        Intent a = mo17133a();
        a.setAction("com.xiaomi.mipush.thirdparty");
        a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        m2326b(a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2342a(Intent intent) {
        intent.fillIn(mo17133a(), 24);
        m2329c(intent);
    }

    /* renamed from: a */
    public final void mo17138a(C1872hs hsVar) {
        Intent a = mo17133a();
        byte[] a2 = C1905iy.m4543a(hsVar);
        if (a2 == null) {
            C1524b.m2141a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        a.putExtra("mipush_payload", a2);
        m2326b(a);
    }

    /* renamed from: a */
    public final void mo17139a(C1895io ioVar, boolean z) {
        C1776eu.m3405a(this.f1668a.getApplicationContext()).mo17537a(this.f1668a.getPackageName(), "E100003", ioVar.mo18114a(), AuthCode.StatusCode.WAITING_CONNECT, (String) null);
        this.f1669a = null;
        C1578b.m2373a(this.f1668a).f1697a = ioVar.mo18114a();
        Intent a = mo17133a();
        byte[] a2 = C1905iy.m4543a(C1562ai.m2286a(this.f1668a, ioVar, C1868ho.Registration));
        if (a2 == null) {
            C1524b.m2141a("register fail, because msgBytes is null.");
            return;
        }
        a.setAction("com.xiaomi.mipush.REGISTER_APP");
        a.putExtra("mipush_app_id", C1578b.m2373a(this.f1668a).mo17163a());
        a.putExtra("mipush_payload", a2);
        a.putExtra("mipush_session", this.f1673a);
        a.putExtra("mipush_env_chanage", z);
        a.putExtra("mipush_env_type", C1578b.m2373a(this.f1668a).mo17163a());
        if (!C1653bi.m2685b(this.f1668a) || !mo17153b()) {
            this.f1669a = a;
        } else {
            m2329c(a);
        }
    }

    /* renamed from: a */
    public final void mo17140a(C1901iu iuVar) {
        byte[] a = C1905iy.m4543a(C1562ai.m2286a(this.f1668a, iuVar, C1868ho.UnRegistration));
        if (a == null) {
            C1524b.m2141a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent a2 = mo17133a();
        a2.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        a2.putExtra("mipush_app_id", C1578b.m2373a(this.f1668a).mo17163a());
        a2.putExtra("mipush_payload", a);
        m2329c(a2);
    }

    /* renamed from: a */
    public final <T extends C1906iz<T, ?>> void mo17141a(T t, C1868ho hoVar, C1882ib ibVar) {
        mo17143a(t, hoVar, !hoVar.equals(C1868ho.Registration), ibVar);
    }

    /* renamed from: a */
    public <T extends C1906iz<T, ?>> void mo17142a(T t, C1868ho hoVar, boolean z) {
        C1569a aVar = new C1569a();
        aVar.f1678a = t;
        aVar.f1677a = hoVar;
        aVar.f1679a = z;
        synchronized (f1666a) {
            f1666a.add(aVar);
            if (f1666a.size() > 10) {
                f1666a.remove(0);
            }
        }
    }

    /* renamed from: a */
    public final <T extends C1906iz<T, ?>> void mo17143a(T t, C1868ho hoVar, boolean z, C1882ib ibVar) {
        mo17145a(t, hoVar, z, true, ibVar, true);
    }

    /* renamed from: a */
    public final <T extends C1906iz<T, ?>> void mo17144a(T t, C1868ho hoVar, boolean z, C1882ib ibVar, boolean z2) {
        mo17145a(t, hoVar, z, true, ibVar, z2);
    }

    /* renamed from: a */
    public final <T extends C1906iz<T, ?>> void mo17145a(T t, C1868ho hoVar, boolean z, boolean z2, C1882ib ibVar, boolean z3) {
        mo17146a(t, hoVar, z, z2, ibVar, z3, this.f1668a.getPackageName(), C1578b.m2373a(this.f1668a).mo17163a());
    }

    /* renamed from: a */
    public final <T extends C1906iz<T, ?>> void mo17146a(T t, C1868ho hoVar, boolean z, boolean z2, C1882ib ibVar, boolean z3, String str, String str2) {
        mo17147a(t, hoVar, z, z2, ibVar, z3, str, str2, true);
    }

    /* renamed from: a */
    public final <T extends C1906iz<T, ?>> void mo17147a(T t, C1868ho hoVar, boolean z, boolean z2, C1882ib ibVar, boolean z3, String str, String str2, boolean z4) {
        mo17148a(t, hoVar, z, z2, ibVar, z3, str, str2, z4, true);
    }

    /* renamed from: a */
    public final <T extends C1906iz<T, ?>> void mo17148a(T t, C1868ho hoVar, boolean z, boolean z2, C1882ib ibVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        C1882ib ibVar2 = ibVar;
        if (!z5 || C1578b.m2373a(this.f1668a).mo17173c()) {
            C1891ik a = z4 ? C1562ai.m2287a(this.f1668a, t, hoVar, z, str, str2) : C1562ai.m2291b(this.f1668a, t, hoVar, z, str, str2);
            if (ibVar2 != null) {
                a.mo18045a(ibVar);
            }
            byte[] a2 = C1905iy.m4543a(a);
            if (a2 == null) {
                C1524b.m2141a("send message fail, because msgBytes is null.");
                return;
            }
            T t2 = t;
            C1868ho hoVar2 = hoVar;
            C1712da.m2971a(this.f1668a.getPackageName(), this.f1668a, t, hoVar, a2.length);
            Intent a3 = mo17133a();
            a3.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            a3.putExtra("mipush_payload", a2);
            boolean z6 = z3;
            a3.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            m2329c(a3);
        } else if (z2) {
            mo17142a(t, hoVar, z);
        } else {
            C1524b.m2141a("drop the message before initialization.");
        }
    }

    /* renamed from: a */
    public final void mo17149a(String str, C1575au auVar, C1582e eVar) {
        C1559af.m2278a(this.f1668a).mo17127a(auVar, "syncing");
        m2323a(str, auVar, false, C1586i.m2433a(this.f1668a, eVar));
    }

    /* renamed from: a */
    public void mo17150a(String str, String str2) {
        Intent a = mo17133a();
        a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a.putExtra(C2014bd.f3769A, this.f1668a.getPackageName());
        a.putExtra(C2014bd.f3775G, str);
        a.putExtra(C2014bd.f3776H, str2);
        m2329c(a);
    }

    /* renamed from: a */
    public final void mo17151a(boolean z) {
        mo17152a(z, (String) null);
    }

    /* renamed from: a */
    public final void mo17152a(boolean z, String str) {
        C1575au auVar;
        if (z) {
            C1559af.m2278a(this.f1668a).mo17127a(C1575au.DISABLE_PUSH, "syncing");
            C1559af.m2278a(this.f1668a).mo17127a(C1575au.ENABLE_PUSH, "");
            auVar = C1575au.DISABLE_PUSH;
        } else {
            C1559af.m2278a(this.f1668a).mo17127a(C1575au.ENABLE_PUSH, "syncing");
            C1559af.m2278a(this.f1668a).mo17127a(C1575au.DISABLE_PUSH, "");
            auVar = C1575au.ENABLE_PUSH;
        }
        m2323a(str, auVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a */
    public boolean m2358a() {
        return this.f1675a && 1 == C1578b.m2373a(this.f1668a).mo17163a();
    }

    /* renamed from: a */
    public boolean m2359a(int i) {
        if (!C1578b.m2373a(this.f1668a).mo17170b()) {
            return false;
        }
        m2328c(i);
        C1894in inVar = new C1894in();
        inVar.mo18078a(C1999aw.m5064a());
        inVar.mo18084b(C1578b.m2373a(this.f1668a).mo17163a());
        inVar.mo18091d(this.f1668a.getPackageName());
        inVar.mo18087c(C1878hy.ClientABTest.f2959a);
        inVar.f3224a = new HashMap();
        Map<String, String> map = inVar.f3224a;
        map.put("boot_mode", i + "");
        m2317a(this.f1668a).mo17143a(inVar, C1868ho.Notification, false, (C1882ib) null);
        return true;
    }

    /* renamed from: b */
    public final void m2360b() {
        Intent a = mo17133a();
        a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        m2329c(a);
    }

    /* renamed from: b */
    public void mo17154b(int i) {
        Intent a = mo17133a();
        a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a.putExtra(C2014bd.f3769A, this.f1668a.getPackageName());
        a.putExtra(C2014bd.f3772D, i);
        String str = C2014bd.f3774F;
        a.putExtra(str, C1662bn.m2725b(this.f1668a.getPackageName() + i));
        m2329c(a);
    }

    /* renamed from: b */
    public boolean m2362b() {
        if (!mo17133a() || !mo17157e()) {
            return true;
        }
        if (this.f1672a == null) {
            this.f1672a = Integer.valueOf(C2019bg.m5124a(this.f1668a).mo18500a());
            if (this.f1672a.intValue() == 0) {
                this.f1668a.getContentResolver().registerContentObserver(C2019bg.m5124a(this.f1668a).mo18500a(), false, new C1572ar(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f1672a.intValue() != 0;
    }

    /* renamed from: c */
    public void m2363c() {
        Intent intent = this.f1669a;
        if (intent != null) {
            m2329c(intent);
            this.f1669a = null;
        }
    }

    /* renamed from: d */
    public void m2364d() {
        synchronized (f1666a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<C1569a> it = f1666a.iterator();
            while (it.hasNext()) {
                C1569a next = it.next();
                mo17145a(next.f1678a, next.f1677a, next.f1679a, false, (C1882ib) null, true);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f1666a.clear();
        }
    }

    /* renamed from: e */
    public void m2365e() {
        Intent a = mo17133a();
        a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a.putExtra(C2014bd.f3769A, this.f1668a.getPackageName());
        a.putExtra(C2014bd.f3774F, C1662bn.m2725b(this.f1668a.getPackageName()));
        m2329c(a);
    }
}
