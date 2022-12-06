package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbhd extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbhd zzb;
    private int zze;
    private zzgrn zzf = zzaK();
    private int zzg;
    private int zzh;
    private long zzi;
    private String zzj = "";
    private String zzk = "";
    private long zzl;
    private int zzm;

    static {
        zzbhd zzbhd = new zzbhd();
        zzb = zzbhd;
        zzgre.zzaQ(zzbhd.class, zzbhd);
    }

    private zzbhd() {
    }

    public static zzbgz zza() {
        return (zzbgz) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzbhd zzbhd, Iterable iterable) {
        zzgrn zzgrn = zzbhd.zzf;
        if (!zzgrn.zzc()) {
            zzbhd.zzf = zzgre.zzaL(zzgrn);
        }
        zzgpf.zzau(iterable, zzbhd.zzf);
    }

    static /* synthetic */ void zze(zzbhd zzbhd, int i) {
        zzbhd.zze |= 1;
        zzbhd.zzg = i;
    }

    static /* synthetic */ void zzf(zzbhd zzbhd, int i) {
        zzbhd.zze |= 2;
        zzbhd.zzh = i;
    }

    static /* synthetic */ void zzg(zzbhd zzbhd, long j) {
        zzbhd.zze |= 4;
        zzbhd.zzi = j;
    }

    static /* synthetic */ void zzh(zzbhd zzbhd, String str) {
        str.getClass();
        zzbhd.zze |= 8;
        zzbhd.zzj = str;
    }

    static /* synthetic */ void zzi(zzbhd zzbhd, String str) {
        str.getClass();
        zzbhd.zze |= 16;
        zzbhd.zzk = str;
    }

    static /* synthetic */ void zzj(zzbhd zzbhd, long j) {
        zzbhd.zze |= 32;
        zzbhd.zzl = j;
    }

    static /* synthetic */ void zzk(zzbhd zzbhd, int i) {
        zzbhd.zze |= 64;
        zzbhd.zzm = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zze", "zzf", zzbgy.class, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        } else if (i2 == 3) {
            return new zzbhd();
        } else {
            if (i2 == 4) {
                return new zzbgz((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
