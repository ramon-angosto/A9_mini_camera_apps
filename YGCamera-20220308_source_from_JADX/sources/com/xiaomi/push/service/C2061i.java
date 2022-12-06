package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1818ga;
import com.xiaomi.push.C1866hm;
import com.xiaomi.push.C1872hs;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C1941p;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.push.service.i */
public class C2061i {

    /* renamed from: a */
    private static volatile C2061i f3886a;

    /* renamed from: a */
    private long f3887a;

    /* renamed from: a */
    private Context f3888a;

    /* renamed from: a */
    private SharedPreferences f3889a;

    /* renamed from: a */
    private String f3890a = null;

    /* renamed from: a */
    private AtomicInteger f3891a = new AtomicInteger(0);

    /* renamed from: a */
    private volatile boolean f3892a = false;

    /* renamed from: b */
    private String f3893b = null;

    /* renamed from: b */
    private AtomicInteger f3894b = new AtomicInteger(0);

    /* renamed from: b */
    private boolean f3895b;

    /* renamed from: c */
    private boolean f3896c;

    private C2061i(Context context) {
        this.f3888a = context;
        this.f3896c = C1938m.m4714a(context);
        this.f3895b = C1995at.m5047a(this.f3888a).mo18472a(C1873ht.IntelligentHeartbeatSwitchBoolean.mo17806a(), true);
        this.f3889a = this.f3888a.getSharedPreferences("hb_record", 0);
        this.f3887a = this.f3889a.getLong("record_short_hb_count_start", -1);
    }

