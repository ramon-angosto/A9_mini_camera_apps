package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzn {
    /* access modifiers changed from: private */
    public final Application zza;
    /* access modifiers changed from: private */
    public final zzb zzb;
    /* access modifiers changed from: private */
    public final zzam zzc;

    zzn(Application application, zzb zzb2, zzam zzam) {
        this.zza = application;
        this.zzb = zzb2;
        this.zzc = zzam;
    }

    /* access modifiers changed from: package-private */
    public final zzbu zzd(Activity activity, ConsentRequestParameters consentRequestParameters) throws zzj {
        ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
        if (consentDebugSettings == null) {
            consentDebugSettings = new ConsentDebugSettings.Builder(this.zza).build();
        }
        return zzo.zza(new zzo(this, activity, consentDebugSettings, consentRequestParameters, (zzm) null));
    }
}
