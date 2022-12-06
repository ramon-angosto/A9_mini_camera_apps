package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgr implements zzka, zzkb {
    private final int zza;
    private final zzjg zzb = new zzjg();
    private zzkc zzc;
    private int zzd;
    private zznb zze;
    private int zzf;
    private zztz zzg;
    private zzaf[] zzh;
    private long zzi;
    private long zzj = Long.MIN_VALUE;
    private boolean zzk;
    private boolean zzl;

    public zzgr(int i) {
        this.zza = i;
    }

    private final void zzP(long j, boolean z) throws zzha {
        this.zzk = false;
        this.zzj = j;
        zzu(j, z);
    }

    public final void zzA() {
        zzdd.zzf(this.zzf == 0);
        zzjg zzjg = this.zzb;
        zzjg.zzb = null;
        zzjg.zza = null;
        zzv();
    }

    public final void zzB(long j) throws zzha {
        zzP(j, false);
    }

    public final void zzC() {
        this.zzk = true;
    }

    public /* synthetic */ void zzD(float f, float f2) {
    }

    public final void zzE() throws zzha {
        boolean z = true;
        if (this.zzf != 1) {
            z = false;
        }
        zzdd.zzf(z);
        this.zzf = 2;
        zzw();
    }

    public final void zzF() {
        zzdd.zzf(this.zzf == 2);
        this.zzf = 1;
        zzx();
    }

    public final boolean zzG() {
        return this.zzj == Long.MIN_VALUE;
    }

    public final boolean zzH() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public final zzaf[] zzJ() {
        zzaf[] zzafArr = this.zzh;
        if (zzafArr != null) {
            return zzafArr;
        }
        throw null;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzbe() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final int zzbf(zzjg zzjg, zzgi zzgi, int i) {
        zztz zztz = this.zzg;
        if (zztz != null) {
            int zza2 = zztz.zza(zzjg, zzgi, i);
            if (zza2 == -4) {
                if (zzgi.zzg()) {
                    this.zzj = Long.MIN_VALUE;
                    return this.zzk ? -4 : -3;
                }
                long j = zzgi.zzd + this.zzi;
                zzgi.zzd = j;
                this.zzj = Math.max(this.zzj, j);
            } else if (zza2 == -5) {
                zzaf zzaf = zzjg.zza;
                if (zzaf != null) {
                    long j2 = zzaf.zzq;
                    if (j2 != Long.MAX_VALUE) {
                        zzad zzb2 = zzaf.zzb();
                        zzb2.zzW(j2 + this.zzi);
                        zzjg.zza = zzb2.zzY();
                        return -5;
                    }
                } else {
                    throw null;
                }
            }
            return zza2;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zzha zzbg(Throwable th, zzaf zzaf, boolean z, int i) {
        int i2 = 4;
        if (zzaf != null && !this.zzl) {
            this.zzl = true;
            try {
                i2 = zzO(zzaf) & 7;
            } catch (zzha unused) {
            } finally {
                this.zzl = false;
            }
        }
        return zzha.zzb(th, zzK(), this.zzd, zzaf, i2, z, i);
    }

    public int zze() throws zzha {
        return 0;
    }

    public final long zzf() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final zzjg zzh() {
        zzjg zzjg = this.zzb;
        zzjg.zzb = null;
        zzjg.zza = null;
        return zzjg;
    }

    public zzji zzi() {
        return null;
    }

    public final zzkb zzj() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final zzkc zzk() {
        zzkc zzkc = this.zzc;
        if (zzkc != null) {
            return zzkc;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zznb zzl() {
        zznb zznb = this.zze;
        if (zznb != null) {
            return zznb;
        }
        throw null;
    }

    public final zztz zzm() {
        return this.zzg;
    }

    public final void zzn() {
        boolean z = true;
        if (this.zzf != 1) {
            z = false;
        }
        zzdd.zzf(z);
        zzjg zzjg = this.zzb;
        zzjg.zzb = null;
        zzjg.zza = null;
        this.zzf = 0;
        this.zzg = null;
        this.zzh = null;
        this.zzk = false;
        zzs();
    }

    public final void zzo(zzkc zzkc, zzaf[] zzafArr, zztz zztz, long j, boolean z, boolean z2, long j2, long j3) throws zzha {
        boolean z3 = z;
        zzdd.zzf(this.zzf == 0);
        this.zzc = zzkc;
        this.zzf = 1;
        zzt(z, z2);
        zzz(zzafArr, zztz, j2, j3);
        long j4 = j;
        zzP(j, z);
    }

    public void zzp(int i, Object obj) throws zzha {
    }

    public final void zzq(int i, zznb zznb) {
        this.zzd = i;
        this.zze = zznb;
    }

    /* access modifiers changed from: protected */
    public void zzs() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzt(boolean z, boolean z2) throws zzha {
    }

    /* access modifiers changed from: protected */
    public void zzu(long j, boolean z) throws zzha {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzv() {
    }

    /* access modifiers changed from: protected */
    public void zzw() throws zzha {
    }

    /* access modifiers changed from: protected */
    public void zzx() {
    }

    /* access modifiers changed from: protected */
    public void zzy(zzaf[] zzafArr, long j, long j2) throws zzha {
        throw null;
    }

    public final void zzz(zzaf[] zzafArr, zztz zztz, long j, long j2) throws zzha {
        zzdd.zzf(!this.zzk);
        this.zzg = zztz;
        if (this.zzj == Long.MIN_VALUE) {
            this.zzj = j;
        }
        this.zzh = zzafArr;
        this.zzi = j2;
        zzy(zzafArr, j, j2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzI() {
        if (zzG()) {
            return this.zzk;
        }
        zztz zztz = this.zzg;
        if (zztz != null) {
            return zztz.zze();
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final int zzd(long j) {
        zztz zztz = this.zzg;
        if (zztz != null) {
            return zztz.zzb(j - this.zzi);
        }
        throw null;
    }

    public final void zzr() throws IOException {
        zztz zztz = this.zzg;
        if (zztz != null) {
            zztz.zzd();
            return;
        }
        throw null;
    }
}
