package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaii implements zzaib {
    final /* synthetic */ zzaik zza;
    private final zzee zzb = new zzee(new byte[4], 4);

    public zzaii(zzaik zzaik) {
        this.zza = zzaik;
    }

    public final void zza(zzef zzef) {
        if (zzef.zzk() == 0 && (zzef.zzk() & 128) != 0) {
            zzef.zzG(6);
            int zza2 = zzef.zza() / 4;
            for (int i = 0; i < zza2; i++) {
                zzef.zzA(this.zzb, 4);
                int zzc = this.zzb.zzc(16);
                this.zzb.zzj(3);
                if (zzc == 0) {
                    this.zzb.zzj(13);
                } else {
                    int zzc2 = this.zzb.zzc(13);
                    if (this.zza.zzf.get(zzc2) == null) {
                        zzaik zzaik = this.zza;
                        zzaik.zzf.put(zzc2, new zzaic(new zzaij(zzaik, zzc2)));
                        zzaik zzaik2 = this.zza;
                        zzaik2.zzl = zzaik2.zzl + 1;
                    }
                }
            }
            this.zza.zzf.remove(0);
        }
    }

    public final void zzb(zzel zzel, zzzl zzzl, zzaio zzaio) {
    }
}
