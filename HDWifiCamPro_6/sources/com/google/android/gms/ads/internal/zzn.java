package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzn implements View.OnTouchListener {
    final /* synthetic */ zzs zza;

    zzn(zzs zzs) {
        this.zza = zzs;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzs zzs = this.zza;
        if (zzs.zzh == null) {
            return false;
        }
        zzs.zzh.zzd(motionEvent);
        return false;
    }
}
