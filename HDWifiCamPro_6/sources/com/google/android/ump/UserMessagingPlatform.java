package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzd;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class UserMessagingPlatform {

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    public interface OnConsentFormLoadFailureListener {
        void onConsentFormLoadFailure(FormError formError);
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    public interface OnConsentFormLoadSuccessListener {
        void onConsentFormLoadSuccess(ConsentForm consentForm);
    }

    private UserMessagingPlatform() {
    }

    public static ConsentInformation getConsentInformation(Context context) {
        return zzd.zza(context).zzb();
    }

    public static void loadConsentForm(Context context, OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzd.zza(context).zzc().zza(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
    }
}
