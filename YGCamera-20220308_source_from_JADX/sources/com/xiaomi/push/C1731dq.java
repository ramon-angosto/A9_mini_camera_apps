package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.dq */
public class C1731dq implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Context f2070a;

    /* renamed from: a */
    private String f2071a = "";

    /* renamed from: b */
    private String f2072b;

    public C1731dq(Context context, String str) {
        this.f2070a = context;
        this.f2071a = str;
    }

    /* renamed from: a */
    private void m3037a(String str) {
        C1876hw hwVar = new C1876hw();
        hwVar.mo17811a(str);
        hwVar.mo17809a(System.currentTimeMillis());
        hwVar.mo17810a(C1870hq.ActivityActiveTimeStamp);
        C1741dz.m3060a(this.f2070a, hwVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!TextUtils.isEmpty(this.f2071a) && !TextUtils.isEmpty(localClassName)) {
            this.f2072b = "";
            if (TextUtils.isEmpty(this.f2072b) || TextUtils.equals(this.f2072b, localClassName)) {
                m3037a(this.f2070a.getPackageName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + localClassName + Constants.COLON_SEPARATOR + this.f2071a + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(System.currentTimeMillis() / 1000));
                this.f2071a = "";
                this.f2072b = "";
                return;
            }
            this.f2071a = "";
        }
    }

    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f2072b)) {
            this.f2072b = activity.getLocalClassName();
        }
        this.f2071a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
