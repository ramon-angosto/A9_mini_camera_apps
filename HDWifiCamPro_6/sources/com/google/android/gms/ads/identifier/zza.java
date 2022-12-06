package com.google.android.gms.ads.identifier;

import android.net.Uri;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
final class zza extends Thread {
    final /* synthetic */ Map zza;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zza = map;
    }

    public final void run() {
        Map map = this.zza;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        zzc.zza(buildUpon.build().toString());
    }
}
