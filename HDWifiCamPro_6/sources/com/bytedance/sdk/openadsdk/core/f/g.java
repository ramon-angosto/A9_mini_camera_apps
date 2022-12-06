package com.bytedance.sdk.openadsdk.core.f;

import android.util.Pair;
import android.view.View;
import com.a.a.a.a.b.a;
import com.a.a.a.a.b.a.e;
import com.a.a.a.a.b.b;
import java.util.Set;

/* compiled from: ViewabilityTracker */
public class g {
    protected boolean a = false;
    protected int b = 0;
    protected String c;
    protected e d;
    private final b e;
    private final a f;
    private boolean g = false;

    /* access modifiers changed from: package-private */
    public void a(float f2, boolean z) {
    }

    public void a(boolean z) {
    }

    public void a(boolean z, float f2) {
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
    }

    public g(b bVar, a aVar, View view) {
        this.e = bVar;
        this.f = aVar;
        this.c = bVar.c();
        a(view);
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        b bVar;
        if (view != null && (bVar = this.e) != null) {
            bVar.a(view);
        }
    }

    public void a(View view, com.a.a.a.a.b.g gVar) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(view, gVar, (String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5) {
        /*
            r4 = this;
            com.a.a.a.a.b.b r0 = r4.e
            if (r0 == 0) goto L_0x0077
            com.a.a.a.a.b.a r0 = r4.f
            if (r0 != 0) goto L_0x000a
            goto L_0x0077
        L_0x000a:
            boolean r0 = com.bytedance.sdk.openadsdk.core.f.e.c()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0072
            if (r5 == r2) goto L_0x0061
            r0 = 2
            if (r5 == r0) goto L_0x003f
            r3 = 3
            if (r5 == r3) goto L_0x002c
            r0 = 4
            if (r5 == r0) goto L_0x001e
            goto L_0x0072
        L_0x001e:
            int r3 = r4.b
            if (r3 == 0) goto L_0x0072
            if (r3 == r0) goto L_0x0072
            com.a.a.a.a.b.b r0 = r4.e
            r0.b()
            r4.a = r1
            goto L_0x0073
        L_0x002c:
            boolean r3 = r4.g
            if (r3 == 0) goto L_0x0031
            goto L_0x0072
        L_0x0031:
            int r3 = r4.b
            if (r3 == r2) goto L_0x0037
            if (r3 != r0) goto L_0x0072
        L_0x0037:
            com.a.a.a.a.b.a r0 = r4.f
            r0.a()
            r4.g = r2
            goto L_0x0073
        L_0x003f:
            int r0 = r4.b
            if (r0 != 0) goto L_0x0072
            com.a.a.a.a.b.b r0 = r4.e
            r0.a()
            com.a.a.a.a.b.a.e r0 = r4.d
            if (r0 != 0) goto L_0x0054
            com.a.a.a.a.b.a.d r0 = com.a.a.a.a.b.a.d.STANDALONE
            com.a.a.a.a.b.a.e r0 = com.a.a.a.a.b.a.e.a(r2, r0)
            r4.d = r0
        L_0x0054:
            com.a.a.a.a.b.a r0 = r4.f
            com.a.a.a.a.b.a.e r1 = r4.d
            r0.a((com.a.a.a.a.b.a.e) r1)
            r4.a = r2
            r0 = 0
            r4.d = r0
            goto L_0x0073
        L_0x0061:
            int r0 = r4.b
            if (r0 != 0) goto L_0x0072
            com.a.a.a.a.b.b r0 = r4.e
            r0.a()
            com.a.a.a.a.b.a r0 = r4.f
            r0.b()
            r4.a = r2
            goto L_0x0073
        L_0x0072:
            r2 = r1
        L_0x0073:
            if (r2 == 0) goto L_0x0077
            r4.b = r5
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.g.a(int):void");
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a(1);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a(4);
    }

    public void d() {
        a(3);
    }

    public void a(Set<Pair<View, com.a.a.a.a.b.g>> set) {
        for (Pair next : set) {
            a((View) next.first, (com.a.a.a.a.b.g) next.second);
        }
    }
}
