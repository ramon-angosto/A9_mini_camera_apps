package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaba implements GoogleApiClient.OnConnectionFailedListener {
    final /* synthetic */ StatusPendingResult zaa;

    zaba(zabe zabe, StatusPendingResult statusPendingResult) {
        this.zaa = statusPendingResult;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaa.setResult(new Status(8));
    }
}
