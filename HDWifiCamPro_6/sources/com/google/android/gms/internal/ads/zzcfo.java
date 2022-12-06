package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcfo implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzchh zzb;

    zzcfo(zzcfp zzcfp, Context context, zzchh zzchh) {
        this.zza = context;
        this.zzb = zzchh;
    }

    public final void run() {
        try {
            this.zzb.zzd(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzb.zze(e);
            zzcgp.zzh("Exception while getting advertising Id info", e);
        }
    }
}
