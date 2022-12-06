package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgnb extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgnb zzb;
    private String zze = "";
    private zzgmc zzf;

    static {
        zzgnb zzgnb = new zzgnb();
        zzb = zzgnb;
        zzgre.zzaQ(zzgnb.class, zzgnb);
    }

    private zzgnb() {
    }

    public static zzgnb zzd() {
        return zzb;
    }

    public static zzgnb zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgnb) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    public final zzgmc zza() {
        zzgmc zzgmc = this.zzf;
        return zzgmc == null ? zzgmc.zzd() : zzgmc;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgnb();
        } else {
            if (i2 == 4) {
                return new zzgna((zzgmz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zzf != null;
    }
}
