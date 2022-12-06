package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfjz extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzfjz zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public long zzg;
    /* access modifiers changed from: private */
    public int zzh;
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    /* access modifiers changed from: private */
    public int zzl;
    private int zzm;
    /* access modifiers changed from: private */
    public int zzn;
    /* access modifiers changed from: private */
    public long zzo;
    private int zzp;
    private String zzq = "";
    private String zzr = "";
    private String zzs = "";
    /* access modifiers changed from: private */
    public String zzt = "";
    private String zzu = "";

    static {
        zzfjz zzfjz = new zzfjz();
        zzb = zzfjz;
        zzgre.zzaQ(zzfjz.class, zzfjz);
    }

    private zzfjz() {
    }

    public static zzfjy zza() {
        return (zzfjy) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzfjz zzfjz, String str) {
        str.getClass();
        zzfjz.zzi = str;
    }

    static /* synthetic */ void zze(zzfjz zzfjz, String str) {
        str.getClass();
        zzfjz.zzj = str;
    }

    static /* synthetic */ void zzf(zzfjz zzfjz, String str) {
        str.getClass();
        zzfjz.zzk = str;
    }

    static /* synthetic */ void zzj(zzfjz zzfjz, String str) {
        str.getClass();
        zzfjz.zzq = str;
    }

    static /* synthetic */ void zzk(zzfjz zzfjz, String str) {
        str.getClass();
        zzfjz.zzr = str;
    }

    static /* synthetic */ void zzl(zzfjz zzfjz, String str) {
        str.getClass();
        zzfjz.zzs = str;
    }

    static /* synthetic */ void zzo(zzfjz zzfjz, String str) {
        str.getClass();
        zzfjz.zzu = str;
    }

    static /* synthetic */ void zzr(zzfjz zzfjz, int i) {
        if (i != 1) {
            zzfjz.zzm = i - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    static /* synthetic */ void zzs(zzfjz zzfjz, int i) {
        if (i != 1) {
            zzfjz.zzp = i - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0000\u0011\u0000\u0000\u0001\u0011\u0011\u0000\u0000\u0000\u0001\f\u0002\u0007\u0003\u0002\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0004\t\f\n\u0004\u000b\u0002\f\f\rȈ\u000eȈ\u000fȈ\u0010Ȉ\u0011Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
        } else if (i2 == 3) {
            return new zzfjz();
        } else {
            if (i2 == 4) {
                return new zzfjy((zzfjx) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
