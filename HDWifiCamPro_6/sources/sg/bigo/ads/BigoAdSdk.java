package sg.bigo.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.core.d;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.h.b;
import sg.bigo.ads.common.h.f;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.n.c;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.controller.e.a;
import sg.bigo.ads.controller.e.d;
import sg.bigo.ads.core.a.c;

public class BigoAdSdk {
    /* access modifiers changed from: private */
    public static final AtomicBoolean a = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static final AtomicBoolean b = new AtomicBoolean(false);
    private static a c;
    private static volatile a d;

    /* renamed from: sg.bigo.ads.BigoAdSdk$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[ConsentOptions.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                sg.bigo.ads.ConsentOptions[] r0 = sg.bigo.ads.ConsentOptions.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                sg.bigo.ads.ConsentOptions r1 = sg.bigo.ads.ConsentOptions.GDPR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                sg.bigo.ads.ConsentOptions r1 = sg.bigo.ads.ConsentOptions.CCPA     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.BigoAdSdk.AnonymousClass3.<clinit>():void");
        }
    }

    public interface InitListener {
        void onInitialized();
    }

    public static a a(Context context) {
        if (d == null) {
            d = new a(context);
        }
        if (!d.c) {
            d.m();
        }
        return d;
    }

    public static void a(b bVar, sg.bigo.ads.controller.b bVar2) {
        sg.bigo.ads.controller.a aVar = new sg.bigo.ads.controller.a(bVar2);
        if (!a.get()) {
            aVar.a(0, 1000, 0, "Please initialize SDK before request ads.", (Object) null);
            return;
        }
        a aVar2 = c;
        if (o.b(aVar2.f.a.getAppKey())) {
            aVar.a(0, 1001, 10000, "App Id cannot be null.", (Object) null);
            return;
        }
        d a2 = bVar.a();
        if (a2 != null) {
            aVar.a(0, a2.a, a2.b, a2.c, (Object) null);
            return;
        }
        bVar.c = new b.a((byte) 0);
        b.a aVar3 = bVar.c;
        aVar3.a = UUID.randomUUID().toString();
        aVar3.b = "";
        aVar3.c = "";
        aVar3.d = "";
        aVar3.e = System.currentTimeMillis();
        c.a(3, new Runnable(bVar, aVar) {
            final /* synthetic */ sg.bigo.ads.api.b a;
            final /* synthetic */ sg.bigo.ads.controller.b b;

            {
                this.a = r2;
                this.b = r3;
            }

