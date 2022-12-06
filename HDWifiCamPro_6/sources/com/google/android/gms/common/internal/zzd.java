package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class zzd extends zzab {
    private BaseGmsClient zza;
    private final int zzb;

    public zzd(BaseGmsClient baseGmsClient, int i) {
        this.zza = baseGmsClient;
        this.zzb = i;
    }

    public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
        Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zza.onPostInitHandler(i, iBinder, bundle, this.zzb);
        this.zza = null;
    }

    public final void zzb(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void zzc(int i, IBinder iBinder, zzj zzj) {
        BaseGmsClient baseGmsClient = this.zza;
        Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(zzj);
        BaseGmsClient.zzj(baseGmsClient, zzj);
        onPostInitComplete(i, iBinder, zzj.zza);
    }
}
