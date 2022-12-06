package com.meizu.cloud.pushsdk.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.meizu.cloud.pushsdk.a.a.b;
import com.meizu.cloud.pushsdk.a.d.b;
import com.meizu.cloud.pushsdk.a.d.c;
import com.meizu.cloud.pushsdk.a.d.f;
import com.meizu.cloud.pushsdk.a.d.g;
import com.meizu.cloud.pushsdk.a.d.h;
import com.meizu.cloud.pushsdk.a.e.d;
import com.meizu.cloud.pushsdk.a.e.e;
import com.meizu.cloud.pushsdk.a.e.f;
import com.meizu.cloud.pushsdk.a.e.h;
import com.meizu.cloud.pushsdk.a.e.i;
import com.meizu.cloud.pushsdk.a.e.j;
import com.meizu.cloud.pushsdk.a.e.k;
import com.meizu.cloud.pushsdk.a.e.l;
import com.meizu.cloud.pushsdk.a.e.m;
import com.meizu.cloud.pushsdk.a.e.n;
import com.meizu.cloud.pushsdk.a.e.o;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

public class b<T extends b> {
    private static final String a = "b";
    private static final g w = g.a("application/json; charset=utf-8");
    private static final g x = g.a("text/x-markdown; charset=utf-8");
    private static final Object z = new Object();
    private Future A;
    private com.meizu.cloud.pushsdk.a.d.a B;
    /* access modifiers changed from: private */
    public int C;
    /* access modifiers changed from: private */
    public boolean D;
    private boolean E;
    private int F;
    private e G;
    private f H;
    private n I;
    /* access modifiers changed from: private */
    public l J;
    private com.meizu.cloud.pushsdk.a.e.b K;
    private m L;
    private i M;
    private h N;
    private k O;
    private com.meizu.cloud.pushsdk.a.e.g P;
    private j Q;
    private d R;
    /* access modifiers changed from: private */
    public o S;
    /* access modifiers changed from: private */
    public com.meizu.cloud.pushsdk.a.e.c T;
    private com.meizu.cloud.pushsdk.a.e.a U;
    private Bitmap.Config V;
    private int W;
    private int X;
    private ImageView.ScaleType Y;
    private Executor Z;
    private String aa;
    private Type ab;
    private int b;
    private d c;
    private int d;
    private String e;
    private int f;
    private Object g;
    private e h;
    private HashMap<String, String> i;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private HashMap<String, String> l;
    private HashMap<String, String> m;
    private HashMap<String, String> n;
    private HashMap<String, File> o;
    private String p;
    private String q;
    private JSONObject r;
    private JSONArray s;
    private String t;
    private byte[] u;
    private File v;
    private g y;

    public b(C0040b bVar) {
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.F = 0;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.d = 0;
        this.b = bVar.b;
        this.c = bVar.a;
        this.e = bVar.c;
        this.g = bVar.d;
        this.i = bVar.i;
        this.V = bVar.e;
        this.X = bVar.g;
        this.W = bVar.f;
        this.Y = bVar.h;
        this.m = bVar.j;
        this.n = bVar.k;
        this.Z = bVar.l;
        this.aa = bVar.m;
    }

    public b(c cVar) {
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.F = 0;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.d = 0;
        this.b = cVar.b;
        this.c = cVar.a;
        this.e = cVar.c;
        this.g = cVar.d;
        this.i = cVar.j;
        this.j = cVar.k;
        this.k = cVar.l;
        this.m = cVar.m;
        this.n = cVar.n;
        this.r = cVar.e;
        this.s = cVar.f;
        this.t = cVar.g;
        this.v = cVar.i;
        this.u = cVar.h;
        this.Z = cVar.o;
        this.aa = cVar.p;
        if (cVar.q != null) {
            this.y = g.a(cVar.q);
        }
    }

    public b(a aVar) {
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.F = 0;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.d = 1;
        this.b = 0;
        this.c = aVar.a;
        this.e = aVar.b;
        this.g = aVar.c;
        this.p = aVar.g;
        this.q = aVar.h;
        this.i = aVar.d;
        this.m = aVar.e;
        this.n = aVar.f;
        this.F = aVar.i;
        this.Z = aVar.j;
        this.aa = aVar.k;
    }

