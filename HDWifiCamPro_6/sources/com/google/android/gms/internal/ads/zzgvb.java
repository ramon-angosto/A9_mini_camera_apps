package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvb extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgvb zzb;
    private int zze;
    private String zzf = "";

    static {
        zzgvb zzgvb = new zzgvb();
        zzb = zzgvb;
        zzgre.zzaQ(zzgvb.class, zzgvb);
    }

    private zzgvb() {
    }

    public static zzgva zza() {
        return (zzgva) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzgvb zzgvb, String str) {
        zzgvb.zze |= 1;
        zzgvb.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgvb();
        } else {
            if (i2 == 4) {
                return new zzgva((zzguq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
