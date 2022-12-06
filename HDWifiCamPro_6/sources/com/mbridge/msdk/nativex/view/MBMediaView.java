package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.nativex.view.MediaViewPlayerView;
import com.mbridge.msdk.nativex.view.mbfullview.BaseView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeFullView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeTopFullView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.out.OnMBMediaViewListener;
import com.mbridge.msdk.out.OnMBMediaViewListenerPlus;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.signal.communication.IRewardCommunication;
import com.mbridge.msdk.videocommon.download.h;
import com.mbridge.msdk.videocommon.view.MyImageView;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MBMediaView extends LinearLayout implements VideoPlayerStatusListener, IRewardCommunication {
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_1_LANDING_PAGE = 1;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_2_NORMAL_FULLSCREEN = 2;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_3_NORMAL_FULLSCREEN_ENDCARD = 3;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_4_NORMAL_FULLSCREEN_LP = 4;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_6_SMALLVIDEO = 6;
    public static final String TAG = "MBMediaView";
    public static final int WHAT_VIEW_FULL_SCREEN = 2;
    public static final int WHAT_VIEW_SMALL_SCREEN = 1;
    private static int o = 2;
    private static int p = 1;
    private ProgressBar A;
    /* access modifiers changed from: private */
    public View B;
    /* access modifiers changed from: private */
    public BaseView C;
    private RelativeLayout D;
    private RelativeLayout E;
    /* access modifiers changed from: private */
    public TextView F;
    private ProgressBar G;
    private RelativeLayout H;
    private int I;
    /* access modifiers changed from: private */
    public Handler J;
    /* access modifiers changed from: private */
    public CampaignEx K;
    private int L;
    private int M;
    private double N;
    private double O;
    /* access modifiers changed from: private */
    public int P;
    /* access modifiers changed from: private */
    public int Q;
    private e R;
    private SensorManager S;
    private Sensor T;
    private com.mbridge.msdk.videocommon.download.a U = null;
    /* access modifiers changed from: private */
    public a V = null;
    private OnMBMediaViewListener W;
    private boolean a = true;
    private OnMBMediaViewListenerPlus aa;
    private int ab;
    /* access modifiers changed from: private */
    public boolean ac = false;
    private boolean ad = false;
    private RelativeLayout ae;
    private ImageView af;
    /* access modifiers changed from: private */
    public int ag;
    /* access modifiers changed from: private */
    public boolean ah = false;
    /* access modifiers changed from: private */
    public Context ai;
    private boolean aj = false;
    private Runnable ak = new Runnable() {
        public final void run() {
            try {
                if (!MBMediaView.this.h) {
                    if (!MBMediaView.this.a((View) MBMediaView.this)) {
                        MBMediaView.Q(MBMediaView.this);
                    } else {
                        MBMediaView.R(MBMediaView.this);
                    }
                }
                MBMediaView.this.J.postDelayed(this, 300);
            } catch (Exception e) {
                q.d(MBMediaView.TAG, e.getMessage());
            }
        }
    };
    private boolean b = true;
    private boolean c = true;
    /* access modifiers changed from: private */
    public boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    /* access modifiers changed from: private */
    public boolean h = false;
    /* access modifiers changed from: private */
    public volatile boolean i = false;
    /* access modifiers changed from: private */
    public volatile boolean j = false;
    private boolean k = true;
    private boolean l = true;
    private ArrayList<String> m = new ArrayList<>();
    private ArrayList<String> n = new ArrayList<>();
    private boolean q = false;
    /* access modifiers changed from: private */
    public boolean r = false;
    private int s = 0;
    /* access modifiers changed from: private */
    public MediaViewPlayerView t;
    private RelativeLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private WindVaneWebViewForNV x;
    /* access modifiers changed from: private */
    public WindVaneWebViewForNV y;
    /* access modifiers changed from: private */
    public MyImageView z;

    private enum a {
        BIG_IMAGE,
        VIDEO,
        GIF
    }

    public void handlerPlayableException(Object obj, String str) {
    }

    public void notifyCloseBtn(Object obj, String str) {
    }

    public void onPlayCompleted() {
    }

    public void onPlayProgressMS(int i2, int i3) {
    }

    public void onPlayStarted(int i2) {
    }

    public void setOrientation(Object obj, String str) {
    }

    public MBMediaView(Context context) {
        super(context);
        a(context);
    }

    public MBMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        try {
            c();
            b();
            this.ai = context;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    private void a() {
        com.mbridge.msdk.videocommon.download.a aVar = this.U;
        if (aVar != null) {
            aVar.b((com.mbridge.msdk.videocommon.listener.a) null);
        }
    }

    private void b() {
        int a2 = k.a(getContext(), "mbridge_nativex_mbmediaview", TtmlNode.TAG_LAYOUT);
        if (a2 == -1) {
            q.d(TAG, "can not find mediaview resource");
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(a2, (ViewGroup) null);
        this.v = (RelativeLayout) inflate.findViewById(k.a(getContext(), "mbridge_rl_mediaview_root", "id"));
        this.u = (RelativeLayout) inflate.findViewById(k.a(getContext(), "mbridge_ll_playerview_container", "id"));
        this.z = (MyImageView) inflate.findViewById(k.a(getContext(), "mbridge_my_big_img", "id"));
        this.A = (ProgressBar) inflate.findViewById(k.a(getContext(), "mbridge_native_pb", "id"));
        this.w = (RelativeLayout) inflate.findViewById(k.a(getContext(), "mbridge_nativex_webview_layout", "id"));
        this.x = (WindVaneWebViewForNV) inflate.findViewById(k.a(getContext(), "mbridge_nativex_webview_layout_webview", "id"));
        this.v.setClickable(true);
        addView(inflate, -1, -1);
    }

    private void c() {
        this.J = new Handler() {
            public final void handleMessage(Message message) {
                if (message != null) {
                    try {
                        int i = message.what;
                        if (i == 1) {
                            MBMediaView.this.q();
                        } else if (i == 2) {
                        } else {
                            if (i == 3) {
                                Object obj = message.obj;
                                if (obj != null && (obj instanceof View)) {
                                    if (MBMediaView.this.a((View) obj)) {
                                        MBMediaView.b(MBMediaView.this);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        q.d(MBMediaView.TAG, e.getMessage());
                    }
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.c) {
                this.S = (SensorManager) getContext().getSystemService("sensor");
                this.T = this.S.getDefaultSensor(1);
                this.R = new e();
                this.S.registerListener(this.R, this.T, 2);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            this.g = isHardwareAccelerated();
        }
        this.ag = getOrientation();
        d();
        this.J.postDelayed(this.ak, 3000);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.J.removeCallbacks(this.ak);
            if (this.J != null) {
                this.J.removeCallbacksAndMessages((Object) null);
            }
            if (!(this.S == null || this.R == null)) {
                this.S.unregisterListener(this.R);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return;
        }
        a();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        try {
            this.e = z2;
            if (this.V == a.VIDEO && this.t != null) {
                this.t.setIsFrontDesk(z2);
            }
            if (this.h) {
                if (this.t == null) {
                    q.d(TAG, "fullscreen playerview is null return");
                } else if (!this.e) {
                    this.t.pause();
                } else if (this.t.isPlaying()) {
                    q.b(TAG, "fullscreen windowfocuse true isPlaying do nothing return");
                } else if (this.t != null && !this.t.isComplete() && !this.t.getIsActiviePause()) {
                    this.t.onClickPlayButton();
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return;
        }
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        try {
            this.L = getHeight();
            this.M = getWidth();
            if (this.M == 0) {
                this.M = getMeasuredWidth();
            }
            if (this.L == 0) {
                this.L = getMeasuredHeight();
            }
            if (this.M == 0 && this.L == 0) {
                this.M = (int) A();
            }
            if (this.V == a.VIDEO && !this.h) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (this.L == 0 || ((layoutParams != null && layoutParams.height == -2) || (layoutParams != null && layoutParams.height == -1))) {
                    this.L = (int) ((((double) this.M) * this.O) / this.N);
                }
                h();
            } else if (this.V == a.BIG_IMAGE && !this.h) {
                f();
            } else if (this.V == a.GIF && !this.h) {
                g();
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ab A[Catch:{ all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNativeAd(com.mbridge.msdk.out.Campaign r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x000c
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            if (r0 != r3) goto L_0x000c
            return
        L_0x000c:
            r0 = 1
            r2.e = r0     // Catch:{ all -> 0x00af }
            r2.g = r0     // Catch:{ all -> 0x00af }
            r0 = 0
            r2.h = r0     // Catch:{ all -> 0x00af }
            r2.i = r0     // Catch:{ all -> 0x00af }
            r2.j = r0     // Catch:{ all -> 0x00af }
            r2.r = r0     // Catch:{ all -> 0x00af }
            r2.y()     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ all -> 0x00af }
            r2.K = r3     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.K     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx$b r3 = r3.getMediaViewHolder()     // Catch:{ all -> 0x00af }
            if (r3 != 0) goto L_0x003b
            com.mbridge.msdk.foundation.entity.CampaignEx$b r3 = new com.mbridge.msdk.foundation.entity.CampaignEx$b     // Catch:{ all -> 0x00af }
            r3.<init>()     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            java.util.Map r0 = r0.getAdvImpList()     // Catch:{ all -> 0x00af }
            r3.l = r0     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            r0.setMediaViewHolder(r3)     // Catch:{ all -> 0x00af }
        L_0x003b:
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.K     // Catch:{ all -> 0x00af }
            int r3 = r3.getAdType()     // Catch:{ all -> 0x00af }
            r0 = 94
            if (r3 == r0) goto L_0x0075
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.K     // Catch:{ all -> 0x00af }
            int r3 = r3.getAdType()     // Catch:{ all -> 0x00af }
            r0 = 287(0x11f, float:4.02E-43)
            if (r3 != r0) goto L_0x0050
            goto L_0x0075
        L_0x0050:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r3.<init>()     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x00af }
            r3.append(r0)     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r0.getVideoUrlEncode()     // Catch:{ all -> 0x00af }
            r3.append(r0)     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r0.getBidToken()     // Catch:{ all -> 0x00af }
            r3.append(r0)     // Catch:{ all -> 0x00af }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00af }
            goto L_0x0099
        L_0x0075:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r3.<init>()     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r0.getRequestId()     // Catch:{ all -> 0x00af }
            r3.append(r0)     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x00af }
            r3.append(r0)     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.K     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r0.getVideoUrlEncode()     // Catch:{ all -> 0x00af }
            r3.append(r0)     // Catch:{ all -> 0x00af }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00af }
        L_0x0099:
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r2.o()     // Catch:{ all -> 0x00af }
            com.mbridge.msdk.videocommon.download.a r3 = r0.a(r1, r3)     // Catch:{ all -> 0x00af }
            r2.U = r3     // Catch:{ all -> 0x00af }
            boolean r3 = r2.q     // Catch:{ all -> 0x00af }
            if (r3 == 0) goto L_0x00b9
            r2.d()     // Catch:{ all -> 0x00af }
            goto L_0x00b9
        L_0x00af:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            java.lang.String r0 = "MBMediaView"
            com.mbridge.msdk.foundation.tools.q.d(r0, r3)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.nativex.view.MBMediaView.setNativeAd(com.mbridge.msdk.out.Campaign):void");
    }

    public void setOnMediaViewListener(OnMBMediaViewListener onMBMediaViewListener) {
        this.W = onMBMediaViewListener;
    }

    public void setOnMediaViewListener(OnMBMediaViewListenerPlus onMBMediaViewListenerPlus) {
        this.aa = onMBMediaViewListenerPlus;
    }

    public void setIsAllowFullScreen(boolean z2) {
        this.d = z2;
    }

    public void setAllowVideoRefresh(boolean z2) {
        this.a = z2;
    }

    public void setAllowLoopPlay(boolean z2) {
        this.b = z2;
    }

    public void setAllowScreenChange(boolean z2) {
        this.c = z2;
    }

    public void destory() {
        try {
            if (this.t != null) {
                this.t.release();
            }
            a();
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    private void d() {
        try {
            this.V = a(true);
            changeNoticeURL();
            if (this.V == a.BIG_IMAGE) {
                j();
                m();
            } else if (this.V == a.VIDEO) {
                e();
            } else if (this.V == a.GIF) {
                n();
                l();
            }
            this.q = true;
        } catch (Throwable th) {
            q.a(TAG, th.getMessage(), th);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        z();
        k();
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            if (this.V == a.BIG_IMAGE && this.M != 0 && this.Q != 0 && this.P != 0) {
                int i2 = (this.M * this.Q) / this.P;
                if (this.z != null && i2 != 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
                    layoutParams.width = this.M;
                    layoutParams.height = i2;
                    this.z.setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        try {
            if (this.V != a.GIF) {
                return;
            }
            if (this.M != 0 && this.Q != 0 && this.P != 0) {
                int i2 = (this.M * this.Q) / this.P;
                if (this.w != null && i2 != 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                    layoutParams.width = this.M;
                    layoutParams.height = i2;
                    layoutParams.addRule(13);
                    this.w.setLayoutParams(layoutParams);
                }
            } else if (this.M != 0 && this.w != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams2.width = this.M;
                layoutParams2.height = (this.M * 627) / IronSourceConstants.RV_INSTANCE_LOAD_FAILED;
                layoutParams2.addRule(13);
                this.w.setLayoutParams(layoutParams2);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            if (this.V == a.VIDEO && this.u != null) {
                int A2 = (int) A();
                int j2 = u.j(getContext());
                if (!this.h) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
                    layoutParams.width = this.M;
                    layoutParams.height = this.L;
                    layoutParams.addRule(13);
                    this.u.setLayoutParams(layoutParams);
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
                    layoutParams2.width = A2;
                    layoutParams2.height = j2;
                    layoutParams2.addRule(13);
                    this.D.setLayoutParams(layoutParams2);
                }
                q();
                if (!this.h) {
                    a((View) this.t, (float) this.M, (float) this.L);
                } else {
                    a((View) this.t, (float) A2, (float) j2);
                }
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    private void i() {
        try {
            this.t.showSoundIndicator(this.l);
            this.t.showProgressView(this.k);
            if (this.W != null) {
                this.W.onExitFullscreen();
            }
            if (this.aa != null) {
                this.aa.onExitFullscreen();
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !this.m.contains(str)) {
                this.m.add(str);
                if (this.W != null) {
                    this.W.onVideoStart();
                }
                if (this.aa != null) {
                    this.aa.onVideoStart();
                }
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !this.n.contains(str)) {
                this.n.add(str);
                if (this.aa != null) {
                    this.aa.onVideoComplete();
                }
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    private void j() {
        try {
            u.a((ImageView) this.z);
            this.z.setVisibility(0);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    private void k() {
        try {
            this.u.setVisibility(0);
            this.z.setVisibility(8);
            this.w.setVisibility(8);
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        try {
            this.u.setVisibility(8);
            this.z.setVisibility(8);
            this.w.setVisibility(0);
            this.x.setVisibility(0);
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    private void m() {
        try {
            if (this.K != null) {
                String imageUrl = this.K.getImageUrl();
                if (!x.a(imageUrl) && getContext() != null) {
                    com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(imageUrl, (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
                        public final void onFailedLoad(String str, String str2) {
                        }

                        public final void onSuccessLoad(Bitmap bitmap, String str) {
                            if (MBMediaView.this.z != null && MBMediaView.this.V == a.BIG_IMAGE) {
                                if (bitmap != null) {
                                    int unused = MBMediaView.this.P = bitmap.getWidth();
                                    int unused2 = MBMediaView.this.Q = bitmap.getHeight();
                                    MBMediaView.this.z.setImageUrl(str);
                                    MBMediaView.this.z.setImageBitmap(bitmap);
                                }
                                MBMediaView.this.z.setOnClickListener(new com.mbridge.msdk.widget.a() {
                                    /* access modifiers changed from: protected */
                                    public final void a(View view) {
                                        if (MBMediaView.this.ai != null) {
                                            MBMediaView.this.b(MBMediaView.this.ai);
                                        } else {
                                            MBMediaView.this.b(view.getContext());
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    private void n() {
        try {
            if (this.K != null) {
                String gifUrl = this.K.getGifUrl();
                if (!x.a(gifUrl) && getContext() != null) {
                    this.x.loadDataWithBaseURL((String) null, "<!DOCTYPE html><html lang=\"en\"><head>  <meta charset=\"UTF-8\">  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">  <title>Document</title>  <style>  *{    margin: 0;    padding: 0;  }  html, body{    width: 100%;    height: 100%;  }  body{    background-image: url('gifUrl');    background-position: center;    background-size: contain;    background-repeat: no-repeat;  }  </style></head><body></body></html>".replace("gifUrl", gifUrl), "text/html", "utf-8", (String) null);
                    this.x.setInterceptTouch(true);
                    this.w.setOnClickListener(new com.mbridge.msdk.widget.a() {
                        /* access modifiers changed from: protected */
                        public final void a(View view) {
                            if (MBMediaView.this.ai != null) {
                                MBMediaView mBMediaView = MBMediaView.this;
                                mBMediaView.b(mBMediaView.ai);
                            } else {
                                MBMediaView.this.b(view.getContext());
                            }
                            q.b(MBMediaView.TAG, "CLICK WEBVIEW LAYOUT ");
                        }
                    });
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public String o() {
        try {
            if (this.K == null || !x.b(this.K.getCampaignUnitId())) {
                return null;
            }
            return this.K.getCampaignUnitId();
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
            return null;
        }
    }

    private a a(boolean z2) {
        a aVar = null;
        try {
            if (this.K == null) {
                return null;
            }
            if (x.a(this.K.getVideoUrlEncode())) {
                if (x.b(this.K.getImageUrl())) {
                    aVar = a.BIG_IMAGE;
                }
                if (!x.b(this.K.getGifUrl())) {
                    return aVar;
                }
                if (x.a(this.K.getImageUrl())) {
                    aVar = a.GIF;
                }
                this.x.setWebViewClient(new g(this));
                n();
                return aVar;
            } else if (Build.VERSION.SDK_INT < 14 || !this.g || this.U == null) {
                return a.BIG_IMAGE;
            } else {
                if (x.b(this.K.getVideoUrlEncode()) && x.a(this.K.getImageUrl())) {
                    return a.VIDEO;
                }
                if (!x.b(this.K.getVideoUrlEncode()) || !x.b(this.K.getImageUrl())) {
                    return null;
                }
                if (com.mbridge.msdk.videocommon.download.k.a(this.U, s())) {
                    return a.VIDEO;
                }
                a aVar2 = a.BIG_IMAGE;
                if (!z2 || !this.a) {
                    return aVar2;
                }
                this.U.b((com.mbridge.msdk.videocommon.listener.a) new f(this));
                return aVar2;
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return a.BIG_IMAGE;
        }
    }

    private void p() {
        try {
            if (this.K == null) {
                q.b(TAG, "campaign is null addPlayerView return");
            }
            if (!(this.t == null || this.t.getParent() == null)) {
                ((ViewGroup) this.t.getParent()).removeView(this.t);
            }
            k();
            this.t = new MediaViewPlayerView(getContext());
            this.t.showProgressView(this.k);
            this.t.showSoundIndicator(this.l);
            if (this.f) {
                this.t.openSound();
            } else {
                this.t.closeSound();
            }
            this.t.setAllowLoopPlay(this.b);
            this.t.initPlayerViewData(r(), this.K, u(), this, this.U, o());
            this.t.setOnMediaViewPlayerViewListener(new c(this));
            this.u.addView(this.t, -1, -1);
            if (this.t != null) {
                this.t.setOnClickListener(new com.mbridge.msdk.widget.a() {
                    /* access modifiers changed from: protected */
                    public final void a(View view) {
                        try {
                            if (!MBMediaView.this.h) {
                                MBMediaView.d(MBMediaView.this);
                            }
                            MBMediaView.this.t.showSoundIndicator(true);
                            MBMediaView.this.t.showProgressView(true);
                            if (MBMediaView.this.d && !MBMediaView.this.h && (MBMediaView.this.B == null || MBMediaView.this.B.getParent() == null)) {
                                if (!MBMediaView.this.t.halfLoadingViewisVisible()) {
                                    if (MBMediaView.this.t.isPlaying()) {
                                        MBMediaView.h(MBMediaView.this);
                                        return;
                                    }
                                }
                                q.b(MBMediaView.TAG, "is loading or no playing return;");
                            } else if (MBMediaView.this.h) {
                                q.b(MBMediaView.TAG, "fullScreenShowUI");
                                MBMediaView.i(MBMediaView.this);
                            } else if (MBMediaView.this.ai != null) {
                                MBMediaView.this.b(MBMediaView.this.ai);
                            } else {
                                MBMediaView.this.b(view.getContext());
                            }
                        } catch (Throwable th) {
                            q.a(MBMediaView.TAG, th.getMessage(), th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        try {
            if (getVisibility() == 0) {
                if (a((View) this)) {
                    int i2 = 0;
                    com.mbridge.msdk.b.d t2 = t();
                    if (t2 != null) {
                        i2 = t2.d();
                    }
                    Message obtainMessage = this.J.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.obj = this;
                    this.J.sendMessageDelayed(obtainMessage, (long) (i2 * 1000));
                }
                if (this.V != a.VIDEO) {
                    return;
                }
                if (this.t == null) {
                    p();
                } else if (this.K != this.t.getCampaign()) {
                    this.t.release();
                    p();
                    if (getParent() != null) {
                        ((View) getParent()).invalidate();
                    }
                    requestLayout();
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    private String r() {
        try {
            if (this.K == null) {
                return null;
            }
            if (this.U != null && this.U.f() == 5) {
                String d2 = this.U.d();
                if (new File(d2).exists() && this.U.e() == u.a(new File(d2))) {
                    return d2;
                }
            }
            String videoUrlEncode = this.K.getVideoUrlEncode();
            if (x.b(videoUrlEncode)) {
                return videoUrlEncode;
            }
            return null;
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public boolean a(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0) {
                    Rect rect = new Rect();
                    if (!view.getLocalVisibleRect(rect)) {
                        return false;
                    }
                    long height = (long) (rect.height() * rect.width());
                    long height2 = (long) (view.getHeight() * view.getWidth());
                    long j2 = (long) (((float) height2) * 0.5f);
                    if (height2 > 0 && u.l(getContext()) && this.e && height >= j2 && isShown()) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                q.d(TAG, th.getMessage());
            }
        }
        return false;
    }

    private int s() {
        if (t() != null) {
            return t().e();
        }
        return 100;
    }

    private com.mbridge.msdk.b.d t() {
        try {
            if (this.K == null) {
                return null;
            }
            if (x.a(this.K.getCampaignUnitId())) {
                return null;
            }
            String campaignUnitId = this.K.getCampaignUnitId();
            String h2 = com.mbridge.msdk.foundation.controller.a.e().h();
            if (!x.a(campaignUnitId)) {
                if (!x.a(h2)) {
                    com.mbridge.msdk.b.d e2 = com.mbridge.msdk.b.b.a().e(h2, campaignUnitId);
                    if (e2 != null) {
                        return e2;
                    }
                    return com.mbridge.msdk.b.d.d(campaignUnitId);
                }
            }
            return com.mbridge.msdk.b.d.d(campaignUnitId);
        } catch (Exception e3) {
            q.d(TAG, e3.getMessage());
            return null;
        }
    }

    private boolean u() {
        try {
            com.mbridge.msdk.b.d t2 = t();
            if (t2 == null) {
                return false;
            }
            int i2 = t2.i();
            if (i2 == 1) {
                if (u.b(getContext())) {
                    return true;
                }
                return false;
            } else if (i2 == 2) {
                return false;
            } else {
                if (i2 == 3) {
                    if (u.c(getContext())) {
                        return true;
                    }
                    return false;
                } else if (u.b(getContext())) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public void onPlayError(String str) {
        try {
            q.b(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
            if (!(this.K == null || this.K.getMediaViewHolder() == null || this.K.getMediaViewHolder().d || TextUtils.isEmpty(this.K.getCampaignUnitId()) || this.K.getNativeVideoTracking() == null || this.K.getNativeVideoTracking().h() == null)) {
                this.K.getMediaViewHolder().d = true;
                com.mbridge.msdk.click.a.a(getContext(), this.K, this.K.getCampaignUnitId(), this.K.getNativeVideoTracking().h(), false, false);
            }
            p a2 = p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(getContext()));
            m mVar = null;
            if (!TextUtils.isEmpty(this.K.getNoticeUrl())) {
                int n2 = com.mbridge.msdk.foundation.tools.m.n(getContext());
                mVar = new m("2000021", n2, this.K.getNoticeUrl(), str, com.mbridge.msdk.foundation.tools.m.a(getContext(), n2));
            } else if (!TextUtils.isEmpty(this.K.getClickURL())) {
                int n3 = com.mbridge.msdk.foundation.tools.m.n(getContext());
                mVar = new m("2000021", n3, this.K.getClickURL(), str, com.mbridge.msdk.foundation.tools.m.a(getContext(), n3));
            }
            if (mVar != null) {
                mVar.n(this.K.getId());
                mVar.e(this.K.getVideoUrlEncode());
                mVar.p(str);
                mVar.k(this.K.getRequestId());
                mVar.l(this.K.getRequestIdNotice());
                mVar.m(o());
                a2.a(mVar);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return;
        }
        NativeController.insertExcludeId(this.K.getCampaignUnitId(), this.K);
    }

    public void onBufferingStart(String str) {
        q.b("bufferMsg", str);
    }

    public void onBufferingEnd() {
        q.b("bufferend", "bufferend");
    }

    public void onPlaySetDataSourceError(String str) {
        q.b("errorstr", str);
    }

    /* renamed from: com.mbridge.msdk.nativex.view.MBMediaView$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] a = new int[BaseView.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.mbridge.msdk.nativex.view.mbfullview.BaseView$a[] r0 = com.mbridge.msdk.nativex.view.mbfullview.BaseView.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.mbridge.msdk.nativex.view.mbfullview.BaseView$a r1 = com.mbridge.msdk.nativex.view.mbfullview.BaseView.a.FULL_MIDDLE_VIEW     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.mbridge.msdk.nativex.view.mbfullview.BaseView$a r1 = com.mbridge.msdk.nativex.view.mbfullview.BaseView.a.FULL_TOP_VIEW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.nativex.view.MBMediaView.AnonymousClass9.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public View v() {
        try {
            this.ae = new RelativeLayout(getContext());
            this.ae.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.af = new ImageView(getContext());
            this.af.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 30.0f), u.b(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = u.b(getContext(), 8.0f);
            layoutParams.rightMargin = u.b(getContext(), 8.0f);
            this.af.setLayoutParams(layoutParams);
            this.af.setBackgroundResource(k.a(getContext(), "mbridge_nativex_close", "drawable"));
            this.af.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBMediaView.this.exitFullScreen();
                }
            });
            this.y.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.ae.addView(this.y);
            this.ae.addView(this.af);
            return this.ae;
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
            return null;
        }
    }

    public void exitFullScreen() {
        try {
            w();
            if (this.b) {
                this.t.onClickPlayButton();
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    public void showEndCardWebViewCloseBtn() {
        ImageView imageView = this.af;
        if (imageView != null && imageView.getVisibility() != 0) {
            this.af.setVisibility(0);
        }
    }

    public void hideEndCardWebViewCloseBtn() {
        ImageView imageView = this.af;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.af.setVisibility(8);
        }
    }

    /* JADX WARNING: type inference failed for: r0v42, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v23, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w() {
        /*
            r12 = this;
            java.lang.String r0 = "mbridge_full_player_parent"
            java.lang.String r1 = "mbridge_full_rl_playcontainer"
            java.lang.String r2 = "id"
            android.view.View r3 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r3.findViewById(r4)     // Catch:{ Exception -> 0x023e }
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3     // Catch:{ Exception -> 0x023e }
            android.view.View r4 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            r5 = 100
            android.view.View r4 = r4.findViewById(r5)     // Catch:{ Exception -> 0x023e }
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4     // Catch:{ Exception -> 0x023e }
            android.view.View r5 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            r6 = 101(0x65, float:1.42E-43)
            android.view.View r5 = r5.findViewById(r6)     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5     // Catch:{ Exception -> 0x023e }
            android.view.View r6 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            r7 = 103(0x67, float:1.44E-43)
            android.view.View r6 = r6.findViewById(r7)     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6     // Catch:{ Exception -> 0x023e }
            if (r6 != 0) goto L_0x0041
            if (r5 == 0) goto L_0x0041
            android.view.View r6 = r5.findViewById(r7)     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6     // Catch:{ Exception -> 0x023e }
        L_0x0041:
            android.view.View r7 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            android.content.Context r8 = r12.getContext()     // Catch:{ Exception -> 0x023e }
            int r8 = com.mbridge.msdk.foundation.tools.k.a(r8, r1, r2)     // Catch:{ Exception -> 0x023e }
            android.view.View r7 = r7.findViewById(r8)     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7     // Catch:{ Exception -> 0x023e }
            if (r7 != 0) goto L_0x0066
            if (r6 == 0) goto L_0x0066
            android.content.Context r7 = r12.getContext()     // Catch:{ Exception -> 0x023e }
            int r1 = com.mbridge.msdk.foundation.tools.k.a(r7, r1, r2)     // Catch:{ Exception -> 0x023e }
            android.view.View r1 = r6.findViewById(r1)     // Catch:{ Exception -> 0x023e }
            r7 = r1
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7     // Catch:{ Exception -> 0x023e }
        L_0x0066:
            android.view.View r1 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            android.content.Context r8 = r12.getContext()     // Catch:{ Exception -> 0x023e }
            int r8 = com.mbridge.msdk.foundation.tools.k.a(r8, r0, r2)     // Catch:{ Exception -> 0x023e }
            android.view.View r1 = r1.findViewById(r8)     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1     // Catch:{ Exception -> 0x023e }
            if (r1 != 0) goto L_0x008b
            if (r7 == 0) goto L_0x008b
            android.content.Context r1 = r12.getContext()     // Catch:{ Exception -> 0x023e }
            int r0 = com.mbridge.msdk.foundation.tools.k.a(r1, r0, r2)     // Catch:{ Exception -> 0x023e }
            android.view.View r0 = r7.findViewById(r0)     // Catch:{ Exception -> 0x023e }
            r1 = r0
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1     // Catch:{ Exception -> 0x023e }
        L_0x008b:
            android.view.View r0 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            android.content.Context r8 = r12.getContext()     // Catch:{ Exception -> 0x023e }
            java.lang.String r9 = "mbridge_full_pb_loading"
            int r8 = com.mbridge.msdk.foundation.tools.k.a(r8, r9, r2)     // Catch:{ Exception -> 0x023e }
            android.view.View r0 = r0.findViewById(r8)     // Catch:{ Exception -> 0x023e }
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0     // Catch:{ Exception -> 0x023e }
            android.view.View r8 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            android.content.Context r9 = r12.getContext()     // Catch:{ Exception -> 0x023e }
            java.lang.String r10 = "mbridge_full_rl_install"
            int r9 = com.mbridge.msdk.foundation.tools.k.a(r9, r10, r2)     // Catch:{ Exception -> 0x023e }
            android.view.View r8 = r8.findViewById(r9)     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8     // Catch:{ Exception -> 0x023e }
            android.view.View r9 = r12.getRootView()     // Catch:{ Exception -> 0x023e }
            android.content.Context r10 = r12.getContext()     // Catch:{ Exception -> 0x023e }
            java.lang.String r11 = "mbridge_full_ll_pro_dur"
            int r2 = com.mbridge.msdk.foundation.tools.k.a(r10, r11, r2)     // Catch:{ Exception -> 0x023e }
            android.view.View r2 = r9.findViewById(r2)     // Catch:{ Exception -> 0x023e }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x023e }
            r9 = 0
            if (r4 == 0) goto L_0x00d1
            android.view.ViewParent r10 = r4.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r10 = (android.view.ViewGroup) r10     // Catch:{ Exception -> 0x023e }
            goto L_0x00d2
        L_0x00d1:
            r10 = r9
        L_0x00d2:
            if (r6 == 0) goto L_0x00d8
            r6.removeView(r2)     // Catch:{ Exception -> 0x023e }
            goto L_0x00e9
        L_0x00d8:
            if (r2 == 0) goto L_0x00e9
            android.view.ViewParent r11 = r2.getParent()     // Catch:{ Exception -> 0x023e }
            if (r11 == 0) goto L_0x00e9
            android.view.ViewParent r11 = r2.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r11 = (android.view.ViewGroup) r11     // Catch:{ Exception -> 0x023e }
            r11.removeView(r2)     // Catch:{ Exception -> 0x023e }
        L_0x00e9:
            android.widget.RelativeLayout r2 = r12.ae     // Catch:{ Exception -> 0x023e }
            if (r2 == 0) goto L_0x0118
            if (r6 == 0) goto L_0x00f5
            android.widget.RelativeLayout r2 = r12.ae     // Catch:{ Exception -> 0x023e }
            r6.removeView(r2)     // Catch:{ Exception -> 0x023e }
            goto L_0x010a
        L_0x00f5:
            android.widget.RelativeLayout r2 = r12.ae     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r2 = r2.getParent()     // Catch:{ Exception -> 0x023e }
            if (r2 == 0) goto L_0x010a
            android.widget.RelativeLayout r2 = r12.ae     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r2 = r2.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r11 = r12.ae     // Catch:{ Exception -> 0x023e }
            r2.removeView(r11)     // Catch:{ Exception -> 0x023e }
        L_0x010a:
            com.mbridge.msdk.nativex.view.WindVaneWebViewForNV r2 = r12.y     // Catch:{ Exception -> 0x023e }
            r2.setBackListener(r9)     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.nativex.view.WindVaneWebViewForNV r2 = r12.y     // Catch:{ Exception -> 0x023e }
            r2.setObject(r9)     // Catch:{ Exception -> 0x023e }
            r12.y = r9     // Catch:{ Exception -> 0x023e }
            r12.ae = r9     // Catch:{ Exception -> 0x023e }
        L_0x0118:
            if (r6 == 0) goto L_0x011e
            r6.removeView(r8)     // Catch:{ Exception -> 0x023e }
            goto L_0x012f
        L_0x011e:
            if (r8 == 0) goto L_0x012f
            android.view.ViewParent r2 = r8.getParent()     // Catch:{ Exception -> 0x023e }
            if (r2 == 0) goto L_0x012f
            android.view.ViewParent r2 = r8.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ Exception -> 0x023e }
            r2.removeView(r8)     // Catch:{ Exception -> 0x023e }
        L_0x012f:
            if (r6 == 0) goto L_0x0135
            r6.removeView(r0)     // Catch:{ Exception -> 0x023e }
            goto L_0x0146
        L_0x0135:
            if (r0 == 0) goto L_0x0146
            android.view.ViewParent r2 = r0.getParent()     // Catch:{ Exception -> 0x023e }
            if (r2 == 0) goto L_0x0146
            android.view.ViewParent r2 = r0.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ Exception -> 0x023e }
            r2.removeView(r0)     // Catch:{ Exception -> 0x023e }
        L_0x0146:
            if (r1 == 0) goto L_0x014d
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r0 = r12.t     // Catch:{ Exception -> 0x023e }
            r1.removeView(r0)     // Catch:{ Exception -> 0x023e }
        L_0x014d:
            if (r7 == 0) goto L_0x0153
            r7.removeView(r1)     // Catch:{ Exception -> 0x023e }
            goto L_0x0166
        L_0x0153:
            if (r1 == 0) goto L_0x0166
            android.view.ViewParent r0 = r1.getParent()     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x0166
            android.view.ViewParent r0 = r1.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            r0.removeView(r1)     // Catch:{ Exception -> 0x023e }
        L_0x0166:
            if (r6 == 0) goto L_0x016c
            r6.removeView(r7)     // Catch:{ Exception -> 0x023e }
            goto L_0x018b
        L_0x016c:
            if (r7 == 0) goto L_0x0180
            android.view.ViewParent r0 = r7.getParent()     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x0180
            android.view.ViewParent r0 = r7.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            r0.removeView(r7)     // Catch:{ Exception -> 0x023e }
            goto L_0x018b
        L_0x0180:
            com.mbridge.msdk.nativex.view.mbfullview.BaseView r0 = r12.C     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x018b
            com.mbridge.msdk.nativex.view.mbfullview.BaseView r0 = r12.C     // Catch:{ Exception -> 0x023e }
            android.widget.RelativeLayout r1 = r12.D     // Catch:{ Exception -> 0x023e }
            r0.removeView(r1)     // Catch:{ Exception -> 0x023e }
        L_0x018b:
            if (r5 == 0) goto L_0x0191
            r5.removeView(r6)     // Catch:{ Exception -> 0x023e }
            goto L_0x01bf
        L_0x0191:
            if (r6 == 0) goto L_0x01a5
            android.view.ViewParent r0 = r6.getParent()     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x01a5
            android.view.ViewParent r0 = r6.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            r0.removeView(r6)     // Catch:{ Exception -> 0x023e }
            goto L_0x01bf
        L_0x01a5:
            android.view.View r0 = r12.B     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x01bf
            android.view.View r0 = r12.B     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.nativex.view.mbfullview.BaseView r1 = r12.C     // Catch:{ Exception -> 0x023e }
            r0.removeView(r1)     // Catch:{ Exception -> 0x023e }
            android.view.View r0 = r12.B     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            android.view.View r1 = r12.B     // Catch:{ Exception -> 0x023e }
            r0.removeView(r1)     // Catch:{ Exception -> 0x023e }
        L_0x01bf:
            if (r3 == 0) goto L_0x01e8
            if (r5 == 0) goto L_0x01c7
            r3.removeView(r5)     // Catch:{ Exception -> 0x023e }
            goto L_0x01e8
        L_0x01c7:
            android.view.View r0 = r12.B     // Catch:{ Exception -> 0x023e }
            r3.removeView(r0)     // Catch:{ Exception -> 0x023e }
            android.view.View r0 = r12.B     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x01e8
            android.view.View r0 = r12.B     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x023e }
            android.view.View r1 = r12.B     // Catch:{ Exception -> 0x023e }
            r0.removeView(r1)     // Catch:{ Exception -> 0x023e }
            android.view.View r0 = r12.B     // Catch:{ Exception -> 0x023e }
            r1 = 8
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x023e }
        L_0x01e8:
            r0 = 0
            r12.setVisibility(r0)     // Catch:{ Exception -> 0x023e }
            r12.requestLayout()     // Catch:{ Exception -> 0x023e }
            if (r10 == 0) goto L_0x021b
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r1 = r12.t     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x023e }
            if (r1 == 0) goto L_0x020e
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r1 = r12.t     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x023e }
            if (r1 == r10) goto L_0x020e
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r1 = r12.t     // Catch:{ Exception -> 0x023e }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x023e }
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r2 = r12.t     // Catch:{ Exception -> 0x023e }
            r1.removeView(r2)     // Catch:{ Exception -> 0x023e }
        L_0x020e:
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r1 = r12.t     // Catch:{ Exception -> 0x023e }
            int r2 = r12.I     // Catch:{ Exception -> 0x023e }
            r10.addView(r1, r2)     // Catch:{ Exception -> 0x023e }
            r10.removeView(r4)     // Catch:{ Exception -> 0x023e }
            r10.invalidate()     // Catch:{ Exception -> 0x023e }
        L_0x021b:
            r12.i()     // Catch:{ Exception -> 0x023e }
            r12.h = r0     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r0 = r12.t     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x0248
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r0 = r12.t     // Catch:{ Exception -> 0x023e }
            r0.setExitFullScreen()     // Catch:{ Exception -> 0x023e }
            boolean r0 = r12.f     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x0233
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r0 = r12.t     // Catch:{ Exception -> 0x023e }
            r0.openSound()     // Catch:{ Exception -> 0x023e }
            goto L_0x0238
        L_0x0233:
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r0 = r12.t     // Catch:{ Exception -> 0x023e }
            r0.closeSound()     // Catch:{ Exception -> 0x023e }
        L_0x0238:
            com.mbridge.msdk.nativex.view.MediaViewPlayerView r0 = r12.t     // Catch:{ Exception -> 0x023e }
            r0.gonePauseView()     // Catch:{ Exception -> 0x023e }
            goto L_0x0248
        L_0x023e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "MBMediaView"
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)
        L_0x0248:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.nativex.view.MBMediaView.w():void");
    }

    private boolean x() {
        try {
            this.D = this.C.getMBridgeFullPlayContainer();
            this.H = this.C.getMBridgeFullPlayerParent();
            this.E = this.C.getMBridgeFullClose();
            this.F = this.C.getMBridgeFullTvInstall();
            this.G = this.C.getMBridgeFullPb();
            return true;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return false;
        }
    }

    private void y() {
        try {
            this.i = u.i(getContext()) >= u.j(getContext());
            this.j = this.i;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    private void z() {
        try {
            if (this.K == null) {
                return;
            }
            if (!x.a(this.K.getVideoResolution())) {
                String[] split = this.K.getVideoResolution().split("x");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    double b2 = u.b(str);
                    double b3 = u.b(str2);
                    if (b2 > 0.0d && b3 > 0.0d) {
                        this.N = b2;
                        this.O = b3;
                    }
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public float A() {
        try {
            float i2 = (float) u.i(getContext());
            return this.i ? i2 + ((float) u.k(getContext())) : i2;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return 0.0f;
        }
    }

    private float B() {
        try {
            float j2 = (float) u.j(getContext());
            return !this.i ? j2 + ((float) u.k(getContext())) : j2;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return 0.0f;
        }
    }

    private boolean c(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private void a(View view, float f2, float f3) {
        if (view != null) {
            try {
                double d2 = 0.0d;
                if (this.N > 0.0d) {
                    if (this.O > 0.0d) {
                        double d3 = this.N / this.O;
                        if (f2 > 0.0f && f3 > 0.0f) {
                            d2 = (double) (f2 / f3);
                        }
                        double a2 = u.a(Double.valueOf(d3));
                        double a3 = u.a(Double.valueOf(d2));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        boolean z2 = c(getContext()) && this.i;
                        int i2 = -1;
                        if (a2 > a3) {
                            double d4 = (((double) f2) * this.O) / this.N;
                            layoutParams2.width = -1;
                            if (!z2) {
                                i2 = (int) d4;
                            }
                            layoutParams2.height = i2;
                            layoutParams2.addRule(13);
                            layoutParams.width = this.M;
                            layoutParams.height = (int) d4;
                            layoutParams.addRule(13);
                        } else if (a2 < a3) {
                            double d5 = ((double) f3) * d3;
                            layoutParams2.width = z2 ? -1 : (int) d5;
                            layoutParams2.height = -1;
                            layoutParams2.addRule(13);
                            layoutParams.width = (int) d5;
                            layoutParams.height = this.L;
                            layoutParams.addRule(13);
                        } else {
                            layoutParams2.width = -1;
                            layoutParams2.height = -1;
                            layoutParams.width = this.M;
                            layoutParams.height = this.L;
                            layoutParams.addRule(13);
                        }
                        if (!this.h) {
                            this.u.setLayoutParams(layoutParams);
                        }
                        view.setLayoutParams(layoutParams2);
                        return;
                    }
                }
                b(view);
            } catch (Throwable th) {
                q.d(TAG, th.getMessage());
            }
        }
    }

    private void b(View view) {
        if (view != null) {
            try {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = -1;
                if (this.i) {
                    layoutParams.height = -1;
                } else {
                    layoutParams.height = (((int) A()) * 9) / 16;
                    layoutParams.addRule(13);
                }
                view.setLayoutParams(layoutParams);
            } catch (Exception e2) {
                q.d(TAG, e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        try {
            if (this.E != null || this.af != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 30.0f), u.b(getContext(), 30.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.topMargin = u.b(getContext(), 8.0f);
                layoutParams.rightMargin = u.b(getContext(), 8.0f);
                if (this.E != null) {
                    this.E.setLayoutParams(layoutParams);
                }
                if (this.af != null) {
                    this.af.setLayoutParams(layoutParams);
                }
                updateViewManger(false);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        try {
            if (this.E != null || this.af != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 30.0f), u.b(getContext(), 30.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                if (this.ab != 0 || !u.a(getContext())) {
                    layoutParams.rightMargin = u.b(getContext(), 8.0f);
                } else {
                    layoutParams.rightMargin = u.k(getContext()) + u.b(getContext(), 8.0f);
                }
                layoutParams.topMargin = u.b(getContext(), 8.0f);
                if (this.E != null) {
                    this.E.setLayoutParams(layoutParams);
                }
                if (this.af != null) {
                    this.af.setLayoutParams(layoutParams);
                }
                updateViewManger(true);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public void updateViewManger(boolean z2) {
        com.mbridge.msdk.nativex.view.mbfullview.a a2 = com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext());
        boolean z3 = true;
        int i2 = 0;
        if (a2 != null) {
            try {
                this.C.getmAnimationPlayer().clearAnimation();
                a2.a(z2, !this.t.isComplete(), this.C);
                a2.a(z2, this.C, this.ab);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if ((this.C instanceof MBridgeTopFullView) && a2 != null) {
            if (z2) {
                z3 = false;
            }
            BaseView baseView = this.C;
            if (baseView instanceof MBridgeTopFullView) {
                MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
                if (!z3) {
                    i2 = 8;
                }
                mBridgeTopFullView.getMBridgeFullViewDisplayIcon().setVisibility(i2);
                mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setVisibility(i2);
                mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setVisibility(i2);
                mBridgeTopFullView.getStarLevelLayoutView().setVisibility(i2);
            }
        }
    }

    private void E() {
        int i2;
        try {
            if (this.K != null && this.K.getNativeVideoTracking() != null) {
                String[] a2 = this.K.getNativeVideoTracking().a();
                if (this.i) {
                    i2 = o;
                } else {
                    i2 = p;
                }
                for (String str : a2) {
                    if (!TextUtils.isEmpty(str)) {
                        com.mbridge.msdk.click.a.a(getContext(), this.K, this.K.getCampaignUnitId(), str + "&orienation=" + i2, false, false);
                    }
                }
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    public void changeNoticeURL() {
        String str;
        CampaignEx campaignEx = this.K;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (!TextUtils.isEmpty(noticeUrl)) {
                if (!noticeUrl.contains("is_video")) {
                    if (this.V == a.VIDEO) {
                        str = "1";
                    } else {
                        str = this.V == a.BIG_IMAGE ? "2" : "";
                    }
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&is_video=");
                        sb.append(str);
                    } else {
                        sb.append("?is_video=");
                        sb.append(str);
                    }
                    noticeUrl = sb.toString();
                } else if (this.V == a.VIDEO) {
                    if (noticeUrl.contains("is_video=2")) {
                        noticeUrl = noticeUrl.replace("is_video=2", "is_video=1");
                    }
                } else if (this.V == a.BIG_IMAGE && noticeUrl.contains("is_video=1")) {
                    noticeUrl = noticeUrl.replace("is_video=1", "is_video=2");
                }
                this.K.setNoticeUrl(noticeUrl);
            }
        }
    }

    public String getAddNVT2ToNoticeURL() {
        CampaignEx campaignEx = this.K;
        if (campaignEx == null) {
            return null;
        }
        String noticeUrl = campaignEx.getNoticeUrl();
        if (TextUtils.isEmpty(noticeUrl) || noticeUrl.contains(CampaignEx.JSON_KEY_NV_T2)) {
            return noticeUrl;
        }
        return noticeUrl + "&nv_t2=" + this.K.getNvT2();
    }

    public boolean canShowVideo() {
        if (a(false) == a.VIDEO) {
            return true;
        }
        return false;
    }

    private class e implements SensorEventListener {
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        private e() {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            int i;
            if (!MBMediaView.this.ah) {
                try {
                    float[] fArr = sensorEvent.values;
                    float f = -fArr[0];
                    float f2 = -fArr[1];
                    float f3 = -fArr[2];
                    if (((f * f) + (f2 * f2)) * 4.0f >= f3 * f3) {
                        i = 90 - Math.round(((float) Math.atan2((double) (-f2), (double) f)) * 57.29578f);
                        while (i >= 360) {
                            i -= 360;
                        }
                        while (i < 0) {
                            i += 360;
                        }
                    } else {
                        i = -1;
                    }
                    float B = MBMediaView.this.A();
                    int j = u.j(MBMediaView.this.getContext());
                    if ((i <= 45 || i >= 135) && (i <= 225 || i >= 315)) {
                        if (((i > 135 && i < 225) || ((i > 315 && i < 360) || ((i >= 0 && i <= 45) || i == -1))) && B <= ((float) j) && MBMediaView.this.j) {
                            boolean unused = MBMediaView.this.i = false;
                            boolean unused2 = MBMediaView.this.j = false;
                            MBMediaView.this.J.postDelayed(new Runnable() {
                                public final void run() {
                                    try {
                                        com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(MBMediaView.this.C, MBMediaView.this.i);
                                        MBMediaView.this.C();
                                        MBMediaView.this.h();
                                        MBMediaView.this.f();
                                        MBMediaView.this.g();
                                        if (MBMediaView.this.y != null) {
                                            MBMediaView.this.y.orientation(MBMediaView.this.i);
                                        }
                                    } catch (Exception e) {
                                        q.d(MBMediaView.TAG, e.getMessage());
                                    }
                                }
                            }, 200);
                        }
                    } else if (B >= ((float) j) && !MBMediaView.this.j) {
                        boolean unused3 = MBMediaView.this.i = true;
                        boolean unused4 = MBMediaView.this.j = true;
                        MBMediaView.this.J.postDelayed(new Runnable() {
                            public final void run() {
                                try {
                                    com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(MBMediaView.this.C, MBMediaView.this.i);
                                    MBMediaView.this.D();
                                    MBMediaView.this.h();
                                    MBMediaView.this.f();
                                    MBMediaView.this.g();
                                    if (MBMediaView.this.y != null) {
                                        MBMediaView.this.y.orientation(MBMediaView.this.i);
                                    }
                                } catch (Exception e) {
                                    q.d(MBMediaView.TAG, e.getMessage());
                                }
                            }
                        }, 200);
                    }
                } catch (Throwable th) {
                    q.a(MBMediaView.TAG, th.getMessage(), th);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public WindVaneWebViewForNV F() {
        try {
            if (this.y != null && this.ad) {
                return this.y;
            }
            if (this.ad) {
                return null;
            }
            b(true);
            return null;
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
            return null;
        }
    }

    private void b(boolean z2) {
        try {
            int nvT2 = this.K.getNvT2();
            if (this.y == null) {
                this.y = new WindVaneWebViewForNV(getContext());
                this.y.setObject(this);
                this.y.setBackListener(new com.mbridge.msdk.nativex.listener.b() {
                    public final void a() {
                        MBMediaView.this.exitFullScreen();
                    }
                });
                this.y.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
                    public final void a(WebView webView, String str) {
                        super.a(webView, str);
                        boolean unused = MBMediaView.this.ac = true;
                    }

                    public final void a(WebView webView, int i, String str, String str2) {
                        super.a(webView, i, str, str2);
                        boolean unused = MBMediaView.this.ac = false;
                    }
                });
            }
            if (nvT2 == 3) {
                String str = this.K.getendcard_url();
                if (!TextUtils.isEmpty(str)) {
                    this.K.getMediaViewHolder();
                    if (!str.contains(".zip") || !str.contains("md5filename")) {
                        String b2 = h.a().b(str);
                        if (x.b(b2)) {
                            q.a(TAG, "load html...");
                            this.ad = true;
                            this.y.loadDataWithBaseURL(str, b2, "text/html", "UTF-8", (String) null);
                            return;
                        }
                        return;
                    }
                    String b3 = com.mbridge.msdk.videocommon.download.g.a().b(str);
                    if (x.b(b3)) {
                        this.ad = true;
                        this.y.loadUrl(b3);
                    }
                }
            } else if (nvT2 == 4) {
                this.ad = true;
                if (this.K != null) {
                    BrowserView.MBDownloadListener mBDownloadListener = new BrowserView.MBDownloadListener(this.K);
                    mBDownloadListener.setTitle(this.K.getAppName());
                    this.y.setDownloadListener(mBDownloadListener);
                    this.y.setFilter(new d());
                }
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    private static final class g extends WebViewClient {
        WeakReference<MBMediaView> a;

        public g(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                MBMediaView mBMediaView = (MBMediaView) this.a.get();
                if (mBMediaView != null && mBMediaView.V != null && mBMediaView.V == a.BIG_IMAGE) {
                    mBMediaView.l();
                    a unused = mBMediaView.V = a.GIF;
                    mBMediaView.changeNoticeURL();
                }
            } catch (Exception e) {
                q.d(MBMediaView.TAG, e.getMessage());
            }
        }
    }

    private static final class f implements com.mbridge.msdk.videocommon.listener.a {
        WeakReference<MBMediaView> a;

        public final void a(String str, String str2) {
        }

        public f(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        public final void a(String str) {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                mBMediaView.J.post(new b(mBMediaView));
            }
        }
    }

    private static final class b implements Runnable {
        WeakReference<MBMediaView> a;

        public b(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        public final void run() {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                try {
                    if (mBMediaView.V != null && mBMediaView.V == a.BIG_IMAGE) {
                        mBMediaView.e();
                        a unused = mBMediaView.V = a.VIDEO;
                        mBMediaView.changeNoticeURL();
                    }
                } catch (Throwable th) {
                    q.a(MBMediaView.TAG, th.getMessage(), th);
                }
            }
        }
    }

    private static final class c implements com.mbridge.msdk.nativex.listener.a {
        WeakReference<MBMediaView> a;

        public c(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        public final void a() {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                MBMediaView.L(mBMediaView);
            }
        }

        public final void b() {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                MBMediaView.M(mBMediaView);
            }
        }

        public final void c() {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                MBMediaView.N(mBMediaView);
            }
        }

        public final void d() {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                MBMediaView.O(mBMediaView);
            }
        }

        public final void a(String str) {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                mBMediaView.a(str);
            }
        }

        public final void b(String str) {
            MBMediaView mBMediaView = (MBMediaView) this.a.get();
            if (mBMediaView != null) {
                mBMediaView.b(str);
            }
        }
    }

    public BaseView.a handleViewStyleResult(Context context) {
        int nvT2 = this.K.getNvT2();
        if (nvT2 == 1) {
            b(context);
        } else if (nvT2 == 2 || nvT2 == 3 || nvT2 == 4) {
            return BaseView.a.FULL_MIDDLE_VIEW;
        } else {
            if (nvT2 == 6) {
                return BaseView.a.FULL_TOP_VIEW;
            }
        }
        return null;
    }

    private static final class d implements com.mbridge.msdk.mbsignalcommon.base.a {
        private d() {
        }

        public final boolean a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (t.a.a(str)) {
                        t.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, (NativeListener.NativeTrackingListener) null);
                        return true;
                    } else if (URLUtil.isNetworkUrl(str)) {
                        return false;
                    } else {
                        t.b(com.mbridge.msdk.foundation.controller.a.e().g(), str, (NativeListener.NativeTrackingListener) null);
                        return true;
                    }
                }
            } catch (Exception e) {
                q.d(MBMediaView.TAG, e.getMessage());
            }
            return false;
        }
    }

    public void setProgressVisibility(boolean z2) {
        this.k = z2;
        MediaViewPlayerView mediaViewPlayerView = this.t;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showProgressView(this.k);
        }
    }

    public void setSoundIndicatorVisibility(boolean z2) {
        this.l = z2;
        MediaViewPlayerView mediaViewPlayerView = this.t;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showSoundIndicator(this.l);
        }
    }

    public void setVideoSoundOnOff(boolean z2) {
        this.f = z2;
        MediaViewPlayerView mediaViewPlayerView = this.t;
        if (mediaViewPlayerView == null) {
            return;
        }
        if (this.f) {
            mediaViewPlayerView.openSound();
        } else {
            mediaViewPlayerView.closeSound();
        }
    }

    public BaseView getFullScreenViewByStyle(Context context, BaseView.a aVar) {
        BaseView baseView;
        int i2 = AnonymousClass9.a[aVar.ordinal()];
        if (i2 == 1) {
            baseView = new MBridgeFullView(context);
        } else if (i2 != 2) {
            baseView = null;
        } else {
            baseView = new MBridgeTopFullView(context);
        }
        baseView.setStytle(aVar);
        return baseView;
    }

    public void setFullScreenViewBackgroundColor(int i2) {
        this.s = i2;
    }

    public void setFollowActivityOrientation(boolean z2) {
        this.ah = z2;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ah && this.ag != configuration.orientation) {
            this.ag = configuration.orientation;
            boolean z2 = true;
            this.i = this.ag == 0;
            if (this.ag != 0) {
                z2 = false;
            }
            this.j = z2;
            this.J.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(MBMediaView.this.C, MBMediaView.this.i);
                        if (MBMediaView.this.ag == 0) {
                            MBMediaView.this.D();
                        } else {
                            MBMediaView.this.C();
                        }
                        MBMediaView.this.h();
                        MBMediaView.this.f();
                        MBMediaView.this.g();
                        if (MBMediaView.this.y != null) {
                            MBMediaView.this.y.orientation(MBMediaView.this.i);
                        }
                    } catch (Exception e) {
                        q.d(MBMediaView.TAG, e.getMessage());
                    }
                }
            }, 200);
        }
    }

    public boolean ismCurIsFullScreen() {
        return this.h;
    }

    public void cai(Object obj, String str) {
        q.a(TAG, "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(optString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "packageName is empty");
                }
                int i2 = u.c(com.mbridge.msdk.foundation.controller.a.e().g(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.b.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, i2);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, e2.getMessage());
                    q.a(TAG, e2.getMessage());
                }
            } catch (JSONException e3) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + e3.getLocalizedMessage());
                q.a(TAG, "cai", e3);
            } catch (Throwable th) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + th.getLocalizedMessage());
                q.a(TAG, "cai", th);
            }
        }
    }

    public void getEndScreenInfo(Object obj, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.K);
            String a2 = a((List<CampaignEx>) arrayList, o(), "MAL_16.0.11,3.0.1");
            String encodeToString = !TextUtils.isEmpty(a2) ? Base64.encodeToString(a2.getBytes(), 2) : "";
            q.d(TAG, "getEndScreenInfo-mCampaign.name:" + this.K.getAppName());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, encodeToString);
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public void install(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            if (this.ai != null) {
                b(this.ai);
            } else if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                b(windVaneWebView.getContext());
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        q.d(TAG, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
            return;
        }
        Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
        if (!TextUtils.isEmpty(str)) {
            if (g2 == null) {
                try {
                    if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                        g2 = windVaneWebView.getContext();
                    }
                } catch (Exception e2) {
                    q.d(TAG, e2.getMessage());
                }
            }
            if (g2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("url");
                    int optInt = jSONObject.optInt("type");
                    if (optInt == 1) {
                        com.mbridge.msdk.click.b.a(g2, optString);
                    } else if (optInt == 2) {
                        com.mbridge.msdk.click.b.b(g2, optString);
                    }
                } catch (JSONException e3) {
                    q.d(TAG, e3.getMessage());
                } catch (Throwable th) {
                    q.d(TAG, th.getMessage());
                }
            }
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, 1);
                } catch (Exception e2) {
                    q.d(TAG, e2.getMessage());
                }
            }
            q.d(TAG, "SHOW CLOSE BTN ");
            showEndCardWebViewCloseBtn();
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, a(0));
        } catch (Exception e3) {
            q.d(TAG, e3.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().b(obj, a(1));
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            exitFullScreen();
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, a(0));
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().b(obj, a(1));
        }
    }

    private String a(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            q.d(TAG, "code to string is error");
            return "";
        }
    }

    private String a(List<CampaignEx> list, String str, String str2) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONArray parseCamplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("campaignList", parseCamplistToJson);
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sdk_info", str2);
            return jSONObject.toString();
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        try {
            if (this.W != null) {
                this.W.onVideoAdClicked(this.K);
            }
            if (this.aa != null) {
                this.aa.onVideoAdClicked(this.K);
            }
        } catch (Exception e2) {
            try {
                q.d(TAG, e2.getMessage());
            } catch (Exception e3) {
                q.d(TAG, e3.getMessage());
                return;
            }
        }
        if (this.K == null) {
            return;
        }
        if (!x.a(o())) {
            if (!this.K.isReportClick()) {
                this.K.setReportClick(true);
                if (!(this.K == null || this.K.getNativeVideoTracking() == null || this.K.getNativeVideoTracking().e() == null)) {
                    com.mbridge.msdk.click.a.a(getContext(), this.K, this.K.getCampaignUnitId(), this.K.getNativeVideoTracking().e(), false, false);
                }
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), o());
            aVar.a((NativeListener.NativeTrackingListener) new NativeListener.NativeTrackingListener() {
                public final void onDismissLoading(Campaign campaign) {
                }

                public final void onDownloadFinish(Campaign campaign) {
                }

                public final void onDownloadProgress(int i) {
                }

                public final void onDownloadStart(Campaign campaign) {
                }

                public final boolean onInterceptDefaultLoadingDialog() {
                    return true;
                }

                public final void onShowLoading(Campaign campaign) {
                }

                public final void onStartRedirection(Campaign campaign, String str) {
                    try {
                        MBMediaView.m(MBMediaView.this);
                        MBMediaView.n(MBMediaView.this);
                        MBMediaView.a(MBMediaView.this, campaign, str);
                    } catch (Exception e) {
                        q.d(MBMediaView.TAG, e.getMessage());
                    }
                }

                public final void onRedirectionFailed(Campaign campaign, String str) {
                    try {
                        MBMediaView.o(MBMediaView.this);
                        MBMediaView.p(MBMediaView.this);
                        MBMediaView.b(MBMediaView.this, campaign, str);
                    } catch (Exception e) {
                        q.d(MBMediaView.TAG, e.getMessage());
                    }
                }

                public final void onFinishRedirection(Campaign campaign, String str) {
                    try {
                        MBMediaView.o(MBMediaView.this);
                        MBMediaView.p(MBMediaView.this);
                        MBMediaView.c(MBMediaView.this, campaign, str);
                    } catch (Exception e) {
                        q.d(MBMediaView.TAG, e.getMessage());
                    }
                }
            });
            aVar.a(this.K);
        }
    }

    public void onPlayProgress(int i2, int i3) {
        int i4;
        String str;
        CampaignEx.b mediaViewHolder;
        CampaignEx.b mediaViewHolder2;
        int i5 = i2;
        try {
            if (!(this.K == null || (mediaViewHolder2 = this.K.getMediaViewHolder()) == null || mediaViewHolder2.h || mediaViewHolder2.l == null || mediaViewHolder2.l.size() <= 0)) {
                Map<Integer, String> map = mediaViewHolder2.l;
                Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str2 = (String) next.getValue();
                    if (i5 >= ((Integer) next.getKey()).intValue() && !TextUtils.isEmpty(str2)) {
                        com.mbridge.msdk.click.a.a(getContext(), this.K, this.K.getCampaignUnitId(), str2, false, false);
                        it.remove();
                    }
                }
                if (map.size() <= 0) {
                    mediaViewHolder2.h = true;
                }
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
        int i6 = 0;
        try {
            if (!(this.K == null || (mediaViewHolder = this.K.getMediaViewHolder()) == null || mediaViewHolder.i || i3 == 0)) {
                List<Map<Integer, String>> b2 = this.K.getNativeVideoTracking().b();
                int i7 = ((i5 + 1) * 100) / i3;
                if (b2 != null) {
                    int i8 = 0;
                    while (i8 < b2.size()) {
                        Map map2 = b2.get(i8);
                        if (map2 != null && map2.size() > 0) {
                            Iterator it2 = map2.entrySet().iterator();
                            while (it2.hasNext()) {
                                Map.Entry entry = (Map.Entry) it2.next();
                                int intValue = ((Integer) entry.getKey()).intValue();
                                String str3 = (String) entry.getValue();
                                if (intValue <= i7 && !TextUtils.isEmpty(str3)) {
                                    com.mbridge.msdk.click.a.a(getContext(), this.K, this.K.getCampaignUnitId(), new String[]{str3}, false, true);
                                    it2.remove();
                                    b2.remove(i8);
                                    i8--;
                                }
                            }
                        }
                        i8++;
                    }
                    if (b2.size() <= 0) {
                        mediaViewHolder.i = true;
                    }
                }
            }
        } catch (Throwable unused) {
            q.d(TAG, "reportPlayPercentageData error");
        }
        if (s() != 100 && !this.aj) {
            if (t() != null) {
                i6 = t().f();
            }
            int s2 = s();
            if (s2 != 0) {
                if (i6 > s2) {
                    i6 = s2 / 2;
                }
                if (i6 >= 0 && i5 >= (i4 = (i6 * i3) / 100)) {
                    if (this.K.getAdType() == 94 || this.K.getAdType() == 287) {
                        str = this.K.getRequestId() + this.K.getId() + this.K.getVideoUrlEncode();
                    } else {
                        str = this.K.getId() + this.K.getVideoUrlEncode() + this.K.getBidToken();
                    }
                    com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(o(), str);
                    if (a2 != null) {
                        a2.j();
                        this.aj = true;
                        q.d(TAG, "CDRate is : " + i4 + " and start download !");
                    }
                }
            }
        }
    }

    static /* synthetic */ void b(MBMediaView mBMediaView) {
        CampaignEx campaignEx = mBMediaView.K;
        if (campaignEx != null && campaignEx.getMediaViewHolder() != null) {
            com.mbridge.msdk.foundation.controller.a.e().a(mBMediaView.getContext());
            com.mbridge.msdk.mbnative.d.b.a(mBMediaView.K, mBMediaView.getContext(), mBMediaView.o(), (com.mbridge.msdk.mbnative.c.a) null);
            CampaignEx.b mediaViewHolder = mBMediaView.K.getMediaViewHolder();
            if (!mediaViewHolder.a && mBMediaView.V == a.VIDEO && x.b(mBMediaView.K.getImpressionURL())) {
                mediaViewHolder.a = true;
                String impressionURL = mBMediaView.K.getImpressionURL();
                if (!impressionURL.contains("is_video=1")) {
                    StringBuilder sb = new StringBuilder(impressionURL);
                    if (impressionURL.contains("?")) {
                        sb.append("&is_video=1");
                    } else {
                        sb.append("?is_video=1");
                    }
                    impressionURL = sb.toString();
                }
                Context context = mBMediaView.getContext();
                CampaignEx campaignEx2 = mBMediaView.K;
                com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), impressionURL, false, true);
            }
        }
    }

    static /* synthetic */ void d(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.K;
        if (campaignEx != null && (mediaViewHolder = campaignEx.getMediaViewHolder()) != null && !mediaViewHolder.g && mBMediaView.K.getNativeVideoTracking() != null && mBMediaView.K.getNativeVideoTracking().l() != null) {
            mediaViewHolder.g = true;
            Context context = mBMediaView.getContext();
            CampaignEx campaignEx2 = mBMediaView.K;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.K.getNativeVideoTracking().l(), false, false);
        }
    }

    static /* synthetic */ void h(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.getRootView() != null) {
                if (mBMediaView.getRootView() instanceof ViewGroup) {
                    BaseView.a handleViewStyleResult = mBMediaView.handleViewStyleResult(mBMediaView.getContext());
                    if (handleViewStyleResult != null) {
                        mBMediaView.C = mBMediaView.getFullScreenViewByStyle(mBMediaView.getContext(), handleViewStyleResult);
                        if (mBMediaView.C != null) {
                            if (mBMediaView.x()) {
                                com.mbridge.msdk.nativex.view.mbfullview.a.a(mBMediaView.getContext()).a(mBMediaView.C.style, mBMediaView.K, mBMediaView.C);
                                mBMediaView.h = true;
                                mBMediaView.r = false;
                                if (mBMediaView.t != null) {
                                    mBMediaView.t.setEnterFullScreen();
                                    mBMediaView.t.setIsActivePause(false);
                                }
                                try {
                                    if (mBMediaView.W != null) {
                                        mBMediaView.W.onEnterFullscreen();
                                    }
                                    if (mBMediaView.aa != null) {
                                        mBMediaView.aa.onEnterFullscreen();
                                    }
                                } catch (Exception e2) {
                                    q.d(TAG, e2.getMessage());
                                }
                                FrameLayout frameLayout = (FrameLayout) mBMediaView.getRootView().findViewById(16908290);
                                RelativeLayout relativeLayout = new RelativeLayout(mBMediaView.getContext());
                                mBMediaView.B = relativeLayout;
                                mBMediaView.B.setClickable(true);
                                ViewGroup viewGroup = (ViewGroup) mBMediaView.t.getParent();
                                int childCount = viewGroup.getChildCount();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= childCount) {
                                        break;
                                    } else if (viewGroup.getChildAt(i2) == mBMediaView.t) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                mBMediaView.I = i2;
                                FrameLayout frameLayout2 = new FrameLayout(mBMediaView.getContext());
                                frameLayout2.setId(100);
                                viewGroup.addView(frameLayout2, i2, new ViewGroup.LayoutParams(mBMediaView.getWidth(), mBMediaView.getHeight()));
                                viewGroup.removeView(mBMediaView.t);
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                relativeLayout.setId(101);
                                new RelativeLayout.LayoutParams(-1, -1);
                                mBMediaView.H.addView(mBMediaView.t, new RelativeLayout.LayoutParams(-1, -1));
                                frameLayout.addView(relativeLayout, layoutParams);
                                int i3 = -16777216;
                                int i4 = AnonymousClass9.a[mBMediaView.C.style.ordinal()];
                                if (i4 != 1) {
                                    if (i4 == 2) {
                                        i3 = -1;
                                    }
                                }
                                if (mBMediaView.s != 0) {
                                    relativeLayout.setBackgroundColor(mBMediaView.s);
                                } else {
                                    relativeLayout.setBackgroundColor(i3);
                                }
                                mBMediaView.C.setId(103);
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                                int[] iArr = new int[2];
                                frameLayout.getLocationInWindow(iArr);
                                mBMediaView.ab = iArr[1];
                                if (mBMediaView.ab == 0) {
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        WindowInsets rootWindowInsets = mBMediaView.getRootWindowInsets();
                                        if (rootWindowInsets != null) {
                                            layoutParams2.setMargins(0, rootWindowInsets.getStableInsetTop(), 0, 0);
                                        }
                                    } else {
                                        layoutParams2.setMargins(0, u.e(mBMediaView.getContext()), 0, 0);
                                    }
                                }
                                relativeLayout.addView(mBMediaView.C, layoutParams2);
                                try {
                                    mBMediaView.y();
                                    mBMediaView.a((View) mBMediaView.D, mBMediaView.A(), mBMediaView.B());
                                    com.mbridge.msdk.nativex.view.mbfullview.a.a(mBMediaView.getContext()).a(mBMediaView.C, mBMediaView.i);
                                    if (mBMediaView.i) {
                                        mBMediaView.D();
                                    } else {
                                        mBMediaView.C();
                                    }
                                    mBMediaView.J.postDelayed(new Runnable() {
                                        public final void run() {
                                            boolean unused = MBMediaView.this.r = true;
                                            if (MBMediaView.this.h) {
                                                TextView unused2 = MBMediaView.this.F;
                                            }
                                        }
                                    }, 3000);
                                } catch (Throwable th) {
                                    q.d(TAG, th.getMessage());
                                }
                                try {
                                    mBMediaView.B.setFocusableInTouchMode(true);
                                    mBMediaView.B.requestFocus();
                                    mBMediaView.B.setOnKeyListener(new View.OnKeyListener() {
                                        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                                            try {
                                                if (keyEvent.getKeyCode() != 4) {
                                                    return false;
                                                }
                                                MBMediaView.this.w();
                                                return true;
                                            } catch (Throwable th) {
                                                q.d(MBMediaView.TAG, th.getMessage());
                                                return false;
                                            }
                                        }
                                    });
                                    mBMediaView.B.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            MBMediaView.i(MBMediaView.this);
                                        }
                                    });
                                    mBMediaView.E.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            MBMediaView.this.w();
                                        }
                                    });
                                    mBMediaView.F.setOnClickListener(new com.mbridge.msdk.widget.a() {
                                        /* access modifiers changed from: protected */
                                        public final void a(View view) {
                                            try {
                                                MBMediaView.this.b(view.getContext());
                                            } catch (Exception e) {
                                                q.d(MBMediaView.TAG, e.getMessage());
                                            }
                                        }
                                    });
                                } catch (Exception e3) {
                                    q.d(TAG, e3.getMessage());
                                }
                                if (mBMediaView.t != null) {
                                    mBMediaView.t.openSound();
                                }
                                mBMediaView.t.setMediaViewPlayListener(new MediaViewPlayerView.a(mBMediaView.t) {
                                    public final void a() {
                                        int nvT2 = MBMediaView.this.K.getNvT2();
                                        if (!MBMediaView.this.h || !(nvT2 == 3 || nvT2 == 4)) {
                                            super.a();
                                            return;
                                        }
                                        WindVaneWebViewForNV r = MBMediaView.this.F();
                                        if (r != null) {
                                            View s = MBMediaView.this.v();
                                            if (s == null) {
                                                super.a();
                                                return;
                                            }
                                            if (nvT2 == 3 && MBMediaView.this.ac) {
                                                com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(s, MBMediaView.this.C);
                                                Context context = MBMediaView.this.getContext();
                                                CampaignEx q = MBMediaView.this.K;
                                                String campaignUnitId = MBMediaView.this.K.getCampaignUnitId();
                                                if (q != null) {
                                                    try {
                                                        if (!(q.getNativeVideoTracking() == null || q.getNativeVideoTracking().j() == null)) {
                                                            for (String str : q.getNativeVideoTracking().j()) {
                                                                if (!TextUtils.isEmpty(str)) {
                                                                    com.mbridge.msdk.click.a.a(context, q, campaignUnitId, str, false, true);
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            } else if (nvT2 == 4) {
                                                com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(s, MBMediaView.this.C);
                                                String clickURL = MBMediaView.this.K.getClickURL();
                                                if (!TextUtils.isEmpty(clickURL)) {
                                                    com.mbridge.msdk.click.a.a(MBMediaView.this.getContext(), MBMediaView.this.K, MBMediaView.this.o(), MBMediaView.this.getAddNVT2ToNoticeURL(), true, false);
                                                    MBMediaView.this.y.loadUrl(clickURL);
                                                }
                                            } else {
                                                super.a();
                                                return;
                                            }
                                            r.webViewShow(MBMediaView.this.K, MBMediaView.this.o());
                                            r.orientation(MBMediaView.this.i);
                                            return;
                                        }
                                        super.a();
                                    }
                                });
                                mBMediaView.b(false);
                                if (mBMediaView.K != null && mBMediaView.K.getMediaViewHolder() != null && !mBMediaView.K.getMediaViewHolder().k && !TextUtils.isEmpty(mBMediaView.K.getCampaignUnitId()) && mBMediaView.K.getNativeVideoTracking() != null && mBMediaView.K.getNativeVideoTracking().a() != null) {
                                    mBMediaView.K.getMediaViewHolder().k = true;
                                    mBMediaView.E();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            q.b(TAG, "rootView is null");
        } catch (Exception e4) {
            q.d(TAG, e4.getMessage());
        }
    }

    static /* synthetic */ void i(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.t != null) {
                mBMediaView.t.onClickPlayerView();
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    static /* synthetic */ void m(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.A != null) {
                mBMediaView.A.setVisibility(0);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void n(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.G != null) {
                mBMediaView.G.setVisibility(0);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void a(MBMediaView mBMediaView, Campaign campaign, String str) {
        try {
            if (mBMediaView.W != null) {
                mBMediaView.W.onStartRedirection(campaign, str);
            }
            if (mBMediaView.aa != null) {
                mBMediaView.aa.onStartRedirection(campaign, str);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void o(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.A != null) {
                mBMediaView.A.setVisibility(8);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void p(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.G != null) {
                mBMediaView.G.setVisibility(8);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void b(MBMediaView mBMediaView, Campaign campaign, String str) {
        try {
            if (mBMediaView.W != null) {
                mBMediaView.W.onRedirectionFailed(campaign, str);
            }
            if (mBMediaView.aa != null) {
                mBMediaView.aa.onRedirectionFailed(campaign, str);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void c(MBMediaView mBMediaView, Campaign campaign, String str) {
        try {
            if (mBMediaView.W != null) {
                mBMediaView.W.onFinishRedirection(campaign, str);
            }
            if (mBMediaView.aa != null) {
                mBMediaView.aa.onFinishRedirection(campaign, str);
            }
        } catch (Exception e2) {
            q.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void L(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.K;
        if (campaignEx != null && (mediaViewHolder = campaignEx.getMediaViewHolder()) != null && !mediaViewHolder.b && mBMediaView.K.getNativeVideoTracking() != null && mBMediaView.K.getNativeVideoTracking().c() != null) {
            mediaViewHolder.b = true;
            Context context = mBMediaView.getContext();
            CampaignEx campaignEx2 = mBMediaView.K;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.K.getNativeVideoTracking().c(), false, false);
        }
    }

    static /* synthetic */ void M(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.K;
        if (campaignEx != null && (mediaViewHolder = campaignEx.getMediaViewHolder()) != null && !mediaViewHolder.c && mBMediaView.K.getNativeVideoTracking() != null && mBMediaView.K.getNativeVideoTracking().d() != null) {
            mediaViewHolder.c = true;
            Context context = mBMediaView.getContext();
            CampaignEx campaignEx2 = mBMediaView.K;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.K.getNativeVideoTracking().d(), false, false);
        }
    }

    static /* synthetic */ void N(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.K;
        if (campaignEx != null && (mediaViewHolder = campaignEx.getMediaViewHolder()) != null && !mediaViewHolder.e && mBMediaView.K.getNativeVideoTracking() != null && mBMediaView.K.getNativeVideoTracking().f() != null) {
            mediaViewHolder.e = true;
            Context context = mBMediaView.getContext();
            CampaignEx campaignEx2 = mBMediaView.K;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.K.getNativeVideoTracking().f(), false, false);
        }
    }

    static /* synthetic */ void O(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.K;
        if (campaignEx != null && (mediaViewHolder = campaignEx.getMediaViewHolder()) != null && !mediaViewHolder.f && mBMediaView.K.getNativeVideoTracking() != null && mBMediaView.K.getNativeVideoTracking().g() != null) {
            mediaViewHolder.f = true;
            Context context = mBMediaView.getContext();
            CampaignEx campaignEx2 = mBMediaView.K;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.K.getNativeVideoTracking().g(), false, false);
        }
    }

    static /* synthetic */ void Q(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.t != null && mBMediaView.t.hasPrepare() && mBMediaView.t.isPlaying()) {
                if (mBMediaView.t != null) {
                    mBMediaView.t.pause();
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    static /* synthetic */ void R(MBMediaView mBMediaView) {
        try {
            if (mBMediaView.t != null) {
                if (mBMediaView.t.hasPrepare()) {
                    if (!mBMediaView.t.isPlaying()) {
                        if (!mBMediaView.t.isComplete()) {
                            if (mBMediaView.t.hasPrepare()) {
                                mBMediaView.t.startOrPlayVideo();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }
}
