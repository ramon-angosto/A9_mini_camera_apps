package com.mbridge.msdk.mbbanner.common.bridge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdError;
import com.google.android.material.badge.BadgeDrawable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbbanner.common.b.a;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class BannerExpandDialog extends Dialog {
    private final String a = "BannerExpandDialog";
    private String b;
    private boolean c;
    /* access modifiers changed from: private */
    public FrameLayout d;
    /* access modifiers changed from: private */
    public WindVaneWebView e;
    /* access modifiers changed from: private */
    public TextView f;
    private String g;
    /* access modifiers changed from: private */
    public List<CampaignEx> h;
    /* access modifiers changed from: private */
    public a i;
    private b j = new b() {
        public final void expand(String str, boolean z) {
        }

        public final void open(String str) {
            try {
                q.d("BannerExpandDialog", str);
                if (BannerExpandDialog.this.h.size() > 1) {
                    com.mbridge.msdk.foundation.controller.a.e().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    str = null;
                }
                if (BannerExpandDialog.this.i != null) {
                    BannerExpandDialog.this.i.a(true, str);
                }
            } catch (Throwable th) {
                q.a("BannerExpandDialog", "open", th);
            }
        }

        public final void close() {
            BannerExpandDialog.this.dismiss();
        }

        public final void unload() {
            close();
        }

        public final void useCustomClose(boolean z) {
            try {
                BannerExpandDialog.this.f.setVisibility(z ? 4 : 0);
            } catch (Throwable th) {
                q.a("BannerExpandDialog", "useCustomClose", th);
            }
        }
    };

    public BannerExpandDialog(Context context, Bundle bundle, a aVar) {
        super(context);
        if (bundle != null) {
            this.b = bundle.getString("url");
            this.c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.i = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        this.d = new FrameLayout(getContext());
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.e = new WindVaneWebView(getContext().getApplicationContext());
        this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        this.f = new TextView(getContext());
        this.f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.c ? 4 : 0);
        this.f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BannerExpandDialog.this.dismiss();
            }
        });
        this.d.addView(this.f);
        setContentView(this.d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            if (Build.VERSION.SDK_INT >= 16) {
                int i2 = 519;
                if (Build.VERSION.SDK_INT >= 19) {
                    i2 = 4615;
                }
                getWindow().getDecorView().setSystemUiVisibility(i2);
            }
        }
        this.e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                StringBuilder sb = new StringBuilder("javascript:");
                sb.append(com.mbridge.msdk.b.b.a.a().b());
                if (Build.VERSION.SDK_INT <= 19) {
                    webView.loadUrl(sb.toString());
                } else {
                    webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() {
                        public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                            String str = (String) obj;
                        }
                    });
                }
                BannerExpandDialog.a(BannerExpandDialog.this);
            }
        });
        this.e.setObject(this.j);
        this.e.loadUrl(this.b);
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                if (BannerExpandDialog.this.i != null) {
                    BannerExpandDialog.this.i.a(false);
                }
                BannerExpandDialog.this.e.loadDataWithBaseURL((String) null, "", "text/html", "utf-8", (String) null);
                BannerExpandDialog.this.d.removeView(BannerExpandDialog.this.e);
                BannerExpandDialog.this.e.release();
                WindVaneWebView unused = BannerExpandDialog.this.e = null;
                a unused2 = BannerExpandDialog.this.i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.g = str;
        this.h = list;
    }

    static /* synthetic */ void a(BannerExpandDialog bannerExpandDialog) {
        BannerExpandDialog bannerExpandDialog2 = bannerExpandDialog;
        try {
            int i2 = com.mbridge.msdk.foundation.controller.a.e().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i2 == 2 ? "landscape" : i2 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN);
            jSONObject.put("locked", "true");
            HashMap j2 = m.j(com.mbridge.msdk.foundation.controller.a.e().g());
            int intValue = ((Integer) j2.get("width")).intValue();
            int intValue2 = ((Integer) j2.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", IronSourceConstants.INTERSTITIAL_AD_UNIT);
            hashMap.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, "expanded");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            int[] iArr = new int[2];
            bannerExpandDialog2.e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog2.e, (float) iArr[0], (float) iArr[1], (float) bannerExpandDialog2.e.getWidth(), (float) bannerExpandDialog2.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog2.e, (float) iArr[0], (float) iArr[1], (float) bannerExpandDialog2.e.getWidth(), (float) bannerExpandDialog2.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog2.e, (float) m.h(com.mbridge.msdk.foundation.controller.a.e().g()), (float) m.i(com.mbridge.msdk.foundation.controller.a.e().g()));
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(bannerExpandDialog2.e, (float) intValue, (float) intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) bannerExpandDialog2.e, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog2.e);
        } catch (Throwable th) {
            q.a("BannerExpandDialog", "notifyMraid", th);
        }
    }
}
