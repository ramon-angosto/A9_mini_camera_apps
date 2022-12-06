package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzed.zzf().zzl(context);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzed.zzf().zze();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzed.zzf().zzc();
    }

    public static VersionInfo getVersion() {
        zzed.zzf();
        String[] split = TextUtils.split("21.3.0", "\\.");
        if (split.length != 3) {
            return new VersionInfo(0, 0, 0);
        }
        try {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        } catch (NumberFormatException unused) {
            return new VersionInfo(0, 0, 0);
        }
    }

    @Deprecated
    public static String getVersionString() {
        return zzed.zzf().zzh();
    }

    public static void initialize(Context context) {
        zzed.zzf().zzm(context, (String) null, (OnInitializationCompleteListener) null);
    }

    public static void openAdInspector(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzed.zzf().zzp(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(Context context, String str) {
        zzed.zzf().zzq(context, str);
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzed.zzf().zzr(cls);
    }

    public static void registerWebView(WebView webView) {
        zzed.zzf();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (webView == null) {
            zzcgp.zzg("The webview to be registered cannot be null.");
            return;
        }
        zzcfg zza = zzbzt.zza(webView.getContext());
        if (zza == null) {
            zzcgp.zzj("Internal error, query info generator is null.");
            return;
        }
        try {
            zza.zzi(ObjectWrapper.wrap(webView));
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public static void setAppMuted(boolean z) {
        zzed.zzf().zzs(z);
    }

    public static void setAppVolume(float f) {
        zzed.zzf().zzt(f);
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzed.zzf().zzu(requestConfiguration);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzed.zzf().zzm(context, (String) null, onInitializationCompleteListener);
    }
}
