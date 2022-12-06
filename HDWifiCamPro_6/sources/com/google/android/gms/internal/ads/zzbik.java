package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbik extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbik zzb;
    private int zze;
    private boolean zzf;
    private int zzg;

    static {
        zzbik zzbik = new zzbik();
        zzb = zzbik;
        zzgre.zzaQ(zzbik.class, zzbik);
    }

    private zzbik() {
    }

    public static zzbij zza() {
        return (zzbij) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzbik zzbik, boolean z) {
        zzbik.zze |= 1;
        zzbik.zzf = z;
    }

    static /* synthetic */ void zze(zzbik zzbik, int i) {
        zzbik.zze |= 2;
        zzbik.zzg = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzbik();
        } else {
            if (i2 == 4) {
                return new zzbij((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zzf() {
        return this.zzf;
    }
}
