package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbgj extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbgj zzb;
    private int zze;
    private int zzf;
    private zzgrj zzg = zzaH();

    static {
        zzbgj zzbgj = new zzbgj();
        zzb = zzbgj;
        zzgre.zzaQ(zzbgj.class, zzbgj);
    }

    private zzbgj() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zze", "zzf", zzbgc.zza, "zzg"});
        } else if (i2 == 3) {
            return new zzbgj();
        } else {
            if (i2 == 4) {
                return new zzbgi((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
