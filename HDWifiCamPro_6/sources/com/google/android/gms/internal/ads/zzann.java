package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzann extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzann zzb;
    private int zze;
    private zzgrn zzf = zzaK();
    private zzgpw zzg = zzgpw.zzb;
    private int zzh = 1;
    private int zzi = 1;

    static {
        zzann zzann = new zzann();
        zzb = zzann;
        zzgre.zzaQ(zzann.class, zzann);
    }

    private zzann() {
    }

    public static zzanm zza() {
        return (zzanm) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzann zzann, zzgpw zzgpw) {
        zzgrn zzgrn = zzann.zzf;
        if (!zzgrn.zzc()) {
            zzann.zzf = zzgre.zzaL(zzgrn);
        }
        zzann.zzf.add(zzgpw);
    }

    static /* synthetic */ void zze(zzann zzann, zzgpw zzgpw) {
        zzann.zze |= 1;
        zzann.zzg = zzgpw;
    }

    static /* synthetic */ void zzf(zzann zzann, int i) {
        zzann.zzi = i - 1;
        zzann.zze |= 4;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh", zzanh.zza, "zzi", zzanf.zza});
        } else if (i2 == 3) {
            return new zzann();
        } else {
            if (i2 == 4) {
                return new zzanm((zzamj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
