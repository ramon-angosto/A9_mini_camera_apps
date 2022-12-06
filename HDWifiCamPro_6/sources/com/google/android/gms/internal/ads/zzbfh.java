package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbfh extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbfh zzb;
    private int zze;
    private boolean zzf;
    private int zzg;

    static {
        zzbfh zzbfh = new zzbfh();
        zzb = zzbfh;
        zzgre.zzaQ(zzbfh.class, zzbfh);
    }

    private zzbfh() {
    }

    public static zzbfg zza() {
        return (zzbfg) zzb.zzaz();
    }

    public static zzbfh zzd() {
        return zzb;
    }

    static /* synthetic */ void zze(zzbfh zzbfh, boolean z) {
        zzbfh.zze |= 1;
        zzbfh.zzf = z;
    }

    static /* synthetic */ void zzf(zzbfh zzbfh, int i) {
        zzbfh.zze |= 2;
        zzbfh.zzg = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzbfh();
        } else {
            if (i2 == 4) {
                return new zzbfg((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
