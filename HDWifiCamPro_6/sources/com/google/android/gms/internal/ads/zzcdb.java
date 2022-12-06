package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcdb implements MediationRewardedAdCallback {
    private final zzbvq zza;

    public zzcdb(zzbvq zzbvq) {
        this.zza = zzbvq;
    }

    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called onAdFailedToShow.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        zzcgp.zzj("Mediation ad failed to show: Error Code = " + code + ". Error Message = " + message + " Error Domain = " + domain);
        try {
            this.zza.zzk(adError.zza());
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called onUserEarnedReward.");
        try {
            this.zza.zzt(new zzcdc(rewardItem));
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called onVideoComplete.");
        try {
            this.zza.zzu();
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStart() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called onVideoStart.");
        try {
            this.zza.zzy();
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called reportAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called reportAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcgp.zze("Adapter called onAdFailedToShow.");
        zzcgp.zzj("Mediation ad failed to show: ".concat(String.valueOf(str)));
        try {
            this.zza.zzl(str);
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }
}
