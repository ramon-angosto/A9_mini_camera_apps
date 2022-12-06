package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfer {
    public zzfer() {
        try {
            zzgca.zza();
        } catch (GeneralSecurityException e) {
            zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            zzt.zzo().zzt(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgpt zzt = zzgpw.zzt();
        try {
            zzgao.zzb(zzgbf.zzb(zzgbe.zza("AES128_GCM")), zzgam.zzb(zzt));
        } catch (IOException | GeneralSecurityException e) {
            zze.zza("Failed to generate key".concat(e.toString()));
            zzt.zzo().zzt(e, "CryptoUtils.generateKey");
        }
        String encodeToString = Base64.encodeToString(zzt.zzb().zzE(), 11);
        zzt.zzc();
        return encodeToString;
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdxl zzdxl) {
        zzgbf zzc = zzc(str);
        if (zzc == null) {
            return null;
        }
        try {
            byte[] zza = ((zzgak) zzc.zzd(zzgak.class)).zza(bArr, bArr2);
            zzdxl.zza().put("ds", "1");
            return new String(zza, "UTF-8");
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            zze.zza("Failed to decrypt ".concat(e.toString()));
            zzt.zzo().zzt(e, "CryptoUtils.decrypt");
            zzdxl.zza().put("dsf", e.toString());
            return null;
        }
    }

    @Nullable
    private static final zzgbf zzc(String str) {
        try {
            return zzgao.zza(zzgal.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e) {
            zze.zza("Failed to get keysethandle".concat(e.toString()));
            zzt.zzo().zzt(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
