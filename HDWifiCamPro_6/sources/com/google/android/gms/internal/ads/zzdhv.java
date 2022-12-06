package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdhv implements zzdfv {
    private int zza = ((Integer) zzay.zzc().zzb(zzbjc.zzba)).intValue();

    public final synchronized void zzb(zzfdw zzfdw) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbb)).booleanValue()) {
            try {
                this.zza = zzfdw.zzb.zzb.zzc;
            } catch (NullPointerException unused) {
            }
        }
    }

    public final void zzbE(zzcbc zzcbc) {
    }

    public final synchronized int zzc() {
        return this.zza;
    }
}
