package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BTBaseView extends FrameLayout {
    public static final String TAG = "BTBaseView";
    protected static int n = 0;
    protected static int o = 1;
    protected Context a;
    protected CampaignEx b;
    protected String c;
    protected String d;
    protected c e;
    protected LayoutInflater f;
    protected int g;
    protected boolean h;
    protected float i;
    protected float j;
    protected Rect k;
    protected int l;
    protected int m;

    /* access modifiers changed from: protected */
    public void a() {
    }

    public abstract void init(Context context);

    public abstract void onDestory();

    public String getUnitId() {
        return this.c;
    }

    public void setUnitId(String str) {
        this.c = str;
    }

    public String getInstanceId() {
        return this.d;
    }

    public void setInstanceId(String str) {
        this.d = str;
    }

    public BTBaseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BTBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "";
        this.g = 1;
        this.h = false;
        this.a = context;
        this.f = LayoutInflater.from(context);
        init(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.g = configuration.orientation;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.b = campaignEx;
    }

    public void setRewardUnitSetting(c cVar) {
        this.e = cVar;
    }

    public int findID(String str) {
        return k.a(this.a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return k.a(this.a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public int findColor(String str) {
        return k.a(this.a.getApplicationContext(), str, TtmlNode.ATTR_TTS_COLOR);
    }

    public int findDrawable(String str) {
        return k.a(this.a.getApplicationContext(), str, "drawable");
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            if (viewArr[i2] == null) {
                return false;
            }
            i2++;
            z = true;
        }
        return z;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            return;
        }
        layoutParams.height = -2;
        layoutParams.width = -2;
    }

    public void defaultShow() {
        q.a(TAG, "defaultShow");
    }

    public boolean isLandscape() {
        return this.a.getResources().getConfiguration().orientation == 2;
    }

    public void setLayoutCenter(int i2, int i3) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i2 != -999) {
                parentRelativeLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentRelativeLayoutParams.height = i3;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i2 != -999) {
                parentLinearLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentLinearLayoutParams.height = i3;
            }
            setLayoutParams(parentLinearLayoutParams);
        } else if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i2 != -999) {
                parentFrameLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentFrameLayoutParams.height = i3;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i3;
            parentRelativeLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentRelativeLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentRelativeLayoutParams.height = i5;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i3;
            parentLinearLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentLinearLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentLinearLayoutParams.height = i5;
            }
            setLayoutParams(parentLinearLayoutParams);
        } else if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i3;
            parentFrameLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentFrameLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentFrameLayoutParams.height = i5;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public FrameLayout.LayoutParams getParentFrameLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public CampaignEx getCampaign() {
        return this.b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.i = motionEvent.getRawX();
        this.j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.e, u.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.i));
                jSONObject.put(a.f, u.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.j));
                jSONObject.put(a.h, i2);
                try {
                    this.g = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                jSONObject.put(a.i, this.g);
                jSONObject.put(a.j, (double) u.d(getContext()));
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e4) {
            e = e4;
            jSONObject = jSONObject2;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    public Rect getRect() {
        return this.k;
    }

    public void setRect(Rect rect) {
        this.k = rect;
    }

    public void setLayout(int i2, int i3) {
        this.l = i2;
        this.m = i3;
    }

    public int getViewWidth() {
        return this.l;
    }

    public int getViewHeight() {
        return this.m;
    }

    protected static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", n);
            jSONObject.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            com.mbridge.msdk.video.bt.a.c.a().a(webView, e2.getMessage());
            q.a(TAG, e2.getMessage());
        }
    }
}
