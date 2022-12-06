package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfix implements zzfir {
    private final zzfjb zza;
    private final zzfiz zzb;
    private final zzfio zzc;

    public zzfix(zzfio zzfio, zzfjb zzfjb, zzfiz zzfiz, byte[] bArr) {
        this.zzc = zzfio;
        this.zza = zzfjb;
        this.zzb = zzfiz;
    }

    public final String zza(zzfiq zzfiq) {
        zzfjb zzfjb = this.zza;
        Map zzj = zzfiq.zzj();
        this.zzb.zza(zzj);
        return zzfjb.zza(zzj);
    }

    public final void zzb(zzfiq zzfiq) {
        this.zzc.zzb(zza(zzfiq));
    }
}
