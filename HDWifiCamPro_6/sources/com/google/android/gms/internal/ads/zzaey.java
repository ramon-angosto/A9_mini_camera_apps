package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaey {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzef zzf;
    private final zzef zzg;
    private int zzh;
    private int zzi;

    public zzaey(zzef zzef, zzef zzef2, boolean z) throws zzbu {
        this.zzg = zzef;
        this.zzf = zzef2;
        this.zze = z;
        zzef2.zzF(12);
        this.zza = zzef2.zzn();
        zzef.zzF(12);
        this.zzi = zzef.zzn();
        zzzm.zzb(zzef.zze() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        if (this.zze) {
            j = this.zzf.zzt();
        } else {
            j = this.zzf.zzs();
        }
        this.zzd = j;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzn();
            this.zzg.zzG(4);
            int i2 = -1;
            int i3 = this.zzi - 1;
            this.zzi = i3;
            if (i3 > 0) {
                i2 = -1 + this.zzg.zzn();
            }
            this.zzh = i2;
        }
        return true;
    }
}
