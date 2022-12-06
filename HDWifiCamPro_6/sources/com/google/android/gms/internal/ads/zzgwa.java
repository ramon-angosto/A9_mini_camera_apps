package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgwa extends zzgre implements zzgsp {
    /* access modifiers changed from: private */
    public static final zzgwa zzb;
    private int zze;
    private String zzf = "";
    private long zzg;
    private boolean zzh;
    private int zzi;
    private String zzj = "";
    private String zzk = "";

    static {
        zzgwa zzgwa = new zzgwa();
        zzb = zzgwa;
        zzgre.zzaQ(zzgwa.class, zzgwa);
    }

    private zzgwa() {
    }

    public static zzgvz zza() {
        return (zzgvz) zzb.zzaz();
    }

    static /* synthetic */ void zzd(zzgwa zzgwa, String str) {
        zzgwa.zze |= 1;
        zzgwa.zzf = str;
    }

    static /* synthetic */ void zze(zzgwa zzgwa, long j) {
        zzgwa.zze |= 2;
        zzgwa.zzg = j;
    }

    static /* synthetic */ void zzf(zzgwa zzgwa, boolean z) {
        zzgwa.zze |= 4;
        zzgwa.zzh = z;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004ဌ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzgwb.zza, "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzgwa();
        } else {
            if (i2 == 4) {
                return new zzgvz((zzguq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
