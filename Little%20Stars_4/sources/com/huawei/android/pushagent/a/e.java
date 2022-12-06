package com.huawei.android.pushagent.a;

import android.content.Context;
import com.huawei.android.pushagent.c.a.c;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import java.util.HashMap;

public class e extends c {
    public e(Context context) {
        super(context, "PushRouteInfo");
    }

    public e(Context context, String str) {
        this(context);
        this.c = g(str);
    }

    private HashMap b(String str, String str2) {
        HashMap hashMap = new HashMap();
        for (String str3 : this.c.keySet()) {
            if (str3.matches(str + "\\d{1,3}")) {
                hashMap.put(Long.valueOf(c(str3, 1)), Long.valueOf(c(str3.replace(str, str2), 2147483647L)));
            }
        }
        return hashMap;
    }

    public long A() {
        return c("push4StartInt", 1800);
    }

    public long B() {
        return c("pollingInterval", 1800);
    }

    public String C() {
        return a("pollingIp", "");
    }

    public int D() {
        return a("pollingPort", -1);
    }

    public int E() {
        return a("pollingId", -1);
    }

    public long F() {
        return c("tokenRegTimeOut", 30);
    }

    public long G() {
        return c("firstQueryTRSDayTimes", 6);
    }

    public long H() {
        return c("firstQueryTRSHourTimes", 2);
    }

    public long I() {
        return c("maxQueryTRSDayTimes", 1);
    }

    public HashMap J() {
        return b("flowcInterval", "flowcVlomes");
    }

    public long K() {
        return c("wifiFirstQueryTRSDayTimes", 18);
    }

    public long L() {
        return c("wifiFirstQueryTRSHourTimes", 6);
    }

    public long M() {
        return c("wifiMaxQueryTRSDayTimes", 3);
    }

    public long N() {
        return c("cloneCheckItval", 600);
    }

    public long O() {
        return c("updateFilesItval", 300);
    }

    public long P() {
        return c("stopServiceItval", 5);
    }

    public long Q() {
        return c("heartBeatRspTimeOut", 10) * 1000;
    }

    public HashMap R() {
        return b("wifiFlowcInterval", "wifiFlowcVlomes");
    }

    public HashMap S() {
        HashMap hashMap = new HashMap();
        for (String str : this.c.keySet()) {
            if (str.startsWith("apn_")) {
                hashMap.put(str, (String) this.c.get(str));
            }
        }
        return hashMap;
    }

    public int T() {
        return a("grpNum", 0);
    }

    public String U() {
        return a("publicKey", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDiCa5gkvCb+/dHAcgN1WMm0ItA\rY1njDoy6bPCE+oHZI439lmjP14PH7n2xtKsuybPbzPAGwuXq4doRz+wB8JiOUjNQ\rVI88zNzDDhdV3pxQlFgk61VojWtVBH2H45qMPMbMs4HdVs0Qcida2IhXOi6eAyRK\rp3PApI7e/ta1FHYKiwIDAQAB");
    }

    public boolean V() {
        return W();
    }

    public boolean W() {
        return !"".equals(c()) && -1 != d() && a() == 0;
    }

    public boolean X() {
        return !"".equals(C()) && -1 != D() && a() == 0;
    }

    public long Y() {
        return c("ConnRange", 600) * 1000;
    }

    public int Z() {
        return a("MaxConnTimes", 3);
    }

    public int a() {
        return a("result", -1);
    }

    public void a(long j) {
        a("wifiMinHeartbeat", (Object) Long.valueOf(j));
    }

    public boolean a(e eVar) {
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "wifiMinHeartbeat=" + g() + ",wifiMaxHeartbeat=" + h() + ",3gMinHeartbeat=" + i() + ",3gMaxHeartbeat=" + j());
        return g() == eVar.g() && h() == eVar.h() && i() == eVar.i() && j() == eVar.j();
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        String b = b();
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "old belongId = " + b + ", current belongId = " + str);
        return b.equals(str);
    }

    public long aa() {
        return c("ReConnInterval", 300) * 1000;
    }

    public long ab() {
        return c("KeepConnTime", 300) * 1000;
    }

    public boolean ac() {
        return a("allowPry", 0) == 1;
    }

    public long ad() {
        return c("hbvalid", 1296000) * 1000;
    }

    public boolean ae() {
        return a("isMultiSimEnabled", 0) != 0;
    }

    public String b() {
        return a("belongId", "-1");
    }

    public void b(long j) {
        a("wifiMaxHeartbeat", (Object) Long.valueOf(j));
    }

    public String c() {
        return a("serverIp", "");
    }

    public void c(long j) {
        a("g3MinHeartbeat", (Object) Long.valueOf(j));
    }

    public int d() {
        return a("serverPort", -1);
    }

    public void d(long j) {
        a("g3MaxHeartbeat", (Object) Long.valueOf(j));
    }

    public long e() {
        return c("trsValid_min", 7200);
    }

    public long f() {
        return c("trsValid_max", 2592000);
    }

    public long g() {
        return c("wifiMinHeartbeat", 1800);
    }

    public long h() {
        return c("wifiMaxHeartbeat", 1800);
    }

    public long i() {
        return c("g3MinHeartbeat", 900);
    }

    public long j() {
        return c("g3MaxHeartbeat", 1800);
    }

    public long k() {
        return c("serverRec1_min", 1);
    }

    public long l() {
        return c("serverRec2_min", 30);
    }

    public long m() {
        return c("serverRec3_min", 300);
    }

    public long n() {
        return c("serverRec4_min", 1800);
    }

    public long o() {
        return c("serverRec5_min", 1800);
    }

    public long p() {
        return c("noNetHeartbeat", 7200);
    }

    public long q() {
        return c("connTrsItval", 300);
    }

    public long r() {
        return c("connTrsErrItval", 1800);
    }

    public long s() {
        return c("SrvMaxFail_times", 6);
    }

    public long t() {
        return c("maxQTRS_times", 6);
    }

    public long u() {
        return c("socketConnTimeOut", 30);
    }

    public long v() {
        return c("socketConnectReadOut", 20);
    }

    public long w() {
        return c("pushLeastRun_time", 30);
    }

    public long x() {
        return c("push1StartInt", 3);
    }

    public long y() {
        return c("push2StartInt", 30);
    }

    public long z() {
        return c("push3StartInt", 600);
    }
}
