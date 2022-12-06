package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzary extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzary zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private long zzi;
    private long zzj;

    static {
        zzary zzary = new zzary();
        zzb = zzary;
        zzgre.zzaQ(zzary.class, zzary);
    }

    private zzary() {
    }

    public static zzarx zze() {
        return (zzarx) zzb.zzaz();
    }

    public static zzary zzg() {
        return zzb;
    }

    public static zzary zzh(zzgpw zzgpw) throws zzgrq {
        return (zzary) zzgre.zzaC(zzb, zzgpw);
    }

    public static zzary zzi(zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        return (zzary) zzgre.zzaE(zzb, zzgpw, zzgqq);
    }

    static /* synthetic */ void zzl(zzary zzary, String str) {
        str.getClass();
        zzary.zze |= 1;
        zzary.zzf = str;
    }

    static /* synthetic */ void zzm(zzary zzary, long j) {
        zzary.zze |= 16;
        zzary.zzj = j;
    }

    static /* synthetic */ void zzn(zzary zzary, String str) {
        str.getClass();
        zzary.zze |= 2;
        zzary.zzg = str;
    }

    static /* synthetic */ void zzo(zzary zzary, long j) {
        zzary.zze |= 4;
        zzary.zzh = j;
    }

    static /* synthetic */ void zzp(zzary zzary, long j) {
        zzary.zze |= 8;
        zzary.zzi = j;
    }

    public final long zza() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzary();
        } else {
            if (i2 == 4) {
                return new zzarx((zzarw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzj;
    }

    public final String zzj() {
        return this.zzg;
    }

    public final String zzk() {
        return this.zzf;
    }
}
