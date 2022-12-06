package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbgl extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbgl zzb;
    private int zze;
    private zzbgh zzf;
    private zzgrn zzg = zzaK();
    private int zzh;
    private zzbhn zzi;

    static {
        zzbgl zzbgl = new zzbgl();
        zzb = zzbgl;
        zzgre.zzaQ(zzbgl.class, zzbgl);
    }

    private zzbgl() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzbhl.class, "zzh", zzbgc.zza, "zzi"});
        } else if (i2 == 3) {
            return new zzbgl();
        } else {
            if (i2 == 4) {
                return new zzbgk((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
