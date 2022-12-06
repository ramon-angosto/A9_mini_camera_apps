package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1872hs;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.service.C1999aw;
import com.xiaomi.push.service.C2033bs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a */
    public static class C1550a {

        /* renamed from: a */
        private static volatile C1550a f1624a;
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Context f1625a;

        /* renamed from: a */
        private C1551a f1626a = new C1551a();

        /* renamed from: a */
        private Boolean f1627a;

        /* renamed from: a */
        private String f1628a;

        /* renamed from: a */
        private final ArrayList<C1872hs> f1629a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a */
        public class C1551a {

            /* renamed from: a */
            private final Runnable f1631a = new C1555ab(this);

            /* renamed from: a */
            public final ArrayList<C1872hs> f1632a = new ArrayList<>();
            /* access modifiers changed from: private */

            /* renamed from: a */
            public ScheduledFuture<?> f1633a;

            /* renamed from: a */
            private ScheduledThreadPoolExecutor f1634a = new ScheduledThreadPoolExecutor(1);

            public C1551a() {
            }

            /* renamed from: a */
            private void m2249a() {
                if (this.f1633a == null) {
                    this.f1633a = this.f1634a.scheduleAtFixedRate(this.f1631a, 1000, 1000, TimeUnit.MILLISECONDS);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public void m2251b() {
                C1872hs remove = this.f1632a.remove(0);
                for (C1894in a : C2033bs.m5178a(Arrays.asList(new C1872hs[]{remove}), C1550a.this.f1625a.getPackageName(), C1578b.m2373a(C1550a.this.f1625a).mo17163a(), 30720)) {
                    C1524b.m2159c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.mo17792d());
                    C1568ao.m2317a(C1550a.this.f1625a).mo17143a(a, C1868ho.Notification, true, (C1882ib) null);
                }
            }

            /* renamed from: a */
            public void mo17088a(C1872hs hsVar) {
                this.f1634a.execute(new C1554aa(this, hsVar));
            }
        }

        /* renamed from: a */
        public static C1550a mo17085a() {
            if (f1624a == null) {
                synchronized (C1550a.class) {
                    if (f1624a == null) {
                        f1624a = new C1550a();
                    }
                }
            }
            return f1624a;
        }

        /* renamed from: a */
        private void mo17086a(C1872hs hsVar) {
            synchronized (this.f1629a) {
                if (!this.f1629a.contains(hsVar)) {
                    this.f1629a.add(hsVar);
                    if (this.f1629a.size() > 100) {
                        this.f1629a.remove(0);
                    }
                }
            }
        }

        /* renamed from: a */
        private boolean mo17083a(Context context) {
            if (!C1568ao.m2317a(context).mo17133a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                return packageInfo != null && packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: b */
        private boolean m2240b(Context context) {
            return C1578b.m2373a(context).mo17163a() == null && !mo17083a(this.f1625a);
        }

        /* renamed from: b */
        private boolean m2241b(C1872hs hsVar) {
            if (C2033bs.m5180a(hsVar, false)) {
                return false;
            }
            if (this.f1627a.booleanValue()) {
                C1524b.m2159c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hsVar.mo17792d());
                C1568ao.m2317a(this.f1625a).mo17138a(hsVar);
                return true;
            }
            this.f1626a.mo17088a(hsVar);
            return true;
        }

        /* renamed from: a */
        public void m2242a(Context context) {
            if (context == null) {
                C1524b.m2141a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f1625a = context;
            this.f1627a = Boolean.valueOf(mo17083a(context));
            mo17087b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        /* renamed from: a */
        public synchronized void mo17084a(String str) {
            if (TextUtils.isEmpty(str)) {
                C1524b.m2141a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f1628a = str;
            mo17087b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        /* renamed from: a */
        public boolean m2244a() {
            return this.f1625a != null;
        }

        /* renamed from: a */
        public synchronized boolean m2245a(C1872hs hsVar) {
            String str;
            boolean z = false;
            if (hsVar == null) {
                return false;
            }
            if (C2033bs.m5180a(hsVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(hsVar.mo17777a()) && TextUtils.isEmpty(this.f1628a);
            boolean z3 = !mo17085a();
            if (this.f1625a == null || m2240b(this.f1625a)) {
                z = true;
            }
            if (!z3 && !z2) {
                if (!z) {
                    C1524b.m2159c("MiTinyDataClient Send item immediately." + hsVar.mo17792d());
                    if (TextUtils.isEmpty(hsVar.mo17792d())) {
                        hsVar.mo17796f(C1999aw.m5064a());
                    }
                    if (TextUtils.isEmpty(hsVar.mo17777a())) {
                        hsVar.mo17779a(this.f1628a);
                    }
                    if (TextUtils.isEmpty(hsVar.mo17788c())) {
                        hsVar.mo17793e(this.f1625a.getPackageName());
                    }
                    if (hsVar.mo17777a() <= 0) {
                        hsVar.mo17783b(System.currentTimeMillis());
                    }
                    return m2241b(hsVar);
                }
            }
            if (z2) {
                str = "MiTinyDataClient Pending " + hsVar.mo17785b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL;
            } else if (z3) {
                str = "MiTinyDataClient Pending " + hsVar.mo17785b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT;
            } else {
                if (z) {
                    str = "MiTinyDataClient Pending " + hsVar.mo17785b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID;
                }
                mo17086a(hsVar);
                return true;
            }
            C1524b.m2159c(str);
            mo17086a(hsVar);
            return true;
        }

        /* renamed from: b */
        public void mo17087b(String str) {
            C1524b.m2159c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f1629a) {
                arrayList.addAll(this.f1629a);
                this.f1629a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                mo17086a((C1872hs) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            C1524b.m2141a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        C1550a.mo17085a().mo17083a(context);
        if (TextUtils.isEmpty(str)) {
            C1524b.m2141a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            C1550a.mo17085a().mo17084a(str);
        }
    }

    public static boolean upload(Context context, C1872hs hsVar) {
        C1524b.m2159c("MiTinyDataClient.upload " + hsVar.mo17792d());
        if (!C1550a.mo17085a().mo17085a()) {
            C1550a.mo17085a().mo17083a(context);
        }
        return C1550a.mo17085a().mo17086a(hsVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        C1872hs hsVar = new C1872hs();
        hsVar.mo17791d(str);
        hsVar.mo17787c(str2);
        hsVar.mo17778a(j);
        hsVar.mo17784b(str3);
        hsVar.mo17781a(true);
        hsVar.mo17779a("push_sdk_channel");
        return upload(context, hsVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        C1872hs hsVar = new C1872hs();
        hsVar.mo17791d(str);
        hsVar.mo17787c(str2);
        hsVar.mo17778a(j);
        hsVar.mo17784b(str3);
        return C1550a.mo17085a().mo17086a(hsVar);
    }
}
