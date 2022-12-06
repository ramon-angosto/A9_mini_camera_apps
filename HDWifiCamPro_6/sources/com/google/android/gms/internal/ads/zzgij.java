package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgij extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgij zzb;
    private zzgip zze;
    private zzgld zzf;

    static {
        zzgij zzgij = new zzgij();
        zzb = zzgij;
        zzgre.zzaQ(zzgij.class, zzgij);
    }

    private zzgij() {
    }

    public static zzgii zza() {
        return (zzgii) zzb.zzaz();
    }

    public static zzgij zzd(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgij) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzg(zzgij zzgij, zzgip zzgip) {
        zzgip.getClass();
        zzgij.zze = zzgip;
    }

    static /* synthetic */ void zzh(zzgij zzgij, zzgld zzgld) {
        zzgld.getClass();
        zzgij.zzf = zzgld;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgij();
        } else {
            if (i2 == 4) {
                return new zzgii((zzgih) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgip zze() {
        zzgip zzgip = this.zze;
        return zzgip == null ? zzgip.zze() : zzgip;
    }

    public final zzgld zzf() {
        zzgld zzgld = this.zzf;
        return zzgld == null ? zzgld.zze() : zzgld;
    }
}
