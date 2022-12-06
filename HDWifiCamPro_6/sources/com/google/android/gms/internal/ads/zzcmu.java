package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcmu implements zzfzc {
    final /* synthetic */ List zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Uri zzc;
    final /* synthetic */ zzcmw zzd;

    zzcmu(zzcmw zzcmw, List list, String str, Uri uri) {
        this.zzd = zzcmw;
        this.zza = list;
        this.zzb = str;
        this.zzc = uri;
    }

    public final void zza(Throwable th) {
        zze.zzj("Failed to parse gmsg params for: ".concat(String.valueOf(String.valueOf(this.zzc))));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzO((Map) obj, this.zza, this.zzb);
    }
}
