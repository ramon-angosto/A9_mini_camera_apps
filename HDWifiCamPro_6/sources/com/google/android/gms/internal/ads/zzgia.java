package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgia extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgia zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgid zzf;

    static {
        zzgia zzgia = new zzgia();
        zzb = zzgia;
        zzgre.zzaQ(zzgia.class, zzgia);
    }

    private zzgia() {
    }

    public static zzghz zzc() {
        return (zzghz) zzb.zzaz();
    }

    public static zzgia zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzgia) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzh(zzgia zzgia, zzgid zzgid) {
        zzgid.getClass();
        zzgia.zzf = zzgid;
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
            return zzaP(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgia();
        } else {
            if (i2 == 4) {
                return new zzghz((zzghy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgid zzf() {
        zzgid zzgid = this.zzf;
        return zzgid == null ? zzgid.zze() : zzgid;
    }
}
