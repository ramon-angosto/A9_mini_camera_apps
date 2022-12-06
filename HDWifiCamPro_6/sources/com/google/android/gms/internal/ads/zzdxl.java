package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxl {
    private final ConcurrentHashMap zza;
    private final zzcgc zzb;
    private final zzfef zzc;
    private final String zzd;
    private final String zze;

    public zzdxl(zzdxv zzdxv, zzcgc zzcgc, zzfef zzfef, String str, String str2) {
        this.zza = zzdxv.zzc();
        this.zzb = zzcgc;
        this.zzc = zzfef;
        this.zzd = str;
        this.zze = str2;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgd)).booleanValue()) {
            int zzd2 = zzf.zzd(this.zzc);
            int i = zzd2 - 1;
            if (i != 0) {
                if (i == 1) {
                    this.zza.put("se", "query_g");
                } else if (i == 2) {
                    this.zza.put("se", "r_adinfo");
                } else if (i != 3) {
                    this.zza.put("se", "r_both");
                } else {
                    this.zza.put("se", "r_adstring");
                }
                this.zza.put("scar", "true");
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzgE)).booleanValue()) {
                    this.zza.put("ad_format", this.zze);
                }
                if (zzd2 == 2) {
                    this.zza.put("rid", this.zzd);
                }
                zzd("ragent", this.zzc.zzd.zzp);
                zzd("rtype", zzf.zza(zzf.zzb(this.zzc.zzd)));
                return;
            }
            this.zza.put("scar", "false");
        }
    }

    private final void zzd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final Map zza() {
        return this.zza;
    }

    public final void zzb(zzfdw zzfdw) {
        if (zzfdw.zzb.zza.size() > 0) {
            switch (((zzfdk) zzfdw.zzb.zza.get(0)).zzb) {
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
                    this.zza.put("as", true != this.zzb.zzj() ? MBridgeConstans.ENDCARD_URL_TYPE_PL : "1");
                    break;
                default:
                    this.zza.put("ad_format", "unknown");
                    break;
            }
        }
        zzd("gqi", zzfdw.zzb.zzb.zzb);
    }

    public final void zzc(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
