package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbgt extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbgt zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbgt zzbgt = new zzbgt();
        zzb = zzbgt;
        zzgre.zzaQ(zzbgt.class, zzbgt);
    }

    private zzbgt() {
    }

    public static zzbgm zza() {
        return (zzbgm) zzb.zzaz();
    }

    public static zzbgt zzd() {
        return zzb;
    }

    static /* synthetic */ void zzi(zzbgt zzbgt, int i) {
        zzbgt.zzf = i - 1;
        zzbgt.zze |= 1;
    }

    static /* synthetic */ void zzj(zzbgt zzbgt, int i) {
        zzbgt.zzg = i - 1;
        zzbgt.zze |= 2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", zzbgr.zza, "zzg", zzbgo.zza});
        } else if (i2 == 3) {
            return new zzbgt();
        } else {
            if (i2 == 4) {
                return new zzbgm((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zze() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }

    public final int zzg() {
        int zza = zzbgp.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzh() {
        int zza = zzbgs.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
