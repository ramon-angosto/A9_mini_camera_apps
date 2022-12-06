package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgwg extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgwg zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzgwg zzgwg = new zzgwg();
        zzb = zzgwg;
        zzgre.zzaQ(zzgwg.class, zzgwg);
    }

    private zzgwg() {
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
            return new zzgwg();
        } else {
            if (i2 == 4) {
                return new zzgwf((zzguq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
