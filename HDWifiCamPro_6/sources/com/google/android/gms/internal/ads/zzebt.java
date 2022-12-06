package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzebt implements zzgxi {
    private final zzgxv zza;

    public zzebt(zzgxv zzgxv) {
        this.zza = zzgxv;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = ((Context) this.zza.zzb()).getApplicationInfo();
        zzgxq.zzb(applicationInfo);
        return applicationInfo;
    }
}
