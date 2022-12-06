package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbfd extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbfd zzb;
    private int zze;
    private int zzf;
    private zzbfh zzg;
    private zzbfj zzh;

    static {
        zzbfd zzbfd = new zzbfd();
        zzb = zzbfd;
        zzgre.zzaQ(zzbfd.class, zzbfd);
    }

    private zzbfd() {
    }

    public static zzbfc zza() {
        return (zzbfc) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzbfd zzbfd, zzbfh zzbfh) {
        zzbfh.getClass();
        zzbfd.zzg = zzbfh;
        zzbfd.zze |= 2;
    }

    static /* synthetic */ void zze(zzbfd zzbfd, zzbfj zzbfj) {
        zzbfj.getClass();
        zzbfd.zzh = zzbfj;
        zzbfd.zze |= 4;
    }

    static /* synthetic */ void zzf(zzbfd zzbfd, int i) {
        zzbfd.zzf = 1;
        zzbfd.zze = 1 | zzbfd.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", zzbff.zza, "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbfd();
        } else {
            if (i2 == 4) {
                return new zzbfc((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
