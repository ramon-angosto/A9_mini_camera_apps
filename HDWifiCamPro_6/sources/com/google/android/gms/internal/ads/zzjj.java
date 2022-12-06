package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjj {
    public final zzsg zza;
    public final Object zzb;
    public final zztz[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzjk zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzkb[] zzi;
    private final zzvz zzj;
    private final zzjt zzk;
    private zzjj zzl;
    private zzuh zzm = zzuh.zza;
    private zzwa zzn;
    private long zzo;

    public zzjj(zzkb[] zzkbArr, long j, zzvz zzvz, zzwi zzwi, zzjt zzjt, zzjk zzjk, zzwa zzwa, byte[] bArr) {
        zzjk zzjk2 = zzjk;
        this.zzi = zzkbArr;
        this.zzo = j;
        this.zzj = zzvz;
        this.zzk = zzjt;
        this.zzb = zzjk2.zza.zza;
        this.zzf = zzjk2;
        this.zzn = zzwa;
        this.zzc = new zztz[2];
        this.zzh = new boolean[2];
        zzsi zzsi = zzjk2.zza;
        long j2 = zzjk2.zzb;
        long j3 = zzjk2.zzd;
        zzwi zzwi2 = zzwi;
        zzsg zzo2 = zzjt.zzo(zzsi, zzwi, j2);
        this.zza = j3 != C.TIME_UNSET ? new zzrn(zzo2, true, 0, j3) : zzo2;
    }

    private final void zzs() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzwa zzwa = this.zzn;
                if (i < zzwa.zza) {
                    zzwa.zzb(i);
                    zzvt zzvt = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzwa zzwa = this.zzn;
                if (i < zzwa.zza) {
                    zzwa.zzb(i);
                    zzvt zzvt = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzwa zzwa, long j, boolean z) {
        return zzb(zzwa, j, false, new boolean[2]);
    }

    public final long zzb(zzwa zzwa, long j, boolean z, boolean[] zArr) {
        zzwa zzwa2 = zzwa;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzwa2.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzwa.zza(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzkb[] zzkbArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzkbArr[i2].zzb();
            i2++;
        }
        zzs();
        this.zzn = zzwa2;
        zzt();
        long zzf2 = this.zza.zzf(zzwa2.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzkb[] zzkbArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzkbArr2[i3].zzb();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zztz[] zztzArr = this.zzc;
            if (i4 >= 2) {
                return zzf2;
            }
            if (zztzArr[i4] != null) {
                zzdd.zzf(zzwa.zzb(i4));
                this.zzi[i4].zzb();
                this.zze = true;
            } else {
                zzdd.zzf(zzwa2.zzc[i4] == null);
            }
            i4++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long zzb2 = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return zzb2 == Long.MIN_VALUE ? this.zzf.zze : zzb2;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzjj zzg() {
        return this.zzl;
    }

    public final zzuh zzh() {
        return this.zzm;
    }

    public final zzwa zzi() {
        return this.zzn;
    }

    public final zzwa zzj(float f, zzcn zzcn) throws zzha {
        zzwa zzn2 = this.zzj.zzn(this.zzi, this.zzm, this.zzf.zza, zzcn);
        for (zzvt zzvt : zzn2.zzc) {
        }
        return zzn2;
    }

    public final void zzk(long j) {
        zzdd.zzf(zzu());
        this.zza.zzo(j - this.zzo);
    }

    public final void zzl(float f, zzcn zzcn) throws zzha {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzwa zzj2 = zzj(f, zzcn);
        zzjk zzjk = this.zzf;
        long j = zzjk.zzb;
        long j2 = zzjk.zze;
        if (j2 != C.TIME_UNSET && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        long zza2 = zza(zzj2, j, false);
        long j3 = this.zzo;
        zzjk zzjk2 = this.zzf;
        this.zzo = j3 + (zzjk2.zzb - zza2);
        this.zzf = zzjk2.zzb(zza2);
    }

    public final void zzm(long j) {
        zzdd.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzjt zzjt = this.zzk;
        zzsg zzsg = this.zza;
        try {
            if (zzsg instanceof zzrn) {
                zzjt.zzh(((zzrn) zzsg).zza);
            } else {
                zzjt.zzh(zzsg);
            }
        } catch (RuntimeException e) {
            zzdw.zzc("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzjj zzjj) {
        if (zzjj != this.zzl) {
            zzs();
            this.zzl = zzjj;
            zzt();
        }
    }

    public final void zzp(long j) {
        this.zzo = 1000000000000L;
    }

    public final void zzq() {
        zzsg zzsg = this.zza;
        if (zzsg instanceof zzrn) {
            long j = this.zzf.zzd;
            if (j == C.TIME_UNSET) {
                j = Long.MIN_VALUE;
            }
            ((zzrn) zzsg).zzn(0, j);
        }
    }

    public final boolean zzr() {
        if (!this.zzd) {
            return false;
        }
        if (this.zze) {
            return this.zza.zzb() == Long.MIN_VALUE;
        }
        return true;
    }
}
