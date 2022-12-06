package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcis {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzay.zzc().zzb(zzbjc.zzB)).longValue());
    private long zzb;
    private boolean zzc = true;

    zzcis() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzcid zzcid) {
        if (zzcid != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzc || Math.abs(timestamp - this.zzb) >= this.zza) {
                this.zzc = false;
                this.zzb = timestamp;
                zzs.zza.post(new zzcir(zzcid));
            }
        }
    }

    public final void zzb() {
        this.zzc = true;
    }
}
