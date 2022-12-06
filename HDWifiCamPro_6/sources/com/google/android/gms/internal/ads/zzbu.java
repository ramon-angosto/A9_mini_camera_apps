package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzbu extends IOException {
    public final boolean zza;
    public final int zzb;

    protected zzbu(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.zza = z;
        this.zzb = i;
    }

    public static zzbu zza(String str, Throwable th) {
        return new zzbu(str, th, true, 1);
    }

    public static zzbu zzb(String str, Throwable th) {
        return new zzbu(str, th, true, 0);
    }

    public static zzbu zzc(String str) {
        return new zzbu(str, (Throwable) null, false, 1);
    }
}
