package com.google.android.gms.ads.nonagon.signalgeneration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.internal.ads.zzape;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzdxl;
import com.google.android.gms.internal.ads.zzdxv;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class TaggingLibraryJsInterface {
    private final Context zza;
    /* access modifiers changed from: private */
    public final WebView zzb;
    private final zzape zzc;
    private final int zzd = ((Integer) zzay.zzc().zzb(zzbjc.zzid)).intValue();
    private final zzdxv zze;
    private final boolean zzf = ((Boolean) zzay.zzc().zzb(zzbjc.zzie)).booleanValue();

    TaggingLibraryJsInterface(WebView webView, zzape zzape, zzdxv zzdxv) {
        this.zzb = webView;
        this.zza = webView.getContext();
        this.zzc = zzape;
        this.zze = zzdxv;
        zzbjc.zzc(this.zza);
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        try {
            long currentTimeMillis = zzt.zzB().currentTimeMillis();
            String zze2 = this.zzc.zzc().zze(this.zza, str, this.zzb);
            if (this.zzf) {
                long currentTimeMillis2 = zzt.zzB().currentTimeMillis() - currentTimeMillis;
                zzf.zzc(this.zze, (zzdxl) null, "csg", new Pair("clat", String.valueOf(currentTimeMillis2)));
            }
            return zze2;
        } catch (RuntimeException e) {
            zze.zzh("Exception getting click signals. ", e);
            zzt.zzo().zzt(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getClickSignalsWithTimeout(String str, int i) {
        if (i <= 0) {
            zze.zzg("Invalid timeout for getting click signals. Timeout=" + i);
            return "";
        }
        int min = Math.min(i, this.zzd);
        try {
            return (String) zzchc.zza.zzb(new zzao(this, str)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zze.zzh("Exception getting click signals with timeout. ", e);
            zzt.zzo().zzt(e, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        Context context = this.zza;
        AdFormat adFormat = AdFormat.BANNER;
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        QueryInfo.generate(context, adFormat, builder.build(), new zzap(this, uuid));
        return uuid;
    }

    @JavascriptInterface
    public String getViewSignals() {
        try {
            long currentTimeMillis = zzt.zzB().currentTimeMillis();
            String zzh = this.zzc.zzc().zzh(this.zza, this.zzb, (Activity) null);
            if (this.zzf) {
                long currentTimeMillis2 = zzt.zzB().currentTimeMillis() - currentTimeMillis;
                zzf.zzc(this.zze, (zzdxl) null, "vsg", new Pair("vlat", String.valueOf(currentTimeMillis2)));
            }
            return zzh;
        } catch (RuntimeException e) {
            zze.zzh("Exception getting view signals. ", e);
            zzt.zzo().zzt(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getViewSignalsWithTimeout(int i) {
        if (i <= 0) {
            zze.zzg("Invalid timeout for getting view signals. Timeout=" + i);
            return "";
        }
        int min = Math.min(i, this.zzd);
        try {
            return (String) zzchc.zza.zzb(new zzan(this)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zze.zzh("Exception getting view signals with timeout. ", e);
            zzt.zzo().zzt(e, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    public void reportTouchEvent(String str) {
        int i;
        int i2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("x");
            int i4 = jSONObject.getInt("y");
            int i5 = jSONObject.getInt("duration_ms");
            float f = (float) jSONObject.getDouble("force");
            int i6 = jSONObject.getInt("type");
            if (i6 != 0) {
                if (i6 == 1) {
                    i = 1;
                } else if (i6 == 2) {
                    i = 2;
                } else if (i6 != 3) {
                    i2 = -1;
                } else {
                    i = 3;
                }
                this.zzc.zzd(MotionEvent.obtain(0, (long) i5, i, (float) i3, (float) i4, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            }
            i2 = 0;
            i = i2;
            try {
                this.zzc.zzd(MotionEvent.obtain(0, (long) i5, i, (float) i3, (float) i4, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException | JSONException e) {
                e = e;
                zze.zzh("Failed to parse the touch string. ", e);
                zzt.zzo().zzt(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException | JSONException e2) {
            e = e2;
            zze.zzh("Failed to parse the touch string. ", e);
            zzt.zzo().zzt(e, "TaggingLibraryJsInterface.reportTouchEvent");
        }
    }
}