            public final void run() {
                a.this.l.b();
                final C0129a aVar = new C0129a(this.a, this.b, (byte) 0);
                a.this.g.a((d.a) new d.a() {
                    public final void a() {
                        a.a(a.this, 1);
                        a.a(a.this, aVar);
                        c.a.a().b();
                        c.a.a().a();
                    }

                    public final void a(int i, String str) {
                        if (a.this.c.D()) {
                            a.a(a.this, aVar);
                            c.a.a().b();
                            c.a.a().a();
                            return;
                        }
                        a.this.a(aVar, i, str);
                    }
                }, 1);
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean a(ConsentOptions consentOptions, boolean z) {
        int i = z ? 1 : 2;
        int i2 = AnonymousClass3.a[consentOptions.ordinal()];
        if (i2 != 1) {
            if (i2 != 2 || i == sg.bigo.ads.common.n.a.b()) {
                return false;
            }
            sg.bigo.ads.common.n.a.b(i);
            return true;
        } else if (i == sg.bigo.ads.common.n.a.a()) {
            return false;
        } else {
            sg.bigo.ads.common.n.a.a(i);
            return true;
        }
    }

    public static String getSDKVersion() {
        return "20401";
    }

    public static String getSDKVersionName() {
        return "2.4.1";
    }

    public static void initialize(Context context, AdConfig adConfig, final InitListener initListener) {
        if (a.get()) {
            sg.bigo.ads.common.k.a.a(2, 5, "", "Avoid initializing Bigo Ads SDK repeatedly.");
            return;
        }
        g.a(context);
        g.a(adConfig);
        Context applicationContext = context.getApplicationContext();
        g.a(applicationContext);
        if (!b.getAndSet(true)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean isDebug = adConfig.isDebug();
            sg.bigo.ads.common.o.a.a((int) (System.currentTimeMillis() / 1000));
            sg.bigo.ads.common.n.b.a = applicationContext;
            r.a(isDebug);
            sg.bigo.ads.common.b.a.a = applicationContext;
            sg.bigo.ads.common.l.a.a aVar = new sg.bigo.ads.common.l.a.a();
            sg.bigo.ads.common.l.g.a = aVar;
            aVar.a();
            a aVar2 = new a(applicationContext, adConfig);
            c = aVar2;
            AnonymousClass1 r7 = new Runnable() {
                public final void run() {
                    BigoAdSdk.a.set(true);
                    BigoAdSdk.b.set(false);
                    sg.bigo.ads.common.k.a.a(2, 4, "", "Initialized Bigo Ads SDK successfully.");
                    InitListener initListener = initListener;
                    if (initListener != null) {
                        initListener.onInitialized();
                    }
                }
            };
            aVar2.j = elapsedRealtime;
            sg.bigo.ads.common.f.c.a((c.a) new c.a() {
                public final void a(Throwable th) {
                    sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) null, (int) PathInterpolatorCompat.MAX_NUM_POINTS, 10100, Log.getStackTraceString(th));
                }
            });
            sg.bigo.ads.common.f.c.a(3, new Runnable(r7) {
                final /* synthetic */ Runnable a;

                {
                    this.a = r2;
                }

                /* JADX WARNING: Removed duplicated region for block: B:22:0x0154  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x015a  */
                /* JADX WARNING: Removed duplicated region for block: B:26:0x017e  */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x0184  */
                /* JADX WARNING: Removed duplicated region for block: B:30:0x019b  */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x01a0  */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x02ad  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r14 = this;
                        sg.bigo.ads.controller.e.a r0 = sg.bigo.ads.controller.e.a.this
                        sg.bigo.ads.controller.e.c r1 = r0.f
                        android.content.Context r2 = r1.b
                        java.lang.String r2 = r2.getPackageName()
                        r1.d = r2
                        android.content.Context r2 = r1.b
                        java.lang.String r2 = sg.bigo.ads.common.utils.b.a(r2)
                        r1.e = r2
                        android.content.Context r2 = r1.b
                        int r2 = sg.bigo.ads.common.utils.b.b(r2)
                        r1.f = r2
                        android.content.Context r2 = r1.b
                        java.lang.String r2 = sg.bigo.ads.common.p.b.a((android.content.Context) r2)
                        r1.g = r2
                        java.lang.String r2 = android.os.Build.MANUFACTURER
                        java.lang.String r2 = sg.bigo.ads.common.utils.o.f(r2)
                        r1.h = r2
                        java.lang.String r2 = android.os.Build.MODEL
                        java.lang.String r2 = sg.bigo.ads.common.utils.o.f(r2)
                        r1.i = r2
                        android.content.Context r2 = r1.b
                        java.lang.String r2 = sg.bigo.ads.common.p.b.c(r2)
                        r1.j = r2
                        android.content.Context r2 = r1.b
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        int r4 = sg.bigo.ads.common.utils.d.b(r2)
                        r3.append(r4)
                        java.lang.String r4 = "x"
                        r3.append(r4)
                        int r2 = sg.bigo.ads.common.utils.d.c(r2)
                        r3.append(r2)
                        java.lang.String r2 = r3.toString()
                        r1.k = r2
                        android.content.Context r2 = r1.b
                        float r2 = sg.bigo.ads.common.utils.d.a(r2)
                        r3 = 1092616192(0x41200000, float:10.0)
                        float r2 = r2 * r3
                        int r2 = (int) r2
                        r1.l = r2
                        android.content.Context r2 = r1.b
                        java.lang.String r3 = "com.google.android.gms"
                        android.content.pm.PackageInfo r2 = sg.bigo.ads.common.utils.b.g(r2, r3)
                        if (r2 == 0) goto L_0x0076
                        java.lang.String r2 = r2.versionName
                        r1.m = r2
                    L_0x0076:
                        android.content.Context r2 = r1.b
                        java.lang.String r2 = sg.bigo.ads.common.p.b.e(r2)
                        r1.n = r2
                        int r2 = sg.bigo.ads.common.p.a.a()
                        r1.o = r2
                        long r2 = sg.bigo.ads.common.p.a.b()
                        r1.p = r2
                        android.content.Context r2 = r1.b
                        long r2 = sg.bigo.ads.common.utils.n.b(r2)
                        r1.q = r2
                        android.content.Context r2 = r1.b
                        java.lang.String r3 = r1.d
                        java.lang.String r2 = sg.bigo.ads.common.utils.b.h(r2, r3)
                        r1.r = r2
                        android.content.Context r1 = r0.a
                        sg.bigo.ads.a r1 = sg.bigo.ads.BigoAdSdk.a((android.content.Context) r1)
                        java.lang.String r2 = r1.a
                        boolean r2 = sg.bigo.ads.common.utils.o.b(r2)
                        if (r2 == 0) goto L_0x00b5
                        sg.bigo.ads.api.AdConfig r2 = r0.b
                        java.lang.String r2 = r2.getAppKey()
                        r1.a = r2
                        r1.n()
                    L_0x00b5:
                        sg.bigo.ads.api.AdConfig r2 = r0.b
                        java.lang.String r2 = r2.getAppKey()
                        java.lang.String r1 = r1.a
                        boolean r1 = android.text.TextUtils.equals(r2, r1)
                        if (r1 == 0) goto L_0x00d2
                        sg.bigo.ads.common.l.a r1 = r0.e
                        r1.b()
                        sg.bigo.ads.controller.b.b r1 = r0.c
                        r1.m()
                        sg.bigo.ads.controller.b.d r1 = r0.d
                        r1.m()
                    L_0x00d2:
                        sg.bigo.ads.controller.b.b r1 = r0.c
                        r1.q()
                        sg.bigo.ads.controller.b.b r1 = r0.c
                        sg.bigo.ads.controller.e.c r2 = r0.f
                        java.lang.String r2 = r2.u()
                        boolean r1 = sg.bigo.ads.b.a(r1, r2)
                        if (r1 == 0) goto L_0x00f4
                        sg.bigo.ads.common.l.a r1 = r0.e
                        java.lang.String r2 = sg.bigo.ads.b.a()
                        sg.bigo.ads.controller.b.b r3 = r0.c
                        java.lang.String r3 = r3.p()
                        r1.b(r2, r3)
                    L_0x00f4:
                        sg.bigo.ads.controller.e.f r1 = sg.bigo.ads.controller.e.f.a()
                        sg.bigo.ads.controller.b.b r2 = r0.c
                        sg.bigo.ads.api.a.i r2 = r2.y()
                        r1.a((sg.bigo.ads.api.a.i) r2)
                        android.content.Context r1 = r0.a
                        sg.bigo.ads.controller.e.a$5 r2 = new sg.bigo.ads.controller.e.a$5
                        r2.<init>()
                        sg.bigo.ads.common.c.a.a.a((android.content.Context) r1, (sg.bigo.ads.common.c.a.a.C0121a) r2)
                        sg.bigo.ads.core.e.a.c r1 = sg.bigo.ads.core.e.a.c.a()
                        sg.bigo.ads.controller.b.b r2 = r0.c
                        sg.bigo.ads.api.core.o r2 = r2.a
                        java.util.concurrent.atomic.AtomicBoolean r3 = r1.b
                        r4 = 1
                        boolean r3 = r3.getAndSet(r4)
                        java.lang.String r5 = "RetryTrackerManager"
                        r6 = 3
                        r7 = 0
                        if (r3 == 0) goto L_0x0126
                        java.lang.String r1 = "already init"
                    L_0x0122:
                        sg.bigo.ads.common.k.a.a(r7, r6, r5, r1)
                        goto L_0x0139
                    L_0x0126:
                        r1.c = r2
                        sg.bigo.ads.api.core.o r2 = r1.c
                        boolean r2 = r2.a
                        if (r2 != 0) goto L_0x0131
                        java.lang.String r1 = "config invalid"
                        goto L_0x0122
                    L_0x0131:
                        sg.bigo.ads.core.e.a.c$3 r2 = new sg.bigo.ads.core.e.a.c$3
                        r2.<init>()
                        sg.bigo.ads.common.f.c.a(r4, r2)
                    L_0x0139:
                        sg.bigo.ads.core.d.b r1 = sg.bigo.ads.core.d.b.a()
                        sg.bigo.ads.controller.b.b r2 = r0.c
                        sg.bigo.ads.core.d.a.a r2 = r2.e
                        sg.bigo.ads.controller.d.e r3 = new sg.bigo.ads.controller.d.e
                        sg.bigo.ads.controller.e.c r5 = r0.f
                        r3.<init>(r5)
                        sg.bigo.ads.controller.e.c r5 = r0.f
                        java.util.concurrent.atomic.AtomicBoolean r8 = r1.c
                        boolean r8 = r8.getAndSet(r4)
                        java.lang.String r9 = "already init."
                        if (r8 == 0) goto L_0x015a
                        java.lang.String r1 = "Stats"
                        sg.bigo.ads.common.k.a.a(r7, r6, r1, r9)
                        goto L_0x0165
                    L_0x015a:
                        r1.a = r2
                        sg.bigo.ads.core.d.b.b r2 = new sg.bigo.ads.core.d.b.b
                        sg.bigo.ads.core.d.a.a r8 = r1.a
                        r2.<init>(r8, r3, r5)
                        r1.b = r2
                    L_0x0165:
                        sg.bigo.ads.core.b.b r1 = sg.bigo.ads.core.b.b.a()
                        sg.bigo.ads.controller.b.b r2 = r0.c
                        sg.bigo.ads.core.b.a.a r2 = r2.f
                        sg.bigo.ads.controller.d.b r3 = new sg.bigo.ads.controller.d.b
                        sg.bigo.ads.controller.e.c r5 = r0.f
                        r3.<init>(r5)
                        sg.bigo.ads.controller.e.c r5 = r0.f
                        java.util.concurrent.atomic.AtomicBoolean r8 = r1.b
                        boolean r8 = r8.getAndSet(r4)
                        if (r8 == 0) goto L_0x0184
                        java.lang.String r1 = "Callback"
                        sg.bigo.ads.common.k.a.a(r7, r6, r1, r9)
                        goto L_0x018b
                    L_0x0184:
                        sg.bigo.ads.core.b.b.a r8 = new sg.bigo.ads.core.b.b.a
                        r8.<init>(r2, r3, r5)
                        r1.a = r8
                    L_0x018b:
                        sg.bigo.ads.controller.b.b r1 = r0.c
                        sg.bigo.ads.common.d.a.a r1 = r1.d
                        sg.bigo.ads.core.player.a r2 = sg.bigo.ads.core.player.a.a()
                        java.util.concurrent.atomic.AtomicBoolean r3 = r2.b
                        boolean r3 = r3.getAndSet(r4)
                        if (r3 == 0) goto L_0x01a0
                        r1 = 0
                        sg.bigo.ads.common.d.b.a((java.lang.String) r9, (sg.bigo.ads.common.d.a) r1)
                        goto L_0x01c9
                    L_0x01a0:
                        r2.f = r1
                        sg.bigo.ads.common.d.b r3 = new sg.bigo.ads.common.d.b
                        sg.bigo.ads.common.d.a.a r5 = r2.f
                        r3.<init>(r5, r2)
                        r2.e = r3
                        java.util.ArrayList r3 = new java.util.ArrayList
                        r3.<init>()
                        r2.c = r3
                        java.util.Hashtable r3 = new java.util.Hashtable
                        r3.<init>()
                        r2.d = r3
                        r2.c()
                        sg.bigo.ads.common.h.f r2 = sg.bigo.ads.common.h.f.a.a
                        r2.c = r1
                        sg.bigo.ads.common.h.f r1 = sg.bigo.ads.common.h.f.a.a
                        r1.b()
                    L_0x01c9:
                        android.content.Context r1 = r0.a
                        sg.bigo.ads.controller.b.b r2 = r0.c
                        sg.bigo.ads.core.a.a r2 = r2.h
                        java.lang.String r2 = r2.a
                        sg.bigo.ads.common.utils.b.b(r1, r2)
                        sg.bigo.ads.core.a.c r1 = sg.bigo.ads.core.a.c.a.a()
                        sg.bigo.ads.controller.b.b r2 = r0.c
                        sg.bigo.ads.core.a.b r2 = r2.g
                        sg.bigo.ads.controller.b.b r3 = r0.c
                        sg.bigo.ads.core.a.a r3 = r3.h
                        sg.bigo.ads.controller.b.b r5 = r0.c
                        sg.bigo.ads.controller.d.a r8 = new sg.bigo.ads.controller.d.a
                        sg.bigo.ads.controller.e.c r9 = r0.f
                        r8.<init>(r9)
                        sg.bigo.ads.controller.d.d r9 = new sg.bigo.ads.controller.d.d
                        sg.bigo.ads.controller.e.c r10 = r0.f
                        r9.<init>(r10)
                        sg.bigo.ads.controller.d.c r10 = new sg.bigo.ads.controller.d.c
                        sg.bigo.ads.controller.e.c r11 = r0.f
                        sg.bigo.ads.controller.b.b r12 = r0.c
                        r10.<init>(r11, r12)
                        sg.bigo.ads.controller.e.c r11 = r0.f
                        java.lang.String r12 = "AppCheckReport"
                        java.lang.String r13 = "AppCheckController initialized."
                        sg.bigo.ads.common.k.a.a(r7, r6, r12, r13)
                        r1.b = r2
                        r1.a = r5
                        sg.bigo.ads.core.a.i r5 = new sg.bigo.ads.core.a.i
                        android.content.Context r6 = sg.bigo.ads.common.b.a.a
                        r5.<init>(r6, r11)
                        r1.c = r5
                        sg.bigo.ads.core.a.i r5 = new sg.bigo.ads.core.a.i
                        android.content.Context r6 = sg.bigo.ads.common.b.a.a
                        java.lang.String r12 = "dsp_sdk_report.dat.dat"
                        r5.<init>(r6, r11, r12)
                        r1.d = r5
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
                        java.lang.String r6 = "last_app_list_time"
                        java.lang.Object r5 = sg.bigo.ads.common.n.b.b(r6, r5, r4)
                        java.lang.Long r5 = (java.lang.Long) r5
                        long r5 = r5.longValue()
                        r1.e = r5
                        sg.bigo.ads.core.a.h r5 = new sg.bigo.ads.core.a.h
                        sg.bigo.ads.core.a.i r6 = r1.c
                        r5.<init>(r6, r8)
                        r1.f = r5
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
                        java.lang.String r6 = "last_app_check_time"
                        java.lang.Object r5 = sg.bigo.ads.common.n.b.b(r6, r5, r4)
                        java.lang.Long r5 = (java.lang.Long) r5
                        long r5 = r5.longValue()
                        r1.h = r5
                        sg.bigo.ads.core.a.e r5 = new sg.bigo.ads.core.a.e
                        r5.<init>(r1)
                        r1.i = r5
                        sg.bigo.ads.core.a.o r5 = new sg.bigo.ads.core.a.o
                        r5.<init>()
                        r1.g = r5
                        sg.bigo.ads.core.a.c$1 r5 = new sg.bigo.ads.core.a.c$1
                        r5.<init>(r1)
                        sg.bigo.ads.common.f.c.a(r4, r5)
                        sg.bigo.ads.core.a.n r5 = sg.bigo.ads.core.a.n.a.a
                        sg.bigo.ads.core.a.i r6 = r1.c
                        r5.a = r2
                        r5.b = r6
                        r5.d = r9
                        sg.bigo.ads.core.a.o r2 = new sg.bigo.ads.core.a.o
                        r2.<init>()
                        r5.c = r2
                        sg.bigo.ads.core.a.n$1 r2 = new sg.bigo.ads.core.a.n$1
                        r2.<init>()
                        sg.bigo.ads.common.f.c.a(r4, r2)
                        sg.bigo.ads.core.a.f r2 = sg.bigo.ads.core.a.f.a.a
                        sg.bigo.ads.core.a.i r5 = r1.d
                        sg.bigo.ads.core.a.j r6 = new sg.bigo.ads.core.a.j
                        r6.<init>(r5, r10)
                        r2.b = r6
                        r2.c = r3
                        sg.bigo.ads.core.a.f$1 r3 = new sg.bigo.ads.core.a.f$1
                        r3.<init>()
                        sg.bigo.ads.common.f.c.a(r4, r3)
                        r1.a()
                        sg.bigo.ads.controller.e.a$6 r1 = new sg.bigo.ads.controller.e.a$6
                        r1.<init>()
                        sg.bigo.ads.common.f.c.b(r1)
                        android.content.Context r1 = sg.bigo.ads.common.b.a.a
                        sg.bigo.ads.controller.g.a.a(r1, r0)
                        android.content.Context r1 = r0.a
                        sg.bigo.ads.common.p.b.f(r1)
                        sg.bigo.ads.controller.e.a$b r0 = r0.l
                        r0.a()
                        java.lang.Runnable r0 = r14.a
                        if (r0 == 0) goto L_0x02b0
                        r0.run()
                    L_0x02b0:
                        sg.bigo.ads.controller.e.a r0 = sg.bigo.ads.controller.e.a.this
                        sg.bigo.ads.controller.e.a.a((sg.bigo.ads.controller.e.a) r0, (int) r7)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.e.a.AnonymousClass4.run():void");
                }
            });
        }
    }

    public static boolean isInitialized() {
        return a.get();
    }

    public static void setUserConsent(Context context, final ConsentOptions consentOptions, boolean z) {
        if (!(sg.bigo.ads.common.n.b.a != null)) {
            sg.bigo.ads.common.n.b.a = context.getApplicationContext();
        }
        sg.bigo.ads.common.k.a.a(2, 4, "", "Update the consent status from user: ".concat(String.valueOf(z)));
        boolean a2 = a(consentOptions, z);
        if (!z && a2) {
            sg.bigo.ads.common.f.c.a(1, new Runnable() {
                public final void run() {
                    sg.bigo.ads.common.k.a.a(2, 5, "", "Revoking user consent...The cached data of user will be deleted now.");
                    sg.bigo.ads.core.d.b a2 = sg.bigo.ads.core.d.b.a();
                    if (a2.b != null) {
                        a2.b.c.f();
                    }
                    sg.bigo.ads.core.b.b a3 = sg.bigo.ads.core.b.b.a();
                    if (a3.a != null) {
                        a3.a.b.g();
                    }
                    sg.bigo.ads.core.e.a.c a4 = sg.bigo.ads.core.e.a.c.a();
                    a4.b();
                    a4.a.clear();
                    sg.bigo.ads.core.player.a a5 = sg.bigo.ads.core.player.a.a();
                    if (a5.e != null) {
                        sg.bigo.ads.common.d.b bVar = a5.e;
                        sg.bigo.ads.common.d.b.b.b();
                        bVar.a.clear();
                        bVar.c.clear();
                        bVar.b.clear();
                        bVar.d.clear();
                    }
                    if (a5.c != null) {
                        a5.c.clear();
                    }
                    if (a5.d != null) {
                        a5.d.clear();
                    }
                    f a6 = f.a.a;
                    a6.b.clear();
                    a6.a.clear();
                    b.a.a.a.evictAll();
                    e.b(new File(i.a()));
                    sg.bigo.ads.common.c.a.a.c();
                    try {
                        SharedPreferences.Editor a7 = sg.bigo.ads.common.n.b.a("sp_ads");
                        a7.clear();
                        c.a.a();
                        c.a.C0125a.a(a7);
                    } catch (Exception e) {
                        sg.bigo.ads.common.k.a.a(0, "SharedPreferenceManager", Log.getStackTraceString(e));
                    }
                    boolean unused = BigoAdSdk.a(consentOptions, false);
                }
            });
        }
    }
}
