package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbcd implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzbcd(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzbbv(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzbcb(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzbby(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzbbx(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzbca(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzbbw(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzbbz(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzbcc zzbcc) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzbcc.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e) {
            zze.zzh("Error while dispatching lifecycle callback.", e);
        }
    }
}
