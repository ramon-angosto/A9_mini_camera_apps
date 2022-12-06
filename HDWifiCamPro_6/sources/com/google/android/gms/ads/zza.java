package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzdr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ AdLoader zza;
    public final /* synthetic */ zzdr zzb;

    public /* synthetic */ zza(AdLoader adLoader, zzdr zzdr) {
        this.zza = adLoader;
        this.zzb = zzdr;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
