package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzesl implements zzevd {
    private final boolean zza;

    public zzesl(boolean z) {
        this.zza = z;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        ((Bundle) obj).putBoolean("is_gbid", this.zza);
    }
}
