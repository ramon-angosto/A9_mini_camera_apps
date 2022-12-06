package com.google.android.gms.ads.appopen;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzcaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ AppOpenAd.AppOpenAdLoadCallback zze;

    public /* synthetic */ zzb(Context context, String str, AdRequest adRequest, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adRequest;
        this.zzd = i;
        this.zze = appOpenAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdRequest adRequest = this.zzc;
        try {
            new zzbdr(context, str, adRequest.zza(), this.zzd, this.zze).zza();
        } catch (IllegalStateException e) {
            zzcaf.zza(context).zzd(e, "AppOpenAd.load");
        }
    }
}
