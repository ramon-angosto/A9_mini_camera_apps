package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.DeviceProperties;
import com.mbridge.msdk.MBridgeConstans;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbjf {
    private final String zza = ((String) zzbkm.zzb.zze());
    private final Map zzb = new LinkedHashMap();
    private final Context zzc;
    private final String zzd;

    public zzbjf(Context context, String str) {
        String str2;
        this.zzc = context;
        this.zzd = str;
        this.zzb.put("s", "gmob_sdk");
        this.zzb.put("v", MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
        this.zzb.put("os", Build.VERSION.RELEASE);
        this.zzb.put("api_v", Build.VERSION.SDK);
        Map map = this.zzb;
        zzt.zzp();
        map.put("device", zzs.zzq());
        Map map2 = this.zzb;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put("app", str2);
        Map map3 = this.zzb;
        zzt.zzp();
        boolean zzA = zzs.zzA(context);
        String str3 = MBridgeConstans.ENDCARD_URL_TYPE_PL;
        map3.put("is_lite_sdk", true != zzA ? str3 : "1");
        Future zzb2 = zzt.zzm().zzb(this.zzc);
        try {
            this.zzb.put("network_coarse", Integer.toString(((zzcbh) zzb2.get()).zzk));
            this.zzb.put("network_fine", Integer.toString(((zzcbh) zzb2.get()).zzl));
        } catch (Exception e) {
            zzt.zzo().zzt(e, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziQ)).booleanValue()) {
            this.zzb.put("is_bstar", true == DeviceProperties.isBstar(context) ? "1" : str3);
        }
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Map zzd() {
        return this.zzb;
    }
}
