package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbdw implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbdx zza;

    zzbdw(zzbdx zzbdx) {
        this.zza = zzbdx;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzbdx zzbdx = this.zza;
            if (zzbdx.zzd != null) {
                zzbdx.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
