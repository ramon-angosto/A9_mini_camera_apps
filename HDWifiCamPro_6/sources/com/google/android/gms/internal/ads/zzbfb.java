package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbfb extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbfb zzb;
    private int zze;
    private int zzf;
    private int zzg = 1000;
    private zzbfr zzh;
    private zzbft zzi;
    private zzgrn zzj = zzaK();
    private zzbfv zzk;
    private zzbhf zzl;
    private zzbgv zzm;
    private zzbgj zzn;
    private zzbgl zzo;
    private zzgrn zzp = zzaK();

    static {
        zzbfb zzbfb = new zzbfb();
        zzb = zzbfb;
        zzgre.zzaQ(zzbfb.class, zzbfb);
    }

    private zzbfb() {
    }

    public static zzbfb zzc() {
        return zzb;
    }

    static /* synthetic */ void zze(zzbfb zzbfb, zzbez zzbez) {
        zzbfb.zzf = zzbez.zza();
        zzbfb.zze |= 1;
    }

    static /* synthetic */ void zzf(zzbfb zzbfb, zzbft zzbft) {
        zzbft.getClass();
        zzbfb.zzi = zzbft;
        zzbfb.zze |= 8;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007ဌ\u0000\bဌ\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zze", "zzf", zzbez.zzc(), "zzg", zzbgc.zza, "zzh", "zzi", "zzj", zzbfp.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzbhr.class});
        } else if (i2 == 3) {
            return new zzbfb();
        } else {
            if (i2 == 4) {
                return new zzbfa((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzbft zzd() {
        zzbft zzbft = this.zzi;
        return zzbft == null ? zzbft.zzc() : zzbft;
    }
}
