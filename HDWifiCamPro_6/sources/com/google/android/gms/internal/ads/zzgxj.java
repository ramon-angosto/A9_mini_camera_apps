package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxj implements zzgxi, zzgxc {
    private static final zzgxj zza = new zzgxj((Object) null);
    private final Object zzb;

    private zzgxj(Object obj) {
        this.zzb = obj;
    }

    public static zzgxi zza(Object obj) {
        zzgxq.zza(obj, "instance cannot be null");
        return new zzgxj(obj);
    }

    public static zzgxi zzc(Object obj) {
        return obj == null ? zza : new zzgxj(obj);
    }

    public final Object zzb() {
        return this.zzb;
    }
}
