package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbhf extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzbhf zzb;
    private int zze;
    private int zzf = 1000;
    private int zzg = 1000;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private zzbhh zzp;

    static {
        zzbhf zzbhf = new zzbhf();
        zzb = zzbhf;
        zzgre.zzaQ(zzbhf.class, zzbhf);
    }

    private zzbhf() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgri zzgri = zzbgc.zza;
            return zzaP(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zze", "zzf", zzgri, "zzg", zzgri, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        } else if (i2 == 3) {
            return new zzbhf();
        } else {
            if (i2 == 4) {
                return new zzbhe((zzbew) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
