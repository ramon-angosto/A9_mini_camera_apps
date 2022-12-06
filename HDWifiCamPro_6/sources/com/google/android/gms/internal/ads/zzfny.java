package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfny extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzfny zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private zzfnu zzi;

    static {
        zzfny zzfny = new zzfny();
        zzb = zzfny;
        zzgre.zzaQ(zzfny.class, zzfny);
    }

    private zzfny() {
    }

    public static zzfnw zza() {
        return (zzfnw) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzfny zzfny, String str) {
        str.getClass();
        zzfny.zze |= 2;
        zzfny.zzg = str;
    }

    static /* synthetic */ void zze(zzfny zzfny, zzfnu zzfnu) {
        zzfnu.getClass();
        zzfny.zzi = zzfnu;
        zzfny.zze |= 8;
    }

    static /* synthetic */ void zzf(zzfny zzfny, int i) {
        zzfny.zzf = 1;
        zzfny.zze = 1 | zzfny.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", zzfnx.zza, "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzfny();
        } else {
            if (i2 == 4) {
                return new zzfnw((zzfnv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
