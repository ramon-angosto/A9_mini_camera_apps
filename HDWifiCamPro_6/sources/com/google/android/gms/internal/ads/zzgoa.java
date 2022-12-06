package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgoa implements zzgas {
    private static final byte[] zza = new byte[0];
    private final zzgod zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzgny zze;
    private final int zzf;

    public zzgoa(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, zzgny zzgny) throws GeneralSecurityException {
        zzgoe.zzd(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzb = new zzgod(eCPublicKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zzf = i;
        this.zze = zzgny;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzgoc zza2 = this.zzb.zza(this.zzc, this.zzd, bArr2, this.zze.zza(), this.zzf);
        byte[] zza3 = this.zze.zzb(zza2.zzb()).zza(bArr, zza);
        byte[] zza4 = zza2.zza();
        return ByteBuffer.allocate(zza4.length + zza3.length).put(zza4).put(zza3).array();
    }
}
