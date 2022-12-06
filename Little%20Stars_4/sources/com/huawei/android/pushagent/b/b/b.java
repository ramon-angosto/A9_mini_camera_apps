package com.huawei.android.pushagent.b.b;

import com.huawei.android.pushagent.a.e;
import com.huawei.android.pushagent.c.c.f;
import com.huawei.android.pushagent.plugin.tools.BLocation;

class b extends Thread {
    final /* synthetic */ a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(a aVar, String str) {
        super(str);
        this.a = aVar;
    }

    public void run() {
        try {
            e a2 = f.a(this.a.d, this.a.b());
            if (a2 == null) {
                a2 = new e(this.a.d);
            }
            if (a2.V()) {
                boolean unused = this.a.b(a2);
                return;
            }
            com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "query trs error:" + this.a.a());
        } catch (Exception e) {
            com.huawei.android.pushagent.c.a.e.c(BLocation.TAG, e.toString(), e);
        }
    }
}
