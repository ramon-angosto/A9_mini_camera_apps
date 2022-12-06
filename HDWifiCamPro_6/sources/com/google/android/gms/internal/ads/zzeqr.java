package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeqr implements zzeve {
    private final Executor zza;
    private final zzcfy zzb;

    zzeqr(Executor executor, zzcfy zzcfy) {
        this.zza = executor;
        this.zzb = zzcfy;
    }

    public final int zza() {
        return 10;
    }

    public final zzfzp zzb() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcl)).booleanValue()) {
            return zzfzg.zzi((Object) null);
        }
        return zzfzg.zzm(this.zzb.zzj(), zzeqp.zza, this.zza);
    }
}
