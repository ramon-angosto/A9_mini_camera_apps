package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgiv extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgiv zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgjb zzf;
    /* access modifiers changed from: private */
    public zzgpw zzg = zzgpw.zzb;

    static {
        zzgiv zzgiv = new zzgiv();
        zzb = zzgiv;
        zzgre.zzaQ(zzgiv.class, zzgiv);
    }

    private zzgiv() {
    }

    public static zzgiu zzc() {
        return (zzgiu) zzb.zzaz();
    }

    public static zzgiv zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgiv) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzi(zzgiv zzgiv, zzgjb zzgjb) {
        zzgjb.getClass();
        zzgiv.zzf = zzgjb;
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
            return new zzgiv();
        } else {
            if (i2 == 4) {
                return new zzgiu((zzgit) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjb zzf() {
        zzgjb zzgjb = this.zzf;
        return zzgjb == null ? zzgjb.zze() : zzgjb;
    }

    public final zzgpw zzg() {
        return this.zzg;
    }
}
