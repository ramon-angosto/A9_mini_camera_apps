package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzelo implements zzdmp {
    public final /* synthetic */ zzehf zza;

    public /* synthetic */ zzelo(zzehf zzehf) {
        this.zza = zzehf;
    }

    public final void zza(boolean z, Context context, zzddn zzddn) {
        zzehf zzehf = this.zza;
        try {
            ((zzffa) zzehf.zzb).zzu(z);
            ((zzffa) zzehf.zzb).zzy();
        } catch (zzfek e) {
            zze.zzk("Cannot show rewarded video.", e);
            throw new zzdmo(e.getCause());
        }
    }
}
