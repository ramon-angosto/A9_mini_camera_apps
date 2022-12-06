package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzawm implements zzauz, zzavg {
    public static final zzavb zza = new zzawk();
    private static final int zzb = zzbar.zzg("qt  ");
    private final zzbak zzc = new zzbak(zzbai.zza);
    private final zzbak zzd = new zzbak(4);
    private final zzbak zze = new zzbak(16);
    private final Stack zzf = new Stack();
    private int zzg;
    private int zzh;
    private long zzi;
    private int zzj;
    private zzbak zzk;
    private int zzl;
    private int zzm;
    private zzava zzn;
    private zzawl[] zzo;
    private long zzp;
    private boolean zzq;

    private final void zzh() {
        this.zzg = 0;
        this.zzj = 0;
    }

    private final void zzi(long j) throws zzasz {
        zzaxh zzaxh;
        zzaxh zzaxh2;
        zzavd zzavd;
        zzawo zza2;
        while (!this.zzf.isEmpty() && ((zzavu) this.zzf.peek()).zza == j) {
            zzavu zzavu = (zzavu) this.zzf.pop();
            if (zzavu.zzaR == zzavw.zzE) {
                ArrayList arrayList = new ArrayList();
                zzavd zzavd2 = new zzavd();
                zzavv zzb2 = zzavu.zzb(zzavw.zzaC);
                if (zzb2 != null) {
                    zzaxh = zzawd.zzc(zzb2, this.zzq);
                    if (zzaxh != null) {
                        zzavd2.zzb(zzaxh);
                    }
                } else {
                    zzaxh = null;
                }
                long j2 = Long.MAX_VALUE;
                long j3 = -9223372036854775807L;
                int i = 0;
                while (i < zzavu.zzc.size()) {
                    zzavu zzavu2 = (zzavu) zzavu.zzc.get(i);
                    if (zzavu2.zzaR == zzavw.zzG && (zza2 = zzawd.zza(zzavu2, zzavu.zzb(zzavw.zzF), C.TIME_UNSET, (zzauv) null, this.zzq)) != null) {
                        zzawr zzb3 = zzawd.zzb(zza2, zzavu2.zza(zzavw.zzH).zza(zzavw.zzI).zza(zzavw.zzJ), zzavd2);
                        if (zzb3.zza != 0) {
                            zzawl zzawl = new zzawl(zza2, zzb3, this.zzn.zzbi(i, zza2.zzb));
                            zzasw zze2 = zza2.zzf.zze(zzb3.zzd + 30);
                            if (zza2.zzb == 1) {
                                if (zzavd2.zza()) {
                                    zze2 = zze2.zzd(zzavd2.zzb, zzavd2.zzc);
                                }
                                if (zzaxh != null) {
                                    zze2 = zze2.zzf(zzaxh);
                                }
                            }
                            zzawl.zzc.zza(zze2);
                            zzavd = zzavd2;
                            zzaxh2 = zzaxh;
                            long max = Math.max(j3, zza2.zze);
                            arrayList.add(zzawl);
                            long j4 = zzb3.zzb[0];
                            if (j4 < j2) {
                                j3 = max;
                                j2 = j4;
                            } else {
                                j3 = max;
                            }
                            i++;
                            zzavd2 = zzavd;
                            zzaxh = zzaxh2;
                        }
                    }
                    zzavd = zzavd2;
                    zzaxh2 = zzaxh;
                    i++;
                    zzavd2 = zzavd;
                    zzaxh = zzaxh2;
                }
                this.zzp = j3;
                this.zzo = (zzawl[]) arrayList.toArray(new zzawl[arrayList.size()]);
                this.zzn.zzb();
                this.zzn.zzc(this);
                this.zzf.clear();
                this.zzg = 2;
            } else if (!this.zzf.isEmpty()) {
                ((zzavu) this.zzf.peek()).zzc(zzavu);
            }
        }
        if (this.zzg != 2) {
            zzh();
        }
    }

    public final long zza() {
        return this.zzp;
    }

    public final long zzb(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzawl zzawl : this.zzo) {
            zzawr zzawr = zzawl.zzb;
            int zza2 = zzawr.zza(j);
            if (zza2 == -1) {
                zza2 = zzawr.zzb(j);
            }
            long j3 = zzawr.zzb[zza2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public final boolean zzc() {
        return true;
    }

    public final void zzd(zzava zzava) {
        this.zzn = zzava;
    }

    public final void zze(long j, long j2) {
        this.zzf.clear();
        this.zzj = 0;
        this.zzl = 0;
        this.zzm = 0;
        if (j == 0) {
            zzh();
            return;
        }
        zzawl[] zzawlArr = this.zzo;
        if (zzawlArr != null) {
            for (zzawl zzawl : zzawlArr) {
                zzawr zzawr = zzawl.zzb;
                int zza2 = zzawr.zza(j2);
                if (zza2 == -1) {
                    zza2 = zzawr.zzb(j2);
                }
                zzawl.zzd = zza2;
            }
        }
    }

    public final boolean zzg(zzauy zzauy) throws IOException, InterruptedException {
        return zzawn.zzb(zzauy);
    }

    public final int zzf(zzauy zzauy, zzave zzave) throws IOException, InterruptedException {
        zzawl[] zzawlArr;
        boolean z;
        boolean z2;
        zzauy zzauy2 = zzauy;
        zzave zzave2 = zzave;
        while (true) {
            int i = this.zzg;
            if (i == 0) {
                if (this.zzj == 0) {
                    if (!zzauy2.zzh(this.zze.zza, 0, 8, true)) {
                        return -1;
                    }
                    this.zzj = 8;
                    this.zze.zzv(0);
                    this.zzi = this.zze.zzm();
                    this.zzh = this.zze.zze();
                }
                if (this.zzi == 1) {
                    zzauy2.zzh(this.zze.zza, 8, 8, false);
                    this.zzj += 8;
                    this.zzi = this.zze.zzn();
                }
                int i2 = this.zzh;
                if (i2 == zzavw.zzE || i2 == zzavw.zzG || i2 == zzavw.zzH || i2 == zzavw.zzI || i2 == zzavw.zzJ || i2 == zzavw.zzS) {
                    long zzd2 = (zzauy.zzd() + this.zzi) - ((long) this.zzj);
                    this.zzf.add(new zzavu(this.zzh, zzd2));
                    if (this.zzi == ((long) this.zzj)) {
                        zzi(zzd2);
                    } else {
                        zzh();
                    }
                } else {
                    int i3 = this.zzh;
                    if (i3 == zzavw.zzU || i3 == zzavw.zzF || i3 == zzavw.zzV || i3 == zzavw.zzW || i3 == zzavw.zzao || i3 == zzavw.zzap || i3 == zzavw.zzaq || i3 == zzavw.zzT || i3 == zzavw.zzar || i3 == zzavw.zzas || i3 == zzavw.zzat || i3 == zzavw.zzau || i3 == zzavw.zzav || i3 == zzavw.zzR || i3 == zzavw.zzd || i3 == zzavw.zzaC) {
                        zzbac.zze(this.zzj == 8);
                        zzbac.zze(this.zzi <= 2147483647L);
                        this.zzk = new zzbak((int) this.zzi);
                        System.arraycopy(this.zze.zza, 0, this.zzk.zza, 0, 8);
                    } else {
                        this.zzk = null;
                    }
                    this.zzg = 1;
                }
            } else if (i != 1) {
                long j = Long.MAX_VALUE;
                int i4 = -1;
                int i5 = 0;
                while (true) {
                    zzawlArr = this.zzo;
                    if (i5 >= zzawlArr.length) {
                        break;
                    }
                    zzawl zzawl = zzawlArr[i5];
                    int i6 = zzawl.zzd;
                    zzawr zzawr = zzawl.zzb;
                    if (i6 != zzawr.zza) {
                        long j2 = zzawr.zzb[i6];
                        if (j2 < j) {
                            i4 = i5;
                            j = j2;
                        }
                    }
                    i5++;
                }
                if (i4 == -1) {
                    return -1;
                }
                zzawl zzawl2 = zzawlArr[i4];
                zzavi zzavi = zzawl2.zzc;
                int i7 = zzawl2.zzd;
                zzawr zzawr2 = zzawl2.zzb;
                long j3 = zzawr2.zzb[i7];
                int i8 = zzawr2.zzc[i7];
                if (zzawl2.zza.zzg == 1) {
                    j3 += 8;
                    i8 -= 8;
                }
                long zzd3 = (j3 - zzauy.zzd()) + ((long) this.zzl);
                if (zzd3 < 0 || zzd3 >= 262144) {
                    zzave2.zza = j3;
                    return 1;
                }
                int i9 = (int) zzd3;
                boolean z3 = false;
                zzauy2.zzi(i9, false);
                int i10 = zzawl2.zza.zzk;
                if (i10 == 0) {
                    while (true) {
                        int i11 = this.zzl;
                        if (i11 >= i8) {
                            break;
                        }
                        int zzd4 = zzavi.zzd(zzauy2, i8 - i11, false);
                        this.zzl += zzd4;
                        this.zzm -= zzd4;
                    }
                } else {
                    byte[] bArr = this.zzd.zza;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i12 = 4 - i10;
                    while (this.zzl < i8) {
                        int i13 = this.zzm;
                        if (i13 == 0) {
                            zzauy2.zzh(this.zzd.zza, i12, i10, z3);
                            this.zzd.zzv(z3 ? 1 : 0);
                            this.zzm = this.zzd.zzi();
                            this.zzc.zzv(z3);
                            zzavi.zzb(this.zzc, 4);
                            this.zzl += 4;
                            i8 += i12;
                        } else {
                            int zzd5 = zzavi.zzd(zzauy2, i13, z3);
                            this.zzl += zzd5;
                            this.zzm -= zzd5;
                            z3 = false;
                        }
                    }
                }
                int i14 = i8;
                zzawr zzawr3 = zzawl2.zzb;
                zzavi.zzc(zzawr3.zze[i7], zzawr3.zzf[i7], i14, 0, (zzavh) null);
                zzawl2.zzd++;
                this.zzl = 0;
                this.zzm = 0;
                return 0;
            } else {
                long j4 = this.zzi;
                int i15 = this.zzj;
                long j5 = j4 - ((long) i15);
                long zzd6 = zzauy.zzd() + j5;
                zzbak zzbak = this.zzk;
                if (zzbak != null) {
                    zzauy2.zzh(zzbak.zza, i15, (int) j5, false);
                    if (this.zzh == zzavw.zzd) {
                        zzbak zzbak2 = this.zzk;
                        zzbak2.zzv(8);
                        if (zzbak2.zze() == zzb) {
                            z2 = true;
                        } else {
                            zzbak2.zzw(4);
                            while (true) {
                                if (zzbak2.zza() > 0) {
                                    if (zzbak2.zze() == zzb) {
                                        break;
                                    }
                                } else {
                                    z2 = false;
                                    break;
                                }
                            }
                            z2 = true;
                        }
                        this.zzq = z2;
                    } else if (!this.zzf.isEmpty()) {
                        ((zzavu) this.zzf.peek()).zzd(new zzavv(this.zzh, this.zzk));
                    }
                } else if (j5 < 262144) {
                    zzauy2.zzi((int) j5, false);
                } else {
                    zzave2.zza = zzauy.zzd() + j5;
                    z = true;
                    zzi(zzd6);
                    if (z && this.zzg != 2) {
                        return 1;
                    }
                }
                z = false;
                zzi(zzd6);
                return 1;
            }
        }
    }
}
