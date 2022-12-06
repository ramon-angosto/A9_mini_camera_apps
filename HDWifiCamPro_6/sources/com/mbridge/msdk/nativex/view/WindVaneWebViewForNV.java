package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.nativex.listener.b;
import org.json.JSONObject;

public class WindVaneWebViewForNV extends WindVaneWebView {
    private static String e = "WindVaneWebViewForNV";
    private b f;
    private boolean g = false;

    public void setInterceptTouch(boolean z) {
        this.g = z;
    }

    public void setBackListener(b bVar) {
        this.f = bVar;
    }

    public WindVaneWebViewForNV(Context context) {
        super(context);
    }

    public WindVaneWebViewForNV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WindVaneWebViewForNV(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        b bVar;
        if (i != 4 || (bVar = this.f) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        bVar.a();
        return true;
    }

    public void webViewShow(CampaignEx campaignEx, String str) {
        try {
            g.a().a((WebView) this, "webviewshow", "");
            m mVar = new m();
            mVar.k(campaignEx.getRequestId());
            mVar.l(campaignEx.getRequestIdNotice());
            if (getContext() == null) {
                return;
            }
            if (getContext().getApplicationContext() != null) {
                mVar.n(campaignEx.getId());
                mVar.a(campaignEx.isMraid() ? m.a : m.b);
                com.mbridge.msdk.foundation.same.report.b.a(mVar, getContext().getApplicationContext(), str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void orientation(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            g.a().a((WebView) this, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
