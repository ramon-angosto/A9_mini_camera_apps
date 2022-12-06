package com.google.android.ump;

import android.app.Activity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public interface ConsentInformation {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    public @interface ConsentStatus {
        public static final int NOT_REQUIRED = 1;
        public static final int OBTAINED = 3;
        public static final int REQUIRED = 2;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    public interface OnConsentInfoUpdateFailureListener {
        void onConsentInfoUpdateFailure(FormError formError);
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    public interface OnConsentInfoUpdateSuccessListener {
        void onConsentInfoUpdateSuccess();
    }

    int getConsentStatus();

    boolean isConsentFormAvailable();

    void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener);

    void reset();
}
