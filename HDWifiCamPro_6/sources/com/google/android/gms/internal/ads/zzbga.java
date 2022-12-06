package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbga extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbga zzb;
    private int zze;
    private int zzf;
    private zzbhp zzg;
    private String zzh = "";
    private String zzi = "";

    static {
        zzbga zzbga = new zzbga();
        zzb = zzbga;
        zzgre.zzaQ(zzbga.class, zzbga);
    }

    private zzbga() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005ဌ\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zze", "zzf", zzbfz.zza, "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzbga();
        } else {
            if (i2 == 4) {
                return new zzbfy((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
