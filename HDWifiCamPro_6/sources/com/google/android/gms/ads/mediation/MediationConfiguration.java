package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class MediationConfiguration {
    public static final String CUSTOM_EVENT_SERVER_PARAMETER_FIELD = "parameter";
    private final AdFormat zza;
    private final Bundle zzb;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zza = adFormat;
        this.zzb = bundle;
    }

    public AdFormat getFormat() {
        return this.zza;
    }

    public Bundle getServerParameters() {
        return this.zzb;
    }
}
