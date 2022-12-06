package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgjk extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgjk zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzgpw zzf = zzgpw.zzb;

    static {
        zzgjk zzgjk = new zzgjk();
        zzb = zzgjk;
        zzgre.zzaQ(zzgjk.class, zzgjk);
    }

    private zzgjk() {
    }

    public static zzgjj zzc() {
        return (zzgjj) zzb.zzaz();
    }

    public static zzgjk zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgjk) zzgre.zzaE(zzb, zzgpw, zzgqq);
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
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgjk();
        } else {
            if (i2 == 4) {
                return new zzgjj((zzgji) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgpw zzf() {
        return this.zzf;
    }
}
