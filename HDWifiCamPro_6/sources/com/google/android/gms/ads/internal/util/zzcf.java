package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcf extends BroadcastReceiver {
    final /* synthetic */ zzcg zza;

    zzcf(zzcg zzcg) {
        this.zza = zzcg;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zze(context, intent);
    }
}
