package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcfv extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzcfy zza;

    zzcfv(zzcfy zzcfy) {
        this.zza = zzcfy;
    }

    public final void onAvailable(Network network) {
        this.zza.zzm.set(true);
    }

    public final void onLost(Network network) {
        this.zza.zzm.set(false);
    }
}
