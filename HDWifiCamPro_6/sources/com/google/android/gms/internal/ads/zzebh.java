package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzebh extends Exception {
    private final int zza;

    public zzebh(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzebh(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzebh(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
