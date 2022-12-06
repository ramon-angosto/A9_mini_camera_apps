package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdyu {
    private final zzbqr zza;

    zzdyu(zzbqr zzbqr) {
        this.zza = zzbqr;
    }

    private final void zzs(zzdyt zzdyt) throws RemoteException {
        String zza2 = zzdyt.zza(zzdyt);
        zze.zzi("Dispatching AFMA event on publisher webview: ".concat(zza2));
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdyt("initialize", (zzdys) null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onAdClicked";
        this.zza.zzb(zzdyt.zza(zzdyt));
    }

    public final void zzc(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onAdClosed";
        zzs(zzdyt);
    }

    public final void zzd(long j, int i) throws RemoteException {
        zzdyt zzdyt = new zzdyt(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onAdFailedToLoad";
        zzdyt.zzd = Integer.valueOf(i);
        zzs(zzdyt);
    }

    public final void zze(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onAdLoaded";
        zzs(zzdyt);
    }

    public final void zzf(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdyt);
    }

    public final void zzg(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onAdOpened";
        zzs(zzdyt);
    }

    public final void zzh(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("creation", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "nativeObjectCreated";
        zzs(zzdyt);
    }

    public final void zzi(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("creation", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "nativeObjectNotCreated";
        zzs(zzdyt);
    }

    public final void zzj(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onAdClicked";
        zzs(zzdyt);
    }

    public final void zzk(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onRewardedAdClosed";
        zzs(zzdyt);
    }

    public final void zzl(long j, zzcci zzcci) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onUserEarnedReward";
        zzdyt.zze = zzcci.zzf();
        zzdyt.zzf = Integer.valueOf(zzcci.zze());
        zzs(zzdyt);
    }

    public final void zzm(long j, int i) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onRewardedAdFailedToLoad";
        zzdyt.zzd = Integer.valueOf(i);
        zzs(zzdyt);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onRewardedAdFailedToShow";
        zzdyt.zzd = Integer.valueOf(i);
        zzs(zzdyt);
    }

    public final void zzo(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onAdImpression";
        zzs(zzdyt);
    }

    public final void zzp(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onRewardedAdLoaded";
        zzs(zzdyt);
    }

    public final void zzq(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdyt);
    }

    public final void zzr(long j) throws RemoteException {
        zzdyt zzdyt = new zzdyt("rewarded", (zzdys) null);
        zzdyt.zza = Long.valueOf(j);
        zzdyt.zzc = "onRewardedAdOpened";
        zzs(zzdyt);
    }
}
