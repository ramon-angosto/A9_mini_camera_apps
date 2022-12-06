package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import com.adcolony.adcolonysdk.BuildConfig;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.o;
import com.adcolony.sdk.z0;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

public class AdColony {
    private static ExecutorService a = z0.h();

    class a implements Runnable {
        final /* synthetic */ k a;
        final /* synthetic */ t0 b;
        final /* synthetic */ AdColonySignalsListener c;

        /* renamed from: com.adcolony.sdk.AdColony$a$a  reason: collision with other inner class name */
        class C0004a implements Runnable {
            final /* synthetic */ String a;

            C0004a(String str) {
                this.a = str;
            }

            public void run() {
                if (!this.a.isEmpty()) {
                    a.this.c.onSuccess(this.a);
                } else {
                    a.this.c.onFailure();
                }
            }
        }

        a(k kVar, t0 t0Var, AdColonySignalsListener adColonySignalsListener) {
            this.a = kVar;
            this.b = t0Var;
            this.c = adColonySignalsListener;
        }

        public void run() {
            k kVar = this.a;
            z0.b((Runnable) new C0004a(AdColony.b(kVar, this.b, kVar.y())));
        }
    }

    class b implements Runnable {
        final /* synthetic */ AdColonyAdViewListener a;
        final /* synthetic */ String b;

        b(AdColonyAdViewListener adColonyAdViewListener, String str) {
            this.a = adColonyAdViewListener;
            this.b = str;
        }

        public void run() {
            this.a.onRequestNotFilled(AdColony.a(this.b));
        }
    }

    class c implements Callable<f1> {
        final /* synthetic */ long a;

        c(long j) {
            this.a = j;
        }

        /* renamed from: b */
        public f1 call() {
            return AdColony.b(this.a);
        }
    }

    class d implements Runnable {
        final /* synthetic */ double a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        d(double d2, String str, String str2, String str3) {
            this.a = d2;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        public void run() {
            AdColony.b();
            f1 b2 = c0.b();
            double d2 = this.a;
            if (d2 >= 0.0d) {
                c0.a(b2, "price", d2);
            }
            String str = this.b;
            if (str != null && str.length() <= 3) {
                c0.a(b2, "currency_code", this.b);
            }
            c0.a(b2, "product_id", this.c);
            c0.a(b2, "transaction_id", this.d);
            new h0("AdColony.on_iap_report", 1, b2).c();
        }
    }

    class e implements z0.b {
        private boolean a;
        final /* synthetic */ AdColonyAdViewListener b;
        final /* synthetic */ String c;
        final /* synthetic */ z0.c d;

        e(AdColonyAdViewListener adColonyAdViewListener, String str, z0.c cVar) {
            this.b = adColonyAdViewListener;
            this.c = str;
            this.d = cVar;
        }

