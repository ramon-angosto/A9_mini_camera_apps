package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgf {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    public int zzg;
    public int zzh;
    private final MediaCodec.CryptoInfo zzi = new MediaCodec.CryptoInfo();
    private final zzge zzj;

    public zzgf() {
        this.zzj = zzen.zza >= 24 ? new zzge(this.zzi, (zzgd) null) : null;
    }

    public final MediaCodec.CryptoInfo zza() {
        return this.zzi;
    }

    public final void zzb(int i) {
        if (i != 0) {
            if (this.zzd == null) {
                this.zzd = new int[1];
                this.zzi.numBytesOfClearData = this.zzd;
            }
            int[] iArr = this.zzd;
            iArr[0] = iArr[0] + i;
        }
    }

    public final void zzc(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.zzf = i;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = i2;
        this.zzg = i3;
        this.zzh = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.zzi;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (zzen.zza >= 24) {
            zzge zzge = this.zzj;
            if (zzge != null) {
                zzge.zza(zzge, i3, i4);
                return;
            }
            throw null;
        }
    }
}
