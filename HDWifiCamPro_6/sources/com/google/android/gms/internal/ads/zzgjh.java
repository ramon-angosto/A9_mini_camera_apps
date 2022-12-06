package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgjh extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgjh zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgjh zzgjh = new zzgjh();
        zzb = zzgjh;
        zzgre.zzaQ(zzgjh.class, zzgjh);
    }

    private zzgjh() {
    }

    public static zzgjg zzc() {
        return (zzgjg) zzb.zzaz();
    }

    public static zzgjh zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgjh) zzgre.zzaE(zzb, zzgpw, zzgqq);
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
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgjh();
        } else {
            if (i2 == 4) {
                return new zzgjg((zzgjf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
