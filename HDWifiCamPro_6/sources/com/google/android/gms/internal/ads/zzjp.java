package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjp implements zzss, zzpl {
    final /* synthetic */ zzjt zza;
    private final zzjr zzb;
    private zzsr zzc;
    private zzpk zzd;

    public zzjp(zzjt zzjt, zzjr zzjr) {
        this.zza = zzjt;
        this.zzc = zzjt.zzf;
        this.zzd = zzjt.zzg;
        this.zzb = zzjr;
    }

    private final boolean zzf(int i, zzsi zzsi) {
        zzsi zzsi2 = null;
        if (zzsi != null) {
            zzjr zzjr = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzjr.zzc.size()) {
                    break;
                } else if (((zzsi) zzjr.zzc.get(i2)).zzd == zzsi.zzd) {
                    zzsi2 = zzsi.zzc(Pair.create(zzjr.zzb, zzsi.zza));
                    break;
                } else {
                    i2++;
                }
            }
            if (zzsi2 == null) {
                return false;
            }
        }
        int i3 = i + this.zzb.zzd;
        zzsr zzsr = this.zzc;
        if (zzsr.zza != i3 || !zzen.zzT(zzsr.zzb, zzsi2)) {
            this.zzc = this.zza.zzf.zza(i3, zzsi2, 0);
        }
        zzpk zzpk = this.zzd;
        if (zzpk.zza == i3 && zzen.zzT(zzpk.zzb, zzsi2)) {
            return true;
        }
        this.zzd = this.zza.zzg.zza(i3, zzsi2);
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
