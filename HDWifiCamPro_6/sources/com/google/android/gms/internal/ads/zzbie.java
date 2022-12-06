package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbie extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbie zzb;
    private int zze;
    private int zzf = 1000;
    private zzbhw zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;

    static {
        zzbie zzbie = new zzbie();
        zzb = zzbie;
        zzgre.zzaQ(zzbie.class, zzbie);
    }

    private zzbie() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zze", "zzf", zzbgc.zza, "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzbie();
        } else {
            if (i2 == 4) {
                return new zzbid((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
