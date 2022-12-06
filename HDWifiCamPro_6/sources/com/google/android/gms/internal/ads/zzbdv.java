package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbdv implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbdx zza;

    zzbdv(zzbdx zzbdx) {
        this.zza = zzbdx;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzbdx zzbdx = this.zza;
                if (zzbdx.zzd != null) {
                    zzbdx.zzf = zzbdx.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                zze.zzh("Unable to obtain a cache service instance.", e);
                zzbdx.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
