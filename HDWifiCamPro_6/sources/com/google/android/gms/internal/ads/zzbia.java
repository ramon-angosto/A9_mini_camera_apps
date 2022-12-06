package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbia extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbia zzb;
    private int zze;
    private int zzf = 1000;
    private zzbhw zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzbia zzbia = new zzbia();
        zzb = zzbia;
        zzgre.zzaQ(zzbia.class, zzbia);
    }

    private zzbia() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zze", "zzf", zzbgc.zza, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzbia();
        } else {
            if (i2 == 4) {
                return new zzbhz((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
