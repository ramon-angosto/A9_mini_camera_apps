package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerErrorConstant;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.c;
import com.mbridge.msdk.video.widget.SoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import org.json.JSONObject;

public class MBridgeBTVideoView extends BTBaseView {
    /* access modifiers changed from: private */
    public static boolean G = false;
    /* access modifiers changed from: private */
    public int A = 2;
    private int B;
    private boolean C = false;
    private int D = 2;
    private int E = 1;
    private String F;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private RelativeLayout K;
    /* access modifiers changed from: private */
    public ProgressBar L;
    /* access modifiers changed from: private */
    public PlayerView p;
    private SoundImageView q;
    /* access modifiers changed from: private */
    public TextView r;
    private View s;
    private FeedBackButton t;
    /* access modifiers changed from: private */
    public WebView u;
    private com.mbridge.msdk.videocommon.download.a v;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private a z;

    public void setCreateWebView(WebView webView) {
        this.u = webView;
    }

    public void setOrientation(int i) {
        this.E = i;
    }

    public MBridgeBTVideoView(Context context) {
        super(context);
    }

    public MBridgeBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
            this.r.setBackgroundResource(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_shape_progress", "drawable"));
            this.r.setWidth(u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 30.0f));
            return;
        }
        this.r.setBackgroundResource(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 30.0f));
        int b = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 5.0f);
        layoutParams.setMargins(b, 0, 0, 0);
        this.r.setPadding(b, 0, b, 0);
        this.r.setLayoutParams(layoutParams);
    }

    public void soundOperate(int i, int i2, String str) {
        if (this.h) {
            this.A = i;
            if (i == 1) {
                this.q.setSoundStatus(false);
                this.p.closeSound();
            } else if (i == 2) {
                this.q.setSoundStatus(true);
                this.p.openSound();
            }
            if (i2 == 1) {
                this.q.setVisibility(8);
            } else if (i2 == 2) {
                this.q.setVisibility(0);
            }
        }
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.f.inflate(findLayout, this);
            this.h = b();
            if (!this.h) {
                q.d(BTBaseView.TAG, "MBridgeVideoView init fail");
            }
            a();
        }
        G = false;
    }

    public void onResume() {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setIsCovered(false);
            this.p.setDesk(true);
            if (this.I) {
                this.p.start(true);
            }
        }
    }

    public void onPause() {
        PlayerView playerView = this.p;
        if (playerView != null) {
            this.I = playerView.isPlayIng();
            this.p.setIsBTVideoPlaying(this.I);
            this.p.onPause();
        }
    }

    public void onStop() {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.J) {
            this.D = c.a().d(this.c);
        }
        View view = this.s;
        int i = 8;
        if (view != null) {
            view.setVisibility(this.x == 0 ? 8 : 0);
        }
        SoundImageView soundImageView = this.q;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.y == 0 ? 8 : 0);
        }
        TextView textView = this.r;
        if (textView != null) {
            if (this.w != 0) {
                i = 0;
            }
            textView.setVisibility(i);
            if (this.r.getVisibility() == 0 && b.a().b()) {
                b.a().a(this.c + "_" + 1, this.b);
                b.a().a(this.c + "_" + 1, this.t);
            }
        }
    }

    public boolean playMute() {
        try {
            if (!(this.p == null || this.u == null)) {
                this.p.closeSound();
                this.q.setSoundStatus(false);
                this.A = 1;
                a(this.u, "onPlayerMute", this.d);
                return true;
            }
        } catch (Exception e) {
            q.d(BTBaseView.TAG, e.getMessage());
        }
        return false;
    }

    public int getMute() {
        return this.A;
    }

    public boolean playUnMute() {
        try {
            if (this.p == null || this.u == null) {
                return false;
            }
            this.p.openSound();
            this.q.setSoundStatus(true);
            this.A = 2;
            a(this.u, "onUnmute", this.d);
            return true;
        } catch (Exception e) {
            q.d(BTBaseView.TAG, e.getMessage());
            return false;
        }
    }

    public void play() {
        try {
            if (!this.J) {
                this.F = c();
                this.p.initVFPData(this.F, this.b.getVideoUrlEncode(), this.z);
                if (this.D == 1) {
                    playMute();
                } else {
                    playUnMute();
                }
                if (!this.p.playVideo() && this.z != null) {
                    this.z.onPlayError("play video failed");
                }
                this.J = true;
            } else if (this.C) {
                this.p.playVideo(0);
                this.C = false;
            } else {
                this.p.start(false);
            }
        } catch (Exception e) {
            q.a(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public void resume() {
        try {
            if (this.p != null) {
                if (this.C) {
                    this.p.playVideo(0);
                    this.C = false;
                } else {
                    this.p.onResume();
                }
                if (this.u != null) {
                    a(this.u, "onPlayerResume", this.d);
                }
            }
        } catch (Exception e) {
            q.d(BTBaseView.TAG, e.getMessage());
        }
    }

    public void pause() {
        try {
            if (this.p != null) {
                this.p.pause();
                if (this.u != null) {
                    a(this.u, "onPlayerPause", this.d);
                }
            }
        } catch (Exception e) {
            q.a(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public void stop() {
        try {
            if (this.p != null) {
                this.p.pause();
                this.p.stop();
                this.C = true;
                if (this.u != null) {
                    a(this.u, "onPlayerStop", this.d);
                }
            }
        } catch (Exception e) {
            q.a(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public void onDestory() {
        try {
            if (this.p != null) {
                this.p.setOnClickListener((View.OnClickListener) null);
                this.p.release();
                this.p = null;
            }
            if (this.q != null) {
                this.q.setOnClickListener((View.OnClickListener) null);
            }
            if (this.s != null) {
                this.s.setOnClickListener((View.OnClickListener) null);
            }
            if (this.u != null) {
                this.u = null;
            }
            setOnClickListener((View.OnClickListener) null);
        } catch (Throwable th) {
            q.a(BTBaseView.TAG, th.getMessage());
        }
    }

    private boolean b() {
        try {
            this.p = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.q = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.r = (TextView) findViewById(findID("mbridge_tv_count"));
            this.s = findViewById(findID("mbridge_rl_playing_close"));
            this.K = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.L = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.t = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.p.setIsBTVideo(true);
            return isNotNULL(this.p, this.q, this.r, this.s);
        } catch (Throwable th) {
            q.a(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private String c() {
        try {
            String videoUrlEncode = this.b.getVideoUrlEncode();
            if (this.v == null) {
                return videoUrlEncode;
            }
            String d = this.v.d();
            if (x.a(d) || !new File(d).exists()) {
                return videoUrlEncode;
            }
            return d;
        } catch (Throwable th) {
            q.a(BTBaseView.TAG, th.getMessage(), th);
            return "";
        }
    }

    private int d() {
        int i = 5;
        try {
            com.mbridge.msdk.videocommon.d.a b = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (b != null) {
                i = (int) b.f();
            }
            q.b(BTBaseView.TAG, "MBridgeBaseView buffetTimeout:" + i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        if (this.h) {
            this.q.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean isSilent = MBridgeBTVideoView.this.p.isSilent();
                    if (MBridgeBTVideoView.this.u != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.n);
                            jSONObject.put("id", MBridgeBTVideoView.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("mute", MBridgeBTVideoView.this.A);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.u, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            q.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + isSilent + " mute = " + MBridgeBTVideoView.this.A);
                        } catch (Exception e) {
                            c.a().a(MBridgeBTVideoView.this.u, e.getMessage());
                        }
                    }
                }
            });
            this.s.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.u != null) {
                        BTBaseView.a(MBridgeBTVideoView.this.u, "onPlayerCloseBtnClicked", MBridgeBTVideoView.this.d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.u != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.n);
                            jSONObject.put("id", MBridgeBTVideoView.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.u, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception unused) {
                            c.a().a(MBridgeBTVideoView.this.u, "onClicked", MBridgeBTVideoView.this.d);
                        }
                    }
                }
            });
        }
    }

    private static final class a extends DefaultVideoPlayerStatusListener {
        private MBridgeBTVideoView a;
        private WebView b;
        private String c;
        private String d;
        private int e;
        private int f;
        private boolean g;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private int k;
        private int l;
        private boolean m = false;

        public a(MBridgeBTVideoView mBridgeBTVideoView, WebView webView) {
            this.a = mBridgeBTVideoView;
            this.b = webView;
            if (mBridgeBTVideoView != null) {
                this.c = mBridgeBTVideoView.d;
                this.d = mBridgeBTVideoView.c;
            }
        }

        public final void a(int i2, int i3) {
            this.k = i2;
            this.l = i3;
        }

        public final void onPlayStarted(int i2) {
            super.onPlayStarted(i2);
            if (!this.g) {
                this.a.L.setMax(i2);
                WebView webView = this.b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.c);
                }
                this.g = true;
            }
            boolean unused = MBridgeBTVideoView.G = false;
        }

        public final void onPlayCompleted() {
            super.onPlayCompleted();
            if (this.a.b == null) {
                this.a.r.setText(MBridgeConstans.ENDCARD_URL_TYPE_PL);
            } else if (this.a.b.getVideoCompleteTime() > 0) {
                this.a.r.setText(k.a(com.mbridge.msdk.foundation.controller.a.e().g(), "mbridge_reward_video_view_reward_time_complete", "string"));
            } else {
                this.a.r.setText(MBridgeConstans.ENDCARD_URL_TYPE_PL);
            }
            this.a.p.setClickable(false);
            WebView webView = this.b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.c);
            }
            this.e = this.f;
            boolean unused = MBridgeBTVideoView.G = true;
            this.a.stop();
        }

        public final void onPlayError(String str) {
            super.onPlayError(str);
            if (this.b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.o);
                    jSONObject.put("id", this.c);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject2.put("id", this.c);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(this.b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    c.a().a(this.b, e2.getMessage());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:47:0x01bd A[Catch:{ Exception -> 0x01dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPlayProgress(int r9, int r10) {
            /*
                r8 = this;
                java.lang.String r0 = "id"
                java.lang.String r1 = "DefaultVideoPlayerStatusListener"
                super.onPlayProgress(r9, r10)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r8.a
                boolean r2 = r2.h
                r3 = 1
                if (r2 == 0) goto L_0x00b5
                r2 = 0
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r8.a
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b
                if (r4 == 0) goto L_0x0040
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r8.a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b
                int r2 = r2.getVideoCompleteTime()
                com.mbridge.msdk.foundation.b.b r4 = com.mbridge.msdk.foundation.b.b.a()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r6 = r8.a
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r6.b
                java.lang.String r6 = r6.getCampaignUnitId()
                r5.append(r6)
                java.lang.String r6 = "_"
                r5.append(r6)
                r5.append(r3)
                java.lang.String r5 = r5.toString()
                r4.b(r5, r9)
            L_0x0040:
                if (r2 <= r10) goto L_0x0043
                r2 = r10
            L_0x0043:
                if (r2 > 0) goto L_0x0048
                int r4 = r10 - r9
                goto L_0x004a
            L_0x0048:
                int r4 = r2 - r9
            L_0x004a:
                java.lang.String r5 = "string"
                if (r4 > 0) goto L_0x0072
                if (r2 > 0) goto L_0x0053
                java.lang.String r2 = "0"
                goto L_0x00ac
            L_0x0053:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r8.a
                android.content.Context r2 = r2.getContext()
                android.content.res.Resources r2 = r2.getResources()
                com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()
                android.content.Context r4 = r4.g()
                java.lang.String r6 = "mbridge_reward_video_view_reward_time_complete"
                int r4 = com.mbridge.msdk.foundation.tools.k.a(r4, r6, r5)
                java.lang.CharSequence r2 = r2.getText(r4)
                java.lang.String r2 = (java.lang.String) r2
                goto L_0x00ac
            L_0x0072:
                if (r2 > 0) goto L_0x007f
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                java.lang.String r4 = ""
                goto L_0x00a5
            L_0x007f:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r8.a
                android.content.Context r4 = r4.getContext()
                android.content.res.Resources r4 = r4.getResources()
                com.mbridge.msdk.foundation.controller.a r6 = com.mbridge.msdk.foundation.controller.a.e()
                android.content.Context r6 = r6.g()
                java.lang.String r7 = "mbridge_reward_video_view_reward_time_left"
                int r5 = com.mbridge.msdk.foundation.tools.k.a(r6, r7, r5)
                java.lang.CharSequence r4 = r4.getText(r5)
                java.lang.String r4 = (java.lang.String) r4
            L_0x00a5:
                r2.append(r4)
                java.lang.String r2 = r2.toString()
            L_0x00ac:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r8.a
                android.widget.TextView r4 = r4.r
                r4.setText(r2)
            L_0x00b5:
                r8.f = r10
                r8.e = r9
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r8.a
                android.widget.ProgressBar r2 = r2.L
                int r4 = r8.e
                r2.setProgress(r4)
                android.webkit.WebView r2 = r8.b
                if (r2 == 0) goto L_0x012a
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x011c }
                r2.<init>()     // Catch:{ Exception -> 0x011c }
                java.lang.String r4 = "code"
                int r5 = com.mbridge.msdk.video.bt.module.BTBaseView.n     // Catch:{ Exception -> 0x011c }
                r2.put(r4, r5)     // Catch:{ Exception -> 0x011c }
                java.lang.String r4 = r8.c     // Catch:{ Exception -> 0x011c }
                r2.put(r0, r4)     // Catch:{ Exception -> 0x011c }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x011c }
                r4.<init>()     // Catch:{ Exception -> 0x011c }
                java.lang.String r5 = r8.c     // Catch:{ Exception -> 0x011c }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x011c }
                java.lang.String r0 = "progress"
                java.lang.String r5 = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.b(r9, r10)     // Catch:{ Exception -> 0x011c }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x011c }
                java.lang.String r0 = "time"
                java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x011c }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x011c }
                java.lang.String r0 = "duration"
                java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x011c }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x011c }
                java.lang.String r0 = "data"
                r2.put(r0, r4)     // Catch:{ Exception -> 0x011c }
                com.mbridge.msdk.mbsignalcommon.windvane.g r0 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ Exception -> 0x011c }
                android.webkit.WebView r4 = r8.b     // Catch:{ Exception -> 0x011c }
                java.lang.String r5 = "onPlayerProgressChanged"
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x011c }
                byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x011c }
                r6 = 2
                java.lang.String r2 = android.util.Base64.encodeToString(r2, r6)     // Catch:{ Exception -> 0x011c }
                r0.a((android.webkit.WebView) r4, (java.lang.String) r5, (java.lang.String) r2)     // Catch:{ Exception -> 0x011c }
                goto L_0x012a
            L_0x011c:
                r0 = move-exception
                com.mbridge.msdk.video.bt.a.c r2 = com.mbridge.msdk.video.bt.a.c.a()
                android.webkit.WebView r4 = r8.b
                java.lang.String r0 = r0.getMessage()
                r2.a((android.webkit.WebView) r4, (java.lang.String) r0)
            L_0x012a:
                int r0 = r8.k     // Catch:{ Exception -> 0x01dc }
                r2 = 100
                if (r0 == r2) goto L_0x01e4
                boolean r0 = r8.m     // Catch:{ Exception -> 0x01dc }
                if (r0 != 0) goto L_0x01e4
                int r0 = r8.l     // Catch:{ Exception -> 0x01dc }
                if (r0 != 0) goto L_0x0139
                return
            L_0x0139:
                int r0 = r8.l     // Catch:{ Exception -> 0x01dc }
                if (r0 < 0) goto L_0x01e4
                int r0 = r8.l     // Catch:{ Exception -> 0x01dc }
                int r10 = r10 * r0
                int r10 = r10 / r2
                if (r9 < r10) goto L_0x01e4
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r9 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r9 = r9.b     // Catch:{ Exception -> 0x01dc }
                int r9 = r9.getAdType()     // Catch:{ Exception -> 0x01dc }
                r0 = 94
                if (r9 == r0) goto L_0x0187
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r9 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r9 = r9.b     // Catch:{ Exception -> 0x01dc }
                int r9 = r9.getAdType()     // Catch:{ Exception -> 0x01dc }
                r0 = 287(0x11f, float:4.02E-43)
                if (r9 != r0) goto L_0x015c
                goto L_0x0187
            L_0x015c:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01dc }
                r9.<init>()     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x01dc }
                java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x01dc }
                r9.append(r0)     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x01dc }
                java.lang.String r0 = r0.getVideoUrlEncode()     // Catch:{ Exception -> 0x01dc }
                r9.append(r0)     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x01dc }
                java.lang.String r0 = r0.getBidToken()     // Catch:{ Exception -> 0x01dc }
                r9.append(r0)     // Catch:{ Exception -> 0x01dc }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01dc }
                goto L_0x01b1
            L_0x0187:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01dc }
                r9.<init>()     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x01dc }
                java.lang.String r0 = r0.getRequestId()     // Catch:{ Exception -> 0x01dc }
                r9.append(r0)     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x01dc }
                java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x01dc }
                r9.append(r0)     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r8.a     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x01dc }
                java.lang.String r0 = r0.getVideoUrlEncode()     // Catch:{ Exception -> 0x01dc }
                r9.append(r0)     // Catch:{ Exception -> 0x01dc }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01dc }
            L_0x01b1:
                com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x01dc }
                java.lang.String r2 = r8.d     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.videocommon.download.a r9 = r0.a(r2, r9)     // Catch:{ Exception -> 0x01dc }
                if (r9 == 0) goto L_0x01e4
                r9.j()     // Catch:{ Exception -> 0x01dc }
                r8.m = r3     // Catch:{ Exception -> 0x01dc }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01dc }
                r9.<init>()     // Catch:{ Exception -> 0x01dc }
                java.lang.String r0 = "CDRate is : "
                r9.append(r0)     // Catch:{ Exception -> 0x01dc }
                r9.append(r10)     // Catch:{ Exception -> 0x01dc }
                java.lang.String r10 = " and start download !"
                r9.append(r10)     // Catch:{ Exception -> 0x01dc }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01dc }
                com.mbridge.msdk.foundation.tools.q.d(r1, r9)     // Catch:{ Exception -> 0x01dc }
                goto L_0x01e4
            L_0x01dc:
                r9 = move-exception
                java.lang.String r9 = r9.getMessage()
                com.mbridge.msdk.foundation.tools.q.d(r1, r9)
            L_0x01e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.a.onPlayProgress(int, int):void");
        }

        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals(PlayerErrorConstant.PLAYERING_TIMEOUT)) && this.b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.n);
                        jSONObject.put("id", this.c);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
                        g.a().a(this.b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        c.a().a(this.b, e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }
    }

    public void setSoundImageViewVisble(int i) {
        this.q.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i) {
        this.r.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCloseViewVisable(int i) {
        this.s.setVisibility(i == 0 ? 4 : 0);
    }

    public void setShowClose(int i) {
        this.x = i;
    }

    public void setProgressBarState(int i) {
        ProgressBar progressBar = this.L;
        if (progressBar != null) {
            progressBar.setVisibility(i == 0 ? 8 : 0);
        }
    }

    public void setShowMute(int i) {
        this.y = i;
    }

    public void setShowTime(int i) {
        this.w = i;
    }

    /* access modifiers changed from: private */
    public static String b(int i, int i2) {
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

    public void setVolume(float f, float f2) {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setVolume(f, f2);
        }
    }

    public void setPlaybackParams(float f) {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setPlaybackParams(f);
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        if (i <= 0) {
            i = this.K.getPaddingLeft();
        }
        if (i2 <= 0) {
            i2 = this.K.getPaddingRight();
        }
        if (i3 <= 0) {
            i3 = this.K.getPaddingTop();
        }
        if (i4 <= 0) {
            i4 = this.K.getPaddingBottom();
        }
        q.d(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        this.K.setPadding(i, i3, i2, i4);
    }

    public void preLoadData() {
        String str;
        int i;
        if (this.b.getAdType() == 94 || this.b.getAdType() == 287) {
            str = this.b.getRequestId() + this.b.getId() + this.b.getVideoUrlEncode();
        } else {
            str = this.b.getId() + this.b.getVideoUrlEncode() + this.b.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.c, str);
        if (a2 != null) {
            this.v = a2;
        }
        this.B = d();
        this.F = c();
        if (this.h && !TextUtils.isEmpty(this.F) && this.b != null) {
            this.z = new a(this, this.u);
            a aVar = this.z;
            CampaignEx campaignEx = this.b;
            if (campaignEx == null) {
                i = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.c, false).p();
            } else if (campaignEx.getReady_rate() != -1) {
                i = campaignEx.getReady_rate();
            } else {
                i = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.c, false).p();
            }
            aVar.a(i, com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.c, false).q());
            this.p.setDesk(false);
            this.p.initBufferIngParam(this.B);
            soundOperate(this.A, -1, (String) null);
        }
        G = false;
    }
}
