package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzkg implements zzji {
    private final zzde zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzby zze = zzby.zza;

    public zzkg(zzde zzde) {
        this.zza = zzde;
    }

    public final long zza() {
        long j;
        long j2 = this.zzc;
        if (!this.zzb) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzby zzby = this.zze;
        if (zzby.zzc == 1.0f) {
            j = zzen.zzv(elapsedRealtime);
        } else {
            j = zzby.zza(elapsedRealtime);
        }
        return j2 + j;
    }

    public final void zzb(long j) {
        this.zzc = j;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    public final zzby zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (!this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
            this.zzb = true;
        }
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    public final void zzg(zzby zzby) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzby;
    }
}
