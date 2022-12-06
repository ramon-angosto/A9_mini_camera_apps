package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcvo implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;

    public zzcvo(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        ((zzczu) this.zza).zza();
        String str = (String) this.zzd.zzb();
        boolean equals = "native".equals(str);
        zzt.zzp();
        return new zzbbm(UUID.randomUUID().toString(), ((zzcpc) this.zzb).zza(), str, (JSONObject) this.zzc.zzb(), false, equals);
    }
}
