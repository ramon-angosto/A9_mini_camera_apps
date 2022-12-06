package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfkt {
    private final zzfla zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzfku zzg;

    private zzfkt(zzfla zzfla, WebView webView, String str, List list, String str2, String str3, zzfku zzfku) {
        this.zza = zzfla;
        this.zzb = webView;
        this.zzg = zzfku;
        this.zzf = str2;
        this.zze = "";
    }

    public static zzfkt zzb(zzfla zzfla, WebView webView, String str, String str2) {
        return new zzfkt(zzfla, webView, (String) null, (List) null, str, "", zzfku.HTML);
    }

    public static zzfkt zzc(zzfla zzfla, WebView webView, String str, String str2) {
        return new zzfkt(zzfla, webView, (String) null, (List) null, str, "", zzfku.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfku zzd() {
        return this.zzg;
    }

    public final zzfla zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
