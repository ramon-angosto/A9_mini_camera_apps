package com.google.android.gms.internal.ads;

import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdse implements zzbbq {
    public final /* synthetic */ zzcmp zza;

    public /* synthetic */ zzdse(zzcmp zzcmp) {
        this.zza = zzcmp;
    }

    public final void zzc(zzbbp zzbbp) {
        zzcmp zzcmp = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", true != zzbbp.zzj ? MBridgeConstans.ENDCARD_URL_TYPE_PL : "1");
        zzcmp.zzd("onAdVisibilityChanged", hashMap);
    }
}
