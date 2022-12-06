package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzbf extends WebViewClient {
    final /* synthetic */ zzbg zza;

    /* synthetic */ zzbf(zzbg zzbg, zzbe zzbe) {
        this.zza = zzbg;
    }

    public final void onLoadResource(WebView webView, String str) {
        if (zzbg.zzc(this.zza, str)) {
            this.zza.zzb.zzd(str);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (!this.zza.zzc) {
            Log.d("UserMessagingPlatform", "Wall html loaded.");
            boolean unused = this.zza.zzc = true;
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zza.zzb.zze(i, str, str2);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (!zzbg.zzc(this.zza, uri)) {
            return false;
        }
        this.zza.zzb.zzd(uri);
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!zzbg.zzc(this.zza, str)) {
            return false;
        }
        this.zza.zzb.zzd(str);
        return true;
    }
}
