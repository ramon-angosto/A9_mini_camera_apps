package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcug implements zzctw {
    private final Context zza;
    private final zzg zzb = zzt.zzo().zzh();

    public zzcug(Context context) {
        this.zza = context;
    }

    public final void zza(Map map) {
        if (!map.isEmpty()) {
            String str = (String) map.get("gad_idless");
            if (str != null) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                map.remove("gad_idless");
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzar)).booleanValue()) {
                    this.zzb.zzH(parseBoolean);
                    if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue() && parseBoolean) {
                        this.zza.deleteDatabase("OfflineUpload.db");
                    }
                }
            }
            Bundle bundle = new Bundle();
            for (Map.Entry entry : map.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzam)).booleanValue()) {
                zzt.zzn().zzr(bundle);
            }
        }
    }
}
