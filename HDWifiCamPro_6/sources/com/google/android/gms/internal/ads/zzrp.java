package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzrp implements zzss, zzpl {
    final /* synthetic */ zzrr zza;
    private final Object zzb;
    private zzsr zzc;
    private zzpk zzd;

    public zzrp(zzrr zzrr, Object obj) {
        this.zza = zzrr;
        this.zzc = zzrr.zze((zzsi) null);
        this.zzd = zzrr.zzc((zzsi) null);
        this.zzb = obj;
    }

    private final boolean zzf(int i, zzsi zzsi) {
        zzsi zzsi2;
        if (zzsi != null) {
            zzsi2 = this.zza.zzv(this.zzb, zzsi);
            if (zzsi2 == null) {
                return false;
            }
        } else {
            zzsi2 = null;
        }
        zzsr zzsr = this.zzc;
        if (zzsr.zza != i || !zzen.zzT(zzsr.zzb, zzsi2)) {
            this.zzc = this.zza.zzf(i, zzsi2, 0);
        }
        zzpk zzpk = this.zzd;
        if (zzpk.zza == i && zzen.zzT(zzpk.zzb, zzsi2)) {
            return true;
        }
        this.zzd = this.zza.zzd(i, zzsi2);
        return true;
    }

    public final void zzaf(int i, zzsi zzsi, zzse zzse) {
        if (zzf(i, zzsi)) {
            this.zzc.zzc(zzse);
        }
    }

    public final void zzag(int i, zzsi zzsi, zzrz zzrz, zzse zzse) {
        if (zzf(i, zzsi)) {
            this.zzc.zze(zzrz, zzse);
        }
    }

    public final void zzah(int i, zzsi zzsi, zzrz zzrz, zzse zzse) {
        if (zzf(i, zzsi)) {
            this.zzc.zzg(zzrz, zzse);
        }
    }

    public final void zzai(int i, zzsi zzsi, zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
        if (zzf(i, zzsi)) {
            this.zzc.zzi(zzrz, zzse, iOException, z);
        }
    }

    public final void zzaj(int i, zzsi zzsi, zzrz zzrz, zzse zzse) {
        if (zzf(i, zzsi)) {
            this.zzc.zzk(zzrz, zzse);
        }
    }
}
