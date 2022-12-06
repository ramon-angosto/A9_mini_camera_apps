package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdqe implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ View zza;
    public final /* synthetic */ zzcmp zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ WindowManager.LayoutParams zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ WindowManager zzf;

    public /* synthetic */ zzdqe(View view, zzcmp zzcmp, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.zza = view;
        this.zzb = zzcmp;
        this.zzc = str;
        this.zzd = layoutParams;
        this.zze = i;
        this.zzf = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zza;
        zzcmp zzcmp = this.zzb;
        String str = this.zzc;
        WindowManager.LayoutParams layoutParams = this.zzd;
        int i = this.zze;
        WindowManager windowManager = this.zzf;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzcmp.zzH().getWindowToken() != null) {
            if ("1".equals(str) || "2".equals(str)) {
                layoutParams.y = rect.bottom - i;
            } else {
                layoutParams.y = rect.top - i;
            }
            windowManager.updateViewLayout(zzcmp.zzH(), layoutParams);
        }
    }
}
