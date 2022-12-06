package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvs extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgvs zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private zzgpw zzh = zzgpw.zzb;
    private zzgpw zzi = zzgpw.zzb;

    static {
        zzgvs zzgvs = new zzgvs();
        zzb = zzgvs;
        zzgre.zzaQ(zzgvs.class, zzgvs);
    }

    private zzgvs() {
    }

    public static zzgvq zza() {
        return (zzgvq) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzgvs zzgvs, String str) {
        zzgvs.zze |= 2;
        zzgvs.zzg = "image/png";
    }

    static /* synthetic */ void zze(zzgvs zzgvs, zzgpw zzgpw) {
        zzgpw.getClass();
        zzgvs.zze |= 4;
        zzgvs.zzh = zzgpw;
    }

    static /* synthetic */ void zzf(zzgvs zzgvs, int i) {
        zzgvs.zzf = 1;
        zzgvs.zze = 1 | zzgvs.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zze", "zzf", zzgvr.zza, "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzgvs();
        } else {
            if (i2 == 4) {
                return new zzgvq((zzguq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