        public boolean a() {
            return this.a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            r0 = new com.adcolony.sdk.e0.a().a("RequestNotFilled called due to a native timeout. ");
            r0 = r0.a("Timeout set to: " + r6.d.b() + " ms. ");
            r0.a("Execution took: " + (java.lang.System.currentTimeMillis() - r6.d.c()) + " ms. ").a("AdView request not yet started.").a(com.adcolony.sdk.e0.i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            com.adcolony.sdk.AdColony.a(r6.b, r6.c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
            if (r6.d.a() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                monitor-enter(r6)
                boolean r0 = r6.a     // Catch:{ all -> 0x0076 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r6)     // Catch:{ all -> 0x0076 }
                return
            L_0x0007:
                r0 = 1
                r6.a = r0     // Catch:{ all -> 0x0076 }
                monitor-exit(r6)     // Catch:{ all -> 0x0076 }
                com.adcolony.sdk.AdColonyAdViewListener r0 = r6.b
                java.lang.String r1 = r6.c
                com.adcolony.sdk.AdColony.a((com.adcolony.sdk.AdColonyAdViewListener) r0, (java.lang.String) r1)
                com.adcolony.sdk.z0$c r0 = r6.d
                boolean r0 = r0.a()
                if (r0 == 0) goto L_0x0075
                com.adcolony.sdk.e0$a r0 = new com.adcolony.sdk.e0$a
                r0.<init>()
                java.lang.String r1 = "RequestNotFilled called due to a native timeout. "
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Timeout set to: "
                r1.append(r2)
                com.adcolony.sdk.z0$c r2 = r6.d
                long r2 = r2.b()
                r1.append(r2)
                java.lang.String r2 = " ms. "
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Execution took: "
                r1.append(r2)
                long r2 = java.lang.System.currentTimeMillis()
                com.adcolony.sdk.z0$c r4 = r6.d
                long r4 = r4.c()
                long r2 = r2 - r4
                r1.append(r2)
                java.lang.String r2 = " ms. "
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.String r1 = "AdView request not yet started."
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.i
                r0.a((com.adcolony.sdk.e0) r1)
            L_0x0075:
                return
            L_0x0076:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0076 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.AdColony.e.run():void");
        }
    }

    class f implements Runnable {
        final /* synthetic */ z0.b a;
        final /* synthetic */ String b;
        final /* synthetic */ AdColonyAdViewListener c;
        final /* synthetic */ AdColonyAdSize d;
        final /* synthetic */ AdColonyAdOptions e;
        final /* synthetic */ z0.c f;

        f(z0.b bVar, String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions, z0.c cVar) {
            this.a = bVar;
            this.b = str;
            this.c = adColonyAdViewListener;
            this.d = adColonyAdSize;
            this.e = adColonyAdOptions;
            this.f = cVar;
        }

        public void run() {
            k b2 = a.b();
            if (b2.E() || b2.F()) {
                AdColony.f();
                z0.a(this.a);
            } else if (AdColony.b() || !a.c()) {
                z0.c((Runnable) this.a);
                if (!this.a.a()) {
                    b2.c().a(this.b, this.c, this.d, this.e, this.f.d());
                }
            } else {
                z0.a(this.a);
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ AdColonyAppOptions a;

        g(AdColonyAppOptions adColonyAppOptions) {
            this.a = adColonyAppOptions;
        }

        public void run() {
            AdColony.b();
            f1 b = c0.b();
            c0.a(b, "options", this.a.b());
            new h0("Options.set_options", 1, b).c();
        }
    }

    class h implements z0.b {
        private boolean a;
        final /* synthetic */ AdColonyInterstitialListener b;
        final /* synthetic */ String c;
        final /* synthetic */ z0.c d;

        h(AdColonyInterstitialListener adColonyInterstitialListener, String str, z0.c cVar) {
            this.b = adColonyInterstitialListener;
            this.c = str;
            this.d = cVar;
        }

        public boolean a() {
            return this.a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            r0 = new com.adcolony.sdk.e0.a().a("RequestNotFilled called due to a native timeout. ");
            r0 = r0.a("Timeout set to: " + r6.d.b() + " ms. ");
            r0.a("Execution took: " + (java.lang.System.currentTimeMillis() - r6.d.c()) + " ms. ").a("Interstitial request not yet started.").a(com.adcolony.sdk.e0.i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            com.adcolony.sdk.AdColony.a(r6.b, r6.c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
            if (r6.d.a() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                monitor-enter(r6)
                boolean r0 = r6.a     // Catch:{ all -> 0x0076 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r6)     // Catch:{ all -> 0x0076 }
                return
            L_0x0007:
                r0 = 1
                r6.a = r0     // Catch:{ all -> 0x0076 }
                monitor-exit(r6)     // Catch:{ all -> 0x0076 }
                com.adcolony.sdk.AdColonyInterstitialListener r0 = r6.b
                java.lang.String r1 = r6.c
                com.adcolony.sdk.AdColony.a((com.adcolony.sdk.AdColonyInterstitialListener) r0, (java.lang.String) r1)
                com.adcolony.sdk.z0$c r0 = r6.d
                boolean r0 = r0.a()
                if (r0 == 0) goto L_0x0075
                com.adcolony.sdk.e0$a r0 = new com.adcolony.sdk.e0$a
                r0.<init>()
                java.lang.String r1 = "RequestNotFilled called due to a native timeout. "
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Timeout set to: "
                r1.append(r2)
                com.adcolony.sdk.z0$c r2 = r6.d
                long r2 = r2.b()
                r1.append(r2)
                java.lang.String r2 = " ms. "
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Execution took: "
                r1.append(r2)
                long r2 = java.lang.System.currentTimeMillis()
                com.adcolony.sdk.z0$c r4 = r6.d
                long r4 = r4.c()
                long r2 = r2 - r4
                r1.append(r2)
                java.lang.String r2 = " ms. "
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.String r1 = "Interstitial request not yet started."
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.i
                r0.a((com.adcolony.sdk.e0) r1)
            L_0x0075:
                return
            L_0x0076:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0076 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.AdColony.h.run():void");
        }
    }

    class i implements Runnable {
        final /* synthetic */ z0.b a;
        final /* synthetic */ String b;
        final /* synthetic */ AdColonyInterstitialListener c;
        final /* synthetic */ AdColonyAdOptions d;
        final /* synthetic */ z0.c e;

        i(z0.b bVar, String str, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions, z0.c cVar) {
            this.a = bVar;
            this.b = str;
            this.c = adColonyInterstitialListener;
            this.d = adColonyAdOptions;
            this.e = cVar;
        }

        public void run() {
            k b2 = a.b();
            if (b2.E() || b2.F()) {
                AdColony.f();
                z0.a(this.a);
            } else if (AdColony.b() || !a.c()) {
                AdColonyZone adColonyZone = b2.C().get(this.b);
                if (adColonyZone == null) {
                    adColonyZone = new AdColonyZone(this.b);
                }
                if (adColonyZone.getZoneType() == 2 || adColonyZone.getZoneType() == 1) {
                    z0.a(this.a);
                    return;
                }
                z0.c((Runnable) this.a);
                if (!this.a.a()) {
                    b2.c().a(this.b, this.c, this.d, this.e.d());
                }
            } else {
                z0.a(this.a);
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ AdColonyInterstitialListener a;
        final /* synthetic */ String b;

        j(AdColonyInterstitialListener adColonyInterstitialListener, String str) {
            this.a = adColonyInterstitialListener;
            this.b = str;
        }

        public void run() {
            this.a.onRequestNotFilled(AdColony.a(this.b));
        }
    }

    public static boolean addCustomMessageListener(AdColonyCustomMessageListener adColonyCustomMessageListener, String str) {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.addCustomMessageListener as AdColony ").a("has not yet been configured.").a(e0.f);
            return false;
        } else if (!z0.e(str)) {
            new e0.a().a("Ignoring call to AdColony.addCustomMessageListener.").a(e0.f);
            return false;
        } else {
            a.b().m().put(str, adColonyCustomMessageListener);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static String b(k kVar, t0 t0Var, long j2) {
        q n = kVar.n();
        ArrayList arrayList = new ArrayList(Arrays.asList(new f1[]{z0.c(kVar.u().b()), z0.a(n.d())}));
        if (j2 > 0) {
            q0 q0Var = new q0();
            if (n.N()) {
                arrayList.add(n.b());
            } else {
                q0Var.a(n.a(j2));
            }
            if (n.O()) {
                arrayList.add(n.c());
            } else {
                q0Var.a(n.b(j2));
            }
            if (kVar.G()) {
                q0Var.a(new c(j2));
            } else {
                arrayList.add(d());
            }
            if (!q0Var.b()) {
                arrayList.addAll(q0Var.a());
            }
        } else {
            arrayList.add(n.b());
            arrayList.add(n.c());
            arrayList.add(d());
        }
        arrayList.add(kVar.e());
        f1 a2 = c0.a((f1[]) arrayList.toArray(new f1[0]));
        t0Var.c();
        c0.b(a2, "signals_count", t0Var.b());
        c0.b(a2, "device_audio", e());
        a2.e();
        byte[] bytes = a2.toString().getBytes(h.a);
        if (kVar.H()) {
            return a(bytes);
        }
        return Base64.encodeToString(bytes, 0);
    }

    static void c() {
        if (a.isShutdown()) {
            a = Executors.newSingleThreadExecutor();
        }
    }

    public static boolean clearCustomMessageListeners() {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.clearCustomMessageListeners as AdColony").a(" has not yet been configured.").a(e0.f);
            return false;
        }
        a.b().m().clear();
        return true;
    }

    public static void collectSignals(AdColonySignalsListener adColonySignalsListener) {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.collectSignals() as AdColony has not yet been configured.").a(e0.f);
            adColonySignalsListener.onFailure();
            return;
        }
        k b2 = a.b();
        if (!a((Runnable) new a(b2, b2.x(), adColonySignalsListener))) {
            adColonySignalsListener.onFailure();
        }
    }

    @Deprecated
    public static boolean configure(Activity activity, String str, String... strArr) {
        return a((Context) activity, (AdColonyAppOptions) null, str);
    }

    private static f1 d() {
        return b(-1);
    }

    public static boolean disable() {
        if (!a.e()) {
            return false;
        }
        Context a2 = a.a();
        if (a2 != null && (a2 instanceof b)) {
            ((Activity) a2).finish();
        }
        k b2 = a.b();
        b2.c().b();
        b2.R();
        b2.T();
        b2.b(true);
        return true;
    }

    private static boolean e() {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        return z0.b(z0.a(a2));
    }

    /* access modifiers changed from: private */
    public static void f() {
        new e0.a().a("The AdColony API is not available while AdColony is disabled.").a(e0.h);
    }

    static void g() {
        a.shutdown();
    }

    public static AdColonyAppOptions getAppOptions() {
        if (!a.e()) {
            return null;
        }
        return a.b().u();
    }

    public static AdColonyCustomMessageListener getCustomMessageListener(String str) {
        if (!a.e()) {
            return null;
        }
        return a.b().m().get(str);
    }

    public static AdColonyRewardListener getRewardListener() {
        if (!a.e()) {
            return null;
        }
        return a.b().w();
    }

    public static String getSDKVersion() {
        if (!a.e()) {
            return "";
        }
        return a.b().n().I();
    }

    public static AdColonyZone getZone(String str) {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.getZone() as AdColony has not yet been ").a("configured.").a(e0.f);
            return null;
        }
        HashMap<String, AdColonyZone> C = a.b().C();
        if (C.containsKey(str)) {
            return C.get(str);
        }
        AdColonyZone adColonyZone = new AdColonyZone(str);
        a.b().C().put(str, adColonyZone);
        return adColonyZone;
    }

    public static boolean notifyIAPComplete(String str, String str2) {
        return notifyIAPComplete(str, str2, (String) null, 0.0d);
    }

    public static boolean removeCustomMessageListener(String str) {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.removeCustomMessageListener as AdColony").a(" has not yet been configured.").a(e0.f);
            return false;
        }
        a.b().m().remove(str);
        return true;
    }

    public static boolean removeRewardListener() {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.removeRewardListener() as AdColony has ").a("not yet been configured.").a(e0.f);
            return false;
        }
        a.b().a((AdColonyRewardListener) null);
        return true;
    }

    public static boolean requestAdView(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize) {
        return requestAdView(str, adColonyAdViewListener, adColonyAdSize, (AdColonyAdOptions) null);
    }

    public static boolean requestInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener) {
        return requestInterstitial(str, adColonyInterstitialListener, (AdColonyAdOptions) null);
    }

    public static boolean setAppOptions(AdColonyAppOptions adColonyAppOptions) {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.setAppOptions() as AdColony has not yet").a(" been configured.").a(e0.f);
            return false;
        }
        if (adColonyAppOptions == null) {
            adColonyAppOptions = new AdColonyAppOptions();
        }
        a.a(adColonyAppOptions);
        if (a.d()) {
            k b2 = a.b();
            if (b2.D()) {
                adColonyAppOptions.a(b2.u().a());
            }
        }
        a.b().b(adColonyAppOptions);
        Context a2 = a.a();
        if (a2 != null) {
            adColonyAppOptions.b(a2);
        }
        return a((Runnable) new g(adColonyAppOptions));
    }

    public static boolean setRewardListener(AdColonyRewardListener adColonyRewardListener) {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.setRewardListener() as AdColony has not").a(" yet been configured.").a(e0.f);
            return false;
        }
        a.b().a(adColonyRewardListener);
        return true;
    }

    @Deprecated
    public static boolean configure(Activity activity, AdColonyAppOptions adColonyAppOptions, String str, String... strArr) {
        return a((Context) activity, adColonyAppOptions, str);
    }

    public static boolean notifyIAPComplete(String str, String str2, String str3, double d2) {
        if (!a.e()) {
            new e0.a().a("Ignoring call to notifyIAPComplete as AdColony has not yet been ").a("configured.").a(e0.f);
            return false;
        } else if (!z0.e(str) || !z0.e(str2)) {
            new e0.a().a("Ignoring call to notifyIAPComplete as one of the passed Strings ").a("is greater than ").a(128).a(" characters.").a(e0.f);
            return false;
        } else {
            if (str3 != null && str3.length() > 3) {
                new e0.a().a("You are trying to report an IAP event with a currency String ").a("containing more than 3 characters.").a(e0.f);
            }
            if (a((Runnable) new d(d2, str3, str, str2))) {
                return true;
            }
            new e0.a().a("Executing AdColony.notifyIAPComplete failed").a(e0.i);
            return false;
        }
    }

    public static boolean requestAdView(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
        if (adColonyAdViewListener == null) {
            new e0.a().a("AdColonyAdViewListener is set to null. ").a("It is required to be non null.").a(e0.f);
        }
        if (!a.e()) {
            new e0.a().a("Ignoring call to requestAdView as AdColony has not yet been").a(" configured.").a(e0.f);
            a(adColonyAdViewListener, str);
            return false;
        } else if (adColonyAdSize.getHeight() <= 0 || adColonyAdSize.getWidth() <= 0) {
            new e0.a().a("Ignoring call to requestAdView as you've provided an AdColonyAdSize").a(" object with an invalid width or height.").a(e0.f);
            a(adColonyAdViewListener, str);
            return false;
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(AdColonyAdapterUtils.KEY_ZONE_ID, str);
            if (r0.a(1, bundle)) {
                a(adColonyAdViewListener, str);
                return false;
            }
            z0.c cVar = new z0.c(a.b().d());
            e eVar = new e(adColonyAdViewListener, str, cVar);
            z0.a((Runnable) eVar, cVar.d());
            if (a((Runnable) new f(eVar, str, adColonyAdViewListener, adColonyAdSize, adColonyAdOptions, cVar))) {
                return true;
            }
            z0.a((z0.b) eVar);
            return false;
        }
    }

    public static boolean requestInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions) {
        if (adColonyInterstitialListener == null) {
            new e0.a().a("AdColonyInterstitialListener is set to null. ").a("It is required to be non null.").a(e0.f);
        }
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.requestInterstitial as AdColony has not").a(" yet been configured.").a(e0.f);
            a(adColonyInterstitialListener, str);
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AdColonyAdapterUtils.KEY_ZONE_ID, str);
        if (r0.a(1, bundle)) {
            a(adColonyInterstitialListener, str);
            return false;
        }
        z0.c cVar = new z0.c(a.b().d());
        h hVar = new h(adColonyInterstitialListener, str, cVar);
        z0.a((Runnable) hVar, cVar.d());
        if (a((Runnable) new i(hVar, str, adColonyInterstitialListener, adColonyAdOptions, cVar))) {
            return true;
        }
        z0.a((z0.b) hVar);
        return false;
    }

