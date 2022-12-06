package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzahf {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;
    private int zzf;

    public zzahf(int i) {
    }

    public final void zza(byte[] bArr, int i, int i2) {
        if (this.zze) {
            int i3 = i2 - i;
            byte[] bArr2 = this.zzc;
            int length = bArr2.length;
            int i4 = this.zza + i3;
            if (length < i4) {
                this.zzc = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.zzc, this.zza, i3);
            this.zza += i3;
        }
    }

    public final void zzb() {
        this.zze = false;
        this.zza = 0;
        this.zzf = 0;
    }

    public final boolean zzc(int i, int i2) {
        int i3 = this.zzf;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i == 179 || i == 181) {
                            this.zza -= i2;
                            this.zze = false;
                            return true;
                        }
                    } else if ((i & PsExtractor.VIDEO_STREAM_MASK) != 32) {
                        zzdw.zze("H263Reader", "Unexpected start code value");
                        zzb();
                    } else {
                        this.zzb = this.zza;
                        this.zzf = 4;
                    }
                } else if (i > 31) {
                    zzdw.zze("H263Reader", "Unexpected start code value");
                    zzb();
                } else {
                    this.zzf = 3;
                }
            } else if (i != 181) {
                zzdw.zze("H263Reader", "Unexpected start code value");
                zzb();
            } else {
                this.zzf = 2;
            }
        } else if (i == 176) {
            this.zzf = 1;
            this.zze = true;
        }
        zza(zzd, 0, 3);
        return false;
    }
}
