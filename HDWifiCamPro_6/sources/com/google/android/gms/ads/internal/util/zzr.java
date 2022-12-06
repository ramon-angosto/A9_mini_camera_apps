package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzr extends BroadcastReceiver {
    final /* synthetic */ zzs zza;

    /* synthetic */ zzr(zzs zzs, zzq zzq) {
        this.zza = zzs;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zza.zzd = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zza.zzd = false;
        }
    }
}
