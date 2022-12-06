package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbcm implements ValueCallback {
    public final /* synthetic */ zzbcn zza;
    public final /* synthetic */ zzbcf zzb;
    public final /* synthetic */ WebView zzc;
    public final /* synthetic */ boolean zzd;

    public /* synthetic */ zzbcm(zzbcn zzbcn, zzbcf zzbcf, WebView webView, boolean z) {
        this.zza = zzbcn;
        this.zzb = zzbcf;
        this.zzc = webView;
        this.zzd = z;
    }

    public final void onReceiveValue(Object obj) {
        zzbcn zzbcn = this.zza;
        zzbcf zzbcf = this.zzb;
        WebView webView = this.zzc;
        boolean z = this.zzd;
        zzbcn.zze.zzd(zzbcf, webView, (String) obj, z);
    }
}
