package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfrq implements IBinder.DeathRecipient {
    public final /* synthetic */ zzfry zza;

    public /* synthetic */ zzfrq(zzfry zzfry) {
        this.zza = zzfry;
    }

    public final void binderDied() {
        zzfry.zzh(this.zza);
    }
}
