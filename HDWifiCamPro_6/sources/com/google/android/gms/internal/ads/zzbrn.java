package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbrn implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzchh zza;
    final /* synthetic */ zzbrp zzb;

    zzbrn(zzbrp zzbrp, zzchh zzchh) {
        this.zzb = zzbrp;
        this.zza = zzchh;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzd(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zze(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzchh zzchh = this.zza;
        zzchh.zze(new RuntimeException("onConnectionSuspended: " + i));
    }
}
