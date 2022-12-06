package sg.bigo.ads.core.player.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.HashMap;
import sg.bigo.ads.R;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.player.b.a;
import sg.bigo.ads.core.player.d;

public final class b extends c implements a.C0147a {
    private int A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public long C;
    private final sg.bigo.ads.core.player.b D;
    private final n E;
    private boolean F;
    private View G;
    private final TextureView.SurfaceTextureListener H;
    private final View.OnClickListener I;
    /* access modifiers changed from: package-private */
    public ImageView a;
    Context b;
    public ProgressBar c;
    public boolean d;
    int e;
    Runnable f;
    private int g;
    private int h;
    private d i;
    private ImageView j;
    private sg.bigo.ads.common.view.a k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public a m = new a();
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public int o = 0;
    /* access modifiers changed from: private */
    public boolean p;
    private boolean q;
    private long r;
    private Runnable s;
    private boolean t;
    /* access modifiers changed from: private */
    public boolean u;
    private boolean v;
    private boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private int y;
    private boolean z;

    public b(Context context, int i2, int i3, sg.bigo.ads.core.player.b bVar, n nVar) {
        super(context);
        boolean z2 = true;
        this.d = true;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = false;
        this.z = false;
        this.C = 0;
        this.F = true;
        this.H = new TextureView.SurfaceTextureListener() {
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onSurfaceTextureAvailable");
                long unused = b.this.C = SystemClock.elapsedRealtime();
                Surface surface = new Surface(surfaceTexture);
                a a2 = b.this.m;
                try {
                    a2.a.setSurface(surface);
                    a2.e = true;
                } catch (IllegalStateException unused2) {
                    sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "setSurface IllegalStateException");
                }
                b.this.m.a(b.this.l);
                b.c(b.this);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                sg.bigo.ads.common.k.a.b("VideoPlayView", "onSurfaceTextureDestroyed");
                b.this.a(false);
                a a2 = b.this.m;
                try {
                    a2.a.reset();
                    c.a(a2.f);
                } catch (IllegalStateException unused) {
                    sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "reset IllegalStateException");
                }
                a2.e = false;
                a2.d = false;
                if (!b.this.p) {
                    boolean unused2 = b.this.u = false;
                    if (b.this.n > 0) {
                        b bVar = b.this;
                        int unused3 = bVar.o = bVar.n;
                    }
                }
                return false;
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onSurfaceTextureSizeChanged");
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.I = new View.OnClickListener() {
            public final void onClick(View view) {
                switch (view.getId()) {
                    case 200011:
                        b.this.setMute(!b.this.d);
                        return;
                    case 200012:
                        if (!b.this.B || !b.this.x) {
                            b bVar = b.this;
                            if (bVar.k()) {
                                bVar.removeCallbacks(bVar.f);
                                bVar.j();
                                bVar.a.setVisibility(0);
                                bVar.a.setImageDrawable(bVar.b.getResources().getDrawable(R.drawable.bigo_ad_ic_media_play));
                                return;
                            }
                            bVar.removeCallbacks(bVar.f);
                            bVar.b(false);
                            bVar.a.setVisibility(0);
                            bVar.a.setImageDrawable(bVar.b.getResources().getDrawable(R.drawable.bigo_ad_ic_media_pause));
                            bVar.postDelayed(bVar.f, 1500);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.e = 0;
        this.f = new Runnable() {
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.setVisibility(8);
                }
            }
        };
        this.b = context;
        this.E = nVar;
        this.D = bVar;
        this.r = bVar.g;
        this.p = bVar.f;
        this.g = i2;
        this.h = i3;
        int i4 = bVar.a;
        this.q = bVar.b;
        this.i = new d(this.b, i2, i3, i4);
        if (Build.VERSION.SDK_INT <= 19) {
            this.G = new View(this.b);
        }
        s.a(this.i, this, (ViewGroup.LayoutParams) null, -1);
        this.i.setSurfaceTextureListener(this.H);
        if (!bVar.h) {
            if (this.k == null) {
                this.k = new sg.bigo.ads.common.view.a(this.b);
                this.k.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            addView(this.k, new FrameLayout.LayoutParams(-1, -1, 17));
            n nVar2 = this.E;
            if (nVar2 != null && !TextUtils.isEmpty(nVar2.X())) {
                this.k.setVisibility(0);
                this.k.setImageURI(i.b(this.E.X()));
            }
        }
        this.d = this.m.a(bVar.d);
        if (!bVar.c) {
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.bigo_ad_volume_padding);
            this.j = new ImageView(this.b);
            this.j.setId(200011);
            this.j.setOnClickListener(this.I);
            this.j.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.j.setImageDrawable(this.b.getResources().getDrawable(this.d ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
            int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.bigo_ad_volume_size) + (dimensionPixelSize * 2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2, 85);
            layoutParams.rightMargin = dimensionPixelSize;
            layoutParams.bottomMargin = dimensionPixelSize;
            this.j.setVisibility(0);
            addView(this.j, layoutParams);
        }
        n nVar3 = this.E;
        this.B = (nVar3 == null || !nVar3.Y()) ? false : z2;
        if (this.B) {
            o();
        }
        int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.bigo_ad_replay_size);
        this.a = new ImageView(this.b);
        this.a.setImageDrawable(this.b.getResources().getDrawable(R.drawable.bigo_ad_ic_media_play));
        this.a.setVisibility(this.p ? 0 : 8);
        addView(this.a, new FrameLayout.LayoutParams(dimensionPixelSize3, dimensionPixelSize3, 17));
        this.m.b = this;
        setId(200012);
        setOnClickListener(this.I);
        b(0);
    }

    private void b(int i2) {
        n nVar = this.E;
        if (nVar != null) {
            sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) nVar, i2, nVar.V(), this.E.W());
        }
    }

    static /* synthetic */ void c(b bVar) {
        if (bVar.n()) {
            c.a(bVar.s);
            if (bVar.s == null) {
                bVar.s = new Runnable() {
                    public final void run() {
                        b.this.l();
                        b.this.a("AdVideoTooLate", new int[]{10107});
                    }
                };
            }
            c.a(2, bVar.s, bVar.r);
        }
    }

    private void c(boolean z2) {
        this.u = false;
        if (!this.m.d) {
            StringBuilder sb = new StringBuilder("incorrect status, the player is not prepared");
            sb.append(z2 ? " wating to play" : ", start ad failed");
            sg.bigo.ads.common.k.a.b("VideoPlayView", sb.toString());
            this.t = z2;
            int i2 = this.e;
            if (i2 < 8) {
                this.e = i2 + 1;
                if (this.e == 8) {
                    sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) this.E, 3003, 10107, "Not prepared, src path = " + this.l);
                }
            }
        } else if (!sg.bigo.ads.common.p.b.a()) {
            sg.bigo.ads.common.k.a.b("VideoPlayView", "screen is off, start ad cancel");
        } else {
            if (this.m.a()) {
                this.A = getAdDuration();
            }
            sg.bigo.ads.common.view.a aVar = this.k;
            if (aVar != null) {
                aVar.setVisibility(8);
            }
            this.a.setVisibility(8);
            a(true);
        }
    }

    private void m() {
        if (this.m.d && this.m.b()) {
            this.t = false;
            if (this.B) {
                p();
            }
            this.z = false;
            sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "pauseAd called");
        }
    }

    private boolean n() {
        return this.r > 0;
    }

    private void o() {
        Context context = sg.bigo.ads.common.b.a.a;
        this.c = new ProgressBar(context);
        this.c.setBackgroundColor(context.getResources().getColor(17170445));
        q.a(context, this.c, R.drawable.bigo_ad_progressbar_white);
        this.c.setVisibility(8);
        addView(this.c, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    private void p() {
        if (this.c == null) {
            o();
        }
        this.c.setVisibility(8);
    }

    public final void a() {
        a("AdVideoStart", (int[]) null);
    }

    public final void a(MediaPlayer mediaPlayer) {
        int i2;
        int i3;
        c.a(this.s);
        boolean z2 = this.g == 0 && this.h == 0;
        this.g = mediaPlayer.getVideoWidth();
        this.h = mediaPlayer.getVideoHeight();
        if (z2 && (i2 = this.g) > 0 && (i3 = this.h) > 0) {
            d dVar = this.i;
            dVar.a = i2;
            dVar.b = i3;
            dVar.requestLayout();
        }
        HashMap hashMap = new HashMap();
        if (this.C > 0) {
            hashMap.put("cost", String.valueOf(SystemClock.elapsedRealtime() - this.C));
            this.C = 0;
        }
        if (this.F) {
            b(18);
        }
        if (this.t || n()) {
            this.t = false;
            h();
        } else if (!this.u && !this.p) {
            a(true);
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            d.a.a.a(this);
        } else {
            d.a.a.b(this);
        }
    }

    public final boolean a(int i2) {
        sg.bigo.ads.common.k.a.a("VideoPlayView", "onInfo called, whatInfo = ".concat(String.valueOf(i2)));
        if (i2 == 3) {
            sg.bigo.ads.common.k.a.a("VideoPlayView", "player pushed first video frame for rendering, video started");
            sg.bigo.ads.common.view.a aVar = this.k;
            if (aVar != null) {
                aVar.setVisibility(8);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        return false;
    }

    public final boolean a(int i2, int i3) {
        if (!(i2 == -1010 || i2 == -1007 || i2 == -1004)) {
            if (i2 == 100) {
                this.m.e();
                this.m = new a();
            }
        }
        sg.bigo.ads.common.k.a.a(2, "VideoPlayView", "An error occurred during the video playback: ".concat(String.valueOf(i2)));
        a("AdError", new int[]{i2, i3});
        if (i2 == -38) {
            sg.bigo.ads.common.k.a.a(0, "VideoPlayView", "onError code = -38, now reset status and init again.Range=" + this.n);
            this.m.a(this.l);
        }
        return true;
    }

    public final void b() {
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onPlay");
        this.p = false;
        int i2 = this.o;
        if (i2 > 0) {
            this.m.a(i2);
            this.o = -1;
        }
        a("AdVideoPlaying", (int[]) null);
    }

    public final void b(boolean z2) {
        if (this.u) {
            b(9);
        }
        c(z2);
    }

    public final void c() {
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onPause");
        a("AdVideoPaused", (int[]) null);
    }

    public final void d() {
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onStop");
    }

    public final void e() {
        String str;
        int adRemainingTime = getAdRemainingTime();
        if (this.B && (str = this.l) != null && !str.startsWith("file:")) {
            if (this.y == adRemainingTime) {
                if (!this.z) {
                    if (this.c == null) {
                        o();
                    }
                    this.c.setVisibility(0);
                    sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onBuffering");
                    this.x = true;
                    a("AdVideoBuffering", (int[]) null);
                }
                this.z = true;
            } else {
                if (this.z) {
                    p();
                    sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onBuffered");
                    this.x = false;
                    a("AdVideoBuffered", (int[]) null);
                }
                this.z = false;
            }
            this.y = adRemainingTime;
        }
        if (this.A <= 0) {
            this.A = getAdDuration();
            if (this.A <= 0) {
                return;
            }
        }
        int i2 = this.A;
        if (adRemainingTime > i2) {
            adRemainingTime = i2;
        }
        this.n = adRemainingTime;
        int i3 = this.A;
        a("AdRemainingTimeChange", new int[]{adRemainingTime, i3, (int) ((((float) adRemainingTime) * 100.0f) / ((float) i3))});
    }

    public final void f() {
        this.p = true;
        sg.bigo.ads.common.view.a aVar = this.k;
        if (aVar != null) {
            aVar.setVisibility(0);
        }
        this.a.setVisibility(this.q ? 8 : 0);
        this.a.setImageDrawable(this.b.getResources().getDrawable(R.drawable.bigo_ad_ic_media_play));
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onCompletion play");
        a(false);
        a("AdVideoComplete", (int[]) null);
    }

    public final void g() {
        a("AdSizeChange", (int[]) null);
    }

    public final String getAdCompanions() {
        return "";
    }

    public final int getAdDuration() {
        return this.m.f();
    }

    public final boolean getAdExpanded() {
        return false;
    }

    public final int getAdHeight() {
        return this.h;
    }

    public final boolean getAdIcons() {
        return false;
    }

    public final boolean getAdLinear() {
        return false;
    }

    public final int getAdRemainingTime() {
        return this.m.c();
    }

    public final boolean getAdSkippableState() {
        return false;
    }

    public final int getAdVolume() {
        return 0;
    }

    public final int getAdWidth() {
        return this.g;
    }

    public final ImageView getCoverView() {
        return this.k;
    }

    public final int getCurrentPos() {
        return this.n;
    }

    public final int getPlayStatus() {
        return this.m.c;
    }

    public final void h() {
        if (this.u || this.p) {
            sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "tryStartAd, video is completed play, unregister it from list");
            a(false);
            return;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "try start play video ad");
        c(false);
    }

    public final void i() {
        if (k()) {
            m();
        }
    }

    public final void j() {
        this.u = true;
        m();
        b(8);
    }

    public final boolean k() {
        return getPlayStatus() == 2;
    }

    public final void l() {
        this.m.d();
        this.m.e();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onDetachedFromWindow called");
        a(false);
        this.c = null;
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onVisibilityChanged visibility != VISIBLE");
            a(false);
            return;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onVisibilityChanged visibility == VISIBLE");
        a(true);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "onWindowVisibilityChanged: ".concat(String.valueOf(i2)));
        View view = this.G;
        if (view == null) {
            return;
        }
        if (i2 == 0) {
            s.a(view);
            s.a(this.i, this, (ViewGroup.LayoutParams) null, 0);
            return;
        }
        s.a(this.i);
        s.a(this.G, this, new FrameLayout.LayoutParams(this.g, this.h), 0);
    }

    public final void setMute(boolean z2) {
        if (this.d == z2) {
            this.v = false;
            return;
        }
        this.d = this.m.a(z2);
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageDrawable(this.b.getResources().getDrawable(this.d ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
        }
        if (this.v || this.w) {
            this.v = false;
            this.w = false;
            return;
        }
        int[] iArr = new int[1];
        iArr[0] = this.d ? 0 : 100;
        a("AdVolumeChange", iArr);
    }

    public final void setPlayInfo$505cff1c(String str) {
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "setPlayInfo path=" + str + ",position=0");
        this.l = str;
        this.n = 0;
    }

    public final void setSeekPos(int i2) {
        this.o = i2;
    }

    public final void setStatPrepareEventOnce(boolean z2) {
        this.F = z2;
    }
}