    @Deprecated
    public static boolean configure(Application application, String str, String... strArr) {
        return configure(application, (AdColonyAppOptions) null, str);
    }

    static boolean a(Runnable runnable) {
        return z0.a(a, runnable);
    }

    @Deprecated
    public static boolean configure(Application application, AdColonyAppOptions adColonyAppOptions, String str, String... strArr) {
        return a((Context) application, adColonyAppOptions, str);
    }

    private static String a(k kVar, t0 t0Var) {
        return b(kVar, t0Var, -1);
    }

    public static boolean configure(Activity activity, String str) {
        return a((Context) activity, (AdColonyAppOptions) null, str);
    }

    static String a(byte[] bArr) {
        g gVar = new g(BuildConfig.COLLECT_SIGNALS_DICT_ID, "", BuildConfig.COLLECT_SIGNALS_DICT, "");
        try {
            byte[] a2 = gVar.a(bArr);
            f1 b2 = c0.b();
            b2.a(CampaignUnit.JSON_KEY_SESSION_ID, gVar.b());
            b2.a("b", Base64.encodeToString(a2, 0));
            return b2.toString();
        } catch (UnsupportedEncodingException | JSONException unused) {
            return Base64.encodeToString(bArr, 0);
        }
    }

    public static boolean configure(Activity activity, AdColonyAppOptions adColonyAppOptions, String str) {
        return a((Context) activity, adColonyAppOptions, str);
    }

