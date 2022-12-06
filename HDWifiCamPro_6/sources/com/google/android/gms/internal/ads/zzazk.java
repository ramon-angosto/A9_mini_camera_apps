package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzazk implements zzazm {
    private final byte[] zza;
    private Uri zzb;
    private int zzc;
    private int zzd;

    public zzazk(byte[] bArr) {
        if (bArr != null) {
            zzbac.zzc(bArr.length > 0);
            this.zza = bArr;
            return;
        }
        throw null;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.zza, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        return min;
    }

    public final long zzb(zzazo zzazo) throws IOException {
        this.zzb = zzazo.zza;
        long j = zzazo.zzc;
        int i = (int) j;
        this.zzc = i;
        long j2 = zzazo.zzd;
        long j3 = -1;
        if (j2 == -1) {
            j2 = ((long) this.zza.length) - j;
        } else {
            j3 = j2;
        }
        int i2 = (int) j2;
        this.zzd = i2;
        if (i2 > 0 && i + i2 <= this.zza.length) {
            return (long) i2;
        }
        int length = this.zza.length;
        throw new IOException("Unsatisfiable range: [" + i + ", " + j3 + "], length: " + length);
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws IOException {
        this.zzb = null;
    }
}
