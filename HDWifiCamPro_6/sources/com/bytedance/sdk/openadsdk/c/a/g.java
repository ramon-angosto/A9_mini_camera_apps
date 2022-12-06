package com.bytedance.sdk.openadsdk.c.a;

import com.bytedance.sdk.component.e.a.e.d;
import com.bytedance.sdk.component.f.b;

/* compiled from: NetResponseWrapper */
class g implements d {
    private b a;

    public g(b bVar) {
        this.a = bVar;
    }

    public boolean a() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.f();
        }
        return false;
    }

    public int b() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a();
        }
        return -1;
    }
}
