package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzglr extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzglr zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzglu zzf;
    /* access modifiers changed from: private */
    public zzgpw zzg = zzgpw.zzb;

    static {
        zzglr zzglr = new zzglr();
        zzb = zzglr;
        zzgre.zzaQ(zzglr.class, zzglr);
    }

    private zzglr() {
    }

    public static zzglq zzc() {
        return (zzglq) zzb.zzaz();
    }

    public static zzglr zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzglr) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzi(zzglr zzglr, zzglu zzglu) {
        zzglu.getClass();
        zzglr.zzf = zzglu;
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
            return new zzglr();
        } else {
            if (i2 == 4) {
                return new zzglq((zzglp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzglu zzf() {
        zzglu zzglu = this.zzf;
        return zzglu == null ? zzglu.zzf() : zzglu;
    }

    public final zzgpw zzg() {
        return this.zzg;
    }

    public final boolean zzk() {
        return this.zzf != null;
    }
}
