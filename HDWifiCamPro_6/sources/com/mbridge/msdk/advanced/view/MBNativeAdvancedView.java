package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.advanced.js.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBNativeAdvancedView extends RelativeLayout {
    /* access modifiers changed from: private */
    public static String a = "MBAdvancedNativeView";
    /* access modifiers changed from: private */
    public MBNativeAdvancedWebview b;
    private View c;
    private boolean d;
    private boolean e;
    private boolean f;
    private b g;
    private Context h;

    public void setH5Ready(boolean z) {
        this.d = z;
    }

    public void setVideoReady(boolean z) {
        this.e = z;
    }

    public boolean isEndCardReady() {
        return this.f;
    }

    public void setEndCardReady(boolean z) {
        this.f = z;
    }

    public boolean isH5Ready() {
        return this.d;
    }

    public boolean isVideoReady() {
        return this.e;
    }

    public void resetLoadState() {
        this.f = false;
        this.e = false;
        this.d = false;
    }

    public b getAdvancedNativeSignalCommunicationImpl() {
        return this.g;
    }

    public void setAdvancedNativeSignalCommunicationImpl(b bVar) {
        this.g = bVar;
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.b;
        if (mBNativeAdvancedWebview != null) {
            mBNativeAdvancedWebview.setObject(this.g);
        }
    }

    public MBNativeAdvancedView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = context;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public MBNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.b;
    }

    public void setAdvancedNativeWebview(MBNativeAdvancedWebview mBNativeAdvancedWebview) {
        this.b = mBNativeAdvancedWebview;
        b bVar = this.g;
        if (bVar != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void changeCloseBtnState(int i) {
        View view = this.c;
        if (view == null) {
            return;
        }
        if (i == 2) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    public View getCloseView() {
        return this.c;
    }

    public void setCloseView(View view) {
        this.c = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void clearResState() {
        this.f = false;
        this.e = false;
        this.d = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        View view = this.c;
        if (view != null && view.getParent() != null) {
            removeView(this.c);
        }
    }

    public static void transInfoForMraid(WebView webView, int i, int i2, int i3, int i4) {
        WebView webView2 = webView;
        q.d(a, "transInfoForMraid");
        try {
            int i5 = a.e().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i5 == 2 ? "landscape" : i5 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN);
            jSONObject.put("locked", "true");
            float h2 = (float) m.h(a.e().g());
            float i6 = (float) m.i(a.e().g());
            HashMap j = m.j(a.e().g());
            int intValue = ((Integer) j.get("width")).intValue();
            int intValue2 = ((Integer) j.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "inline");
            hashMap.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, "default");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f2 = (float) i;
            float f3 = (float) i2;
            float f4 = (float) i3;
            float f5 = (float) i4;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f2, f3, f4, f5);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f2, f3, f4, f5);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView2, h2, i6);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(webView2, (float) intValue, (float) intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView2, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView2);
        } catch (Throwable th) {
            q.a(a, "transInfoForMraid", th);
        }
    }

    public void destroy() {
        removeAllViews();
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.b;
        if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
            this.b.release();
            com.mbridge.msdk.advanced.js.a.a(this.b, "onSystemDestory", "");
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    public void show() {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.b;
        if (mBNativeAdvancedWebview != null && mBNativeAdvancedWebview.getParent() == null) {
            addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.b.getLocationInWindow(iArr);
        MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.b;
        transInfoForMraid(mBNativeAdvancedWebview2, iArr[0], iArr[1], mBNativeAdvancedWebview2.getWidth(), this.b.getHeight());
        MBNativeAdvancedWebview mBNativeAdvancedWebview3 = this.b;
        if (mBNativeAdvancedWebview3 != null) {
            mBNativeAdvancedWebview3.setObject(this.g);
            this.b.post(new Runnable() {
                public final void run() {
                    String str = "";
                    try {
                        int[] iArr = new int[2];
                        MBNativeAdvancedView.this.b.getLocationOnScreen(iArr);
                        String a2 = MBNativeAdvancedView.a;
                        q.d(a2, "coordinate:" + iArr[0] + "--" + iArr[1]);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("startX", u.a(a.e().g(), (float) iArr[0]));
                        jSONObject.put("startY", u.a(a.e().g(), (float) iArr[1]));
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        try {
                            q.a(MBNativeAdvancedView.a, th.getMessage(), th);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    g.a().a((WebView) MBNativeAdvancedView.this.b, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                }
            });
        }
        View view = this.c;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 28.0f), u.b(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = u.b(getContext(), 2.0f);
                layoutParams.topMargin = u.b(getContext(), 2.0f);
                addView(this.c, layoutParams);
            } else {
                bringChildToFront(this.c);
            }
        }
        clearResState();
    }
}
