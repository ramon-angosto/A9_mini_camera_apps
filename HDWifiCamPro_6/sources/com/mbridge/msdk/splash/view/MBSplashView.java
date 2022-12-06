package com.mbridge.msdk.splash.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.splash.signal.b;
import com.mbridge.msdk.splash.signal.c;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MBSplashView extends RelativeLayout {
    /* access modifiers changed from: private */
    public static String a = "MBSplashView";
    private int b;
    /* access modifiers changed from: private */
    public MBSplashWebview c;
    private ViewGroup d;
    private View e;
    private View f;
    private int g;
    private boolean h;
    private boolean i;
    private ViewGroup j;
    private RelativeLayout.LayoutParams k;
    private b l;

    public void setH5Ready(boolean z) {
        this.h = z;
    }

    public void setVideoReady(boolean z) {
        this.i = z;
    }

    public boolean isH5Ready() {
        return this.h;
    }

    public boolean isVideoReady() {
        return this.i;
    }

    public void resetLoadState() {
        this.i = false;
        this.h = false;
    }

    public b getSplashSignalCommunicationImpl() {
        return this.l;
    }

    public void setSplashSignalCommunicationImpl(b bVar) {
        this.l = bVar;
        MBSplashWebview mBSplashWebview = this.c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(this.l);
        }
    }

    public MBSplashView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MBSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    private void b() {
        setBackgroundColor(0);
        this.b = getResources().getConfiguration().orientation;
    }

    public MBSplashWebview getSplashWebview() {
        return this.c;
    }

    public void setSplashWebview(MBSplashWebview mBSplashWebview) {
        this.c = mBSplashWebview;
        b bVar = this.l;
        if (bVar != null) {
            mBSplashWebview.setObject(bVar);
        }
    }

    public void changeCloseBtnState(int i2) {
        View view = this.e;
        if (view == null) {
            return;
        }
        if (i2 == 2) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    public View getCloseView() {
        return this.e;
    }

    public void setCloseView(View view) {
        this.e = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public View getIconVg() {
        return this.f;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f = view;
        this.k = layoutParams;
    }

    public void show() {
        ViewGroup viewGroup;
        if (!(this.l == null || (viewGroup = this.j) == null || !(viewGroup.getContext() instanceof Activity))) {
            this.l.a(this.j.getContext());
        }
        if (this.f == null) {
            MBSplashWebview mBSplashWebview = this.c;
            if (mBSplashWebview != null && mBSplashWebview.getParent() == null) {
                addView(this.c, new ViewGroup.LayoutParams(-1, -1));
            }
            c();
        } else {
            if (this.d == null) {
                this.d = new RelativeLayout(getContext());
                this.d.setId(2147482647);
            }
            if (this.b == 2) {
                this.g = u.h(getContext());
                MBSplashWebview mBSplashWebview2 = this.c;
                if (mBSplashWebview2 != null && mBSplashWebview2.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(0, this.d.getId());
                    addView(this.c, layoutParams);
                }
                c();
                ViewGroup viewGroup2 = this.d;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i2 = this.k.width;
                    int i3 = this.g;
                    if (i2 > i3 / 4) {
                        i2 = i3 / 4;
                    }
                    this.d.addView(this.f, i2, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.d, layoutParams2);
                }
            } else {
                this.g = u.g(getContext());
                MBSplashWebview mBSplashWebview3 = this.c;
                if (mBSplashWebview3 != null && mBSplashWebview3.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams3.addRule(2, this.d.getId());
                    addView(this.c, layoutParams3);
                }
                c();
                ViewGroup viewGroup3 = this.d;
                if (viewGroup3 != null && viewGroup3.getParent() == null) {
                    int i4 = this.k.height;
                    int i5 = this.g;
                    if (i4 > i5 / 4) {
                        i4 = i5 / 4;
                    }
                    this.d.addView(this.f, -1, i4);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i4);
                    layoutParams4.addRule(12);
                    addView(this.d, layoutParams4);
                }
            }
        }
        View view = this.e;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(u.b(getContext(), 100.0f), u.b(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = u.b(getContext(), 10.0f);
                layoutParams5.topMargin = u.b(getContext(), 10.0f);
                addView(this.e, layoutParams5);
            } else {
                bringChildToFront(this.e);
            }
        }
        clearResState();
    }

    public void clearResState() {
        this.i = false;
        this.h = false;
    }

    public void updateCountdown(int i2) {
        if (this.c != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN, i2);
                g.a().a((WebView) this.c, "updateCountdown", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c() {
        int[] iArr = new int[2];
        this.c.getLocationInWindow(iArr);
        MBSplashWebview mBSplashWebview = this.c;
        transInfoForMraid(mBSplashWebview, iArr[0], iArr[1], mBSplashWebview.getWidth(), this.c.getHeight());
        MBSplashWebview mBSplashWebview2 = this.c;
        if (mBSplashWebview2 != null) {
            mBSplashWebview2.setObject(this.l);
            this.c.post(new Runnable() {
                public final void run() {
                    try {
                        q.a(MBSplashView.a, "webviewshow");
                        String str = "";
                        try {
                            int[] iArr = new int[2];
                            MBSplashView.this.c.getLocationOnScreen(iArr);
                            String a2 = MBSplashView.a;
                            q.d(a2, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", u.a(a.e().g(), (float) iArr[0]));
                            jSONObject.put("startY", u.a(a.e().g(), (float) iArr[1]));
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            q.a(MBSplashView.a, th.getMessage(), th);
                        }
                        g.a().a((WebView) MBSplashView.this.c, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void transInfoForMraid(WebView webView, int i2, int i3, int i4, int i5) {
        WebView webView2 = webView;
        try {
            int i6 = a.e().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i6 == 2 ? "landscape" : i6 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN);
            jSONObject.put("locked", "true");
            float h2 = (float) m.h(a.e().g());
            float i7 = (float) m.i(a.e().g());
            HashMap j2 = m.j(a.e().g());
            int intValue = ((Integer) j2.get("width")).intValue();
            int intValue2 = ((Integer) j2.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", IronSourceConstants.INTERSTITIAL_AD_UNIT);
            hashMap.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, "default");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f2 = (float) i2;
            float f3 = (float) i3;
            float f4 = (float) i4;
            float f5 = (float) i5;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f2, f3, f4, f5);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f2, f3, f4, f5);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView2, h2, i7);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(webView2, (float) intValue, (float) intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView2, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView2);
        } catch (Throwable th) {
            q.a(a, "transInfoForMraid", th);
        }
    }

    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        MBSplashWebview mBSplashWebview = this.c;
        if (mBSplashWebview != null && !mBSplashWebview.isDestoryed()) {
            this.c.release();
            c.a(this.c, "onSystemDestory", "");
        }
    }

    public ViewGroup getDevContainer() {
        return this.j;
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.j = viewGroup;
    }
}
