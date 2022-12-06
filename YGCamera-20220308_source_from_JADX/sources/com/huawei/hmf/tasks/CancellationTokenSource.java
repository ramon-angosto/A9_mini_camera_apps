package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p011a.C0584c;

public class CancellationTokenSource {
    private C0584c impl = new C0584c();

    public void cancel() {
        C0584c cVar = this.impl;
        if (!cVar.f183c) {
            synchronized (cVar.f182b) {
                cVar.f183c = true;
                for (Runnable run : cVar.f181a) {
                    run.run();
                }
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
