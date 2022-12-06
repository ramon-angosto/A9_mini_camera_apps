package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgpp extends zzgps {
    private final int zzc;
    private final int zzd;

    zzgpp(byte[] bArr, int i, int i2) {
        super(bArr);
        zzq(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        zzB(i, this.zzd);
        return this.zza[this.zzc + i];
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    /* access modifiers changed from: protected */
    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc + i, bArr, i2, i3);
    }
}
