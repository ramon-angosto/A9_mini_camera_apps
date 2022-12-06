package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzg;

public final class zzpl {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", zzaaA, zzaaz);
    private static final Api.zza<zzpp, Api.ApiOptions.NoOptions> zzaaA = new Api.zza<zzpp, Api.ApiOptions.NoOptions>() {
        /* renamed from: zze */
        public zzpp zza(Context context, Looper looper, zzg zzg, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpp(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api.zzf<zzpp> zzaaz = new Api.zzf<>();
    public static final zzpm zzasx = new zzpn();
}
