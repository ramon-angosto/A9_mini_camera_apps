package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzamd extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzamd zzb;
    private int zze;
    private zzamf zzf;
    private zzami zzg;

    static {
        zzamd zzamd = new zzamd();
        zzb = zzamd;
        zzgre.zzaQ(zzamd.class, zzamd);
    }

    private zzamd() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzamd();
        } else {
            if (i2 == 4) {
                return new zzamc((zzamb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
