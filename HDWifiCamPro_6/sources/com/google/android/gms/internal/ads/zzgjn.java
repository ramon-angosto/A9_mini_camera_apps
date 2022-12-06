package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgjn extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgjn zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgjn zzgjn = new zzgjn();
        zzb = zzgjn;
        zzgre.zzaQ(zzgjn.class, zzgjn);
    }

    private zzgjn() {
    }

    public static zzgjm zzc() {
        return (zzgjm) zzb.zzaz();
    }

    public static zzgjn zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgjn) zzgre.zzaE(zzb, zzgpw, zzgqq);
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
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
        } else if (i2 == 3) {
            return new zzgjn();
        } else {
            if (i2 == 4) {
                return new zzgjm((zzgjl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
