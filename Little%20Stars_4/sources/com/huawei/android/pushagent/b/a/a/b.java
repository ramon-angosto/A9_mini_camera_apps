package com.huawei.android.pushagent.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import java.util.Date;

public abstract class b {
    public long a = 0;
    public boolean b = false;
    public Context c = null;
    public int d = 1;

    public b(Context context) {
        this.c = context;
    }

    public void a() {
        if (a.b(this.c) == this) {
            long b2 = b(false);
            e.a("PushLogAC2705", "after delayHeartBeatReq, nextHeartBeatTime, will be " + b2 + "ms later");
            com.huawei.android.pushagent.c.a.a.b(this.c, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", b2).setPackage(this.c.getPackageName()), b2);
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.a = j;
        new h(this.c, c()).a("lastHeartBeatTime", Long.valueOf(j));
    }

    public void a(boolean z) {
        this.b = z;
    }

    public abstract long b(boolean z);

    public void b() {
        if (a.b(this.c) == this) {
            long e = e() - System.currentTimeMillis();
            e.a("PushLogAC2705", "after updateHeartBeatReq, nextHeartBeatTime, will be " + e + "ms later");
            com.huawei.android.pushagent.c.a.a.b(this.c, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", e).setPackage(this.c.getPackageName()), e);
        }
    }

    public abstract boolean b(long j);

    public String c() {
        return getClass().getSimpleName();
    }

    public abstract void c(boolean z);

    public long d() {
        return this.a;
    }

    public long e() {
        long currentTimeMillis = System.currentTimeMillis();
        long b2 = b(false);
        return (d() > currentTimeMillis || d() + b2 <= currentTimeMillis) ? currentTimeMillis + b2 : d() + b2;
    }

    public abstract b f();

    public abstract void g();

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lastHeartBeatTime");
        stringBuffer.append(new Date(this.a));
        stringBuffer.append(" heartBeatInterval");
        stringBuffer.append(b(false));
        return stringBuffer.toString();
    }
}
