package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zzs implements Runnable {
    public final /* synthetic */ ConsentInformation.OnConsentInfoUpdateFailureListener zza;
    public final /* synthetic */ zzj zzb;

    public /* synthetic */ zzs(ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener, zzj zzj) {
        this.zza = onConsentInfoUpdateFailureListener;
        this.zzb = zzj;
    }

    public final void run() {
        this.zza.onConsentInfoUpdateFailure(this.zzb.zza());
    }
}
