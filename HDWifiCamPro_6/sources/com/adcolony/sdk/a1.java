package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.view.MotionEventCompat;
import com.adcolony.sdk.e0;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

class a1 extends TextureView implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, TextureView.SurfaceTextureListener {
    private boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    private boolean D;
    private String E;
    /* access modifiers changed from: private */
    public String F;
    private FileInputStream G;
    private h0 H;
    /* access modifiers changed from: private */
    public c I;
    private Surface J;
    private SurfaceTexture K;
    /* access modifiers changed from: private */
    public RectF L = new RectF();
    /* access modifiers changed from: private */
    public j M;
    private ProgressBar N;
    /* access modifiers changed from: private */
    public MediaPlayer O;
    /* access modifiers changed from: private */
    public f1 P = c0.b();
    private ExecutorService Q = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public h0 R;
    private float a;
    private float b;
    /* access modifiers changed from: private */
    public float c;
    /* access modifiers changed from: private */
    public float d;
    private float e;
    private float f;
    /* access modifiers changed from: private */
    public int g;
    private boolean h = true;
    /* access modifiers changed from: private */
    public Paint i = new Paint();
    /* access modifiers changed from: private */
    public Paint j = new Paint(1);
    private int k;
    private int l;
    private int m;
    private int n;
    /* access modifiers changed from: private */
    public int o;
    private int p;
    private int q;
    /* access modifiers changed from: private */
    public double r;
    /* access modifiers changed from: private */
    public double s;
    /* access modifiers changed from: private */
    public long t;
    /* access modifiers changed from: private */
    public boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private boolean y;
    /* access modifiers changed from: private */
    public boolean z;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (a1.this.a(h0Var)) {
                a1.this.i();
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (a1.this.a(h0Var)) {
                a1.this.c(h0Var);
            }
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            if (a1.this.a(h0Var)) {
                a1.this.d(h0Var);
            }
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            if (a1.this.a(h0Var)) {
                a1.this.h();
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            if (a1.this.a(h0Var)) {
                boolean unused = a1.this.b(h0Var);
            }
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            if (a1.this.a(h0Var)) {
                boolean unused = a1.this.e(h0Var);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (a1.this.R != null) {
                f1 b = c0.b();
                c0.b(b, "id", a1.this.o);
                c0.a(b, "ad_session_id", a1.this.F);
                c0.b(b, "success", true);
                a1.this.R.a(b).c();
                h0 unused = a1.this.R = null;
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            long unused = a1.this.t = 0;
            while (!a1.this.u && !a1.this.x && a.c()) {
                Context a2 = a.a();
                if (!a1.this.u && !a1.this.z && a2 != null && (a2 instanceof Activity)) {
                    if (a1.this.O.isPlaying()) {
                        if (a1.this.t == 0 && a.d) {
                            long unused2 = a1.this.t = System.currentTimeMillis();
                        }
                        boolean unused3 = a1.this.w = true;
                        a1 a1Var = a1.this;
                        double unused4 = a1Var.r = ((double) a1Var.O.getCurrentPosition()) / 1000.0d;
                        a1 a1Var2 = a1.this;
                        double unused5 = a1Var2.s = ((double) a1Var2.O.getDuration()) / 1000.0d;
                        if (System.currentTimeMillis() - a1.this.t > 1000 && !a1.this.C && a.d) {
                            if (a1.this.r == 0.0d) {
                                new e0.a().a("getCurrentPosition() not working, firing ").a("AdSession.on_error").a(e0.i);
                                a1.this.g();
                            } else {
                                boolean unused6 = a1.this.C = true;
                            }
                        }
                        if (a1.this.B) {
                            a1.this.e();
                        }
                    }
                    if (a1.this.w && !a1.this.u && !a1.this.x) {
                        c0.b(a1.this.P, "id", a1.this.o);
                        c0.b(a1.this.P, "container_id", a1.this.I.c());
                        c0.a(a1.this.P, "ad_session_id", a1.this.F);
                        c0.a(a1.this.P, "elapsed", a1.this.r);
                        c0.a(a1.this.P, IronSourceConstants.EVENTS_DURATION, a1.this.s);
                        new h0("VideoView.on_progress", a1.this.I.k(), a1.this.P).c();
                    }
                    if (a1.this.v || ((Activity) a2).isFinishing()) {
                        boolean unused7 = a1.this.v = false;
                        a1.this.j();
                        return;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException unused8) {
                        a1.this.g();
                        new e0.a().a("InterruptedException in ADCVideoView's update thread.").a(e0.h);
                    }
                } else {
                    return;
                }
            }
            if (a1.this.v) {
                a1.this.j();
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ Context a;

        i(Context context) {
            this.a = context;
        }

        public void run() {
            a1 a1Var = a1.this;
            j unused = a1Var.M = new j(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (a1.this.c * 4.0f), (int) (a1.this.c * 4.0f));
            layoutParams.setMargins(0, a1.this.I.b() - ((int) (a1.this.c * 4.0f)), 0, 0);
            layoutParams.gravity = 0;
            a1.this.I.addView(a1.this.M, layoutParams);
        }
    }

    private class j extends View {
        j(Context context) {
            super(context);
            setWillNotDraw(false);
            Class<j> cls = j.class;
            try {
                cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{1, null});
            } catch (Exception unused) {
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(a1.this.L, 270.0f, a1.this.d, false, a1.this.i);
            canvas.drawText("" + a1.this.g, a1.this.L.centerX(), (float) (((double) a1.this.L.centerY()) + (((double) a1.this.j.getFontMetrics().bottom) * 1.35d)), a1.this.j);
            invalidate();
        }
    }

    a1(Context context, h0 h0Var, int i2, c cVar) {
        super(context);
        this.I = cVar;
        this.H = h0Var;
        this.o = i2;
        setSurfaceTextureListener(this);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.u = true;
        this.r = this.s;
        c0.b(this.P, "id", this.o);
        c0.b(this.P, "container_id", this.I.c());
        c0.a(this.P, "ad_session_id", this.F);
        c0.a(this.P, "elapsed", this.r);
        c0.a(this.P, IronSourceConstants.EVENTS_DURATION, this.s);
        new h0("VideoView.on_progress", this.I.k(), this.P).c();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        g();
        e0.a aVar = new e0.a();
        aVar.a("MediaPlayer error: " + i2 + "," + i3).a(e0.h);
        return true;
    }

    public void onMeasure(int i2, int i3) {
        l();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.y = true;
        if (this.D) {
            this.I.removeView(this.N);
        }
        if (this.A) {
            this.p = mediaPlayer.getVideoWidth();
            this.q = mediaPlayer.getVideoHeight();
            l();
            new e0.a().a("MediaPlayer getVideoWidth = ").a(mediaPlayer.getVideoWidth()).a(e0.e);
            new e0.a().a("MediaPlayer getVideoHeight = ").a(mediaPlayer.getVideoHeight()).a(e0.e);
        }
        f1 b2 = c0.b();
        c0.b(b2, "id", this.o);
        c0.b(b2, "container_id", this.I.c());
        c0.a(b2, "ad_session_id", this.F);
        new h0("VideoView.on_ready", this.I.k(), b2).c();
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        ExecutorService executorService = this.Q;
        if (executorService != null && !executorService.isShutdown()) {
            try {
                this.Q.submit(new g());
            } catch (RejectedExecutionException unused) {
                g();
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (surfaceTexture == null || this.z) {
            new e0.a().a("Null texture provided by system's onSurfaceTextureAvailable or ").a("MediaPlayer has been destroyed.").a(e0.i);
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.J = surface;
        try {
            this.O.setSurface(surface);
        } catch (IllegalStateException unused) {
            new e0.a().a("IllegalStateException thrown when calling MediaPlayer.setSurface()").a(e0.h);
            g();
        }
        this.K = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.K = surfaceTexture;
        if (!this.z) {
            return false;
        }
        surfaceTexture.release();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.K = surfaceTexture;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.K = surfaceTexture;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        k b2 = a.b();
        d c2 = b2.c();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        f1 b3 = c0.b();
        c0.b(b3, "view_id", this.o);
        c0.a(b3, "ad_session_id", this.F);
        c0.b(b3, "container_x", this.k + x2);
        c0.b(b3, "container_y", this.l + y2);
        c0.b(b3, "view_x", x2);
        c0.b(b3, "view_y", y2);
        c0.b(b3, "id", this.I.c());
        if (action == 0) {
            new h0("AdContainer.on_touch_began", this.I.k(), b3).c();
        } else if (action == 1) {
            if (!this.I.p()) {
                b2.a(c2.d().get(this.F));
            }
            new h0("AdContainer.on_touch_ended", this.I.k(), b3).c();
        } else if (action == 2) {
            new h0("AdContainer.on_touch_moved", this.I.k(), b3).c();
        } else if (action == 3) {
            new h0("AdContainer.on_touch_cancelled", this.I.k(), b3).c();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            c0.b(b3, "container_x", ((int) motionEvent2.getX(action2)) + this.k);
            c0.b(b3, "container_y", ((int) motionEvent2.getY(action2)) + this.l);
            c0.b(b3, "view_x", (int) motionEvent2.getX(action2));
            c0.b(b3, "view_y", (int) motionEvent2.getY(action2));
            new h0("AdContainer.on_touch_began", this.I.k(), b3).c();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            c0.b(b3, "container_x", ((int) motionEvent2.getX(action3)) + this.k);
            c0.b(b3, "container_y", ((int) motionEvent2.getY(action3)) + this.l);
            c0.b(b3, "view_x", (int) motionEvent2.getX(action3));
            c0.b(b3, "view_y", (int) motionEvent2.getY(action3));
            if (!this.I.p()) {
                b2.a(c2.d().get(this.F));
            }
            new h0("AdContainer.on_touch_ended", this.I.k(), b3).c();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void g() {
        f1 b2 = c0.b();
        c0.a(b2, "id", this.F);
        new h0("AdSession.on_error", this.I.k(), b2).c();
        this.u = true;
    }

    private void l() {
        double min = Math.min(((double) this.m) / ((double) this.p), ((double) this.n) / ((double) this.q));
        int i2 = (int) (((double) this.p) * min);
        int i3 = (int) (((double) this.q) * min);
        new e0.a().a("setMeasuredDimension to ").a(i2).a(" by ").a(i3).a(e0.e);
        setMeasuredDimension(i2, i3);
        if (this.A) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams);
        }
    }

    private void m() {
        try {
            this.Q.submit(new h());
        } catch (RejectedExecutionException unused) {
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        if (!this.y) {
            new e0.a().a("ADCVideoView pause() called while MediaPlayer is not prepared.").a(e0.g);
            return false;
        } else if (!this.w) {
            return false;
        } else {
            this.O.getCurrentPosition();
            this.s = (double) this.O.getDuration();
            this.O.pause();
            this.x = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        if (!this.y) {
            return false;
        }
        if (!this.x && a.d) {
            this.O.start();
            m();
        } else if (!this.u && a.d) {
            this.O.start();
            this.x = false;
            if (!this.Q.isShutdown()) {
                m();
            }
            j jVar = this.M;
            if (jVar != null) {
                jVar.invalidate();
            }
        }
        setWillNotDraw(false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        new e0.a().a("MediaPlayer stopped and released.").a(e0.e);
        try {
            if (!this.u && this.y && this.O.isPlaying()) {
                this.O.stop();
            }
        } catch (IllegalStateException unused) {
            new e0.a().a("Caught IllegalStateException when calling stop on MediaPlayer").a(e0.g);
        }
        ProgressBar progressBar = this.N;
        if (progressBar != null) {
            this.I.removeView(progressBar);
        }
        this.u = true;
        this.y = false;
        this.O.release();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.v = true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Context a2;
        f1 a3 = this.H.a();
        this.F = c0.h(a3, "ad_session_id");
        this.k = c0.d(a3, "x");
        this.l = c0.d(a3, "y");
        this.m = c0.d(a3, "width");
        this.n = c0.d(a3, "height");
        this.B = c0.b(a3, "enable_timer");
        this.D = c0.b(a3, "enable_progress");
        this.E = c0.h(a3, "filepath");
        this.p = c0.d(a3, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_VIDEO_WIDTH);
        this.q = c0.d(a3, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_VIDEO_HEIGHT);
        this.f = a.b().n().s();
        new e0.a().a("Original video dimensions = ").a(this.p).a("x").a(this.q).a(e0.c);
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.m, this.n);
        layoutParams.setMargins(this.k, this.l, 0, 0);
        layoutParams.gravity = 0;
        this.I.addView(this, layoutParams);
        if (this.D && (a2 = a.a()) != null) {
            ProgressBar progressBar = new ProgressBar(a2);
            this.N = progressBar;
            c cVar = this.I;
            int i2 = (int) (this.f * 100.0f);
            cVar.addView(progressBar, new FrameLayout.LayoutParams(i2, i2, 17));
        }
        this.O = new MediaPlayer();
        this.y = false;
        try {
            if (!this.E.startsWith("http")) {
                FileInputStream fileInputStream = new FileInputStream(this.E);
                this.G = fileInputStream;
                this.O.setDataSource(fileInputStream.getFD());
            } else {
                this.A = true;
                this.O.setDataSource(this.E);
            }
            this.O.setOnErrorListener(this);
            this.O.setOnPreparedListener(this);
            this.O.setOnCompletionListener(this);
            this.O.prepareAsync();
        } catch (IOException e2) {
            new e0.a().a("Failed to create/prepare MediaPlayer: ").a(e2.toString()).a(e0.h);
            g();
        }
        this.I.i().add(a.a("VideoView.play", (j0) new a(), true));
        this.I.i().add(a.a("VideoView.set_bounds", (j0) new b(), true));
        this.I.i().add(a.a("VideoView.set_visible", (j0) new c(), true));
        this.I.i().add(a.a("VideoView.pause", (j0) new d(), true));
        this.I.i().add(a.a("VideoView.seek_to_time", (j0) new e(), true));
        this.I.i().add(a.a("VideoView.set_volume", (j0) new f(), true));
        this.I.j().add("VideoView.play");
        this.I.j().add("VideoView.set_bounds");
        this.I.j().add("VideoView.set_visible");
        this.I.j().add("VideoView.pause");
        this.I.j().add("VideoView.seek_to_time");
        this.I.j().add("VideoView.set_volume");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.h) {
            this.e = (float) (360.0d / this.s);
            this.j.setColor(-3355444);
            this.j.setShadowLayer((float) ((int) (this.f * 2.0f)), 0.0f, 0.0f, -16777216);
            this.j.setTextAlign(Paint.Align.CENTER);
            this.j.setLinearText(true);
            this.j.setTextSize(this.f * 12.0f);
            this.i.setStyle(Paint.Style.STROKE);
            float f2 = this.f * 2.0f;
            if (f2 > 6.0f) {
                f2 = 6.0f;
            }
            if (f2 < 4.0f) {
                f2 = 4.0f;
            }
            this.i.setStrokeWidth(f2);
            this.i.setShadowLayer((float) ((int) (this.f * 3.0f)), 0.0f, 0.0f, -16777216);
            this.i.setColor(-3355444);
            Rect rect = new Rect();
            this.j.getTextBounds("0123456789", 0, 9, rect);
            this.c = (float) rect.height();
            Context a2 = a.a();
            if (a2 != null) {
                z0.b((Runnable) new i(a2));
            }
            this.h = false;
        }
        this.g = (int) (this.s - this.r);
        float f3 = this.c;
        float f4 = (float) ((int) f3);
        this.a = f4;
        float f5 = (float) ((int) (3.0f * f3));
        this.b = f5;
        float f6 = f3 / 2.0f;
        float f7 = f3 * 2.0f;
        this.L.set(f4 - f6, f5 - f7, f4 + f7, f5 + f6);
        this.d = (float) (((double) this.e) * (this.s - this.r));
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.u;
    }

    /* access modifiers changed from: private */
    public void c(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.k = c0.d(a2, "x");
        this.l = c0.d(a2, "y");
        this.m = c0.d(a2, "width");
        this.n = c0.d(a2, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.k, this.l, 0, 0);
        layoutParams.width = this.m;
        layoutParams.height = this.n;
        setLayoutParams(layoutParams);
        if (this.B && this.M != null) {
            int i2 = (int) (this.c * 4.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams2.setMargins(0, this.I.b() - ((int) (this.c * 4.0f)), 0, 0);
            layoutParams2.gravity = 0;
            this.M.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    public boolean b(h0 h0Var) {
        if (!this.y) {
            return false;
        }
        if (this.u) {
            this.u = false;
        }
        this.R = h0Var;
        int d2 = c0.d(h0Var.a(), "time");
        int duration = this.O.getDuration() / 1000;
        this.O.setOnSeekCompleteListener(this);
        this.O.seekTo(d2 * 1000);
        if (duration == d2) {
            this.u = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.K != null) {
            this.z = true;
        }
        this.Q.shutdown();
    }

    /* access modifiers changed from: private */
    public boolean a(h0 h0Var) {
        f1 a2 = h0Var.a();
        return c0.d(a2, "id") == this.o && c0.d(a2, "container_id") == this.I.c() && c0.h(a2, "ad_session_id").equals(this.I.a());
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.O != null;
    }

    /* access modifiers changed from: package-private */
    public MediaPlayer b() {
        return this.O;
    }

    /* access modifiers changed from: private */
    public boolean e(h0 h0Var) {
        boolean z2 = false;
        if (!this.y) {
            return false;
        }
        float c2 = (float) c0.c(h0Var.a(), "volume");
        AdColonyInterstitial j2 = a.b().j();
        if (j2 != null) {
            if (((double) c2) <= 0.0d) {
                z2 = true;
            }
            j2.a(z2);
        }
        this.O.setVolume(c2, c2);
        f1 b2 = c0.b();
        c0.b(b2, "success", true);
        h0Var.a(b2).c();
        return true;
    }

    /* access modifiers changed from: private */
    public void d(h0 h0Var) {
        j jVar;
        j jVar2;
        if (c0.b(h0Var.a(), "visible")) {
            setVisibility(0);
            if (this.B && (jVar2 = this.M) != null) {
                jVar2.setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(4);
        if (this.B && (jVar = this.M) != null) {
            jVar.setVisibility(4);
        }
    }
}
