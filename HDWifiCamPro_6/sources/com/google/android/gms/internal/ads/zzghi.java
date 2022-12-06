package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzghi implements zzgbj {
    private final zzgbu zza;
    private final zzghn zzb;
    private final zzghn zzc;

    /* synthetic */ zzghi(zzgbu zzgbu, zzghh zzghh) {
        zzghn zzghn;
        this.zza = zzgbu;
        if (zzgbu.zzf()) {
            zzgho zzb2 = zzgfx.zza().zzb();
            zzght zza2 = zzgfu.zza(zzgbu);
            this.zzb = zzb2.zza(zza2, "mac", "compute");
            zzghn = zzb2.zza(zza2, "mac", "verify");
        } else {
            zzghn = zzgfu.zza;
            this.zzb = zzghn;
        }
        this.zzc = zzghn;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzgbo zzgbo : this.zza.zze(copyOf)) {
                if (zzgbo.zzf() == 4) {
                    bArr3 = zzgnv.zzc(bArr2, zzghj.zzb);
                } else {
                    bArr3 = bArr2;
                }
                try {
                    ((zzgbj) zzgbo.zzc()).zza(copyOfRange, bArr3);
                    zzgbo.zza();
                    return;
                } catch (GeneralSecurityException e) {
                    zzghj.zza.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", "tag prefix matches a key, but cannot verify: ".concat(e.toString()));
                }
            }
            for (zzgbo zzgbo2 : this.zza.zze(zzgap.zza)) {
                try {
                    ((zzgbj) zzgbo2.zzc()).zza(bArr, bArr2);
                    zzgbo2.zza();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }

    public final byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        if (this.zza.zza().zzf() == 4) {
            bArr = zzgnv.zzc(bArr, zzghj.zzb);
        }
        try {
            byte[] zzc2 = zzgnv.zzc(this.zza.zza().zzd(), ((zzgbj) this.zza.zza().zzc()).zzb(bArr));
            this.zza.zza().zza();
            return zzc2;
        } catch (GeneralSecurityException e) {
            throw e;
        }
    }
}
