package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzju {
    private static final zzsi zzs = new zzsi(new Object());
    public final zzcn zza;
    public final zzsi zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzha zzf;
    public final boolean zzg;
    public final zzuh zzh;
    public final zzwa zzi;
    public final List zzj;
    public final zzsi zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzby zzn;
    public final boolean zzo;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;

    public zzju(zzcn zzcn, zzsi zzsi, long j, long j2, int i, zzha zzha, boolean z, zzuh zzuh, zzwa zzwa, List list, zzsi zzsi2, boolean z2, int i2, zzby zzby, long j3, long j4, long j5, boolean z3) {
        this.zza = zzcn;
        this.zzb = zzsi;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzha;
        this.zzg = z;
        this.zzh = zzuh;
        this.zzi = zzwa;
        this.zzj = list;
        this.zzk = zzsi2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = zzby;
        this.zzp = j3;
        this.zzq = j4;
        this.zzr = j5;
        this.zzo = z3;
    }

    public static zzju zzg(zzwa zzwa) {
        return new zzju(zzcn.zza, zzs, C.TIME_UNSET, 0, 1, (zzha) null, false, zzuh.zza, zzwa, zzfvn.zzo(), zzs, false, 0, zzby.zza, 0, 0, 0, false);
    }

    public static zzsi zzh() {
        return zzs;
    }

    public final zzju zza(zzsi zzsi) {
        zzcn zzcn = this.zza;
        return new zzju(zzcn, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzsi, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzo);
    }

    public final zzju zzb(zzsi zzsi, long j, long j2, long j3, long j4, zzuh zzuh, zzwa zzwa, List list) {
        long j5 = j;
        zzuh zzuh2 = zzuh;
        zzwa zzwa2 = zzwa;
        List list2 = list;
        zzcn zzcn = this.zza;
        return new zzju(zzcn, zzsi, j2, j3, this.zze, this.zzf, this.zzg, zzuh2, zzwa2, list2, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, j4, j5, this.zzo);
    }

    public final zzju zzc(boolean z, int i) {
        zzcn zzcn = this.zza;
        return new zzju(zzcn, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, this.zzn, this.zzp, this.zzq, this.zzr, this.zzo);
    }

    public final zzju zzd(zzha zzha) {
        zzcn zzcn = this.zza;
        return new zzju(zzcn, this.zzb, this.zzc, this.zzd, this.zze, zzha, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzo);
    }

    public final zzju zze(int i) {
        zzcn zzcn = this.zza;
        return new zzju(zzcn, this.zzb, this.zzc, this.zzd, i, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzo);
    }

    public final zzju zzf(zzcn zzcn) {
        return new zzju(zzcn, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzo);
    }
}
