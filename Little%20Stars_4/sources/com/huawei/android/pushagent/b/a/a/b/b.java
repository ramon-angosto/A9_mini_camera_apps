package com.huawei.android.pushagent.b.a.a.b;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.b.j;
import com.huawei.android.pushagent.a.e;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.Set;

public class b extends com.huawei.android.pushagent.b.a.a.b {
    public long e = 7200000;
    private boolean f = false;
    private long g;
    private long h;
    private int i;
    private String j;
    private String k;
    private String l;

    public b(Context context) {
        super(context);
        long j2 = this.e;
        this.g = j2;
        this.h = j2;
        this.i = 0;
        this.j = "";
        this.k = "";
        this.l = null;
    }

    private void a(e eVar, String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                Set keySet = eVar.S().keySet();
                if (keySet.size() > 0) {
                    Iterator it = keySet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        if (str2.contains(str)) {
                            String str3 = (String) eVar.S().get(str2);
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "apnName is:" + str2 + ",apnHeartBeat is:" + str3);
                            String[] split = str3.split("_");
                            this.g = Long.parseLong(split[0]) * 1000;
                            this.h = Long.parseLong(split[1]) * 1000;
                            z = true;
                            break;
                        }
                    }
                }
            } catch (Exception e2) {
                com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", e2.toString(), e2);
            }
        }
        if (!z) {
            this.g = eVar.i() * 1000;
            this.h = eVar.j() * 1000;
        }
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "after all, minHeartBeat is :" + this.g + ",maxHeartBeat is:" + this.h);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String j() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            com.huawei.android.pushagent.b.a.a.a r1 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x0025
            com.huawei.android.pushagent.b.a.a.a r1 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ Exception -> 0x001b }
            java.net.Socket r1 = r1.c()     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x0025
            java.net.InetAddress r1 = r1.getLocalAddress()     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = r1.getHostAddress()     // Catch:{ Exception -> 0x001b }
            goto L_0x0026
        L_0x001b:
            r1 = move-exception
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PushLogAC2705"
            com.huawei.android.pushagent.c.a.e.a(r2, r1)
        L_0x0025:
            r1 = r0
        L_0x0026:
            if (r1 != 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.b.b.j():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Long k() {
        /*
            r6 = this;
            java.lang.String r0 = "PushLogAC2705"
            android.content.Context r1 = r6.c
            java.lang.String r2 = "cloudpush_fixHeatBeat"
            java.lang.String r3 = ""
            java.lang.String r1 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r3)
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r4 = r1.trim()     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            long r4 = r4 * r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            java.lang.String r3 = "get heart beat from config, value:"
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            r2.append(r4)     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            java.lang.String r3 = " so neednot ajust"
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            com.huawei.android.pushagent.c.a.e.a(r0, r2)     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0057, Exception -> 0x0036 }
            return r0
        L_0x0036:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "get cloudpush_fixHeatBeat:"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " cause:"
            r3.append(r1)
            java.lang.String r1 = r2.toString()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.android.pushagent.c.a.e.c(r0, r1, r2)
        L_0x0057:
            r1 = 2
            int r2 = r6.d
            if (r1 == r2) goto L_0x0061
            r1 = 5
            int r2 = r6.d
            if (r1 != r2) goto L_0x0077
        L_0x0061:
            r1 = 1
            android.content.Context r2 = r6.c
            int r2 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r2)
            if (r1 != r2) goto L_0x0077
            java.lang.String r1 = "in wifi and in charging, cannot ajust heartBeat"
            com.huawei.android.pushagent.c.a.e.a(r0, r1)
            r0 = 60000(0xea60, double:2.9644E-319)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        L_0x0077:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.b.b.k():java.lang.Long");
    }

    private boolean l() {
        int a = com.huawei.android.pushagent.c.a.b.a(this.c);
        String h2 = a.h(this.c);
        String j2 = a.j(this.c);
        if (1 == a) {
            j2 = "wifi";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("HasFindHeartBeat_" + h2 + "_" + a + "_" + j2, Boolean.valueOf(this.f));
        contentValues.put("HearBeatInterval_" + h2 + "_" + a + "_" + j2, Long.valueOf(this.e));
        StringBuilder sb = new StringBuilder();
        sb.append("ClientIP_");
        sb.append(h2);
        sb.append("_");
        sb.append(a);
        contentValues.put(sb.toString(), this.l);
        if (this.f) {
            String a2 = a.a(System.currentTimeMillis() + com.huawei.android.pushagent.b.b.a.a(this.c).ad(), "yyyy-MM-dd HH:mm:ss SSS");
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "when find best heart beat,save the valid end time " + a2 + " to xml.");
            contentValues.put("HeartBeatValid", a2);
        }
        return new h(this.c, c()).a(contentValues);
    }

    public long b(boolean z) {
        if (-1 == com.huawei.android.pushagent.c.a.b.a(this.c)) {
            com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "no network, use no network heartbeat");
            return com.huawei.android.pushagent.b.b.a.a(this.c).p() * 1000;
        }
        Long k2 = k();
        if (k2 != null) {
            return k2.longValue();
        }
        if (h()) {
            f();
        }
        long j2 = this.e;
        if (this.f) {
            return j2;
        }
        if (!z) {
            j2 += 30000;
        }
        long j3 = this.g;
        if (j2 > j3) {
            j3 = this.h;
            if (j2 < j3) {
                return j2;
            }
        }
        return j3;
    }

    public boolean b(long j2) {
        return true;
    }

    public String c() {
        return "PushHearBeat";
    }

    public void c(boolean z) {
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "enter adjustHeartBeat:(findHeartBeat:" + this.f + " RspTimeOut:" + z + " beatInterval:" + this.e + " range:[" + this.g + Constants.ACCEPT_TIME_SEPARATOR_SP + this.h + "]," + "isHearBeatTimeReq:" + this.b + " batteryStatus:" + this.d + ")");
        if (k() != null || this.f) {
            return;
        }
        if (!this.b) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "It is not hearBeatTimeReq");
            return;
        }
        a(false);
        this.e = b(z);
        if (!z) {
            long j2 = this.e;
            if (j2 > this.g && j2 < this.h) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "set current heartBeatInterval " + this.e + "ms");
                l();
            }
        }
        this.f = true;
        com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "after all the best heartBeat Interval:" + this.e + "ms");
        l();
    }

    public void g() {
        try {
            com.huawei.android.pushagent.c.a.a.c(PushService.a().getContext(), new Intent("com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT").putExtra("timer_reason", "timeOutWaitPushSrvRsp").putExtra("connect_mode", a.C0032a.ConnectEntity_Push.ordinal()).setPackage(this.c.getPackageName()), com.huawei.android.pushagent.b.b.a.a(this.c).Q());
            a(System.currentTimeMillis());
            j jVar = new j();
            double b = (double) b(false);
            Double.isNaN(b);
            jVar.a((byte) ((int) Math.ceil((b * 1.0d) / 60000.0d)));
            com.huawei.android.pushagent.b.a.a.e().a((com.huawei.android.pushagent.a.b) jVar);
        } catch (Exception e2) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "call pushChannel.send cause Exception:" + e2.toString(), e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        int a = com.huawei.android.pushagent.c.a.b.a(this.c);
        String h2 = com.huawei.android.pushagent.c.a.h(this.c);
        if (a == 0) {
            return a != this.i || !h2.equals(this.j) || !com.huawei.android.pushagent.c.a.j(this.c).equals(this.k);
        } else if (a == 1) {
            return a != this.i || !h2.equals(this.j) || !j().equals(this.l);
        } else {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "isEnvChange:netType:" + a + false);
            return false;
        }
    }

    /* renamed from: i */
    public b f() {
        try {
            if (com.huawei.android.pushagent.b.a.a.e() == null) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "system is in start, wait net for heartBeat");
                return null;
            }
            this.l = j();
            ContentValues a = new h(this.c, c()).a();
            if (a != null) {
                String asString = a.getAsString("HeartBeatValid");
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "hear beat valid from xml is " + asString);
                if (!TextUtils.isEmpty(asString) && (System.currentTimeMillis() >= com.huawei.android.pushagent.c.a.a(asString) || System.currentTimeMillis() + com.huawei.android.pushagent.b.b.a.a(this.c).ad() < com.huawei.android.pushagent.c.a.a(asString))) {
                    PushService.a(new Intent("com.huawei.android.push.intent.HEARTBEAT_VALID_ARRIVED"));
                }
            } else {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "PushHearBeat preferences is null");
            }
            this.i = com.huawei.android.pushagent.c.a.b.a(this.c);
            this.j = com.huawei.android.pushagent.c.a.h(this.c);
            com.huawei.android.pushagent.b.b.a a2 = com.huawei.android.pushagent.b.b.a.a(this.c);
            this.g = a2.i() * 1000;
            this.h = a2.j() * 1000;
            int i2 = 0;
            this.f = false;
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "in loadHeartBeat netType:" + this.i + " mccMnc:" + this.j);
            ContentValues a3 = new h(this.c, c()).a();
            int i3 = this.i;
            if (i3 != -1) {
                if (i3 == 0) {
                    this.k = com.huawei.android.pushagent.c.a.j(this.c);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "in loadHeartBeat apnName:" + this.k);
                    a(a2, this.k);
                } else if (i3 != 1) {
                    com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "unKnow net type");
                    return this;
                } else {
                    this.g = a2.g() * 1000;
                    this.h = a2.h() * 1000;
                    this.k = "wifi";
                    this.e = this.g;
                    if (a3 != null) {
                        String asString2 = a3.getAsString("ClientIP_" + this.j + "_" + this.i);
                        if (this.l == null || !this.l.equals(asString2)) {
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "curIP:" + this.l + " oldIP:" + asString2 + ", there are diff, so need find heartBeat again");
                            return this;
                        }
                    }
                }
                this.e = this.g;
                if (a3 != null) {
                    if (a3.containsKey("HasFindHeartBeat_" + this.j + "_" + this.i + "_" + this.k)) {
                        if (a3.containsKey("HearBeatInterval_" + this.j + "_" + this.i + "_" + this.k)) {
                            this.f = a3.getAsBoolean("HasFindHeartBeat_" + this.j + "_" + this.i + "_" + this.k).booleanValue();
                            Integer asInteger = a3.getAsInteger("HearBeatInterval_" + this.j + "_" + this.i + "_" + this.k);
                            if (asInteger != null) {
                                i2 = asInteger.intValue();
                            }
                            long j2 = (long) i2;
                            if (j2 >= 180000) {
                                this.e = j2;
                            }
                        }
                    }
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "have no this heartbeat config, use default");
                }
                return this;
            }
            this.e = a2.p() * 1000;
            return this;
        } catch (Exception e2) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "call loadHeartBeat cause:" + e2.toString(), e2);
            return this;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HasFindHeartBeat");
        stringBuffer.append("=");
        stringBuffer.append(this.f);
        stringBuffer.append(" ");
        stringBuffer.append("HearBeatInterval");
        stringBuffer.append("=");
        stringBuffer.append(this.e);
        stringBuffer.append(" ");
        stringBuffer.append("minHeartBeat");
        stringBuffer.append("=");
        stringBuffer.append(this.g);
        stringBuffer.append(" ");
        stringBuffer.append("maxHeartBeat");
        stringBuffer.append("=");
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }
}
