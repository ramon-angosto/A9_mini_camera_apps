package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdtq implements zza, zzbop, zzo, zzbor, zzz, zzdkn {
    private zza zza;
    private zzbop zzb;
    private zzo zzc;
    private zzbor zzd;
    private zzz zze;
    private zzdkn zzf;

    /* access modifiers changed from: private */
    public final synchronized void zzi(zza zza2, zzbop zzbop, zzo zzo, zzbor zzbor, zzz zzz, zzdkn zzdkn) {
        this.zza = zza2;
        this.zzb = zzbop;
        this.zzc = zzo;
        this.zzd = zzbor;
        this.zze = zzz;
        this.zzf = zzdkn;
    }

    public final synchronized void onAdClicked() {
        zza zza2 = this.zza;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzbop zzbop = this.zzb;
        if (zzbop != null) {
            zzbop.zza(str, bundle);
        }
    }

    public final synchronized void zzb() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzb();
        }
    }

    public final synchronized void zzbC() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbC();
        }
    }

    public final synchronized void zzbD(String str, String str2) {
        zzbor zzbor = this.zzd;
        if (zzbor != null) {
            zzbor.zzbD(str, str2);
        }
    }

    public final synchronized void zzbK() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbK();
        }
    }

    public final synchronized void zzbr() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbr();
        }
    }

    public final synchronized void zze() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zze();
        }
    }

    public final synchronized void zzf(int i) {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzf(i);
        }
    }

    public final synchronized void zzg() {
        zzz zzz = this.zze;
        if (zzz != null) {
            ((zzdtr) zzz).zza.zzb();
        }
    }

    public final synchronized void zzq() {
        zzdkn zzdkn = this.zzf;
        if (zzdkn != null) {
            zzdkn.zzq();
        }
    }
}