    /* renamed from: a */
    private int mo18531a() {
        if (TextUtils.isEmpty(this.f3890a)) {
            return -1;
        }
        try {
            return this.f3889a.getInt("HB_" + this.f3890a, -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static C2061i m5236a(Context context) {
        if (f3886a == null) {
            synchronized (C2061i.class) {
                if (f3886a == null) {
                    f3886a = new C2061i(context);
                }
            }
        }
        return f3886a;
    }

    /* renamed from: a */
    private void m5237a(String str, Map<String, String> map) {
        C1872hs hsVar = new C1872hs();
        hsVar.mo17791d(str);
        hsVar.mo17787c("hb_name");
        hsVar.mo17779a("hb_channel");
        hsVar.mo17778a(1);
        String str2 = null;
        hsVar.mo17784b((String) null);
        hsVar.mo17781a(false);
        hsVar.mo17783b(System.currentTimeMillis());
        hsVar.mo17798g(this.f3888a.getPackageName());
        hsVar.mo17793e("com.xiaomi.xmsf");
        if (map != null) {
            C2071n a = C2072o.m5301a(this.f3888a);
            if (a != null && !TextUtils.isEmpty(a.f3926a)) {
                String[] split = a.f3926a.split("@");
                if (split.length > 0) {
                    str2 = split[0];
                }
            }
            map.put("uuid", str2);
            hsVar.mo17780a(map);
        }
        C1866hm a2 = C1866hm.m3887a(this.f3888a);
        if (a2 != null) {
            a2.mo17763a(hsVar, this.f3888a.getPackageName());
        }
    }

    /* renamed from: a */
    private boolean m5238a() {
        return this.f3891a.get() >= Math.max(C1995at.m5047a(this.f3888a).mo18465a(C1873ht.IntelligentHeartbeatNATCountInt.mo17806a(), 5), 3);
    }

    /* renamed from: a */
    private boolean mo18533a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5240b(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "WIFI-ID-UNKNOWN"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0016
            java.lang.String r4 = r3.f3890a
            if (r4 == 0) goto L_0x0015
            java.lang.String r0 = "W-"
            boolean r4 = r4.startsWith(r0)
            if (r4 == 0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            r4 = 0
        L_0x0016:
            r3.f3890a = r4
        L_0x0018:
            java.util.concurrent.atomic.AtomicInteger r4 = r3.f3891a
            r0 = 0
            r4.getAndSet(r0)
            java.lang.String r4 = r3.f3890a
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r1 = 1
            if (r4 != 0) goto L_0x0032
            int r4 = r3.mo18531a()
            r2 = -1
            if (r4 == r2) goto L_0x002f
            goto L_0x0032
        L_0x002f:
            r3.f3892a = r1
            goto L_0x0034
        L_0x0032:
            r3.f3892a = r0
        L_0x0034:
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r2 = r3.f3890a
            r4[r0] = r2
            boolean r0 = r3.f3892a
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r4[r1] = r0
            java.lang.String r0 = "[HB] network changed, netid:%s, %s"
            java.lang.String r4 = java.lang.String.format(r0, r4)
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2061i.m5240b(java.lang.String):void");
    }

    /* renamed from: b */
    private boolean mo18534b() {
        return !TextUtils.isEmpty(this.f3890a) && this.f3890a.startsWith("M-") && !C1995at.m5047a(this.f3888a).mo18472a(C1873ht.IntelligentHeartbeatUseInMobileNetworkBoolean.mo17806a(), false);
    }

    /* renamed from: c */
    private void m5242c(String str) {
        if (mo18533a(str)) {
            SharedPreferences.Editor edit = this.f3889a.edit();
            edit.putInt("HB_" + str, 235000);
            edit.apply();
        }
    }

    /* renamed from: c */
    private boolean mo18535c() {
        return mo18536d() && C1995at.m5047a(this.f3888a).mo18472a(C1873ht.IntelligentHeartbeatDataCollectSwitchBoolean.mo17806a(), true) && C1941p.China.name().equals(C1966a.m4862a(this.f3888a).mo18436a());
    }

    /* renamed from: d */
    private void m5244d(String str) {
        String str2;
        String str3;
        if (mo18535c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
            } else if (str.startsWith("M-")) {
                str2 = "M";
            } else {
                return;
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(valueOf);
            sb.append(":::");
            sb.append(valueOf2);
            String string = this.f3889a.getString("record_hb_change", (String) null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            SharedPreferences.Editor edit = this.f3889a.edit();
            edit.putString("record_hb_change", str3);
            edit.apply();
        }
    }

    /* renamed from: d */
    private boolean mo18536d() {
        return this.f3895b && this.f3896c;
    }

    /* renamed from: e */
    private void m5246e() {
        if (mo18535c()) {
            int incrementAndGet = this.f3894b.incrementAndGet();
            C1524b.m2158b("[HB] short ping interval count:" + incrementAndGet);
            if (incrementAndGet >= 5) {
                SharedPreferences.Editor edit = this.f3889a.edit();
                int i = this.f3889a.getInt("record_short_hb_count", 0);
                if (i <= 0 && this.f3887a <= 0) {
                    this.f3887a = System.currentTimeMillis();
                    edit.putLong("record_short_hb_count_start", this.f3887a);
                }
                int i2 = i + incrementAndGet;
                C1524b.m2141a("[HB] accumulate short hb count and write to file. " + i2);
                edit.putInt("record_short_hb_count", i2);
                edit.apply();
                this.f3894b.set(0);
            }
        }
    }

    /* renamed from: e */
    private boolean m5247e() {
        if (this.f3887a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f3887a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    /* renamed from: f */
    private void m5248f() {
        if (!this.f3889a.getBoolean("support_wifi_digest", false)) {
            SharedPreferences.Editor edit = this.f3889a.edit();
            edit.putBoolean("support_wifi_digest", true);
            edit.apply();
        }
    }

    /* renamed from: g */
    private void m5249g() {
        String[] split;
        String[] split2;
        if (mo18535c()) {
            String string = this.f3889a.getString("record_hb_change", (String) null);
            char c = 1;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i = 0;
                while (i < split.length) {
                    if (!TextUtils.isEmpty(split[i]) && (split2 = split[i].split(":::")) != null && split2.length >= 4) {
                        String str = split2[0];
                        String str2 = split2[c];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put(NotificationCompat.CATEGORY_EVENT, "change");
                        hashMap.put("model", Build.MODEL);
                        hashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, str2);
                        hashMap.put("net_name", str);
                        hashMap.put("interval", str3);
                        hashMap.put("timestamp", str4);
                        m5237a("category_hb_change", hashMap);
                        C1524b.m2141a("[HB] report hb changed events.");
                    }
                    i++;
                    c = 1;
                }
                SharedPreferences.Editor edit = this.f3889a.edit();
                edit.remove("record_hb_change");
                edit.apply();
            }
            if (this.f3889a.getBoolean("support_wifi_digest", false) && !this.f3889a.getBoolean("record_support_wifi_digest_reported", false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(NotificationCompat.CATEGORY_EVENT, "support");
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                m5237a("category_hb_change", hashMap2);
                C1524b.m2141a("[HB] report support wifi digest events.");
                SharedPreferences.Editor edit2 = this.f3889a.edit();
                edit2.putBoolean("record_support_wifi_digest_reported", true);
                edit2.apply();
            }
            if (m5246e()) {
                int i2 = this.f3889a.getInt("record_short_hb_count", 0);
                String valueOf = String.valueOf(235);
                String valueOf2 = String.valueOf(this.f3887a);
                String valueOf3 = String.valueOf(System.currentTimeMillis());
                HashMap hashMap3 = new HashMap();
                hashMap3.put("interval", valueOf);
                hashMap3.put("count", String.valueOf(i2));
                hashMap3.put("start_time", valueOf2);
                hashMap3.put("end_time", valueOf3);
                m5237a("category_hb_count", hashMap3);
                C1524b.m2141a("[HB] report short hb count events.");
                SharedPreferences.Editor edit3 = this.f3889a.edit();
                edit3.putInt("record_short_hb_count", 0);
                this.f3887a = System.currentTimeMillis();
                edit3.putLong("record_short_hb_count_start", this.f3887a);
                edit3.apply();
            }
        }
    }

    /* renamed from: a */
    public long m5250a() {
        int a;
        long b = (long) C1818ga.m3681b();
        if (!this.f3896c || !C1995at.m5047a(this.f3888a).mo18472a(C1873ht.IntelligentHeartbeatSwitchBoolean.mo17806a(), true) || mo18534b() || (a = mo18531a()) == -1) {
            return b;
        }
        m5246e();
        long j = (long) a;
        C1524b.m2141a("[HB] ping interval:" + j);
        return j;
    }

    /* renamed from: a */
    public void m5251a() {
    }

    /* renamed from: a */
    public synchronized void mo18532a(NetworkInfo networkInfo) {
        if (mo18536d()) {
            String str = null;
            if (networkInfo != null) {
                if (networkInfo.getType() == 0) {
                    String subtypeName = networkInfo.getSubtypeName();
                    if (!TextUtils.isEmpty(subtypeName) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(subtypeName)) {
                        str = "M-" + subtypeName;
                    }
                } else if (networkInfo.getType() == 1 || networkInfo.getType() == 6) {
                    m5240b("WIFI-ID-UNKNOWN");
                }
            }
            m5240b(str);
        }
    }

    /* renamed from: a */
    public synchronized void m5253a(String str) {
        if (!TextUtils.isEmpty(str)) {
            m5248f();
        }
        if (mo18536d() && !TextUtils.isEmpty(str)) {
            m5240b("W-" + str);
        }
    }

    /* renamed from: b */
    public void m5254b() {
        if (mo18536d() && this.f3892a && !TextUtils.isEmpty(this.f3890a) && this.f3890a.equals(this.f3893b)) {
            this.f3891a.getAndIncrement();
            C1524b.m2141a("[HB] ping timeout count:" + this.f3891a);
            if (mo18531a()) {
                C1524b.m2141a("[HB] change hb interval for net:" + this.f3890a);
                m5242c(this.f3890a);
                this.f3892a = false;
                this.f3891a.getAndSet(0);
                m5244d(this.f3890a);
            }
        }
    }

    /* renamed from: c */
    public void m5255c() {
        if (mo18536d()) {
            this.f3893b = this.f3890a;
        }
    }

    /* renamed from: d */
    public void m5256d() {
        if (mo18536d()) {
            m5249g();
            if (this.f3892a) {
                this.f3891a.getAndSet(0);
            }
        }
    }
}
