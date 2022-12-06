package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zznt;

public interface zzog {
    void begin();

    void connect();

    boolean disconnect();

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);

    void zza(ConnectionResult connectionResult, Api<?> api, int i);

    <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(T t);

    <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(T t);
}
