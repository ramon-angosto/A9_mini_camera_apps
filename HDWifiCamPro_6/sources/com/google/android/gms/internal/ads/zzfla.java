package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfla {
    private final String zza;
    private final String zzb;

    private zzfla(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfla zza(String str, String str2) {
        zzfly.zza(str, "Name is null or empty");
        zzfly.zza(str2, "Version is null or empty");
        return new zzfla(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
