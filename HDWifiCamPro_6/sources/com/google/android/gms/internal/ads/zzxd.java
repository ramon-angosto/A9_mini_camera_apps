package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzxd {
    private zzxc zza = new zzxc();
    private zzxc zzb = new zzxc();
    private boolean zzc;
    private long zzd = C.TIME_UNSET;
    private int zze;

    public final float zza() {
        if (this.zza.zzf()) {
            return (float) (1.0E9d / ((double) this.zza.zza()));
        }
        return -1.0f;
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc() {
        return this.zza.zzf() ? this.zza.zza() : C.TIME_UNSET;
    }

    public final long zzd() {
        return this.zza.zzf() ? this.zza.zzb() : C.TIME_UNSET;
    }

    public final void zze(long j) {
        this.zza.zzc(j);
        int i = 0;
        if (this.zza.zzf()) {
            this.zzc = false;
        } else if (this.zzd != C.TIME_UNSET) {
            if (!this.zzc || this.zzb.zze()) {
                this.zzb.zzd();
                this.zzb.zzc(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzc(j);
        }
        if (this.zzc && this.zzb.zzf()) {
            zzxc zzxc = this.zza;
            this.zza = this.zzb;
            this.zzb = zzxc;
            this.zzc = false;
        }
        this.zzd = j;
        if (!this.zza.zzf()) {
            i = this.zze + 1;
        }
        this.zze = i;
    }

    public final void zzf() {
        this.zza.zzd();
        this.zzb.zzd();
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
        this.zze = 0;
    }

    public final boolean zzg() {
        return this.zza.zzf();
    }
}
