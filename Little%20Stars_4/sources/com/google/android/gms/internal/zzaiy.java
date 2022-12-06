package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class zzaiy implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzaiy zzbSS = new zzaiy();
    private boolean zzWh;
    private final AtomicBoolean zzbST = new AtomicBoolean();

    private zzaiy() {
    }

    public static void zza(Application application) {
        application.registerActivityLifecycleCallbacks(zzbSS);
        application.registerComponentCallbacks(zzbSS);
        zzbSS.zzWh = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.zzbST.compareAndSet(true, false)) {
            FirebaseApp.zzaI(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.zzbST.compareAndSet(true, false)) {
            FirebaseApp.zzaI(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.zzbST.compareAndSet(false, true)) {
            FirebaseApp.zzaI(true);
        }
    }
}
