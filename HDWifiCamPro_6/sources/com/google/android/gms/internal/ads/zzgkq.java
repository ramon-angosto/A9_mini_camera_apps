package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgkq extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgkq zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgkk zzf;
    /* access modifiers changed from: private */
    public zzgpw zzg = zzgpw.zzb;
    /* access modifiers changed from: private */
    public zzgpw zzh = zzgpw.zzb;

    static {
        zzgkq zzgkq = new zzgkq();
        zzb = zzgkq;
        zzgre.zzaQ(zzgkq.class, zzgkq);
    }

    private zzgkq() {
    }

    public static zzgkp zzd() {
        return (zzgkp) zzb.zzaz();
    }

    public static zzgkq zzf() {
        return zzb;
    }

    public static zzgkq zzg(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgkq) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzk(zzgkq zzgkq, zzgkk zzgkk) {
        zzgkk.getClass();
        zzgkq.zzf = zzgkk;
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
            return zzaP(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzgkq();
        } else {
            if (i2 == 4) {
                return new zzgkp((zzgko) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgkk zzc() {
        zzgkk zzgkk = this.zzf;
        return zzgkk == null ? zzgkk.zze() : zzgkk;
    }

    public final zzgpw zzh() {
        return this.zzg;
    }

    public final zzgpw zzi() {
        return this.zzh;
    }
}
