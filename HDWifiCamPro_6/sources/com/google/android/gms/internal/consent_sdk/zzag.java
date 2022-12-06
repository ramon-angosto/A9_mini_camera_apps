package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzag {
    private Application zza;

    private zzag() {
    }

    /* synthetic */ zzag(zzaf zzaf) {
    }

    public final zzd zza() {
        zzck.zzb(this.zza, Application.class);
        return new zzaj(this.zza, (zzaf) null);
    }

    public final zzag zzb(Application application) {
        if (application != null) {
            this.zza = application;
            return this;
        }
        throw null;
    }
}
