package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgpt extends OutputStream {
    private static final byte[] zza = new byte[0];
    private final int zzb = 128;
    private final ArrayList zzc = new ArrayList();
    private int zzd;
    private byte[] zze = new byte[128];
    private int zzf;

    zzgpt(int i) {
    }

    private final void zzd(int i) {
        this.zzc.add(new zzgps(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza())});
    }

    public final synchronized void write(int i) {
        if (this.zzf == this.zze.length) {
            zzd(1);
        }
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        this.zzf = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized int zza() {
        return this.zzd + this.zzf;
    }

    public final synchronized zzgpw zzb() {
        int i = this.zzf;
        byte[] bArr = this.zze;
        if (i >= bArr.length) {
            this.zzc.add(new zzgps(this.zze));
            this.zze = zza;
        } else if (i > 0) {
            this.zzc.add(new zzgps(Arrays.copyOf(bArr, i)));
        }
        this.zzd += this.zzf;
        this.zzf = 0;
        return zzgpw.zzu(this.zzc);
    }

    public final synchronized void zzc() {
        this.zzc.clear();
        this.zzd = 0;
        this.zzf = 0;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i3 = this.zzf;
        int i4 = length - i3;
        if (i2 <= i4) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.zzf += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i4);
        int i5 = i2 - i4;
        zzd(i5);
        System.arraycopy(bArr, i + i4, this.zze, 0, i5);
        this.zzf = i5;
    }
}
