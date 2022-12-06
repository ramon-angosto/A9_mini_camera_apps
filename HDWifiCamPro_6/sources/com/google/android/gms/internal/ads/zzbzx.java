package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbzx extends zzbzq {
    final /* synthetic */ List zza;

    zzbzx(zzbzz zzbzz, List list) {
        this.zza = list;
    }

    public final void zze(String str) {
        zzcgp.zzg("Error recording click: ".concat(String.valueOf(str)));
    }

    public final void zzf(List list) {
        zzcgp.zzi("Recorded click: ".concat(this.zza.toString()));
    }
}
