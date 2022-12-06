package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.VideoNativePlayer;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import com.mbridge.msdk.videocommon.view.MyImageView;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class MediaViewPlayerView extends LinearLayout implements VideoPlayerStatusListener {
    private static Handler F = new Handler();
    private String A;
    private String B;
    private CampaignEx C;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.nativex.listener.a D;
    private Timer E;
    private com.mbridge.msdk.videocommon.download.a G;
    /* access modifiers changed from: private */
    public VideoNativePlayer H;
    private a I;
    private boolean J = false;
    private boolean a = false;
    /* access modifiers changed from: private */
    public boolean b = false;
    /* access modifiers changed from: private */
    public boolean c = false;
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public boolean e = false;
    private boolean f = false;
    /* access modifiers changed from: private */
    public boolean g = false;
    /* access modifiers changed from: private */
    public boolean h = true;
    /* access modifiers changed from: private */
    public boolean i = false;
    /* access modifiers changed from: private */
    public boolean j = true;
    /* access modifiers changed from: private */
    public boolean k = false;
    private volatile int l = -1;
    private boolean m = true;
    private boolean n = true;
    private TextureView o;
    private LinearLayout p;
    /* access modifiers changed from: private */
    public Surface q;
    private ProgressBar r;
    /* access modifiers changed from: private */
    public MyImageView s;
    /* access modifiers changed from: private */
    public ImageView t;
    /* access modifiers changed from: private */
    public ImageView u;
    private ImageView v;
    private ImageView w;
    private View x;
    private AnimationDrawable y;
    private AlphaAnimation z;

    public void onBufferingEnd() {
    }

    public void onBufferingStart(String str) {
    }

    public void setMediaViewPlayListener(a aVar) {
        this.I = aVar;
    }

    public MediaViewPlayerView(Context context) {
        super(context);
        a();
    }

    public MediaViewPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        try {
            c();
            b();
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
        }
    }

    private void b() {
        this.H = new VideoNativePlayer();
        this.H.setSelfVideoFeedsPlayerListener(this);
    }

    private void c() {
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "mbridge_nativex_playerview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
            if (inflate != null) {
                this.p = (LinearLayout) inflate.findViewById(k.a(getContext(), "mbridge_ll_loading", "id"));
                this.o = (TextureView) inflate.findViewById(k.a(getContext(), "mbridge_textureview", "id"));
                this.o.setKeepScreenOn(true);
                this.o.setSurfaceTextureListener(new b());
                this.r = (ProgressBar) inflate.findViewById(k.a(getContext(), "mbridge_progress", "id"));
                this.s = (MyImageView) inflate.findViewById(k.a(getContext(), "mbridge_iv_playend_pic", "id"));
                this.t = (ImageView) inflate.findViewById(k.a(getContext(), "mbridge_iv_play", "id"));
                this.u = (ImageView) inflate.findViewById(k.a(getContext(), "mbridge_iv_pause", "id"));
                this.v = (ImageView) inflate.findViewById(k.a(getContext(), "mbridge_iv_sound", "id"));
                this.x = inflate.findViewById(k.a(getContext(), "mbridge_view_cover", "id"));
                this.w = (ImageView) inflate.findViewById(k.a(getContext(), "mbridge_iv_sound_animation", "id"));
                this.y = (AnimationDrawable) this.w.getDrawable();
                this.y.start();
                d();
                addView(inflate, -1, -1);
            }
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public boolean initPlayerViewData(String str, CampaignEx campaignEx, boolean z2, VideoPlayerStatusListener videoPlayerStatusListener, com.mbridge.msdk.videocommon.download.a aVar, String str2) {
        CampaignEx campaignEx2 = campaignEx;
        try {
            if (TextUtils.isEmpty(str) || campaignEx2 == null) {
                return false;
            }
            this.B = str;
            this.b = z2;
            this.C = campaignEx2;
            this.G = aVar;
            this.A = str2;
            this.H.initParameter(this.C.getVideoUrlEncode(), true, this.j, this.s, videoPlayerStatusListener);
            try {
                if (this.C != null) {
                    String imageUrl = this.C.getImageUrl();
                    if (!x.a(imageUrl)) {
                        if (getContext() != null) {
                            if (com.mbridge.msdk.foundation.same.c.b.a(getContext()).b(imageUrl)) {
                                Bitmap a2 = com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(imageUrl);
                                if (!(this.s == null || a2 == null)) {
                                    this.s.setImageUrl(imageUrl);
                                    this.s.setImageBitmap(a2);
                                    this.s.setVisibility(0);
                                }
                            } else {
                                com.mbridge.msdk.foundation.same.c.b.a(getContext()).a(imageUrl, (c) new c() {
                                    public final void onFailedLoad(String str, String str2) {
                                    }

                                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                                        if (MediaViewPlayerView.this.s != null && bitmap != null) {
                                            MediaViewPlayerView.this.s.setImageUrl(str);
                                            MediaViewPlayerView.this.s.setImageBitmap(bitmap);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                q.d("MediaViewPlayerView", th.getMessage());
            }
            this.a = true;
            return true;
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
            this.a = false;
        }
    }

    public void playVideo() {
        try {
            if (!this.a || this.H == null) {
                return;
            }
            if (!this.g) {
                e();
                return;
            }
            if ((!TextUtils.isEmpty(this.B) && this.B.startsWith("http")) || this.B.startsWith("https")) {
                this.B = m();
            }
            f();
            this.H.play(getContext(), this.B, this.q);
            if (this.f || this.e) {
                this.f = false;
            }
            if (this.k) {
                this.H.openSound();
            } else {
                this.H.closeSound();
            }
            this.c = false;
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public void startOrPlayVideo() {
        try {
            if (!this.g) {
                e();
            } else if (!hasPrepare()) {
                playVideo();
            } else {
                try {
                    if (this.H != null) {
                        f();
                        if (this.i) {
                            this.H.start(this.q);
                            this.i = false;
                        } else {
                            this.H.start();
                        }
                        if (this.f || this.e) {
                            this.f = false;
                        }
                    }
                } catch (Throwable th) {
                    q.a("MediaViewPlayerView", th.getMessage(), th);
                }
            }
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
        }
    }

    public void pause() {
        try {
            if (this.H != null) {
                this.H.pause();
                this.f = true;
            }
            h();
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public void stop() {
        try {
            if (this.H != null) {
                this.H.stop();
            }
            h();
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
        }
    }

    public void release() {
        try {
            if (this.H != null) {
                this.H.releasePlayer();
                this.H = null;
            }
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public boolean hasPrepare() {
        try {
            if (this.H != null) {
                return this.H.hasPrepare();
            }
            return false;
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
            return false;
        }
    }

    public boolean isComplete() {
        try {
            if (this.H != null) {
                return this.H.isComplete();
            }
            return false;
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
            return false;
        }
    }

    public boolean isPlaying() {
        try {
            if (this.H != null) {
                return this.H.isPlaying();
            }
            return false;
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
            return false;
        }
    }

    public void openSound() {
        this.k = true;
        try {
            if (this.H != null) {
                this.v.setImageResource(k.a(getContext(), "mbridge_nativex_sound_open", "drawable"));
                this.H.openSound();
            }
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public void closeSound() {
        this.k = false;
        try {
            if (this.H != null) {
                this.v.setImageResource(k.a(getContext(), "mbridge_nativex_sound_close", "drawable"));
                this.H.closeSound();
            }
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public void setIsFrontDesk(boolean z2) {
        try {
            if (this.H != null) {
                this.H.setIsFrontDesk(z2);
            }
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public boolean halfLoadingViewisVisible() {
        try {
            if (this.H == null || !this.H.loadingViewIsVisible()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
            return false;
        }
    }

    public void setIsComplete(boolean z2) {
        try {
            if (this.H != null) {
                this.H.setIsComplete(z2);
            }
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public void setEnterFullScreen() {
        try {
            q.b("MediaViewPlayerView", "setEnterFullScreen");
            this.d = true;
            this.h = true;
            this.v.setVisibility(0);
            h();
        } catch (Throwable th) {
            q.a("MediaViewPlayerView", th.getMessage(), th);
        }
    }

    public void setExitFullScreen() {
        try {
            this.d = false;
            this.c = false;
            this.v.setVisibility(8);
            g();
            f();
        } catch (Throwable th) {
            q.a("MediaViewPlayerView", th.getMessage(), th);
        }
    }

    public boolean curIsFullScreen() {
        return this.d;
    }

    public void setIsActivePause(boolean z2) {
        this.e = z2;
    }

    public boolean getIsActiviePause() {
        return this.e;
    }

    public Campaign getCampaign() {
        return this.C;
    }

    public void setAllowLoopPlay(boolean z2) {
        this.j = z2;
    }

    public void setOnMediaViewPlayerViewListener(com.mbridge.msdk.nativex.listener.a aVar) {
        this.D = aVar;
    }

    private void d() {
        this.v.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    if (MediaViewPlayerView.this.k) {
                        MediaViewPlayerView.this.closeSound();
                        if (MediaViewPlayerView.this.D != null) {
                            MediaViewPlayerView.this.D.a();
                            return;
                        }
                        return;
                    }
                    MediaViewPlayerView.this.openSound();
                    if (MediaViewPlayerView.this.D != null) {
                        MediaViewPlayerView.this.D.b();
                    }
                } catch (Throwable th) {
                    q.d("MediaViewPlayerView", th.getMessage());
                }
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    MediaViewPlayerView.this.pause();
                    MediaViewPlayerView.this.t.setVisibility(0);
                    MediaViewPlayerView.this.i();
                    MediaViewPlayerView.this.k();
                    if (MediaViewPlayerView.this.D != null) {
                        MediaViewPlayerView.this.D.c();
                    }
                    boolean unused = MediaViewPlayerView.this.e = true;
                } catch (Throwable th) {
                    q.a("MediaViewPlayerView", th.getMessage(), th);
                }
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MediaViewPlayerView.this.onClickPlayButton();
            }
        });
    }

    public void onClickPlayButton() {
        try {
            f();
            j();
            setIsComplete(false);
            if (this.f) {
                this.H.play();
            } else if (!hasPrepare() || this.c) {
                q.b("MediaViewPlayerView", "点击播放 playVideo()");
                playVideo();
            } else {
                q.b("MediaViewPlayerView", "startOrPlayVideo() hasPrepare():" + hasPrepare() + " mIsNeedToRepeatPrepare:" + this.c);
                startOrPlayVideo();
            }
            if (this.e && this.D != null) {
                this.D.d();
            }
            this.e = false;
        } catch (Throwable th) {
            q.a("MediaViewPlayerView", th.getMessage(), th);
        }
    }

    public void onClickPlayerView() {
        try {
            if ((this.s != null && this.s.getVisibility() == 0) || !isPlaying() || this.u == null) {
                return;
            }
            if (this.u.getVisibility() == 0) {
                gonePauseView();
                l();
                return;
            }
            if (this.z != null) {
                this.z.cancel();
            }
            this.z = new AlphaAnimation(0.0f, 1.0f);
            this.z.setDuration(300);
            this.z.setInterpolator(new DecelerateInterpolator());
            this.z.setAnimationListener(new Animation.AnimationListener() {
                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    MediaViewPlayerView.this.u.setVisibility(0);
                    MediaViewPlayerView.g(MediaViewPlayerView.this);
                }
            });
            i();
            this.x.startAnimation(this.z);
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    public void showPlayView() {
        this.t.setVisibility(0);
    }

    public void gonePauseView() {
        Handler handler = F;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        MediaViewPlayerView.this.k();
                        MediaViewPlayerView.this.j();
                    } catch (Exception e) {
                        q.d("MediaViewPlayerView", e.getMessage());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            i();
            k();
            this.r.setVisibility(8);
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    private void f() {
        try {
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            j();
            showProgressView(this.n);
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    private void g() {
        ImageView imageView;
        if (!this.d && (imageView = this.w) != null && imageView.getVisibility() != 0 && this.m) {
            this.w.setVisibility(0);
        }
    }

    private void h() {
        if (this.w.getVisibility() == 0) {
            this.w.setVisibility(8);
        }
    }

    public void showProgressView(boolean z2) {
        this.n = z2;
        ProgressBar progressBar = this.r;
        if (progressBar != null) {
            progressBar.setVisibility(z2 ? 0 : 4);
        }
    }

    public void showSoundIndicator(boolean z2) {
        this.m = z2;
        if (this.m) {
            g();
        } else {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        this.x.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.t.getVisibility() != 0) {
            this.x.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        this.u.setVisibility(8);
    }

    public void onPlayStarted(int i2) {
        if (this.D != null && !TextUtils.isEmpty(this.B)) {
            this.D.a(this.B);
        }
    }

    public void onPlayProgress(int i2, int i3) {
        try {
            f();
            g();
            this.e = false;
            this.c = false;
            this.l = i2;
        } catch (Throwable th) {
            q.a("MediaViewPlayerView", th.getMessage(), th);
        }
    }

    public void onPlayCompleted() {
        if (this.D != null && !TextUtils.isEmpty(this.B)) {
            this.D.b(this.B);
        }
        a aVar = this.I;
        if (aVar != null) {
            aVar.a();
            return;
        }
        try {
            if (!this.j) {
                e();
            }
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
        }
    }

    public void onPlayError(String str) {
        try {
            this.c = true;
            e();
            if (!this.J) {
                this.H.play(getContext(), this.B, this.q);
                this.J = true;
            }
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
        }
    }

    public void onPlaySetDataSourceError(String str) {
        try {
            this.c = true;
            try {
                if (!URLUtil.isNetworkUrl(this.B)) {
                    String videoUrlEncode = this.C.getVideoUrlEncode();
                    if (x.b(videoUrlEncode)) {
                        this.B = videoUrlEncode;
                    }
                }
            } catch (Throwable th) {
                q.d("MediaViewPlayerView", th.getMessage());
            }
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
        }
    }

    private void l() {
        try {
            if (F != null) {
                F.removeCallbacksAndMessages((Object) null);
            }
            if (this.E != null) {
                this.E.cancel();
            }
        } catch (Exception e2) {
            q.d("MediaViewPlayerView", e2.getMessage());
        }
    }

    private String m() {
        String str;
        try {
            if (this.C == null) {
                return null;
            }
            try {
                if (this.G == null) {
                    if (this.C.getAdType() != 287) {
                        if (this.C.getAdType() != 94) {
                            str = this.C.getId() + this.C.getVideoUrlEncode() + this.C.getBidToken();
                            this.G = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.A, str);
                        }
                    }
                    str = this.C.getRequestId() + this.C.getId() + this.C.getVideoUrlEncode();
                    this.G = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.A, str);
                }
            } catch (Exception e2) {
                q.d("MediaViewPlayerView", e2.getMessage());
            }
            if (this.G != null && this.G.f() == 5) {
                String d2 = this.G.d();
                if (new File(d2).exists()) {
                    return d2;
                }
            }
            String videoUrlEncode = this.C.getVideoUrlEncode();
            if (x.b(videoUrlEncode)) {
                return videoUrlEncode;
            }
            return null;
        } catch (Exception e3) {
            q.d("MediaViewPlayerView", e3.getMessage());
        }
    }

    public static class a {
        private MediaViewPlayerView a;

        public a(MediaViewPlayerView mediaViewPlayerView) {
            this.a = mediaViewPlayerView;
        }

        public void a() {
            try {
                if (this.a != null && !this.a.j) {
                    q.b("MediaViewPlayerView", "play end and display endcardView");
                    this.a.e();
                }
            } catch (Exception e) {
                q.d("MediaViewPlayerView", e.getMessage());
            }
        }
    }

    private class b implements TextureView.SurfaceTextureListener {
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        private b() {
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            try {
                Surface unused = MediaViewPlayerView.this.q = new Surface(surfaceTexture);
                boolean unused2 = MediaViewPlayerView.this.g = true;
                boolean unused3 = MediaViewPlayerView.this.i = true;
                if (MediaViewPlayerView.this.d) {
                    if (MediaViewPlayerView.this.h) {
                        boolean unused4 = MediaViewPlayerView.this.c = false;
                        boolean unused5 = MediaViewPlayerView.this.h = false;
                    }
                    if (!MediaViewPlayerView.this.isComplete()) {
                        if (!MediaViewPlayerView.this.e) {
                            MediaViewPlayerView.this.startOrPlayVideo();
                            return;
                        }
                    }
                    MediaViewPlayerView.this.e();
                } else if (MediaViewPlayerView.this.b) {
                    if (MediaViewPlayerView.this.hasPrepare()) {
                        if (MediaViewPlayerView.this.isComplete()) {
                            MediaViewPlayerView.this.e();
                            return;
                        }
                    }
                    MediaViewPlayerView.this.startOrPlayVideo();
                } else {
                    if (MediaViewPlayerView.this.hasPrepare()) {
                        if (!MediaViewPlayerView.this.isComplete()) {
                            MediaViewPlayerView.this.startOrPlayVideo();
                            return;
                        }
                    }
                    MediaViewPlayerView.this.e();
                }
            } catch (Exception e) {
                q.d("MediaViewPlayerView", e.getMessage());
            }
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            q.b("MediaViewPlayerView", "onSurfaceTextureSizeChanged ");
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                if (MediaViewPlayerView.this.H != null && MediaViewPlayerView.this.H.isPlayIng()) {
                    MediaViewPlayerView.this.pause();
                }
                boolean unused = MediaViewPlayerView.this.c = true;
                boolean unused2 = MediaViewPlayerView.this.g = false;
            } catch (Throwable th) {
                q.d("MediaViewPlayerView", th.getMessage());
            }
            return true;
        }
    }

    public void onPlayProgressMS(int i2, int i3) {
        try {
            if (this.r != null && this.r.getVisibility() == 0) {
                if (i3 > 0) {
                    this.r.setMax(i3);
                }
                if (i2 >= 0) {
                    this.r.setProgress(i2 + 1);
                }
            }
        } catch (Throwable th) {
            q.d("MediaViewPlayerView", th.getMessage());
        }
    }

    static /* synthetic */ void g(MediaViewPlayerView mediaViewPlayerView) {
        mediaViewPlayerView.l();
        mediaViewPlayerView.E = new Timer();
        mediaViewPlayerView.E.schedule(new TimerTask() {
            public final void run() {
                try {
                    MediaViewPlayerView.this.gonePauseView();
                } catch (Throwable th) {
                    q.a("MediaViewPlayerView", th.getMessage(), th);
                }
            }
        }, 2000);
    }
}
