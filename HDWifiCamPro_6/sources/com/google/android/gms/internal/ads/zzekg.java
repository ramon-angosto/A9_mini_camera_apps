package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzl;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzekg implements zzehc {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        zzfdk zzfdk2 = zzfdk;
        String optString = zzfdk2.zzw.optString("pubid", "");
        zzfef zzfef = zzfdw.zza.zza;
        zzfed zzfed = new zzfed();
        zzfed.zzp(zzfef);
        zzfed.zzs(optString);
        Bundle zzd = zzd(zzfef.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzfdk2.zzw.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzfdk2.zzw.optString("adJson", (String) null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzfdk2.zzE.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzfdk2.zzE.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzl zzl = zzfef.zzd;
        zzl zzl2 = r5;
        zzl zzl3 = new zzl(zzl.zza, zzl.zzb, zzd2, zzl.zzd, zzl.zze, zzl.zzf, zzl.zzg, zzl.zzh, zzl.zzi, zzl.zzj, zzl.zzk, zzl.zzl, zzd, zzl.zzn, zzl.zzo, zzl.zzp, zzl.zzq, zzl.zzr, zzl.zzs, zzl.zzt, zzl.zzu, zzl.zzv, zzl.zzw, zzl.zzx);
        zzfed.zzE(zzl2);
        zzfef zzG = zzfed.zzG();
        Bundle bundle = new Bundle();
        zzfdw zzfdw2 = zzfdw;
        zzfdn zzfdn = zzfdw2.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzfdn.zza));
        bundle2.putInt("refresh_interval", zzfdn.zzc);
        bundle2.putString("gws_query_id", zzfdn.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzfdw2.zza.zza.zzf;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzfdk zzfdk3 = zzfdk;
        bundle3.putString("allocation_id", zzfdk3.zzx);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzfdk3.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzfdk3.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzfdk3.zzq));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzfdk3.zzn));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzfdk3.zzh));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzfdk3.zzi));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzfdk3.zzj));
        bundle3.putString("transaction_id", zzfdk3.zzk);
        bundle3.putString("valid_from_timestamp", zzfdk3.zzl);
        bundle3.putBoolean("is_closable_area_disabled", zzfdk3.zzQ);
        if (zzfdk3.zzm != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzfdk3.zzm.zzb);
            bundle4.putString("rb_type", zzfdk3.zzm.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzG, bundle);
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        return !TextUtils.isEmpty(zzfdk.zzw.optString("pubid", ""));
    }

    /* access modifiers changed from: protected */
    public abstract zzfzp zzc(zzfef zzfef, Bundle bundle);
}
