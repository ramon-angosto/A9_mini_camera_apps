package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzcn {
    public static final zzcn zza = new zzci();
    public static final zzn zzb = zzch.zza;

    protected zzcn() {
    }

    public final boolean equals(Object obj) {
        int zzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcn)) {
            return false;
        }
        zzcn zzcn = (zzcn) obj;
        if (zzcn.zzc() == zzc() && zzcn.zzb() == zzb()) {
            zzcm zzcm = new zzcm();
            zzck zzck = new zzck();
            zzcm zzcm2 = new zzcm();
            zzck zzck2 = new zzck();
            for (int i = 0; i < zzc(); i++) {
                if (!zze(i, zzcm, 0).equals(zzcn.zze(i, zzcm2, 0))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < zzb(); i2++) {
                if (!zzd(i2, zzck, true).equals(zzcn.zzd(i2, zzck2, true))) {
                    return false;
                }
            }
            int zzg = zzg(true);
            if (zzg == zzcn.zzg(true) && (zzh = zzh(true)) == zzcn.zzh(true)) {
                while (zzg != zzh) {
                    int zzj = zzj(zzg, 0, true);
                    if (zzj != zzcn.zzj(zzg, 0, true)) {
                        return false;
                    }
                    zzg = zzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        zzcm zzcm = new zzcm();
        zzck zzck = new zzck();
        int zzc = zzc() + 217;
        for (int i = 0; i < zzc(); i++) {
            zzc = (zzc * 31) + zze(i, zzcm, 0).hashCode();
        }
        int zzb2 = (zzc * 31) + zzb();
        for (int i2 = 0; i2 < zzb(); i2++) {
            zzb2 = (zzb2 * 31) + zzd(i2, zzck, true).hashCode();
        }
        int zzg = zzg(true);
        while (zzg != -1) {
            zzb2 = (zzb2 * 31) + zzg;
            zzg = zzj(zzg, 0, true);
        }
        return zzb2;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzck zzd(int i, zzck zzck, boolean z);

    public abstract zzcm zze(int i, zzcm zzcm, long j);

    public abstract Object zzf(int i);

    public int zzg(boolean z) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i, zzck zzck, zzcm zzcm, int i2, boolean z) {
        int i3 = zzd(i, zzck, false).zzd;
        if (zze(i3, zzcm, 0).zzp != i) {
            return i + 1;
        }
        int zzj = zzj(i3, i2, z);
        if (zzj == -1) {
            return -1;
        }
        return zze(zzj, zzcm, 0).zzo;
    }

    public int zzj(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == zzh(z) ? zzg(z) : i + 1;
            }
            throw new IllegalStateException();
        } else if (i == zzh(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int zzk(int i, int i2, boolean z) {
        if (i == zzg(false)) {
            return -1;
        }
        return i - 1;
    }

    public final Pair zzl(zzcm zzcm, zzck zzck, int i, long j) {
        Pair zzm = zzm(zzcm, zzck, i, j, 0);
        if (zzm != null) {
            return zzm;
        }
        throw null;
    }

    public final Pair zzm(zzcm zzcm, zzck zzck, int i, long j, long j2) {
        zzdd.zza(i, 0, zzc());
        zze(i, zzcm, j2);
        if (j == C.TIME_UNSET) {
            long j3 = zzcm.zzm;
            j = 0;
        }
        int i2 = zzcm.zzo;
        zzd(i2, zzck, false);
        while (i2 < zzcm.zzp) {
            long j4 = zzck.zzf;
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 == 0) {
                break;
            }
            int i4 = i2 + 1;
            long j5 = zzd(i4, zzck, false).zzf;
            if (i3 < 0) {
                break;
            }
            i2 = i4;
        }
        zzd(i2, zzck, true);
        long j6 = zzck.zzf;
        long j7 = zzck.zze;
        if (j7 != C.TIME_UNSET) {
            j = Math.min(j, j7 - 1);
        }
        long max = Math.max(0, j);
        Object obj = zzck.zzc;
        if (obj != null) {
            return Pair.create(obj, Long.valueOf(max));
        }
        throw null;
    }

    public zzck zzn(Object obj, zzck zzck) {
        return zzd(zza(obj), zzck, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
