package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgkn extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgkn zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgkq zzf;
    /* access modifiers changed from: private */
    public zzgpw zzg = zzgpw.zzb;

    static {
        zzgkn zzgkn = new zzgkn();
        zzb = zzgkn;
        zzgre.zzaQ(zzgkn.class, zzgkn);
    }

    private zzgkn() {
    }

    public static zzgkm zzc() {
        return (zzgkm) zzb.zzaz();
    }

    public static zzgkn zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgkn) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzi(zzgkn zzgkn, zzgkq zzgkq) {
        zzgkq.getClass();
        zzgkn.zzf = zzgkq;
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
            return new zzgkn();
        } else {
            if (i2 == 4) {
                return new zzgkm((zzgkl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgkq zzf() {
        zzgkq zzgkq = this.zzf;
        return zzgkq == null ? zzgkq.zzf() : zzgkq;
    }

    public final zzgpw zzg() {
        return this.zzg;
    }
}
