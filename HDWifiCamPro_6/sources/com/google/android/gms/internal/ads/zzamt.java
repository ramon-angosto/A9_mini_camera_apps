package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzamt extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzamt zzb;
    private int zze;
    private int zzf;
    private long zzg = -1;

    static {
        zzamt zzamt = new zzamt();
        zzb = zzamt;
        zzgre.zzaQ(zzamt.class, zzamt);
    }

    private zzamt() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", zzamp.zza, "zzg"});
        } else if (i2 == 3) {
            return new zzamt();
        } else {
            if (i2 == 4) {
                return new zzams((zzamj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
