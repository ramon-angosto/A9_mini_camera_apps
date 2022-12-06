package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaqk extends BroadcastReceiver {
    final /* synthetic */ zzaql zza;

    zzaqk(zzaql zzaql) {
        this.zza = zzaql;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzf();
    }
}
