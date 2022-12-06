package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjm {
    private final zzck zza = new zzck();
    private final zzcm zzb = new zzcm();
    private final zzko zzc;
    private final Handler zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzjj zzh;
    private zzjj zzi;
    private zzjj zzj;
    private int zzk;
    private Object zzl;
    private long zzm;

    public zzjm(zzko zzko, Handler handler) {
        this.zzc = zzko;
        this.zzd = handler;
    }

    private final boolean zzA(zzcn zzcn, zzsi zzsi) {
        if (!zzC(zzsi)) {
            return false;
        }
        int i = zzcn.zzn(zzsi.zza, this.zza).zzd;
        if (zzcn.zze(i, this.zzb, 0).zzp == zzcn.zza(zzsi.zza)) {
            return true;
        }
        return false;
    }

    private final boolean zzB(zzcn zzcn) {
        zzjj zzjj = this.zzh;
        if (zzjj == null) {
            return true;
        }
        int zza2 = zzcn.zza(zzjj.zzb);
        while (true) {
            zza2 = zzcn.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg);
            while (zzjj.zzg() != null && !zzjj.zzf.zzg) {
                zzjj = zzjj.zzg();
            }
            zzjj zzg2 = zzjj.zzg();
            if (zza2 == -1 || zzg2 == null || zzcn.zza(zzg2.zzb) != zza2) {
                boolean zzm2 = zzm(zzjj);
                zzjj.zzf = zzg(zzcn, zzjj.zzf);
            } else {
                zzjj = zzg2;
            }
        }
        boolean zzm22 = zzm(zzjj);
        zzjj.zzf = zzg(zzcn, zzjj.zzf);
        if (!zzm22) {
            return true;
        }
        return false;
    }

    private static final boolean zzC(zzsi zzsi) {
        return !zzsi.zzb() && zzsi.zze == -1;
    }

    private final long zzs(zzcn zzcn, Object obj, int i) {
        zzcn.zzn(obj, this.zza);
        this.zza.zzh(i);
        this.zza.zzj(i);
        return 0;
    }

    private final zzjk zzt(zzcn zzcn, zzjj zzjj, long j) {
        long j2;
        zzcn zzcn2 = zzcn;
        zzjk zzjk = zzjj.zzf;
        long zze2 = (zzjj.zze() + zzjk.zze) - j;
        if (zzjk.zzg) {
            long j3 = 0;
            int zzi2 = zzcn.zzi(zzcn2.zza(zzjk.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (zzi2 == -1) {
                return null;
            }
            int i = zzcn2.zzd(zzi2, this.zza, true).zzd;
            Object obj = this.zza.zzc;
            if (obj != null) {
                long j4 = zzjk.zza.zzd;
                if (zzcn2.zze(i, this.zzb, 0).zzo == zzi2) {
                    Pair zzm2 = zzcn.zzm(this.zzb, this.zza, i, C.TIME_UNSET, Math.max(0, zze2));
                    if (zzm2 == null) {
                        return null;
                    }
                    obj = zzm2.first;
                    long longValue = ((Long) zzm2.second).longValue();
                    zzjj zzg2 = zzjj.zzg();
                    if (zzg2 == null || !zzg2.zzb.equals(obj)) {
                        j4 = this.zze;
                        this.zze = 1 + j4;
                    } else {
                        j4 = zzg2.zzf.zza.zzd;
                    }
                    j3 = longValue;
                    j2 = C.TIME_UNSET;
                } else {
                    j2 = 0;
                }
                zzsi zzx = zzx(zzcn, obj, j3, j4, this.zzb, this.zza);
                if (!(j2 == C.TIME_UNSET || zzjk.zzc == C.TIME_UNSET)) {
                    zzcn2.zzn(zzjk.zza.zza, this.zza).zzb();
                }
                return zzu(zzcn, zzx, j2, j3);
            }
            throw null;
        }
        zzsi zzsi = zzjk.zza;
        zzcn2.zzn(zzsi.zza, this.zza);
        if (zzsi.zzb()) {
            int i2 = zzsi.zzb;
            if (this.zza.zza(i2) == -1) {
                return null;
            }
            int zzf2 = this.zza.zzf(i2, zzsi.zzc);
            if (zzf2 < 0) {
                return zzv(zzcn, zzsi.zza, i2, zzf2, zzjk.zzc, zzsi.zzd);
            }
            long j5 = zzjk.zzc;
            if (j5 == C.TIME_UNSET) {
                zzcm zzcm = this.zzb;
                zzck zzck = this.zza;
                Pair zzm3 = zzcn.zzm(zzcm, zzck, zzck.zzd, C.TIME_UNSET, Math.max(0, zze2));
                if (zzm3 == null) {
                    return null;
                }
                j5 = ((Long) zzm3.second).longValue();
            }
            zzs(zzcn2, zzsi.zza, zzsi.zzb);
            return zzw(zzcn, zzsi.zza, Math.max(0, j5), zzjk.zzc, zzsi.zzd);
        }
        int zze3 = this.zza.zze(zzsi.zze);
        this.zza.zzl(zzsi.zze);
        if (zze3 != this.zza.zza(zzsi.zze)) {
            return zzv(zzcn, zzsi.zza, zzsi.zze, zze3, zzjk.zze, zzsi.zzd);
        }
        zzs(zzcn2, zzsi.zza, zzsi.zze);
        return zzw(zzcn, zzsi.zza, 0, zzjk.zze, zzsi.zzd);
    }

    private final zzjk zzu(zzcn zzcn, zzsi zzsi, long j, long j2) {
        zzsi zzsi2 = zzsi;
        zzcn zzcn2 = zzcn;
        zzcn.zzn(zzsi2.zza, this.zza);
        if (zzsi.zzb()) {
            return zzv(zzcn, zzsi2.zza, zzsi2.zzb, zzsi2.zzc, j, zzsi2.zzd);
        }
        return zzw(zzcn, zzsi2.zza, j2, j, zzsi2.zzd);
    }

    private final zzjk zzv(zzcn zzcn, Object obj, int i, int i2, long j, long j2) {
        zzsi zzsi = new zzsi(obj, i, i2, j2);
        long zzg2 = zzcn.zzn(zzsi.zza, this.zza).zzg(zzsi.zzb, zzsi.zzc);
        if (i2 == this.zza.zze(i)) {
            this.zza.zzi();
        }
        this.zza.zzl(zzsi.zzb);
        return new zzjk(zzsi, (zzg2 == C.TIME_UNSET || zzg2 > 0) ? 0 : Math.max(0, -1 + zzg2), j, C.TIME_UNSET, zzg2, false, false, false, false);
    }

    private final zzjk zzw(zzcn zzcn, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        zzcn zzcn2 = zzcn;
        Object obj2 = obj;
        long j7 = j;
        zzcn2.zzn(obj2, this.zza);
        int zzc2 = this.zza.zzc(j7);
        if (zzc2 == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzl(zzc2);
        }
        zzsi zzsi = new zzsi(obj2, j3, zzc2);
        boolean zzC = zzC(zzsi);
        boolean zzA = zzA(zzcn2, zzsi);
        boolean zzz = zzz(zzcn2, zzsi, zzC);
        if (zzc2 != -1) {
            this.zza.zzl(zzc2);
        }
        if (zzc2 != -1) {
            this.zza.zzh(zzc2);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != C.TIME_UNSET) {
            j6 = j4;
            j5 = j6;
        } else {
            j5 = this.zza.zze;
            j6 = -9223372036854775807L;
        }
        if (j5 != C.TIME_UNSET && j7 >= j5) {
            j7 = Math.max(0, j5 - 1);
        }
        return new zzjk(zzsi, j7, j2, j6, j5, false, zzC, zzA, zzz);
    }

    private static zzsi zzx(zzcn zzcn, Object obj, long j, long j2, zzcm zzcm, zzck zzck) {
        zzcn.zzn(obj, zzck);
        zzcn.zze(zzck.zzd, zzcm, 0);
        zzcn.zza(obj);
        if (zzck.zze == 0) {
            zzck.zzb();
        }
        zzcn.zzn(obj, zzck);
        int zzd2 = zzck.zzd(j);
        if (zzd2 == -1) {
            return new zzsi(obj, j2, zzck.zzc(j));
        }
        return new zzsi(obj, zzd2, zzck.zze(zzd2), j2);
    }

    private final void zzy() {
        zzsi zzsi;
        zzfvk zzi2 = zzfvn.zzi();
        for (zzjj zzjj = this.zzh; zzjj != null; zzjj = zzjj.zzg()) {
            zzi2.zze(zzjj.zzf.zza);
        }
        zzjj zzjj2 = this.zzi;
        if (zzjj2 == null) {
            zzsi = null;
        } else {
            zzsi = zzjj2.zzf.zza;
        }
        this.zzd.post(new zzjl(this, zzi2, zzsi));
    }

    private final boolean zzz(zzcn zzcn, zzsi zzsi, boolean z) {
        int zza2 = zzcn.zza(zzsi.zza);
        if (!zzcn.zze(zzcn.zzd(zza2, this.zza, false).zzd, this.zzb, 0).zzi) {
            if (zzcn.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final zzjj zza() {
        zzjj zzjj = this.zzh;
        if (zzjj == null) {
            return null;
        }
        if (zzjj == this.zzi) {
            this.zzi = zzjj.zzg();
        }
        zzjj.zzn();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzjj zzjj2 = this.zzh;
            this.zzl = zzjj2.zzb;
            this.zzm = zzjj2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzy();
        return this.zzh;
    }

    public final zzjj zzb() {
        zzjj zzjj = this.zzi;
        boolean z = false;
        if (!(zzjj == null || zzjj.zzg() == null)) {
            z = true;
        }
        zzdd.zzf(z);
        this.zzi = this.zzi.zzg();
        zzy();
        return this.zzi;
    }

    public final zzjj zzc() {
        return this.zzj;
    }

    public final zzjj zzd() {
        return this.zzh;
    }

    public final zzjj zze() {
        return this.zzi;
    }

    public final zzjk zzf(long j, zzju zzju) {
        zzjj zzjj = this.zzj;
        if (zzjj != null) {
            return zzt(zzju.zza, zzjj, j);
        }
        return zzu(zzju.zza, zzju.zzb, zzju.zzc, zzju.zzr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzjk zzg(com.google.android.gms.internal.ads.zzcn r19, com.google.android.gms.internal.ads.zzjk r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzsi r3 = r2.zza
            boolean r12 = zzC(r3)
            boolean r13 = r0.zzA(r1, r3)
            boolean r14 = r0.zzz(r1, r3, r12)
            com.google.android.gms.internal.ads.zzsi r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzck r5 = r0.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0037
            int r1 = r3.zze
            if (r1 != r4) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            com.google.android.gms.internal.ads.zzck r9 = r0.zza
            r9.zzh(r1)
            r9 = r5
            goto L_0x0038
        L_0x0037:
            r9 = r7
        L_0x0038:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzck r1 = r0.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzg(r5, r6)
        L_0x0048:
            r7 = r9
            r9 = r5
            goto L_0x0057
        L_0x004b:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0052
            r7 = r5
            r9 = r7
            goto L_0x0057
        L_0x0052:
            com.google.android.gms.internal.ads.zzck r1 = r0.zza
            long r5 = r1.zze
            goto L_0x0048
        L_0x0057:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzck r1 = r0.zza
            int r4 = r3.zzb
            r1.zzl(r4)
            goto L_0x006e
        L_0x0065:
            int r1 = r3.zze
            if (r1 == r4) goto L_0x006e
            com.google.android.gms.internal.ads.zzck r4 = r0.zza
            r4.zzl(r1)
        L_0x006e:
            com.google.android.gms.internal.ads.zzjk r15 = new com.google.android.gms.internal.ads.zzjk
            long r4 = r2.zzb
            long r1 = r2.zzc
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjm.zzg(com.google.android.gms.internal.ads.zzcn, com.google.android.gms.internal.ads.zzjk):com.google.android.gms.internal.ads.zzjk");
    }

    public final zzsi zzh(zzcn zzcn, Object obj, long j) {
        long j2;
        int zza2;
        int i = zzcn.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 == null || (zza2 = zzcn.zza(obj2)) == -1 || zzcn.zzd(zza2, this.zza, false).zzd != i) {
            zzjj zzjj = this.zzh;
            while (true) {
                if (zzjj == null) {
                    zzjj zzjj2 = this.zzh;
                    while (true) {
                        if (zzjj2 != null) {
                            int zza3 = zzcn.zza(zzjj2.zzb);
                            if (zza3 != -1 && zzcn.zzd(zza3, this.zza, false).zzd == i) {
                                j2 = zzjj2.zzf.zza.zzd;
                                break;
                            }
                            zzjj2 = zzjj2.zzg();
                        } else {
                            j2 = this.zze;
                            this.zze = 1 + j2;
                            if (this.zzh == null) {
                                this.zzl = obj;
                                this.zzm = j2;
                            }
                        }
                    }
                } else if (zzjj.zzb.equals(obj)) {
                    j2 = zzjj.zzf.zza.zzd;
                    break;
                } else {
                    zzjj = zzjj.zzg();
                }
            }
        } else {
            j2 = this.zzm;
        }
        long j3 = j2;
        zzcn.zzn(obj, this.zza);
        zzcn.zze(this.zza.zzd, this.zzb, 0);
        int zza4 = zzcn.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcm zzcm = this.zzb;
            if (zza4 < zzcm.zzo) {
                return zzx(zzcn, obj3, j, j3, zzcm, this.zza);
            }
            zzcn.zzd(zza4, this.zza, true);
            this.zza.zzb();
            zzck zzck = this.zza;
            if (zzck.zzd(zzck.zze) == -1 || (obj3 = this.zza.zzc) != null) {
                zza4--;
            } else {
                throw null;
            }
        }
    }

    public final void zzi() {
        if (this.zzk != 0) {
            zzjj zzjj = this.zzh;
            zzdd.zzb(zzjj);
            this.zzl = zzjj.zzb;
            this.zzm = zzjj.zzf.zza.zzd;
            while (zzjj != null) {
                zzjj.zzn();
                zzjj = zzjj.zzg();
            }
            this.zzh = null;
            this.zzj = null;
            this.zzi = null;
            this.zzk = 0;
            zzy();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzfvk zzfvk, zzsi zzsi) {
        this.zzc.zzT(zzfvk.zzg(), zzsi);
    }

    public final void zzk(long j) {
        zzjj zzjj = this.zzj;
        if (zzjj != null) {
            zzjj.zzm(j);
        }
    }

    public final boolean zzl(zzsg zzsg) {
        zzjj zzjj = this.zzj;
        return zzjj != null && zzjj.zza == zzsg;
    }

    public final boolean zzm(zzjj zzjj) {
        boolean z = false;
        zzdd.zzf(zzjj != null);
        if (zzjj.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzjj;
        while (zzjj.zzg() != null) {
            zzjj = zzjj.zzg();
            if (zzjj == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzjj.zzn();
            this.zzk--;
        }
        this.zzj.zzo((zzjj) null);
        zzy();
        return z;
    }

    public final boolean zzn() {
        zzjj zzjj = this.zzj;
        if (zzjj == null || (!zzjj.zzf.zzi && zzjj.zzr() && this.zzj.zzf.zze != C.TIME_UNSET && this.zzk < 100)) {
            return true;
        }
        return false;
    }

    public final boolean zzo(zzcn zzcn, long j, long j2) {
        zzjj zzjj;
        zzjk zzjk;
        long j3;
        boolean z;
        zzcn zzcn2 = zzcn;
        zzjj zzjj2 = this.zzh;
        zzjj zzjj3 = null;
        while (true) {
            zzjj zzjj4 = zzjj3;
            zzjj3 = zzjj2;
            zzjj = zzjj4;
            if (zzjj3 == null) {
                return true;
            }
            zzjk zzjk2 = zzjj3.zzf;
            if (zzjj == null) {
                zzjk = zzg(zzcn2, zzjk2);
                long j4 = j;
            } else {
                zzjk zzt = zzt(zzcn2, zzjj, j);
                if (zzt == null) {
                    return !zzm(zzjj);
                }
                if (zzjk2.zzb == zzt.zzb && zzjk2.zza.equals(zzt.zza)) {
                    zzjk = zzt;
                }
            }
            zzjj3.zzf = zzjk.zza(zzjk2.zzc);
            long j5 = zzjk2.zze;
            long j6 = zzjk.zze;
            if (j5 == C.TIME_UNSET || j5 == j6) {
                zzjj2 = zzjj3.zzg();
            } else {
                zzjj3.zzq();
                long j7 = zzjk.zze;
                if (j7 == C.TIME_UNSET) {
                    j3 = Long.MAX_VALUE;
                } else {
                    j3 = j7 + zzjj3.zze();
                }
                if (zzjj3 == this.zzi) {
                    boolean z2 = zzjj3.zzf.zzf;
                    if (j2 == Long.MIN_VALUE || j2 >= j3) {
                        z = true;
                        return zzm(zzjj3) && !z;
                    }
                }
                z = false;
                if (zzm(zzjj3)) {
                }
            }
        }
        return !zzm(zzjj);
    }

    public final boolean zzp(zzcn zzcn, int i) {
        this.zzf = i;
        return zzB(zzcn);
    }

    public final boolean zzq(zzcn zzcn, boolean z) {
        this.zzg = z;
        return zzB(zzcn);
    }

    public final zzjj zzr(zzkb[] zzkbArr, zzvz zzvz, zzwi zzwi, zzjt zzjt, zzjk zzjk, zzwa zzwa) {
        long j;
        zzjj zzjj = this.zzj;
        if (zzjj == null) {
            j = 1000000000000L;
            zzjk zzjk2 = zzjk;
        } else {
            j = (zzjj.zze() + zzjj.zzf.zze) - zzjk.zzb;
        }
        zzjj zzjj2 = new zzjj(zzkbArr, j, zzvz, zzwi, zzjt, zzjk, zzwa, (byte[]) null);
        zzjj zzjj3 = this.zzj;
        if (zzjj3 != null) {
            zzjj3.zzo(zzjj2);
        } else {
            this.zzh = zzjj2;
            this.zzi = zzjj2;
        }
        this.zzl = null;
        this.zzj = zzjj2;
        this.zzk++;
        zzy();
        return zzjj2;
    }
}
