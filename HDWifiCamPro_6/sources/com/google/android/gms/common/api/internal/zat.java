package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zaa;
    private final boolean zab;
    private zau zac;

    public zat(Api<?> api, boolean z) {
        this.zaa = api;
        this.zab = z;
    }

    private final zau zab() {
        Preconditions.checkNotNull(this.zac, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.zac;
    }

    public final void onConnected(Bundle bundle) {
        zab().onConnected(bundle);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zab().zaa(connectionResult, this.zaa, this.zab);
    }

    public final void onConnectionSuspended(int i) {
        zab().onConnectionSuspended(i);
    }

    public final void zaa(zau zau) {
        this.zac = zau;
    }
}
