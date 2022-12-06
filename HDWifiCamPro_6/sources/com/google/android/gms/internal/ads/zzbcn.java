package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbcn implements Runnable {
    final ValueCallback zza = new zzbcm(this, this.zzb, this.zzc, this.zzd);
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzbcp zze;

    zzbcn(zzbcp zzbcp, zzbcf zzbcf, WebView webView, boolean z) {
        this.zze = zzbcp;
        this.zzb = zzbcf;
        this.zzc = webView;
        this.zzd = z;
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
