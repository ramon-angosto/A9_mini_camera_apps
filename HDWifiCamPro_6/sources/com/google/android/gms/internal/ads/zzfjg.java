package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfjg implements zzdjx, zzddq, zzdkb {
    private final zzfju zza;
    private final zzfjj zzb;

    zzfjg(Context context, zzfju zzfju) {
        this.zza = zzfju;
        this.zzb = zzfji.zza(context, 13);
    }

    public final void zza() {
    }

    public final void zzb() {
        if (((Boolean) zzbkl.zzd.zze()).booleanValue()) {
            zzfju zzfju = this.zza;
            zzfjj zzfjj = this.zzb;
            zzfjj.zze(true);
            zzfju.zza(zzfjj);
        }
    }

    public final void zzf() {
    }

    public final void zzg() {
        if (((Boolean) zzbkl.zzd.zze()).booleanValue()) {
            this.zzb.zzf();
        }
    }

    public final void zzk(zze zze) {
        if (((Boolean) zzbkl.zzd.zze()).booleanValue()) {
            zzfju zzfju = this.zza;
            zzfjj zzfjj = this.zzb;
            zzfjj.zze(false);
            zzfju.zza(zzfjj);
        }
    }
}
