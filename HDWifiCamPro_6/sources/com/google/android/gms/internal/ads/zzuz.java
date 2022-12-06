package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzuz extends zzvn implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg = zzvr.zzf(this.zzd.zzd);
    private final zzvf zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzuz(int i, zzcp zzcp, int i2, zzvf zzvf, int i3, boolean z, zzfsy zzfsy) {
        super(i, zzcp, i2);
        int i4;
        int i5;
        boolean z2;
        this.zzh = zzvf;
        this.zzi = zzvr.zzm(i3, false);
        int i6 = 0;
        while (true) {
            if (i6 >= zzvf.zzq.size()) {
                i4 = 0;
                i6 = Integer.MAX_VALUE;
                break;
            }
            i4 = zzvr.zza(this.zzd, (String) zzvf.zzq.get(i6), false);
            if (i4 > 0) {
                break;
            }
            i6++;
        }
        this.zzk = i6;
        this.zzj = i4;
        int i7 = this.zzd.zzf;
        int i8 = zzvf.zzr;
        this.zzl = Integer.bitCount(0);
        zzaf zzaf = this.zzd;
        int i9 = zzaf.zzf;
        int i10 = 1;
        this.zzm = true;
        this.zzp = 1 == (zzaf.zze & 1);
        this.zzq = zzaf.zzz;
        this.zzr = zzaf.zzA;
        this.zzs = zzaf.zzi;
        if (zzaf.zzi != -1) {
            int i11 = zzvf.zzt;
        }
        if (zzaf.zzz != -1) {
            int i12 = zzvf.zzs;
        }
        this.zzf = zzfsy.zza(zzaf);
        String[] zzaf2 = zzen.zzaf();
        int i13 = 0;
        while (true) {
            if (i13 >= zzaf2.length) {
                i5 = 0;
                i13 = Integer.MAX_VALUE;
                break;
            }
            i5 = zzvr.zza(this.zzd, zzaf2[i13], false);
            if (i5 > 0) {
                break;
            }
            i13++;
        }
        this.zzn = i13;
        this.zzo = i5;
        int i14 = 0;
        while (true) {
            if (i14 >= zzvf.zzu.size()) {
                i14 = Integer.MAX_VALUE;
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzvf.zzu.get(i14))) {
                break;
            }
            i14++;
        }
        this.zzt = i14;
        this.zzu = (i3 & 128) == 128;
        this.zzv = (i3 & 64) == 64;
        zzvf zzvf2 = this.zzh;
        if (!zzvr.zzm(i3, zzvf2.zzQ) || (!(z2 = this.zzf) && !zzvf2.zzK)) {
            i10 = 0;
        } else if (zzvr.zzm(i3, false) && z2 && this.zzd.zzi != -1) {
            boolean z3 = zzvf2.zzA;
            boolean z4 = zzvf2.zzz;
            if (zzvf2.zzS || !z) {
                i10 = 2;
            }
        }
        this.zze = i10;
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzvn zzvn) {
        zzuz zzuz = (zzuz) zzvn;
        zzvf zzvf = this.zzh;
        boolean z = zzvf.zzN;
        zzaf zzaf = this.zzd;
        int i = zzaf.zzz;
        if (i == -1) {
            return false;
        }
        zzaf zzaf2 = zzuz.zzd;
        if (i != zzaf2.zzz) {
            return false;
        }
        boolean z2 = zzvf.zzL;
        String str = zzaf.zzm;
        if (str == null || !TextUtils.equals(str, zzaf2.zzm)) {
            return false;
        }
        zzvf zzvf2 = this.zzh;
        boolean z3 = zzvf2.zzM;
        int i2 = this.zzd.zzA;
        if (i2 == -1 || i2 != zzuz.zzd.zzA) {
            return false;
        }
        boolean z4 = zzvf2.zzO;
        return this.zzu == zzuz.zzu && this.zzv == zzuz.zzv;
    }

    /* renamed from: zza */
    public final int compareTo(zzuz zzuz) {
        zzfwv zzfwv;
        if (!this.zzf || !this.zzi) {
            zzfwv = zzvr.zzc.zza();
        } else {
            zzfwv = zzvr.zzc;
        }
        zzfvc zzd = zzfvc.zzj().zzd(this.zzi, zzuz.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzuz.zzk), zzfwv.zzc().zza()).zzb(this.zzj, zzuz.zzj).zzb(this.zzl, zzuz.zzl).zzd(this.zzp, zzuz.zzp);
        boolean z = zzuz.zzm;
        zzfvc zzc = zzd.zzd(true, true).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzuz.zzn), zzfwv.zzc().zza()).zzb(this.zzo, zzuz.zzo).zzd(this.zzf, zzuz.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzuz.zzt), zzfwv.zzc().zza());
        Integer valueOf = Integer.valueOf(this.zzs);
        Integer valueOf2 = Integer.valueOf(zzuz.zzs);
        boolean z2 = this.zzh.zzz;
        zzfvc zzc2 = zzc.zzc(valueOf, valueOf2, zzvr.zzd).zzd(this.zzu, zzuz.zzu).zzd(this.zzv, zzuz.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzuz.zzq), zzfwv).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzuz.zzr), zzfwv);
        Integer valueOf3 = Integer.valueOf(this.zzs);
        Integer valueOf4 = Integer.valueOf(zzuz.zzs);
        if (!zzen.zzT(this.zzg, zzuz.zzg)) {
            zzfwv = zzvr.zzd;
        }
        return zzc2.zzc(valueOf3, valueOf4, zzfwv).zza();
    }
}
