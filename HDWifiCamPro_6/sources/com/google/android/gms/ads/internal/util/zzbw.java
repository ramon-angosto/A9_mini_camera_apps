package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbw {
    final Map zza = new ConcurrentHashMap();
    private final AtomicInteger zzb = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return (Bitmap) this.zza.get(num);
    }
}
