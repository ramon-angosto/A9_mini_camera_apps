package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.i;

/* compiled from: NativeRenderInterceptor */
public class e implements i {
    private Context a;
    /* access modifiers changed from: private */
    public a b;
    private l c;

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public e(Context context, l lVar, a aVar) {
        this.a = context;
        this.b = aVar;
        this.c = lVar;
    }

    public boolean a(final i.a aVar) {
        this.c.c().d();
        this.b.a(new f() {
            public void a(View view, m mVar) {
                if (!aVar.c()) {
                    n b2 = aVar.b();
                    if (b2 != null) {
                        b2.a(e.this.b, mVar);
                    }
                    aVar.a(true);
                }
            }

            public void a(int i) {
                n b2 = aVar.b();
                if (b2 != null) {
                    b2.a_(i);
                }
            }
        });
        return true;
    }

    public void a(c cVar) {
        this.b.a(cVar);
    }
}
