package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawh {
    public final zzawq zza = new zzawq();
    public final zzavi zzb;
    public zzawo zzc;
    public zzawe zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public zzavh zzh;
    public zzawp zzi;

    public zzawh(zzavi zzavi) {
        this.zzb = zzavi;
    }

    public final void zzb() {
        zzawq zzawq = this.zza;
        zzawq.zzd = 0;
        zzawq.zzr = 0;
        zzawq.zzl = false;
        zzawq.zzq = false;
        zzawq.zzn = null;
        this.zze = 0;
        this.zzg = 0;
        this.zzf = 0;
        this.zzh = null;
        this.zzi = null;
    }

    public final void zza(zzawo zzawo, zzawe zzawe) {
        if (zzawo != null) {
            this.zzc = zzawo;
            if (zzawe != null) {
                this.zzd = zzawe;
                this.zzb.zza(zzawo.zzf);
                zzb();
                return;
            }
            throw null;
        }
        throw null;
    }
}
