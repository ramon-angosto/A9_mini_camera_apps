package com.huawei.android.pushagent.plugin.c;

import android.content.Context;
import com.huawei.android.pushagent.plugin.a.e;

public abstract class b {
    public abstract int a();

    public abstract String a(Context context);

    public void a(Context context, long j) {
        e eVar = new e(context);
        long d = eVar.d();
        long e = eVar.e();
        long j2 = j * 60000;
        if (d > j2) {
            j2 = d;
        } else if (e < j2) {
            j2 = e;
        }
        eVar.b(b(), j2);
    }

    public long b(Context context) {
        return new e(context).c(b());
    }

    public abstract String b();

    public void b(Context context, long j) {
        new e(context).a(b(), j);
    }

    public abstract int c();

    public long c(Context context) {
        return new e(context).b(b());
    }
}
