package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzrz {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzfc zza;
    public final Uri zzb;
    public final Map zzc;

    public zzrz(long j, zzfc zzfc, Uri uri, Map map, long j2, long j3, long j4) {
        this.zza = zzfc;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
