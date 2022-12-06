package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgla extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgla zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzglg zzf;
    /* access modifiers changed from: private */
    public zzgpw zzg = zzgpw.zzb;

    static {
        zzgla zzgla = new zzgla();
        zzb = zzgla;
        zzgre.zzaQ(zzgla.class, zzgla);
    }

    private zzgla() {
    }

    public static zzgkz zzc() {
        return (zzgkz) zzb.zzaz();
    }

    public static zzgla zze() {
        return zzb;
    }

    public static zzgla zzf(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgla) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzj(zzgla zzgla, zzglg zzglg) {
        zzglg.getClass();
        zzgla.zzf = zzglg;
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
            return zzaP(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgla();
        } else {
            if (i2 == 4) {
                return new zzgkz((zzgky) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzglg zzg() {
        zzglg zzglg = this.zzf;
        return zzglg == null ? zzglg.zze() : zzglg;
    }

    public final zzgpw zzh() {
        return this.zzg;
    }
}
