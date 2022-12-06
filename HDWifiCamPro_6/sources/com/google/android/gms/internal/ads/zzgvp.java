package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvp extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgvp zzb;
    private int zze;
    private zzgvo zzf;
    private zzgrn zzg = zzaK();
    private zzgpw zzh = zzgpw.zzb;
    private zzgpw zzi;
    private int zzj;
    private zzgpw zzk;
    private byte zzl = 2;

    static {
        zzgvp zzgvp = new zzgvp();
        zzb = zzgvp;
        zzgre.zzaQ(zzgvp.class, zzgvp);
    }

    private zzgvp() {
        zzgpw zzgpw = zzgpw.zzb;
        this.zzi = zzgpw;
        this.zzk = zzgpw;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zze", "zzf", "zzg", zzgvh.class, "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzgvp();
        } else {
            if (i2 == 4) {
                return new zzgvm((zzguq) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzl = b;
            return null;
        }
    }
}
