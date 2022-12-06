package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfaf implements zzfaz {
    private final zzfaz zza;
    private final zzfaz zzb;
    private final zzfgm zzc;
    private final String zzd;
    private zzdcj zze;
    private final Executor zzf;

    public zzfaf(zzfaz zzfaz, zzfaz zzfaz2, zzfgm zzfgm, String str, Executor executor) {
        this.zza = zzfaz;
        this.zzb = zzfaz2;
        this.zzc = zzfgm;
        this.zzd = str;
        this.zzf = executor;
    }

    private final zzfzp zzg(zzffz zzffz, zzfba zzfba) {
        zzdcj zzdcj = zzffz.zza;
        this.zze = zzdcj;
        if (zzffz.zzc != null) {
            if (zzdcj.zzf() != null) {
                zzffz.zzc.zzo().zzbL(zzffz.zza.zzf());
            }
            return zzfzg.zzi(zzffz.zzc);
        }
        zzdcj.zzb().zzk(zzffz.zzb);
        return ((zzfap) this.zza).zzb(zzfba, (zzfay) null, zzffz.zza);
    }

    /* renamed from: zza */
    public final synchronized zzdcj zzd() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzb(zzfba zzfba, zzfae zzfae, zzfay zzfay, zzdcj zzdcj, zzfak zzfak) throws Exception {
        if (zzfak != null) {
            zzfae zzfae2 = new zzfae(zzfae.zza, zzfae.zzb, zzfae.zzc, zzfae.zzd, zzfae.zze, zzfae.zzf, zzfak.zza);
            if (zzfak.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzfae2);
                return zzg(zzfak.zzc, zzfba);
            }
            zzfzp zza2 = this.zzc.zza(zzfae2);
            if (zza2 != null) {
                this.zze = null;
                return zzfzg.zzn(zza2, new zzfab(this), this.zzf);
            }
            this.zzc.zze(zzfae2);
            zzfba = new zzfba(zzfba.zzb, zzfak.zzb);
        }
        zzfzp zzb2 = ((zzfap) this.zza).zzb(zzfba, zzfay, zzdcj);
        this.zze = zzdcj;
        return zzb2;
    }

    public final /* bridge */ /* synthetic */ zzfzp zzc(zzfba zzfba, zzfay zzfay, Object obj) {
        return zzf(zzfba, zzfay, (zzdcj) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zze(zzfgj zzfgj) throws Exception {
        zzfgl zzfgl;
        if (zzfgj == null || zzfgj.zza == null || (zzfgl = zzfgj.zzb) == null) {
            throw new zzebh(1, "Empty prefetch");
        }
        zzbfe zza2 = zzbfk.zza();
        zzbfc zza3 = zzbfd.zza();
        zza3.zzd(2);
        zza3.zzb(zzbfh.zzd());
        zza2.zza(zza3);
        zzfgj.zza.zza.zzb().zzc().zzi((zzbfk) zza2.zzam());
        return zzg(zzfgj.zza, ((zzfae) zzfgl).zzb);
    }

    public final synchronized zzfzp zzf(zzfba zzfba, zzfay zzfay, zzdcj zzdcj) {
        zzfba zzfba2 = zzfba;
        zzfay zzfay2 = zzfay;
        synchronized (this) {
            zzdci zza2 = zzfay2.zza(zzfba2.zzb);
            zza2.zza(new zzfag(this.zzd));
            zzdcj zzdcj2 = (zzdcj) zza2.zzh();
            zzdcj2.zzg();
            zzdcj2.zzg();
            zzl zzl = zzdcj2.zzg().zzd;
            if (zzl.zzs == null) {
                if (zzl.zzx == null) {
                    zzfef zzg = zzdcj2.zzg();
                    zzfay zzfay3 = zzfay;
                    zzfba zzfba3 = zzfba;
                    zzfzp zzn = zzfzg.zzn(zzfyx.zzv(((zzfal) this.zzb).zzb(zzfba2, zzfay2, zzdcj2)), new zzfac(this, zzfba, new zzfae(zzfay3, zzfba3, zzg.zzd, zzg.zzf, this.zzf, zzg.zzj, (zzfga) null), zzfay, zzdcj2), this.zzf);
                    return zzn;
                }
            }
            this.zze = zzdcj2;
            zzfzp zzb2 = ((zzfap) this.zza).zzb(zzfba2, zzfay2, zzdcj2);
            return zzb2;
        }
    }
}
