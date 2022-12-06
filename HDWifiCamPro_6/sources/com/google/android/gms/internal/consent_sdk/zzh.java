package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzh {
    private final Executor zza;

    zzh(Executor executor) {
        this.zza = executor;
    }

    public final Executor zza() {
        return this.zza;
    }

    public final void zzb(String str, String str2, zzg... zzgArr) {
        this.zza.execute(new zze(str, str2, zzgArr));
    }
}
