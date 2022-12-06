package com.bytedance.sdk.component.d.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.b;
import com.bytedance.sdk.component.d.c;
import com.bytedance.sdk.component.d.c.a.a;
import com.bytedance.sdk.component.d.c.a.b.e;
import com.bytedance.sdk.component.d.d;
import com.bytedance.sdk.component.d.l;
import com.bytedance.sdk.component.d.m;
import com.bytedance.sdk.component.d.p;
import com.bytedance.sdk.component.d.q;
import com.bytedance.sdk.component.d.r;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: LoadFactory */
public class f {
    private Map<String, List<c>> a = new ConcurrentHashMap();
    private final m b;
    private Map<String, q> c = new HashMap();
    private Map<String, r> d = new HashMap();
    private Map<String, c> e = new HashMap();
    private d f;
    private l g;
    private ExecutorService h;
    private p i;

    public f(Context context, m mVar) {
        this.b = (m) h.a(mVar);
        a.a(context, mVar.h());
    }

    private q d(b bVar) {
        q d2 = this.b.d();
        return d2 != null ? com.bytedance.sdk.component.d.c.a.b.a.a(d2) : com.bytedance.sdk.component.d.c.a.b.a.a(bVar.b());
    }

    private r e(b bVar) {
        r e2 = this.b.e();
        return e2 != null ? e2 : e.a(bVar.b());
    }

    private c f(b bVar) {
        c f2 = this.b.f();
        return f2 != null ? f2 : new com.bytedance.sdk.component.d.c.a.a.b(bVar.e(), bVar.a(), e());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r4 = r4.toCharArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r2 >= r4.length) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r4[r2] = (char) (r4[r2] ^ r2);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return new java.lang.String(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = 'J';
        r1 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        switch(r1) {
            case 55: goto L_0x0039;
            case 56: goto L_0x004f;
            case 57: goto L_0x0010;
            default: goto L_0x000f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        switch(1) {
            case 60: goto L_0x0017;
            case 61: goto L_0x0023;
            case 62: goto L_0x0030;
            default: goto L_0x0016;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f1667305730962dc(java.lang.String r4) {
        /*
        L_0x0000:
            r0 = 73
            r1 = 96
        L_0x0004:
            r2 = 0
            switch(r0) {
                case 72: goto L_0x004f;
                case 73: goto L_0x0009;
                case 74: goto L_0x000c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0054
        L_0x0009:
            switch(r1) {
                case 94: goto L_0x0000;
                case 95: goto L_0x0010;
                case 96: goto L_0x004f;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r1) {
                case 55: goto L_0x0039;
                case 56: goto L_0x004f;
                case 57: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0000
        L_0x0010:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0017;
                case 61: goto L_0x0023;
                case 62: goto L_0x0030;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x004f
        L_0x0017:
            int r3 = 0 - r1
            int r3 = r3 * r2
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0000
        L_0x0023:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x004f
        L_0x0030:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L_0x0000
        L_0x0039:
            char[] r4 = r4.toCharArray()
        L_0x003d:
            int r0 = r4.length
            if (r2 >= r0) goto L_0x0049
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0049:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L_0x004f:
            r0 = 74
            r1 = 55
            goto L_0x0004
        L_0x0054:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.f.f1667305730962dc(java.lang.String):java.lang.String");
    }

    private d h() {
        d c2 = this.b.c();
        return c2 == null ? com.bytedance.sdk.component.d.b.b.a() : c2;
    }

    private l i() {
        l a2 = this.b.a();
        return a2 != null ? a2 : com.bytedance.sdk.component.d.a.b.a();
    }

    private ExecutorService j() {
        ExecutorService b2 = this.b.b();
        return b2 != null ? b2 : com.bytedance.sdk.component.d.a.c.a();
    }

    private p k() {
        p g2 = this.b.g();
        return g2 == null ? new g() : g2;
    }

    public com.bytedance.sdk.component.d.c.b.a a(c cVar) {
        ImageView.ScaleType d2 = cVar.d();
        if (d2 == null) {
            d2 = com.bytedance.sdk.component.d.c.b.a.a;
        }
        ImageView.ScaleType scaleType = d2;
        Bitmap.Config j = cVar.j();
        if (j == null) {
            j = com.bytedance.sdk.component.d.c.b.a.b;
        }
        return new com.bytedance.sdk.component.d.c.b.a(cVar.b(), cVar.c(), scaleType, j, cVar.f(), cVar.g());
    }

    public c a(String str) {
        return c(a.a(new File(str)));
    }

    public q a(b bVar) {
        if (bVar == null) {
            bVar = a.f();
        }
        String file = bVar.e().toString();
        q qVar = this.c.get(file);
        if (qVar != null) {
            return qVar;
        }
        q d2 = d(bVar);
        this.c.put(file, d2);
        return d2;
    }

    public Collection<r> a() {
        return this.d.values();
    }

    public r b(b bVar) {
        if (bVar == null) {
            bVar = a.f();
        }
        String file = bVar.e().toString();
        r rVar = this.d.get(file);
        if (rVar != null) {
            return rVar;
        }
        r e2 = e(bVar);
        this.d.put(file, e2);
        return e2;
    }

    public Collection<c> b() {
        return this.e.values();
    }

    public c c(b bVar) {
        if (bVar == null) {
            bVar = a.f();
        }
        String file = bVar.e().toString();
        c cVar = this.e.get(file);
        if (cVar != null) {
            return cVar;
        }
        c f2 = f(bVar);
        this.e.put(file, f2);
        return f2;
    }

    public d c() {
        if (this.f == null) {
            this.f = h();
        }
        return this.f;
    }

    public l d() {
        if (this.g == null) {
            this.g = i();
        }
        return this.g;
    }

    public ExecutorService e() {
        if (this.h == null) {
            this.h = j();
        }
        return this.h;
    }

    public Map<String, List<c>> f() {
        return this.a;
    }

    public p g() {
        if (this.i == null) {
            this.i = k();
        }
        return this.i;
    }
}
