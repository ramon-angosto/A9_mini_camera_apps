package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbf {
    private final zzgmk zza;
    private final zzghm zzb = zzghm.zza;

    private zzgbf(zzgmk zzgmk) {
        this.zza = zzgmk;
    }

    static final zzgbf zza(zzgmk zzgmk) throws GeneralSecurityException {
        if (zzgmk != null && zzgmk.zza() > 0) {
            return new zzgbf(zzgmk);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static final zzgbf zzb(zzgbd zzgbd) throws GeneralSecurityException {
        zzgbg zzd = zzgbg.zzd();
        zzd.zzc(zzgbd.zza());
        return zzd.zzb();
    }

    public final String toString() {
        return zzgbz.zza(this.zza).toString();
    }

    /* access modifiers changed from: package-private */
    public final zzgmk zzc() {
        return this.zza;
    }

    public final Object zzd(Class cls) throws GeneralSecurityException {
        Class zze = zzgby.zze(cls);
        if (zze != null) {
            zzgbz.zzb(this.zza);
            zzgbn zzgbn = new zzgbn(zze, (zzgbm) null);
            zzgbn.zzc(this.zzb);
            for (zzgmj zzgmj : this.zza.zzh()) {
                if (zzgmj.zzi() == 3) {
                    Object zzf = zzgby.zzf(zzgmj.zzc(), zze);
                    if (zzgmj.zza() == this.zza.zzc()) {
                        zzgbn.zza(zzf, zzgmj);
                    } else {
                        zzgbn.zzb(zzf, zzgmj);
                    }
                }
            }
            return zzgby.zzj(zzgbn.zzd(), cls);
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls.getName())));
    }
}
