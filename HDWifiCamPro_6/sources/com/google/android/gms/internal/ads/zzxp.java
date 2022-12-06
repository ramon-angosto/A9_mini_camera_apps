package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzxp implements DisplayManager.DisplayListener, zzxn {
    private final DisplayManager zza;
    private zzxl zzb;

    private zzxp(DisplayManager displayManager) {
        this.zza = displayManager;
    }

    public static zzxn zzc(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager != null) {
            return new zzxp(displayManager);
        }
        return null;
    }

    private final Display zzd() {
        return this.zza.getDisplay(0);
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayChanged(int i) {
        zzxl zzxl = this.zzb;
        if (zzxl != null && i == 0) {
            zzxr.zzb(zzxl.zza, zzd());
        }
    }

    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zza.unregisterDisplayListener(this);
        this.zzb = null;
    }

    public final void zzb(zzxl zzxl) {
        this.zzb = zzxl;
        this.zza.registerDisplayListener(this, zzen.zzD((Handler.Callback) null));
        zzxr.zzb(zzxl.zza, zzd());
    }
}
