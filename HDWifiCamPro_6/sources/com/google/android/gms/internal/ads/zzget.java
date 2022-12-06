package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzget implements zzgas {
    private static final byte[] zza = new byte[0];
    private final zzglu zzb;
    private final zzgeu zzc;
    private final zzgeq zzd;
    private final zzgep zze;

    private zzget(zzglu zzglu, zzgeu zzgeu, zzgep zzgep, zzgeq zzgeq, byte[] bArr) {
        this.zzb = zzglu;
        this.zzc = zzgeu;
        this.zze = zzgep;
        this.zzd = zzgeq;
    }

    static zzget zzb(zzglu zzglu) throws GeneralSecurityException {
        if (!zzglu.zzh().zzD()) {
            zzglo zzc2 = zzglu.zzc();
            return new zzget(zzglu, zzgex.zzb(zzc2), zzgex.zzc(zzc2), zzgex.zza(zzc2), (byte[]) null);
        }
        throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        zzglu zzglu = this.zzb;
        zzgeu zzgeu = this.zzc;
        zzgep zzgep = this.zze;
        zzgeq zzgeq = this.zzd;
        zzgev zza2 = zzgeu.zza(zzglu.zzh().zzE());
        zzger zzc2 = zzger.zzc(zza2.zza(), zza2.zzb(), zzgeu, zzgep, zzgeq, bArr3);
        return zzgnv.zzc(zzc2.zza(), zzc2.zzb(bArr, zza));
    }
}
