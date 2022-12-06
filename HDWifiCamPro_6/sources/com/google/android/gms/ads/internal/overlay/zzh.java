package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcmp;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzh {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzh(zzcmp zzcmp) throws zzf {
        this.zzb = zzcmp.getLayoutParams();
        ViewParent parent = zzcmp.getParent();
        this.zzd = zzcmp.zzG();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzf("Could not get the parent of the WebView for an overlay.");
        }
        this.zzc = (ViewGroup) parent;
        this.zza = this.zzc.indexOfChild(zzcmp.zzH());
        this.zzc.removeView(zzcmp.zzH());
        zzcmp.zzap(true);
    }
}
