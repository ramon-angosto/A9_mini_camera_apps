package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzera implements zzeve {
    private static final Object zza = new Object();
    private final String zzb;
    private final String zzc;
    private final zzdar zzd;
    private final zzffk zze;
    private final zzfef zzf;
    private final zzg zzg = zzt.zzo().zzh();
    private final zzdxl zzh;

    public zzera(String str, String str2, zzdar zzdar, zzffk zzffk, zzfef zzfef, zzdxl zzdxl) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzdar;
        this.zze = zzffk;
        this.zzf = zzfef;
        this.zzh = zzdxl;
    }

    public final int zza() {
        return 12;
    }

    public final zzfzp zzb() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgD)).booleanValue()) {
            this.zzh.zza().put("seq_num", this.zzb);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeH)).booleanValue()) {
            this.zzd.zzg(this.zzf.zzd);
            bundle.putAll(this.zze.zzb());
        }
        return zzfzg.zzi(new zzeqz(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeH)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzeG)).booleanValue()) {
                synchronized (zza) {
                    this.zzd.zzg(this.zzf.zzd);
                    bundle2.putBundle("quality_signals", this.zze.zzb());
                }
            } else {
                this.zzd.zzg(this.zzf.zzd);
                bundle2.putBundle("quality_signals", this.zze.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzb);
        if (!this.zzg.zzP()) {
            bundle2.putString("session_id", this.zzc);
        }
    }
}
