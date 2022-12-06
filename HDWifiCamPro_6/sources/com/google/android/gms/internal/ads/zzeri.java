package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeri implements zzevd {
    public final double zza;
    public final boolean zzb;

    public zzeri(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfeq.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfeq.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}
