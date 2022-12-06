package com.adcolony.sdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.adcolony.sdk.e0;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.utility.platform.Platform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Callable;

class q {
    /* access modifiers changed from: private */
    public final f a = new f();
    /* access modifiers changed from: private */
    public final f b = new f();
    private String c = "";
    private boolean d;
    private String e = "";
    private f1 f = c0.b();
    private String g = "";

    class a implements j0 {

        /* renamed from: com.adcolony.sdk.q$a$a  reason: collision with other inner class name */
        class C0008a implements Runnable {
            final /* synthetic */ h0 a;

            /* renamed from: com.adcolony.sdk.q$a$a$a  reason: collision with other inner class name */
            class C0009a implements Runnable {
                final /* synthetic */ f1 a;

                C0009a(f1 f1Var) {
                    this.a = f1Var;
                }

                public void run() {
                    C0008a.this.a.a(this.a).c();
                }
            }

            C0008a(a aVar, h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                z0.b((Runnable) new C0009a(a.b().n().c(2000)));
            }
        }

        a(q qVar) {
        }

        public void a(h0 h0Var) {
            if (!z0.a((Runnable) new C0008a(this, h0Var))) {
                new e0.a().a("Error retrieving device info, disabling AdColony.").a(e0.i);
                AdColony.disable();
            }
        }
    }

    class b implements Callable<f1> {
        final /* synthetic */ long a;

        b(long j) {
            this.a = j;
        }

        /* renamed from: b */
        public f1 call() {
            if (!q.this.N() && this.a > 0) {
                q.this.a.a(this.a);
            }
            return q.this.b();
        }
    }

    class c implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ y b;

        c(Context context, y yVar) {
            this.a = context;
            this.b = yVar;
        }

