package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zzcb implements ThreadFactory {
    public final /* synthetic */ zzcc zza;
    public final /* synthetic */ String zzb = "Google consent worker";

    public /* synthetic */ zzcb(zzcc zzcc, String str) {
        this.zza = zzcc;
    }

    public final Thread newThread(Runnable runnable) {
        return this.zza.zza(this.zzb, runnable);
    }
}
