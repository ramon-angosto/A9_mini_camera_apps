package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdwk implements zzdfv, zzdeo, zzddd, zzddu, zza, zzdig {
    private final zzbep zza;
    private boolean zzb = false;

    public zzdwk(zzbep zzbep, @Nullable zzfbf zzfbf) {
        this.zza = zzbep;
        zzbep.zzc(2);
        if (zzfbf != null) {
            zzbep.zzc(IronSourceConstants.RV_API_HAS_AVAILABILITY_TRUE);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzc(7);
            this.zzb = true;
            return;
        }
        this.zza.zzc(8);
    }

    public final void zza(zze zze) {
        switch (zze.zza) {
            case 1:
                this.zza.zzc(101);
                return;
            case 2:
                this.zza.zzc(102);
                return;
            case 3:
                this.zza.zzc(5);
                return;
            case 4:
                this.zza.zzc(103);
                return;
            case 5:
                this.zza.zzc(104);
                return;
            case 6:
                this.zza.zzc(105);
                return;
            case 7:
                this.zza.zzc(106);
                return;
            default:
                this.zza.zzc(4);
                return;
        }
    }

    public final void zzb(zzfdw zzfdw) {
        this.zza.zzb(new zzdwg(zzfdw));
    }

    public final void zzbE(zzcbc zzcbc) {
    }

    public final void zzd() {
        this.zza.zzc(1109);
    }

    public final void zze(zzbfk zzbfk) {
        this.zza.zzb(new zzdwj(zzbfk));
        this.zza.zzc(1103);
    }

    public final void zzf(zzbfk zzbfk) {
        this.zza.zzb(new zzdwi(zzbfk));
        this.zza.zzc(IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE);
    }

    public final void zzh(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    public final void zzi(zzbfk zzbfk) {
        this.zza.zzb(new zzdwh(zzbfk));
        this.zza.zzc(1104);
    }

    public final void zzk(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    public final synchronized void zzl() {
        this.zza.zzc(6);
    }

    public final void zzn() {
        this.zza.zzc(3);
    }
}
