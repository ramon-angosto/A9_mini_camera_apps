package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawq {
    public zzawe zza;
    public long zzb;
    public long zzc;
    public int zzd;
    public int zze;
    public long[] zzf;
    public int[] zzg;
    public int[] zzh;
    public int[] zzi;
    public long[] zzj;
    public boolean[] zzk;
    public boolean zzl;
    public boolean[] zzm;
    public zzawp zzn;
    public int zzo;
    public zzbak zzp;
    public boolean zzq;
    public long zzr;

    zzawq() {
    }

    public final void zza(int i) {
        zzbak zzbak = this.zzp;
        if (zzbak == null || zzbak.zzd() < i) {
            this.zzp = new zzbak(i);
        }
        this.zzo = i;
        this.zzl = true;
        this.zzq = true;
    }
}
