package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfnm implements OnFailureListener {
    public final /* synthetic */ zzfnq zza;

    public /* synthetic */ zzfnm(zzfnq zzfnq) {
        this.zza = zzfnq;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzf(exc);
    }
}
