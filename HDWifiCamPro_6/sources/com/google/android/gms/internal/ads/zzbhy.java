package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbhy extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbhy zzb;
    private int zze;
    private zzbhp zzf;
    private int zzg = 1000;
    private zzbhw zzh;
    private zzbhn zzi;

    static {
        zzbhy zzbhy = new zzbhy();
        zzb = zzbhy;
        zzgre.zzaQ(zzbhy.class, zzbhy);
    }

    private zzbhy() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", zzbgc.zza, "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzbhy();
        } else {
            if (i2 == 4) {
                return new zzbhx((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
