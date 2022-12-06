package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbd {
    private final zzgmc zza;

    private zzgbd(zzgmc zzgmc) {
        this.zza = zzgmc;
    }

    public static zzgbd zze(String str, byte[] bArr, int i) {
        zzgmb zza2 = zzgmc.zza();
        zza2.zza(str);
        zza2.zzb(zzgpw.zzv(bArr));
        int i2 = i - 1;
        zza2.zzc(i2 != 0 ? i2 != 1 ? 5 : 4 : 3);
        return new zzgbd((zzgmc) zza2.zzam());
    }

    /* access modifiers changed from: package-private */
    public final zzgmc zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zza.zzf();
    }

    public final byte[] zzc() {
        return this.zza.zze().zzE();
    }

    public final int zzd() {
        int zzi = this.zza.zzi() - 2;
        int i = 1;
        if (zzi != 1) {
            i = 2;
            if (zzi != 2) {
                i = 3;
                if (zzi != 3) {
                    if (zzi == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i;
    }
}
