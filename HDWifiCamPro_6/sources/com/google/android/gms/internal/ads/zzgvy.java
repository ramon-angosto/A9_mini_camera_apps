package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvy extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgvy zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private zzgvl zzh;
    private zzgvp zzi;
    private int zzj;
    private zzgrj zzk = zzaH();
    private String zzl = "";
    private int zzm;
    private zzgrn zzn = zzgre.zzaK();
    private byte zzo = 2;

    static {
        zzgvy zzgvy = new zzgvy();
        zzb = zzgvy;
        zzgre.zzaQ(zzgvy.class, zzgvy);
    }

    private zzgvy() {
    }

    public static zzgvx zzc() {
        return (zzgvx) zzb.zzaz();
    }

    static /* synthetic */ void zzf(zzgvy zzgvy, int i) {
        zzgvy.zze |= 1;
        zzgvy.zzf = i;
    }

    static /* synthetic */ void zzg(zzgvy zzgvy, String str) {
        str.getClass();
        zzgvy.zze |= 2;
        zzgvy.zzg = str;
    }

    static /* synthetic */ void zzh(zzgvy zzgvy, zzgvl zzgvl) {
        zzgvl.getClass();
        zzgvy.zzh = zzgvl;
        zzgvy.zze |= 4;
    }

    static /* synthetic */ void zzi(zzgvy zzgvy, String str) {
        str.getClass();
        zzgrn zzgrn = zzgvy.zzn;
        if (!zzgrn.zzc()) {
            zzgvy.zzn = zzgre.zzaL(zzgrn);
        }
        zzgvy.zzn.add(str);
    }

    static /* synthetic */ void zzj(zzgvy zzgvy, int i) {
        zzgvy.zzm = i - 1;
        zzgvy.zze |= 64;
    }

    public final int zza() {
        return this.zzn.size();
    }

    public final String zze() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzo);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzgvv.zza, "zzn"});
        } else if (i2 == 3) {
            return new zzgvy();
        } else {
            if (i2 == 4) {
                return new zzgvx((zzguq) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzo = b;
            return null;
        }
    }
}
