package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgiy extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgiy zzb;
    private zzgjb zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgiy zzgiy = new zzgiy();
        zzb = zzgiy;
        zzgre.zzaQ(zzgiy.class, zzgiy);
    }

    private zzgiy() {
    }

    public static zzgix zzc() {
        return (zzgix) zzb.zzaz();
    }

    public static zzgiy zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgiy) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzg(zzgiy zzgiy, zzgjb zzgjb) {
        zzgjb.getClass();
        zzgiy.zze = zzgjb;
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
            return new zzgiy();
        } else {
            if (i2 == 4) {
                return new zzgix((zzgiw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjb zzf() {
        zzgjb zzgjb = this.zze;
        return zzgjb == null ? zzgjb.zze() : zzgjb;
    }
}
