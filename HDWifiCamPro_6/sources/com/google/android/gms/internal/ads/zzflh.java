package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzflh implements Application.ActivityLifecycleCallbacks {
    private static final zzflh zza = new zzflh();
    private boolean zzb;
    private boolean zzc;
    private zzflm zzd;

    private zzflh() {
    }

    public static zzflh zza() {
        return zza;
    }

    private final void zze() {
        boolean z = this.zzc;
        for (zzfkv zzg : zzflg.zza().zzc()) {
            zzfls zzg2 = zzg.zzg();
            if (zzg2.zzk()) {
                zzfll.zza().zzb(zzg2.zza(), "setState", true != z ? "foregrounded" : "backgrounded");
            }
        }
    }

    private final void zzf(boolean z) {
        if (this.zzc != z) {
            this.zzc = z;
            if (this.zzb) {
                zze();
                if (this.zzd == null) {
                    return;
                }
                if (!z) {
                    zzfmi.zzd().zzi();
                } else {
                    zzfmi.zzd().zzh();
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzf(false);
    }

    public final void onActivityStopped(Activity activity) {
        View zzf;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i = runningAppProcessInfo.importance;
        boolean z = false;
        boolean z2 = true;
        for (zzfkv zzfkv : zzflg.zza().zzb()) {
            if (zzfkv.zzj() && (zzf = zzfkv.zzf()) != null && zzf.hasWindowFocus()) {
                z2 = false;
            }
        }
        if (i != 100 && z2) {
            z = true;
        }
        zzf(z);
    }

    public final void zzb() {
        this.zzb = true;
        this.zzc = false;
        zze();
    }

    public final void zzc() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = null;
    }

    public final void zzd(zzflm zzflm) {
        this.zzd = zzflm;
    }
}
