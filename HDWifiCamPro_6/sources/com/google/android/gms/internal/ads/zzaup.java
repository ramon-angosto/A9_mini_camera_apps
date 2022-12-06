package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaup {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    private final MediaCodec.CryptoInfo zzg;
    private final zzauo zzh;

    public zzaup() {
        this.zzg = zzbar.zza >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzh = zzbar.zza >= 24 ? new zzauo(this.zzg, (zzaun) null) : null;
    }

    public final MediaCodec.CryptoInfo zza() {
        return this.zzg;
    }

    public final void zzb(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.zzf = i;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = 1;
        if (zzbar.zza >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzg;
            cryptoInfo.numSubSamples = this.zzf;
            cryptoInfo.numBytesOfClearData = this.zzd;
            cryptoInfo.numBytesOfEncryptedData = this.zze;
            cryptoInfo.key = this.zzb;
            cryptoInfo.iv = this.zza;
            cryptoInfo.mode = this.zzc;
            if (zzbar.zza >= 24) {
                zzauo.zza(this.zzh, 0, 0);
            }
        }
    }
}
