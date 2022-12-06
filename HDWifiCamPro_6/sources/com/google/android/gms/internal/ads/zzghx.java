package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghx extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzghx zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzgpw zzf = zzgpw.zzb;
    private zzgid zzg;

    static {
        zzghx zzghx = new zzghx();
        zzb = zzghx;
        zzgre.zzaQ(zzghx.class, zzghx);
    }

    private zzghx() {
    }

    public static zzghw zzc() {
        return (zzghw) zzb.zzaz();
    }

    public static zzghx zze(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzghx) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzj(zzghx zzghx, zzgid zzgid) {
        zzgid.getClass();
        zzghx.zzg = zzgid;
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
            return zzaP(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzghx();
        } else {
            if (i2 == 4) {
                return new zzghw((zzghv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgid zzf() {
        zzgid zzgid = this.zzg;
        return zzgid == null ? zzgid.zze() : zzgid;
    }

    public final zzgpw zzg() {
        return this.zzf;
    }
}
