package com.huawei.android.pushagent.b.a.a.a;

import android.content.Context;
import com.huawei.android.pushagent.a.c;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;

public class b extends com.huawei.android.pushagent.b.a.a.b {
    long e = -1;

    public b(Context context) {
        super(context);
        f();
    }

    public long b(boolean z) {
        if (-1 == com.huawei.android.pushagent.c.a.b.a(this.c)) {
            return a.a(this.c).p() * 1000;
        }
        if (h()) {
            f();
        }
        long j = this.e;
        if (j > 0) {
            return j;
        }
        long B = a.a(this.c).B() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (d() >= currentTimeMillis) {
            a(0);
        }
        return d() <= currentTimeMillis - (a.a(this.c).B() * 1000) ? a.a(this.c).B() * 1000 : (d() > currentTimeMillis || currentTimeMillis > d() + (a.a(this.c).B() * 1000)) ? B : (d() + (a.a(this.c).B() * 1000)) - currentTimeMillis;
    }

    public boolean b(long j) {
        this.e = j;
        return true;
    }

    public String c() {
        return "Push_PollingHBeat";
    }

    public void c(boolean z) {
    }

    public com.huawei.android.pushagent.b.a.a.b f() {
        this.a = new h(this.c, c()).d("lastHeartBeatTime");
        return this;
    }

    public void g() {
        try {
            com.huawei.android.pushagent.b.a.a.f().a(false);
        } catch (c e2) {
            e.c("PushLogAC2705", e2.toString(), e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }
}
