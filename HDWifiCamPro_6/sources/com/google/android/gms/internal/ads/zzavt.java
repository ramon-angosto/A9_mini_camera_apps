package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzavt {
    private static final long[] zza = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] zzb = new byte[8];
    private int zzc;
    private int zzd;

    public static int zzb(int i) {
        int i2 = 0;
        while (i2 < 8) {
            int i3 = ((zza[i2] & ((long) i)) > 0 ? 1 : ((zza[i2] & ((long) i)) == 0 ? 0 : -1));
            i2++;
            if (i3 != 0) {
                return i2;
            }
        }
        return -1;
    }

    public static long zzc(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~zza[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzd() {
        this.zzc = 0;
        this.zzd = 0;
    }

    public final long zze(zzauy zzauy, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.zzc == 0) {
            if (!zzauy.zzh(this.zzb, 0, 1, z)) {
                return -1;
            }
            int zzb2 = zzb(this.zzb[0] & UByte.MAX_VALUE);
            this.zzd = zzb2;
            if (zzb2 != -1) {
                this.zzc = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.zzd;
        if (i2 > i) {
            this.zzc = 0;
            return -2;
        }
        if (i2 != 1) {
            zzauy.zzh(this.zzb, 1, i2 - 1, false);
        }
        this.zzc = 0;
        return zzc(this.zzb, this.zzd, z2);
    }
}
