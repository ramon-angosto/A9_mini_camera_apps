package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzahz {
    private final zzahc zza;
    private final zzel zzb;
    private final zzee zzc = new zzee(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzahz(zzahc zzahc, zzel zzel) {
        this.zza = zzahc;
        this.zzb = zzel;
    }

    public final void zza(zzef zzef) throws zzbu {
        long j;
        zzef.zzB(this.zzc.zza, 0, 3);
        this.zzc.zzh(0);
        this.zzc.zzj(8);
        this.zzd = this.zzc.zzl();
        this.zze = this.zzc.zzl();
        this.zzc.zzj(6);
        zzef.zzB(this.zzc.zza, 0, this.zzc.zzc(8));
        this.zzc.zzh(0);
        if (this.zzd) {
            this.zzc.zzj(4);
            int zzc2 = this.zzc.zzc(3);
            this.zzc.zzj(1);
            int zzc3 = this.zzc.zzc(15);
            this.zzc.zzj(1);
            long zzc4 = (((long) zzc2) << 30) | ((long) (zzc3 << 15)) | ((long) this.zzc.zzc(15));
            this.zzc.zzj(1);
            if (!this.zzf && this.zze) {
                this.zzc.zzj(4);
                int zzc5 = this.zzc.zzc(3);
                this.zzc.zzj(1);
                int zzc6 = this.zzc.zzc(15);
                this.zzc.zzj(1);
                int zzc7 = this.zzc.zzc(15);
                this.zzc.zzj(1);
                this.zzb.zzb((((long) zzc5) << 30) | ((long) (zzc6 << 15)) | ((long) zzc7));
                this.zzf = true;
            }
            j = this.zzb.zzb(zzc4);
        } else {
            j = 0;
        }
        this.zza.zzd(j, 4);
        this.zza.zza(zzef);
        this.zza.zzc();
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
