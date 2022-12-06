package com.bytedance.sdk.component.d.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.i;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.s;
import com.bytedance.sdk.component.d.t;
import com.bytedance.sdk.component.d.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ImageRequest */
public class c implements i {
    private int A;
    Future<?> a;
    private String b;
    /* access modifiers changed from: private */
    public String c;
    private String d;
    private o e;
    private ImageView.ScaleType f;
    private Bitmap.Config g;
    private int h;
    private int i;
    /* access modifiers changed from: private */
    public h j;
    /* access modifiers changed from: private */
    public u k;
    /* access modifiers changed from: private */
    public WeakReference<ImageView> l;
    /* access modifiers changed from: private */
    public volatile boolean m;
    private boolean n;
    private boolean o;
    /* access modifiers changed from: private */
    public s p;
    /* access modifiers changed from: private */
    public t q;
    /* access modifiers changed from: private */
    public Queue<com.bytedance.sdk.component.d.d.i> r;
    /* access modifiers changed from: private */
    public final Handler s;
    private boolean t;
    private g u;
    private int v;
    private f w;
    private a x;
    private com.bytedance.sdk.component.d.b y;
    private int z;

    /* compiled from: ImageRequest */
    public static class b implements j {
        /* access modifiers changed from: private */
        public o a;
        /* access modifiers changed from: private */
        public ImageView b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public ImageView.ScaleType e;
        /* access modifiers changed from: private */
        public Bitmap.Config f;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */
        public int h;
        /* access modifiers changed from: private */
        public u i;
        /* access modifiers changed from: private */
        public t j;
        /* access modifiers changed from: private */
        public s k;
        /* access modifiers changed from: private */
        public boolean l;
        /* access modifiers changed from: private */
        public boolean m;
        /* access modifiers changed from: private */
        public String n;
        /* access modifiers changed from: private */
        public com.bytedance.sdk.component.d.b o;
        /* access modifiers changed from: private */
        public f p;
        /* access modifiers changed from: private */
        public h q;
        /* access modifiers changed from: private */
        public int r;
        /* access modifiers changed from: private */
        public int s;

