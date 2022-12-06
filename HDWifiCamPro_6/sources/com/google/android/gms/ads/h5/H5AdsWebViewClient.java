package com.google.android.gms.ads.h5;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbqn;
import com.google.android.gms.internal.ads.zzbra;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class H5AdsWebViewClient extends zzbqn {
    private final zzbra zza;

    public H5AdsWebViewClient(Context context, WebView webView) {
        this.zza = new zzbra(context, webView);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    /* access modifiers changed from: protected */
    public WebViewClient getDelegate() {
        return this.zza;
    }

    public WebViewClient getDelegateWebViewClient() {
        return this.zza.getDelegate();
    }

    public void setDelegateWebViewClient(WebViewClient webViewClient) {
        this.zza.zzb(webViewClient);
    }
}
