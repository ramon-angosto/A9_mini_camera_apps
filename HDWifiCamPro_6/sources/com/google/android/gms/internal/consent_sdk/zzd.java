package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public abstract class zzd {
    private static zzd zza;

    public static zzd zza(Context context) {
        zzd zzd;
        synchronized (zzd.class) {
            if (zza == null) {
                zzag zzag = new zzag((zzaf) null);
                zzag.zzb((Application) context.getApplicationContext());
                zza = zzag.zza();
            }
            zzd = zza;
        }
        return zzd;
    }

    public abstract zzk zzb();

    public abstract zzba zzc();
}
