package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgll extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgll zzb;
    private zzglo zze;

    static {
        zzgll zzgll = new zzgll();
        zzb = zzgll;
        zzgre.zzaQ(zzgll.class, zzgll);
    }

    private zzgll() {
    }

    public static zzglk zza() {
        return (zzglk) zzb.zzaz();
    }

    public static zzgll zzd(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgll) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzf(zzgll zzgll, zzglo zzglo) {
        zzglo.getClass();
        zzgll.zze = zzglo;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzgll();
        } else {
            if (i2 == 4) {
                return new zzglk((zzglj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzglo zze() {
        zzglo zzglo = this.zze;
        return zzglo == null ? zzglo.zzd() : zzglo;
    }
}
