package com.bytedance.sdk.component.a;

import android.webkit.WebView;
import com.bytedance.sdk.component.a.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsBridge2 */
public class r {
    static w a;
    private final a b;
    private final WebView c;
    private final j d;
    private final List<n> e = new ArrayList();
    private o f;
    private volatile boolean g = false;

    public static j a(WebView webView) {
        return new j(webView);
    }

    public r a(String str, e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    public r a(String str, String str2, e<?, ?> eVar) {
        b();
        this.b.g.a(str, eVar);
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public r a(String str, d.b bVar) {
        return a(str, (String) null, bVar);
    }

    public r a(String str, String str2, d.b bVar) {
        b();
        this.b.g.a(str, bVar);
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public void a() {
        if (!this.g) {
            this.b.b();
            this.g = true;
            for (n next : this.e) {
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r0 = a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    r(com.bytedance.sdk.component.a.j r3) {
        /*
            r2 = this;
            r2.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.e = r0
            r0 = 0
            r2.g = r0
            r2.d = r3
            boolean r0 = r3.h
            if (r0 == 0) goto L_0x001e
            com.bytedance.sdk.component.a.w r0 = a
            if (r0 == 0) goto L_0x001e
            java.lang.String r1 = r3.k
            com.bytedance.sdk.component.a.v r0 = r0.a((java.lang.String) r1)
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            android.webkit.WebView r1 = r3.a
            if (r1 == 0) goto L_0x0034
            com.bytedance.sdk.component.a.a r1 = r3.b
            if (r1 != 0) goto L_0x002f
            com.bytedance.sdk.component.a.z r1 = new com.bytedance.sdk.component.a.z
            r1.<init>()
            r2.b = r1
            goto L_0x0038
        L_0x002f:
            com.bytedance.sdk.component.a.a r1 = r3.b
            r2.b = r1
            goto L_0x0038
        L_0x0034:
            com.bytedance.sdk.component.a.a r1 = r3.b
            r2.b = r1
        L_0x0038:
            com.bytedance.sdk.component.a.a r1 = r2.b
            r1.a((com.bytedance.sdk.component.a.j) r3, (com.bytedance.sdk.component.a.v) r0)
            android.webkit.WebView r0 = r3.a
            r2.c = r0
            java.util.List<com.bytedance.sdk.component.a.n> r0 = r2.e
            com.bytedance.sdk.component.a.n r1 = r3.j
            r0.add(r1)
            boolean r0 = r3.f
            com.bytedance.sdk.component.a.i.a((boolean) r0)
            boolean r3 = r3.g
            com.bytedance.sdk.component.a.y.a((boolean) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.a.r.<init>(com.bytedance.sdk.component.a.j):void");
    }

    private void b() {
        if (this.g) {
            i.a((RuntimeException) new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
