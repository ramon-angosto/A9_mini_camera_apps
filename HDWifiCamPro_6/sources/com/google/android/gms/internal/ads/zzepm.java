package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzepm implements zzevd {
    final zzfef zza;
    private final long zzb;

    public zzepm(zzfef zzfef, long j) {
        Preconditions.checkNotNull(zzfef, "the targeting must not be null");
        this.zza = zzfef;
        this.zzb = j;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzl zzl = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzl.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        int i2 = i - 1;
        if (i != 0) {
            boolean z = true;
            if (i2 == 1) {
                bundle.putBoolean("is_new_rewarded", true);
            } else if (i2 == 2) {
                bundle.putBoolean("is_rewarded_interstitial", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            zzfeq.zzf(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzl.zzb)), zzl.zzb != -1);
            zzfeq.zzb(bundle, "extras", zzl.zzc);
            int i3 = zzl.zzd;
            zzfeq.zze(bundle, "cust_gender", i3, i3 != -1);
            zzfeq.zzd(bundle, "kw", zzl.zze);
            int i4 = zzl.zzg;
            zzfeq.zze(bundle, "tag_for_child_directed_treatment", i4, i4 != -1);
            if (zzl.zzf) {
                bundle.putBoolean("test_request", true);
            }
            zzfeq.zze(bundle, "d_imp_hdr", 1, zzl.zza >= 2 && zzl.zzh);
            String str = zzl.zzi;
            zzfeq.zzf(bundle, "ppid", str, zzl.zza >= 2 && !TextUtils.isEmpty(str));
            Location location = zzl.zzk;
            if (location != null) {
                float accuracy = location.getAccuracy();
                long time = location.getTime();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", accuracy * 1000.0f);
                bundle2.putLong("lat", (long) (latitude * 1.0E7d));
                bundle2.putLong("long", (long) (longitude * 1.0E7d));
                bundle2.putLong("time", time * 1000);
                bundle.putBundle("uule", bundle2);
            }
            zzfeq.zzc(bundle, "url", zzl.zzl);
            zzfeq.zzd(bundle, "neighboring_content_urls", zzl.zzv);
            zzfeq.zzb(bundle, "custom_targeting", zzl.zzn);
            zzfeq.zzd(bundle, "category_exclusions", zzl.zzo);
            zzfeq.zzc(bundle, "request_agent", zzl.zzp);
            zzfeq.zzc(bundle, "request_pkg", zzl.zzq);
            zzfeq.zzg(bundle, "is_designed_for_families", zzl.zzr, zzl.zza >= 7);
            if (zzl.zza >= 8) {
                int i5 = zzl.zzt;
                if (i5 == -1) {
                    z = false;
                }
                zzfeq.zze(bundle, "tag_for_under_age_of_consent", i5, z);
                zzfeq.zzc(bundle, "max_ad_content_rating", zzl.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
