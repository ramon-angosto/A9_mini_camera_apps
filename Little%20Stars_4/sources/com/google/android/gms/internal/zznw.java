package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;

public class zznw implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zzakT;
    private final int zzamk;
    private zzoh zzaml;

    public zznw(Api<?> api, int i) {
        this.zzakT = api;
        this.zzamk = i;
    }

    private void zzrM() {
        zzaa.zzb(this.zzaml, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(@Nullable Bundle bundle) {
        zzrM();
        this.zzaml.onConnected(bundle);
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzrM();
        this.zzaml.zza(connectionResult, this.zzakT, this.zzamk);
    }

    public void onConnectionSuspended(int i) {
        zzrM();
        this.zzaml.onConnectionSuspended(i);
    }

    public void zza(zzoh zzoh) {
        this.zzaml = zzoh;
    }
}
