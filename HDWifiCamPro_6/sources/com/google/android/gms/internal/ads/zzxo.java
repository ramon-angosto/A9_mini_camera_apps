package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzxo implements zzxn {
    private final WindowManager zza;

    private zzxo(WindowManager windowManager) {
        this.zza = windowManager;
    }

    public static zzxn zzc(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return new zzxo(windowManager);
        }
        return null;
    }

    public final void zza() {
    }

    public final void zzb(zzxl zzxl) {
        zzxr.zzb(zzxl.zza, this.zza.getDefaultDisplay());
    }
}
