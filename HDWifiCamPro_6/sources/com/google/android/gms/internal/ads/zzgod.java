package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgod {
    private final ECPublicKey zza;

    public zzgod(ECPublicKey eCPublicKey) {
        this.zza = eCPublicKey;
    }

    public final zzgoc zza(String str, byte[] bArr, byte[] bArr2, int i, int i2) throws GeneralSecurityException {
        KeyPair zzc = zzgoe.zzc(this.zza.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) zzc.getPublic();
        byte[] zzg = zzgoe.zzg((ECPrivateKey) zzc.getPrivate(), this.zza);
        byte[] zzl = zzgoe.zzl(eCPublicKey.getParams().getCurve(), i2, eCPublicKey.getW());
        int i3 = 1;
        byte[] zzc2 = zzgnv.zzc(zzl, zzg);
        Mac mac = (Mac) zzgog.zzb.zza(str);
        if (i <= mac.getMacLength() * 255) {
            if (bArr == null || bArr.length == 0) {
                mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
            } else {
                mac.init(new SecretKeySpec(bArr, str));
            }
            byte[] doFinal = mac.doFinal(zzc2);
            byte[] bArr3 = new byte[i];
            mac.init(new SecretKeySpec(doFinal, str));
            byte[] bArr4 = new byte[0];
            int i4 = 0;
            while (true) {
                mac.update(bArr4);
                mac.update(bArr2);
                mac.update((byte) i3);
                bArr4 = mac.doFinal();
                int length = bArr4.length;
                int i5 = i4 + length;
                if (i5 < i) {
                    System.arraycopy(bArr4, 0, bArr3, i4, length);
                    i3++;
                    i4 = i5;
                } else {
                    System.arraycopy(bArr4, 0, bArr3, i4, i - i4);
                    return new zzgoc(zzl, bArr3);
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }
}
