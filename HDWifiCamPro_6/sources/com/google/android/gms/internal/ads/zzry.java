package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzry implements zzex {
    private final zzex zza;
    private final int zzb;
    private final zzrx zzc;
    private final byte[] zzd;
    private int zze;

    public zzry(zzex zzex, int i, zzrx zzrx) {
        zzdd.zzd(i > 0);
        this.zza = zzex;
        this.zzb = i;
        this.zzc = zzrx;
        this.zzd = new byte[1];
        this.zze = i;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zze;
        if (i3 == 0) {
            int i4 = 0;
            if (this.zza.zza(this.zzd, 0, 1) != -1) {
                int i5 = (this.zzd[0] & UByte.MAX_VALUE) << 4;
                if (i5 != 0) {
                    byte[] bArr2 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int zza2 = this.zza.zza(bArr2, i4, i6);
                        if (zza2 != -1) {
                            i4 += zza2;
                            i6 -= zza2;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr2[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.zzc.zza(new zzef(bArr2, i5));
                    }
                }
                i3 = this.zzb;
                this.zze = i3;
            }
            return -1;
        }
        int zza3 = this.zza.zza(bArr, i, Math.min(i3, i2));
        if (zza3 != -1) {
            this.zze -= zza3;
        }
        return zza3;
    }

    public final long zzb(zzfc zzfc) {
        throw new UnsupportedOperationException();
    }

    public final Uri zzc() {
        return this.zza.zzc();
    }

    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    public final Map zze() {
        return this.zza.zze();
    }

    public final void zzf(zzfz zzfz) {
        if (zzfz != null) {
            this.zza.zzf(zzfz);
            return;
        }
        throw null;
    }
}
