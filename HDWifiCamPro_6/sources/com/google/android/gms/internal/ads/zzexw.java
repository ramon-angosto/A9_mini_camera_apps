package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzch;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzexw implements Callable {
    public static final /* synthetic */ zzexw zza = new zzexw();

    private /* synthetic */ zzexw() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzay.zzc().zzb(zzbjc.zzI);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzay.zzc().zzb(zzbjc.zzJ)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzch.zza(str2));
                }
            }
        }
        return new zzexy(hashMap);
    }
}
