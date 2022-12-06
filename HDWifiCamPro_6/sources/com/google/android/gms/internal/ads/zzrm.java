package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzrm implements zztz {
    public final zztz zza;
    final /* synthetic */ zzrn zzb;
    private boolean zzc;

    public zzrm(zzrn zzrn, zztz zztz) {
        this.zzb = zzrn;
        this.zza = zztz;
    }

    public final int zza(zzjg zzjg, zzgi zzgi, int i) {
        if (this.zzb.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzgi.zzc(4);
            return -4;
        }
        int zza2 = this.zza.zza(zzjg, zzgi, i);
        if (zza2 == -5) {
            zzaf zzaf = zzjg.zza;
            if (zzaf != null) {
                int i2 = zzaf.zzC;
                int i3 = 0;
                if (i2 == 0) {
                    if (zzaf.zzD != 0) {
                        i2 = 0;
                    }
                    return -5;
                }
                if (this.zzb.zzb == Long.MIN_VALUE) {
                    i3 = zzaf.zzD;
                }
                zzad zzb2 = zzaf.zzb();
                zzb2.zzC(i2);
                zzb2.zzD(i3);
                zzjg.zza = zzb2.zzY();
                return -5;
            }
            throw null;
        }
        zzrn zzrn = this.zzb;
        long j = zzrn.zzb;
        if (j == Long.MIN_VALUE || ((zza2 != -4 || zzgi.zzd < j) && (zza2 != -3 || zzrn.zzb() != Long.MIN_VALUE || zzgi.zzc))) {
            return zza2;
        }
        zzgi.zzb();
        zzgi.zzc(4);
        this.zzc = true;
        return -4;
    }

    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
