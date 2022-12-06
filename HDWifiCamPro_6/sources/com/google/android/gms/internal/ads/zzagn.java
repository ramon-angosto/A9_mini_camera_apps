package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzagn {
    private final zzagg zza = new zzagg();
    private zzaap zzb;
    private zzzl zzc;
    private zzagi zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzagk zzj = new zzagk();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    /* access modifiers changed from: protected */
    public abstract long zza(zzef zzef);

    /* access modifiers changed from: protected */
    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzagk();
            this.zzf = 0;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1;
        this.zzg = 0;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean zzc(zzef zzef, long j, zzagk zzagk) throws IOException;

    /* access modifiers changed from: package-private */
    public final int zze(zzzj zzzj, zzaai zzaai) throws IOException {
        zzzj zzzj2 = zzzj;
        zzdd.zzb(this.zzb);
        int i = zzen.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzzj2)) {
                long zzf2 = zzzj.zzf();
                long j = this.zzf;
                this.zzk = zzf2 - j;
                if (zzc(this.zza.zza(), j, this.zzj)) {
                    this.zzf = zzzj.zzf();
                } else {
                    zzaf zzaf = this.zzj.zza;
                    this.zzi = zzaf.zzA;
                    if (!this.zzm) {
                        this.zzb.zzk(zzaf);
                        this.zzm = true;
                    }
                    zzagi zzagi = this.zzj.zzb;
                    if (zzagi != null) {
                        this.zzd = zzagi;
                    } else if (zzzj.zzd() == -1) {
                        this.zzd = new zzagm((zzagl) null);
                    } else {
                        zzagh zzb2 = this.zza.zzb();
                        this.zzd = new zzagb(this, this.zzf, zzzj.zzd(), (long) (zzb2.zzd + zzb2.zze), zzb2.zzb, (zzb2.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                    return 0;
                }
            }
            this.zzh = 3;
            return -1;
        } else if (i2 == 1) {
            ((zzyy) zzzj2).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        } else if (i2 != 2) {
            return -1;
        } else {
            long zzd2 = this.zzd.zzd(zzzj2);
            if (zzd2 >= 0) {
                zzaai.zza = zzd2;
                return 1;
            }
            if (zzd2 < -1) {
                zzi(-(zzd2 + 2));
            }
            if (!this.zzl) {
                zzaal zze2 = this.zzd.zze();
                zzdd.zzb(zze2);
                this.zzc.zzN(zze2);
                this.zzl = true;
            }
            if (this.zzk > 0 || this.zza.zze(zzzj2)) {
                this.zzk = 0;
                zzef zza2 = this.zza.zza();
                long zza3 = zza(zza2);
                if (zza3 >= 0) {
                    long j2 = this.zzg;
                    if (j2 + zza3 >= this.zze) {
                        long zzf3 = zzf(j2);
                        zzaan.zzb(this.zzb, zza2, zza2.zzd());
                        this.zzb.zzs(zzf3, 1, zza2.zzd(), 0, (zzaao) null);
                        this.zze = -1;
                    }
                }
                this.zzg += zza3;
                return 0;
            }
            this.zzh = 3;
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    /* access modifiers changed from: protected */
    public final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzzl zzzl, zzaap zzaap) {
        this.zzc = zzzl;
        this.zzb = zzaap;
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzi(long j) {
        this.zzg = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzagi zzagi = this.zzd;
            int i = zzen.zza;
            zzagi.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
