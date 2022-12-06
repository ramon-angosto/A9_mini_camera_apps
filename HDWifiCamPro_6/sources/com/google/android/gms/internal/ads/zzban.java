package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzban implements zzbag {
    private boolean zza;
    private long zzb;
    private long zzc;
    private zzata zzd = zzata.zza;

    public final long zzI() {
        long j;
        long j2 = this.zzb;
        if (!this.zza) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzc;
        zzata zzata = this.zzd;
        if (zzata.zzb == 1.0f) {
            j = zzash.zza(elapsedRealtime);
        } else {
            j = zzata.zza(elapsedRealtime);
        }
        return j2 + j;
    }

    public final zzata zzJ() {
        throw null;
    }

    public final zzata zzK(zzata zzata) {
        if (this.zza) {
            zza(zzI());
        }
        this.zzd = zzata;
        return zzata;
    }

    public final void zza(long j) {
        this.zzb = j;
        if (this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
        }
    }

    public final void zzb() {
        if (!this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
            this.zza = true;
        }
    }

    public final void zzc() {
        if (this.zza) {
            zza(zzI());
            this.zza = false;
        }
    }

    public final void zzd(zzbag zzbag) {
        zza(zzbag.zzI());
        this.zzd = zzbag.zzJ();
    }
}
