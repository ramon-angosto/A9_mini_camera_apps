package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzaz;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbsm extends AdManagerInterstitialAd {
    private final Context zza;
    private final zzp zzb;
    private final zzbs zzc;
    private final String zzd;
    private final zzbvh zze = new zzbvh();
    private AppEventListener zzf;
    private FullScreenContentCallback zzg;
    private OnPaidEventListener zzh;

    public zzbsm(Context context, String str) {
        this.zza = context;
        this.zzd = str;
        this.zzb = zzp.zza;
        this.zzc = zzaw.zza().zze(context, new zzq(), str, this.zze);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzf;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzh;
    }

    public final ResponseInfo getResponseInfo() {
        zzdh zzdh = null;
        try {
            zzbs zzbs = this.zzc;
            if (zzbs != null) {
                zzdh = zzbs.zzk();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzb(zzdh);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzf = appEventListener;
            zzbs zzbs = this.zzc;
            if (zzbs != null) {
                zzbs.zzG(appEventListener != null ? new zzbce(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzg = fullScreenContentCallback;
            zzbs zzbs = this.zzc;
            if (zzbs != null) {
                zzbs.zzJ(new zzaz(fullScreenContentCallback));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzbs zzbs = this.zzc;
            if (zzbs != null) {
                zzbs.zzL(z);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzh = onPaidEventListener;
            zzbs zzbs = this.zzc;
            if (zzbs != null) {
                zzbs.zzP(new zzey(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity) {
        if (activity == null) {
            zzcgp.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzbs zzbs = this.zzc;
            if (zzbs != null) {
                zzbs.zzW(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzdr zzdr, AdLoadCallback adLoadCallback) {
        try {
            zzbs zzbs = this.zzc;
            if (zzbs != null) {
                zzbs.zzy(this.zzb.zza(this.zza, zzdr), new zzh(adLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, (AdError) null, (ResponseInfo) null));
        }
    }
}
