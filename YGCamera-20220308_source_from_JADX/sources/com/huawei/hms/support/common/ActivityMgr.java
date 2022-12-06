package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST = new ActivityMgr();

    /* renamed from: a */
    public WeakReference<Activity> f979a;

    /* renamed from: a */
    public static String m1367a(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }

    public Activity getCurrentActivity() {
        if (this.f979a == null) {
            HMSLog.m1379i("ActivityMgr", "mCurrentActivity is " + this.f979a);
            return null;
        }
        HMSLog.m1379i("ActivityMgr", "mCurrentActivity.get() is " + this.f979a.get());
        return (Activity) this.f979a.get();
    }

    public void init(Application application) {
        HMSLog.m1374d("ActivityMgr", "init");
        if (application == null) {
            HMSLog.m1380w("ActivityMgr", "init failed for app is null");
            return;
        }
        application.unregisterActivityLifecycleCallbacks(INST);
        application.registerActivityLifecycleCallbacks(INST);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        HMSLog.m1374d("ActivityMgr", "onCreated:" + m1367a(activity));
        this.f979a = new WeakReference<>(activity);
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        HMSLog.m1374d("ActivityMgr", "onResumed:" + m1367a(activity));
        this.f979a = new WeakReference<>(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        HMSLog.m1374d("ActivityMgr", "onStarted:" + m1367a(activity));
        this.f979a = new WeakReference<>(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
