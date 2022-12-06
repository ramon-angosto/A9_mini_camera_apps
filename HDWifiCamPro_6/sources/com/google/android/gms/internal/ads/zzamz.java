package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzamz extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzamz zzb;
    private int zze;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private long zzl = -1;
    private long zzm = -1;

    static {
        zzamz zzamz = new zzamz();
        zzb = zzamz;
        zzgre.zzaQ(zzamz.class, zzamz);
    }

    private zzamz() {
    }

    public static zzamy zza() {
        return (zzamy) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzamz zzamz, long j) {
        zzamz.zze |= 1;
        zzamz.zzf = j;
    }

    static /* synthetic */ void zze(zzamz zzamz, long j) {
        zzamz.zze |= 4;
        zzamz.zzh = j;
    }

    static /* synthetic */ void zzf(zzamz zzamz, long j) {
        zzamz.zze |= 8;
        zzamz.zzi = j;
    }

    static /* synthetic */ void zzg(zzamz zzamz, long j) {
        zzamz.zze |= 16;
        zzamz.zzj = j;
    }

    static /* synthetic */ void zzh(zzamz zzamz, long j) {
        zzamz.zze |= 32;
        zzamz.zzk = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        } else if (i2 == 3) {
            return new zzamz();
        } else {
            if (i2 == 4) {
                return new zzamy((zzamj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
