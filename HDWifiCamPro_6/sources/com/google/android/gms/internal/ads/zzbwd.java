package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbwd implements MediationAdLoadCallback {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ Adapter zzb;
    final /* synthetic */ zzbwj zzc;

    zzbwd(zzbwj zzbwj, zzbvq zzbvq, Adapter adapter) {
        this.zzc = zzbwj;
        this.zza = zzbvq;
        this.zzb = adapter;
    }

    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzb.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            zzcgp.zze(canonicalName + "failed to load mediation ad: ErrorCode = " + code + ". ErrorMessage = " + message + ". ErrorDomain = " + domain);
            this.zza.zzh(adError.zza());
            this.zza.zzi(adError.getCode(), adError.getMessage());
            this.zza.zzg(adError.getCode());
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        try {
            this.zzc.zzi = (MediationInterscrollerAd) obj;
            this.zza.zzo();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
        return new zzbwb(this.zza);
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }
}
