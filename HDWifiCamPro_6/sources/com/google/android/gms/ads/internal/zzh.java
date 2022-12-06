package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfoa;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzh implements zzfoa {
    final /* synthetic */ zzi zza;

    zzh(zzi zzi) {
        this.zza = zzi;
    }

    public final void zza(int i, long j) {
        this.zza.zzi.zzd(i, System.currentTimeMillis() - j);
    }

    public final void zzb(int i, long j, String str) {
        this.zza.zzi.zze(i, System.currentTimeMillis() - j, str);
    }
}
