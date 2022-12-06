package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgjb extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgjb zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgjb zzgjb = new zzgjb();
        zzb = zzgjb;
        zzgre.zzaQ(zzgjb.class, zzgjb);
    }

    private zzgjb() {
    }

    public static zzgja zzc() {
        return (zzgja) zzb.zzaz();
    }

    public static zzgjb zze() {
        return zzb;
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
            return zzaP(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzgjb();
        } else {
            if (i2 == 4) {
                return new zzgja((zzgiz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
