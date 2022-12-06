package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbhp extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbhp zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzbhp zzbhp = new zzbhp();
        zzb = zzbhp;
        zzgre.zzaQ(zzbhp.class, zzbhp);
    }

    private zzbhp() {
    }

    public static zzbho zza() {
        return (zzbho) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzbhp zzbhp, int i) {
        zzbhp.zze |= 1;
        zzbhp.zzf = i;
    }

    static /* synthetic */ void zze(zzbhp zzbhp, int i) {
        zzbhp.zze |= 2;
        zzbhp.zzg = i;
    }

    static /* synthetic */ void zzf(zzbhp zzbhp, int i) {
        zzbhp.zze |= 4;
        zzbhp.zzh = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbhp();
        } else {
            if (i2 == 4) {
                return new zzbho((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
