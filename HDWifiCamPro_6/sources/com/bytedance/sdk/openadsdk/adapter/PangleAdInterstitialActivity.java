package com.bytedance.sdk.openadsdk.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.CustomEventInterstitialListener;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.ArrayList;

public class PangleAdInterstitialActivity extends Activity {
    public static final String INTENT_TYPE = "intent_type";
    public static final int INTENT_TYPE_IMAGE_2_3 = 2;
    public static final int INTENT_TYPE_IMAGE_3_2 = 1;
    /* access modifiers changed from: private */
    public static CustomEventInterstitialListener n;
    private static TTNativeAd o;
    private ImageView a;
    private RelativeLayout b;
    private NiceImageView c;
    private TextView d;
    private TextView e;
    private Button f;
    private TTRatingBar2 g;
    private Intent h;
    private ViewGroup i;
    private RelativeLayout j;
    private ViewGroup k;
    private float l;
    private float m;

    public void onBackPressed() {
    }

    public static void showAd(Context context, TTNativeAd tTNativeAd, int i2, CustomEventInterstitialListener customEventInterstitialListener) {
        o = tTNativeAd;
        n = customEventInterstitialListener;
        Intent intent = new Intent(context, PangleAdInterstitialActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(INTENT_TYPE, i2);
        b.a(context, intent, new b.a() {
            public void a() {
            }

            public void a(Throwable th) {
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialShowFail();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = getIntent();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.l = (float) z.c((Context) this);
        this.m = (float) z.d((Context) this);
        if (this.h.getIntExtra(INTENT_TYPE, 0) == 2) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        if (this.h != null) {
            b();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r7 = this;
            float r0 = r7.l
            int r0 = (int) r0
            com.bytedance.sdk.openadsdk.TTNativeAd r1 = o
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0086
            java.util.List r1 = r1.getImageList()
            if (r1 == 0) goto L_0x0086
            com.bytedance.sdk.openadsdk.TTNativeAd r1 = o
            java.util.List r1 = r1.getImageList()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0086
            com.bytedance.sdk.openadsdk.TTNativeAd r1 = o
            java.util.List r1 = r1.getImageList()
            java.lang.Object r1 = r1.get(r3)
            com.bytedance.sdk.openadsdk.TTImage r1 = (com.bytedance.sdk.openadsdk.TTImage) r1
            if (r1 == 0) goto L_0x0086
            boolean r4 = r1.isValid()
            if (r4 == 0) goto L_0x0086
            int r4 = r1.getHeight()
            float r4 = (float) r4
            int r1 = r1.getWidth()
            float r1 = (float) r1
            float r1 = r1 / r4
            r4 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 * r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "ratio...."
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "PangleAdInterstitial"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r6, (java.lang.String) r5)
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            r5 = 1155432448(0x44de8000, float:1780.0)
            if (r4 <= 0) goto L_0x006c
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x006c
            float r0 = (float) r0
            r1 = 1071896330(0x3fe3d70a, float:1.78)
            float r0 = r0 / r1
            int r0 = (int) r0
            int r0 = r0 + 30
            java.lang.String r1 = "RATIO_1_7_8...."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r6, (java.lang.String) r1)
            goto L_0x0086
        L_0x006c:
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x007e
            float r0 = (float) r0
            r1 = 1072986849(0x3ff47ae1, float:1.91)
            float r0 = r0 / r1
            int r0 = (int) r0
            int r0 = r0 + 30
            java.lang.String r1 = "RATIO_1_9_1...."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r6, (java.lang.String) r1)
            goto L_0x0086
        L_0x007e:
            java.lang.String r1 = "RATIO_1_1...."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r6, (java.lang.String) r1)
            r1 = r0
            r0 = r2
            goto L_0x0088
        L_0x0086:
            r1 = r0
            r0 = r3
        L_0x0088:
            android.content.Intent r4 = r7.h
            java.lang.String r5 = "intent_type"
            int r3 = r4.getIntExtra(r5, r3)
            if (r3 == r2) goto L_0x00ab
            r0 = 2
            if (r3 == r0) goto L_0x009a
            r7.finish()
            goto L_0x0128
        L_0x009a:
            java.lang.String r0 = "tt_pangle_ad_instersitial_layout_2_3"
            int r0 = com.bytedance.sdk.component.utils.t.f(r7, r0)
            r7.setContentView(r0)
            r7.d()
            r7.a((int) r1)
            goto L_0x0128
        L_0x00ab:
            if (r0 != 0) goto L_0x00d3
            java.lang.String r0 = "tt_pangle_ad_instersitial_layout_3_2"
            int r0 = com.bytedance.sdk.component.utils.t.f(r7, r0)
            r7.setContentView(r0)
            r7.d()
            r0 = 1117126656(0x42960000, float:75.0)
            float r0 = com.bytedance.sdk.openadsdk.l.z.b((android.content.Context) r7, (float) r0)
            float r2 = r7.m
            float r3 = (float) r1
            float r4 = r2 - r3
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x00cf
            float r4 = r7.l
            float r4 = r4 - r3
            float r0 = r0 - r4
            float r2 = r2 + r0
            r7.m = r2
        L_0x00cf:
            r7.a((int) r1)
            goto L_0x0128
        L_0x00d3:
            java.lang.String r0 = "tt_pangle_ad_instersitial_layout_3_2_1_1"
            int r0 = com.bytedance.sdk.component.utils.t.f(r7, r0)
            r7.setContentView(r0)
            r7.d()
            r0 = 1126825984(0x432a0000, float:170.0)
            float r0 = com.bytedance.sdk.openadsdk.l.z.b((android.content.Context) r7, (float) r0)
            float r2 = r7.m
            r3 = 1101004800(0x41a00000, float:20.0)
            float r3 = com.bytedance.sdk.openadsdk.l.z.b((android.content.Context) r7, (float) r3)
            float r2 = r2 - r3
            int r2 = (int) r2
            float r3 = r7.l
            float r4 = (float) r1
            float r5 = r3 - r4
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 >= 0) goto L_0x00fb
            float r3 = r3 - r0
            int r0 = (int) r3
            goto L_0x00fc
        L_0x00fb:
            r0 = r1
        L_0x00fc:
            float r3 = r7.m
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x010c
            int r1 = (int) r3
            float r1 = (float) r1
            r3 = 1111490560(0x42400000, float:48.0)
            float r3 = com.bytedance.sdk.openadsdk.l.z.b((android.content.Context) r7, (float) r3)
            float r1 = r1 - r3
            int r1 = (int) r1
        L_0x010c:
            android.widget.RelativeLayout r3 = r7.j
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            r3.height = r1
            r3.width = r0
            android.widget.RelativeLayout r0 = r7.j
            r0.setLayoutParams(r3)
            android.view.ViewGroup r0 = r7.i
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r0.height = r2
            android.view.ViewGroup r1 = r7.i
            r1.setLayoutParams(r0)
        L_0x0128:
            com.bytedance.sdk.openadsdk.TTNativeAd r0 = o
            r7.a((com.bytedance.sdk.openadsdk.TTNativeAd) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.b():void");
    }

    private void a(int i2) {
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = i2;
        this.j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
        layoutParams2.height = (int) (this.m - ((float) i2));
        this.i.setLayoutParams(layoutParams2);
    }

    private void a(TTNativeAd tTNativeAd) {
        TTImage tTImage;
        if (tTNativeAd != null) {
            if (o.getImageList() != null && !o.getImageList().isEmpty() && (tTImage = o.getImageList().get(0)) != null && tTImage.isValid()) {
                d.a().a(tTImage.getImageUrl(), this.a);
            }
            if (!(o.getIcon() == null || !o.getIcon().isValid() || o.getIcon().getImageUrl() == null)) {
                d.a().a(o.getIcon().getImageUrl(), (ImageView) this.c);
            }
            this.d.setText(o.getTitle());
            this.e.setText(o.getDescription());
            this.f.setText(o.getButtonText());
            c();
            b(tTNativeAd);
        }
    }

    private void b(TTNativeAd tTNativeAd) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f);
        tTNativeAd.registerViewForInteraction(this.k, arrayList, arrayList2, this.b, new TTNativeAd.AdInteractionListener() {
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                l.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdClicked....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialClicked();
                }
            }

            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                l.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdClicked....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialClicked();
                }
            }

            public void onAdShow(TTNativeAd tTNativeAd) {
                l.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdShow....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialShown();
                }
            }
        });
    }

    private void c() {
        this.b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PangleAdInterstitialActivity.this.finish();
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialDismissed();
                }
            }
        });
    }

    private void d() {
        this.g = (TTRatingBar2) findViewById(t.e(this, "tt_pangle_ad_score"));
        TTRatingBar2 tTRatingBar2 = this.g;
        if (tTRatingBar2 != null) {
            z.a((TextView) null, tTRatingBar2, (double) o.getAppScore(), (Context) this);
        }
        this.a = (ImageView) findViewById(t.e(this, "tt_pangle_ad_main_img"));
        this.b = (RelativeLayout) findViewById(t.e(this, "tt_pangle_ad_close_layout"));
        this.c = (NiceImageView) findViewById(t.e(this, "tt_pangle_ad_icon"));
        this.d = (TextView) findViewById(t.e(this, "tt_pangle_ad_title"));
        this.e = (TextView) findViewById(t.e(this, "tt_pangle_ad_content"));
        this.f = (Button) findViewById(t.e(this, "tt_pangle_ad_btn"));
        this.i = (ViewGroup) findViewById(t.e(this, "tt_pangle_ad_content_layout"));
        this.j = (RelativeLayout) findViewById(t.e(this, "tt_pangle_ad_image_layout"));
        this.k = (ViewGroup) findViewById(t.e(this, "tt_pangle_ad_root"));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        o = null;
        n = null;
    }
}
