package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfiq {
    private final HashMap zza = new HashMap();
    private final zzfiw zzb = new zzfiw(zzt.zzB());

    private zzfiq() {
        this.zza.put("new_csi", "1");
    }

    public static zzfiq zzb(String str) {
        zzfiq zzfiq = new zzfiq();
        zzfiq.zza.put("action", str);
        return zzfiq;
    }

    public static zzfiq zzc(String str) {
        zzfiq zzfiq = new zzfiq();
        zzfiq.zza.put("request_id", str);
        return zzfiq;
    }

    public final zzfiq zza(String str, String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzfiq zzd(String str) {
        this.zzb.zzb(str);
        return this;
    }

    public final zzfiq zze(String str, String str2) {
        this.zzb.zzc(str, str2);
        return this;
    }

    public final zzfiq zzf(zzfdk zzfdk) {
        this.zza.put("aai", zzfdk.zzx);
        return this;
    }

    public final zzfiq zzg(zzfdn zzfdn) {
        if (!TextUtils.isEmpty(zzfdn.zzb)) {
            this.zza.put("gqi", zzfdn.zzb);
        }
        return this;
    }

    public final zzfiq zzh(zzfdw zzfdw, zzcgc zzcgc) {
        zzfdv zzfdv = zzfdw.zzb;
        zzg(zzfdv.zzb);
        if (!zzfdv.zza.isEmpty()) {
            switch (((zzfdk) zzfdv.zza.get(0)).zzb) {
                case 1:
                    this.zza.put("ad_format", "banner");
                    break;
                case 2:
                    this.zza.put("ad_format", IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
                    break;
                case 3:
                    this.zza.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zza.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zza.put("ad_format", "rewarded");
                    break;
                case 6:
                    this.zza.put("ad_format", "app_open_ad");
                    if (zzcgc != null) {
                        this.zza.put("as", true != zzcgc.zzj() ? MBridgeConstans.ENDCARD_URL_TYPE_PL : "1");
                        break;
                    }
                    break;
                default:
                    this.zza.put("ad_format", "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzfiq zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final Map zzj() {
        HashMap hashMap = new HashMap(this.zza);
        for (zzfiv zzfiv : this.zzb.zza()) {
            hashMap.put(zzfiv.zza, zzfiv.zzb);
        }
        return hashMap;
    }
}
