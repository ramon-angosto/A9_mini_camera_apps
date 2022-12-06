package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafk {
    public final zzaap zza;
    public final zzafx zzb = new zzafx();
    public final zzef zzc = new zzef();
    public zzafy zzd;
    public zzafg zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzef zzj = new zzef(1);
    private final zzef zzk = new zzef();
    /* access modifiers changed from: private */
    public boolean zzl;

    public zzafk(zzaap zzaap, zzafy zzafy, zzafg zzafg) {
        this.zza = zzaap;
        this.zzd = zzafy;
        this.zze = zzafg;
        zzh(zzafy, zzafg);
    }

    public final int zza() {
        int i;
        if (!this.zzl) {
            i = this.zzd.zzg[this.zzf];
        } else {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzef zzef;
        zzafw zzf2 = zzf();
        if (zzf2 == null) {
            return 0;
        }
        int i3 = zzf2.zzd;
        if (i3 != 0) {
            zzef = this.zzb.zzn;
        } else {
            byte[] bArr = (byte[]) zzen.zzH(zzf2.zze);
            zzef zzef2 = this.zzk;
            int length = bArr.length;
            zzef2.zzD(bArr, length);
            zzef = this.zzk;
            i3 = length;
        }
        boolean zzb2 = this.zzb.zzb(this.zzf);
        boolean z = zzb2 || i2 != 0;
        zzef zzef3 = this.zzj;
        zzef3.zzH()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzef3.zzF(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzef, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zzb2) {
            this.zzc.zzC(8);
            zzef zzef4 = this.zzc;
            byte[] zzH = zzef4.zzH();
            zzH[0] = 0;
            zzH[1] = 1;
            zzH[2] = 0;
            zzH[3] = (byte) i2;
            zzH[4] = (byte) ((i >> 24) & 255);
            zzH[5] = (byte) ((i >> 16) & 255);
            zzH[6] = (byte) ((i >> 8) & 255);
            zzH[7] = (byte) (i & 255);
            this.zza.zzr(zzef4, 8, 1);
            return i3 + 9;
        }
        zzef zzef5 = this.zzb.zzn;
        int zzo = zzef5.zzo();
        zzef5.zzG(-2);
        int i4 = (zzo * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzC(i4);
            byte[] zzH2 = this.zzc.zzH();
            zzef5.zzB(zzH2, 0, i4);
            int i5 = (((zzH2[2] & UByte.MAX_VALUE) << 8) | (zzH2[3] & UByte.MAX_VALUE)) + i2;
            zzH2[2] = (byte) ((i5 >> 8) & 255);
            zzH2[3] = (byte) (i5 & 255);
            zzef5 = this.zzc;
        }
        this.zza.zzr(zzef5, i4, 1);
        return i3 + 1 + i4;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzafx zzafx = this.zzb;
        return zzafx.zzi[this.zzf];
    }

    public final zzafw zzf() {
        if (!this.zzl) {
            return null;
        }
        zzafg zzafg = this.zzb.zza;
        int i = zzen.zza;
        int i2 = zzafg.zza;
        zzafw zzafw = this.zzb.zzm;
        if (zzafw == null) {
            zzafw = this.zzd.zza.zza(i2);
        }
        if (zzafw == null || !zzafw.zza) {
            return null;
        }
        return zzafw;
    }

    public final void zzh(zzafy zzafy, zzafg zzafg) {
        this.zzd = zzafy;
        this.zze = zzafg;
        this.zza.zzk(zzafy.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzafx zzafx = this.zzb;
        zzafx.zzd = 0;
        zzafx.zzp = 0;
        zzafx.zzq = false;
        zzafx.zzk = false;
        zzafx.zzo = false;
        zzafx.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
