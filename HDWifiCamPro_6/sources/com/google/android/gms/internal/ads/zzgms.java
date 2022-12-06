package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgms extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgms zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgmv zzf;

    static {
        zzgms zzgms = new zzgms();
        zzb = zzgms;
        zzgre.zzaQ(zzgms.class, zzgms);
    }

    private zzgms() {
    }

    public static zzgmr zzc() {
        return (zzgmr) zzb.zzaz();
    }

    public static zzgms zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgms) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzh(zzgms zzgms, zzgmv zzgmv) {
        zzgmv.getClass();
        zzgms.zzf = zzgmv;
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
            return new zzgms();
        } else {
            if (i2 == 4) {
                return new zzgmr((zzgmq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgmv zzf() {
        zzgmv zzgmv = this.zzf;
        return zzgmv == null ? zzgmv.zzc() : zzgmv;
    }
}
