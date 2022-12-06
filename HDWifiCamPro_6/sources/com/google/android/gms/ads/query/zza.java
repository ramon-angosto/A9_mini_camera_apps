package com.google.android.gms.ads.query;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbzt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ AdFormat zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ QueryInfoGenerationCallback zzd;

    public /* synthetic */ zza(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = adRequest;
        this.zzd = queryInfoGenerationCallback;
    }

    public final void run() {
        Context context = this.zza;
        AdFormat adFormat = this.zzb;
        AdRequest adRequest = this.zzc;
        new zzbzt(context, adFormat, adRequest == null ? null : adRequest.zza()).zzb(this.zzd);
    }
}
