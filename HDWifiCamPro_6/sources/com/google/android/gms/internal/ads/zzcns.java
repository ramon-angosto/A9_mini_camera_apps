package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzcns extends zzcmw {
    public zzcns(zzcmp zzcmp, zzbep zzbep, boolean z) {
        super(zzcmp, zzbep, z);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzM(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcmp)) {
            zze.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcmp zzcmp = (zzcmp) webView;
        zzcdq zzcdq = this.zza;
        if (zzcdq != null) {
            zzcdq.zzd(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcmp.zzP() != null) {
            zzcmp.zzP().zzD();
        }
        if (zzcmp.zzQ().zzi()) {
            str2 = (String) zzay.zzc().zzb(zzbjc.zzM);
        } else if (zzcmp.zzaC()) {
            str2 = (String) zzay.zzc().zzb(zzbjc.zzL);
        } else {
            str2 = (String) zzay.zzc().zzb(zzbjc.zzK);
        }
        zzt.zzp();
        return zzs.zzu(zzcmp.getContext(), zzcmp.zzp().zza, str2);
    }
}
