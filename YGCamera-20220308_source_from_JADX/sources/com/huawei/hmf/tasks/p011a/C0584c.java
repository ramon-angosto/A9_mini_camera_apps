package com.huawei.hmf.tasks.p011a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hmf.tasks.a.c */
public final class C0584c extends CancellationToken {

    /* renamed from: a */
    public final List<Runnable> f181a = new ArrayList();

    /* renamed from: b */
    public final Object f182b = new Object();

    /* renamed from: c */
    public boolean f183c = false;

    public final boolean isCancellationRequested() {
        return this.f183c;
    }

    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f182b) {
            if (this.f183c) {
                runnable.run();
            } else {
                this.f181a.add(runnable);
            }
        }
        return this;
    }
}
