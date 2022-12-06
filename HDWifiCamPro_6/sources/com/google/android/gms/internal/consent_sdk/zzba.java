package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.UserMessagingPlatform;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzba {
    private final zzcl<zzas> zza;
    private final AtomicReference<zzbc> zzb = new AtomicReference<>();

    zzba(zzcl<zzas> zzcl) {
        this.zza = zzcl;
    }

    public final void zza(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzcd.zza();
        zzbc zzbc = this.zzb.get();
        if (zzbc == null) {
            onConsentFormLoadFailureListener.onConsentFormLoadFailure(new zzj(3, "No available form can be built.").zza());
            return;
        }
        zzas zzb2 = this.zza.zzb();
        zzb2.zza(zzbc);
        zzb2.zzb().zza().zzb(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
    }

    public final void zzb(zzbc zzbc) {
        this.zzb.set(zzbc);
    }

    public final boolean zzc() {
        return this.zzb.get() != null;
    }
}
