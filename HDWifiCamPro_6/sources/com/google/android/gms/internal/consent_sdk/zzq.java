package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zzq implements Runnable {
    public final /* synthetic */ zzv zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ ConsentRequestParameters zzc;
    public final /* synthetic */ ConsentInformation.OnConsentInfoUpdateSuccessListener zzd;
    public final /* synthetic */ ConsentInformation.OnConsentInfoUpdateFailureListener zze;

    public /* synthetic */ zzq(zzv zzv, Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zza = zzv;
        this.zzb = activity;
        this.zzc = consentRequestParameters;
        this.zzd = onConsentInfoUpdateSuccessListener;
        this.zze = onConsentInfoUpdateFailureListener;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
