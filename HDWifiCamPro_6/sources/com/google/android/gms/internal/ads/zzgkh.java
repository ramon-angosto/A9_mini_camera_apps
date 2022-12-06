package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgkh extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgkh zzb;
    private zzgkk zze;

    static {
        zzgkh zzgkh = new zzgkh();
        zzb = zzgkh;
        zzgre.zzaQ(zzgkh.class, zzgkh);
    }

    private zzgkh() {
    }

    public static zzgkg zza() {
        return (zzgkg) zzb.zzaz();
    }

    public static zzgkh zzd(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgkh) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzf(zzgkh zzgkh, zzgkk zzgkk) {
        zzgkk.getClass();
        zzgkh.zze = zzgkk;
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
            return new zzgkh();
        } else {
            if (i2 == 4) {
                return new zzgkg((zzgkf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgkk zze() {
        zzgkk zzgkk = this.zze;
        return zzgkk == null ? zzgkk.zze() : zzgkk;
    }
}
