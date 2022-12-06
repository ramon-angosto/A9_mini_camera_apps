package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeew implements zzdjt {
    private boolean zza = false;
    private boolean zzb = false;
    private final String zzc;
    private final zzfir zzd;
    private final zzg zze;

    public zzeew(String str, zzfir zzfir) {
        this.zzc = str;
        this.zzd = zzfir;
        this.zze = zzt.zzo().zzh();
    }

    private final zzfiq zzg(String str) {
        String str2;
        if (this.zze.zzP()) {
            str2 = "";
        } else {
            str2 = this.zzc;
        }
        zzfiq zzb2 = zzfiq.zzb(str);
        zzb2.zza("tms", Long.toString(zzt.zzB().elapsedRealtime(), 10));
        zzb2.zza("tid", str2);
        return zzb2;
    }

    public final void zza(String str) {
        zzfir zzfir = this.zzd;
        zzfiq zzg = zzg("aaia");
        zzg.zza("aair", "MalformedJson");
        zzfir.zzb(zzg);
    }

    public final void zzb(String str, String str2) {
        zzfir zzfir = this.zzd;
        zzfiq zzg = zzg("adapter_init_finished");
        zzg.zza("ancn", str);
        zzg.zza("rqe", str2);
        zzfir.zzb(zzg);
    }

    public final void zzc(String str) {
        zzfir zzfir = this.zzd;
        zzfiq zzg = zzg("adapter_init_started");
        zzg.zza("ancn", str);
        zzfir.zzb(zzg);
    }

    public final void zzd(String str) {
        zzfir zzfir = this.zzd;
        zzfiq zzg = zzg("adapter_init_finished");
        zzg.zza("ancn", str);
        zzfir.zzb(zzg);
    }

    public final synchronized void zze() {
        if (!this.zzb) {
            this.zzd.zzb(zzg("init_finished"));
            this.zzb = true;
        }
    }

    public final synchronized void zzf() {
        if (!this.zza) {
            this.zzd.zzb(zzg("init_started"));
            this.zza = true;
        }
    }
}
