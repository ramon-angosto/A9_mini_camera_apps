package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmy extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgmy zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgnb zzf;

    static {
        zzgmy zzgmy = new zzgmy();
        zzb = zzgmy;
        zzgre.zzaQ(zzgmy.class, zzgmy);
    }

    private zzgmy() {
    }

    public static zzgmx zzc() {
        return (zzgmx) zzb.zzaz();
    }

    public static zzgmy zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgmy) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzh(zzgmy zzgmy, zzgnb zzgnb) {
        zzgnb.getClass();
        zzgmy.zzf = zzgnb;
    }

    public final int zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgmy();
        } else {
            if (i2 == 4) {
                return new zzgmx((zzgmw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgnb zzf() {
        zzgnb zzgnb = this.zzf;
        return zzgnb == null ? zzgnb.zzd() : zzgnb;
    }
}
