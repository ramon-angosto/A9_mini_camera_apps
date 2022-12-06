package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzakh;
import com.google.android.gms.internal.ads.zzakm;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbh implements zzakh {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbl zzb;

    zzbh(zzbo zzbo, String str, zzbl zzbl) {
        this.zza = str;
        this.zzb = zzbl;
    }

    public final void zza(zzakm zzakm) {
        String str = this.zza;
        String zzakm2 = zzakm.toString();
        zze.zzj("Failed to load URL: " + str + "\n" + zzakm2);
        this.zzb.zza((Object) null);
    }
}
