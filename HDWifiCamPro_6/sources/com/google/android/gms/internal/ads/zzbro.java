package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbro implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzchh zza;

    zzbro(zzbrp zzbrp, zzchh zzchh) {
        this.zza = zzchh;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zza.zze(new RuntimeException("Connection failed."));
    }
}
