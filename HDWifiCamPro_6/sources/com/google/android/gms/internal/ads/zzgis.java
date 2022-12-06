package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgis extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgis zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgis zzgis = new zzgis();
        zzb = zzgis;
        zzgre.zzaQ(zzgis.class, zzgis);
    }

    private zzgis() {
    }

    public static zzgir zzc() {
        return (zzgir) zzb.zzaz();
    }

    public static zzgis zze() {
        return zzb;
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
            return zzaP(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzgis();
        } else {
            if (i2 == 4) {
                return new zzgir((zzgiq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
