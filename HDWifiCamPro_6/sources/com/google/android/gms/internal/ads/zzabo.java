package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzabo implements zzzi {
    public static final zzzp zza = zzabn.zza;
    private final byte[] zzb;
    private final zzef zzc;
    private final zzzq zzd;
    private zzzl zze;
    private zzaap zzf;
    private int zzg;
    private zzbq zzh;
    private zzzv zzi;
    private int zzj;
    private int zzk;
    private zzabm zzl;
    private int zzm;
    private long zzn;

    public zzabo() {
        this(0);
    }

    public zzabo(int i) {
        this.zzb = new byte[42];
        this.zzc = new zzef(new byte[32768], 0);
        this.zzd = new zzzq();
        this.zzg = 0;
    }

    private final long zze(zzef zzef, boolean z) {
        boolean z2;
        if (this.zzi != null) {
            int zzc2 = zzef.zzc();
            while (zzc2 <= zzef.zzd() - 16) {
                zzef.zzF(zzc2);
                if (zzzr.zzc(zzef, this.zzi, this.zzk, this.zzd)) {
                    zzef.zzF(zzc2);
                    return this.zzd.zza;
                }
                zzc2++;
            }
            if (z) {
                while (zzc2 <= zzef.zzd() - this.zzj) {
                    zzef.zzF(zzc2);
                    try {
                        z2 = zzzr.zzc(zzef, this.zzi, this.zzk, this.zzd);
                    } catch (IndexOutOfBoundsException unused) {
                        z2 = false;
                    }
                    if (zzef.zzc() <= zzef.zzd() && z2) {
                        zzef.zzF(zzc2);
                        return this.zzd.zza;
                    }
                    zzc2++;
                }
                zzef.zzF(zzef.zzd());
                return -1;
            }
            zzef.zzF(zzc2);
            return -1;
        }
        throw null;
    }

    private final void zzf() {
        long j = this.zzn;
        zzzv zzzv = this.zzi;
        int i = zzen.zza;
        this.zzf.zzs((j * 1000000) / ((long) zzzv.zze), 1, this.zzm, 0, (zzaao) null);
    }

    public final void zzb(zzzl zzzl) {
        this.zze = zzzl;
        this.zzf = zzzl.zzv(0, 1);
        zzzl.zzC();
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        zzzs.zza(zzzj, false);
        zzef zzef = new zzef(4);
        ((zzyy) zzzj).zzm(zzef.zzH(), 0, 4, false);
        if (zzef.zzs() == 1716281667) {
            return true;
        }
        return false;
    }

    public final void zzc(long j, long j2) {
        long j3 = 0;
        if (j == 0) {
            this.zzg = 0;
        } else {
            zzabm zzabm = this.zzl;
            if (zzabm != null) {
                zzabm.zzd(j2);
            }
        }
        if (j2 != 0) {
            j3 = -1;
        }
        this.zzn = j3;
        this.zzm = 0;
        this.zzc.zzC(0);
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        boolean zzl2;
        zzaal zzaal;
        zzzj zzzj2 = zzzj;
        int i = this.zzg;
        boolean z = true;
        if (i == 0) {
            zzzj.zzj();
            long zze2 = zzzj.zze();
            zzbq zza2 = zzzs.zza(zzzj2, true);
            ((zzyy) zzzj2).zzo((int) (zzzj.zze() - zze2), false);
            this.zzh = zza2;
            this.zzg = 1;
            return 0;
        } else if (i == 1) {
            ((zzyy) zzzj2).zzm(this.zzb, 0, 42, false);
            zzzj.zzj();
            this.zzg = 2;
            return 0;
        } else if (i == 2) {
            zzef zzef = new zzef(4);
            ((zzyy) zzzj2).zzn(zzef.zzH(), 0, 4, false);
            if (zzef.zzs() == 1716281667) {
                this.zzg = 3;
                return 0;
            }
            throw zzbu.zza("Failed to read FLAC stream marker.", (Throwable) null);
        } else if (i == 3) {
            zzzv zzzv = this.zzi;
            do {
                zzzj.zzj();
                zzee zzee = new zzee(new byte[4], 4);
                zzyy zzyy = (zzyy) zzzj2;
                zzyy.zzm(zzee.zza, 0, 4, false);
                zzl2 = zzee.zzl();
                int zzc2 = zzee.zzc(7);
                int zzc3 = zzee.zzc(24) + 4;
                if (zzc2 == 0) {
                    byte[] bArr = new byte[38];
                    zzyy.zzn(bArr, 0, 38, false);
                    zzzv = new zzzv(bArr, 4);
                } else if (zzzv == null) {
                    throw new IllegalArgumentException();
                } else if (zzc2 == 3) {
                    zzef zzef2 = new zzef(zzc3);
                    zzyy.zzn(zzef2.zzH(), 0, zzc3, false);
                    zzzv = zzzv.zzf(zzzs.zzb(zzef2));
                } else if (zzc2 == 4) {
                    zzef zzef3 = new zzef(zzc3);
                    zzyy.zzn(zzef3.zzH(), 0, zzc3, false);
                    zzef3.zzG(4);
                    zzzv = zzzv.zzg(Arrays.asList(zzaav.zzc(zzef3, false, false).zzb));
                } else if (zzc2 == 6) {
                    zzef zzef4 = new zzef(zzc3);
                    zzyy.zzn(zzef4.zzH(), 0, zzc3, false);
                    zzef4.zzG(4);
                    zzzv = zzzv.zze(zzfvn.zzp(zzaci.zzb(zzef4)));
                } else {
                    zzyy.zzo(zzc3, false);
                }
                int i2 = zzen.zza;
                this.zzi = zzzv;
            } while (!zzl2);
            zzzv zzzv2 = this.zzi;
            if (zzzv2 != null) {
                this.zzj = Math.max(zzzv2.zzc, 6);
                this.zzf.zzk(this.zzi.zzc(this.zzb, this.zzh));
                this.zzg = 4;
                return 0;
            }
            throw null;
        } else if (i == 4) {
            zzzj.zzj();
            zzef zzef5 = new zzef(2);
            ((zzyy) zzzj2).zzm(zzef5.zzH(), 0, 2, false);
            int zzo = zzef5.zzo();
            if ((zzo >> 2) == 16382) {
                zzzj.zzj();
                this.zzk = zzo;
                zzzl zzzl = this.zze;
                int i3 = zzen.zza;
                long zzf2 = zzzj.zzf();
                long zzd2 = zzzj.zzd();
                zzzv zzzv3 = this.zzi;
                if (zzzv3 != null) {
                    if (zzzv3.zzk != null) {
                        zzaal = new zzzt(zzzv3, zzf2);
                    } else if (zzd2 == -1 || zzzv3.zzj <= 0) {
                        zzaal = new zzaak(zzzv3.zza(), 0);
                    } else {
                        this.zzl = new zzabm(zzzv3, this.zzk, zzf2, zzd2);
                        zzaal = this.zzl.zzb();
                    }
                    zzzl.zzN(zzaal);
                    this.zzg = 5;
                    return 0;
                }
                throw null;
            }
            zzzj.zzj();
            throw zzbu.zza("First frame does not start with sync code.", (Throwable) null);
        } else if (this.zzf != null) {
            zzzv zzzv4 = this.zzi;
            if (zzzv4 != null) {
                zzabm zzabm = this.zzl;
                if (zzabm != null && zzabm.zze()) {
                    return zzabm.zza(zzzj2, zzaai);
                }
                if (this.zzn == -1) {
                    this.zzn = zzzr.zzb(zzzj2, zzzv4);
                    return 0;
                }
                zzef zzef6 = this.zzc;
                int zzd3 = zzef6.zzd();
                if (zzd3 < 32768) {
                    int zza3 = zzzj2.zza(zzef6.zzH(), zzd3, 32768 - zzd3);
                    if (zza3 != -1) {
                        z = false;
                    }
                    if (!z) {
                        this.zzc.zzE(zzd3 + zza3);
                    } else if (this.zzc.zza() == 0) {
                        zzf();
                        return -1;
                    }
                } else {
                    z = false;
                }
                zzef zzef7 = this.zzc;
                int zzc4 = zzef7.zzc();
                int i4 = this.zzm;
                int i5 = this.zzj;
                if (i4 < i5) {
                    zzef7.zzG(Math.min(i5 - i4, zzef7.zza()));
                }
                long zze3 = zze(this.zzc, z);
                zzef zzef8 = this.zzc;
                int zzc5 = zzef8.zzc() - zzc4;
                zzef8.zzF(zzc4);
                zzaan.zzb(this.zzf, this.zzc, zzc5);
                this.zzm += zzc5;
                if (zze3 != -1) {
                    zzf();
                    this.zzm = 0;
                    this.zzn = zze3;
                }
                zzef zzef9 = this.zzc;
                if (zzef9.zza() >= 16) {
                    return 0;
                }
                int zza4 = zzef9.zza();
                System.arraycopy(zzef9.zzH(), zzef9.zzc(), zzef9.zzH(), 0, zza4);
                this.zzc.zzF(0);
                this.zzc.zzE(zza4);
                return 0;
            }
            throw null;
        } else {
            throw null;
        }
    }
}
