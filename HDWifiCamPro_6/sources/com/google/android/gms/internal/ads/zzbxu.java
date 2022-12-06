package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbxu implements MediationInterstitialAdapter {
    /* access modifiers changed from: private */
    public Activity zza;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzb;
    private Uri zzc;

    public final void onDestroy() {
        zzcgp.zze("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzcgp.zze("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzcgp.zze("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzb = mediationInterstitialListener;
        if (this.zzb == null) {
            zzcgp.zzj("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzcgp.zzj("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else if (!zzbka.zzg(context)) {
            zzcgp.zzj("Default browser does not support custom tabs. Bailing out.");
            this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else {
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzcgp.zzj("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            this.zza = (Activity) context;
            this.zzc = Uri.parse(string);
            this.zzb.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.zzc);
        zzs.zza.post(new zzbxt(this, new AdOverlayInfoParcel(new zzc(build.intent, (zzx) null), (zza) null, new zzbxs(this), (zzz) null, new zzcgv(0, 0, false, false, false), (zzcmp) null, (zzdkn) null)));
        zzt.zzo().zzo();
    }
}
