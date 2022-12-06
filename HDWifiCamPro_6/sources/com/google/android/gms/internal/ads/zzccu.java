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
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzccu extends RewardedAd {
    private final String zza;
    private final zzccl zzb;
    private final Context zzc;
    private final zzcdd zzd = new zzcdd();
    private OnAdMetadataChangedListener zze;
    private OnPaidEventListener zzf;
    private FullScreenContentCallback zzg;

    public zzccu(Context context, String str) {
        this.zzc = context.getApplicationContext();
        this.zza = str;
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
        return this.zzg;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zze;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzf;
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
            if (zzd2 == null) {
                return RewardItem.DEFAULT_REWARD;
            }
            return new zzccv(zzd2);
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            return RewardItem.DEFAULT_REWARD;
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzg = fullScreenContentCallback;
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
        try {
            this.zze = onAdMetadataChangedListener;
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzi(new zzex(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzf = onPaidEventListener;
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzj(new zzey(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions != null) {
            try {
                zzccl zzccl = this.zzb;
                if (zzccl != null) {
                    zzccl.zzl(new zzccz(serverSideVerificationOptions));
                }
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            zzcgp.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
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

    public final void zza(zzdr zzdr, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzccl zzccl = this.zzb;
            if (zzccl != null) {
                zzccl.zzf(zzp.zza.zza(this.zzc, zzdr), new zzccy(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }
}
