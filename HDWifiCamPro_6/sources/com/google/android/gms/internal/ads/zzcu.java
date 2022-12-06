package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzcu {
    public static final zzcu zza = new zzcu(new zzct());
    @Deprecated
    public static final zzcu zzb = zza;
    @Deprecated
    public static final zzn zzc = zzcs.zza;
    public final boolean zzA;
    public final zzfvq zzB;
    public final zzfvs zzC;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final int zzg = Integer.MAX_VALUE;
    public final int zzh = 0;
    public final int zzi = 0;
    public final int zzj = 0;
    public final int zzk = 0;
    public final int zzl;
    public final int zzm;
    public final boolean zzn;
    public final zzfvn zzo;
    public final int zzp;
    public final zzfvn zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final zzfvn zzu;
    public final zzfvn zzv;
    public final int zzw;
    public final int zzx;
    public final boolean zzy;
    public final boolean zzz;

    protected zzcu(zzct zzct) {
        this.zzl = zzct.zze;
        this.zzm = zzct.zzf;
        this.zzn = zzct.zzg;
        this.zzo = zzct.zzh;
        this.zzp = 0;
        this.zzq = zzct.zzi;
        this.zzr = 0;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = Integer.MAX_VALUE;
        this.zzu = zzct.zzl;
        this.zzv = zzct.zzm;
        this.zzw = zzct.zzn;
        this.zzx = 0;
        this.zzy = false;
        this.zzz = false;
        this.zzA = false;
        this.zzB = zzfvq.zzc(zzct.zzo);
        this.zzC = zzfvs.zzl(zzct.zzp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcu zzcu = (zzcu) obj;
            return this.zzn == zzcu.zzn && this.zzl == zzcu.zzl && this.zzm == zzcu.zzm && this.zzo.equals(zzcu.zzo) && this.zzq.equals(zzcu.zzq) && this.zzu.equals(zzcu.zzu) && this.zzv.equals(zzcu.zzv) && this.zzw == zzcu.zzw && this.zzB.equals(zzcu.zzB) && this.zzC.equals(zzcu.zzC);
        }
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.zzn ? 1 : 0) - true) * 31) + this.zzl) * 31) + this.zzm) * 31) + this.zzo.hashCode()) * 961) + this.zzq.hashCode()) * 961) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31) + this.zzu.hashCode()) * 31) + this.zzv.hashCode()) * 31) + this.zzw) * 28629151) + this.zzB.hashCode()) * 31) + this.zzC.hashCode();
    }
}
