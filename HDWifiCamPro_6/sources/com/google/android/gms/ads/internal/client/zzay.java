package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbiw;
import com.google.android.gms.internal.ads.zzbja;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzay {
    private static final zzay zza = new zzay();
    private final zzbiv zzb;
    private final zzbiw zzc;
    private final zzbja zzd;

    protected zzay() {
        zzbiv zzbiv = new zzbiv();
        zzbiw zzbiw = new zzbiw();
        zzbja zzbja = new zzbja();
        this.zzb = zzbiv;
        this.zzc = zzbiw;
        this.zzd = zzbja;
    }

    public static zzbiv zza() {
        return zza.zzb;
    }

    public static zzbiw zzb() {
        return zza.zzc;
    }

    public static zzbja zzc() {
        return zza.zzd;
    }
}
