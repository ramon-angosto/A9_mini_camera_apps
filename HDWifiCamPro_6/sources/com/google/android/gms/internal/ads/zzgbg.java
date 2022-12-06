package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbg {
    private final zzgmh zza;

    private zzgbg(zzgmh zzgmh) {
        this.zza = zzgmh;
    }

    public static zzgbg zzd() {
        return new zzgbg(zzgmk.zzd());
    }

    private final synchronized int zze() {
        int zza2;
        zza2 = zzggq.zza();
        while (zzg(zza2)) {
            zza2 = zzggq.zza();
        }
        return zza2;
    }

    private final synchronized zzgmj zzf(zzgmc zzgmc) throws GeneralSecurityException {
        return zzh(zzgby.zzc(zzgmc), zzgmc.zzi());
    }

    private final synchronized boolean zzg(int i) {
        boolean z;
        Iterator it = this.zza.zzc().iterator();
        while (true) {
            if (it.hasNext()) {
                if (((zzgmj) it.next()).zza() == i) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    private final synchronized zzgmj zzh(zzglx zzglx, int i) throws GeneralSecurityException {
        zzgmi zzd;
        int zze = zze();
        if (i != 2) {
            zzd = zzgmj.zzd();
            zzd.zza(zzglx);
            zzd.zzb(zze);
            zzd.zzd(3);
            zzd.zzc(i);
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zzgmj) zzd.zzam();
    }

    @Deprecated
    public final synchronized int zza(zzgmc zzgmc, boolean z) throws GeneralSecurityException {
        zzgmj zzf;
        zzf = zzf(zzgmc);
        this.zza.zza(zzf);
        this.zza.zzb(zzf.zza());
        return zzf.zza();
    }

    public final synchronized zzgbf zzb() throws GeneralSecurityException {
        return zzgbf.zza((zzgmk) this.zza.zzam());
    }

    @Deprecated
    public final synchronized zzgbg zzc(zzgmc zzgmc) throws GeneralSecurityException {
        zza(zzgmc, true);
        return this;
    }
}
