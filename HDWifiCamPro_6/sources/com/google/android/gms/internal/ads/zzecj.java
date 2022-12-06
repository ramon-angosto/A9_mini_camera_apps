package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzecj implements zzfzc {
    final /* synthetic */ zzeck zza;

    zzecj(zzeck zzeck) {
        this.zza = zzeck;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue()) {
            Matcher matcher = zzeck.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfdw zzfdw = (zzfdw) obj;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue()) {
            this.zza.zzf.zzi(zzfdw.zzb.zzb.zze);
            this.zza.zzf.zzj(zzfdw.zzb.zzb.zzf);
        }
    }
}
