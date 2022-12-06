package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzanj extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzanj zzb;
    private int zze;
    private long zzf;
    private String zzg = "";
    private zzgpw zzh = zzgpw.zzb;

    static {
        zzanj zzanj = new zzanj();
        zzb = zzanj;
        zzgre.zzaQ(zzanj.class, zzanj);
    }

    private zzanj() {
    }

    public static zzanj zzd() {
        return zzb;
    }

    public final long zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzanj();
        } else {
            if (i2 == 4) {
                return new zzani((zzamj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zze() {
        return (this.zze & 1) != 0;
    }
}
