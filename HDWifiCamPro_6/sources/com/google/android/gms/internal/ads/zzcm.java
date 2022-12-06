package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcm {
    public static final Object zza = new Object();
    public static final zzn zzb = zzcl.zza;
    private static final Object zzq = new Object();
    private static final zzbg zzr;
    public Object zzc = zza;
    public zzbg zzd = zzr;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;
    @Deprecated
    public boolean zzj;
    public zzaw zzk;
    public boolean zzl;
    public long zzm;
    public long zzn;
    public int zzo;
    public int zzp;

    static {
        zzaj zzaj = new zzaj();
        zzaj.zza("androidx.media3.common.Timeline");
        zzaj.zzb(Uri.EMPTY);
        zzr = zzaj.zzc();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass().equals(obj.getClass())) {
            zzcm zzcm = (zzcm) obj;
            return zzen.zzT(this.zzc, zzcm.zzc) && zzen.zzT(this.zzd, zzcm.zzd) && zzen.zzT((Object) null, (Object) null) && zzen.zzT(this.zzk, zzcm.zzk) && this.zze == zzcm.zze && this.zzf == zzcm.zzf && this.zzg == zzcm.zzg && this.zzh == zzcm.zzh && this.zzi == zzcm.zzi && this.zzl == zzcm.zzl && this.zzn == zzcm.zzn && this.zzo == zzcm.zzo && this.zzp == zzcm.zzp;
        }
    }

    public final int hashCode() {
        int i;
        int hashCode = (((this.zzc.hashCode() + 217) * 31) + this.zzd.hashCode()) * 961;
        zzaw zzaw = this.zzk;
        if (zzaw == null) {
            i = 0;
        } else {
            i = zzaw.hashCode();
        }
        long j = this.zze;
        long j2 = this.zzf;
        long j3 = this.zzg;
        boolean z = this.zzh;
        boolean z2 = this.zzi;
        boolean z3 = this.zzl;
        long j4 = this.zzn;
        return (((((((((((((((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 961) + ((int) ((j4 >>> 32) ^ j4))) * 31) + this.zzo) * 31) + this.zzp) * 31;
    }

    public final zzcm zza(Object obj, zzbg zzbg, Object obj2, long j, long j2, long j3, boolean z, boolean z2, zzaw zzaw, long j4, long j5, int i, int i2, long j6) {
        zzaw zzaw2 = zzaw;
        this.zzc = obj;
        this.zzd = zzbg != null ? zzbg : zzr;
        this.zze = C.TIME_UNSET;
        this.zzf = C.TIME_UNSET;
        this.zzg = C.TIME_UNSET;
        this.zzh = z;
        this.zzi = z2;
        this.zzj = zzaw2 != null;
        this.zzk = zzaw2;
        this.zzm = 0;
        this.zzn = j5;
        this.zzo = 0;
        this.zzp = 0;
        this.zzl = false;
        return this;
    }

    public final boolean zzb() {
        zzdd.zzf(this.zzj == (this.zzk != null));
        return this.zzk != null;
    }
}
