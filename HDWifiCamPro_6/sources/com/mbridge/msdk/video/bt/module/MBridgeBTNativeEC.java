package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.c;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import com.mbridge.msdk.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeBTNativeEC extends BTBaseView {
    private StarLevelView A;
    /* access modifiers changed from: private */
    public boolean B = false;
    /* access modifiers changed from: private */
    public boolean C = false;
    private int D = 0;
    private Runnable E;
    /* access modifiers changed from: private */
    public View F;
    private View G;
    /* access modifiers changed from: private */
    public String H;
    private j I;
    /* access modifiers changed from: private */
    public WebView J;
    private ViewGroup p;
    private ViewGroup q;
    private RelativeLayout r;
    private ImageView s;
    private RoundImageView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public void onDestory() {
    }

    public MBridgeBTNativeEC(Context context) {
        super(context);
    }

    public MBridgeBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setUnitId(String str) {
        this.H = str;
    }

    public void setJSCommon(j jVar) {
        this.I = jVar;
    }

    public void setCreateWebView(WebView webView) {
        this.J = webView;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.E == null) {
            this.E = new Runnable() {
                public final void run() {
                    boolean unused = MBridgeBTNativeEC.this.C = true;
                    if (MBridgeBTNativeEC.this.F != null) {
                        MBridgeBTNativeEC.this.F.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.E;
        if (runnable != null) {
            postDelayed(runnable, (long) (this.D * 1000));
        }
        if (!this.h && this.J != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.H);
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                q.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e) {
                q.a(BTBaseView.TAG, e.getMessage());
            }
            g.a().a(this.J, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.J != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.H);
                jSONObject3.put(DataSchemeDataSource.SCHEME_DATA, jSONObject4);
                q.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e2) {
                q.a(BTBaseView.TAG, e2.getMessage());
            }
            g.a().a(this.J, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.E;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r7.s.setVisibility(8);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0167 A[Catch:{ all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0181 A[Catch:{ all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x018a A[Catch:{ all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData() {
        /*
            r7 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x019a
            boolean r0 = r7.h     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x019a
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0190 }
            int r0 = r0.getCbd()     // Catch:{ all -> 0x0190 }
            r1 = -2
            if (r0 <= r1) goto L_0x001a
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0190 }
            int r0 = r0.getCbd()     // Catch:{ all -> 0x0190 }
            r7.D = r0     // Catch:{ all -> 0x0190 }
            goto L_0x0026
        L_0x001a:
            com.mbridge.msdk.videocommon.d.c r0 = r7.e     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x0026
            com.mbridge.msdk.videocommon.d.c r0 = r7.e     // Catch:{ all -> 0x0190 }
            int r0 = r0.n()     // Catch:{ all -> 0x0190 }
            r7.D = r0     // Catch:{ all -> 0x0190 }
        L_0x0026:
            com.mbridge.msdk.video.module.a.a.e r0 = new com.mbridge.msdk.video.module.a.a.e     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.videocommon.view.RoundImageView r1 = r7.t     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r7.H     // Catch:{ all -> 0x0190 }
            r0.<init>(r1, r2, r3)     // Catch:{ all -> 0x0190 }
            android.content.Context r1 = r7.a     // Catch:{ all -> 0x0190 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.same.c.b r1 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r1)     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x0190 }
            java.lang.String r2 = r2.getImageUrl()     // Catch:{ all -> 0x0190 }
            r1.a((java.lang.String) r2, (com.mbridge.msdk.foundation.same.c.c) r0)     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.video.module.a.a.j r0 = new com.mbridge.msdk.video.module.a.a.j     // Catch:{ all -> 0x0190 }
            android.widget.ImageView r1 = r7.u     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0190 }
            android.content.Context r2 = r2.g()     // Catch:{ all -> 0x0190 }
            r3 = 1090519040(0x41000000, float:8.0)
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r2, (float) r3)     // Catch:{ all -> 0x0190 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0190 }
            android.content.Context r1 = r7.a     // Catch:{ all -> 0x0190 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.same.c.b r1 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r1)     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x0190 }
            java.lang.String r2 = r2.getIconUrl()     // Catch:{ all -> 0x0190 }
            r1.a((java.lang.String) r2, (com.mbridge.msdk.foundation.same.c.c) r0)     // Catch:{ all -> 0x0190 }
            android.widget.TextView r0 = r7.x     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x0190 }
            java.lang.String r1 = r1.getAppName()     // Catch:{ all -> 0x0190 }
            r0.setText(r1)     // Catch:{ all -> 0x0190 }
            android.widget.TextView r0 = r7.y     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x0190 }
            java.lang.String r1 = r1.getAppDesc()     // Catch:{ all -> 0x0190 }
            r0.setText(r1)     // Catch:{ all -> 0x0190 }
            android.widget.TextView r0 = r7.z     // Catch:{ all -> 0x0190 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0190 }
            r1.<init>()     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x0190 }
            int r2 = r2.getNumberRating()     // Catch:{ all -> 0x0190 }
            r1.append(r2)     // Catch:{ all -> 0x0190 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0190 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0190 }
            r0.setText(r1)     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.videocommon.view.StarLevelView r0 = r7.A     // Catch:{ all -> 0x0190 }
            r0.removeAllViews()     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0190 }
            double r0 = r0.getRating()     // Catch:{ all -> 0x0190 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x00b1
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x00b1:
            com.mbridge.msdk.videocommon.view.StarLevelView r2 = r7.A     // Catch:{ all -> 0x0190 }
            r2.initScore(r0)     // Catch:{ all -> 0x0190 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0190 }
            r1 = 17
            r2 = 8
            if (r0 >= r1) goto L_0x00c4
            android.widget.ImageView r0 = r7.s     // Catch:{ all -> 0x0190 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0190 }
            return
        L_0x00c4:
            com.mbridge.msdk.videocommon.view.RoundImageView r0 = r7.t     // Catch:{ all -> 0x00dc }
            android.graphics.drawable.Drawable r0 = r0.getDrawable()     // Catch:{ all -> 0x00dc }
            android.graphics.Bitmap r0 = r7.a((android.graphics.drawable.Drawable) r0)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x00e1
            android.graphics.Bitmap r0 = r7.blurBitmap(r0)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x00e1
            android.widget.ImageView r1 = r7.s     // Catch:{ all -> 0x00dc }
            r1.setImageBitmap(r0)     // Catch:{ all -> 0x00dc }
            goto L_0x00e1
        L_0x00dc:
            android.widget.ImageView r0 = r7.s     // Catch:{ all -> 0x0190 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0190 }
        L_0x00e1:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0190 }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0190 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0190 }
            if (r0 != 0) goto L_0x00fe
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0190 }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0190 }
            java.lang.String r1 = "alecfc=1"
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x00fe
            r0 = 1
            r7.B = r0     // Catch:{ all -> 0x0190 }
        L_0x00fe:
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0190 }
            java.lang.String r0 = r0.getLanguage()     // Catch:{ all -> 0x0190 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = "drawable"
            if (r1 != 0) goto L_0x0136
            java.lang.String r1 = "zh"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x0136
            android.widget.ImageView r0 = r7.v     // Catch:{ all -> 0x0190 }
            android.content.res.Resources r1 = r7.getResources()     // Catch:{ all -> 0x0190 }
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x0190 }
            java.lang.String r5 = "mbridge_reward_flag_cn"
            com.mbridge.msdk.foundation.controller.a r6 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0190 }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x0190 }
            int r3 = r4.getIdentifier(r5, r3, r6)     // Catch:{ all -> 0x0190 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)     // Catch:{ all -> 0x0190 }
            r0.setImageDrawable(r1)     // Catch:{ all -> 0x0190 }
            goto L_0x0155
        L_0x0136:
            android.widget.ImageView r0 = r7.v     // Catch:{ all -> 0x0190 }
            android.content.res.Resources r1 = r7.getResources()     // Catch:{ all -> 0x0190 }
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x0190 }
            java.lang.String r5 = "mbridge_reward_flag_en"
            com.mbridge.msdk.foundation.controller.a r6 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0190 }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x0190 }
            int r3 = r4.getIdentifier(r5, r3, r6)     // Catch:{ all -> 0x0190 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)     // Catch:{ all -> 0x0190 }
            r0.setImageDrawable(r1)     // Catch:{ all -> 0x0190 }
        L_0x0155:
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0190 }
            java.lang.String r0 = r0.h()     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.b.a r0 = r1.b(r0)     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x0181
            java.lang.String r0 = r0.Q()     // Catch:{ all -> 0x0190 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0190 }
            if (r1 == 0) goto L_0x0176
            android.widget.ImageView r1 = r7.w     // Catch:{ all -> 0x0190 }
            r1.setVisibility(r2)     // Catch:{ all -> 0x0190 }
        L_0x0176:
            android.widget.ImageView r1 = r7.w     // Catch:{ all -> 0x0190 }
            com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC$2 r3 = new com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC$2     // Catch:{ all -> 0x0190 }
            r3.<init>(r0)     // Catch:{ all -> 0x0190 }
            r1.setOnClickListener(r3)     // Catch:{ all -> 0x0190 }
            goto L_0x0186
        L_0x0181:
            android.widget.ImageView r0 = r7.w     // Catch:{ all -> 0x0190 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0190 }
        L_0x0186:
            boolean r0 = r7.C     // Catch:{ all -> 0x0190 }
            if (r0 != 0) goto L_0x019a
            android.view.View r0 = r7.F     // Catch:{ all -> 0x0190 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0190 }
            goto L_0x019a
        L_0x0190:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "BTBaseView"
            com.mbridge.msdk.foundation.tools.q.a(r1, r0)
        L_0x019a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.preLoadData():void");
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.g = configuration.orientation;
        if (this.g == 2) {
            removeView(this.p);
            a((View) this.q);
            return;
        }
        removeView(this.q);
        a((View) this.p);
    }

    private void a(View view) {
        if (view == null) {
            init(this.a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        if (this.h) {
            this.r.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.B) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 1);
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                    }
                }
            });
            this.F.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.J != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", MBridgeBTNativeEC.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTNativeEC.this.H);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            q.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            q.a(BTBaseView.TAG, e.getMessage());
                        }
                        g.a().a(MBridgeBTNativeEC.this.J, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            });
            this.G.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0);
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.u.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0);
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.t.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0);
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
        }
    }

    private boolean b(View view) {
        try {
            this.r = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_layout"));
            this.s = (ImageView) view.findViewById(findID("mbridge_iv_adbanner_bg"));
            this.t = (RoundImageView) view.findViewById(findID("mbridge_iv_adbanner"));
            this.u = (ImageView) view.findViewById(findID("mbridge_iv_icon"));
            this.v = (ImageView) view.findViewById(findID("mbridge_iv_flag"));
            this.w = (ImageView) view.findViewById(findID("mbridge_iv_link"));
            this.x = (TextView) view.findViewById(findID("mbridge_tv_apptitle"));
            this.y = (TextView) view.findViewById(findID("mbridge_tv_appdesc"));
            this.z = (TextView) view.findViewById(findID("mbridge_tv_number"));
            this.A = (StarLevelView) view.findViewById(findID("mbridge_sv_starlevel"));
            this.F = view.findViewById(findID("mbridge_iv_close"));
            this.G = view.findViewById(findID("mbridge_tv_cta"));
            return isNotNULL(this.s, this.t, this.u, this.x, this.y, this.z, this.A, this.F, this.G);
        } catch (Throwable th) {
            q.a(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript create = RenderScript.create(this.a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(10.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            bitmap.recycle();
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            q.a(BTBaseView.TAG, th.getMessage());
            return null;
        }
    }

    public void init(Context context) {
        boolean z2;
        int findLayout = findLayout(isLandscape() ? "mbridge_reward_endcard_native_land" : "mbridge_reward_endcard_native_hor");
        if (findLayout > 0) {
            if (isLandscape()) {
                this.q = (ViewGroup) this.f.inflate(findLayout, (ViewGroup) null);
                addView(this.q);
                z2 = b((View) this.q);
            } else {
                this.p = (ViewGroup) this.f.inflate(findLayout, (ViewGroup) null);
                addView(this.p);
                z2 = b((View) this.p);
            }
            this.h = z2;
            a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC r2, int r3) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0014 }
            r1.<init>()     // Catch:{ JSONException -> 0x0014 }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.g     // Catch:{ JSONException -> 0x0010 }
            org.json.JSONObject r3 = r2.a(r3)     // Catch:{ JSONException -> 0x0010 }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x0010 }
            goto L_0x0019
        L_0x0010:
            r3 = move-exception
            goto L_0x0016
        L_0x0012:
            r2 = move-exception
            goto L_0x002d
        L_0x0014:
            r3 = move-exception
            r1 = r0
        L_0x0016:
            r3.printStackTrace()     // Catch:{ all -> 0x0012 }
        L_0x0019:
            com.mbridge.msdk.video.signal.a.j r3 = r2.I     // Catch:{ all -> 0x0012 }
            if (r3 == 0) goto L_0x0036
            com.mbridge.msdk.video.signal.a.j r2 = r2.I     // Catch:{ all -> 0x0012 }
            r3 = 1
            if (r1 == 0) goto L_0x0027
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0012 }
            goto L_0x0029
        L_0x0027:
            java.lang.String r0 = ""
        L_0x0029:
            r2.click(r3, r0)     // Catch:{ all -> 0x0012 }
            goto L_0x0036
        L_0x002d:
            java.lang.String r2 = r2.getMessage()
            java.lang.String r3 = "BTBaseView"
            com.mbridge.msdk.foundation.tools.q.a(r3, r2)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC, int):void");
    }

    static /* synthetic */ void a(MBridgeBTNativeEC mBridgeBTNativeEC, float f, float f2) {
        if (mBridgeBTNativeEC.J != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", n);
                jSONObject.put("id", mBridgeBTNativeEC.d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f));
                jSONObject2.put("y", String.valueOf(f2));
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                g.a().a(mBridgeBTNativeEC.J, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                c.a().a(mBridgeBTNativeEC.J, "onClicked", mBridgeBTNativeEC.d);
            }
        }
    }
}
