package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzflv extends zzfls {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzflv(Map map, String str) {
        this.zzc = map;
    }

    public final void zzc() {
        long j;
        super.zzc();
        if (this.zzb == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzflu(this), Math.max(4000 - j, 2000));
        this.zza = null;
    }

    public final void zzf(zzfkv zzfkv, zzfkt zzfkt) {
        JSONObject jSONObject = new JSONObject();
        Map zzi = zzfkt.zzi();
        for (String str : zzi.keySet()) {
            zzflw.zzh(jSONObject, str, (zzflb) zzi.get(str));
        }
        zzg(zzfkv, zzfkt, jSONObject);
    }

    public final void zzj() {
        this.zza = new WebView(zzflj.zzb().zza());
        this.zza.getSettings().setJavaScriptEnabled(true);
        zzi(this.zza);
        WebView webView = this.zza;
        if (webView != null && !TextUtils.isEmpty((CharSequence) null)) {
            webView.loadUrl("javascript: null");
        }
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzflb zzflb = (zzflb) this.zzc.get((String) it.next());
        throw null;
    }
}
