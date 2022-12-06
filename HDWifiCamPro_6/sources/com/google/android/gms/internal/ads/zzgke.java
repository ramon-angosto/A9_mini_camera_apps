package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgke extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgke zzb;
    private zzgmc zze;

    static {
        zzgke zzgke = new zzgke();
        zzb = zzgke;
        zzgre.zzaQ(zzgke.class, zzgke);
    }

    private zzgke() {
    }

    public static zzgkd zza() {
        return (zzgkd) zzb.zzaz();
    }

    public static zzgke zzd() {
        return zzb;
    }

    static /* synthetic */ void zzf(zzgke zzgke, zzgmc zzgmc) {
        zzgmc.getClass();
        zzgke.zze = zzgmc;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzgke();
        } else {
            if (i2 == 4) {
                return new zzgkd((zzgkc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgmc zze() {
        zzgmc zzgmc = this.zze;
        return zzgmc == null ? zzgmc.zzd() : zzgmc;
    }
}
