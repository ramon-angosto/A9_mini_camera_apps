package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdtn;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzl implements Runnable {
    public final /* synthetic */ zzaa zza;
    public final /* synthetic */ zzdtn[] zzb;

    public /* synthetic */ zzl(zzaa zzaa, zzdtn[] zzdtnArr) {
        this.zza = zzaa;
        this.zzb = zzdtnArr;
    }

    public final void run() {
        this.zza.zzH(this.zzb);
    }
}
