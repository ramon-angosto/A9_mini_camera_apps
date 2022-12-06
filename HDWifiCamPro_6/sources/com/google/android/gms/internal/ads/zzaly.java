package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaly extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzaly zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzaly zzaly = new zzaly();
        zzb = zzaly;
        zzgre.zzaQ(zzaly.class, zzaly);
    }

    private zzaly() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzaly();
        } else {
            if (i2 == 4) {
                return new zzalx((zzalv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
