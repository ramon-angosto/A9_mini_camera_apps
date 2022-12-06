package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzud extends zzcn {
    private static final Object zzc = new Object();
    private static final zzbg zzd;
    private final long zze;
    private final long zzf;
    private final boolean zzg;
    private final zzbg zzh;
    private final zzaw zzi;

    static {
        zzaj zzaj = new zzaj();
        zzaj.zza("SinglePeriodTimeline");
        zzaj.zzb(Uri.EMPTY);
        zzd = zzaj.zzc();
    }

    public zzud(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, zzbg zzbg, zzaw zzaw) {
        this.zze = j4;
        this.zzf = j5;
        this.zzg = z;
        this.zzh = zzbg;
        this.zzi = zzaw;
    }

    public final int zza(Object obj) {
        return zzc.equals(obj) ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzck zzd(int i, zzck zzck, boolean z) {
        zzdd.zza(i, 0, 1);
        zzck.zzk((Object) null, z ? zzc : null, 0, this.zze, 0, zzd.zza, false);
        return zzck;
    }

    public final zzcm zze(int i, zzcm zzcm, long j) {
        zzdd.zza(i, 0, 1);
        zzcm.zza(zzcm.zza, this.zzh, (Object) null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, this.zzg, false, this.zzi, 0, this.zzf, 0, 0, 0);
        return zzcm;
    }

    public final Object zzf(int i) {
        zzdd.zza(i, 0, 1);
        return zzc;
    }
}
