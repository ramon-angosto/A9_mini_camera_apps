package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbfj extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbfj zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        zzbfj zzbfj = new zzbfj();
        zzb = zzbfj;
        zzgre.zzaQ(zzbfj.class, zzbfj);
    }

    private zzbfj() {
    }

    public static zzbfi zza() {
        return (zzbfi) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzbfj zzbfj, boolean z) {
        zzbfj.zze |= 1;
        zzbfj.zzf = z;
    }

    static /* synthetic */ void zze(zzbfj zzbfj, boolean z) {
        zzbfj.zze |= 2;
        zzbfj.zzg = z;
    }

    static /* synthetic */ void zzf(zzbfj zzbfj, int i) {
        zzbfj.zze |= 4;
        zzbfj.zzh = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbfj();
        } else {
            if (i2 == 4) {
                return new zzbfi((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
