package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzkk extends BroadcastReceiver {
    final /* synthetic */ zzkl zza;

    /* synthetic */ zzkk(zzkl zzkl, zzkj zzkj) {
        this.zza = zzkl;
    }

    public final void onReceive(Context context, Intent intent) {
        zzkl zzkl = this.zza;
        zzkl.zzb.post(new zzki(zzkl));
    }
}
