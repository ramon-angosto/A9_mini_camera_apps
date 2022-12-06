package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzyu {
    protected final zzyo zza;
    protected final zzyt zzb;
    protected zzyq zzc;
    private final int zzd;

    protected zzyu(zzyr zzyr, zzyt zzyt, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzyt;
        this.zzd = i;
        this.zza = new zzyo(zzyr, j, 0, j3, j4, j5, j6);
    }

    protected static final int zzf(zzzj zzzj, long j, zzaai zzaai) {
        if (j == zzzj.zzf()) {
            return 0;
        }
        zzaai.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzzj zzzj, long j) throws IOException {
        long zzf = j - zzzj.zzf();
        if (zzf < 0 || zzf > 262144) {
            return false;
        }
        ((zzyy) zzzj).zzo((int) zzf, false);
        return true;
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        while (true) {
            zzyq zzyq = this.zzc;
            zzdd.zzb(zzyq);
            long zzb2 = zzyq.zzf;
            long zza2 = zzyq.zzg;
            long zzc2 = zzyq.zzh;
            if (zza2 - zzb2 <= ((long) this.zzd)) {
                zzc(false, zzb2);
                return zzf(zzzj, zzb2, zzaai);
            } else if (!zzg(zzzj, zzc2)) {
                return zzf(zzzj, zzc2, zzaai);
            } else {
                zzzj.zzj();
                zzys zza3 = this.zzb.zza(zzzj, zzyq.zzb);
                int zza4 = zza3.zzb;
                if (zza4 == -3) {
                    zzc(false, zzc2);
                    return zzf(zzzj, zzc2, zzaai);
                } else if (zza4 == -2) {
                    zzyq.zzh(zzyq, zza3.zzc, zza3.zzd);
                } else if (zza4 != -1) {
                    zzg(zzzj, zza3.zzd);
                    zzc(true, zza3.zzd);
                    return zzf(zzzj, zza3.zzd, zzaai);
                } else {
                    zzyq.zzg(zzyq, zza3.zzc, zza3.zzd);
                }
            }
        }
    }

    public final zzaal zzb() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        long j2 = j;
        zzyq zzyq = this.zzc;
        if (zzyq == null || zzyq.zza != j2) {
            long zzf = this.zza.zzf(j2);
            zzyo zzyo = this.zza;
            zzyq zzyq2 = r1;
            zzyq zzyq3 = new zzyq(j, zzf, 0, zzyo.zzc, zzyo.zzd, zzyo.zze, zzyo.zzf);
            this.zzc = zzyq2;
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
