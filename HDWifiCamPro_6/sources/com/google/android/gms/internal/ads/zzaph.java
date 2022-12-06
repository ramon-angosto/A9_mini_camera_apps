package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaph extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzapi zza;

    zzaph(zzapi zzapi) {
        this.zza = zzapi;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzapi.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzapi.class) {
            this.zza.zza = null;
        }
    }
}
