package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgig extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgig zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgim zzf;
    private zzgla zzg;

    static {
        zzgig zzgig = new zzgig();
        zzb = zzgig;
        zzgre.zzaQ(zzgig.class, zzgig);
    }

    private zzgig() {
    }

    public static zzgif zzc() {
        return (zzgif) zzb.zzaz();
    }

    public static zzgig zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgig) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzi(zzgig zzgig, zzgim zzgim) {
        zzgim.getClass();
        zzgig.zzf = zzgim;
    }

    static /* synthetic */ void zzj(zzgig zzgig, zzgla zzgla) {
        zzgla.getClass();
        zzgig.zzg = zzgla;
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
            return zzaP(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgig();
        } else {
            if (i2 == 4) {
                return new zzgif((zzgie) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgim zzf() {
        zzgim zzgim = this.zzf;
        return zzgim == null ? zzgim.zze() : zzgim;
    }

    public final zzgla zzg() {
        zzgla zzgla = this.zzg;
        return zzgla == null ? zzgla.zze() : zzgla;
    }
}
