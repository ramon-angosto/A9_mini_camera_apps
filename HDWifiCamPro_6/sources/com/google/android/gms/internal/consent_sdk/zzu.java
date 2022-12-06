package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zzu implements Runnable {
    public final /* synthetic */ ConsentInformation.OnConsentInfoUpdateSuccessListener zza;

    public /* synthetic */ zzu(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        this.zza = onConsentInfoUpdateSuccessListener;
    }

    public final void run() {
        this.zza.onConsentInfoUpdateSuccess();
    }
}
