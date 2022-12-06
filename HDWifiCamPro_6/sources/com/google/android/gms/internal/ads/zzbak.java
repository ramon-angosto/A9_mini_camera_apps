package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbak {
    public byte[] zza;
    private int zzb;
    private int zzc;

    public zzbak() {
    }

    public zzbak(int i) {
        this.zza = new byte[i];
        this.zzc = i;
    }

    public final int zza() {
        return this.zzc - this.zzb;
    }

    public final int zzb() {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        this.zzb = i4 + 1;
        return (bArr[i4] & UByte.MAX_VALUE) | ((b & UByte.MAX_VALUE) << 24) | ((b2 & UByte.MAX_VALUE) << 16) | ((b3 & UByte.MAX_VALUE) << 8);
    }

    public final int zzf() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return ((bArr[i2] & UByte.MAX_VALUE) << 8) | (b & UByte.MAX_VALUE);
    }

    public final int zzg() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    public final int zzh() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        this.zzb = i3 + 2;
        return (b2 & UByte.MAX_VALUE) | ((b & UByte.MAX_VALUE) << 8);
    }

    public final int zzi() {
        int zze = zze();
        if (zze >= 0) {
            return zze;
        }
        throw new IllegalStateException("Top bit not zero: " + zze);
    }

    public final int zzj() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return (bArr[i2] & UByte.MAX_VALUE) | ((b & UByte.MAX_VALUE) << 8);
    }

    public final long zzk() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        this.zzb = i4 + 1;
        return ((((long) b2) & 255) << 8) | (((long) b) & 255) | ((((long) b3) & 255) << 16) | ((((long) bArr[i4]) & 255) << 24);
    }

    public final long zzl() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.zzb = i5;
        byte b4 = bArr[i4];
        int i6 = i5 + 1;
        this.zzb = i6;
        byte b5 = bArr[i5];
        int i7 = i6 + 1;
        this.zzb = i7;
        byte b6 = bArr[i6];
        int i8 = i7 + 1;
        this.zzb = i8;
        byte b7 = bArr[i7];
        this.zzb = i8 + 1;
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) bArr[i8]) & 255);
    }

    public final long zzm() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        this.zzb = i4 + 1;
        return ((((long) b2) & 255) << 16) | ((((long) b) & 255) << 24) | ((((long) b3) & 255) << 8) | (((long) bArr[i4]) & 255);
    }

    public final long zzn() {
        long zzl = zzl();
        if (zzl >= 0) {
            return zzl;
        }
        throw new IllegalStateException("Top bit not zero: " + zzl);
    }

    public final String zzo(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.zzb;
        int i3 = i2 + i;
        int i4 = i3 - 1;
        if (i4 < this.zzc && this.zza[i4] == 0) {
            i--;
        }
        String str = new String(this.zza, i2, i);
        this.zzb = i3;
        return str;
    }

    public final short zzp() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return (short) ((bArr[i2] & UByte.MAX_VALUE) | ((b & UByte.MAX_VALUE) << 8));
    }

    public final void zzq(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zza, this.zzb, bArr, i, i2);
        this.zzb += i2;
    }

    public final void zzr() {
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zzs(int i) {
        zzt(zzb() < i ? new byte[i] : this.zza, i);
    }

    public final void zzt(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzc = i;
        this.zzb = 0;
    }

    public final void zzu(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zza.length) {
            z = true;
        }
        zzbac.zzc(z);
        this.zzc = i;
    }

    public final void zzv(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzc) {
            z = true;
        }
        zzbac.zzc(z);
        this.zzb = i;
    }

    public final void zzw(int i) {
        zzv(this.zzb + i);
    }

    public zzbak(byte[] bArr) {
        this.zza = bArr;
        this.zzc = bArr.length;
    }
}
