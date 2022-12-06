package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgip extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgip zzb;
    private zzgis zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgip zzgip = new zzgip();
        zzb = zzgip;
        zzgre.zzaQ(zzgip.class, zzgip);
    }

    private zzgip() {
    }

    public static zzgio zzc() {
        return (zzgio) zzb.zzaz();
    }

    public static zzgip zze() {
        return zzb;
    }

    public static zzgip zzf(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgip) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzh(zzgip zzgip, zzgis zzgis) {
        zzgis.getClass();
        zzgip.zze = zzgis;
    }

    public final int zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgip();
        } else {
            if (i2 == 4) {
                return new zzgio((zzgin) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgis zzg() {
        zzgis zzgis = this.zze;
        return zzgis == null ? zzgis.zze() : zzgis;
    }
}
