package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zznt;
import java.util.Collections;

public class zzoe implements zzog {
    private final zzoh zzamB;

    public zzoe(zzoh zzoh) {
        this.zzamB = zzoh;
    }

    public void begin() {
        this.zzamB.zzso();
        this.zzamB.zzamm.zzano = Collections.emptySet();
    }

    public void connect() {
        this.zzamB.zzsm();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(T t) {
        this.zzamB.zzamm.zzanh.add(t);
        return t;
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
