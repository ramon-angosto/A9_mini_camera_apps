package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgxa {
    public static zzgxa zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzgwv(cls.getSimpleName());
        }
        return new zzgwx(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
