package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzdxl;
import com.google.android.gms.internal.ads.zzdxv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ zzdxv zza;
    public final /* synthetic */ zzdxl zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Pair[] zzd;

    public /* synthetic */ zze(zzdxv zzdxv, zzdxl zzdxl, String str, Pair[] pairArr) {
        this.zza = zzdxv;
        this.zzb = zzdxl;
        this.zzc = str;
        this.zzd = pairArr;
    }

    public final void run() {
        Map map;
        zzdxv zzdxv = this.zza;
        zzdxl zzdxl = this.zzb;
        String str = this.zzc;
        Pair[] pairArr = this.zzd;
        if (zzdxl == null) {
            map = zzdxv.zzc();
        } else {
            map = zzdxl.zza();
        }
        map.put("action", str);
        for (Pair pair : pairArr) {
            map.put((String) pair.first, (String) pair.second);
        }
        zzdxv.zze(map);
    }
}
