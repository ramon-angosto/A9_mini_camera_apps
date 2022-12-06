package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcwd {
    private final zzfir zza;
    private final zzdxq zzb;
    private final zzfdw zzc;

    public zzcwd(zzdxq zzdxq, zzfdw zzfdw, zzfir zzfir) {
        this.zza = zzfir;
        this.zzb = zzdxq;
        this.zzc = zzfdw;
    }

    private static String zzb(int i) {
        int i2 = i - 1;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h";
    }

    public final void zza(long j, int i) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue()) {
            zzfir zzfir = this.zza;
            zzfiq zzb2 = zzfiq.zzb("ad_closed");
            zzb2.zzg(this.zzc.zzb.zzb);
            zzb2.zza("show_time", String.valueOf(j));
            zzb2.zza("ad_format", "app_open_ad");
            zzb2.zza("acr", zzb(i));
            zzfir.zzb(zzb2);
            return;
        }
        zzdxp zza2 = this.zzb.zza();
        zza2.zze(this.zzc.zzb.zzb);
        zza2.zzb("action", "ad_closed");
        zza2.zzb("show_time", String.valueOf(j));
        zza2.zzb("ad_format", "app_open_ad");
        zza2.zzb("acr", zzb(i));
        zza2.zzg();
    }
}
