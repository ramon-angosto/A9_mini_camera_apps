package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfnu extends zzgre implements zzgsp {
    private static final zzgrk zzb = new zzfnr();
    /* access modifiers changed from: private */
    public static final zzfnu zze;
    private int zzf;
    private zzgrj zzg = zzaH();
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzfnu zzfnu = new zzfnu();
        zze = zzfnu;
        zzgre.zzaQ(zzfnu.class, zzfnu);
    }

    private zzfnu() {
    }

    public static zzfnt zza() {
        return (zzfnt) zze.zzaz();
    }

    static /* synthetic */ void zzd(zzfnu zzfnu, String str) {
        str.getClass();
        zzfnu.zzf |= 1;
        zzfnu.zzh = str;
    }

    static /* synthetic */ void zze(zzfnu zzfnu, int i) {
        zzgrj zzgrj = zzfnu.zzg;
        if (!zzgrj.zzc()) {
            zzfnu.zzg = zzgre.zzaI(zzgrj);
        }
        zzfnu.zzg.zzh(2);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaP(zze, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzf", "zzg", zzfns.zza, "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzfnu();
        } else {
            if (i2 == 4) {
                return new zzfnt((zzfnr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
