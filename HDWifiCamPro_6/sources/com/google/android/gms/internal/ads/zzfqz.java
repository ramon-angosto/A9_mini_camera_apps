package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfqz extends zzfrl {
    final /* synthetic */ zzfra zza;
    private final zzfrf zzb;

    zzfqz(zzfra zzfra, zzfrf zzfrf) {
        this.zza = zzfra;
        this.zzb = zzfrf;
    }

    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfrd zzc = zzfre.zzc();
        zzc.zzb(i);
        if (string != null) {
            zzc.zza(string);
        }
        this.zzb.zza(zzc.zzc());
        if (i == 8157) {
            this.zza.zzc();
        }
    }
}
