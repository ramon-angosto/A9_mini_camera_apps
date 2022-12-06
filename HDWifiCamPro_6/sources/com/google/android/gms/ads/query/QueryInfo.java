package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzeg;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbkq;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzcge;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class QueryInfo {
    private final zzeg zza;

    public QueryInfo(zzeg zzeg) {
        this.zza = zzeg;
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzdr zzdr;
        zzbjc.zzc(context);
        if (((Boolean) zzbkq.zzk.zze()).booleanValue()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziM)).booleanValue()) {
                zzcge.zzb.execute(new zza(context, adFormat, adRequest, queryInfoGenerationCallback));
                return;
            }
        }
        if (adRequest == null) {
            zzdr = null;
        } else {
            zzdr = adRequest.zza();
        }
        new zzbzt(context, adFormat, zzdr).zzb(queryInfoGenerationCallback);
    }

    public String getQuery() {
        return this.zza.zzb();
    }

    public Bundle getQueryBundle() {
        return this.zza.zza();
    }

    public String getRequestId() {
        return this.zza.zzd();
    }

    public final zzeg zza() {
        return this.zza;
    }
}
