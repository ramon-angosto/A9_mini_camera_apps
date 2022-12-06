package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbgh extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbgh zzb;
    private int zze;
    private String zzf = "";
    private int zzg;
    private zzgrj zzh = zzaH();
    private zzbhn zzi;

    static {
        zzbgh zzbgh = new zzbgh();
        zzb = zzbgh;
        zzgre.zzaQ(zzbgh.class, zzbgh);
    }

    private zzbgh() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzbgc.zza, "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzbgh();
        } else {
            if (i2 == 4) {
                return new zzbgg((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
