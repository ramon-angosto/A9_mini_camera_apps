package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzejg implements zzdmp {
    private final zzfdk zza;
    private final zzbxd zzb;
    private final boolean zzc;
    private zzdds zzd = null;

    zzejg(zzfdk zzfdk, zzbxd zzbxd, boolean z) {
        this.zza = zzfdk;
        this.zzb = zzbxd;
        this.zzc = z;
    }

    public final void zza(boolean z, Context context, zzddn zzddn) throws zzdmo {
        boolean z2;
        try {
            if (this.zzc) {
                z2 = this.zzb.zzr(ObjectWrapper.wrap(context));
            } else {
                z2 = this.zzb.zzq(ObjectWrapper.wrap(context));
            }
            if (!z2) {
                throw new zzdmo("Adapter failed to show.");
            } else if (this.zzd != null) {
                if (!((Boolean) zzay.zzc().zzb(zzbjc.zzbp)).booleanValue() && this.zza.zzZ == 2) {
                    this.zzd.zza();
                }
            }
        } catch (Throwable th) {
            throw new zzdmo(th);
        }
    }

    public final void zzb(zzdds zzdds) {
        this.zzd = zzdds;
    }
}
