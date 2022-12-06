package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgcs extends zzgfr {
    zzgcs() {
        super(zzgjk.class, new zzgcq(zzgak.class));
    }

    public static void zzg(boolean z) throws GeneralSecurityException {
        if (zzm()) {
            zzgby.zzn(new zzgcs(), true);
        }
    }

    static /* bridge */ /* synthetic */ zzgfp zzh(int i, int i2) {
        zzgjm zzc = zzgjn.zzc();
        zzc.zza(i);
        return new zzgfp((zzgjn) zzc.zzam(), i2);
    }

    private static boolean zzm() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final zzgfq zza() {
        return new zzgcr(this, zzgjn.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgjk.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgjk zzgjk = (zzgjk) zzgso;
        zzgoz.zzb(zzgjk.zza(), 0);
        zzgoz.zza(zzgjk.zzf().zzd());
    }

    public final int zzf() {
        return 3;
    }
}
