package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgim extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgim zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgis zzf;
    /* access modifiers changed from: private */
    public zzgpw zzg = zzgpw.zzb;

    static {
        zzgim zzgim = new zzgim();
        zzb = zzgim;
        zzgre.zzaQ(zzgim.class, zzgim);
    }

    private zzgim() {
    }

    public static zzgil zzc() {
        return (zzgil) zzb.zzaz();
    }

    public static zzgim zze() {
        return zzb;
    }

    public static zzgim zzf(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgim) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzj(zzgim zzgim, zzgis zzgis) {
        zzgis.getClass();
        zzgim.zzf = zzgis;
    }

    public final int zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgim();
        } else {
            if (i2 == 4) {
                return new zzgil((zzgik) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgis zzg() {
        zzgis zzgis = this.zzf;
        return zzgis == null ? zzgis.zze() : zzgis;
    }

    public final zzgpw zzh() {
        return this.zzg;
    }
}
