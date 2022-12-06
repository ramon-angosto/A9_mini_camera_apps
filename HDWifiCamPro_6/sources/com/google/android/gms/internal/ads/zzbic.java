package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbic extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbic zzb;
    private int zze;
    private int zzf = 1000;
    private zzbhw zzg;
    private zzbhn zzh;

    static {
        zzbic zzbic = new zzbic();
        zzb = zzbic;
        zzgre.zzaQ(zzbic.class, zzbic);
    }

    private zzbic() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", zzbgc.zza, "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbic();
        } else {
            if (i2 == 4) {
                return new zzbib((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
