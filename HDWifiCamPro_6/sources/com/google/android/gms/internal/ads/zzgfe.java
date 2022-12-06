package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgfe implements zzgeu {
    private final zzgep zza;
    private final int zzb;

    private zzgfe(zzgep zzgep, int i) {
        this.zza = zzgep;
        this.zzb = i;
    }

    static zzgfe zzc(int i) throws GeneralSecurityException {
        int i2 = i - 1;
        if (i2 == 0) {
            return new zzgfe(new zzgep("HmacSha256"), 1);
        }
        if (i2 != 1) {
            return new zzgfe(new zzgep("HmacSha512"), 3);
        }
        return new zzgfe(new zzgep("HmacSha384"), 2);
    }

    public final zzgev zza(byte[] bArr) throws GeneralSecurityException {
        KeyPair zzc = zzgoe.zzc(zzgoe.zzk(this.zzb));
        byte[] zzg = zzgoe.zzg((ECPrivateKey) zzc.getPrivate(), zzgoe.zzj(zzgoe.zzk(this.zzb), 1, bArr));
        int i = this.zzb;
        byte[] zzl = zzgoe.zzl(zzgoe.zzk(i).getCurve(), 1, ((ECPublicKey) zzc.getPublic()).getW());
        byte[] zzc2 = zzgnv.zzc(zzl, bArr);
        byte[] zzd = zzgfd.zzd(zzb());
        zzgep zzgep = this.zza;
        return new zzgev(zzgep.zzb((byte[]) null, zzg, "eae_prk", zzc2, "shared_secret", zzd, zzgep.zza()), zzl);
    }

    public final byte[] zzb() throws GeneralSecurityException {
        int i = this.zzb - 1;
        if (i == 0) {
            return zzgfd.zzc;
        }
        if (i != 1) {
            return zzgfd.zze;
        }
        return zzgfd.zzd;
    }
}
