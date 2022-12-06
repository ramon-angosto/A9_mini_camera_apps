package com.huawei.android.pushagent.plugin.a;

import android.content.Context;
import com.huawei.android.pushagent.c.a.a.f;
import com.huawei.android.pushagent.c.a.c;
import com.huawei.android.pushagent.c.a.h;

public class e extends c {
    public e(Context context) {
        super(context, "PushPluginInfo");
        af();
    }

    public String a() {
        return f.b(this.d, a("salt_v2", ""));
    }

    public void a(long j) {
        a("pushCycleTime", (Object) Long.valueOf(j));
    }

    public void a(String str) {
        a("salt_v2", (Object) f.a(this.d, str));
    }

    public void a(String str, long j) {
        a(str + "LastRunTime", (Object) Long.valueOf(j));
    }

    public long b(String str) {
        return c(str + "LastRunTime", 0);
    }

    public void b(long j) {
        a("lastReportLbs", (Object) Long.valueOf(j));
    }

    public void b(String str, long j) {
        a(str + "Cycle", (Object) Long.valueOf(j));
    }

    public boolean b() {
        this.c.remove("salt_v2");
        return e("salt_v2");
    }

    public long c() {
        return c("pushCycleTime", 0);
    }

    public long c(String str) {
        return c(str + "Cycle", 0);
    }

    public long d() {
        return c("minUp", 1800000);
    }

    public void d(String str) {
        a("device_token", (Object) str);
    }

    public long e() {
        return c("maxUp", 86400000);
    }

    public boolean e(String str) {
        return new h(this.d, this.b).f(str);
    }

    public int f() {
        return a("belongId", -1);
    }

    public long g() {
        return c("lastReportLbs", 0);
    }

    public String h() {
        return a("device_token", "");
    }
}
