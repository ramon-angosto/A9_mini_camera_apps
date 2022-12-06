package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaf {
    private static final zzaf zzG = new zzaf(new zzad());
    public static final zzn zza = zzab.zza;
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    private int zzH;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final String zzj;
    public final zzbq zzk;
    public final String zzl;
    public final String zzm;
    public final int zzn;
    public final List zzo;
    public final zzx zzp;
    public final long zzq;
    public final int zzr;
    public final int zzs;
    public final float zzt;
    public final int zzu;
    public final float zzv;
    public final byte[] zzw;
    public final int zzx;
    public final zzq zzy;
    public final int zzz;

    private zzaf(zzad zzad) {
        this.zzb = zzad.zza;
        this.zzc = zzad.zzb;
        this.zzd = zzen.zzP(zzad.zzc);
        this.zze = zzad.zzd;
        int i = 0;
        this.zzf = 0;
        int zzd2 = zzad.zze;
        this.zzg = zzd2;
        int zzl2 = zzad.zzf;
        this.zzh = zzl2;
        this.zzi = zzl2 != -1 ? zzl2 : zzd2;
        this.zzj = zzad.zzg;
        this.zzk = zzad.zzh;
        this.zzl = zzad.zzi;
        this.zzm = zzad.zzj;
        this.zzn = zzad.zzk;
        this.zzo = zzad.zzl == null ? Collections.emptyList() : zzad.zzl;
        this.zzp = zzad.zzm;
        this.zzq = zzad.zzn;
        this.zzr = zzad.zzo;
        this.zzs = zzad.zzp;
        this.zzt = zzad.zzq;
        this.zzu = zzad.zzr == -1 ? 0 : zzad.zzr;
        this.zzv = zzad.zzs == -1.0f ? 1.0f : zzad.zzs;
        this.zzw = zzad.zzt;
        this.zzx = zzad.zzu;
        this.zzy = zzad.zzv;
        this.zzz = zzad.zzw;
        this.zzA = zzad.zzx;
        this.zzB = zzad.zzy;
        this.zzC = zzad.zzz == -1 ? 0 : zzad.zzz;
        this.zzD = zzad.zzA != -1 ? zzad.zzA : i;
        this.zzE = zzad.zzB;
        this.zzF = (zzad.zzC != 0 || this.zzp == null) ? zzad.zzC : 1;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaf zzaf = (zzaf) obj;
            int i2 = this.zzH;
            if ((i2 == 0 || (i = zzaf.zzH) == 0 || i2 == i) && this.zze == zzaf.zze && this.zzg == zzaf.zzg && this.zzh == zzaf.zzh && this.zzn == zzaf.zzn && this.zzq == zzaf.zzq && this.zzr == zzaf.zzr && this.zzs == zzaf.zzs && this.zzu == zzaf.zzu && this.zzx == zzaf.zzx && this.zzz == zzaf.zzz && this.zzA == zzaf.zzA && this.zzB == zzaf.zzB && this.zzC == zzaf.zzC && this.zzD == zzaf.zzD && this.zzE == zzaf.zzE && this.zzF == zzaf.zzF && Float.compare(this.zzt, zzaf.zzt) == 0 && Float.compare(this.zzv, zzaf.zzv) == 0 && zzen.zzT(this.zzb, zzaf.zzb) && zzen.zzT(this.zzc, zzaf.zzc) && zzen.zzT(this.zzj, zzaf.zzj) && zzen.zzT(this.zzl, zzaf.zzl) && zzen.zzT(this.zzm, zzaf.zzm) && zzen.zzT(this.zzd, zzaf.zzd) && Arrays.equals(this.zzw, zzaf.zzw) && zzen.zzT(this.zzk, zzaf.zzk) && zzen.zzT(this.zzy, zzaf.zzy) && zzen.zzT(this.zzp, zzaf.zzp) && zzd(zzaf)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        String str3 = this.zzl;
        String str4 = this.zzm;
        String str5 = this.zzj;
        int i = this.zzi;
        String str6 = this.zzd;
        int i2 = this.zzr;
        int i3 = this.zzs;
        float f = this.zzt;
        int i4 = this.zzz;
        int i5 = this.zzA;
        return "Format(" + str + ", " + str2 + ", " + str3 + ", " + str4 + ", " + str5 + ", " + i + ", " + str6 + ", [" + i2 + ", " + i3 + ", " + f + "], [" + i4 + ", " + i5 + "])";
    }

    public final int zza() {
        int i;
        int i2 = this.zzr;
        if (i2 == -1 || (i = this.zzs) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final zzad zzb() {
        return new zzad(this, (zzac) null);
    }

    public final zzaf zzc(int i) {
        zzad zzad = new zzad(this, (zzac) null);
        zzad.zzA(i);
        return new zzaf(zzad);
    }

    public final boolean zzd(zzaf zzaf) {
        if (this.zzo.size() != zzaf.zzo.size()) {
            return false;
        }
        for (int i = 0; i < this.zzo.size(); i++) {
            if (!Arrays.equals((byte[]) this.zzo.get(i), (byte[]) zzaf.zzo.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.zzH;
        if (i6 != 0) {
            return i6;
        }
        String str = this.zzb;
        int i7 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i8 = (i + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str2 = this.zzc;
        int hashCode = (i8 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzd;
        if (str3 == null) {
            i2 = 0;
        } else {
            i2 = str3.hashCode();
        }
        int i9 = (((((((hashCode + i2) * 31) + this.zze) * 961) + this.zzg) * 31) + this.zzh) * 31;
        String str4 = this.zzj;
        if (str4 == null) {
            i3 = 0;
        } else {
            i3 = str4.hashCode();
        }
        int i10 = (i9 + i3) * 31;
        zzbq zzbq = this.zzk;
        if (zzbq == null) {
            i4 = 0;
        } else {
            i4 = zzbq.hashCode();
        }
        int i11 = (i10 + i4) * 31;
        String str5 = this.zzl;
        if (str5 == null) {
            i5 = 0;
        } else {
            i5 = str5.hashCode();
        }
        int i12 = (i11 + i5) * 31;
        String str6 = this.zzm;
        if (str6 != null) {
            i7 = str6.hashCode();
        }
        int floatToIntBits = ((((((((((((((((((((((((((((((i12 + i7) * 31) + this.zzn) * 31) + ((int) this.zzq)) * 31) + this.zzr) * 31) + this.zzs) * 31) + Float.floatToIntBits(this.zzt)) * 31) + this.zzu) * 31) + Float.floatToIntBits(this.zzv)) * 31) + this.zzx) * 31) + this.zzz) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) + this.zzF;
        this.zzH = floatToIntBits;
        return floatToIntBits;
    }
}
