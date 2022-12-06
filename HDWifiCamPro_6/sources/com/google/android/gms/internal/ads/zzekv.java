package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzekv implements zzdmp {
    public final /* synthetic */ zzehf zza;

    public /* synthetic */ zzekv(zzehf zzehf) {
        this.zza = zzehf;
    }

    public final void zza(boolean z, Context context, zzddn zzddn) {
        zzehf zzehf = this.zza;
        try {
            ((zzffa) zzehf.zzb).zzu(z);
            ((zzffa) zzehf.zzb).zzx(context);
        } catch (zzfek e) {
            throw new zzdmo(e.getCause());
        }
    }
}
