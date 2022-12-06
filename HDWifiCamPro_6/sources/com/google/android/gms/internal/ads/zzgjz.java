package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgjz extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgjz zzb;

    static {
        zzgjz zzgjz = new zzgjz();
        zzb = zzgjz;
        zzgre.zzaQ(zzgjz.class, zzgjz);
    }

    private zzgjz() {
    }

    public static zzgjz zzc() {
        return zzb;
    }

    public static zzgjz zzd(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgjz) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0000", (Object[]) null);
        }
        if (i2 == 3) {
            return new zzgjz();
        }
        if (i2 == 4) {
            return new zzgjy((zzgjx) null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
