package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgkk extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgkk zzb;
    private zzgkt zze;
    private zzgke zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzgkk zzgkk = new zzgkk();
        zzb = zzgkk;
        zzgre.zzaQ(zzgkk.class, zzgkk);
    }

    private zzgkk() {
    }

    public static zzgkj zzc() {
        return (zzgkj) zzb.zzaz();
    }

    public static zzgkk zze() {
        return zzb;
    }

    static /* synthetic */ void zzg(zzgkk zzgkk, zzgkt zzgkt) {
        zzgkt.getClass();
        zzgkk.zze = zzgkt;
    }

    static /* synthetic */ void zzh(zzgkk zzgkk, zzgke zzgke) {
        zzgke.getClass();
        zzgkk.zzf = zzgke;
    }

    public final zzgke zza() {
        zzgke zzgke = this.zzf;
        return zzgke == null ? zzgke.zzd() : zzgke;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgkk();
        } else {
            if (i2 == 4) {
                return new zzgkj((zzgki) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgkt zzf() {
        zzgkt zzgkt = this.zze;
        return zzgkt == null ? zzgkt.zzd() : zzgkt;
    }

    public final int zzi() {
        int i = this.zzg;
        int i2 = 3;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            i2 = i != 2 ? i != 3 ? 0 : 5 : 4;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
