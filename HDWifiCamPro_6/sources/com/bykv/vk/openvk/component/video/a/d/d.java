package com.bykv.vk.openvk.component.video.a.d;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.a.d.c;
import com.bykv.vk.openvk.component.video.api.a;
import com.bykv.vk.openvk.component.video.api.b;
import com.bykv.vk.openvk.component.video.api.f.d;
import com.mbridge.msdk.MBridgeConstans;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SSMediaPlayerWrapper */
public class d implements c.a, c.b, c.C0018c, c.d, c.e, c.f, c.g, com.bykv.vk.openvk.component.video.api.a, d.a {
    private static final SparseIntArray w = new SparseIntArray();
    /* access modifiers changed from: private */
    public boolean A = false;
    /* access modifiers changed from: private */
    public volatile int B = 200;
    private AtomicBoolean C = new AtomicBoolean(false);
    private Surface D = null;
    private final Runnable E = new Runnable() {
        public void run() {
            if (d.this.e != null) {
                long s = d.this.s();
                if (s > 0 && Build.VERSION.SDK_INT >= 23 && d.this.l() && d.this.o != Long.MIN_VALUE) {
                    if (d.this.o == s) {
                        if (!d.this.m && d.this.p >= 400) {
                            d.this.b(701, 800);
                            boolean unused = d.this.m = true;
                        }
                        d dVar = d.this;
                        long unused2 = dVar.p = dVar.p + ((long) d.this.B);
                    } else {
                        if (d.this.m) {
                            d dVar2 = d.this;
                            long unused3 = dVar2.n = dVar2.n + d.this.p;
                            d.this.b(702, 800);
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(d.this.n), "  bufferCount =", Integer.valueOf(d.this.c));
                        }
                        long unused4 = d.this.p = 0;
                        boolean unused5 = d.this.m = false;
                    }
                }
                if (d.this.q() > 0) {
                    if (d.this.o != s) {
                        if (b.e()) {
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(d.this.o), "  curPosition = ", Long.valueOf(s));
                        }
                        d dVar3 = d.this;
                        dVar3.a(s, dVar3.q());
                    }
                    long unused6 = d.this.o = s;
                }
                if (!d.this.h()) {
                    d.this.l.postDelayed(this, (long) d.this.B);
                    return;
                }
                d dVar4 = d.this;
                dVar4.a(dVar4.q(), d.this.q());
            }
        }
    };
    private final a F = new a();
    /* access modifiers changed from: private */
    public boolean G;
    private final Object H = new Object();
    private StringBuilder I = null;
    private long J = 0;
    private long K = 0;
    private boolean L = false;
    private SurfaceTexture a;
    private SurfaceHolder b;
    /* access modifiers changed from: private */
    public int c = 0;
    private boolean d = false;
    /* access modifiers changed from: private */
    public volatile c e = null;
    private final boolean f = false;
    /* access modifiers changed from: private */
    public boolean g = false;
    private boolean h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public volatile int j = 201;
    /* access modifiers changed from: private */
    public long k = -1;
    /* access modifiers changed from: private */
    public final Handler l;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public long n = 0;
    /* access modifiers changed from: private */
    public long o = Long.MIN_VALUE;
    /* access modifiers changed from: private */
    public long p = 0;
    private long q = 0;
    private long r = 0;
    private boolean s;
    private ArrayList<Runnable> t;
    private int u = 0;
    /* access modifiers changed from: private */
    public String v = MBridgeConstans.ENDCARD_URL_TYPE_PL;
    private boolean x;
    /* access modifiers changed from: private */
    public final List<WeakReference<a.C0020a>> y = Collections.synchronizedList(new ArrayList());
    private com.bykv.vk.openvk.component.video.api.c.c z = null;

    /* access modifiers changed from: private */
    public void a(long j2, long j3) {
        for (WeakReference next : this.y) {
            if (!(next == null || next.get() == null)) {
                ((a.C0020a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, j2, j3);
            }
        }
    }

    public d() {
        boolean z2 = false;
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "SSMediaPlayerWrapper() ");
        this.u = 0;
        HandlerThread handlerThread = new HandlerThread("csj_SSMediaPlayerWrapper", -1);
        handlerThread.start();
        this.l = new com.bykv.vk.openvk.component.video.api.f.d(handlerThread.getLooper(), this);
        this.L = Build.VERSION.SDK_INT >= 17 ? true : z2;
        u();
    }

    private void t() {
        this.n = 0;
        this.c = 0;
        this.p = 0;
        this.m = false;
        this.o = Long.MIN_VALUE;
    }

    public void b(final boolean z2) {
        this.x = z2;
        if (this.e != null) {
            this.e.a(z2);
        } else {
            this.l.post(new Runnable() {
                public void run() {
                    if (d.this.e != null) {
                        d.this.e.a(z2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        StringBuilder sb = new StringBuilder();
        sb.append("initMediaPlayer: ");
        sb.append(this.l != null);
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", sb.toString());
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (d.this.e == null) {
                        try {
                            c unused = d.this.e = new b();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (d.this.e != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("initMediaPlayer mMediaPlayer is null :");
                            sb.append(d.this.e == null);
                            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", sb.toString());
                            String unused2 = d.this.v = MBridgeConstans.ENDCARD_URL_TYPE_PL;
                            d.this.e.a((c.e) d.this);
                            d.this.e.a((c.b) d.this);
                            d.this.e.a((c.C0018c) d.this);
                            d.this.e.a((c.a) d.this);
                            d.this.e.a((c.f) d.this);
                            d.this.e.a((c.d) d.this);
                            d.this.e.a((c.g) d.this);
                            try {
                                d.this.e.c(false);
                            } catch (Throwable th2) {
                                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setLooping error: ", th2);
                            }
                            boolean unused3 = d.this.g = false;
                        }
                    }
                }
            });
        }
    }

    public void a(boolean z2, long j2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("[video] MediaPlayerProxy#start firstSeekToPosition=");
        sb.append(j2);
        sb.append(",isFirst :");
        sb.append(z2);
        sb.append(",isPauseOtherMusicVolume=");
        sb.append(z3);
        sb.append(" ");
        sb.append(this.j);
        sb.append(" ");
        sb.append(this.e == null);
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", sb.toString());
        u();
        this.A = z3;
        this.C.set(true);
        this.G = false;
        a(z3);
        if (z2) {
            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] first start , SSMediaPlayer  start method !");
            this.k = j2;
            v();
        } else {
            b(j2);
        }
        this.l.postDelayed(this.E, (long) this.B);
    }

    private void b(long j2) {
        this.F.a(j2);
        if (this.x) {
            b((Runnable) this.F);
        } else if (b(this.z)) {
            b((Runnable) this.F);
        } else {
            a((Runnable) this.F);
        }
    }

    private boolean b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        return cVar != null && cVar.c();
    }

    public void a() {
        if (this.l != null) {
            this.C.set(true);
            this.l.post(new Runnable() {
                public void run() {
                    if (d.this.m() && d.this.e != null) {
                        try {
                            d.this.e.e();
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "resume play exec start ");
                            for (WeakReference weakReference : d.this.y) {
                                if (!(weakReference == null || weakReference.get() == null)) {
                                    ((a.C0020a) weakReference.get()).e(d.this);
                                }
                            }
                            int unused = d.this.j = 206;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                        }
                    }
                }
            });
        }
    }

    /* compiled from: SSMediaPlayerWrapper */
    class a implements Runnable {
        private long b;
        private boolean c;

        a() {
        }

        public void a(long j) {
            this.b = j;
        }

        public void run() {
            if (d.this.e != null) {
                try {
                    if (!this.c) {
                        long unused = d.this.k = Math.max(this.b, d.this.e.i());
                    }
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start, OpStartTask:" + d.this.k);
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th);
                }
            }
            d.this.l.sendEmptyMessageDelayed(100, 0);
            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
        }
    }

    public void b() {
        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "pause: from outer");
        this.l.removeMessages(100);
        this.G = true;
        this.l.sendEmptyMessage(101);
    }

    public void d() {
        this.j = 203;
        B();
        if (this.l != null) {
            try {
                b("release");
                this.l.removeCallbacksAndMessages((Object) null);
                if (this.e != null) {
                    this.i = true;
                    this.l.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                x();
                throw th;
            }
            x();
        }
    }

    private void v() {
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b((Runnable) new Runnable() {
            public void run() {
                if (d.this.l != null) {
                    d.this.l.sendEmptyMessage(104);
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    public void c() {
        b((Runnable) new Runnable() {
            public void run() {
                if (d.this.l != null) {
                    d.this.l.sendEmptyMessage(105);
                }
            }
        });
    }

    public void a(final long j2) {
        if (this.j == 207 || this.j == 206 || this.j == 209) {
            b((Runnable) new Runnable() {
                public void run() {
                    if (d.this.l != null) {
                        d.this.l.obtainMessage(106, Long.valueOf(j2)).sendToTarget();
                    }
                }
            });
        }
    }

    public boolean e() {
        return this.d;
    }

    public void a(final SurfaceTexture surfaceTexture) {
        this.a = surfaceTexture;
        b(true);
        b((Runnable) new Runnable() {
            public void run() {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setSurface() runnable exec");
                d.this.u();
                if (d.this.l != null) {
                    d.this.l.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void a(final SurfaceHolder surfaceHolder) {
        this.b = surfaceHolder;
        b(true);
        b((Runnable) new Runnable() {
            public void run() {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setDisplay() runnable exec");
                d.this.u();
                if (d.this.l != null) {
                    d.this.l.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void a(final com.bykv.vk.openvk.component.video.api.c.c cVar) {
        this.z = cVar;
        if (cVar != null) {
            this.L = this.L && !cVar.c();
        }
        b((Runnable) new Runnable() {
            public void run() {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setDataSource() runnable exec ");
                d.this.u();
                if (d.this.l != null) {
                    d.this.l.obtainMessage(107, cVar).sendToTarget();
                }
            }
        });
    }

    public boolean l() {
        return (this.j == 206 || this.l.hasMessages(100)) && !this.G;
    }

    public boolean i() {
        return r() || l() || m();
    }

    public boolean m() {
        return (this.j == 207 || this.G) && !this.l.hasMessages(100);
    }

    public boolean n() {
        return this.j == 203;
    }

    public boolean r() {
        return this.j == 205;
    }

    public boolean h() {
        return this.j == 209;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01aa, code lost:
        r5 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.os.Message r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            int r2 = r0.what
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[video]  execute , mCurrentState = "
            r3.append(r4)
            int r4 = r1.j
            r3.append(r4)
            java.lang.String r4 = " handlerMsg="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "CSJ_VIDEO_MEDIA"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r3)
            com.bykv.vk.openvk.component.video.a.d.c r3 = r1.e
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0308
            int r3 = r0.what
            r7 = 110(0x6e, float:1.54E-43)
            if (r3 == r7) goto L_0x02eb
            r7 = 111(0x6f, float:1.56E-43)
            if (r3 == r7) goto L_0x02c3
            r7 = 201(0xc9, float:2.82E-43)
            if (r3 == r7) goto L_0x0308
            r8 = 203(0xcb, float:2.84E-43)
            r11 = 202(0xca, float:2.83E-43)
            r12 = 205(0xcd, float:2.87E-43)
            r13 = 208(0xd0, float:2.91E-43)
            r14 = 209(0xd1, float:2.93E-43)
            r15 = 206(0xce, float:2.89E-43)
            r9 = 207(0xcf, float:2.9E-43)
            switch(r3) {
                case 100: goto L_0x026b;
                case 101: goto L_0x0210;
                case 102: goto L_0x01fa;
                case 103: goto L_0x01c1;
                case 104: goto L_0x01a1;
                case 105: goto L_0x017c;
                case 106: goto L_0x0159;
                case 107: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0308
        L_0x004d:
            r16.t()
            int r3 = r1.j
            if (r3 == r7) goto L_0x0058
            int r3 = r1.j
            if (r3 != r8) goto L_0x01aa
        L_0x0058:
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0151 }
            com.bykv.vk.openvk.component.video.api.c.c r0 = (com.bykv.vk.openvk.component.video.api.c.c) r0     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x0151 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0151 }
            if (r3 == 0) goto L_0x006d
            java.lang.String r3 = com.bykv.vk.openvk.component.video.api.b.b()     // Catch:{ all -> 0x0151 }
            r0.a((java.lang.String) r3)     // Catch:{ all -> 0x0151 }
        L_0x006d:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = r0.a()     // Catch:{ all -> 0x0151 }
            java.lang.String r8 = r0.l()     // Catch:{ all -> 0x0151 }
            r3.<init>(r7, r8)     // Catch:{ all -> 0x0151 }
            boolean r7 = r3.exists()     // Catch:{ all -> 0x0151 }
            if (r7 == 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            r0.<init>()     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = "setDataSource： try paly local:"
            r0.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = r3.getAbsolutePath()     // Catch:{ all -> 0x0151 }
            r0.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0151 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0151 }
            boolean r0 = com.bykv.vk.openvk.component.video.api.b.c()     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x00a7
            java.lang.String r0 = r3.getAbsolutePath()     // Catch:{ all -> 0x0151 }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0151 }
            goto L_0x014d
        L_0x00a7:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0151 }
            r0.a((java.lang.String) r3)     // Catch:{ all -> 0x0151 }
            goto L_0x014d
        L_0x00b2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            r3.<init>()     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = "setDataSource： paly net:"
            r3.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = r0.k()     // Catch:{ all -> 0x0151 }
            r3.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0151 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ all -> 0x0151 }
            int r3 = r0.b     // Catch:{ all -> 0x0151 }
            r7 = 23
            if (r3 != r6) goto L_0x00f6
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0151 }
            if (r3 >= r7) goto L_0x00f6
            com.bykv.vk.openvk.component.video.a.d.c r3 = r1.e     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = r0.k()     // Catch:{ all -> 0x0151 }
            r3.a((java.lang.String) r7)     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            r3.<init>()     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = "setDataSource：  url"
            r3.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r0.k()     // Catch:{ all -> 0x0151 }
            r3.append(r0)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0151 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0151 }
            goto L_0x014d
        L_0x00f6:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0151 }
            if (r3 < r7) goto L_0x0118
            com.bykv.vk.openvk.component.video.a.d.c r3 = r1.e     // Catch:{ all -> 0x0151 }
            r3.a((com.bykv.vk.openvk.component.video.api.c.c) r0)     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            r3.<init>()     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = "setDataSource： MediaDataSource url"
            r3.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r0.k()     // Catch:{ all -> 0x0151 }
            r3.append(r0)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0151 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0151 }
            goto L_0x014d
        L_0x0118:
            com.bykv.vk.openvk.component.video.a.b.f.a r3 = com.bykv.vk.openvk.component.video.a.b.f.a.a()     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r3.b(r0)     // Catch:{ all -> 0x0151 }
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = "setDataSource：  local url = "
            r3[r5] = r7     // Catch:{ all -> 0x0151 }
            r3[r6] = r0     // Catch:{ all -> 0x0151 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x0148
            boolean r3 = com.bykv.vk.openvk.component.video.api.b.c()     // Catch:{ all -> 0x0151 }
            if (r3 == 0) goto L_0x0148
            java.lang.String r3 = "file"
            boolean r3 = r0.startsWith(r3)     // Catch:{ all -> 0x0151 }
            if (r3 == 0) goto L_0x0148
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0151 }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0151 }
            goto L_0x014d
        L_0x0148:
            com.bykv.vk.openvk.component.video.a.d.c r3 = r1.e     // Catch:{ all -> 0x0151 }
            r3.a((java.lang.String) r0)     // Catch:{ all -> 0x0151 }
        L_0x014d:
            r1.j = r11     // Catch:{ all -> 0x0151 }
            goto L_0x0308
        L_0x0151:
            r0 = move-exception
            java.lang.String r3 = "OP_SET_DATASOURCE error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
            goto L_0x0308
        L_0x0159:
            int r3 = r1.j
            if (r3 == r15) goto L_0x0165
            int r3 = r1.j
            if (r3 == r9) goto L_0x0165
            int r3 = r1.j
            if (r3 != r14) goto L_0x01aa
        L_0x0165:
            com.bykv.vk.openvk.component.video.a.d.c r3 = r1.e     // Catch:{ all -> 0x0174 }
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0174 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0174 }
            long r7 = r0.longValue()     // Catch:{ all -> 0x0174 }
            r3.a((long) r7)     // Catch:{ all -> 0x0174 }
            goto L_0x0308
        L_0x0174:
            r0 = move-exception
            java.lang.String r3 = "OP_SEEKTO error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
            goto L_0x0308
        L_0x017c:
            int r0 = r1.j
            if (r0 == r12) goto L_0x0190
            int r0 = r1.j
            if (r0 == r15) goto L_0x0190
            int r0 = r1.j
            if (r0 == r13) goto L_0x0190
            int r0 = r1.j
            if (r0 == r9) goto L_0x0190
            int r0 = r1.j
            if (r0 != r14) goto L_0x01aa
        L_0x0190:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x0199 }
            r0.f()     // Catch:{ all -> 0x0199 }
            r1.j = r13     // Catch:{ all -> 0x0199 }
            goto L_0x0308
        L_0x0199:
            r0 = move-exception
            java.lang.String r3 = "OP_STOP error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
            goto L_0x0308
        L_0x01a1:
            int r0 = r1.j
            if (r0 == r11) goto L_0x01ad
            int r0 = r1.j
            if (r0 != r13) goto L_0x01aa
            goto L_0x01ad
        L_0x01aa:
            r5 = r6
            goto L_0x0308
        L_0x01ad:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x01b9 }
            r0.h()     // Catch:{ all -> 0x01b9 }
            java.lang.String r0 = "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x01b9 }
            goto L_0x0308
        L_0x01b9:
            r0 = move-exception
            java.lang.String r3 = "OP_PREPARE_ASYNC error: "
            com.bykv.vk.openvk.component.video.api.f.c.c(r4, r3, r0)
            goto L_0x0308
        L_0x01c1:
            r16.w()     // Catch:{ all -> 0x01ca }
            java.lang.String r0 = "[video] OP_RELEASE execute , releaseMediaplayer !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x01ca }
            goto L_0x01d0
        L_0x01ca:
            r0 = move-exception
            java.lang.String r3 = "OP_RELEASE error: "
            com.bykv.vk.openvk.component.video.api.f.c.c(r4, r3, r0)
        L_0x01d0:
            r1.i = r5
            java.util.List<java.lang.ref.WeakReference<com.bykv.vk.openvk.component.video.api.a$a>> r0 = r1.y
            java.util.Iterator r0 = r0.iterator()
        L_0x01d8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01f6
            java.lang.Object r3 = r0.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            if (r3 == 0) goto L_0x01d8
            java.lang.Object r4 = r3.get()
            if (r4 == 0) goto L_0x01d8
            java.lang.Object r3 = r3.get()
            com.bykv.vk.openvk.component.video.api.a$a r3 = (com.bykv.vk.openvk.component.video.api.a.C0020a) r3
            r3.c(r1)
            goto L_0x01d8
        L_0x01f6:
            r1.j = r8
            goto L_0x0308
        L_0x01fa:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x0208 }
            r0.l()     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "[video] OP_RESET execute!"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0208 }
            r1.j = r7     // Catch:{ all -> 0x0208 }
            goto L_0x0308
        L_0x0208:
            r0 = move-exception
            java.lang.String r3 = "OP_RESET error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
            goto L_0x0308
        L_0x0210:
            boolean r0 = r1.m
            if (r0 == 0) goto L_0x021b
            long r7 = r1.n
            long r10 = r1.p
            long r7 = r7 + r10
            r1.n = r7
        L_0x021b:
            r1.m = r5
            r7 = 0
            r1.p = r7
            r7 = -9223372036854775808
            r1.o = r7
            int r0 = r1.j
            if (r0 == r15) goto L_0x0231
            int r0 = r1.j
            if (r0 == r9) goto L_0x0231
            int r0 = r1.j
            if (r0 != r14) goto L_0x01aa
        L_0x0231:
            java.lang.String r0 = "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0263 }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x0263 }
            r0.g()     // Catch:{ all -> 0x0263 }
            r1.j = r9     // Catch:{ all -> 0x0263 }
            r1.G = r5     // Catch:{ all -> 0x0263 }
            java.util.List<java.lang.ref.WeakReference<com.bykv.vk.openvk.component.video.api.a$a>> r0 = r1.y     // Catch:{ all -> 0x0263 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0263 }
        L_0x0245:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0263 }
            if (r3 == 0) goto L_0x0308
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0263 }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ all -> 0x0263 }
            if (r3 == 0) goto L_0x0245
            java.lang.Object r7 = r3.get()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x0245
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0263 }
            com.bykv.vk.openvk.component.video.api.a$a r3 = (com.bykv.vk.openvk.component.video.api.a.C0020a) r3     // Catch:{ all -> 0x0263 }
            r3.d(r1)     // Catch:{ all -> 0x0263 }
            goto L_0x0245
        L_0x0263:
            r0 = move-exception
            java.lang.String r3 = "OP_PAUSE error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
            goto L_0x0308
        L_0x026b:
            int r0 = r1.j
            if (r0 == r12) goto L_0x0277
            int r0 = r1.j
            if (r0 == r9) goto L_0x0277
            int r0 = r1.j
            if (r0 != r14) goto L_0x01aa
        L_0x0277:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x02bc }
            r0.e()     // Catch:{ all -> 0x02bc }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02bc }
            r1.r = r7     // Catch:{ all -> 0x02bc }
            java.lang.String r0 = "[video] OP_START execute , mMediaPlayer real start !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x02bc }
            r1.j = r15     // Catch:{ all -> 0x02bc }
            long r7 = r1.k     // Catch:{ all -> 0x02bc }
            r9 = 0
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x02b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bc }
            r0.<init>()     // Catch:{ all -> 0x02bc }
            java.lang.String r3 = "[video] OP_START, seekTo:"
            r0.append(r3)     // Catch:{ all -> 0x02bc }
            long r7 = r1.k     // Catch:{ all -> 0x02bc }
            r0.append(r7)     // Catch:{ all -> 0x02bc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02bc }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x02bc }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x02bc }
            long r7 = r1.k     // Catch:{ all -> 0x02bc }
            r0.a((long) r7)     // Catch:{ all -> 0x02bc }
            r7 = -1
            r1.k = r7     // Catch:{ all -> 0x02bc }
        L_0x02b2:
            com.bykv.vk.openvk.component.video.api.c.c r0 = r1.z     // Catch:{ all -> 0x02bc }
            if (r0 == 0) goto L_0x0308
            boolean r0 = r1.A     // Catch:{ all -> 0x02bc }
            r1.a((boolean) r0)     // Catch:{ all -> 0x02bc }
            goto L_0x0308
        L_0x02bc:
            r0 = move-exception
            java.lang.String r3 = "OP_START error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
            goto L_0x0308
        L_0x02c3:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02e4 }
            r7 = 14
            if (r3 < r7) goto L_0x02db
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x02e4 }
            android.graphics.SurfaceTexture r0 = (android.graphics.SurfaceTexture) r0     // Catch:{ all -> 0x02e4 }
            android.view.Surface r3 = new android.view.Surface     // Catch:{ all -> 0x02e4 }
            r3.<init>(r0)     // Catch:{ all -> 0x02e4 }
            r1.D = r3     // Catch:{ all -> 0x02e4 }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x02e4 }
            android.view.Surface r3 = r1.D     // Catch:{ all -> 0x02e4 }
            r0.a((android.view.Surface) r3)     // Catch:{ all -> 0x02e4 }
        L_0x02db:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x02e4 }
            r0.b(r6)     // Catch:{ all -> 0x02e4 }
            r16.A()     // Catch:{ all -> 0x02e4 }
            goto L_0x0308
        L_0x02e4:
            r0 = move-exception
            java.lang.String r3 = "OP_SET_SURFACE error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
            goto L_0x0308
        L_0x02eb:
            java.lang.String r3 = "resumeVideo:  OP_SET_DISPLAY "
            com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r4, (java.lang.String) r3)
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0302 }
            android.view.SurfaceHolder r0 = (android.view.SurfaceHolder) r0     // Catch:{ all -> 0x0302 }
            com.bykv.vk.openvk.component.video.a.d.c r3 = r1.e     // Catch:{ all -> 0x0302 }
            r3.a((android.view.SurfaceHolder) r0)     // Catch:{ all -> 0x0302 }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.e     // Catch:{ all -> 0x0302 }
            r0.b(r6)     // Catch:{ all -> 0x0302 }
            r16.A()     // Catch:{ all -> 0x0302 }
            goto L_0x0308
        L_0x0302:
            r0 = move-exception
            java.lang.String r3 = "OP_SET_DISPLAY error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r4, r3, r0)
        L_0x0308:
            if (r5 == 0) goto L_0x033f
            r0 = 200(0xc8, float:2.8E-43)
            r1.j = r0
            boolean r0 = r1.g
            if (r0 != 0) goto L_0x033f
            com.bykv.vk.openvk.component.video.api.c.a r0 = new com.bykv.vk.openvk.component.video.api.c.a
            r3 = 308(0x134, float:4.32E-43)
            r0.<init>(r3, r2)
            java.util.List<java.lang.ref.WeakReference<com.bykv.vk.openvk.component.video.api.a$a>> r2 = r1.y
            java.util.Iterator r2 = r2.iterator()
        L_0x031f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x033d
            java.lang.Object r3 = r2.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            if (r3 == 0) goto L_0x031f
            java.lang.Object r4 = r3.get()
            if (r4 == 0) goto L_0x031f
            java.lang.Object r3 = r3.get()
            com.bykv.vk.openvk.component.video.api.a$a r3 = (com.bykv.vk.openvk.component.video.api.a.C0020a) r3
            r3.a((com.bykv.vk.openvk.component.video.api.a) r1, (com.bykv.vk.openvk.component.video.api.c.a) r0)
            goto L_0x031f
        L_0x033d:
            r1.g = r6
        L_0x033f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.d.d.a(android.os.Message):void");
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.e.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void w() {
        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.e != null) {
            try {
                this.e.l();
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "releaseMediaplayer error1: ", th);
            }
            this.e.a((c.b) null);
            this.e.a((c.g) null);
            this.e.a((c.a) null);
            this.e.a((c.d) null);
            this.e.a((c.C0018c) null);
            this.e.a((c.e) null);
            this.e.a((c.f) null);
            try {
                this.e.k();
            } catch (Throwable th2) {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "releaseMediaplayer error2: ", th2);
            }
        }
    }

    private void x() {
        Handler handler = this.l;
        if (handler != null && handler.getLooper() != null) {
            this.l.post(new Runnable() {
                public void run() {
                    if (d.this.l.getLooper() != null) {
                        try {
                            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "onDestory............");
                            d.this.l.getLooper().quit();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "onDestroy error: ", th);
                        }
                    }
                }
            });
        }
    }

    public void a(c cVar, int i2) {
        if (this.e == cVar) {
            for (WeakReference next : this.y) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0020a) next.get()).b(this, i2);
                }
            }
        }
    }

    private void y() {
        Integer valueOf = Integer.valueOf(w.get(this.u));
        if (valueOf == null) {
            w.put(this.u, 1);
        } else {
            w.put(this.u, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    public void a(c cVar) {
        this.j = 209;
        w.delete(this.u);
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacks(this.E);
        }
        for (WeakReference next : this.y) {
            if (!(next == null || next.get() == null)) {
                ((a.C0020a) next.get()).a(this);
            }
        }
        b("completion");
    }

    public boolean a(c cVar, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", "what=" + i2 + "extra=" + i3);
        y();
        this.j = 200;
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacks(this.E);
        }
        if (a(i2, i3)) {
            x();
        }
        if (!this.C.get()) {
            return true;
        }
        this.C.set(false);
        if (!this.g) {
            com.bykv.vk.openvk.component.video.api.c.a aVar = new com.bykv.vk.openvk.component.video.api.c.a(308, i3);
            for (WeakReference next : this.y) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0020a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, aVar);
                }
            }
            this.g = true;
            return true;
        }
        com.bykv.vk.openvk.component.video.api.c.a aVar2 = new com.bykv.vk.openvk.component.video.api.c.a(i2, i3);
        for (WeakReference next2 : this.y) {
            if (!(next2 == null || next2.get() == null)) {
                ((a.C0020a) next2.get()).a((com.bykv.vk.openvk.component.video.api.a) this, aVar2);
            }
        }
        return true;
    }

    private boolean a(int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z2 = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z2;
    }

    public boolean b(c cVar, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", "what,extra:" + i2 + "," + i3);
        if (this.e != cVar) {
            return false;
        }
        if (i3 == -1004) {
            com.bykv.vk.openvk.component.video.api.c.a aVar = new com.bykv.vk.openvk.component.video.api.c.a(i2, i3);
            for (WeakReference next : this.y) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0020a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, aVar);
                }
            }
        }
        b(i2, i3);
        return false;
    }

    /* access modifiers changed from: private */
    public void b(int i2, int i3) {
        String str;
        int i4 = i2;
        if (i4 == 701) {
            this.J = SystemClock.elapsedRealtime();
            this.c++;
            for (WeakReference next : this.y) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0020a) next.get()).a(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.c));
        } else if (i4 == 702) {
            if (this.J > 0) {
                str = "CSJ_VIDEO_MEDIA";
                this.K += SystemClock.elapsedRealtime() - this.J;
                this.J = 0;
            } else {
                str = "CSJ_VIDEO_MEDIA";
            }
            for (WeakReference next2 : this.y) {
                if (!(next2 == null || next2.get() == null)) {
                    ((a.C0020a) next2.get()).a((com.bykv.vk.openvk.component.video.api.a) this, Integer.MAX_VALUE);
                }
            }
            com.bykv.vk.openvk.component.video.api.f.c.b(str, "bufferCount = ", Integer.valueOf(this.c), " mBufferTotalTime = ", Long.valueOf(this.K));
        } else {
            String str2 = "CSJ_VIDEO_MEDIA";
            if (this.L && i4 == 3) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.r;
                this.d = true;
                for (WeakReference next3 : this.y) {
                    if (!(next3 == null || next3.get() == null)) {
                        ((a.C0020a) next3.get()).a((com.bykv.vk.openvk.component.video.api.a) this, elapsedRealtime);
                    }
                }
                a(this.A);
                com.bykv.vk.openvk.component.video.api.f.c.b(str2, "onRenderStart");
            }
        }
    }

    public void b(c cVar) {
        this.j = 205;
        if (this.G) {
            this.l.post(new Runnable() {
                public void run() {
                    try {
                        d.this.e.g();
                        int unused = d.this.j = 207;
                        boolean unused2 = d.this.G = false;
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.l;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        w.delete(this.u);
        com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", "onPrepared:" + this.L + " " + this.s);
        if (!this.L && !this.s) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.r;
            for (WeakReference next : this.y) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0020a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, elapsedRealtime);
                }
            }
            this.d = true;
            this.s = true;
        }
        for (WeakReference next2 : this.y) {
            if (!(next2 == null || next2.get() == null)) {
                ((a.C0020a) next2.get()).b(this);
            }
        }
    }

    public void c(c cVar) {
        for (WeakReference next : this.y) {
            if (!(next == null || next.get() == null)) {
                ((a.C0020a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, true);
            }
        }
    }

    private void a(Runnable runnable) {
        try {
            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "enqueueAction()");
            if (this.t == null) {
                this.t = new ArrayList<>();
            }
            this.t.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void z() {
        if (!this.h) {
            this.h = true;
            Iterator it = new ArrayList(this.t).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.t.clear();
            this.h = false;
        }
    }

    private void A() {
        ArrayList<Runnable> arrayList = this.t;
        boolean z2 = arrayList == null || arrayList.isEmpty();
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "isPendingAction:" + z2);
        if (!z2) {
            z();
        }
    }

    private void B() {
        ArrayList<Runnable> arrayList = this.t;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.t.clear();
        }
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            if (!this.i) {
                runnable.run();
            } else {
                a(runnable);
            }
        }
    }

    public void a(final boolean z2) {
        Handler handler = this.l;
        if (handler == null) {
            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            handler.post(new Runnable() {
                public void run() {
                    com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "run:before setQuietPlay ", Boolean.valueOf(z2));
                    if (!d.this.i && d.this.j != 203 && d.this.e != null) {
                        try {
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "run:exec  setQuietPlay ", Boolean.valueOf(z2));
                            boolean unused = d.this.A = z2;
                            d.this.e.d(z2);
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setQuietPlay error: ", th);
                        }
                    }
                }
            });
        }
    }

    private void b(String str) {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeMessages(201);
        }
        synchronized (this.H) {
            if (this.I != null) {
                this.I = null;
            }
        }
    }

    public long o() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.K;
        }
        if (this.m) {
            long j2 = this.p;
            if (j2 > 0) {
                return this.n + j2;
            }
        }
        return this.n;
    }

    public int j() {
        if (this.e != null) {
            return this.e.m();
        }
        return 0;
    }

    public int k() {
        if (this.e != null) {
            return this.e.n();
        }
        return 0;
    }

    public int p() {
        return this.c;
    }

    public void a(c cVar, int i2, int i3, int i4, int i5) {
        for (WeakReference next : this.y) {
            if (!(next == null || next.get() == null)) {
                ((a.C0020a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, i2, i3);
            }
        }
    }

    public long q() {
        long j2 = this.q;
        if (j2 != 0) {
            return j2;
        }
        if (this.j == 206 || this.j == 207) {
            try {
                this.q = this.e.j();
            } catch (Throwable unused) {
            }
        }
        return this.q;
    }

    public long s() {
        if (this.j != 206 && this.j != 207) {
            return 0;
        }
        try {
            return this.e.i();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void a(a.C0020a aVar) {
        if (aVar != null) {
            for (WeakReference next : this.y) {
                if (next != null && next.get() == aVar) {
                    return;
                }
            }
            this.y.add(new WeakReference(aVar));
        }
    }

    public SurfaceHolder f() {
        return this.b;
    }

    public SurfaceTexture g() {
        return this.a;
    }
}
