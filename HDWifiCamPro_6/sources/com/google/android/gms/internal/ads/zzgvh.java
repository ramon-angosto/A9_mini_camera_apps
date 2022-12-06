package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvh extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgvh zzb;
    private int zze;
    private zzgpw zzf = zzgpw.zzb;
    private zzgpw zzg = zzgpw.zzb;
    private byte zzh = 2;

    static {
        zzgvh zzgvh = new zzgvh();
        zzb = zzgvh;
        zzgre.zzaQ(zzgvh.class, zzgvh);
    }

    private zzgvh() {
    }

    public static zzgvg zza() {
        return (zzgvg) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzgvh zzgvh, zzgpw zzgpw) {
        zzgvh.zze |= 1;
        zzgvh.zzf = zzgpw;
    }

    static /* synthetic */ void zze(zzgvh zzgvh, zzgpw zzgpw) {
        zzgvh.zze |= 2;
        zzgvh.zzg = zzgpw;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgvh();
        } else {
            if (i2 == 4) {
                return new zzgvg((zzguq) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzh = b;
            return null;
        }
    }
}
