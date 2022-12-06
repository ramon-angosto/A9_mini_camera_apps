package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvf extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgvf zzb;
    private int zze;
    private String zzf = "";
    private zzgve zzg;
    private long zzh;
    private String zzi = "";

    static {
        zzgvf zzgvf = new zzgvf();
        zzb = zzgvf;
        zzgre.zzaQ(zzgvf.class, zzgvf);
    }

    private zzgvf() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003ဂ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzgvf();
        } else {
            if (i2 == 4) {
                return new zzgvc((zzguq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
