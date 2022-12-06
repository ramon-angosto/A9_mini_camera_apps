package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzk implements ConsentInformation {
    private final zzam zza;
    private final zzv zzb;
    private final zzba zzc;

    public zzk(zzam zzam, zzv zzv, zzba zzba) {
        this.zza = zzam;
        this.zzb = zzv;
        this.zzc = zzba;
    }

    public final int getConsentStatus() {
        return this.zza.zza();
    }

    public final boolean isConsentFormAvailable() {
        return this.zzc.zzc();
    }

    public final void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzb.zzc(activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener);
    }

    public final void reset() {
        this.zzc.zzb((zzbc) null);
        this.zza.zzd();
    }
}
