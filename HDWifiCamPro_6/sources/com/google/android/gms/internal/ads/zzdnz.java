package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdnz implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzdnz(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcgv zza2 = ((zzcpc) this.zza).zza();
        zzt.zzp();
        return new zzbbm(UUID.randomUUID().toString(), zza2, "native", new JSONObject(), false, true);
    }
}
