package com.google.android.gms.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzb {
    public static int zza(AdSize adSize) {
        return adSize.zzb();
    }

    public static int zzb(AdSize adSize) {
        return adSize.zza();
    }

    public static AdSize zzc(int i, int i2, String str) {
        return new AdSize(i, i2, str);
    }

    public static AdSize zzd(int i, int i2) {
        AdSize adSize = new AdSize(i, i2);
        adSize.zze(true);
        adSize.zzc(i2);
        return adSize;
    }

    public static AdSize zze(int i, int i2) {
        AdSize adSize = new AdSize(i, i2);
        adSize.zzf(true);
        adSize.zzd(i2);
        return adSize;
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.zzg();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.zzh();
    }

    public static boolean zzh(AdSize adSize) {
        return adSize.zzi();
    }
}
