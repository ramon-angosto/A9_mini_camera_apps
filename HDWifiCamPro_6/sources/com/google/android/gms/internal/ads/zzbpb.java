package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbpb implements zzbpu {
    public static final /* synthetic */ zzbpb zza = new zzbpb();

    private /* synthetic */ zzbpb() {
    }

    public final void zza(Object obj, Map map) {
        zzcnq zzcnq = (zzcnq) obj;
        zzbpu zzbpu = zzbpt.zza;
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzhc)).booleanValue()) {
            zze.zzj("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get(CampaignEx.JSON_KEY_PACKAGE_NAME);
        if (TextUtils.isEmpty(str)) {
            zze.zzj("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(zzcnq.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
        hashMap.put(str, valueOf);
        zze.zza("/canOpenApp;" + str + ";" + valueOf);
        ((zzbsn) zzcnq).zzd("openableApp", hashMap);
    }
}
