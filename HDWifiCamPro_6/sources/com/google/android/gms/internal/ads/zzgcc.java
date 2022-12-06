package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgcc implements zzgak {
    private final zzgbu zza;
    private final zzghn zzb;
    private final zzghn zzc;

    /* synthetic */ zzgcc(zzgbu zzgbu, zzgcb zzgcb) {
        zzghn zzghn;
        this.zza = zzgbu;
        if (zzgbu.zzf()) {
            zzgho zzb2 = zzgfx.zza().zzb();
            zzght zza2 = zzgfu.zza(zzgbu);
            this.zzb = zzb2.zza(zza2, "aead", "encrypt");
            zzghn = zzb2.zza(zza2, "aead", "decrypt");
        } else {
            zzghn = zzgfu.zza;
            this.zzb = zzghn;
        }
        this.zzc = zzghn;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzgbo zzgbo : this.zza.zze(copyOf)) {
                try {
                    byte[] zza2 = ((zzgak) zzgbo.zzc()).zza(copyOfRange, bArr2);
                    zzgbo.zza();
                    int length2 = copyOfRange.length;
                    return zza2;
                } catch (GeneralSecurityException e) {
                    zzgcd.zza.logp(Level.INFO, "com.google.crypto.tink.aead.AeadWrapper$WrappedAead", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e.toString()));
                }
            }
        }
        for (zzgbo zzgbo2 : this.zza.zze(zzgap.zza)) {
            try {
                byte[] zza3 = ((zzgak) zzgbo2.zzc()).zza(bArr, bArr2);
                zzgbo2.zza();
                int length3 = bArr.length;
                return zza3;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zzc2 = zzgnv.zzc(this.zza.zza().zzd(), ((zzgak) this.zza.zza().zzc()).zzb(bArr, bArr2));
            this.zza.zza().zza();
            int length = bArr.length;
            return zzc2;
        } catch (GeneralSecurityException e) {
            throw e;
        }
    }
}
