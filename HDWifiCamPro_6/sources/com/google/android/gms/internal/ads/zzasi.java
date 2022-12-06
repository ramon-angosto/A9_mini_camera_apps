package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzasi extends Exception {
    private zzasi(int i, String str, Throwable th, int i2) {
        super((String) null, th);
    }

    public static zzasi zza(Exception exc, int i) {
        return new zzasi(1, (String) null, exc, i);
    }

    public static zzasi zzb(IOException iOException) {
        return new zzasi(0, (String) null, iOException, -1);
    }

    static zzasi zzc(RuntimeException runtimeException) {
        return new zzasi(2, (String) null, runtimeException, -1);
    }
}
