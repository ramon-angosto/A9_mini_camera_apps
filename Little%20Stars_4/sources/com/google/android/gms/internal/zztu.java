package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.zzg;

public final class zztu {
    public static final Api<zztw> API = new Api<>("SignIn.API", zzaaA, zzaaz);
    public static final Api.zzf<zzg> zzaCB = new Api.zzf<>();
    public static final Api.zza<zzg, zztw> zzaaA = new Api.zza<zzg, zztw>() {
        public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, zztw zztw, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (zztw == null) {
                zztw = zztw.zzbnf;
            }
            return new zzg(context, looper, true, zzg, zztw, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api.zzf<zzg> zzaaz = new Api.zzf<>();
    public static final Scope zzacw = new Scope(Scopes.PROFILE);
    public static final Scope zzacx = new Scope("email");
    public static final Api<zza> zzavg = new Api<>("SignIn.INTERNAL_API", zzbne, zzaCB);
    static final Api.zza<zzg, zza> zzbne = new Api.zza<zzg, zza>() {
        public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, false, zzg, zza.zzIO(), connectionCallbacks, onConnectionFailedListener);
        }
    };

    public static class zza implements Api.ApiOptions.HasOptions {
        public Bundle zzIO() {
            return null;
        }
    }
}
