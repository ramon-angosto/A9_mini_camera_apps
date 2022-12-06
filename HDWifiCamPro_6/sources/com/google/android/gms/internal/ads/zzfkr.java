package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfkr {
    public abstract void zzb(View view, zzfkx zzfkx, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();

    public static zzfkr zza(zzfks zzfks, zzfkt zzfkt) {
        if (zzfkp.zzb()) {
            return new zzfkv(zzfks, zzfkt);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}
