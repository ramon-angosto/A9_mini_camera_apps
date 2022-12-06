package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzex;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcdf extends RewardedInterstitialAd {
    private final String zza;
    private final zzccl zzb;
    private final Context zzc;
    private final zzcdd zzd = new zzcdd();
    private FullScreenContentCallback zze;
    private OnAdMetadataChangedListener zzf;
    private OnPaidEventListener zzg;

    public zzcdf(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = zzaw.zza().zzp(context, str, new zzbvh());
    }

    public final Bundle getAdMetadata() {
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                return zzccl.zzb();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    public final ResponseInfo getResponseInfo() {
        zzdh zzdh = null;
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzdh = zzccl.zzc();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzb(zzdh);
    }

    public final RewardItem getRewardItem() {
        try {
            zzccl zzccl = this.zzb;
            zzcci zzd2 = zzccl != null ? zzccl.zzd() : null;
            if (zzd2 != null) {
                return new zzccv(zzd2);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzh(z);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzi(new zzex(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzj(new zzey(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzl(new zzccz(serverSideVerificationOptions));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzk(this.zzd);
                this.zzb.zzm(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzdr zzdr, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzg(zzp.zza.zza(this.zzc, zzdr), new zzcde(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }
}
