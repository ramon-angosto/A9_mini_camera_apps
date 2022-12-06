package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzezg implements zzddd, zzdez, zzfaw, zzo, zzdfl, zzddq, zzdkn {
    private final zzffm zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzezg zzh = null;

    public zzezg(zzffm zzffm) {
        this.zza = zzffm;
    }

    public static zzezg zzi(zzezg zzezg) {
        zzezg zzezg2 = new zzezg(zzezg.zza);
        zzezg2.zzh = zzezg;
        return zzezg2;
    }

    public final void zzb() {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzb();
            return;
        }
        zzfan.zza(this.zzf, zzeyz.zza);
        zzfan.zza(this.zzd, zzeza.zza);
        zzfan.zza(this.zzd, zzezb.zza);
    }

    public final void zzbC() {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzbC();
        } else {
            zzfan.zza(this.zzf, zzeyw.zza);
        }
    }

    public final void zzbK() {
    }

    public final void zzbL(zzfaw zzfaw) {
        this.zzh = (zzezg) zzfaw;
    }

    public final void zzbr() {
    }

    public final void zze() {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zze();
        } else {
            zzfan.zza(this.zzf, zzezd.zza);
        }
    }

    public final void zzf(int i) {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzf(i);
        } else {
            zzfan.zza(this.zzf, new zzeyv(i));
        }
    }

    public final void zzg(zzs zzs) {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzg(zzs);
        } else {
            zzfan.zza(this.zzg, new zzeyu(zzs));
        }
    }

    public final void zzh() {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzh();
        } else {
            zzfan.zza(this.zze, zzezf.zza);
        }
    }

    public final void zzj() {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzj();
            return;
        }
        this.zza.zza();
        zzfan.zza(this.zzc, zzeys.zza);
        zzfan.zza(this.zzd, zzeyt.zza);
    }

    public final void zzk(zze zze2) {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzk(zze2);
        } else {
            zzfan.zza(this.zzd, new zzezc(zze2));
        }
    }

    public final void zzn(zzdez zzdez) {
        this.zze.set(zzdez);
    }

    public final void zzo(zzo zzo) {
        this.zzf.set(zzo);
    }

    public final void zzp(zzde zzde) {
        this.zzg.set(zzde);
    }

    public final void zzq() {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzq();
        } else {
            zzfan.zza(this.zzd, zzeze.zza);
        }
    }

    public final void zzr(zzbdm zzbdm) {
        this.zzb.set(zzbdm);
    }

    public final void zzs(zzbdq zzbdq) {
        this.zzd.set(zzbdq);
    }

    public final void zzt(zzbdn zzbdn) {
        this.zzc.set(zzbdn);
    }

    public final void zzl(zzbdj zzbdj) {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zzl(zzbdj);
        } else {
            zzfan.zza(this.zzb, new zzeyy(zzbdj));
        }
    }

    public final void zza(zze zze2) {
        zzezg zzezg = this.zzh;
        if (zzezg != null) {
            zzezg.zza(zze2);
            return;
        }
        zzfan.zza(this.zzb, new zzeyr(zze2));
        zzfan.zza(this.zzb, new zzeyx(zze2));
    }
}
