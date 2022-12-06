package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzarv extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzarv zzb;
    private int zze;
    private zzary zzf;
    private zzgpw zzg = zzgpw.zzb;
    private zzgpw zzh = zzgpw.zzb;

    static {
        zzarv zzarv = new zzarv();
        zzb = zzarv;
        zzgre.zzaQ(zzarv.class, zzarv);
    }

    private zzarv() {
    }

    public static zzarv zzc(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzarv) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzarv();
        } else {
            if (i2 == 4) {
                return new zzaru((zzart) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzary zzd() {
        zzary zzary = this.zzf;
        return zzary == null ? zzary.zzg() : zzary;
    }

    public final zzgpw zze() {
        return this.zzh;
    }

    public final zzgpw zzf() {
        return this.zzg;
    }
}
