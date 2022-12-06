package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzavx {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzbak zzf;
    private final zzbak zzg;
    private int zzh;
    private int zzi;

    public zzavx(zzbak zzbak, zzbak zzbak2, boolean z) {
        this.zzg = zzbak;
        this.zzf = zzbak2;
        this.zze = z;
        zzbak2.zzv(12);
        this.zza = zzbak2.zzi();
        zzbak.zzv(12);
        this.zzi = zzbak.zzi();
        zzbac.zzf(zzbak.zze() != 1 ? false : true, "first_chunk must be 1");
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
            j = this.zzf.zzn();
        } else {
            j = this.zzf.zzm();
        }
        this.zzd = j;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzi();
            this.zzg.zzw(4);
            int i2 = -1;
            int i3 = this.zzi - 1;
            this.zzi = i3;
            if (i3 > 0) {
                i2 = -1 + this.zzg.zzi();
            }
            this.zzh = i2;
        }
        return true;
    }
}
