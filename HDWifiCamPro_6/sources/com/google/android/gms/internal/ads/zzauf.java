package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzauf implements zzatl {
    private int zzb = -1;
    private int zzc = -1;
    private int[] zzd;
    private boolean zze;
    private int[] zzf;
    private ByteBuffer zzg;
    private ByteBuffer zzh;
    private boolean zzi;

    public zzauf() {
        ByteBuffer byteBuffer = zza;
        this.zzg = byteBuffer;
        this.zzh = byteBuffer;
    }

    public final int zza() {
        int[] iArr = this.zzf;
        return iArr == null ? this.zzb : iArr.length;
    }

    public final int zzb() {
        return 2;
    }

    public final ByteBuffer zzc() {
        ByteBuffer byteBuffer = this.zzh;
        this.zzh = zza;
        return byteBuffer;
    }

    public final void zzd() {
        this.zzh = zza;
        this.zzi = false;
    }

    public final void zze() {
        this.zzi = true;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = this.zzb;
        int length = ((limit - position) / (i + i)) * this.zzf.length;
        int i2 = length + length;
        if (this.zzg.capacity() < i2) {
            this.zzg = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.zzg.clear();
        }
        while (position < limit) {
            for (int i3 : this.zzf) {
                this.zzg.putShort(byteBuffer.getShort(i3 + i3 + position));
            }
            int i4 = this.zzb;
            position += i4 + i4;
        }
        byteBuffer.position(limit);
        this.zzg.flip();
        this.zzh = this.zzg;
    }

    public final void zzg() {
        zzd();
        this.zzg = zza;
        this.zzb = -1;
        this.zzc = -1;
        this.zzf = null;
        this.zze = false;
    }

    public final boolean zzh(int i, int i2, int i3) throws zzatk {
        boolean z = !Arrays.equals(this.zzd, this.zzf);
        this.zzf = this.zzd;
        int[] iArr = this.zzf;
        if (iArr == null) {
            this.zze = false;
            return z;
        } else if (i3 != 2) {
            throw new zzatk(i, i2, i3);
        } else if (!z && this.zzc == i && this.zzb == i2) {
            return false;
        } else {
            this.zzc = i;
            this.zzb = i2;
            this.zze = i2 != iArr.length;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzf;
                if (i4 >= iArr2.length) {
                    return true;
                }
                int i5 = iArr2[i4];
                if (i5 < i2) {
                    this.zze = (i5 != i4) | this.zze;
                    i4++;
                } else {
                    throw new zzatk(i, i2, 2);
                }
            }
        }
    }

    public final boolean zzi() {
        return this.zze;
    }

    public final boolean zzj() {
        return this.zzi && this.zzh == zza;
    }

    public final void zzk(int[] iArr) {
        this.zzd = iArr;
    }
}
