package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzdx implements Runnable {
    public final /* synthetic */ zzed zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ OnInitializationCompleteListener zzc;

    public /* synthetic */ zzdx(zzed zzed, Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zza = zzed;
        this.zzb = context;
        this.zzc = onInitializationCompleteListener;
    }

    public final void run() {
        this.zza.zzo(this.zzb, (String) null, this.zzc);
    }
}
