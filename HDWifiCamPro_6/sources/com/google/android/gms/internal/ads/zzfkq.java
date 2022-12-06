package com.google.android.gms.internal.ads;

import android.app.Application;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfkq {
    private boolean zza;

    /* access modifiers changed from: package-private */
    public final void zza(Context context) {
        zzfly.zzb(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzflm.zzb().zzc(context);
            zzflh zza2 = zzflh.zza();
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(zza2);
            }
            zzflw.zzg(context);
            zzflj.zzb().zzc(context);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zza;
    }
}
