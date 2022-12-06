package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfez {
    public static void zza(Context context, boolean z) {
        if (z) {
            zze.zzi("This request is sent from a test device.");
            return;
        }
        zzaw.zzb();
        String zzx = zzcgi.zzx(context);
        zze.zzi("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"" + zzx + "\")) to get test ads on this device.");
    }

    public static void zzb(int i, Throwable th, String str) {
        zze.zzi("Ad failed to load : " + i);
        zze.zzb(str, th);
        if (i != 3) {
            zzt.zzo().zzs(th, str);
        }
    }
}
