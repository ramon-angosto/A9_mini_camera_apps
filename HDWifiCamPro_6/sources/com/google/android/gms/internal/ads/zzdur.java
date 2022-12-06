package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdur implements View.OnTouchListener {
    public final /* synthetic */ zzdux zza;

    public /* synthetic */ zzdur(zzdux zzdux) {
        this.zza = zzdux;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzh(view, motionEvent);
        return false;
    }
}
