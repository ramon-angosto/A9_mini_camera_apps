package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzvl extends zzvn implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzvl(int i, zzcp zzcp, int i2, zzvf zzvf, int i3, String str) {
        super(i, zzcp, i2);
        zzfvn zzfvn;
        int i4;
        int i5 = 0;
        this.zzf = zzvr.zzm(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzvf.zzx;
        this.zzg = 1 == (i6 & 1);
        this.zzh = (i6 & 2) != 0;
        if (zzvf.zzv.isEmpty()) {
            zzfvn = zzfvn.zzp("");
        } else {
            zzfvn = zzvf.zzv;
        }
        int i8 = 0;
        while (true) {
            if (i8 >= zzfvn.size()) {
                i8 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
            boolean z = zzvf.zzy;
            i4 = zzvr.zza(this.zzd, (String) zzfvn.get(i8), false);
            if (i4 > 0) {
                break;
            }
            i8++;
        }
        this.zzi = i8;
        this.zzj = i4;
        int i9 = this.zzd.zzf;
        int i10 = zzvf.zzw;
        this.zzk = Integer.bitCount(0);
        int i11 = this.zzd.zzf;
        this.zzm = false;
        this.zzl = zzvr.zza(this.zzd, str, zzvr.zzf(str) == null);
        boolean z2 = this.zzj > 0 || (zzvf.zzv.isEmpty() && this.zzk > 0) || this.zzg || (this.zzh && this.zzl > 0);
        if (zzvr.zzm(i3, zzvf.zzQ) && z2) {
            i5 = 1;
        }
        this.zze = i5;
    }

    /* renamed from: zza */
    public final int compareTo(zzvl zzvl) {
        zzfwv zzfwv;
        zzfvc zzd = zzfvc.zzj().zzd(this.zzf, zzvl.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzvl.zzi), zzfwv.zzc().zza()).zzb(this.zzj, zzvl.zzj).zzb(this.zzk, zzvl.zzk).zzd(this.zzg, zzvl.zzg);
        Boolean valueOf = Boolean.valueOf(this.zzh);
        Boolean valueOf2 = Boolean.valueOf(zzvl.zzh);
        if (this.zzj == 0) {
            zzfwv = zzfwv.zzc();
        } else {
            zzfwv = zzfwv.zzc().zza();
        }
        zzfvc zzb = zzd.zzc(valueOf, valueOf2, zzfwv).zzb(this.zzl, zzvl.zzl);
        if (this.zzk == 0) {
            boolean z = zzvl.zzm;
            zzb = zzb.zze(false, false);
        }
        return zzb.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzvn zzvn) {
        zzvl zzvl = (zzvl) zzvn;
        return false;
    }
}
