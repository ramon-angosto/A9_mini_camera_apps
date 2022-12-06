package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzane extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzane zzb;
    private int zze;
    private zzgpw zzf = zzgpw.zzb;
    private zzgpw zzg;
    private zzgpw zzh;
    private zzgpw zzi;

    static {
        zzane zzane = new zzane();
        zzb = zzane;
        zzgre.zzaQ(zzane.class, zzane);
    }

    private zzane() {
        zzgpw zzgpw = zzgpw.zzb;
        this.zzg = zzgpw;
        this.zzh = zzgpw;
        this.zzi = zzgpw;
    }

    public static zzand zza() {
        return (zzand) zzb.zzaz();
    }

    public static zzane zzd(byte[] bArr, zzgqq zzgqq) throws zzgrq {
        return (zzane) zzgre.zzaG(zzb, bArr, zzgqq);
    }

    static /* synthetic */ void zzi(zzane zzane, zzgpw zzgpw) {
        zzane.zze |= 1;
        zzane.zzf = zzgpw;
    }

    static /* synthetic */ void zzj(zzane zzane, zzgpw zzgpw) {
        zzane.zze |= 2;
        zzane.zzg = zzgpw;
    }

    static /* synthetic */ void zzk(zzane zzane, zzgpw zzgpw) {
        zzane.zze |= 4;
        zzane.zzh = zzgpw;
    }

    static /* synthetic */ void zzl(zzane zzane, zzgpw zzgpw) {
        zzane.zze |= 8;
        zzane.zzi = zzgpw;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzane();
        } else {
            if (i2 == 4) {
                return new zzand((zzamj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgpw zze() {
        return this.zzf;
    }

    public final zzgpw zzf() {
        return this.zzg;
    }

    public final zzgpw zzg() {
        return this.zzi;
    }

    public final zzgpw zzh() {
        return this.zzh;
    }
}
