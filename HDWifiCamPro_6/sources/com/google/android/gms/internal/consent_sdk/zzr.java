package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zzr implements Runnable {
    public final /* synthetic */ zzv zza;
    public final /* synthetic */ ConsentInformation.OnConsentInfoUpdateSuccessListener zzb;

    public /* synthetic */ zzr(zzv zzv, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        this.zza = zzv;
        this.zzb = onConsentInfoUpdateSuccessListener;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