    public static boolean configure(Application application, String str) {
        return configure(application, (AdColonyAppOptions) null, str);
    }

    public static boolean configure(Application application, AdColonyAppOptions adColonyAppOptions, String str) {
        return a((Context) application, adColonyAppOptions, str);
    }

    private static boolean a(Context context, AdColonyAppOptions adColonyAppOptions, String str) {
        if (r0.a(0, (Bundle) null)) {
            new e0.a().a("Cannot configure AdColony; configuration mechanism requires 5 ").a("seconds between attempts.").a(e0.f);
            return false;
        }
        if (context == null) {
            context = a.a();
        }
        if (context == null) {
            new e0.a().a("Ignoring call to AdColony.configure() as the provided Activity or ").a("Application context is null and we do not currently hold a ").a("reference to either for our use.").a(e0.f);
            return false;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (adColonyAppOptions == null) {
            adColonyAppOptions = new AdColonyAppOptions();
        }
        if (a.d() && !c0.b(a.b().u().b(), "reconfigurable") && !a.b().u().a().equals(str)) {
            new e0.a().a("Ignoring call to AdColony.configure() as the app id does not ").a("match what was used during the initial configuration.").a(e0.f);
            return false;
        } else if (str.equals("")) {
            new e0.a().a("AdColony.configure() called with an empty app id String.").a(e0.h);
            return false;
        } else {
            a.c = true;
            adColonyAppOptions.a(str);
            if (Build.VERSION.SDK_INT < 21) {
                new e0.a().a("The minimum API level for the AdColony SDK is ").a(21).a(".").a(e0.f);
                a.a(context, adColonyAppOptions, true);
            } else {
                a.a(context, adColonyAppOptions, false);
            }
            f1 b2 = c0.b();
            c0.a(b2, "appId", str);
            c0.j(b2, a.b().z().f() + "/adc3/AppInfo");
            return true;
        }
    }

    @Deprecated
    public static String collectSignals() {
        if (!a.e()) {
            new e0.a().a("Ignoring call to AdColony.collectSignals() as AdColony has not yet been configured.").a(e0.f);
            return "";
        }
        k b2 = a.b();
        return a(b2, b2.x());
    }

    /* access modifiers changed from: private */
    public static f1 b(long j2) {
        o.b bVar;
        f1 b2 = c0.b();
        if (j2 > 0) {
            bVar = o0.c().a(j2);
        } else {
            bVar = o0.c().b();
        }
        if (bVar != null) {
            c0.a(b2, "odt_payload", bVar.b());
        }
        return b2;
    }

    static boolean b() {
        k b2 = a.b();
        b2.a(15000);
        return b2.I();
    }

    static AdColonyZone a(String str) {
        AdColonyZone adColonyZone;
        if (a.c()) {
            adColonyZone = a.b().C().get(str);
        } else {
            adColonyZone = a.d() ? a.b().C().get(str) : null;
        }
        if (adColonyZone != null) {
            return adColonyZone;
        }
        AdColonyZone adColonyZone2 = new AdColonyZone(str);
        adColonyZone2.c(6);
        return adColonyZone2;
    }

    static void a(AdColonyInterstitialListener adColonyInterstitialListener, String str) {
        if (adColonyInterstitialListener != null) {
            z0.b((Runnable) new j(adColonyInterstitialListener, str));
        }
    }

    static void a(AdColonyAdViewListener adColonyAdViewListener, String str) {
        if (adColonyAdViewListener != null) {
            z0.b((Runnable) new b(adColonyAdViewListener, str));
        }
    }

    static void a(Context context, AdColonyAppOptions adColonyAppOptions) {
        k b2 = a.b();
        q n = b2.n();
        if (adColonyAppOptions != null && context != null) {
            String d2 = z0.d(context);
            String c2 = z0.c();
            int d3 = z0.d();
            String m = n.m();
            String e2 = b2.s().e();
            HashMap hashMap = new HashMap();
            hashMap.put("sessionId", "unknown");
            hashMap.put("countryLocale", Locale.getDefault().getDisplayLanguage() + " (" + Locale.getDefault().getDisplayCountry() + ")");
            hashMap.put("countryLocaleShort", a.b().n().p());
            hashMap.put("manufacturer", a.b().n().C());
            hashMap.put("model", a.b().n().F());
            hashMap.put("osVersion", a.b().n().H());
            hashMap.put("carrierName", m);
            hashMap.put("networkType", e2);
            hashMap.put("platform", "android");
            hashMap.put("appName", d2);
            hashMap.put("appVersion", c2);
            hashMap.put("appBuildNumber", Integer.valueOf(d3));
            hashMap.put("appId", "" + adColonyAppOptions.a());
            hashMap.put("apiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("sdkVersion", a.b().n().I());
            hashMap.put("controllerVersion", "unknown");
            f1 f1Var = new f1(adColonyAppOptions.getMediationInfo());
            f1 f1Var2 = new f1(adColonyAppOptions.getPluginInfo());
            if (!c0.h(f1Var, "mediation_network").equals("")) {
                hashMap.put("mediationNetwork", c0.h(f1Var, "mediation_network"));
                hashMap.put("mediationNetworkVersion", c0.h(f1Var, "mediation_network_version"));
            }
            if (!c0.h(f1Var2, "plugin").equals("")) {
                hashMap.put("plugin", c0.h(f1Var2, "plugin"));
                hashMap.put("pluginVersion", c0.h(f1Var2, "plugin_version"));
            }
            b2.q().a((HashMap<String, Object>) hashMap);
        }
    }
}
