package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzr implements AppSetIdClient {
    private final AppSetIdClient zza;
    private final AppSetIdClient zzb;

    public zzr(Context context) {
        this.zza = new zzp(context, GoogleApiAvailabilityLight.getInstance());
        this.zzb = zzl.zzc(context);
    }

    public static /* synthetic */ Task zza(zzr zzr, Task task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return task;
        }
        Exception exception = task.getException();
        if (!(exception instanceof ApiException)) {
            return task;
        }
        int statusCode = ((ApiException) exception).getStatusCode();
        if (statusCode == 43001 || statusCode == 43002 || statusCode == 43003 || statusCode == 17) {
            return zzr.zzb.getAppSetIdInfo();
        }
        if (statusCode == 43000) {
            return Tasks.forException(new Exception("Failed to get app set ID due to an internal error. Please try again later."));
        }
        if (statusCode != 15) {
            return task;
        }
        return Tasks.forException(new Exception("The operation to get app set ID timed out. Please try again later."));
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        return this.zza.getAppSetIdInfo().continueWithTask(new zzq(this));
    }
}
