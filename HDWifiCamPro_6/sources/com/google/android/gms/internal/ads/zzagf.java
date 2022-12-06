package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagf implements zzzi {
    public static final zzzp zza = zzage.zza;
    private zzzl zzb;
    private zzagn zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zze(zzzj zzzj) throws IOException {
        zzagh zzagh = new zzagh();
        if (zzagh.zzb(zzzj, true) && (zzagh.zza & 2) == 2) {
            int min = Math.min(zzagh.zze, 8);
            zzef zzef = new zzef(min);
            ((zzyy) zzzj).zzm(zzef.zzH(), 0, min, false);
            zzef.zzF(0);
            if (zzef.zza() >= 5 && zzef.zzk() == 127 && zzef.zzs() == 1179402563) {
                this.zzc = new zzagd();
            } else {
                zzef.zzF(0);
                try {
                    if (zzaav.zzd(1, zzef, true)) {
                        this.zzc = new zzagp();
                    }
                } catch (zzbu unused) {
                }
                zzef.zzF(0);
                if (zzagj.zzd(zzef)) {
                    this.zzc = new zzagj();
                }
            }
            return true;
        }
        return false;
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        zzdd.zzb(this.zzb);
        if (this.zzc == null) {
            if (zze(zzzj)) {
                zzzj.zzj();
            } else {
                throw zzbu.zza("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzd) {
            zzaap zzv = this.zzb.zzv(0, 1);
            this.zzb.zzC();
            this.zzc.zzh(this.zzb, zzv);
            this.zzd = true;
        }
        return this.zzc.zze(zzzj, zzaai);
    }

    public final void zzb(zzzl zzzl) {
        this.zzb = zzzl;
    }

    public final void zzc(long j, long j2) {
        zzagn zzagn = this.zzc;
        if (zzagn != null) {
            zzagn.zzj(j, j2);
        }
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        try {
            return zze(zzzj);
        } catch (zzbu unused) {
            return false;
        }
    }
}
