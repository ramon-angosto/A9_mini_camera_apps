package com.mbridge.msdk.video.signal.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.h;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONObject;

public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {
    private int a = 0;
    private int b = 1;
    /* access modifiers changed from: protected */
    public Activity j;
    /* access modifiers changed from: protected */
    public String k;
    /* access modifiers changed from: protected */
    public String l;
    /* access modifiers changed from: protected */
    public c m;
    protected String n;
    protected com.mbridge.msdk.videocommon.b.c o;
    protected String p;
    protected int q = 2;
    /* access modifiers changed from: protected */
    public boolean r = false;
    protected boolean s = false;
    protected int t;
    protected int u;
    protected int v;
    /* access modifiers changed from: protected */
    public boolean w = false;
    protected IJSFactory x = new a();

    public AbstractJSContainer(Context context) {
        super(context);
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.x = iJSFactory;
    }

    public void onResume() {
        if (!b.c) {
            if (getJSCommon().b()) {
                getActivityProxy().b();
            }
            getActivityProxy().a(0);
        }
    }

    public void onPause() {
        if (getJSCommon().b()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onStop() {
        if (getJSCommon().b()) {
            getActivityProxy().c();
        }
        getActivityProxy().a(3);
    }

    public void onRestart() {
        if (getJSCommon().b()) {
            getActivityProxy().e();
        }
        getActivityProxy().a(4);
    }

    public void onStart() {
        if (getJSCommon().b()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(2);
    }

    public void onDestroy() {
        if (getJSCommon().b()) {
            getActivityProxy().f();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().b()) {
            getActivityProxy().a(configuration);
        }
    }

    public com.mbridge.msdk.video.signal.a getActivityProxy() {
        return this.x.getActivityProxy();
    }

    public com.mbridge.msdk.video.signal.c getJSCommon() {
        return this.x.getJSCommon();
    }

    public i getJSVideoModule() {
        return this.x.getJSVideoModule();
    }

    public f getJSNotifyProxy() {
        return this.x.getJSNotifyProxy();
    }

    public e getJSContainerModule() {
        return this.x.getJSContainerModule();
    }

    public h getIJSRewardVideoV1() {
        return this.x.getIJSRewardVideoV1();
    }

    public com.mbridge.msdk.video.signal.b getJSBTModule() {
        return this.x.getJSBTModule();
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
        g.a().a(obj, a(this.a));
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj, String str) {
        g.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            q.d("AbstractJSContainer", "code to string is error");
            return "";
        }
    }

    public void setRewardId(String str) {
        this.p = str;
    }

    public void setUserId(String str) {
        this.n = str;
    }

    public void setUnitId(String str) {
        this.k = str;
    }

    public String getUnitId() {
        return this.k;
    }

    public String getPlacementId() {
        return this.l;
    }

    public void setPlacementId(String str) {
        this.l = str;
    }

    public void setActivity(Activity activity) {
        this.j = activity;
    }

    public void setReward(com.mbridge.msdk.videocommon.b.c cVar) {
        this.o = cVar;
    }

    public void setMute(int i) {
        this.q = i;
    }

    public void setIV(boolean z) {
        this.r = z;
    }

    public void setBidCampaign(boolean z) {
        this.s = z;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.t = i;
        this.u = i2;
        this.v = i3;
    }

    public void setBigOffer(boolean z) {
        this.w = z;
    }

    public void setRewardUnitSetting(c cVar) {
        this.m = cVar;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        q.d("AbstractJSContainer", str);
        Activity activity = this.j;
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: protected */
    public final j b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        a.C0105a a2 = com.mbridge.msdk.videocommon.a.a(this.r ? 287 : 94, campaignEx);
        if (a2 != null && a2.c()) {
            WindVaneWebView a3 = a2.a();
            if (a3.getObject() instanceof j) {
                return (j) a3.getObject();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final int c(CampaignEx campaignEx) {
        j b2 = b(campaignEx);
        if (b2 != null) {
            return b2.l();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void a(c cVar, CampaignEx campaignEx) {
        CampaignEx.c rewardTemplateMode;
        if (c(campaignEx) != 1) {
            boolean z = false;
            if (!(campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null)) {
                z = b(rewardTemplateMode.c());
            }
            if (!z && cVar != null) {
                b(this.m.c());
            }
        }
    }

    private boolean b(int i) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.j.setRequestedOrientation(11);
                } else {
                    this.j.setRequestedOrientation(0);
                }
            } catch (Throwable th) {
                q.a("AbstractJSContainer", th.getMessage(), th);
                return false;
            }
        } else if (Build.VERSION.SDK_INT >= 18) {
            this.j.setRequestedOrientation(12);
        } else {
            this.j.setRequestedOrientation(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final String b() {
        c cVar;
        if (!TextUtils.isEmpty(this.l) || (cVar = this.m) == null || TextUtils.isEmpty(cVar.y())) {
            return this.l;
        }
        return this.m.y();
    }
}
