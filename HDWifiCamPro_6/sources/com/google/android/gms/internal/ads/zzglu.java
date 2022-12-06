package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzglu extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzglu zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzglo zzf;
    /* access modifiers changed from: private */
    public zzgpw zzg = zzgpw.zzb;

    static {
        zzglu zzglu = new zzglu();
        zzb = zzglu;
        zzgre.zzaQ(zzglu.class, zzglu);
    }

    private zzglu() {
    }

    public static zzglt zzd() {
        return (zzglt) zzb.zzaz();
    }

    public static zzglu zzf() {
        return zzb;
    }

    public static zzglu zzg(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzglu) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzj(zzglu zzglu, zzglo zzglo) {
        zzglo.getClass();
        zzglu.zzf = zzglo;
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
            return new zzglu();
        } else {
            if (i2 == 4) {
                return new zzglt((zzgls) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzglo zzc() {
        zzglo zzglo = this.zzf;
        return zzglo == null ? zzglo.zzd() : zzglo;
    }

    public final zzgpw zzh() {
        return this.zzg;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }
}
