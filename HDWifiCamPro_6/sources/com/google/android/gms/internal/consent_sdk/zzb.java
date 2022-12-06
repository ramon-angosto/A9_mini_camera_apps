package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzb {
    private final Application zza;

    public zzb(Application application) {
        this.zza = application;
    }

    public final zza zza() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
            return new zza(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            Log.d("UserMessagingPlatform", "Failed to get ad id.", e);
            return null;
        }
    }
}
