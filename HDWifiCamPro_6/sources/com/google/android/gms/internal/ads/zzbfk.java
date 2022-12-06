package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbfk extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbfk zzb;
    private zzgrn zze = zzaK();

    static {
        zzbfk zzbfk = new zzbfk();
        zzb = zzbfk;
        zzgre.zzaQ(zzbfk.class, zzbfk);
    }

    private zzbfk() {
    }

    public static zzbfe zza() {
        return (zzbfe) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzbfk zzbfk, zzbfd zzbfd) {
        zzbfd.getClass();
        zzgrn zzgrn = zzbfk.zze;
        if (!zzgrn.zzc()) {
            zzbfk.zze = zzgre.zzaL(zzgrn);
        }
        zzbfk.zze.add(zzbfd);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzbfd.class});
        } else if (i2 == 3) {
            return new zzbfk();
        } else {
            if (i2 == 4) {
                return new zzbfe((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