        public void run() {
            boolean z;
            String str;
            if (a.e) {
                str = "00000000-0000-0000-0000-000000000000";
                z = true;
            } else {
                str = null;
                z = false;
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
                    str = advertisingIdInfo.getId();
                    z = advertisingIdInfo.isLimitAdTrackingEnabled();
                } catch (NoClassDefFoundError unused) {
                    new e0.a().a("Google Play Services Ads dependencies are missing.").a(e0.f);
                } catch (NoSuchMethodError unused2) {
                    new e0.a().a("Google Play Services is out of date, please update to GPS 4.0+.").a(e0.f);
                } catch (Exception e) {
                    new e0.a().a("Query Advertising ID failed with: ").a(Log.getStackTraceString(e)).a(e0.g);
                }
                if (str == null && Build.MANUFACTURER.equals(Platform.MANUFACTURER_AMAZON)) {
                    str = q.this.g();
                    z = q.this.h();
                }
            }
            if (str == null) {
                new e0.a().a("Advertising ID is not available. ").a("Collecting Android ID instead of Advertising ID.").a(e0.f);
                y yVar = this.b;
                if (yVar != null) {
                    yVar.a(new Throwable("Advertising ID is not available."));
                }
            } else {
                q.this.a(str);
                s0 a2 = a.b().q().a();
                if (a2 != null) {
                    a2.d.put("advertisingId", q.this.f());
                }
                q.this.c(z);
                y yVar2 = this.b;
                if (yVar2 != null) {
                    yVar2.a(q.this.f());
                }
            }
            q.this.a(true);
        }
    }

    class d implements Callable<f1> {
        final /* synthetic */ long a;

        d(long j) {
            this.a = j;
        }

        /* renamed from: b */
        public f1 call() {
            if (!q.this.O() && this.a > 0) {
                q.this.b.a(this.a);
            }
            return q.this.c();
        }
    }

    class e implements OnCompleteListener<AppSetIdInfo> {
        final /* synthetic */ y a;

        e(y yVar) {
            this.a = yVar;
        }

        public void onComplete(Task<AppSetIdInfo> task) {
            Throwable th;
            if (task.isSuccessful()) {
                q.this.b(task.getResult().getId());
                y yVar = this.a;
                if (yVar != null) {
                    yVar.a(q.this.k());
                }
            } else {
                if (task.getException() != null) {
                    th = task.getException();
                } else {
                    th = new Throwable("Task failed with unknown exception.");
                }
                new e0.a().a("App Set ID is not available. Unexpected exception occurred: ").a(Log.getStackTraceString(th)).a(e0.g);
                y yVar2 = this.a;
                if (yVar2 != null) {
                    yVar2.a(th);
                }
            }
            q.this.b(true);
        }
    }

    q() {
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public String B() {
        return "";
    }

    /* access modifiers changed from: package-private */
    public String C() {
        return Build.MANUFACTURER;
    }

    /* access modifiers changed from: package-private */
    public int D() {
        ActivityManager activityManager;
        Context a2 = a.a();
        if (a2 == null || (activityManager = (ActivityManager) a2.getSystemService("activity")) == null) {
            return 0;
        }
        return activityManager.getMemoryClass();
    }

    /* access modifiers changed from: package-private */
    public long E() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / ((long) 1048576);
    }

    /* access modifiers changed from: package-private */
    public String F() {
        return Build.MODEL;
    }

    /* access modifiers changed from: package-private */
    public int G() {
        Context a2 = a.a();
        if (a2 == null) {
            return 2;
        }
        int i = a2.getResources().getConfiguration().orientation;
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return 2;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public String H() {
        return Build.VERSION.RELEASE;
    }

    /* access modifiers changed from: package-private */
    public String I() {
        return "4.8.0";
    }

    /* access modifiers changed from: package-private */
    public String J() {
        TelephonyManager telephonyManager;
        Context a2 = a.a();
        if (a2 == null || (telephonyManager = (TelephonyManager) a2.getSystemService("phone")) == null) {
            return "";
        }
        return telephonyManager.getSimCountryIso();
    }

    /* access modifiers changed from: package-private */
    public int K() {
        return TimeZone.getDefault().getOffset(15) / 60000;
    }

    /* access modifiers changed from: package-private */
    public String L() {
        return TimeZone.getDefault().getID();
    }

    /* access modifiers changed from: package-private */
    public void M() {
        a(false);
        b(false);
        a.a("Device.get_info", (j0) new a(this));
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        return this.a.a();
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return this.b.a();
    }

    /* access modifiers changed from: package-private */
    public boolean P() {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
        float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        float f3 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        if (Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= 6.0d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z) {
        this.d = z;
    }

    /* access modifiers changed from: package-private */
    public f1 d() {
        f1 b2 = c0.b();
        k b3 = a.b();
        c0.a(b2, "carrier_name", m());
        c0.a(b2, "data_path", b3.z().b());
        c0.b(b2, "device_api", j());
        Rect w = w();
        c0.b(b2, "screen_width", w.width());
        c0.b(b2, "screen_height", w.height());
        c0.b(b2, "display_dpi", v());
        c0.a(b2, "device_type", u());
        c0.a(b2, "locale_language_code", y());
        c0.a(b2, "ln", y());
        c0.a(b2, "locale_country_code", p());
        c0.a(b2, "locale", p());
        c0.a(b2, "mac_address", B());
        c0.a(b2, "manufacturer", C());
        c0.a(b2, "device_brand", C());
        c0.a(b2, "media_path", b3.z().c());
        c0.a(b2, "temp_storage_path", b3.z().d());
        c0.b(b2, "memory_class", D());
        c0.b(b2, "memory_used_mb", E());
        c0.a(b2, "model", F());
        c0.a(b2, "device_model", F());
        c0.a(b2, "sdk_type", "android_native");
        c0.a(b2, "sdk_version", I());
        c0.a(b2, "network_type", b3.s().e());
        c0.a(b2, "os_version", H());
        c0.a(b2, "os_name", "android");
        c0.a(b2, "platform", "android");
        c0.a(b2, "arch", a());
        c0.a(b2, ReportDBAdapter.ReportColumns.COLUMN_USER_ID, c0.h(b3.u().b(), ReportDBAdapter.ReportColumns.COLUMN_USER_ID));
        c0.a(b2, "app_id", b3.u().a());
        c0.a(b2, "app_bundle_name", z0.b());
        c0.a(b2, "app_bundle_version", z0.c());
        c0.a(b2, "battery_level", l());
        c0.a(b2, "cell_service_country_code", J());
        c0.a(b2, "timezone_ietf", L());
        c0.b(b2, "timezone_gmt_m", K());
        c0.b(b2, "timezone_dst_m", q());
        c0.a(b2, "launch_metadata", z());
        c0.a(b2, "controller_version", b3.f());
        c0.b(b2, "current_orientation", G());
        c0.b(b2, "cleartext_permitted", n());
        c0.a(b2, "density", (double) s());
        c0.b(b2, "dark_mode", r());
        c0.a(b2, "adc_alt_id", e());
        e1 a2 = c0.a();
        if (z0.c("com.android.vending")) {
            a2.b("google");
        }
        if (z0.c("com.amazon.venezia")) {
            a2.b("amazon");
        }
        if (z0.c("com.huawei.appmarket")) {
            a2.b("huawei");
        }
        if (z0.c("com.sec.android.app.samsungapps")) {
            a2.b("samsung");
        }
        c0.a(b2, "available_stores", a2);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return z0.a(a.b().z());
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        Context a2 = a.a();
        if (a2 == null) {
            return null;
        }
        return Settings.Secure.getString(a2.getContentResolver(), "advertising_id");
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(a2.getContentResolver(), "limit_ad_tracking") != 0) {
                return true;
            }
            return false;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String i() {
        Context a2 = a.a();
        if (a2 == null) {
            return "";
        }
        return Settings.Secure.getString(a2.getContentResolver(), VungleApiClient.ANDROID_ID);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return Build.VERSION.SDK_INT;
    }

    public String k() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public double l() {
        Context a2 = a.a();
        if (a2 == null) {
            return 0.0d;
        }
        try {
            Intent registerReceiver = a2.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return 0.0d;
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 < 0) {
                return 0.0d;
            }
            return ((double) intExtra) / ((double) intExtra2);
        } catch (RuntimeException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    public String m() {
        Context a2 = a.a();
        String str = "";
        if (a2 == null) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) a2.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperatorName();
        }
        return str.length() == 0 ? "unknown" : str;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return Build.VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    /* access modifiers changed from: package-private */
    public String o() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public String p() {
        return Locale.getDefault().getCountry();
    }

    /* access modifiers changed from: package-private */
    public int q() {
        TimeZone timeZone = TimeZone.getDefault();
        if (!timeZone.inDaylightTime(new Date())) {
            return 0;
        }
        return timeZone.getDSTSavings() / 60000;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        int i;
        Context a2 = a.a();
        if (a2 == null || Build.VERSION.SDK_INT < 29 || (i = a2.getResources().getConfiguration().uiMode & 48) == 16 || i != 32) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public float s() {
        Context a2 = a.a();
        if (a2 == null) {
            return 0.0f;
        }
        return a2.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: package-private */
    public f1 t() {
        if (!N()) {
            try {
                return z0.b(c0.a(d(), a(2000).call()));
            } catch (Exception unused) {
            }
        }
        return z0.b(c0.a(d(), b()));
    }

    /* access modifiers changed from: package-private */
    public String u() {
        return P() ? "tablet" : "phone";
    }

    /* access modifiers changed from: package-private */
    public int v() {
        Context a2 = a.a();
        if (a2 == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return a2.getResources().getConfiguration().densityDpi;
        }
        try {
            WindowManager windowManager = (WindowManager) a2.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        } catch (RuntimeException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public Rect w() {
        Rect rect = new Rect();
        Context a2 = a.a();
        if (a2 == null) {
            return rect;
        }
        try {
            WindowManager windowManager = (WindowManager) a2.getSystemService("window");
            if (windowManager == null) {
                return rect;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (RuntimeException unused) {
            return rect;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:32|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r1 = r2.getWindowInsets().getInsetsIgnoringVisibility((android.view.WindowInsets.Type.navigationBars() | android.view.WindowInsets.Type.displayCutout()) | android.view.WindowInsets.Type.statusBars());
        r1 = new android.graphics.Rect(0, 0, r2.getBounds().width() - (r1.right + r1.left), r2.getBounds().height() - (r1.top + r1.bottom));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00d8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Rect x() {
        /*
            r8 = this;
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.content.Context r1 = com.adcolony.sdk.a.a()
            if (r1 == 0) goto L_0x0111
            java.lang.String r2 = "window"
            java.lang.Object r2 = r1.getSystemService(r2)     // Catch:{ RuntimeException -> 0x0111 }
            android.view.WindowManager r2 = (android.view.WindowManager) r2     // Catch:{ RuntimeException -> 0x0111 }
            if (r2 == 0) goto L_0x0111
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ RuntimeException -> 0x0111 }
            r4 = 17
            r5 = 0
            if (r3 >= r4) goto L_0x0039
            android.util.DisplayMetrics r3 = new android.util.DisplayMetrics     // Catch:{ RuntimeException -> 0x0111 }
            r3.<init>()     // Catch:{ RuntimeException -> 0x0111 }
            android.view.Display r2 = r2.getDefaultDisplay()     // Catch:{ RuntimeException -> 0x0111 }
            r2.getMetrics(r3)     // Catch:{ RuntimeException -> 0x0111 }
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r3.widthPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = r3.heightPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r1 = com.adcolony.sdk.z0.f((android.content.Context) r1)     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = r3 - r1
            r2.<init>(r5, r5, r4, r3)     // Catch:{ RuntimeException -> 0x0111 }
            r0 = r2
            goto L_0x0111
        L_0x0039:
            r4 = 30
            if (r3 >= r4) goto L_0x008d
            android.util.DisplayMetrics r3 = new android.util.DisplayMetrics     // Catch:{ RuntimeException -> 0x0111 }
            r3.<init>()     // Catch:{ RuntimeException -> 0x0111 }
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics     // Catch:{ RuntimeException -> 0x0111 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x0111 }
            android.view.Display r2 = r2.getDefaultDisplay()     // Catch:{ RuntimeException -> 0x0111 }
            r2.getMetrics(r3)     // Catch:{ RuntimeException -> 0x0111 }
            r2.getRealMetrics(r4)     // Catch:{ RuntimeException -> 0x0111 }
            int r2 = com.adcolony.sdk.z0.f((android.content.Context) r1)     // Catch:{ RuntimeException -> 0x0111 }
            int r1 = com.adcolony.sdk.z0.b((android.content.Context) r1)     // Catch:{ RuntimeException -> 0x0111 }
            int r6 = r4.heightPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r7 = r3.heightPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r6 = r6 - r7
            if (r6 > 0) goto L_0x006d
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r3.widthPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = r3.heightPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = r3 - r2
            r1.<init>(r5, r5, r4, r3)     // Catch:{ RuntimeException -> 0x0111 }
        L_0x006a:
            r0 = r1
            goto L_0x0111
        L_0x006d:
            if (r1 <= 0) goto L_0x0082
            if (r6 > r2) goto L_0x0074
            if (r1 <= r2) goto L_0x0074
            goto L_0x0082
        L_0x0074:
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = r3.widthPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r4.heightPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r1 = r1 + r2
            int r4 = r4 - r1
            r6.<init>(r5, r5, r3, r4)     // Catch:{ RuntimeException -> 0x0111 }
            r0 = r6
            goto L_0x0111
        L_0x0082:
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = r3.widthPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r4.heightPixels     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r4 - r2
            r1.<init>(r5, r5, r3, r4)     // Catch:{ RuntimeException -> 0x0111 }
            goto L_0x006a
        L_0x008d:
            android.view.WindowMetrics r2 = r2.getCurrentWindowMetrics()     // Catch:{ RuntimeException -> 0x0111 }
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r3.<init>()     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            android.graphics.Point r4 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r4.<init>()     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            android.view.Display r1 = r1.getDisplay()     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r1.getCurrentSizeRange(r3, r4)     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            android.graphics.Rect r1 = r2.getBounds()     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r1 = r1.width()     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            android.graphics.Rect r6 = r2.getBounds()     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r6 = r6.height()     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r7 = 2
            if (r1 <= r6) goto L_0x00b7
            r1 = r7
            goto L_0x00b8
        L_0x00b7:
            r1 = 1
        L_0x00b8:
            if (r1 != r7) goto L_0x00c4
            android.graphics.Point r1 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r4 = r4.x     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r3 = r3.y     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r1.<init>(r4, r3)     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            goto L_0x00cd
        L_0x00c4:
            android.graphics.Point r1 = new android.graphics.Point     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r3 = r3.x     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r4 = r4.y     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r1.<init>(r3, r4)     // Catch:{ UnsupportedOperationException -> 0x00d8 }
        L_0x00cd:
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r4 = r1.x     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            int r1 = r1.y     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r3.<init>(r5, r5, r4, r1)     // Catch:{ UnsupportedOperationException -> 0x00d8 }
            r0 = r3
            goto L_0x0111
        L_0x00d8:
            android.view.WindowInsets r1 = r2.getWindowInsets()     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = android.view.WindowInsets.Type.navigationBars()     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = android.view.WindowInsets.Type.displayCutout()     // Catch:{ RuntimeException -> 0x0111 }
            r3 = r3 | r4
            int r4 = android.view.WindowInsets.Type.statusBars()     // Catch:{ RuntimeException -> 0x0111 }
            r3 = r3 | r4
            android.graphics.Insets r1 = r1.getInsetsIgnoringVisibility(r3)     // Catch:{ RuntimeException -> 0x0111 }
            android.graphics.Rect r3 = r2.getBounds()     // Catch:{ RuntimeException -> 0x0111 }
            int r3 = r3.width()     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r1.right     // Catch:{ RuntimeException -> 0x0111 }
            int r6 = r1.left     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r4 + r6
            int r3 = r3 - r4
            android.graphics.Rect r2 = r2.getBounds()     // Catch:{ RuntimeException -> 0x0111 }
            int r2 = r2.height()     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r1.top     // Catch:{ RuntimeException -> 0x0111 }
            int r1 = r1.bottom     // Catch:{ RuntimeException -> 0x0111 }
            int r4 = r4 + r1
            int r2 = r2 - r4
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ RuntimeException -> 0x0111 }
            r1.<init>(r5, r5, r3, r2)     // Catch:{ RuntimeException -> 0x0111 }
            goto L_0x006a
        L_0x0111:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.q.x():android.graphics.Rect");
    }

    /* access modifiers changed from: package-private */
    public String y() {
        return Locale.getDefault().getLanguage();
    }

    /* access modifiers changed from: package-private */
    public f1 z() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public void a(f1 f1Var) {
        this.f = f1Var;
    }

    public void b(String str) {
        this.e = str;
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        this.g = str;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.c = str;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        this.b.a(z);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.a.a(z);
    }

    /* access modifiers changed from: package-private */
    public f1 b() {
        f1 b2 = c0.b();
        String f2 = f();
        c0.a(b2, "advertiser_id", f2);
        c0.b(b2, "limit_tracking", A());
        if (f2 == null || f2.isEmpty()) {
            c0.a(b2, "android_id_sha1", z0.b(i()));
        }
        return b2;
    }

    /* access modifiers changed from: package-private */
    public f1 c(long j) {
        if (j <= 0) {
            return c0.a(d(), b(), c());
        }
        ArrayList arrayList = new ArrayList(Collections.singletonList(d()));
        q0 q0Var = new q0();
        if (N()) {
            arrayList.add(b());
        } else {
            q0Var.a(a(j));
        }
        if (O()) {
            arrayList.add(c());
        } else {
            q0Var.a(b(j));
        }
        if (!q0Var.b()) {
            arrayList.addAll(q0Var.a());
        }
        return c0.a((f1[]) arrayList.toArray(new f1[0]));
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: package-private */
    public Callable<f1> a(long j) {
        return new b(j);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        a(context, (y<String>) null);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, y<String> yVar) {
        if (context != null) {
            if (f().isEmpty()) {
                a(false);
            }
            if (!z0.a((Runnable) new c(context, yVar))) {
                new e0.a().a("Executing Query Advertising ID failed.").a(e0.i);
                if (yVar != null) {
                    yVar.a(new Throwable("Query Advertising ID failed on execute."));
                }
            } else {
                return;
            }
        } else if (yVar != null) {
            yVar.a(new Throwable("Context cannot be null."));
        }
        a(true);
    }

    /* access modifiers changed from: package-private */
    public Callable<f1> b(long j) {
        return new d(j);
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        b(context, (y<String>) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r3, com.adcolony.sdk.y<java.lang.String> r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            if (r4 == 0) goto L_0x0080
            java.lang.Throwable r3 = new java.lang.Throwable
            java.lang.String r0 = "Context cannot be null."
            r3.<init>(r0)
            r4.a((java.lang.Throwable) r3)
            goto L_0x0080
        L_0x000f:
            java.lang.String r0 = r2.k()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0023
            if (r4 == 0) goto L_0x0080
            java.lang.String r3 = r2.k()
            r4.a(r3)
            goto L_0x0080
        L_0x0023:
            r0 = 0
            r2.b((boolean) r0)
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ NoClassDefFoundError | NoSuchMethodError -> 0x0056, Exception -> 0x003c }
            com.google.android.gms.appset.AppSetIdClient r3 = com.google.android.gms.appset.AppSet.getClient(r3)     // Catch:{ NoClassDefFoundError | NoSuchMethodError -> 0x0056, Exception -> 0x003c }
            com.google.android.gms.tasks.Task r3 = r3.getAppSetIdInfo()     // Catch:{ NoClassDefFoundError | NoSuchMethodError -> 0x0056, Exception -> 0x003c }
            com.adcolony.sdk.q$e r0 = new com.adcolony.sdk.q$e     // Catch:{ NoClassDefFoundError | NoSuchMethodError -> 0x0056, Exception -> 0x003c }
            r0.<init>(r4)     // Catch:{ NoClassDefFoundError | NoSuchMethodError -> 0x0056, Exception -> 0x003c }
            r3.addOnCompleteListener(r0)     // Catch:{ NoClassDefFoundError | NoSuchMethodError -> 0x0056, Exception -> 0x003c }
            return
        L_0x003c:
            r3 = move-exception
            com.adcolony.sdk.e0$a r0 = new com.adcolony.sdk.e0$a
            r0.<init>()
            java.lang.String r1 = "Query App Set ID failed with: "
            com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)
            com.adcolony.sdk.e0$a r3 = r0.a((java.lang.String) r3)
            com.adcolony.sdk.e0 r0 = com.adcolony.sdk.e0.g
            r3.a((com.adcolony.sdk.e0) r0)
            goto L_0x0066
        L_0x0056:
            com.adcolony.sdk.e0$a r3 = new com.adcolony.sdk.e0$a
            r3.<init>()
            java.lang.String r0 = "Google Play Services App Set dependency is missing."
            com.adcolony.sdk.e0$a r3 = r3.a((java.lang.String) r0)
            com.adcolony.sdk.e0 r0 = com.adcolony.sdk.e0.f
            r3.a((com.adcolony.sdk.e0) r0)
        L_0x0066:
            com.adcolony.sdk.e0$a r3 = new com.adcolony.sdk.e0$a
            r3.<init>()
            java.lang.String r0 = "App Set ID is not available."
            com.adcolony.sdk.e0$a r3 = r3.a((java.lang.String) r0)
            com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.f
            r3.a((com.adcolony.sdk.e0) r1)
            if (r4 == 0) goto L_0x0080
            java.lang.Throwable r3 = new java.lang.Throwable
            r3.<init>(r0)
            r4.a((java.lang.Throwable) r3)
        L_0x0080:
            r3 = 1
            r2.b((boolean) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.q.b(android.content.Context, com.adcolony.sdk.y):void");
    }

    /* access modifiers changed from: package-private */
    public f1 c() {
        f1 b2 = c0.b();
        c0.a(b2, "app_set_id", k());
        return b2;
    }
}
