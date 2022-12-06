package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcoe {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcoe(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzcoe zza() {
        return new zzcoe(0, 0, 0);
    }

    public static zzcoe zzb(int i, int i2) {
        return new zzcoe(1, i, i2);
    }

    public static zzcoe zzc(zzq zzq) {
        if (zzq.zzd) {
            return new zzcoe(3, 0, 0);
        }
        if (zzq.zzi) {
            return new zzcoe(2, 0, 0);
        }
        if (zzq.zzh) {
            return zza();
        }
        return zzb(zzq.zzf, zzq.zzc);
    }

    public static zzcoe zzd() {
        return new zzcoe(5, 0, 0);
    }

    public static zzcoe zze() {
        return new zzcoe(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
