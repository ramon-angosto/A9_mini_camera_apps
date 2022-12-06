package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzgqg extends zzgql {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    zzgqg(int i) {
        super((zzgqk) null);
        if (i >= 0) {
            this.zza = new byte[Math.max(i, 20)];
            this.zzb = this.zza.length;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    /* access modifiers changed from: package-private */
    public final void zzc(byte b) {
        byte[] bArr = this.zza;
        int i = this.zzc;
        this.zzc = i + 1;
        bArr[i] = b;
        this.zzd++;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i) {
        byte[] bArr = this.zza;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        this.zzc = i3;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        this.zzc = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i4 + 1;
        this.zzc = i5;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.zzc = i5 + 1;
        bArr[i5] = (byte) ((i >> 24) & 255);
        this.zzd += 4;
    }

    /* access modifiers changed from: package-private */
    public final void zze(long j) {
        byte[] bArr = this.zza;
        int i = this.zzc;
        int i2 = i + 1;
        this.zzc = i2;
        bArr[i] = (byte) ((int) (j & 255));
        int i3 = i2 + 1;
        this.zzc = i3;
        bArr[i2] = (byte) ((int) ((j >> 8) & 255));
        int i4 = i3 + 1;
        this.zzc = i4;
        bArr[i3] = (byte) ((int) ((j >> 16) & 255));
        int i5 = i4 + 1;
        this.zzc = i5;
        bArr[i4] = (byte) ((int) (255 & (j >> 24)));
        int i6 = i5 + 1;
        this.zzc = i6;
        bArr[i5] = (byte) (((int) (j >> 32)) & 255);
        int i7 = i6 + 1;
        this.zzc = i7;
        bArr[i6] = (byte) (((int) (j >> 40)) & 255);
        int i8 = i7 + 1;
        this.zzc = i8;
        bArr[i7] = (byte) (((int) (j >> 48)) & 255);
        this.zzc = i8 + 1;
        bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        this.zzd += 8;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i) {
        if (zzgql.zzb) {
            long j = (long) this.zzc;
            while ((i & -128) != 0) {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                zzgui.zzq(bArr, (long) i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            zzgui.zzq(bArr2, (long) i3, (byte) i);
            this.zzd += (int) (((long) this.zzc) - j);
            return;
        }
        while ((i & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr3[i4] = (byte) ((i & 127) | 128);
            this.zzd++;
            i >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        bArr4[i5] = (byte) i;
        this.zzd++;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(long j) {
        if (zzgql.zzb) {
            long j2 = (long) this.zzc;
            while ((j & -128) != 0) {
                byte[] bArr = this.zza;
                int i = this.zzc;
                this.zzc = i + 1;
                zzgui.zzq(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i2 = this.zzc;
            this.zzc = i2 + 1;
            zzgui.zzq(bArr2, (long) i2, (byte) ((int) j));
            this.zzd += (int) (((long) this.zzc) - j2);
            return;
        }
        while ((j & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            bArr3[i3] = (byte) ((((int) j) & 127) | 128);
            this.zzd++;
            j >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        bArr4[i4] = (byte) ((int) j);
        this.zzd++;
    }
}
