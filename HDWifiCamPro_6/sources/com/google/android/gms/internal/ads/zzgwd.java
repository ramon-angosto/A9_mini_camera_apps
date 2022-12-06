package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgwd extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgwd zzb;
    private int zze;
    private String zzf = "";
    private zzgpw zzg = zzgpw.zzb;

    static {
        zzgwd zzgwd = new zzgwd();
        zzb = zzgwd;
        zzgre.zzaQ(zzgwd.class, zzgwd);
    }

    private zzgwd() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgwd();
        } else {
            if (i2 == 4) {
                return new zzgwc((zzguq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
