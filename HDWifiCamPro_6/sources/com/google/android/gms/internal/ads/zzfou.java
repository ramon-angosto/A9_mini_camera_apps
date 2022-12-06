package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfou extends Exception {
    private final int zza;

    public zzfou(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzfou(int i, Throwable th) {
        super(th);
        this.zza = i;
    }
}
