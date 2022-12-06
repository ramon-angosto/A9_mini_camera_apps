package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcgo;
import com.google.android.gms.internal.ads.zzchf;
import com.google.android.gms.internal.ads.zzfzp;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzd {
    public static void zza(Context context) {
        if (zzcgo.zzk(context) && !zzcgo.zzm()) {
            zzfzp zzb = new zzc(context).zzb();
            zze.zzi("Updating ad debug logging enablement.");
            zzchf.zza(zzb, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