    public void a(k kVar) {
        this.h = e.STRING;
        this.O = kVar;
        com.meizu.cloud.pushsdk.a.f.a.a().a(this);
    }

    public c a() {
        this.h = e.BITMAP;
        return com.meizu.cloud.pushsdk.a.f.e.a(this);
    }

    public c b() {
        return com.meizu.cloud.pushsdk.a.f.e.a(this);
    }

    public int c() {
        return this.b;
    }

    public d d() {
        return this.c;
    }

    public String e() {
        String str = this.e;
        for (Map.Entry next : this.n.entrySet()) {
            str = str.replace("{" + ((String) next.getKey()) + "}", String.valueOf(next.getValue()));
        }
        f.a g2 = com.meizu.cloud.pushsdk.a.d.f.c(str).g();
        for (Map.Entry next2 : this.m.entrySet()) {
            g2.a((String) next2.getKey(), (String) next2.getValue());
        }
        return g2.b().toString();
    }

    public int f() {
        return this.f;
    }

    public void a(int i2) {
        this.f = i2;
    }

    public e g() {
        return this.h;
    }

    public int h() {
        return this.d;
    }

    public void a(String str) {
        this.aa = str;
    }

    public String i() {
        return this.aa;
    }

    public void j() {
        this.E = true;
        if (this.T == null) {
            a.a("Prefetch done : " + toString());
            p();
        } else if (!this.D) {
            Executor executor = this.Z;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (b.this.T != null) {
                            b.this.T.a();
                        }
                        a.a("Delivering success : " + toString());
                        b.this.p();
                    }
                });
            } else {
                com.meizu.cloud.pushsdk.a.b.b.a().b().c().execute(new Runnable() {
                    public void run() {
                        if (b.this.T != null) {
                            b.this.T.a();
                        }
                        a.a("Delivering success : " + toString());
                        b.this.p();
                    }
                });
            }
        } else {
            b(new com.meizu.cloud.pushsdk.a.c.a());
            p();
        }
    }

    public o k() {
        return new o() {
            public void a(long j, long j2) {
                int unused = b.this.C = (int) ((100 * j) / j2);
                if (b.this.S != null && !b.this.D) {
                    b.this.S.a(j, j2);
                }
            }
        };
    }

    public String l() {
        return this.p;
    }

    public String m() {
        return this.q;
    }

    public com.meizu.cloud.pushsdk.a.d.a n() {
        return this.B;
    }

    public void a(com.meizu.cloud.pushsdk.a.d.a aVar) {
        this.B = aVar;
    }

    public void a(Future future) {
        this.A = future;
    }

    public void o() {
        this.G = null;
        this.G = null;
        this.I = null;
        this.K = null;
        this.L = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
    }

    public void p() {
        o();
        com.meizu.cloud.pushsdk.a.f.a.a().b(this);
    }

    /* renamed from: com.meizu.cloud.pushsdk.a.a.b$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] a = new int[e.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.meizu.cloud.pushsdk.a.a.e[] r0 = com.meizu.cloud.pushsdk.a.a.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.meizu.cloud.pushsdk.a.a.e r1 = com.meizu.cloud.pushsdk.a.a.e.JSON_ARRAY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.meizu.cloud.pushsdk.a.a.e r1 = com.meizu.cloud.pushsdk.a.a.e.JSON_OBJECT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.meizu.cloud.pushsdk.a.a.e r1 = com.meizu.cloud.pushsdk.a.a.e.STRING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.meizu.cloud.pushsdk.a.a.e r1 = com.meizu.cloud.pushsdk.a.a.e.BITMAP     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.meizu.cloud.pushsdk.a.a.e r1 = com.meizu.cloud.pushsdk.a.a.e.PREFETCH     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.a.a.b.AnonymousClass8.<clinit>():void");
        }
    }

    public c a(com.meizu.cloud.pushsdk.a.d.k kVar) {
        c<Bitmap> a2;
        int i2 = AnonymousClass8.a[this.h.ordinal()];
        if (i2 == 1) {
            try {
                return c.a(new JSONArray(com.meizu.cloud.pushsdk.a.h.f.a((com.meizu.cloud.pushsdk.a.h.l) kVar.b().a()).h()));
            } catch (Exception e2) {
                return c.a(com.meizu.cloud.pushsdk.a.i.b.b(new com.meizu.cloud.pushsdk.a.c.a((Throwable) e2)));
            }
        } else if (i2 == 2) {
            try {
                return c.a(new JSONObject(com.meizu.cloud.pushsdk.a.h.f.a((com.meizu.cloud.pushsdk.a.h.l) kVar.b().a()).h()));
            } catch (Exception e3) {
                return c.a(com.meizu.cloud.pushsdk.a.i.b.b(new com.meizu.cloud.pushsdk.a.c.a((Throwable) e3)));
            }
        } else if (i2 == 3) {
            try {
                return c.a(com.meizu.cloud.pushsdk.a.h.f.a((com.meizu.cloud.pushsdk.a.h.l) kVar.b().a()).h());
            } catch (Exception e4) {
                return c.a(com.meizu.cloud.pushsdk.a.i.b.b(new com.meizu.cloud.pushsdk.a.c.a((Throwable) e4)));
            }
        } else if (i2 == 4) {
            synchronized (z) {
                try {
                    a2 = com.meizu.cloud.pushsdk.a.i.b.a(kVar, this.W, this.X, this.V, this.Y);
                } catch (Exception e5) {
                    return c.a(com.meizu.cloud.pushsdk.a.i.b.b(new com.meizu.cloud.pushsdk.a.c.a((Throwable) e5)));
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a2;
        } else if (i2 != 5) {
            return null;
        } else {
            return c.a("prefetch");
        }
    }

    public com.meizu.cloud.pushsdk.a.c.a a(com.meizu.cloud.pushsdk.a.c.a aVar) {
        try {
            if (!(aVar.a() == null || aVar.a().b() == null || aVar.a().b().a() == null)) {
                aVar.b(com.meizu.cloud.pushsdk.a.h.f.a((com.meizu.cloud.pushsdk.a.h.l) aVar.a().b().a()).h());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public synchronized void b(com.meizu.cloud.pushsdk.a.c.a aVar) {
        try {
            if (!this.E) {
                if (this.D) {
                    aVar.d();
                    aVar.a(0);
                }
                c(aVar);
                a.a("Delivering anError : " + toString());
            }
            this.E = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return;
    }

    public void a(final c cVar) {
        try {
            this.E = true;
            if (!this.D) {
                if (this.Z != null) {
                    this.Z.execute(new Runnable() {
                        public void run() {
                            b.this.b(cVar);
                        }
                    });
                } else {
                    com.meizu.cloud.pushsdk.a.b.b.a().b().c().execute(new Runnable() {
                        public void run() {
                            b.this.b(cVar);
                        }
                    });
                }
                a.a("Delivering success : " + toString());
                return;
            }
            com.meizu.cloud.pushsdk.a.c.a aVar = new com.meizu.cloud.pushsdk.a.c.a();
            aVar.d();
            aVar.a(0);
            c(aVar);
            p();
            a.a("Delivering cancelled : " + toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        com.meizu.cloud.pushsdk.a.e.f fVar = this.H;
        if (fVar != null) {
            fVar.a((JSONObject) cVar.a());
        } else {
            e eVar = this.G;
            if (eVar != null) {
                eVar.a((JSONArray) cVar.a());
            } else {
                n nVar = this.I;
                if (nVar != null) {
                    nVar.a((String) cVar.a());
                } else {
                    com.meizu.cloud.pushsdk.a.e.b bVar = this.K;
                    if (bVar != null) {
                        bVar.a((Bitmap) cVar.a());
                    } else {
                        m mVar = this.L;
                        if (mVar != null) {
                            mVar.a(cVar.a());
                        } else {
                            i iVar = this.M;
                            if (iVar != null) {
                                iVar.a(cVar.d(), (JSONObject) cVar.a());
                            } else {
                                h hVar = this.N;
                                if (hVar != null) {
                                    hVar.a(cVar.d(), (JSONArray) cVar.a());
                                } else {
                                    k kVar = this.O;
                                    if (kVar != null) {
                                        kVar.a(cVar.d(), (String) cVar.a());
                                    } else {
                                        com.meizu.cloud.pushsdk.a.e.g gVar = this.P;
                                        if (gVar != null) {
                                            gVar.a(cVar.d(), (Bitmap) cVar.a());
                                        } else {
                                            j jVar = this.Q;
                                            if (jVar != null) {
                                                jVar.a(cVar.d(), cVar.a());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        p();
    }

    private void c(com.meizu.cloud.pushsdk.a.c.a aVar) {
        com.meizu.cloud.pushsdk.a.e.f fVar = this.H;
        if (fVar != null) {
            fVar.a(aVar);
            return;
        }
        e eVar = this.G;
        if (eVar != null) {
            eVar.a(aVar);
            return;
        }
        n nVar = this.I;
        if (nVar != null) {
            nVar.a(aVar);
            return;
        }
        com.meizu.cloud.pushsdk.a.e.b bVar = this.K;
        if (bVar != null) {
            bVar.a(aVar);
            return;
        }
        m mVar = this.L;
        if (mVar != null) {
            mVar.a(aVar);
            return;
        }
        i iVar = this.M;
        if (iVar != null) {
            iVar.a(aVar);
            return;
        }
        h hVar = this.N;
        if (hVar != null) {
            hVar.a(aVar);
            return;
        }
        k kVar = this.O;
        if (kVar != null) {
            kVar.a(aVar);
            return;
        }
        com.meizu.cloud.pushsdk.a.e.g gVar = this.P;
        if (gVar != null) {
            gVar.a(aVar);
            return;
        }
        j jVar = this.Q;
        if (jVar != null) {
            jVar.a(aVar);
            return;
        }
        com.meizu.cloud.pushsdk.a.e.c cVar = this.T;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void b(final com.meizu.cloud.pushsdk.a.d.k kVar) {
        try {
            this.E = true;
            if (!this.D) {
                if (this.Z != null) {
                    this.Z.execute(new Runnable() {
                        public void run() {
                            if (b.this.J != null) {
                                b.this.J.a(kVar);
                            }
                            b.this.p();
                        }
                    });
                } else {
                    com.meizu.cloud.pushsdk.a.b.b.a().b().c().execute(new Runnable() {
                        public void run() {
                            if (b.this.J != null) {
                                b.this.J.a(kVar);
                            }
                            b.this.p();
                        }
                    });
                }
                a.a("Delivering success : " + toString());
                return;
            }
            com.meizu.cloud.pushsdk.a.c.a aVar = new com.meizu.cloud.pushsdk.a.c.a();
            aVar.d();
            aVar.a(0);
            if (this.J != null) {
                this.J.a(aVar);
            }
            p();
            a.a("Delivering cancelled : " + toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public com.meizu.cloud.pushsdk.a.d.j q() {
        JSONObject jSONObject = this.r;
        if (jSONObject != null) {
            g gVar = this.y;
            if (gVar != null) {
                return com.meizu.cloud.pushsdk.a.d.j.a(gVar, jSONObject.toString());
            }
            return com.meizu.cloud.pushsdk.a.d.j.a(w, jSONObject.toString());
        }
        JSONArray jSONArray = this.s;
        if (jSONArray != null) {
            g gVar2 = this.y;
            if (gVar2 != null) {
                return com.meizu.cloud.pushsdk.a.d.j.a(gVar2, jSONArray.toString());
            }
            return com.meizu.cloud.pushsdk.a.d.j.a(w, jSONArray.toString());
        }
        String str = this.t;
        if (str != null) {
            g gVar3 = this.y;
            if (gVar3 != null) {
                return com.meizu.cloud.pushsdk.a.d.j.a(gVar3, str);
            }
            return com.meizu.cloud.pushsdk.a.d.j.a(x, str);
        }
        File file = this.v;
        if (file != null) {
            g gVar4 = this.y;
            if (gVar4 != null) {
                return com.meizu.cloud.pushsdk.a.d.j.a(gVar4, file);
            }
            return com.meizu.cloud.pushsdk.a.d.j.a(x, file);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            g gVar5 = this.y;
            if (gVar5 != null) {
                return com.meizu.cloud.pushsdk.a.d.j.a(gVar5, bArr);
            }
            return com.meizu.cloud.pushsdk.a.d.j.a(x, bArr);
        }
        b.a aVar = new b.a();
        try {
            for (Map.Entry next : this.j.entrySet()) {
                aVar.a((String) next.getKey(), (String) next.getValue());
            }
            for (Map.Entry next2 : this.k.entrySet()) {
                aVar.b((String) next2.getKey(), (String) next2.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public com.meizu.cloud.pushsdk.a.d.j r() {
        h.a a2 = new h.a().a(com.meizu.cloud.pushsdk.a.d.h.e);
        try {
            for (Map.Entry next : this.l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.a.d.c.a(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + ((String) next.getKey()) + "\""), com.meizu.cloud.pushsdk.a.d.j.a((g) null, (String) next.getValue()));
            }
            for (Map.Entry next2 : this.o.entrySet()) {
                String name = ((File) next2.getValue()).getName();
                com.meizu.cloud.pushsdk.a.d.j a3 = com.meizu.cloud.pushsdk.a.d.j.a(g.a(com.meizu.cloud.pushsdk.a.i.b.a(name)), (File) next2.getValue());
                a2.a(com.meizu.cloud.pushsdk.a.d.c.a(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + ((String) next2.getKey()) + "\"; filename=\"" + name + "\""), a3);
                if (this.y != null) {
                    a2.a(this.y);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.a.d.c s() {
        c.a aVar = new c.a();
        try {
            for (Map.Entry next : this.i.entrySet()) {
                aVar.a((String) next.getKey(), (String) next.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    /* renamed from: com.meizu.cloud.pushsdk.a.a.b$b  reason: collision with other inner class name */
    public static class C0040b<T extends C0040b> {
        /* access modifiers changed from: private */
        public d a = d.MEDIUM;
        /* access modifiers changed from: private */
        public int b = 0;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public Object d;
        /* access modifiers changed from: private */
        public Bitmap.Config e;
        /* access modifiers changed from: private */
        public int f;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */
        public ImageView.ScaleType h;
        /* access modifiers changed from: private */
        public HashMap<String, String> i = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> j = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> k = new HashMap<>();
        /* access modifiers changed from: private */
        public Executor l;
        /* access modifiers changed from: private */
        public String m;

        public C0040b(String str) {
            this.c = str;
            this.b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.j.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public static class c<T extends c> {
        /* access modifiers changed from: private */
        public d a = d.MEDIUM;
        /* access modifiers changed from: private */
        public int b = 1;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public Object d;
        /* access modifiers changed from: private */
        public JSONObject e = null;
        /* access modifiers changed from: private */
        public JSONArray f = null;
        /* access modifiers changed from: private */
        public String g = null;
        /* access modifiers changed from: private */
        public byte[] h = null;
        /* access modifiers changed from: private */
        public File i = null;
        /* access modifiers changed from: private */
        public HashMap<String, String> j = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> k = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> l = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> m = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> n = new HashMap<>();
        /* access modifiers changed from: private */
        public Executor o;
        /* access modifiers changed from: private */
        public String p;
        /* access modifiers changed from: private */
        public String q;

        public c(String str) {
            this.c = str;
            this.b = 1;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    this.k.put(next.getKey(), next.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public static class a<T extends a> {
        /* access modifiers changed from: private */
        public d a = d.MEDIUM;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public Object c;
        /* access modifiers changed from: private */
        public HashMap<String, String> d = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> e = new HashMap<>();
        /* access modifiers changed from: private */
        public HashMap<String, String> f = new HashMap<>();
        /* access modifiers changed from: private */
        public String g;
        /* access modifiers changed from: private */
        public String h;
        /* access modifiers changed from: private */
        public int i = 0;
        /* access modifiers changed from: private */
        public Executor j;
        /* access modifiers changed from: private */
        public String k;

        public a(String str, String str2, String str3) {
            this.b = str;
            this.g = str2;
            this.h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f + ", mMethod=" + this.b + ", mPriority=" + this.c + ", mRequestType=" + this.d + ", mUrl=" + this.e + '}';
    }
}
