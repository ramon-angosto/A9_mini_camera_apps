package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbxj implements MediationAdLoadCallback {
    final /* synthetic */ zzbwr zza;
    final /* synthetic */ zzbvq zzb;

    zzbxj(zzbxo zzbxo, zzbwr zzbwr, zzbvq zzbvq) {
        this.zza = zzbwr;
        this.zzb = zzbvq;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationInterscrollerAd mediationInterscrollerAd = (MediationInterscrollerAd) obj;
        if (mediationInterscrollerAd == null) {
            zzcgp.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zza.zze("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzcgp.zzh("", e);
                return null;
            }
        } else {
            try {
                this.zza.zzh(new zzbwk(mediationInterscrollerAd));
            } catch (RemoteException e2) {
                zzcgp.zzh("", e2);
            }
            return new zzbxp(this.zzb);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }
}
