package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgem implements zzgny {
    private final String zza;
    private final int zzb;
    private zzgje zzc;
    private zzgig zzd;
    private int zze;
    private zzgjq zzf;

    zzgem(zzgmc zzgmc) throws GeneralSecurityException {
        this.zza = zzgmc.zzf();
        if (this.zza.equals(zzgca.zzb)) {
            try {
                zzgjh zze2 = zzgjh.zze(zzgmc.zze(), zzgqq.zza());
                this.zzc = (zzgje) zzgby.zzd(zzgmc);
                this.zzb = zze2.zza();
            } catch (zzgrq e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zza.equals(zzgca.zza)) {
            try {
                zzgij zzd2 = zzgij.zzd(zzgmc.zze(), zzgqq.zza());
                this.zzd = (zzgig) zzgby.zzd(zzgmc);
                this.zze = zzd2.zze().zza();
                this.zzb = this.zze + zzd2.zzf().zza();
            } catch (zzgrq e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else if (this.zza.equals(zzgdx.zza)) {
            try {
                zzgjt zze3 = zzgjt.zze(zzgmc.zze(), zzgqq.zza());
                this.zzf = (zzgjq) zzgby.zzd(zzgmc);
                this.zzb = zze3.zza();
            } catch (zzgrq e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(this.zza)));
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzgfi zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zza.equals(zzgca.zzb)) {
            zzgjd zzc2 = zzgje.zzc();
            zzc2.zzak(this.zzc);
            zzc2.zza(zzgpw.zzw(bArr, 0, this.zzb));
            return new zzgfi((zzgak) zzgby.zzh(this.zza, (zzgje) zzc2.zzam(), zzgak.class));
        } else if (this.zza.equals(zzgca.zza)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            zzgil zzc3 = zzgim.zzc();
            zzc3.zzak(this.zzd.zzf());
            zzc3.zza(zzgpw.zzv(copyOfRange));
            zzgkz zzc4 = zzgla.zzc();
            zzc4.zzak(this.zzd.zzg());
            zzc4.zza(zzgpw.zzv(copyOfRange2));
            zzgif zzc5 = zzgig.zzc();
            zzc5.zzc(this.zzd.zza());
            zzc5.zza((zzgim) zzc3.zzam());
            zzc5.zzb((zzgla) zzc4.zzam());
            return new zzgfi((zzgak) zzgby.zzh(this.zza, (zzgig) zzc5.zzam(), zzgak.class));
        } else if (this.zza.equals(zzgdx.zza)) {
            zzgjp zzc6 = zzgjq.zzc();
            zzc6.zzak(this.zzf);
            zzc6.zza(zzgpw.zzw(bArr, 0, this.zzb));
            return new zzgfi((zzgaq) zzgby.zzh(this.zza, (zzgjq) zzc6.zzam(), zzgaq.class));
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
