package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzapu implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzapu(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzapm(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzaps(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzapp(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzapo(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzapr(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzapn(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzapq(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzapt zzapt) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzapt.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
