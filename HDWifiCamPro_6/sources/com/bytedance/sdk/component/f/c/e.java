package com.bytedance.sdk.component.f.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.k;
import com.bytedance.sdk.component.f.d.b;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TNCManager */
public class e {
    Handler a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 10000) {
                e.this.b(message.arg1 != 0);
            }
        }
    };
    private long b = 0;
    private a c;
    private boolean d;
    private b e;
    private boolean f = false;
    private Context g;
    private d h;
    private int i = 0;
    private long j = 19700101000L;
    private int k = 0;
    private HashMap<String, Integer> l = new HashMap<>();
    private HashMap<String, Integer> m = new HashMap<>();
    private int n = 0;
    private HashMap<String, Integer> o = new HashMap<>();
    private HashMap<String, Integer> p = new HashMap<>();
    private boolean q = true;
    private Map<String, Integer> r = new HashMap();
    private int s;

    private e() {
    }

    public e(int i2) {
        this.s = i2;
    }

    private String a(k kVar) {
        if (kVar == null || kVar.b() == null || kVar.b().a() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(kVar.b().a().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bytedance.sdk.component.b.a.m r12, java.lang.String r13) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = r11.q
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            r0 = 0
            java.lang.String r1 = "tnc-cmd"
            java.lang.String r12 = r12.a(r1, r0)
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "TNCManager"
            if (r0 == 0) goto L_0x002f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "handleTncProbe, no probeProto, "
        L_0x0021:
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            return
        L_0x002f:
            java.lang.String r0 = "@"
            java.lang.String[] r12 = r12.split(r0)
            if (r12 == 0) goto L_0x0108
            int r2 = r12.length
            r3 = 2
            if (r2 == r3) goto L_0x003d
            goto L_0x0108
        L_0x003d:
            r2 = 1
            r3 = 0
            r5 = 0
            r6 = r12[r5]     // Catch:{ all -> 0x0050 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ all -> 0x0050 }
            r12 = r12[r2]     // Catch:{ all -> 0x004e }
            long r7 = java.lang.Long.parseLong(r12)     // Catch:{ all -> 0x004e }
            goto L_0x006a
        L_0x004e:
            r12 = move-exception
            goto L_0x0052
        L_0x0050:
            r12 = move-exception
            r6 = r5
        L_0x0052:
            r12.printStackTrace()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r7 = "handleTncProbe, probeProto except, "
            r12.append(r7)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            r7 = r3
        L_0x006a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r9 = "handleTncProbe, local: "
            r12.append(r9)
            int r9 = r11.i
            r12.append(r9)
            r12.append(r0)
            long r9 = r11.j
            r12.append(r9)
            java.lang.String r9 = " svr: "
            r12.append(r9)
            r12.append(r6)
            r12.append(r0)
            r12.append(r7)
            java.lang.String r0 = " "
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            long r9 = r11.j
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 > 0) goto L_0x00a5
            return
        L_0x00a5:
            r11.i = r6
            r11.j = r7
            android.content.Context r12 = r11.g
            java.lang.String r9 = r11.a()
            android.content.SharedPreferences r12 = r12.getSharedPreferences(r9, r5)
            android.content.SharedPreferences$Editor r12 = r12.edit()
            java.lang.String r5 = "tnc_probe_cmd"
            android.content.SharedPreferences$Editor r12 = r12.putInt(r5, r6)
            java.lang.String r5 = "tnc_probe_version"
            android.content.SharedPreferences$Editor r12 = r12.putLong(r5, r7)
            r12.apply()
            int r12 = r11.i
            r5 = 10000(0x2710, float:1.4013E-41)
            if (r12 != r5) goto L_0x0107
            com.bytedance.sdk.component.f.c.c r12 = r11.f()
            if (r12 != 0) goto L_0x00d3
            return
        L_0x00d3:
            java.util.Random r5 = new java.util.Random
            long r6 = java.lang.System.currentTimeMillis()
            r5.<init>(r6)
            int r6 = r12.l
            if (r6 <= 0) goto L_0x00ea
            int r12 = r12.l
            int r12 = r5.nextInt(r12)
            long r3 = (long) r12
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
        L_0x00ea:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r5 = "handleTncProbe, updateConfig delay: "
            r12.append(r5)
            r12.append(r3)
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            r11.a((boolean) r2, (long) r3)
        L_0x0107:
            return
        L_0x0108:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "handleTncProbe, probeProto err, "
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(com.bytedance.sdk.component.b.a.m, java.lang.String):void");
    }

    private void a(boolean z, long j2) {
        if (!this.a.hasMessages(10000)) {
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.what = 10000;
            obtainMessage.arg1 = z ? 1 : 0;
            if (j2 > 0) {
                this.a.sendMessageDelayed(obtainMessage, j2);
            } else {
                this.a.sendMessage(obtainMessage);
            }
        }
    }

    private boolean a(int i2) {
        return i2 >= 200 && i2 < 400;
    }

    private void b(String str) {
        Map<String, String> g2;
        if (TextUtils.isEmpty(str) || (g2 = g()) == null || !g2.containsValue(str)) {
            return;
        }
        if (this.r.get(str) == null) {
            this.r.put(str, 1);
            return;
        }
        this.r.put(str, Integer.valueOf(this.r.get(str).intValue() + 1));
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        c f2 = f();
        if (f2 != null) {
            b.b("TNCManager", "doUpdateRemote, " + z);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.b + (((long) f2.k) * 1000) <= elapsedRealtime) {
                this.b = elapsedRealtime;
                g.a().a(this.s, this.g).c();
                return;
            }
            b.b("TNCManager", "doUpdateRemote, time limit");
        }
    }

    private boolean b(int i2) {
        if (i2 < 100 || i2 >= 1000) {
            return true;
        }
        c f2 = f();
        if (f2 == null || TextUtils.isEmpty(f2.m)) {
            return false;
        }
        String str = f2.m;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i2);
        return str.contains(sb.toString());
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.r.containsKey(str)) {
            this.r.put(str, 0);
        }
    }

    private boolean d(String str) {
        Map<String, String> g2 = g();
        if (g2 == null) {
            return false;
        }
        String str2 = g2.get(str);
        if (TextUtils.isEmpty(str2) || this.r.get(str2) == null || this.r.get(str2).intValue() < 3) {
            return false;
        }
        b.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r4 = r4.toCharArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r2 >= r4.length) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r4[r2] = (char) (r4[r2] ^ r2);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return new java.lang.String(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = 'J';
        r1 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        switch(r1) {
            case 55: goto L_0x0039;
            case 56: goto L_0x004f;
            case 57: goto L_0x0010;
            default: goto L_0x000f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        switch(1) {
            case 60: goto L_0x0017;
            case 61: goto L_0x0023;
            case 62: goto L_0x0030;
            default: goto L_0x0016;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e1667305730908dc(java.lang.String r4) {
        /*
        L_0x0000:
            r0 = 73
            r1 = 96
        L_0x0004:
            r2 = 0
            switch(r0) {
                case 72: goto L_0x004f;
                case 73: goto L_0x0009;
                case 74: goto L_0x000c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0054
        L_0x0009:
            switch(r1) {
                case 94: goto L_0x0000;
                case 95: goto L_0x0010;
                case 96: goto L_0x004f;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r1) {
                case 55: goto L_0x0039;
                case 56: goto L_0x004f;
                case 57: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0000
        L_0x0010:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0017;
                case 61: goto L_0x0023;
                case 62: goto L_0x0030;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x004f
        L_0x0017:
            int r3 = 0 - r1
            int r3 = r3 * r2
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0000
        L_0x0023:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x004f
        L_0x0030:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L_0x0000
        L_0x0039:
            char[] r4 = r4.toCharArray()
        L_0x003d:
            int r0 = r4.length
            if (r2 >= r0) goto L_0x0049
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0049:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L_0x004f:
            r0 = 74
            r1 = 55
            goto L_0x0004
        L_0x0054:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.e1667305730908dc(java.lang.String):java.lang.String");
    }

    private void i() {
        SharedPreferences sharedPreferences = this.g.getSharedPreferences(a(), 0);
        this.i = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.j = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void j() {
        b.b("TNCManager", "resetTNCControlState");
        this.k = 0;
        this.l.clear();
        this.m.clear();
        this.n = 0;
        this.o.clear();
        this.p.clear();
    }

    public String a() {
        return "ttnet_tnc_config" + this.s;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00fc
            java.lang.String r0 = "/network/get_network"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x00fc
            java.lang.String r0 = "/get_domains/v4"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x00fc
            java.lang.String r0 = "/ies/speed"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x0029
            goto L_0x00fc
        L_0x0029:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x003a }
            r1.<init>(r7)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r1.getProtocol()     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r1.getHost()     // Catch:{ all -> 0x0038 }
            goto L_0x003f
        L_0x0038:
            r1 = move-exception
            goto L_0x003c
        L_0x003a:
            r1 = move-exception
            r2 = r0
        L_0x003c:
            r1.printStackTrace()
        L_0x003f:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00fc
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00fc
        L_0x0058:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0063
            goto L_0x00fc
        L_0x0063:
            boolean r1 = r6.d(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L_0x0080
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
        L_0x0072:
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x007c:
            com.bytedance.sdk.component.f.d.b.b(r3, r0)
            return r7
        L_0x0080:
            java.util.Map r1 = r6.g()
            if (r1 == 0) goto L_0x00f3
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L_0x008d
            goto L_0x00f3
        L_0x008d:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x009d
            return r7
        L_0x009d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleHostMapping, match, origin: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.bytedance.sdk.component.f.d.b.b(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "://"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto L_0x00e1
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        L_0x00e1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleHostMapping, target: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            goto L_0x007c
        L_0x00f3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, nomatch: "
            goto L_0x0072
        L_0x00fc:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(java.lang.String):java.lang.String");
    }

    public synchronized void a(Context context, boolean z) {
        if (!this.f) {
            this.g = context;
            this.q = z;
            this.h = new d(context, z, this.s);
            if (z) {
                i();
            }
            b.b("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.i + " probeVersion: " + this.j);
            this.c = g.a().a(this.s, this.g);
            this.f = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0198, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x019d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bytedance.sdk.component.b.a.k r8, com.bytedance.sdk.component.b.a.m r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 == 0) goto L_0x019c
            if (r9 != 0) goto L_0x0007
            goto L_0x019c
        L_0x0007:
            boolean r0 = r7.q     // Catch:{ all -> 0x0199 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r7)
            return
        L_0x000d:
            android.content.Context r0 = r7.g     // Catch:{ all -> 0x0199 }
            boolean r0 = com.bytedance.sdk.component.f.d.e.a(r0)     // Catch:{ all -> 0x0199 }
            if (r0 != 0) goto L_0x0017
            monitor-exit(r7)
            return
        L_0x0017:
            r0 = 0
            com.bytedance.sdk.component.b.a.f r1 = r8.b()     // Catch:{ Exception -> 0x0020 }
            java.net.URL r0 = r1.a()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            if (r0 != 0) goto L_0x0024
            monitor-exit(r7)
            return
        L_0x0024:
            java.lang.String r1 = r0.getProtocol()     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r0.getHost()     // Catch:{ all -> 0x0199 }
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0199 }
            java.lang.String r8 = r7.a((com.bytedance.sdk.component.b.a.k) r8)     // Catch:{ all -> 0x0199 }
            int r3 = r9.c()     // Catch:{ all -> 0x0199 }
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x0199 }
            if (r4 != 0) goto L_0x004a
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x0199 }
            if (r4 != 0) goto L_0x004a
            monitor-exit(r7)
            return
        L_0x004a:
            r4 = r8
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0199 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0199 }
            if (r4 == 0) goto L_0x0055
            monitor-exit(r7)
            return
        L_0x0055:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r4.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "TNCManager"
            java.lang.String r6 = "onResponse, url: "
            r4.append(r6)     // Catch:{ all -> 0x0199 }
            r4.append(r1)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "://"
            r4.append(r6)     // Catch:{ all -> 0x0199 }
            r4.append(r2)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r4.append(r6)     // Catch:{ all -> 0x0199 }
            r4.append(r8)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r4.append(r6)     // Catch:{ all -> 0x0199 }
            r4.append(r3)     // Catch:{ all -> 0x0199 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0199 }
            com.bytedance.sdk.component.f.d.b.b(r5, r4)     // Catch:{ all -> 0x0199 }
            com.bytedance.sdk.component.f.c.c r4 = r7.f()     // Catch:{ all -> 0x0199 }
            if (r4 == 0) goto L_0x0090
            boolean r5 = r4.b     // Catch:{ all -> 0x0199 }
            if (r5 == 0) goto L_0x0090
            r7.a((com.bytedance.sdk.component.b.a.m) r9, (java.lang.String) r2)     // Catch:{ all -> 0x0199 }
        L_0x0090:
            if (r4 != 0) goto L_0x0094
            monitor-exit(r7)
            return
        L_0x0094:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r9.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "TNCManager"
            java.lang.String r6 = "onResponse, url matched: "
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            r9.append(r1)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "://"
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            r9.append(r2)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            r9.append(r8)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            r9.append(r3)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = " "
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            int r6 = r7.k     // Catch:{ all -> 0x0199 }
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.l     // Catch:{ all -> 0x0199 }
            int r6 = r6.size()     // Catch:{ all -> 0x0199 }
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.m     // Catch:{ all -> 0x0199 }
            int r6 = r6.size()     // Catch:{ all -> 0x0199 }
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = " "
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            int r6 = r7.n     // Catch:{ all -> 0x0199 }
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.o     // Catch:{ all -> 0x0199 }
            int r6 = r6.size()     // Catch:{ all -> 0x0199 }
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = "#"
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r7.p     // Catch:{ all -> 0x0199 }
            int r6 = r6.size()     // Catch:{ all -> 0x0199 }
            r9.append(r6)     // Catch:{ all -> 0x0199 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0199 }
            com.bytedance.sdk.component.f.d.b.b(r5, r9)     // Catch:{ all -> 0x0199 }
            if (r3 <= 0) goto L_0x0197
            boolean r9 = r7.a((int) r3)     // Catch:{ all -> 0x0199 }
            if (r9 == 0) goto L_0x0125
            int r8 = r7.k     // Catch:{ all -> 0x0199 }
            if (r8 > 0) goto L_0x011e
            int r8 = r7.n     // Catch:{ all -> 0x0199 }
            if (r8 <= 0) goto L_0x0121
        L_0x011e:
            r7.j()     // Catch:{ all -> 0x0199 }
        L_0x0121:
            r7.c(r2)     // Catch:{ all -> 0x0199 }
            goto L_0x0197
        L_0x0125:
            boolean r9 = r7.b((int) r3)     // Catch:{ all -> 0x0199 }
            if (r9 != 0) goto L_0x0197
            int r9 = r7.n     // Catch:{ all -> 0x0199 }
            int r9 = r9 + 1
            r7.n = r9     // Catch:{ all -> 0x0199 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.o     // Catch:{ all -> 0x0199 }
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0199 }
            r9.put(r0, r6)     // Catch:{ all -> 0x0199 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.p     // Catch:{ all -> 0x0199 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0199 }
            r9.put(r8, r0)     // Catch:{ all -> 0x0199 }
            int r9 = r7.n     // Catch:{ all -> 0x0199 }
            int r0 = r4.h     // Catch:{ all -> 0x0199 }
            if (r9 < r0) goto L_0x0194
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.o     // Catch:{ all -> 0x0199 }
            int r9 = r9.size()     // Catch:{ all -> 0x0199 }
            int r0 = r4.i     // Catch:{ all -> 0x0199 }
            if (r9 < r0) goto L_0x0194
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.p     // Catch:{ all -> 0x0199 }
            int r9 = r9.size()     // Catch:{ all -> 0x0199 }
            int r0 = r4.j     // Catch:{ all -> 0x0199 }
            if (r9 < r0) goto L_0x0194
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r9.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r0 = "TNCManager"
            java.lang.String r4 = "onResponse, url doUpdate: "
            r9.append(r4)     // Catch:{ all -> 0x0199 }
            r9.append(r1)     // Catch:{ all -> 0x0199 }
            java.lang.String r1 = "://"
            r9.append(r1)     // Catch:{ all -> 0x0199 }
            r9.append(r2)     // Catch:{ all -> 0x0199 }
            java.lang.String r1 = "#"
            r9.append(r1)     // Catch:{ all -> 0x0199 }
            r9.append(r8)     // Catch:{ all -> 0x0199 }
            java.lang.String r8 = "#"
            r9.append(r8)     // Catch:{ all -> 0x0199 }
            r9.append(r3)     // Catch:{ all -> 0x0199 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0199 }
            com.bytedance.sdk.component.f.d.b.b(r0, r8)     // Catch:{ all -> 0x0199 }
            r8 = 0
            r7.a((boolean) r5, (long) r8)     // Catch:{ all -> 0x0199 }
            r7.j()     // Catch:{ all -> 0x0199 }
        L_0x0194:
            r7.b((java.lang.String) r2)     // Catch:{ all -> 0x0199 }
        L_0x0197:
            monitor-exit(r7)
            return
        L_0x0199:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x019c:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(com.bytedance.sdk.component.b.a.k, com.bytedance.sdk.component.b.a.m):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0130, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bytedance.sdk.component.b.a.k r7, java.lang.Exception r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 == 0) goto L_0x012f
            com.bytedance.sdk.component.b.a.f r0 = r7.b()     // Catch:{ all -> 0x012c }
            if (r0 == 0) goto L_0x012f
            if (r8 != 0) goto L_0x000d
            goto L_0x012f
        L_0x000d:
            boolean r8 = r6.q     // Catch:{ all -> 0x012c }
            if (r8 != 0) goto L_0x0013
            monitor-exit(r6)
            return
        L_0x0013:
            android.content.Context r8 = r6.g     // Catch:{ all -> 0x012c }
            boolean r8 = com.bytedance.sdk.component.f.d.e.a(r8)     // Catch:{ all -> 0x012c }
            if (r8 != 0) goto L_0x001d
            monitor-exit(r6)
            return
        L_0x001d:
            r8 = 0
            com.bytedance.sdk.component.b.a.f r0 = r7.b()     // Catch:{ Exception -> 0x0026 }
            java.net.URL r8 = r0.a()     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            if (r8 != 0) goto L_0x002a
            monitor-exit(r6)
            return
        L_0x002a:
            java.lang.String r0 = r8.getProtocol()     // Catch:{ all -> 0x012c }
            java.lang.String r1 = r8.getHost()     // Catch:{ all -> 0x012c }
            java.lang.String r8 = r8.getPath()     // Catch:{ all -> 0x012c }
            java.lang.String r7 = r6.a((com.bytedance.sdk.component.b.a.k) r7)     // Catch:{ all -> 0x012c }
            java.lang.String r2 = "http"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x004c
            java.lang.String r2 = "https"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x004c
            monitor-exit(r6)
            return
        L_0x004c:
            com.bytedance.sdk.component.f.c.c r2 = r6.f()     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x0054
            monitor-exit(r6)
            return
        L_0x0054:
            java.lang.String r3 = "TNCManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x012c }
            r4.<init>()     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "onError, url matched: "
            r4.append(r5)     // Catch:{ all -> 0x012c }
            r4.append(r0)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "://"
            r4.append(r5)     // Catch:{ all -> 0x012c }
            r4.append(r1)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "#"
            r4.append(r5)     // Catch:{ all -> 0x012c }
            r4.append(r7)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "# "
            r4.append(r5)     // Catch:{ all -> 0x012c }
            int r5 = r6.k     // Catch:{ all -> 0x012c }
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "#"
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r6.l     // Catch:{ all -> 0x012c }
            int r5 = r5.size()     // Catch:{ all -> 0x012c }
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "#"
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r6.m     // Catch:{ all -> 0x012c }
            int r5 = r5.size()     // Catch:{ all -> 0x012c }
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = " "
            r4.append(r5)     // Catch:{ all -> 0x012c }
            int r5 = r6.n     // Catch:{ all -> 0x012c }
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "#"
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r6.o     // Catch:{ all -> 0x012c }
            int r5 = r5.size()     // Catch:{ all -> 0x012c }
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.lang.String r5 = "#"
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r6.p     // Catch:{ all -> 0x012c }
            int r5 = r5.size()     // Catch:{ all -> 0x012c }
            r4.append(r5)     // Catch:{ all -> 0x012c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x012c }
            com.bytedance.sdk.component.f.d.b.b(r3, r4)     // Catch:{ all -> 0x012c }
            int r3 = r6.k     // Catch:{ all -> 0x012c }
            int r3 = r3 + 1
            r6.k = r3     // Catch:{ all -> 0x012c }
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r6.l     // Catch:{ all -> 0x012c }
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
            r3.put(r8, r5)     // Catch:{ all -> 0x012c }
            java.util.HashMap<java.lang.String, java.lang.Integer> r8 = r6.m     // Catch:{ all -> 0x012c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x012c }
            r8.put(r7, r3)     // Catch:{ all -> 0x012c }
            int r8 = r6.k     // Catch:{ all -> 0x012c }
            int r3 = r2.e     // Catch:{ all -> 0x012c }
            if (r8 < r3) goto L_0x0127
            java.util.HashMap<java.lang.String, java.lang.Integer> r8 = r6.l     // Catch:{ all -> 0x012c }
            int r8 = r8.size()     // Catch:{ all -> 0x012c }
            int r3 = r2.f     // Catch:{ all -> 0x012c }
            if (r8 < r3) goto L_0x0127
            java.util.HashMap<java.lang.String, java.lang.Integer> r8 = r6.m     // Catch:{ all -> 0x012c }
            int r8 = r8.size()     // Catch:{ all -> 0x012c }
            int r2 = r2.g     // Catch:{ all -> 0x012c }
            if (r8 < r2) goto L_0x0127
            java.lang.String r8 = "TNCManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012c }
            r2.<init>()     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "onError, url doUpate: "
            r2.append(r3)     // Catch:{ all -> 0x012c }
            r2.append(r0)     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "://"
            r2.append(r0)     // Catch:{ all -> 0x012c }
            r2.append(r1)     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "#"
            r2.append(r0)     // Catch:{ all -> 0x012c }
            r2.append(r7)     // Catch:{ all -> 0x012c }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x012c }
            com.bytedance.sdk.component.f.d.b.b(r8, r7)     // Catch:{ all -> 0x012c }
            r7 = 0
            r6.a((boolean) r4, (long) r7)     // Catch:{ all -> 0x012c }
            r6.j()     // Catch:{ all -> 0x012c }
        L_0x0127:
            r6.b((java.lang.String) r1)     // Catch:{ all -> 0x012c }
            monitor-exit(r6)
            return
        L_0x012c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x012f:
            monitor-exit(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(com.bytedance.sdk.component.b.a.k, java.lang.Exception):void");
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public a b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public b d() {
        return this.e;
    }

    public void e() {
        this.r.clear();
    }

    public c f() {
        d dVar = this.h;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public Map<String, String> g() {
        c f2 = f();
        if (f2 != null) {
            return f2.d;
        }
        return null;
    }

    public d h() {
        return this.h;
    }
}
