package com.bytedance.sdk.openadsdk.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceUtils */
public class e {
    public static String a = "";
    private static volatile boolean b = false;
    private static volatile boolean c = false;
    /* access modifiers changed from: private */
    public static volatile boolean d = false;
    private static volatile boolean e = false;
    private static volatile boolean f = true;
    private static long g;
    private static int h;
    /* access modifiers changed from: private */
    public static int i;
    /* access modifiers changed from: private */
    public static int j;
    /* access modifiers changed from: private */
    public static int k;
    /* access modifiers changed from: private */
    public static int l;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0044, code lost:
        if (((((33 * 33) * 33) + ((46 * 46) * 46)) + ((19 * 19) * 19)) >= (((33 * 46) * 19) * 3)) goto L_0x0008;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        if ((((1 + 1) * 1) % 2) == 0) goto L_0x0008;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0008, code lost:
        continue;
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.content.Context r12, boolean r13) {
        /*
            java.lang.String r0 = "mcc"
            java.lang.String r1 = "mnc"
            java.lang.String r2 = "boot"
            java.lang.String r3 = ""
        L_0x0008:
            r4 = 96
            r5 = 1
            switch(r4) {
                case 96: goto L_0x0029;
                case 97: goto L_0x000f;
                case 98: goto L_0x001b;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0008
        L_0x000f:
            r4 = 17
            int r4 = r4 * r4
            r6 = 29
            int r6 = r6 * r6
            int r6 = r6 * 34
            int r4 = r4 - r6
            r6 = -1
            if (r4 != r6) goto L_0x0008
        L_0x001b:
            r4 = 9
            int r6 = 9 - r5
            int r6 = r6 * r4
            int r4 = r4 * 2
            int r4 = r4 - r5
            int r6 = r6 * r4
            int r6 = r6 % 6
            if (r6 == 0) goto L_0x001b
            goto L_0x0008
        L_0x0029:
            r4 = 91
            switch(r4) {
                case 89: goto L_0x002f;
                case 90: goto L_0x0046;
                case 91: goto L_0x004d;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0029
        L_0x002f:
            r4 = 33
            r6 = 46
            r7 = 19
            int r8 = r4 * r4
            int r8 = r8 * r4
            int r9 = r6 * r6
            int r9 = r9 * r6
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r8 = r8 + r9
            int r4 = r4 * r6
            int r4 = r4 * r7
            int r4 = r4 * 3
            if (r8 >= r4) goto L_0x0008
        L_0x0046:
            int r4 = r5 + r5
            int r4 = r4 * r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0008
        L_0x004d:
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r6 = "sys_adb_status"
            int r7 = e(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            a((org.json.JSONObject) r4)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "type"
            int r7 = c((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "os"
            r4.put(r6, r5)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "os_version"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024b }
            r7.<init>()     // Catch:{ Exception -> 0x024b }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x024b }
            r7.append(r8)     // Catch:{ Exception -> 0x024b }
            r7.append(r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "vendor"
            java.lang.String r7 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "conn_type"
            int r7 = com.bytedance.sdk.openadsdk.l.y.m(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "app_set_id"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.settings.c.b()     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "app_set_id_scope"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.settings.c.a()     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "installed_source"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.settings.c.c()     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "screen_width"
            int r7 = com.bytedance.sdk.openadsdk.l.z.c((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "screen_height"
            int r7 = com.bytedance.sdk.openadsdk.l.z.d((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = "sec_did"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.e.c.d()     // Catch:{ Exception -> 0x024b }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x024b }
            com.bytedance.sdk.openadsdk.core.settings.j r6 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x024b }
            boolean r7 = r6.x(r2)     // Catch:{ Exception -> 0x024b }
            if (r7 == 0) goto L_0x0105
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024b }
            r7.<init>()     // Catch:{ Exception -> 0x024b }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x024b }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x024b }
            long r8 = r8 - r10
            r7.append(r8)     // Catch:{ Exception -> 0x024b }
            r7.append(r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r7)     // Catch:{ Exception -> 0x024b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024b }
            r2.<init>()     // Catch:{ Exception -> 0x024b }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x024b }
            r2.append(r7)     // Catch:{ Exception -> 0x024b }
            r2.append(r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = "power_on_time"
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x024b }
            r4.put(r3, r2)     // Catch:{ Exception -> 0x024b }
        L_0x0105:
            java.lang.String r2 = "uuid"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.j.c(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = "rom_version"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.p.a()     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = "sys_compiling_time"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.j.b(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = "timezone"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.y.r()     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = "language"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.j.a()     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = "carrier_name"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.q.a()     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x0142
            java.lang.String r13 = com.bytedance.sdk.openadsdk.l.y.a((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            goto L_0x0146
        L_0x0142:
            java.lang.String r13 = com.bytedance.sdk.openadsdk.l.y.b((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
        L_0x0146:
            java.lang.String r2 = "total_mem"
            long r7 = java.lang.Long.parseLong(r13)     // Catch:{ Exception -> 0x024b }
            r9 = 1024(0x400, double:5.06E-321)
            long r7 = r7 * r9
            java.lang.String r13 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r13)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "locale_language"
            java.lang.String r2 = c()     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "screen_bright"
            float r2 = d()     // Catch:{ Exception -> 0x024b }
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 * r3
            double r2 = (double) r2     // Catch:{ Exception -> 0x024b }
            double r2 = java.lang.Math.ceil(r2)     // Catch:{ Exception -> 0x024b }
            r7 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r2 = r2 / r7
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            boolean r13 = a()     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x017a
            r5 = 0
        L_0x017a:
            java.lang.String r13 = "is_screen_off"
            r4.put(r13, r5)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "cpu_num"
            int r2 = com.bytedance.sdk.openadsdk.l.d.a((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "cpu_max_freq"
            int r2 = com.bytedance.sdk.openadsdk.l.d.b((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "cpu_min_freq"
            int r2 = com.bytedance.sdk.openadsdk.l.d.c(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            com.bytedance.sdk.openadsdk.l.c$a r13 = com.bytedance.sdk.openadsdk.l.c.a()     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = "battery_remaining_pct"
            float r3 = r13.b     // Catch:{ Exception -> 0x024b }
            int r3 = (int) r3     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = "is_charging"
            int r13 = r13.a     // Catch:{ Exception -> 0x024b }
            r4.put(r2, r13)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "total_space"
            long r2 = com.bytedance.sdk.openadsdk.l.y.c((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "free_space_in"
            long r2 = com.bytedance.sdk.openadsdk.l.y.d((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "sdcard_size"
            long r2 = com.bytedance.sdk.openadsdk.l.y.e((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "rooted"
            int r2 = com.bytedance.sdk.openadsdk.l.y.f((android.content.Context) r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "enable_assisted_clicking"
            int r2 = e()     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "force_language"
            java.lang.String r2 = "tt_choose_language"
            java.lang.String r2 = com.bytedance.sdk.component.utils.t.a(r12, r2)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "airplane"
            int r2 = f(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "darkmode"
            int r2 = l(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "headset"
            int r2 = m(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "ringmute"
            int r2 = n(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "screenscale"
            float r2 = o(r12)     // Catch:{ Exception -> 0x024b }
            double r2 = (double) r2     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "volume"
            int r2 = p(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r2)     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = "low_power_mode"
            int r12 = q(r12)     // Catch:{ Exception -> 0x024b }
            r4.put(r13, r12)     // Catch:{ Exception -> 0x024b }
            boolean r12 = r6.x(r1)     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x023e
            java.lang.String r12 = com.bytedance.sdk.openadsdk.l.q.c()     // Catch:{ Exception -> 0x024b }
            r4.put(r1, r12)     // Catch:{ Exception -> 0x024b }
        L_0x023e:
            boolean r12 = r6.x(r0)     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x024b
            java.lang.String r12 = com.bytedance.sdk.openadsdk.l.q.b()     // Catch:{ Exception -> 0x024b }
            r4.put(r0, r12)     // Catch:{ Exception -> 0x024b }
        L_0x024b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.e.a(android.content.Context, boolean):org.json.JSONObject");
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        b(jSONObject);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        switch(r2) {
            case 52: goto L_0x004d;
            case 53: goto L_0x0040;
            case 54: goto L_0x0034;
            default: goto L_0x003f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        switch(r3) {
            case 29: goto L_0x0054;
            case 30: goto L_0x004d;
            case 31: goto L_0x003c;
            default: goto L_0x0043;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r3 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r2 <= '9') goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046 A[Catch:{ all -> 0x0050 }] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a() {
        /*
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = g
            long r0 = r0 - r2
            r2 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0054
            long r0 = android.os.SystemClock.elapsedRealtime()
            g = r0
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = "power"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x0050 }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x0054
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0050 }
            r2 = 20
            r3 = 55
            if (r1 < r2) goto L_0x0030
            boolean r0 = r0.isInteractive()     // Catch:{ all -> 0x0050 }
            r1 = 0
            r2 = r1
            goto L_0x004d
        L_0x0030:
            boolean r0 = r0.isScreenOn()     // Catch:{ all -> 0x0050 }
        L_0x0034:
            r1 = 73
            r2 = 16
        L_0x0038:
            switch(r1) {
                case 72: goto L_0x004a;
                case 73: goto L_0x0046;
                case 74: goto L_0x003c;
                default: goto L_0x003b;
            }     // Catch:{ all -> 0x0050 }
        L_0x003b:
            goto L_0x004d
        L_0x003c:
            switch(r2) {
                case 52: goto L_0x004d;
                case 53: goto L_0x0040;
                case 54: goto L_0x0034;
                default: goto L_0x003f;
            }     // Catch:{ all -> 0x0050 }
        L_0x003f:
            goto L_0x0034
        L_0x0040:
            switch(r3) {
                case 29: goto L_0x0054;
                case 30: goto L_0x004d;
                case 31: goto L_0x003c;
                default: goto L_0x0043;
            }     // Catch:{ all -> 0x0050 }
        L_0x0043:
            r3 = 30
            goto L_0x0040
        L_0x0046:
            r1 = 57
            if (r2 > r1) goto L_0x0034
        L_0x004a:
            f = r0     // Catch:{ all -> 0x0050 }
            goto L_0x0054
        L_0x004d:
            r1 = 72
            goto L_0x0038
        L_0x0050:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0054:
            boolean r0 = f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.e.a():boolean");
    }

    public static boolean a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b() {
        return com.bytedance.sdk.openadsdk.core.c.a(m.a()).b("limit_ad_track", -1);
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        jSONObject.put("model", Build.MODEL);
        if (m.d().x(VungleApiClient.GAID)) {
            jSONObject.put(VungleApiClient.GAID, com.com.bytedance.overseas.sdk.b.a.a().b());
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (b(context)) {
            return 3;
        }
        return a(context) ? 2 : 1;
    }

    public static String c() {
        if (Build.VERSION.SDK_INT < 21) {
            return Locale.getDefault().getLanguage();
        }
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float d() {
        int i2 = -1;
        try {
            Context a2 = m.a();
            if (a2 != null) {
                i2 = Settings.System.getInt(a2.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            l.e("DeviceUtils", th.getMessage());
        }
        if (i2 < 0) {
            return -1.0f;
        }
        return ((float) Math.round((((float) i2) / 255.0f) * 10.0f)) / 10.0f;
    }

    public static JSONObject d(Context context) {
        return a(context, false);
    }

    public static int e() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) m.a().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        return accessibilityManager.isEnabled() ? 1 : 0;
    }

    public static int e(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.Secure.getInt(Build.VERSION.SDK_INT >= 17 ? context.getContentResolver() : context.getContentResolver(), "adb_enabled", -1);
        } catch (Throwable th) {
            l.e("DeviceUtils", th.getMessage());
            return -1;
        }
    }

    public static int f(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0 : Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00eb, code lost:
        if ((((57 * 57) + (34 * 34)) + (12 * 12)) >= (((57 * 34) + (34 * 12)) + (57 * 12))) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ed, code lost:
        r5 = '1';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f0, code lost:
        switch(r4) {
            case 55: goto L_0x00fe;
            case 56: goto L_0x0000;
            case 57: goto L_0x00f4;
            default: goto L_0x00f3;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fb, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fe, code lost:
        switch(r5) {
            case 60: goto L_0x0103;
            case 61: goto L_0x011a;
            case 62: goto L_0x0126;
            default: goto L_0x0101;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0118, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0124, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0131, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0135, code lost:
        r4 = '7';
        r5 = '=';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) == -1) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        r4 = '4';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        switch(96) {
            case 94: goto L_0x00d6;
            case 95: goto L_0x00ed;
            case 96: goto L_0x0024;
            default: goto L_0x0023;
        };
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f() {
        /*
        L_0x0000:
            r0 = -1
            r1 = 49
            r2 = 34
            r3 = 1
            switch(r1) {
                case 49: goto L_0x001c;
                case 50: goto L_0x000a;
                case 51: goto L_0x0014;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0000
        L_0x000a:
            r1 = 13
            int r1 = r1 * r1
            r4 = 19
            int r4 = r4 * r4
            int r4 = r4 * r2
            int r1 = r1 - r4
            if (r1 != r0) goto L_0x0024
        L_0x0014:
            r0 = 10
            int r0 = r0 + r3
            int r0 = r0 * 10
            int r0 = r0 % 2
            goto L_0x0024
        L_0x001c:
            r4 = 52
            r5 = 96
            switch(r5) {
                case 94: goto L_0x00d6;
                case 95: goto L_0x00ed;
                case 96: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x001c
        L_0x0024:
            com.bytedance.sdk.openadsdk.l.e$c r0 = new com.bytedance.sdk.openadsdk.l.e$c
            r0.<init>()
            r0.run()
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.m.a()
            if (r0 == 0) goto L_0x00d5
            int r1 = com.bytedance.sdk.openadsdk.l.d.a()
            com.bytedance.sdk.openadsdk.core.c r2 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r3 = "cpu_count"
            r2.a((java.lang.String) r3, (int) r1)
            int r1 = com.bytedance.sdk.openadsdk.l.d.a()
            int r1 = com.bytedance.sdk.openadsdk.l.d.a((int) r1)
            com.bytedance.sdk.openadsdk.core.c r2 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r3 = "cpu_max_frequency"
            r2.a((java.lang.String) r3, (int) r1)
            int r1 = com.bytedance.sdk.openadsdk.l.d.a()
            int r1 = com.bytedance.sdk.openadsdk.l.d.b((int) r1)
            com.bytedance.sdk.openadsdk.core.c r2 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r3 = "cpu_min_frequency"
            r2.a((java.lang.String) r3, (int) r1)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.l.y.i()
            if (r1 == 0) goto L_0x0070
            com.bytedance.sdk.openadsdk.core.c r2 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r3 = "total_memory"
            r2.a((java.lang.String) r3, (java.lang.String) r1)
        L_0x0070:
            long r1 = com.bytedance.sdk.openadsdk.l.y.j()
            com.bytedance.sdk.openadsdk.core.c r3 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r4 = "total_internal_storage"
            r3.a((java.lang.String) r4, (long) r1)
            long r1 = com.bytedance.sdk.component.utils.m.a()
            com.bytedance.sdk.openadsdk.core.c r3 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r4 = "free_internal_storage"
            r3.a((java.lang.String) r4, (long) r1)
            long r1 = com.bytedance.sdk.openadsdk.l.y.k()
            com.bytedance.sdk.openadsdk.core.c r3 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r4 = "total_sdcard_storage"
            r3.a((java.lang.String) r4, (long) r1)
            boolean r1 = com.bytedance.sdk.openadsdk.l.y.l()
            com.bytedance.sdk.openadsdk.core.c r2 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r3 = "is_root"
            r2.a((java.lang.String) r3, (int) r1)
            java.lang.String r1 = g(r0)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00c9
            java.lang.String r1 = "com.unity3d.player.UnityPlayer"
            java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00ba }
            java.lang.String r1 = "unity"
            a = r1     // Catch:{ ClassNotFoundException -> 0x00ba }
            goto L_0x00be
        L_0x00ba:
            java.lang.String r1 = "native"
            a = r1
        L_0x00be:
            com.bytedance.sdk.openadsdk.core.c r1 = com.bytedance.sdk.openadsdk.core.c.a(r0)
            java.lang.String r2 = a
            java.lang.String r3 = "framework_name"
            r1.a((java.lang.String) r3, (java.lang.String) r2)
        L_0x00c9:
            g()
            r(r0)
            int r0 = t(r0)
            l = r0
        L_0x00d5:
            return
        L_0x00d6:
            r5 = 57
            r6 = 12
            int r7 = r5 * r5
            int r8 = r2 * r2
            int r7 = r7 + r8
            int r8 = r6 * r6
            int r7 = r7 + r8
            r8 = 57
            int r8 = r8 * r2
            r9 = 34
            int r9 = r9 * r6
            int r8 = r8 + r9
            int r5 = r5 * r6
            int r8 = r8 + r5
            if (r7 >= r8) goto L_0x0000
        L_0x00ed:
            r5 = r1
        L_0x00ee:
            r6 = 18
            switch(r4) {
                case 55: goto L_0x00fe;
                case 56: goto L_0x0000;
                case 57: goto L_0x00f4;
                default: goto L_0x00f3;
            }
        L_0x00f3:
            goto L_0x0135
        L_0x00f4:
            int r4 = r6 * r6
            r5 = 35
            int r5 = r5 * r5
            int r5 = r5 * r2
            int r4 = r4 - r5
            if (r4 != r0) goto L_0x001c
            goto L_0x0103
        L_0x00fe:
            switch(r5) {
                case 60: goto L_0x0103;
                case 61: goto L_0x011a;
                case 62: goto L_0x0126;
                default: goto L_0x0101;
            }
        L_0x0101:
            goto L_0x0000
        L_0x0103:
            r4 = 26
            r5 = 9
            r7 = 15
            int r8 = r4 * r4
            int r8 = r8 * r4
            int r9 = r5 * r5
            int r9 = r9 * r5
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r8 = r8 + r9
            int r4 = r4 * r5
            int r4 = r4 * r7
            int r4 = r4 * 3
            if (r8 >= r4) goto L_0x0000
        L_0x011a:
            r4 = 0
            int r5 = 0 - r3
            int r5 = r5 * r4
            int r4 = r4 * 2
            int r4 = r4 - r3
            int r5 = r5 * r4
            int r5 = r5 % 6
            if (r5 == 0) goto L_0x001c
        L_0x0126:
            int r4 = 18 - r3
            int r4 = r4 * r6
            r5 = 18
            int r5 = r5 * 2
            int r5 = r5 - r3
            int r4 = r4 * r5
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x0126
            goto L_0x001c
        L_0x0135:
            r4 = 55
            r5 = 61
            goto L_0x00ee
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.e.f():void");
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = com.bytedance.sdk.openadsdk.core.c.a(context).b("framework_name", "");
        }
        return a;
    }

    public static void g() {
        try {
            int ringerMode = ((AudioManager) m.a().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode();
            if (ringerMode == 2) {
                h = 1;
            } else if (ringerMode == 1) {
                h = 2;
            } else {
                h = 0;
            }
        } catch (Throwable unused) {
        }
    }

    public static void h(Context context) {
        if (context != null) {
            a.b(context.getApplicationContext());
        }
    }

    public static void i(Context context) {
        Context applicationContext;
        if (!e && context != null && (applicationContext = context.getApplicationContext()) != null) {
            try {
                if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                    v(applicationContext);
                } else {
                    b.b(applicationContext);
                }
                e = true;
            } catch (Throwable unused) {
            }
        }
    }

    private static int l(Context context) {
        try {
            int i2 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
            if (i2 == 32) {
                return 1;
            }
            return i2 == 16 ? 0 : -1;
        } catch (Throwable unused) {
        }
    }

    private static int m(Context context) {
        return k;
    }

    private static int n(Context context) {
        return h;
    }

    private static float o(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static int p(Context context) {
        return j;
    }

    private static int q(Context context) {
        return l;
    }

    private static void r(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            i = audioManager.getStreamMaxVolume(3);
            j = audioManager.getStreamVolume(3);
            j = (int) ((((double) j) / ((double) i)) * 100.0d);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void s(Context context) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            w.a((g) new g("DeviceUtils_get_low_power_mode") {
                public void run() {
                    int unused = e.l = e.t(applicationContext);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static int t(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                    return (Build.VERSION.SDK_INT < 21 || !((PowerManager) context.getSystemService("power")).isPowerSaveMode()) ? 0 : 1;
                }
            }
            return u(context);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int u(Context context) {
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                if (Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN") != 1) {
                    return 0;
                }
            } else if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Settings.System.getInt(context.getContentResolver(), "SmartModeStatus") != 4) {
                return 0;
            }
            return 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static void v(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context.getContentResolver().registerContentObserver(Uri.parse("content://settings/system/POWER_SAVE_MODE_OPEN"), false, new ContentObserver((Handler) null) {
                public void onChange(boolean z) {
                    super.onChange(z);
                    e.s(applicationContext);
                }
            });
        }
    }

    /* compiled from: DeviceUtils */
    public static class c implements Runnable {
        public void run() {
            int i;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(m.a());
                if (advertisingIdInfo != null) {
                    i = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                    if (m.d().x(VungleApiClient.GAID)) {
                        String id = advertisingIdInfo.getId();
                        if (!TextUtils.isEmpty(id)) {
                            com.com.bytedance.overseas.sdk.b.a.a().b(id);
                            com.com.bytedance.overseas.sdk.b.a.a(id);
                        }
                    }
                } else {
                    i = -1;
                }
                if (i != -1) {
                    com.bytedance.sdk.openadsdk.core.c.a(m.a()).a("limit_ad_track", i);
                }
            } catch (IOException e) {
                l.c("DeviceUtils", "getLmtTask error : signaling connection to Google Play Services failed.", (Throwable) e);
            } catch (GooglePlayServicesNotAvailableException e2) {
                l.c("DeviceUtils", "getLmtTask error : indicating that Google Play is not installed on this device.", (Throwable) e2);
            } catch (GooglePlayServicesRepairableException e3) {
                l.c("DeviceUtils", "getLmtTask error : indicating that there was a recoverable error connecting to Google Play Services.", (Throwable) e3);
            } catch (Throwable th) {
                l.e("DeviceUtils", th.getMessage());
            }
        }
    }

    /* compiled from: DeviceUtils */
    static class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        int unused = e.j = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                        if (e.i != 0) {
                            int unused2 = e.j = (int) ((((double) e.j) / ((double) e.i)) * 100.0d);
                        }
                    }
                } else if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    int unused3 = e.k = intent.getIntExtra(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, 0);
                }
            }
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (!e.d && context != null) {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                    intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                    context.registerReceiver(new a(), intentFilter);
                    boolean unused = e.d = true;
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* compiled from: DeviceUtils */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && context != null) {
                if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                    e.s(context);
                } else if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(intent.getAction())) {
                    int i = 0;
                    if (intent.getIntExtra(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, 0) == 1) {
                        i = 1;
                    }
                    int unused = e.l = i;
                }
            }
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (Build.VERSION.SDK_INT >= 21 && context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                intentFilter.addAction("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
                context.registerReceiver(new b(), intentFilter);
            }
        }
    }
}
