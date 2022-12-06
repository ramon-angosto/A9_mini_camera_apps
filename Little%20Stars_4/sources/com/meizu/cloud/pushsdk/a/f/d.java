package com.meizu.cloud.pushsdk.a.f;

import com.meizu.cloud.pushsdk.a.d.g;
import com.meizu.cloud.pushsdk.a.d.j;
import com.meizu.cloud.pushsdk.a.e.o;
import com.meizu.cloud.pushsdk.a.h.a;
import com.meizu.cloud.pushsdk.a.h.b;
import com.meizu.cloud.pushsdk.a.h.e;
import com.meizu.cloud.pushsdk.a.h.f;
import com.meizu.cloud.pushsdk.a.h.k;
import java.io.IOException;

public class d extends j {
    private final j a;
    private b b;
    /* access modifiers changed from: private */
    public f c;

    public d(j jVar, o oVar) {
        this.a = jVar;
        if (oVar != null) {
            this.c = new f(oVar);
        }
    }

    public g a() {
        return this.a.a();
    }

    public long b() throws IOException {
        return this.a.b();
    }

    public void a(b bVar) throws IOException {
        if (this.b == null) {
            this.b = f.a(a((k) bVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    private k a(k kVar) {
        return new e(kVar) {
            long a = 0;
            long b = 0;

            public void a(a aVar, long j) throws IOException {
                super.a(aVar, j);
                if (this.b == 0) {
                    this.b = d.this.b();
                }
                this.a += j;
                if (d.this.c != null) {
                    d.this.c.obtainMessage(1, new com.meizu.cloud.pushsdk.a.g.a(this.a, this.b)).sendToTarget();
                }
            }
        };
    }
}