        public b(f fVar) {
            this.p = fVar;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
            r0 = 'I';
            r1 = '`';
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            switch(r1) {
                case 55: goto L_0x004f;
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
        public static java.lang.String c$b1667305730972dc(java.lang.String r4) {
            /*
            L_0x0000:
                r0 = 74
                r1 = 55
            L_0x0004:
                r2 = 0
                switch(r0) {
                    case 72: goto L_0x0000;
                    case 73: goto L_0x0009;
                    case 74: goto L_0x000c;
                    default: goto L_0x0008;
                }
            L_0x0008:
                goto L_0x0054
            L_0x0009:
                switch(r1) {
                    case 94: goto L_0x004f;
                    case 95: goto L_0x0010;
                    case 96: goto L_0x0039;
                    default: goto L_0x000c;
                }
            L_0x000c:
                switch(r1) {
                    case 55: goto L_0x004f;
                    case 56: goto L_0x004f;
                    case 57: goto L_0x0010;
                    default: goto L_0x000f;
                }
            L_0x000f:
                goto L_0x004f
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
                goto L_0x0039
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
                r0 = 73
                r1 = 96
                goto L_0x0004
            L_0x0054:
                r0 = 72
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(java.lang.String):java.lang.String");
        }

        public i a(ImageView imageView) {
            this.b = imageView;
            return new c(this).u();
        }

        public i a(o oVar) {
            this.a = oVar;
            return new c(this).u();
        }

        public j a(int i2) {
            this.g = i2;
            return this;
        }

        public j a(Bitmap.Config config) {
            this.f = config;
            return this;
        }

        public j a(ImageView.ScaleType scaleType) {
            this.e = scaleType;
            return this;
        }

        public j a(h hVar) {
            this.q = hVar;
            return this;
        }

        public j a(s sVar) {
            this.k = sVar;
            return this;
        }

        public j a(u uVar) {
            this.i = uVar;
            return this;
        }

        public j a(String str) {
            this.c = str;
            return this;
        }

        public j a(boolean z) {
            this.m = z;
            return this;
        }

        public j b(int i2) {
            this.h = i2;
            return this;
        }

        public j b(String str) {
            this.n = str;
            return this;
        }

        public j c(int i2) {
            this.r = i2;
            return this;
        }

        public j c(String str) {
            this.d = str;
            return this;
        }

        public j d(int i2) {
            this.s = i2;
            return this;
        }
    }

    private c(b bVar) {
        this.r = new LinkedBlockingQueue();
        this.s = new Handler(Looper.getMainLooper());
        this.t = true;
        this.b = bVar.d;
        this.e = new a(bVar.a);
        this.l = new WeakReference<>(bVar.b);
        this.f = bVar.e;
        this.g = bVar.f;
        this.h = bVar.g;
        this.i = bVar.h;
        this.k = bVar.i == null ? u.AUTO : bVar.i;
        this.q = bVar.j == null ? t.MAIN : bVar.j;
        this.p = bVar.k;
        this.y = a(bVar);
        if (!TextUtils.isEmpty(bVar.c)) {
            b(bVar.c);
            a(bVar.c);
        }
        this.n = bVar.l;
        this.o = bVar.m;
        this.w = bVar.p;
        this.j = bVar.q;
        this.A = bVar.s;
        this.z = bVar.r;
        this.r.add(new com.bytedance.sdk.component.d.d.c());
    }

    private com.bytedance.sdk.component.d.b a(b bVar) {
        return bVar.o != null ? bVar.o : !TextUtils.isEmpty(bVar.n) ? com.bytedance.sdk.component.d.c.a.a.a(new File(bVar.n)) : com.bytedance.sdk.component.d.c.a.a.f();
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, Throwable th) {
        new com.bytedance.sdk.component.d.d.h(i2, str, th).a(this);
        this.r.clear();
    }

    /* access modifiers changed from: private */
    public i u() {
        try {
            if (this.w == null) {
                if (this.e != null) {
                    this.e.a(1005, "not init !", (Throwable) null);
                }
                return this;
            }
            ExecutorService e2 = this.w.e();
            if (e2 != null) {
                this.a = e2.submit(new Runnable() {
                    public void run() {
                        while (true) {
                            try {
                                if (c.this.m) {
                                    break;
                                }
                                com.bytedance.sdk.component.d.d.i iVar = (com.bytedance.sdk.component.d.d.i) c.this.r.poll();
                                if (iVar == null) {
                                    break;
                                }
                                if (c.this.p != null) {
                                    c.this.p.a(iVar.a(), c.this);
                                }
                                iVar.a(c.this);
                                if (c.this.p != null) {
                                    c.this.p.b(iVar.a(), c.this);
                                }
                            } catch (Throwable th) {
                                c.this.a(2000, th.getMessage(), th);
                                if (c.this.p != null) {
                                    c.this.p.b("exception", c.this);
                                    return;
                                }
                                return;
                            }
                        }
                        if (c.this.m) {
                            c.this.a(1003, "canceled", (Throwable) null);
                        }
                    }
                });
            }
            return this;
        } catch (Exception e3) {
            Log.e("ImageRequest", e3.getMessage());
        }
    }

    public String a() {
        return this.b;
    }

    public void a(int i2) {
        this.v = i2;
    }

    public void a(a aVar) {
        this.x = aVar;
    }

    public void a(g gVar) {
        this.u = gVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(boolean z2) {
        this.t = z2;
    }

    public boolean a(com.bytedance.sdk.component.d.d.i iVar) {
        if (this.m) {
            return false;
        }
        return this.r.add(iVar);
    }

    public int b() {
        return this.h;
    }

    public void b(String str) {
        WeakReference<ImageView> weakReference = this.l;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((ImageView) this.l.get()).setTag(1094453505, str);
        }
        this.c = str;
    }

    public int c() {
        return this.i;
    }

    public ImageView.ScaleType d() {
        return this.f;
    }

    public String e() {
        return this.c;
    }

    public int f() {
        return this.z;
    }

    public int g() {
        return this.A;
    }

    public o h() {
        return this.e;
    }

    public String i() {
        return this.d;
    }

    public Bitmap.Config j() {
        return this.g;
    }

    public u k() {
        return this.k;
    }

    public boolean l() {
        return this.n;
    }

    public boolean m() {
        return this.o;
    }

    public boolean n() {
        return this.t;
    }

    public g o() {
        return this.u;
    }

    public int p() {
        return this.v;
    }

    public a q() {
        return this.x;
    }

    public f r() {
        return this.w;
    }

    public com.bytedance.sdk.component.d.b s() {
        return this.y;
    }

    public String t() {
        return e() + k();
    }

    /* compiled from: ImageRequest */
    private class a implements o {
        /* access modifiers changed from: private */
        public o b;

        public a(o oVar) {
            this.b = oVar;
        }

        public void a(final k kVar) {
            Bitmap a2;
            final ImageView imageView = (ImageView) c.this.l.get();
            if (imageView != null && c.this.k != u.RAW && a(imageView) && (kVar.b() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) kVar.b();
                c.this.s.post(new Runnable() {
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (!(c.this.j == null || !(kVar.b() instanceof Bitmap) || (a2 = c.this.j.a((Bitmap) kVar.b())) == null)) {
                    kVar.a(a2);
                }
            } catch (Throwable unused) {
            }
            if (c.this.q == t.MAIN) {
                c.this.s.post(new Runnable() {
                    public void run() {
                        if (a.this.b != null) {
                            a.this.b.a(kVar);
                        }
                    }
                });
                return;
            }
            o oVar = this.b;
            if (oVar != null) {
                oVar.a(kVar);
            }
        }

        private boolean a(ImageView imageView) {
            Object tag;
            if (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(c.this.c)) {
                return false;
            }
            return true;
        }

        public void a(final int i, final String str, final Throwable th) {
            if (c.this.q == t.MAIN) {
                c.this.s.post(new Runnable() {
                    public void run() {
                        if (a.this.b != null) {
                            a.this.b.a(i, str, th);
                        }
                    }
                });
                return;
            }
            o oVar = this.b;
            if (oVar != null) {
                oVar.a(i, str, th);
            }
        }
    }
}
