package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzfls {
    private zzfmq zza = new zzfmq((WebView) null);
    private long zzb;
    private int zzc;

    public zzfls() {
        zzb();
    }

    public final WebView zza() {
        return (WebView) this.zza.get();
    }

    public final void zzb() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }

    public void zzc() {
        this.zza.clear();
    }

    public final void zzd(String str, long j) {
        if (j >= this.zzb && this.zzc != 3) {
            this.zzc = 3;
            zzfll.zza().zzf(zza(), str);
        }
    }

    public final void zze(String str, long j) {
        if (j >= this.zzb) {
            this.zzc = 2;
            zzfll.zza().zzf(zza(), str);
        }
    }

    public void zzf(zzfkv zzfkv, zzfkt zzfkt) {
        zzg(zzfkv, zzfkt, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public final void zzg(zzfkv zzfkv, zzfkt zzfkt, JSONObject jSONObject) {
        String zzh = zzfkv.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzflw.zzh(jSONObject2, "environment", "app");
        zzflw.zzh(jSONObject2, "adSessionType", zzfkt.zzd());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        zzflw.zzh(jSONObject3, "deviceType", str + "; " + str2);
        zzflw.zzh(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzflw.zzh(jSONObject3, "os", "Android");
        zzflw.zzh(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzflw.zzh(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzflw.zzh(jSONObject4, "partnerName", zzfkt.zze().zzb());
        zzflw.zzh(jSONObject4, "partnerVersion", zzfkt.zze().zzc());
        zzflw.zzh(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzflw.zzh(jSONObject5, "libraryVersion", "1.3.31-google_20220407");
        zzflw.zzh(jSONObject5, "appId", zzflj.zzb().zza().getApplicationContext().getPackageName());
        zzflw.zzh(jSONObject2, "app", jSONObject5);
        if (zzfkt.zzf() != null) {
            zzflw.zzh(jSONObject2, "contentUrl", zzfkt.zzf());
        }
        zzflw.zzh(jSONObject2, "customReferenceData", zzfkt.zzg());
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzfkt.zzh().iterator();
        if (!it.hasNext()) {
            zzfll.zza().zzg(zza(), zzh, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzflb zzflb = (zzflb) it.next();
            throw null;
        }
    }

    public final void zzh(float f) {
        zzfll.zza().zze(zza(), f);
    }

    /* access modifiers changed from: package-private */
    public final void zzi(WebView webView) {
        this.zza = new zzfmq(webView);
    }

    public void zzj() {
    }

    public final boolean zzk() {
        return this.zza.get() != null;
    }
}
