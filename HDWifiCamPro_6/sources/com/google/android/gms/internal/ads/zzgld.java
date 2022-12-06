package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgld extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgld zzb;
    private zzglg zze;
    /* access modifiers changed from: private */
    public int zzf;
    private int zzg;

    static {
        zzgld zzgld = new zzgld();
        zzb = zzgld;
        zzgre.zzaQ(zzgld.class, zzgld);
    }

    private zzgld() {
    }

    public static zzglc zzc() {
        return (zzglc) zzb.zzaz();
    }

    public static zzgld zze() {
        return zzb;
    }

    public static zzgld zzf(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgld) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzh(zzgld zzgld, zzglg zzglg) {
        zzglg.getClass();
        zzgld.zze = zzglg;
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
            return zzaP(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgld();
        } else {
            if (i2 == 4) {
                return new zzglc((zzglb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzglg zzg() {
        zzglg zzglg = this.zze;
        return zzglg == null ? zzglg.zze() : zzglg;
    }
}
