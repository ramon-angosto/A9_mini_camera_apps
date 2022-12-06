package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zze extends zzcgp {
    public static void zza(String str) {
        if (!zzc()) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.v(AdRequest.LOGTAG, str);
            return;
        }
        boolean z = true;
        for (String str2 : zza.zzd(str)) {
            if (z) {
                Log.v(AdRequest.LOGTAG, str2);
            } else {
                Log.v("Ads-cont", str2);
            }
            z = false;
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzc()) {
            Log.v(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzc() {
        return zzm(2) && ((Boolean) zzbkv.zza.zze()).booleanValue();
    }
}
