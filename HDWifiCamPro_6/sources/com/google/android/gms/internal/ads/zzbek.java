package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbek implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzchh zza;
    final /* synthetic */ zzbel zzb;

    zzbek(zzbel zzbel, zzchh zzchh) {
        this.zzb = zzbel;
        this.zza = zzchh;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zze(new RuntimeException("Connection failed."));
        }
    }
}
