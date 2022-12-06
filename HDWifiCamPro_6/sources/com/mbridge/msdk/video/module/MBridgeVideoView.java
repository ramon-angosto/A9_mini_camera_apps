package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.video.dynview.j.c;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.widget.SoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeVideoView extends MBridgeBaseView implements i {
    /* access modifiers changed from: private */
    public static boolean V = false;
    private static int m;
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    /* access modifiers changed from: private */
    public boolean A = false;
    private String B;
    private int C;
    private int D;
    private int E;
    private MBAlertDialog F;
    private com.mbridge.msdk.widget.dialog.a G;
    /* access modifiers changed from: private */
    public String H = "";
    private double I;
    private double J;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    /* access modifiers changed from: private */
    public boolean R = false;
    private boolean S = false;
    private int T;
    /* access modifiers changed from: private */
    public boolean U = false;
    private int W = 2;
    /* access modifiers changed from: private */
    public String aa;
    /* access modifiers changed from: private */
    public int ab;
    private int ac;
    private int ad;
    /* access modifiers changed from: private */
    public boolean ae = false;
    /* access modifiers changed from: private */
    public boolean af = false;
    /* access modifiers changed from: private */
    public boolean ag = false;
    /* access modifiers changed from: private */
    public boolean ah = true;
    /* access modifiers changed from: private */
    public boolean ai = false;
    /* access modifiers changed from: private */
    public boolean aj = false;
    /* access modifiers changed from: private */
    public boolean ak = false;
    /* access modifiers changed from: private */
    public AlphaAnimation al;
    private b am = new b(this);
    private boolean an = false;
    /* access modifiers changed from: private */
    public PlayerView r;
    /* access modifiers changed from: private */
    public SoundImageView s;
    /* access modifiers changed from: private */
    public TextView t;
    /* access modifiers changed from: private */
    public View u;
    /* access modifiers changed from: private */
    public RelativeLayout v;
    /* access modifiers changed from: private */
    public ImageView w;
    /* access modifiers changed from: private */
    public ProgressBar x;
    /* access modifiers changed from: private */
    public FeedBackButton y;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.module.a.a z;

    public void init(Context context) {
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        this.z = aVar;
    }

    public boolean isShowingAlertView() {
        return this.A;
    }

    public void setUnitId(String str) {
        this.H = str;
        b bVar = this.am;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public String getUnitId() {
        return this.H;
    }

    public boolean isMiniCardShowing() {
        return this.N;
    }

    public boolean isShowingTransparent() {
        return this.S;
    }

    public void setShowingTransparent(boolean z2) {
        this.S = z2;
    }

    public MBridgeVideoView(Context context) {
        super(context);
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.i = campaignEx.isDynamicView();
        }
        if (this.i) {
            com.mbridge.msdk.video.dynview.a.a().a(new c().a(this, campaignEx), new com.mbridge.msdk.video.dynview.d.c() {
                public final void a(View view) {
                    if (!(this == null || view == null)) {
                        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                        this.addView(view);
                    }
                    view.setOnClickListener(new com.mbridge.msdk.widget.a() {
                        /* access modifiers changed from: protected */
                        public final void a(View view) {
                            JSONObject jSONObject;
                            JSONException e;
                            if (MBridgeVideoView.this.z != null) {
                                try {
                                    jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(com.mbridge.msdk.foundation.same.a.g, MBridgeVideoView.this.a(0));
                                    } catch (JSONException e2) {
                                        e = e2;
                                    }
                                } catch (JSONException e3) {
                                    JSONException jSONException = e3;
                                    jSONObject = null;
                                    e = jSONException;
                                    e.printStackTrace();
                                    MBridgeVideoView.this.z.a(105, jSONObject);
                                    com.mbridge.msdk.video.module.b.a.d(com.mbridge.msdk.foundation.controller.a.e().g(), MBridgeVideoView.this.b);
                                }
                                MBridgeVideoView.this.z.a(105, jSONObject);
                                com.mbridge.msdk.video.module.b.a.d(com.mbridge.msdk.foundation.controller.a.e().g(), MBridgeVideoView.this.b);
                            }
                        }
                    });
                    MBridgeVideoView.this.a();
                    boolean unused = MBridgeVideoView.V = false;
                }

                public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                    q.d(MBridgeBaseView.TAG, "errorMsg：" + aVar.b());
                }
            });
            return;
        }
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.c.inflate(findLayout, this);
            a();
        }
        V = false;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f = e();
        if (!this.f) {
            q.d(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        c();
        this.al = new AlphaAnimation(0.0f, 100.0f);
        this.al.setDuration(200);
    }

    public void setIsIV(boolean z2) {
        this.U = z2;
        b bVar = this.am;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public void setCampaign(CampaignEx campaignEx) {
        int i;
        super.setCampaign(campaignEx);
        b bVar = this.am;
        if (bVar != null) {
            bVar.a(campaignEx);
            b bVar2 = this.am;
            if (campaignEx == null) {
                i = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.H, false).p();
            } else if (campaignEx.getReady_rate() != -1) {
                i = campaignEx.getReady_rate();
            } else {
                i = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.H, false).p();
            }
            bVar2.a(i, com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.H, false).q());
        }
    }

    public void setSoundState(int i) {
        this.W = i;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f) {
            if (!this.i) {
                this.r.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        MBridgeVideoView.this.e.a(1, "");
                    }
                });
            }
            this.s.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int i = 2;
                    if (MBridgeVideoView.this.r.isSilent()) {
                        i = 1;
                    }
                    MBridgeVideoView.this.e.a(5, i);
                }
            });
            this.u.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeVideoView.this.U) {
                        boolean unused = MBridgeVideoView.this.ak = true;
                        if (!MBridgeVideoView.this.ah) {
                            MBridgeVideoView.this.e.a(123, "");
                        } else {
                            MBridgeVideoView.this.b();
                        }
                    } else {
                        MBridgeVideoView.this.b();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        try {
            if (this.U) {
                if (this.ab == com.mbridge.msdk.foundation.same.a.n || this.ab == com.mbridge.msdk.foundation.same.a.o) {
                    if (this.ae) {
                        if (this.ab == com.mbridge.msdk.foundation.same.a.o) {
                            this.e.a(2, b(this.ai));
                            return;
                        }
                        return;
                    } else if (this.ab == com.mbridge.msdk.foundation.same.a.o && this.ak) {
                        this.e.a(2, b(this.ai));
                        return;
                    } else if (this.ah) {
                        int curPosition = this.r.getCurPosition() / 1000;
                        int videoLength = (int) ((((float) curPosition) / ((float) (this.r.getDuration() == 0 ? this.b.getVideoLength() : this.r.getDuration()))) * 100.0f);
                        if (this.ab == com.mbridge.msdk.foundation.same.a.n) {
                            f();
                            if (this.ac == com.mbridge.msdk.foundation.same.a.p && videoLength >= this.ad) {
                                this.e.a(2, b(this.ai));
                                return;
                            } else if (this.ac != com.mbridge.msdk.foundation.same.a.q || curPosition < this.ad) {
                                this.e.a(8, "");
                            } else {
                                this.e.a(2, b(this.ai));
                                return;
                            }
                        }
                        if (this.ab != com.mbridge.msdk.foundation.same.a.o) {
                            return;
                        }
                        if (this.ac == com.mbridge.msdk.foundation.same.a.p && videoLength >= this.ad) {
                            f();
                            this.e.a(8, "");
                            return;
                        } else if (this.ac == com.mbridge.msdk.foundation.same.a.q && curPosition >= this.ad) {
                            f();
                            this.e.a(8, "");
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            if (this.b == null || this.b.getAdSpaceT() == 2) {
                this.e.a(2, "");
                return;
            }
            int videoCompleteTime = this.b.getVideoCompleteTime();
            if (!((videoCompleteTime > 0 && this.r.getCurPosition() / 1000 < videoCompleteTime) || videoCompleteTime == 0) || this.E != 1 || this.S) {
                this.e.a(2, "");
                return;
            }
            f();
            this.e.a(8, "");
        } catch (Exception e) {
            q.d(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public void hideAlertView(int i) {
        if (this.A) {
            this.A = false;
            this.ae = true;
            setShowingAlertViewCover(this.A);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.H, false);
            d.a(this.a, this.b, com.mbridge.msdk.videocommon.d.c.a, this.H, 1, i);
            if (i == 0) {
                g();
                if (!this.U) {
                    return;
                }
                if (this.ab == com.mbridge.msdk.foundation.same.a.o || this.ab == com.mbridge.msdk.foundation.same.a.n) {
                    this.af = true;
                    this.e.a(124, "");
                    this.aj = true;
                    gonePlayingCloseView();
                    return;
                }
                return;
            }
            this.ag = true;
            if (this.U && this.ab == com.mbridge.msdk.foundation.same.a.o) {
                g();
            } else if (!this.U || this.ab != com.mbridge.msdk.foundation.same.a.n) {
                this.e.a(2, "");
            } else {
                this.e.a(2, b(this.ai));
            }
        }
    }

    public void alertWebViewShowed() {
        this.A = true;
        setShowingAlertViewCover(this.A);
    }

    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.F;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        this.e.a(125, "");
    }

    public void showAlertView() {
        if (!this.N) {
            if (this.G == null) {
                this.G = new com.mbridge.msdk.widget.dialog.a() {
                    public final void a() {
                        boolean unused = MBridgeVideoView.this.A = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.A);
                        if (MBridgeVideoView.this.U && (MBridgeVideoView.this.ab == com.mbridge.msdk.foundation.same.a.o || MBridgeVideoView.this.ab == com.mbridge.msdk.foundation.same.a.n)) {
                            boolean unused2 = MBridgeVideoView.this.af = true;
                            MBridgeVideoView.this.e.a(124, "");
                            boolean unused3 = MBridgeVideoView.this.aj = true;
                            MBridgeVideoView.this.gonePlayingCloseView();
                        }
                        MBridgeVideoView.this.g();
                        d.a(MBridgeVideoView.this.a, MBridgeVideoView.this.b, MBridgeVideoView.this.aa, MBridgeVideoView.this.H, 1, 0);
                    }

                    public final void b() {
                        boolean unused = MBridgeVideoView.this.A = false;
                        boolean unused2 = MBridgeVideoView.this.ag = true;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.A);
                        d.a(MBridgeVideoView.this.a, MBridgeVideoView.this.b, MBridgeVideoView.this.aa, MBridgeVideoView.this.H, 1, 1);
                        if (MBridgeVideoView.this.U && MBridgeVideoView.this.ab == com.mbridge.msdk.foundation.same.a.n) {
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.e;
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            aVar.a(2, mBridgeVideoView2.b(mBridgeVideoView2.ai));
                        } else if (!MBridgeVideoView.this.U || MBridgeVideoView.this.ab != com.mbridge.msdk.foundation.same.a.o) {
                            MBridgeVideoView.this.e.a(2, "");
                        } else {
                            MBridgeVideoView.this.g();
                        }
                    }
                };
            }
            if (this.F == null) {
                this.F = new MBAlertDialog(getContext(), this.G);
            }
            if (this.U) {
                this.F.makeIVAlertView(this.ab, this.H);
            } else {
                this.F.makeRVAlertView(this.H);
            }
            PlayerView playerView = this.r;
            if (playerView != null && !playerView.isComplete()) {
                this.F.show();
                this.ae = true;
                this.A = true;
                setShowingAlertViewCover(this.A);
                com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.H, false);
                this.aa = com.mbridge.msdk.videocommon.d.c.a;
                d.a(this.a, this.b, this.aa, this.H, 1);
            }
        }
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        if (this.f && !TextUtils.isEmpty(this.B) && this.b != null) {
            if (this.b != null && x.b(this.b.getVideoResolution())) {
                String videoResolution = this.b.getVideoResolution();
                q.b(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
                String[] split = videoResolution.split("x");
                if (split.length == 2) {
                    if (u.b(split[0]) > 0.0d) {
                        this.I = u.b(split[0]);
                    }
                    if (u.b(split[1]) > 0.0d) {
                        this.J = u.b(split[1]);
                    }
                    q.b(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.I + "  mVideoH:" + this.J);
                }
                if (this.I <= 0.0d) {
                    this.I = 1280.0d;
                }
                if (this.J <= 0.0d) {
                    this.J = 720.0d;
                }
            }
            this.r.initBufferIngParam(this.D);
            this.r.initVFPData(this.B, this.b.getVideoUrlEncode(), this.am);
            soundOperate(this.W, -1, (String) null);
        }
        V = false;
    }

    public void defaultShow() {
        super.defaultShow();
        this.K = true;
        showVideoLocation(0, 0, u.h(this.a), u.g(this.a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.C == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    public void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        q.b(MBridgeBaseView.TAG, "showVideoLocation marginTop:" + i + " marginLeft:" + i2 + " width:" + i3 + "  height:" + i4 + " radius:" + i5 + " borderTop:" + i6 + " borderLeft:" + i7 + " borderWidth:" + i8 + " borderHeight:" + i9);
        if (this.f) {
            this.v.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.v.getVisibility() != 0) {
                this.v.setVisibility(0);
            }
            if (this.t.getVisibility() == 0) {
                j();
            }
            if (!(i3 > 0 && i4 > 0 && u.h(this.a) >= i3 && u.g(this.a) >= i4) || this.K) {
                h();
                return;
            }
            n = i6;
            o = i7;
            p = i8 + 4;
            q = i9 + 4;
            float f = ((float) i3) / ((float) i4);
            float f2 = 0.0f;
            try {
                f2 = (float) (this.I / this.J);
            } catch (Throwable th) {
                q.a(MBridgeBaseView.TAG, th.getMessage(), th);
            }
            if (i5 > 0) {
                m = i5;
                if (i5 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius((float) u.b(getContext(), (float) i5));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    if (Build.VERSION.SDK_INT >= 16) {
                        setBackground(gradientDrawable);
                        this.r.setBackground(gradientDrawable);
                    } else {
                        setBackgroundDrawable(gradientDrawable);
                        this.r.setBackgroundDrawable(gradientDrawable);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        setClipToOutline(true);
                        this.r.setClipToOutline(true);
                    }
                }
            }
            if (Math.abs(f - f2) <= 0.1f || this.T == 1) {
                h();
                if (this.S) {
                    setLayoutCenter(i3, i4);
                    if (V) {
                        this.e.a(114, "");
                    } else {
                        this.e.a(116, "");
                    }
                } else {
                    setLayoutParam(i2, i, i3, i4);
                }
            } else {
                h();
                videoOperate(1);
            }
        }
    }

    public void soundOperate(int i, int i2) {
        soundOperate(i, i2, "2");
    }

    public void soundOperate(int i, int i2, String str) {
        if (this.f) {
            this.W = i;
            if (i == 1) {
                this.s.setSoundStatus(false);
                this.r.closeSound();
            } else if (i == 2) {
                this.s.setSoundStatus(true);
                this.r.openSound();
            }
            if (this.b != null && this.b.isDynamicView()) {
                this.s.setVisibility(0);
            } else if (i2 == 1) {
                this.s.setVisibility(8);
            } else if (i2 == 2) {
                this.s.setVisibility(0);
            }
        }
        if (str != null && str.equals("2")) {
            this.e.a(7, Integer.valueOf(i));
        }
    }

    public void videoOperate(int i) {
        q.a(MBridgeBaseView.TAG, "VideoView videoOperate:" + i);
        if (!this.f) {
            return;
        }
        if (i == 1) {
            if (getVisibility() == 0 && isfront()) {
                q.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                if (!this.A && !com.mbridge.msdk.foundation.b.b.c) {
                    g();
                }
            }
        } else if (i == 2) {
            if (getVisibility() == 0 && isfront()) {
                q.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                f();
            }
        } else if (i == 3 && !this.M) {
            this.r.release();
            this.M = true;
        }
    }

    public void closeVideoOperate(int i, int i2) {
        if (i == 1) {
            this.ak = true;
            if (getVisibility() == 0) {
                b();
            }
        }
        if (i2 == 1) {
            gonePlayingCloseView();
        } else if (i2 != 2) {
        } else {
            if ((!this.aj || getVisibility() != 0) && this.f && this.u.getVisibility() != 0) {
                this.u.setVisibility(0);
                this.O = true;
            }
        }
    }

    public void progressBarOperate(int i) {
        ProgressBar progressBar;
        if (!this.f) {
            return;
        }
        if (i == 1) {
            ProgressBar progressBar2 = this.x;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        } else if (i == 2 && (progressBar = this.x) != null) {
            progressBar.setVisibility(0);
        }
    }

    public void progressOperate(int i, int i2) {
        if (this.f) {
            q.b(MBridgeBaseView.TAG, "progressOperate progress:" + i);
            int videoLength = this.b != null ? this.b.getVideoLength() : 0;
            if (i > 0 && i <= videoLength && this.r != null) {
                q.b(MBridgeBaseView.TAG, "progressOperate progress:" + i);
                this.r.seekTo(i * 1000);
            }
            if (i2 == 1) {
                this.t.setVisibility(8);
            } else if (i2 == 2) {
                this.t.setVisibility(0);
            }
            if (this.t.getVisibility() == 0) {
                j();
            }
        }
    }

    public String getCurrentProgress() {
        try {
            int a2 = this.am.a();
            int i = 0;
            if (this.b != null) {
                i = this.b.getVideoLength();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, a(a2, i));
            jSONObject.put("time", a2);
            jSONObject.put(IronSourceConstants.EVENTS_DURATION, i + "");
            return jSONObject.toString();
        } catch (Throwable th) {
            q.a(MBridgeBaseView.TAG, th.getMessage(), th);
            return "{}";
        }
    }

    public void setScaleFitXY(int i) {
        this.T = i;
    }

    public void setVisible(int i) {
        setVisibility(i);
    }

    public void setCover(boolean z2) {
        if (this.f) {
            this.r.setIsCovered(z2);
        }
    }

    public void setMiniEndCardState(boolean z2) {
        this.N = z2;
    }

    public void setShowingAlertViewCover(boolean z2) {
        this.r.setIsCovered(z2);
    }

    public boolean isH5Canvas() {
        return getLayoutParams().height < u.g(this.a.getApplicationContext());
    }

    public int getBorderViewHeight() {
        return q;
    }

    public int getBorderViewWidth() {
        return p;
    }

    public int getBorderViewLeft() {
        return o;
    }

    public int getBorderViewTop() {
        return n;
    }

    public int getBorderViewRadius() {
        return m;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.b == null || !this.b.isDynamicView()) && this.f && this.K) {
            h();
        }
    }

    private String a(int i, int i2) {
        if (i2 != 0) {
            double d = (double) (((float) i) / ((float) i2));
            try {
                return u.a(Double.valueOf(d)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i2 + "";
    }

    public int getCloseAlert() {
        return this.E;
    }

    public void setCloseAlert(int i) {
        this.E = i;
    }

    public int getVideoSkipTime() {
        return this.C;
    }

    public void setVideoSkipTime(int i) {
        this.C = i;
    }

    public void setPlayURL(String str) {
        this.B = str;
    }

    public void setBufferTimeout(int i) {
        this.D = i;
    }

    private boolean e() {
        try {
            this.r = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.s = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.t = (TextView) findViewById(findID("mbridge_tv_count"));
            this.u = findViewById(findID("mbridge_rl_playing_close"));
            this.u.setVisibility(4);
            this.v = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.w = (ImageView) findViewById(findID("mbridge_videoview_bg"));
            this.x = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.y = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            return isNotNULL(this.r, this.s, this.t, this.u);
        } catch (Throwable th) {
            q.a(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i = indexOfChild + 1;
        boolean z2 = false;
        while (i <= childCount - 1) {
            if (viewGroup.getChildAt(i).getVisibility() == 0 && this.N) {
                return false;
            }
            i++;
            z2 = true;
        }
        return z2;
    }

    private void f() {
        try {
            if (this.r != null) {
                this.r.onPause();
                if (this.b != null && this.b.getNativeVideoTracking() != null && !this.b.isHasReportAdTrackPause()) {
                    this.b.setHasReportAdTrackPause(true);
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b, this.H, this.b.getNativeVideoTracking().f(), false, false);
                }
            }
        } catch (Throwable th) {
            q.a(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        try {
            if (!this.L) {
                boolean playVideo = this.r.playVideo();
                if (!(this.b == null || this.b.getPlayable_ads_without_video() == 2 || playVideo || this.am == null)) {
                    this.am.onPlayError("play video failed");
                }
                this.L = true;
                return;
            }
            this.r.onResume();
        } catch (Exception e) {
            q.a(MBridgeBaseView.TAG, e.getMessage(), e);
        }
    }

    public void gonePlayingCloseView() {
        if (this.f && this.u.getVisibility() != 8) {
            this.u.setVisibility(8);
            this.O = false;
        }
        if (!this.an && !this.R && !this.P) {
            this.an = true;
            int i = this.C;
            if (i >= 0) {
                if (i == 0) {
                    this.R = true;
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            boolean unused = MBridgeVideoView.this.R = true;
                        }
                    }, (long) (this.C * 1000));
                }
            }
        }
    }

    private void h() {
        float f;
        float h = (float) u.h(this.a);
        float g = (float) u.g(this.a);
        int b2 = u.b(getContext(), 58.0f);
        int b3 = u.b(getContext(), 104.0f);
        if (this.b != null && this.b.getAdSpaceT() == 2) {
            int c = this.b.getRewardTemplateMode().c();
            if (c == 1) {
                h -= (float) (b2 * 2);
                g -= (float) (b3 * 2);
            }
            if (c == 2) {
                h -= (float) (b3 * 2);
                g -= (float) (b2 * 2);
            }
            if (c == 0) {
                if (this.d == 1) {
                    h -= (float) (b2 * 2);
                    f = (float) (b3 * 2);
                } else {
                    h -= (float) (b3 * 2);
                    f = (float) (b2 * 2);
                }
                g -= f;
            }
        }
        double d = this.I;
        if (d > 0.0d) {
            double d2 = this.J;
            if (d2 > 0.0d && h > 0.0f && g > 0.0f) {
                double d3 = d / d2;
                double d4 = (double) (h / g);
                q.b(MBridgeBaseView.TAG, "videoWHDivide:" + d3 + "  screenWHDivide:" + d4);
                double a2 = u.a(Double.valueOf(d3));
                double a3 = u.a(Double.valueOf(d4));
                q.b(MBridgeBaseView.TAG, "videoWHDivideFinal:" + a2 + "  screenWHDivideFinal:" + a3);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
                if (a2 > a3) {
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((((double) h) * this.J) / this.I);
                    layoutParams.gravity = 17;
                } else if (a2 < a3) {
                    layoutParams.width = (int) (((double) g) * d3);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    if (this.b != null && this.b.isDynamicView()) {
                        int b4 = this.b.getRewardTemplateMode().b();
                        int c2 = this.b.getRewardTemplateMode().c();
                        if (b4 == 102 || b4 == 202) {
                            if (c2 == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                layoutParams.height = (int) (this.J / (this.I / ((double) h)));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                layoutParams.width = (int) (((double) g) * d3);
                            }
                        }
                        if (b4 == 202 && !TextUtils.isEmpty(this.b.getImageUrl())) {
                            a(this.b.getImageUrl());
                        }
                        if (b4 == 302 || b4 == 802) {
                            if (this.I / this.J > 1.0d) {
                                layoutParams.width = -1;
                                layoutParams.height = (int) ((this.J * ((double) h)) / this.I);
                            } else {
                                int b5 = u.b(getContext(), 220.0f);
                                layoutParams.width = (int) ((this.I * ((double) b5)) / this.J);
                                layoutParams.height = b5;
                            }
                        }
                    }
                } catch (Throwable th) {
                    q.d(MBridgeBaseView.TAG, th.getMessage());
                }
                this.r.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        i();
    }

    private void i() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (!isLandscape() && this.f) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
                int h = u.h(this.a);
                layoutParams.width = -1;
                layoutParams.height = (h * 9) / 16;
                layoutParams.gravity = 17;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static final class b extends DefaultVideoPlayerStatusListener {
        private MBridgeVideoView a;
        private int b;
        private int c;
        private boolean d;
        private a e = new a();
        private boolean f = false;
        private boolean g = false;
        private boolean h = false;
        private boolean i;
        private String j;
        private CampaignEx k;
        private int l;
        private int m;
        private boolean n = false;

        public final void a(CampaignEx campaignEx) {
            this.k = campaignEx;
        }

        public final void a(boolean z) {
            this.i = z;
        }

        public final void a(String str) {
            this.j = str;
        }

        public final int a() {
            return this.b;
        }

        public final void a(int i2, int i3) {
            this.l = i2;
            this.m = i3;
        }

        public b(MBridgeVideoView mBridgeVideoView) {
            this.a = mBridgeVideoView;
        }

        public final void onPlayStarted(int i2) {
            super.onPlayStarted(i2);
            if (!this.d) {
                this.a.e.a(10, this.e);
                this.d = true;
            }
            CampaignEx campaignEx = this.k;
            if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
                this.a.t.setBackgroundResource(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_shape_progress", "drawable"));
            } else {
                this.a.t.setBackgroundResource(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                if (!this.k.isDynamicView()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 30.0f));
                    int b2 = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 5.0f);
                    layoutParams.addRule(1, k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_native_endcard_feed_btn", "id"));
                    layoutParams.setMargins(b2, 0, 0, 0);
                    this.a.t.setPadding(b2, 0, b2, 0);
                    this.a.t.setLayoutParams(layoutParams);
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.t.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = -2;
                        layoutParams2.height = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 25.0f);
                        this.a.t.setLayoutParams(layoutParams2);
                    }
                    int b3 = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 5.0f);
                    this.a.t.setPadding(b3, 0, b3, 0);
                }
            }
            if (this.a.x != null) {
                this.a.x.setMax(i2);
            }
            CampaignEx campaignEx2 = this.k;
            if (campaignEx2 != null && campaignEx2.getAdSpaceT() == 2) {
                this.a.v.setVisibility(0);
            }
            if (this.a.t.getVisibility() == 0) {
                this.a.j();
            }
            boolean unused = MBridgeVideoView.V = false;
        }

        public final void onPlayCompleted() {
            super.onPlayCompleted();
            boolean unused = this.a.ai = true;
            CampaignEx campaignEx = this.k;
            if (campaignEx != null) {
                if (campaignEx.getVideoCompleteTime() > 0) {
                    this.a.t.setText(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_video_view_reward_time_complete", "string"));
                } else {
                    this.a.t.setText(MBridgeConstans.ENDCARD_URL_TYPE_PL);
                }
                if (this.k.getAdSpaceT() == 2) {
                    this.a.u.setVisibility(4);
                    if (this.a.y != null) {
                        this.a.y.setClickable(false);
                    }
                    this.a.s.setClickable(false);
                }
            } else {
                this.a.t.setText(MBridgeConstans.ENDCARD_URL_TYPE_PL);
            }
            this.a.r.setClickable(false);
            String f2 = this.a.b(true);
            this.a.e.a(121, "");
            this.a.e.a(11, f2);
            this.b = this.c;
            boolean unused2 = MBridgeVideoView.V = true;
        }

        public final void onPlayError(String str) {
            q.d("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            this.a.e.a(12, str);
        }

        public final void onPlayProgress(int i2, int i3) {
            int i4;
            String str;
            String str2;
            String str3;
            StringBuilder sb;
            super.onPlayProgress(i2, i3);
            if (this.a.f) {
                int i5 = 0;
                CampaignEx campaignEx = this.k;
                if (campaignEx != null) {
                    i5 = campaignEx.getVideoCompleteTime();
                    com.mbridge.msdk.foundation.b.b.a().b(this.k.getCampaignUnitId() + "_" + 1, i2);
                }
                if (i5 > i3) {
                    i5 = i3;
                }
                int i6 = i5 <= 0 ? i3 - i2 : i5 - i2;
                if (i6 > 0) {
                    if (i5 <= 0) {
                        sb = new StringBuilder();
                        sb.append(i6);
                        str3 = "";
                    } else {
                        sb = new StringBuilder();
                        sb.append(i6);
                        str3 = (String) this.a.getContext().getResources().getText(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_video_view_reward_time_left", "string"));
                    }
                    sb.append(str3);
                    str2 = sb.toString();
                } else if (i5 <= 0) {
                    str2 = MBridgeConstans.ENDCARD_URL_TYPE_PL;
                } else {
                    str2 = (String) this.a.getContext().getResources().getText(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_video_view_reward_time_complete", "string"));
                }
                this.a.t.setText(str2);
                if (this.a.x != null && this.a.x.getVisibility() == 0) {
                    this.a.x.setProgress(i2);
                }
            }
            this.c = i3;
            a aVar = this.e;
            aVar.a = i2;
            aVar.b = i3;
            aVar.c = this.a.aj;
            this.b = i2;
            this.a.e.a(15, this.e);
            if (this.a.U && !this.a.ae && this.a.ab == com.mbridge.msdk.foundation.same.a.o) {
                this.a.b();
            }
            int i7 = this.l;
            if (i7 != 100 && !this.n && i7 != 0) {
                if (this.m > i7) {
                    this.m = i7 / 2;
                }
                int i8 = this.m;
                if (i8 >= 0 && i2 >= (i4 = (i3 * i8) / 100)) {
                    if (this.k.getAdType() == 94 || this.k.getAdType() == 287) {
                        str = this.k.getRequestId() + this.k.getId() + this.k.getVideoUrlEncode();
                    } else {
                        str = this.k.getId() + this.k.getVideoUrlEncode() + this.k.getBidToken();
                    }
                    com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.j, str);
                    if (a2 != null) {
                        a2.j();
                        this.n = true;
                        q.d("DefaultVideoPlayerStatusListener", "CDRate is : " + i4 + " and start download !");
                    }
                }
            }
        }

        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                this.a.e.a(13, "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                this.a.e.a(14, "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        public final void b() {
            this.a = null;
            boolean unused = MBridgeVideoView.V = false;
        }
    }

    public static class a {
        public int a;
        public int b;
        public boolean c;

        public final String toString() {
            return "ProgressData{curPlayPosition=" + this.a + ", allDuration=" + this.b + '}';
        }
    }

    public void onBackPress() {
        if (!this.N && !this.A && !this.af) {
            if (this.O) {
                b();
            } else if (this.P && this.Q) {
                b();
            } else if (!this.P && this.R) {
                b();
            }
        }
    }

    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.P = true;
            this.R = false;
        } else if (i == 1) {
            this.Q = true;
        }
    }

    public void showIVRewardAlertView(String str) {
        this.e.a(8, "");
    }

    public void notifyVideoClose() {
        this.e.a(2, "");
    }

    public int getMute() {
        return this.W;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.ab = i;
        this.ac = i2;
        this.ad = i3;
    }

    public void setDialogRole(int i) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        this.ah = z2;
        q.d(MBridgeBaseView.TAG, i + " " + this.ah);
    }

    /* access modifiers changed from: private */
    public String b(boolean z2) {
        if (!this.U) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.ae) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.r);
            }
            if (this.ag) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.t);
            }
            if (this.af) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.s);
            }
            jSONObject.put("complete_info", z2 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            q.d(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("NOTCH VideoView ");
        boolean z2 = false;
        sb.append(String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        q.d(MBridgeBaseView.TAG, sb.toString());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (Math.max(Math.max(layoutParams.leftMargin, layoutParams.rightMargin), Math.max(layoutParams.topMargin, layoutParams.bottomMargin)) > Math.max(Math.max(i, i2), Math.max(i3, i4))) {
            z2 = true;
        }
        if (!z2) {
            final int i5 = i;
            final int i6 = i3;
            final int i7 = i2;
            final int i8 = i4;
            this.v.postDelayed(new Runnable() {
                public final void run() {
                    if (!(MBridgeVideoView.this.b == null || MBridgeVideoView.this.b.isDynamicView() || MBridgeVideoView.this.b.getAdSpaceT() == 2)) {
                        MBridgeVideoView.this.v.setPadding(i5, i6, i7, i8);
                        MBridgeVideoView.this.v.startAnimation(MBridgeVideoView.this.al);
                    }
                    MBridgeVideoView.this.v.setVisibility(0);
                }
            }, 200);
        }
        if (this.t.getVisibility() == 0) {
            j();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (com.mbridge.msdk.foundation.b.b.a().b()) {
            com.mbridge.msdk.foundation.b.b a2 = com.mbridge.msdk.foundation.b.b.a();
            a2.a(this.H + "_" + 1, this.b);
            com.mbridge.msdk.foundation.b.b a3 = com.mbridge.msdk.foundation.b.b.a();
            a3.a(this.H + "_" + 1, this.y);
            return;
        }
        FeedBackButton feedBackButton = this.y;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    private void a(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(str, (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                if (bitmap != null) {
                    try {
                        if (!bitmap.isRecycled() && MBridgeVideoView.this.w != null) {
                            MBridgeVideoView.this.w.setVisibility(0);
                            MBridgeVideoView.this.w.setImageBitmap(com.mbridge.msdk.video.dynview.i.a.a().a(bitmap, 20));
                        }
                    } catch (Throwable th) {
                        q.d(MBridgeBaseView.TAG, th.getMessage());
                    }
                }
            }

            public final void onFailedLoad(String str, String str2) {
                q.d(MBridgeBaseView.TAG, str);
            }
        });
    }

    public void releasePlayer() {
        try {
            if (this.r != null && !this.M) {
                this.r.release();
            }
            if (this.am != null) {
                this.am.b();
            }
            if (this.z != null) {
                this.z = null;
            }
        } catch (Exception e) {
            q.d(MBridgeBaseView.TAG, e.getMessage());
        }
    }
}
