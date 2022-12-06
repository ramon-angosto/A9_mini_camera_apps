package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcnp {
    private final zzcnq zza;
    private final zzcno zzb;

    public zzcnp(zzcnq zzcnq, zzcno zzcno, byte[] bArr) {
        this.zzb = zzcno;
        this.zza = zzcnq;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcnq, com.google.android.gms.internal.ads.zzcnx] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ? r0 = this.zza;
        zzape zzK = r0.zzK();
        if (zzK == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzapa zzc = zzK.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            Context context = this.zza.getContext();
            zzcnq zzcnq = this.zza;
            return zzc.zzf(context, str, (View) zzcnq, zzcnq.zzk());
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzcnq, com.google.android.gms.internal.ads.zzcnx] */
    @JavascriptInterface
    public String getViewSignals() {
        ? r0 = this.zza;
        zzape zzK = r0.zzK();
        if (zzK == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzapa zzc = zzK.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            Context context = this.zza.getContext();
            zzcnq zzcnq = this.zza;
            return zzc.zzh(context, (View) zzcnq, zzcnq.zzk());
        }
    }

    @JavascriptInterface
    public void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zzj("URL is empty, ignoring message");
        } else {
            zzs.zza.post(new zzcnn(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        zzcno zzcno = this.zzb;
        Uri parse = Uri.parse(str);
        zzcmw zzaL = ((zzcni) zzcno.zza).zzaL();
        if (zzaL == null) {
            zze.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaL.zzi(parse);
        }
    }
}
