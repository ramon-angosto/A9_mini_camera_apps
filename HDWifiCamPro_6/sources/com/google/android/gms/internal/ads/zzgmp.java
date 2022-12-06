package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmp extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgmp zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgrn zzf = zzaK();

    static {
        zzgmp zzgmp = new zzgmp();
        zzb = zzgmp;
        zzgre.zzaQ(zzgmp.class, zzgmp);
    }

    private zzgmp() {
    }

    public static zzgmm zza() {
        return (zzgmm) zzb.zzaz();
    }

    static /* synthetic */ void zze(zzgmp zzgmp, zzgmo zzgmo) {
        zzgmo.getClass();
        zzgrn zzgrn = zzgmp.zzf;
        if (!zzgrn.zzc()) {
            zzgmp.zzf = zzgre.zzaL(zzgrn);
        }
        zzgmp.zzf.add(zzgmo);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzgmo.class});
        } else if (i2 == 3) {
            return new zzgmp();
        } else {
            if (i2 == 4) {
                return new zzgmm((zzgml) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
