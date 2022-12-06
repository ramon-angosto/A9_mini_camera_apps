package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbzw extends zzbzq {
    final /* synthetic */ List zza;

    zzbzw(zzbzz zzbzz, List list) {
        this.zza = list;
    }

    public final void zze(String str) {
        zzcgp.zzg("Error recording impression urls: ".concat(String.valueOf(str)));
    }

    public final void zzf(List list) {
        zzcgp.zzi("Recorded impression urls: ".concat(this.zza.toString()));
    }
}
