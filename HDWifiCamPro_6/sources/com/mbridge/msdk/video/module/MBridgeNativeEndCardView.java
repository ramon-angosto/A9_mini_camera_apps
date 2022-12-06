package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeNativeEndCardView extends MBridgeBaseView {
    /* access modifiers changed from: private */
    public RelativeLayout A;
    private b B;
    /* access modifiers changed from: private */
    public boolean C = false;
    /* access modifiers changed from: private */
    public boolean D = false;
    private int E = 0;
    /* access modifiers changed from: private */
    public AlphaAnimation F;
    /* access modifiers changed from: private */
    public int G;
    /* access modifiers changed from: private */
    public int H;
    /* access modifiers changed from: private */
    public int I;
    /* access modifiers changed from: private */
    public int J;
    /* access modifiers changed from: private */
    public View K;
    private View L;
    private int M = TTAdConstant.MATE_IS_NULL_CODE;
    private FeedBackButton N;
    private String O;
    private CampaignUnit P;
    private ViewGroup m;
    private ViewGroup n;
    private RelativeLayout o;
    /* access modifiers changed from: private */
    public ImageView p;
    private RelativeLayout q;
    /* access modifiers changed from: private */
    public ImageView r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private LinearLayout y;
    private Runnable z;

    public void setCloseBtnDelay(int i) {
        this.E = i;
    }

    public void setUnitId(String str) {
        this.O = str;
    }

    public MBridgeNativeEndCardView(Context context) {
        super(context);
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet, boolean z2, int i, boolean z3, int i2) {
        super(context, attributeSet, z2, i, z3, i2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.z == null) {
            this.z = new Runnable() {
                public final void run() {
                    boolean unused = MBridgeNativeEndCardView.this.D = true;
                    if (MBridgeNativeEndCardView.this.K != null) {
                        MBridgeNativeEndCardView.this.K.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.z;
        if (runnable != null) {
            postDelayed(runnable, (long) (this.E * 1000));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.z;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (r5.k != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        r3 = "mbridge_reward_endcard_native_land";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        if (r5.k != false) goto L_0x0063;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(android.content.Context r6) {
        /*
            r5 = this;
            boolean r6 = r5.i
            r0 = 1
            if (r6 == 0) goto L_0x0047
            com.mbridge.msdk.video.dynview.j.c r6 = new com.mbridge.msdk.video.dynview.j.c
            r6.<init>()
            android.content.Context r6 = r5.getContext()
            int r1 = r5.M
            int r1 = com.mbridge.msdk.foundation.tools.m.d(r6)
            if (r1 != r0) goto L_0x0019
            java.lang.String r0 = "mbridge_reward_end_card_layout_portrait"
            goto L_0x001b
        L_0x0019:
            java.lang.String r0 = "mbridge_reward_end_card_layout_landscape"
        L_0x001b:
            com.mbridge.msdk.video.dynview.b$a r1 = new com.mbridge.msdk.video.dynview.b$a
            r1.<init>()
            com.mbridge.msdk.video.dynview.b$b r0 = r1.a((java.lang.String) r0)
            r1 = 4
            com.mbridge.msdk.video.dynview.b$b r0 = r0.a((int) r1)
            com.mbridge.msdk.video.dynview.b$b r0 = r0.a((android.content.Context) r6)
            int r6 = com.mbridge.msdk.foundation.tools.m.d(r6)
            com.mbridge.msdk.video.dynview.b$b r6 = r0.b((int) r6)
            com.mbridge.msdk.video.dynview.b r6 = r6.a()
            com.mbridge.msdk.video.dynview.a r0 = com.mbridge.msdk.video.dynview.a.a()
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$3 r1 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$3
            r1.<init>()
            r0.a(r6, r1)
            goto L_0x00bc
        L_0x0047:
            int r6 = r5.l
            java.lang.String r1 = "mbridge_reward_endcard_native_half_landscape"
            java.lang.String r2 = "mbridge_reward_endcard_native_land"
            java.lang.String r3 = "mbridge_reward_endcard_native_half_portrait"
            java.lang.String r4 = "mbridge_reward_endcard_native_hor"
            if (r6 != 0) goto L_0x0067
            boolean r6 = r5.k
            if (r6 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r3 = r4
        L_0x0059:
            boolean r6 = r5.isLandscape()
            if (r6 == 0) goto L_0x007f
            boolean r6 = r5.k
            if (r6 == 0) goto L_0x0065
        L_0x0063:
            r3 = r1
            goto L_0x007f
        L_0x0065:
            r3 = r2
            goto L_0x007f
        L_0x0067:
            int r6 = r5.l
            if (r6 != r0) goto L_0x0072
            boolean r6 = r5.k
            if (r6 == 0) goto L_0x0070
            goto L_0x0075
        L_0x0070:
            r3 = r4
            goto L_0x0075
        L_0x0072:
            java.lang.String r6 = ""
            r3 = r6
        L_0x0075:
            int r6 = r5.l
            r0 = 2
            if (r6 != r0) goto L_0x007f
            boolean r6 = r5.k
            if (r6 == 0) goto L_0x0065
            goto L_0x0063
        L_0x007f:
            int r6 = r5.findLayout(r3)
            if (r6 <= 0) goto L_0x00bc
            boolean r0 = r5.isLandscape()
            r1 = 0
            if (r0 == 0) goto L_0x00a2
            android.view.LayoutInflater r0 = r5.c
            android.view.View r6 = r0.inflate(r6, r1)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r5.n = r6
            android.view.ViewGroup r6 = r5.n
            r5.addView(r6)
            android.view.ViewGroup r6 = r5.n
            boolean r6 = r5.b((android.view.View) r6)
            goto L_0x00b7
        L_0x00a2:
            android.view.LayoutInflater r0 = r5.c
            android.view.View r6 = r0.inflate(r6, r1)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r5.m = r6
            android.view.ViewGroup r6 = r5.m
            r5.addView(r6)
            android.view.ViewGroup r6 = r5.m
            boolean r6 = r5.b((android.view.View) r6)
        L_0x00b7:
            r5.f = r6
            r5.a()
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.init(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0156 A[Catch:{ all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0170 A[Catch:{ all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0179 A[Catch:{ all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0184 A[Catch:{ all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r6) {
        /*
            r5 = this;
            r5.B = r6
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.b     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x0194
            boolean r6 = r5.f     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x0194
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$4 r6 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$4     // Catch:{ all -> 0x018a }
            r6.<init>()     // Catch:{ all -> 0x018a }
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x018a }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.b     // Catch:{ all -> 0x018a }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ all -> 0x018a }
            r0.a((java.lang.String) r1, (com.mbridge.msdk.foundation.same.c.c) r6)     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.video.module.a.a.j r6 = new com.mbridge.msdk.video.module.a.a.j     // Catch:{ all -> 0x018a }
            android.widget.ImageView r0 = r5.s     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x018a }
            android.content.Context r1 = r1.g()     // Catch:{ all -> 0x018a }
            r2 = 1090519040(0x41000000, float:8.0)
            int r1 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)     // Catch:{ all -> 0x018a }
            r6.<init>(r0, r1)     // Catch:{ all -> 0x018a }
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x018a }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.b     // Catch:{ all -> 0x018a }
            java.lang.String r1 = r1.getIconUrl()     // Catch:{ all -> 0x018a }
            r0.a((java.lang.String) r1, (com.mbridge.msdk.foundation.same.c.c) r6)     // Catch:{ all -> 0x018a }
            android.widget.TextView r6 = r5.v     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r5.b     // Catch:{ all -> 0x018a }
            java.lang.String r0 = r0.getAppName()     // Catch:{ all -> 0x018a }
            r6.setText(r0)     // Catch:{ all -> 0x018a }
            android.view.View r6 = r5.L     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x006c
            android.view.View r6 = r5.L     // Catch:{ all -> 0x018a }
            boolean r6 = r6 instanceof android.widget.TextView     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x006c
            android.view.View r6 = r5.L     // Catch:{ all -> 0x018a }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r5.b     // Catch:{ all -> 0x018a }
            java.lang.String r0 = r0.getAdCall()     // Catch:{ all -> 0x018a }
            r6.setText(r0)     // Catch:{ all -> 0x018a }
        L_0x006c:
            android.widget.TextView r6 = r5.w     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x007b
            android.widget.TextView r6 = r5.w     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r5.b     // Catch:{ all -> 0x018a }
            java.lang.String r0 = r0.getAppDesc()     // Catch:{ all -> 0x018a }
            r6.setText(r0)     // Catch:{ all -> 0x018a }
        L_0x007b:
            android.widget.TextView r6 = r5.x     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x009b
            android.widget.TextView r6 = r5.x     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r0.<init>()     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.b     // Catch:{ all -> 0x018a }
            int r1 = r1.getNumberRating()     // Catch:{ all -> 0x018a }
            r0.append(r1)     // Catch:{ all -> 0x018a }
            java.lang.String r1 = ")"
            r0.append(r1)     // Catch:{ all -> 0x018a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x018a }
            r6.setText(r0)     // Catch:{ all -> 0x018a }
        L_0x009b:
            android.widget.LinearLayout r6 = r5.y     // Catch:{ all -> 0x018a }
            r6.removeAllViews()     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.b     // Catch:{ all -> 0x018a }
            double r0 = r6.getRating()     // Catch:{ all -> 0x018a }
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x00ae
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x00ae:
            android.widget.LinearLayout r6 = r5.y     // Catch:{ all -> 0x018a }
            boolean r6 = r6 instanceof com.mbridge.msdk.videocommon.view.StarLevelView     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x00bb
            android.widget.LinearLayout r6 = r5.y     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.videocommon.view.StarLevelView r6 = (com.mbridge.msdk.videocommon.view.StarLevelView) r6     // Catch:{ all -> 0x018a }
            r6.initScore(r0)     // Catch:{ all -> 0x018a }
        L_0x00bb:
            android.widget.LinearLayout r6 = r5.y     // Catch:{ all -> 0x018a }
            boolean r6 = r6 instanceof com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x00ce
            android.widget.LinearLayout r6 = r5.y     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView r6 = (com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView) r6     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r5.b     // Catch:{ all -> 0x018a }
            int r2 = r2.getNumberRating()     // Catch:{ all -> 0x018a }
            r6.setRatingAndUser(r0, r2)     // Catch:{ all -> 0x018a }
        L_0x00ce:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.b     // Catch:{ all -> 0x018a }
            java.lang.String r6 = r6.getendcard_url()     // Catch:{ all -> 0x018a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x018a }
            if (r6 != 0) goto L_0x00eb
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.b     // Catch:{ all -> 0x018a }
            java.lang.String r6 = r6.getendcard_url()     // Catch:{ all -> 0x018a }
            java.lang.String r0 = "alecfc=1"
            boolean r6 = r6.contains(r0)     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x00eb
            r6 = 1
            r5.C = r6     // Catch:{ all -> 0x018a }
        L_0x00eb:
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ all -> 0x018a }
            java.lang.String r6 = r6.getLanguage()     // Catch:{ all -> 0x018a }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x018a }
            java.lang.String r1 = "drawable"
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = "zh"
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x0123
            android.widget.ImageView r6 = r5.t     // Catch:{ all -> 0x018a }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ all -> 0x018a }
            android.content.res.Resources r2 = r5.getResources()     // Catch:{ all -> 0x018a }
            java.lang.String r3 = "mbridge_reward_flag_cn"
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x018a }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x018a }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x018a }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x018a }
            r6.setImageDrawable(r0)     // Catch:{ all -> 0x018a }
            goto L_0x0142
        L_0x0123:
            android.widget.ImageView r6 = r5.t     // Catch:{ all -> 0x018a }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ all -> 0x018a }
            android.content.res.Resources r2 = r5.getResources()     // Catch:{ all -> 0x018a }
            java.lang.String r3 = "mbridge_reward_flag_en"
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x018a }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x018a }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x018a }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x018a }
            r6.setImageDrawable(r0)     // Catch:{ all -> 0x018a }
        L_0x0142:
            com.mbridge.msdk.foundation.controller.a r6 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x018a }
            java.lang.String r6 = r6.h()     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.b.a r6 = r0.b(r6)     // Catch:{ all -> 0x018a }
            r0 = 8
            if (r6 == 0) goto L_0x0170
            java.lang.String r6 = r6.Q()     // Catch:{ all -> 0x018a }
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x018a }
            if (r1 == 0) goto L_0x0165
            android.widget.ImageView r1 = r5.u     // Catch:{ all -> 0x018a }
            r1.setVisibility(r0)     // Catch:{ all -> 0x018a }
        L_0x0165:
            android.widget.ImageView r1 = r5.u     // Catch:{ all -> 0x018a }
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$5 r2 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$5     // Catch:{ all -> 0x018a }
            r2.<init>(r6)     // Catch:{ all -> 0x018a }
            r1.setOnClickListener(r2)     // Catch:{ all -> 0x018a }
            goto L_0x0175
        L_0x0170:
            android.widget.ImageView r6 = r5.u     // Catch:{ all -> 0x018a }
            r6.setVisibility(r0)     // Catch:{ all -> 0x018a }
        L_0x0175:
            boolean r6 = r5.D     // Catch:{ all -> 0x018a }
            if (r6 != 0) goto L_0x017e
            android.view.View r6 = r5.K     // Catch:{ all -> 0x018a }
            r6.setVisibility(r0)     // Catch:{ all -> 0x018a }
        L_0x017e:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x018a }
            r1 = 17
            if (r6 >= r1) goto L_0x0194
            android.widget.ImageView r6 = r5.p     // Catch:{ all -> 0x018a }
            r6.setVisibility(r0)     // Catch:{ all -> 0x018a }
            goto L_0x0194
        L_0x018a:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            java.lang.String r0 = "MBridgeBaseView"
            com.mbridge.msdk.foundation.tools.q.a(r0, r6)
        L_0x0194:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    /* access modifiers changed from: private */
    public void a() {
        c();
        if (!this.f) {
            this.e.a(104, "");
        }
        this.F = new AlphaAnimation(0.0f, 100.0f);
        this.F.setDuration(200);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        if (this.b == null || !this.b.isDynamicView()) {
            this.A.setVisibility(4);
            this.d = configuration.orientation;
            if (this.d == 2) {
                removeView(this.m);
                a((View) this.n);
                return;
            }
            removeView(this.n);
            a((View) this.m);
        }
    }

    public boolean canBackPress() {
        View view = this.K;
        return view != null && view.getVisibility() == 0;
    }

    public void notifyShowListener() {
        this.e.a(110, "");
    }

    private void a(View view) {
        if (view == null) {
            init(this.a);
            preLoadData(this.B);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        b();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.f) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.C) {
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 1);
                    }
                }
            });
            this.K.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeNativeEndCardView.this.e.a(104, "");
                }
            });
            this.L.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                }
            });
            this.s.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                }
            });
            this.r.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean b(View view) {
        try {
            this.o = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_layout"));
            this.r = (ImageView) view.findViewById(findID("mbridge_iv_adbanner"));
            this.s = (ImageView) view.findViewById(findID("mbridge_iv_icon"));
            this.t = (ImageView) view.findViewById(findID("mbridge_iv_flag"));
            this.u = (ImageView) view.findViewById(findID("mbridge_iv_link"));
            this.v = (TextView) view.findViewById(findID("mbridge_tv_apptitle"));
            this.y = (LinearLayout) view.findViewById(findID("mbridge_sv_starlevel"));
            this.K = view.findViewById(findID("mbridge_iv_close"));
            this.L = view.findViewById(findID("mbridge_tv_cta"));
            this.N = (FeedBackButton) view.findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.A = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_controller"));
            if (this.i) {
                this.q = (RelativeLayout) view.findViewById(findID("mbridge_iv_adbanner_bg"));
                if (this.r != null && (this.r instanceof RoundImageView)) {
                    ((RoundImageView) this.r).setBorderRadius(10);
                }
                if (this.s != null && (this.s instanceof RoundImageView)) {
                    ((RoundImageView) this.s).setBorderRadius(10);
                }
                return isNotNULL(this.q, this.r, this.s, this.v, this.y, this.K, this.L);
            }
            this.p = (ImageView) view.findViewById(findID("mbridge_iv_adbanner_bg"));
            this.w = (TextView) view.findViewById(findID("mbridge_tv_appdesc"));
            this.x = (TextView) view.findViewById(findID("mbridge_tv_number"));
            return isNotNULL(this.p, this.r, this.s, this.v, this.w, this.x, this.y, this.K, this.L);
        } catch (Throwable th) {
            q.a(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript create = RenderScript.create(this.a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        q.d(MBridgeBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        this.G = i;
        this.H = i2;
        this.I = i3;
        this.J = i4;
        b();
    }

    private void b() {
        this.A.postDelayed(new Runnable() {
            public final void run() {
                if (!(MBridgeNativeEndCardView.this.b == null || MBridgeNativeEndCardView.this.b.isDynamicView() || MBridgeNativeEndCardView.this.b.getAdSpaceT() == 2)) {
                    MBridgeNativeEndCardView.this.A.setPadding(MBridgeNativeEndCardView.this.G, MBridgeNativeEndCardView.this.I, MBridgeNativeEndCardView.this.H, MBridgeNativeEndCardView.this.J);
                    MBridgeNativeEndCardView.this.A.startAnimation(MBridgeNativeEndCardView.this.F);
                }
                MBridgeNativeEndCardView.this.A.setVisibility(0);
                if (MBridgeNativeEndCardView.this.K.getVisibility() != 0 && MBridgeNativeEndCardView.this.D) {
                    MBridgeNativeEndCardView.this.K.setVisibility(0);
                }
                MBridgeNativeEndCardView.m(MBridgeNativeEndCardView.this);
            }
        }, 200);
    }

    public void setMoreOfferCampaignUnit(CampaignUnit campaignUnit) {
        if (this.b != null && this.b.isDynamicView()) {
            this.P = campaignUnit;
        }
    }

    public void clearMoreOfferBitmap() {
        CampaignUnit campaignUnit;
        if (this.b != null && this.b.isDynamicView() && (campaignUnit = this.P) != null && campaignUnit.getAds() != null && this.P.getAds().size() > 0) {
            Iterator<CampaignEx> it = this.P.getAds().iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (!TextUtils.isEmpty(next.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).c(next.getIconUrl());
                }
            }
        }
    }

    static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, int i) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.g, mBridgeNativeEndCardView.a(i));
            } catch (JSONException e) {
                e = e;
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
            e.printStackTrace();
            mBridgeNativeEndCardView.e.a(105, jSONObject);
        }
        mBridgeNativeEndCardView.e.a(105, jSONObject);
    }

    static /* synthetic */ void m(MBridgeNativeEndCardView mBridgeNativeEndCardView) {
        if (com.mbridge.msdk.foundation.b.b.a().b()) {
            com.mbridge.msdk.foundation.b.b a = com.mbridge.msdk.foundation.b.b.a();
            a.a(mBridgeNativeEndCardView.O + "_" + 2, mBridgeNativeEndCardView.b);
            com.mbridge.msdk.foundation.b.b a2 = com.mbridge.msdk.foundation.b.b.a();
            a2.b(mBridgeNativeEndCardView.O + "_" + 1);
            com.mbridge.msdk.foundation.b.b a3 = com.mbridge.msdk.foundation.b.b.a();
            a3.a(mBridgeNativeEndCardView.O + "_" + 2, mBridgeNativeEndCardView.N);
            return;
        }
        FeedBackButton feedBackButton = mBridgeNativeEndCardView.N;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }
}
