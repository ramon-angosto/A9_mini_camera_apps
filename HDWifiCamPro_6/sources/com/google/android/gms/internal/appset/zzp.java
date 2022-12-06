package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.appset.zze;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzp extends GoogleApi<Api.ApiOptions.NoOptions> implements AppSetIdClient {
    private static final Api.ClientKey<zzd> zza = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzd, Api.ApiOptions.NoOptions> zzb = new zzn();
    private static final Api<Api.ApiOptions.NoOptions> zzc = new Api<>("AppSet.API", zzb, zza);
    private final Context zzd;
    private final GoogleApiAvailabilityLight zze;

    zzp(Context context, GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzd = context;
        this.zze = googleApiAvailabilityLight;
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        if (this.zze.isGooglePlayServicesAvailable(this.zzd, 212800000) != 0) {
            return Tasks.forException(new ApiException(new Status(17)));
        }
        return doRead(TaskApiCall.builder().setFeatures(zze.zza).run(new zzm(this)).setAutoResolveMissingFeatures(false).setMethodKey(27601).build());
    }
}
