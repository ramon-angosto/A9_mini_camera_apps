package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzasu implements Handler.Callback, zzayb, zzazg, zzayd {
    private zzass zzA;
    private long zzB;
    private zzasq zzC;
    private zzasq zzD;
    private zzasq zzE;
    private zzath zzF;
    private boolean zzG;
    private boolean zzH;
    private int zzI;
    private volatile int zzJ;
    private volatile int zzK;
    private final zzcjv zzL;
    private final zzatb[] zza;
    private final zzatc[] zzb;
    private final zzazh zzc;
    private final zzban zzd;
    private final Handler zze;
    private final HandlerThread zzf;
    private final Handler zzg;
    private final zzasm zzh;
    private final zzatg zzi;
    private final zzatf zzj;
    private zzasr zzk;
    private zzata zzl;
    private zzatb zzm;
    private zzbag zzn;
    private zzaye zzo;
    private zzatb[] zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private int zzv = 0;
    private int zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    public zzasu(zzatb[] zzatbArr, zzazh zzazh, zzcjv zzcjv, boolean z, int i, Handler handler, zzasr zzasr, zzasm zzasm, byte[] bArr) {
        this.zza = zzatbArr;
        this.zzc = zzazh;
        this.zzL = zzcjv;
        this.zzr = z;
        this.zzg = handler;
        this.zzu = 1;
        this.zzk = zzasr;
        this.zzh = zzasm;
        this.zzb = new zzatc[2];
        for (int i2 = 0; i2 < 2; i2++) {
            zzatbArr[i2].zzw(i2);
            this.zzb[i2] = zzatbArr[i2].zzf();
        }
        this.zzd = new zzban();
        this.zzp = new zzatb[0];
        this.zzi = new zzatg();
        this.zzj = new zzatf();
        zzazh.zzf(this);
        this.zzl = zzata.zza;
        this.zzf = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzf.start();
        this.zze = new Handler(this.zzf.getLooper(), this);
    }

    private final void zzA(Object obj, int i) {
        this.zzk = new zzasr(0, 0);
        zzD(obj, i);
        this.zzk = new zzasr(0, C.TIME_UNSET);
        zzJ(4);
        zzE(false);
    }

    private final void zzB() {
        long j;
        zzasq zzasq = this.zzC;
        if (!zzasq.zzj) {
            j = 0;
        } else {
            j = zzasq.zza.zza();
        }
        if (j == Long.MIN_VALUE) {
            zzH(false);
            return;
        }
        zzasq zzasq2 = this.zzC;
        long j2 = this.zzB - (zzasq2.zzf - zzasq2.zzh);
        boolean zzj2 = this.zzL.zzj(j - j2);
        zzH(zzj2);
        if (zzj2) {
            this.zzC.zza.zzbj(j2);
        }
    }

    private final void zzC() throws IOException {
        zzasq zzasq = this.zzC;
        if (zzasq != null && !zzasq.zzj) {
            zzasq zzasq2 = this.zzD;
            if (zzasq2 == null || zzasq2.zzl == zzasq) {
                zzatb[] zzatbArr = this.zzp;
                int length = zzatbArr.length;
                int i = 0;
                while (i < length) {
                    if (zzatbArr[i].zzA()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzC.zza.zzs();
            }
        }
    }

    private final void zzD(Object obj, int i) {
        this.zzg.obtainMessage(6, new zzast(this.zzF, obj, this.zzk, i)).sendToTarget();
    }

    private final void zzE(boolean z) {
        this.zze.removeMessages(2);
        this.zzs = false;
        this.zzd.zzc();
        this.zzn = null;
        this.zzm = null;
        this.zzB = 60000000;
        for (zzatb zzatb : this.zzp) {
            try {
                zzQ(zzatb);
                zzatb.zzj();
            } catch (zzasi | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzp = new zzatb[0];
        zzasq zzasq = this.zzE;
        if (zzasq == null) {
            zzasq = this.zzC;
        }
        zzR(zzasq);
        this.zzC = null;
        this.zzD = null;
        this.zzE = null;
        zzH(false);
        if (z) {
            zzaye zzaye = this.zzo;
            if (zzaye != null) {
                zzaye.zzd();
                this.zzo = null;
            }
            this.zzF = null;
        }
    }

    private final void zzF(long j) throws zzasi {
        long j2;
        zzasq zzasq = this.zzE;
        if (zzasq == null) {
            j2 = j + 60000000;
        } else {
            j2 = j + (zzasq.zzf - zzasq.zzh);
        }
        this.zzB = j2;
        this.zzd.zza(j2);
        for (zzatb zzu2 : this.zzp) {
            zzu2.zzu(this.zzB);
        }
    }

    private final void zzG(long j, long j2) {
        this.zze.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.zze.sendEmptyMessage(2);
        } else {
            this.zze.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final void zzH(boolean z) {
        if (this.zzt != z) {
            this.zzt = z;
            this.zzg.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzI(zzasq zzasq) throws zzasi {
        if (this.zzE != zzasq) {
            boolean[] zArr = new boolean[2];
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                zzatb zzatb = this.zza[i2];
                zArr[i2] = zzatb.zzb() != 0;
                zzayx zza2 = zzasq.zzm.zzb.zza(i2);
                if (zza2 != null) {
                    i++;
                }
                if (zArr[i2] && (zza2 == null || (zzatb.zzB() && zzatb.zzh() == this.zzE.zzd[i2]))) {
                    if (zzatb == this.zzm) {
                        this.zzd.zzd(this.zzn);
                        this.zzn = null;
                        this.zzm = null;
                    }
                    zzQ(zzatb);
                    zzatb.zzj();
                }
            }
            this.zzE = zzasq;
            this.zzg.obtainMessage(3, zzasq.zzm).sendToTarget();
            zzz(zArr, i);
        }
    }

    private final void zzJ(int i) {
        if (this.zzu != i) {
            this.zzu = i;
            this.zzg.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzK() throws zzasi {
        this.zzs = false;
        this.zzd.zzb();
        for (zzatb zzy2 : this.zzp) {
            zzy2.zzy();
        }
    }

    private final void zzL() {
        zzE(true);
        this.zzL.zzc();
        zzJ(1);
    }

    private final void zzM() throws zzasi {
        this.zzd.zzc();
        for (zzatb zzQ : this.zzp) {
            zzQ(zzQ);
        }
    }

    private final void zzN() throws zzasi {
        long j;
        zzasq zzasq = this.zzE;
        if (zzasq != null) {
            long zzh2 = zzasq.zza.zzh();
            if (zzh2 != C.TIME_UNSET) {
                zzF(zzh2);
            } else {
                zzatb zzatb = this.zzm;
                if (zzatb == null || zzatb.zzE()) {
                    this.zzB = this.zzd.zzI();
                } else {
                    long zzI2 = this.zzn.zzI();
                    this.zzB = zzI2;
                    this.zzd.zza(zzI2);
                }
                zzasq zzasq2 = this.zzE;
                zzh2 = this.zzB - (zzasq2.zzf - zzasq2.zzh);
            }
            this.zzk.zzc = zzh2;
            this.zzy = SystemClock.elapsedRealtime() * 1000;
            if (this.zzp.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzE.zza.zzg();
            }
            zzasr zzasr = this.zzk;
            if (j == Long.MIN_VALUE) {
                j = this.zzF.zzd(this.zzE.zzg, this.zzj, false).zzc;
            }
            zzasr.zzd = j;
        }
    }

    private final boolean zzO(int i) {
        this.zzF.zzd(i, this.zzj, false);
        this.zzF.zzg(0, this.zzi, false);
        if (this.zzF.zzf(i, this.zzj, this.zzi, this.zzv) == -1) {
            return true;
        }
        return false;
    }

    private final boolean zzP(long j) {
        if (j == C.TIME_UNSET || this.zzk.zzc < j) {
            return true;
        }
        zzasq zzasq = this.zzE.zzl;
        if (zzasq != null) {
            return zzasq.zzj;
        }
        return false;
    }

    private static final void zzQ(zzatb zzatb) throws zzasi {
        if (zzatb.zzb() == 2) {
            zzatb.zzz();
        }
    }

    private static final void zzR(zzasq zzasq) {
        while (zzasq != null) {
            zzasq.zzc();
            zzasq = zzasq.zzl;
        }
    }

    private final int zzt(int i, zzath zzath, zzath zzath2) {
        int zzb2 = zzath.zzb();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzb2 && i3 == -1; i4++) {
            i2 = zzath.zzf(i2, this.zzj, this.zzi, this.zzv);
            i3 = zzath2.zza(zzath.zzd(i2, this.zzj, true).zzb);
        }
        return i3;
    }

    private final long zzu(int i, long j) throws zzasi {
        zzasq zzasq;
        zzM();
        this.zzs = false;
        zzJ(2);
        zzasq zzasq2 = this.zzE;
        if (zzasq2 == null) {
            zzasq zzasq3 = this.zzC;
            if (zzasq3 != null) {
                zzasq3.zzc();
            }
            zzasq = null;
        } else {
            zzasq = null;
            while (zzasq2 != null) {
                if (zzasq2.zzg != i || !zzasq2.zzj) {
                    zzasq2.zzc();
                } else {
                    zzasq = zzasq2;
                }
                zzasq2 = zzasq2.zzl;
            }
        }
        zzasq zzasq4 = this.zzE;
        if (!(zzasq4 == zzasq && zzasq4 == this.zzD)) {
            for (zzatb zzj2 : this.zzp) {
                zzj2.zzj();
            }
            this.zzp = new zzatb[0];
            this.zzn = null;
            this.zzm = null;
            this.zzE = null;
        }
        if (zzasq != null) {
            zzasq.zzl = null;
            this.zzC = zzasq;
            this.zzD = zzasq;
            zzI(zzasq);
            zzasq zzasq5 = this.zzE;
            if (zzasq5.zzk) {
                j = zzasq5.zza.zzi(j);
            }
            zzF(j);
            zzB();
        } else {
            this.zzC = null;
            this.zzD = null;
            this.zzE = null;
            zzF(j);
        }
        this.zze.sendEmptyMessage(2);
        return j;
    }

    private final Pair zzv(int i, long j) {
        return zzw(this.zzF, 0, C.TIME_UNSET);
    }

    private final Pair zzw(zzath zzath, int i, long j) {
        return zzx(zzath, 0, j, 0);
    }

    private final Pair zzx(zzath zzath, int i, long j, long j2) {
        zzbac.zza(0, 0, zzath.zzc());
        zzath.zze(0, this.zzi, false, j2);
        if (j == C.TIME_UNSET) {
            j = 0;
        }
        long j3 = zzath.zzd(0, this.zzj, false).zzc;
        if (j3 != C.TIME_UNSET) {
            int i2 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j));
    }

    private final Pair zzy(zzass zzass) {
        zzath zzath = zzass.zza;
        if (zzath.zzh()) {
            zzath = this.zzF;
        }
        try {
            int i = zzass.zzb;
            Pair zzw2 = zzw(zzath, 0, zzass.zzc);
            zzath zzath2 = this.zzF;
            if (zzath2 == zzath) {
                return zzw2;
            }
            if (zzath2.zza(zzath.zzd(((Integer) zzw2.first).intValue(), this.zzj, true).zzb) != -1) {
                return Pair.create(0, (Long) zzw2.second);
            }
            if (zzt(((Integer) zzw2.first).intValue(), zzath, this.zzF) == -1) {
                return null;
            }
            this.zzF.zzd(0, this.zzj, false);
            return zzv(0, C.TIME_UNSET);
        } catch (IndexOutOfBoundsException unused) {
            zzath zzath3 = this.zzF;
            int i2 = zzass.zzb;
            throw new zzasy(zzath3, 0, zzass.zzc);
        }
    }

    private final void zzz(boolean[] zArr, int i) throws zzasi {
        int i2;
        this.zzp = new zzatb[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 2) {
            zzatb zzatb = this.zza[i3];
            zzayx zza2 = this.zzE.zzm.zzb.zza(i3);
            if (zza2 != null) {
                int i5 = i4 + 1;
                this.zzp[i4] = zzatb;
                if (zzatb.zzb() == 0) {
                    zzatd zzatd = this.zzE.zzm.zzd[i3];
                    boolean z = this.zzr && this.zzu == 3;
                    boolean z2 = !zArr[i3] && z;
                    zza2.zzb();
                    zzasw[] zzaswArr = new zzasw[1];
                    for (int i6 = 0; i6 <= 0; i6++) {
                        zzaswArr[i6] = zza2.zzc(i6);
                    }
                    zzasq zzasq = this.zzE;
                    i2 = i3;
                    zzatb.zzk(zzatd, zzaswArr, zzasq.zzd[i3], this.zzB, z2, zzasq.zzf - zzasq.zzh);
                    zzbag zzi2 = zzatb.zzi();
                    if (zzi2 != null) {
                        if (this.zzn == null) {
                            this.zzn = zzi2;
                            this.zzm = zzatb;
                            this.zzn.zzK(this.zzl);
                        } else {
                            throw zzasi.zzc(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zzatb.zzy();
                    }
                } else {
                    i2 = i3;
                }
                i4 = i5;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:435:0x07ac, code lost:
        if (zzP(r1) != false) goto L_0x07ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0890, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x0891, code lost:
        r2 = r0;
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x0894, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x0895, code lost:
        r2 = r0;
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:509:0x0898, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:0x0899, code lost:
        r2 = r0;
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:512:0x089e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:513:0x089f, code lost:
        r2 = r0;
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x08a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:516:0x08a5, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r8.zzg.obtainMessage(8, com.google.android.gms.internal.ads.zzasi.zzc(r1)).sendToTarget();
        zzL();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:517:0x08c0, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x08c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:519:0x08c2, code lost:
        r1 = true;
        r3 = 8;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x08de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:523:0x08df, code lost:
        r1 = true;
        r3 = 8;
        r2 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x026e A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0272 A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0277 A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0338 A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x034c A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x04fa A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0501 A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0518 A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x051b A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0556 A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x056a A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0584 A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }, LOOP:8: B:318:0x0584->B:322:0x0594, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[Catch:{ all -> 0x0424, all -> 0x036c, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x06db A[Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x08a4 A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r34) {
        /*
            r33 = this;
            r8 = r33
            r1 = r34
            r10 = 1
            int r2 = r1.what     // Catch:{ zzasi -> 0x08de, IOException -> 0x08c1, RuntimeException -> 0x08a4 }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x085b;
                case 1: goto L_0x082c;
                case 2: goto L_0x0439;
                case 3: goto L_0x0392;
                case 4: goto L_0x0374;
                case 5: goto L_0x0370;
                case 6: goto L_0x0359;
                case 7: goto L_0x01fa;
                case 8: goto L_0x01c8;
                case 9: goto L_0x01b8;
                case 10: goto L_0x00da;
                case 11: goto L_0x009c;
                case 12: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r1 = r9
            return r1
        L_0x001a:
            int r1 = r1.arg1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzv = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0024:
            if (r2 != 0) goto L_0x0028
            goto L_0x009b
        L_0x0028:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != r3) goto L_0x002e
            r3 = r10
            goto L_0x002f
        L_0x002e:
            r3 = r9
        L_0x002f:
            com.google.android.gms.internal.ads.zzasq r4 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != r4) goto L_0x0035
            r4 = r10
            goto L_0x0036
        L_0x0035:
            r4 = r9
        L_0x0036:
            com.google.android.gms.internal.ads.zzath r11 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r12 = r2.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r13 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r11 = r11.zzf(r12, r13, r14, r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzasq r12 = r2.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r12 == 0) goto L_0x0068
            if (r11 == r5) goto L_0x0068
            int r13 = r12.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r13 != r11) goto L_0x0068
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r12 != r2) goto L_0x0052
            r2 = r10
            goto L_0x0053
        L_0x0052:
            r2 = r9
        L_0x0053:
            r3 = r3 | r2
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r12 != r2) goto L_0x005a
            r2 = r10
            goto L_0x005b
        L_0x005a:
            r2 = r9
        L_0x005b:
            r4 = r4 | r2
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r11 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r11 = r2.zzf(r13, r11, r14, r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2 = r12
            goto L_0x0042
        L_0x0068:
            if (r12 == 0) goto L_0x006f
            zzR(r12)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzl = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x006f:
            int r5 = r2.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            boolean r5 = r8.zzO(r5)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzi = r5     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r4 != 0) goto L_0x007b
            r8.zzC = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x007b:
            if (r3 != 0) goto L_0x0092
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x0092
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r3 = r3.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r3 = r8.zzu(r2, r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r5 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r5.<init>(r2, r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r5     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0092:
            int r2 = r8.zzu     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != r15) goto L_0x009b
            if (r1 == 0) goto L_0x009b
            r8.zzJ(r7)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x009b:
            return r10
        L_0x009c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasl[] r1 = (com.google.android.gms.internal.ads.zzasl[]) r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r1.length     // Catch:{ all -> 0x00c9 }
        L_0x00a1:
            if (r9 >= r2) goto L_0x00b1
            r3 = r1[r9]     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzask r4 = r3.zza     // Catch:{ all -> 0x00c9 }
            int r5 = r3.zzb     // Catch:{ all -> 0x00c9 }
            java.lang.Object r3 = r3.zzc     // Catch:{ all -> 0x00c9 }
            r4.zzl(r5, r3)     // Catch:{ all -> 0x00c9 }
            int r9 = r9 + 1
            goto L_0x00a1
        L_0x00b1:
            com.google.android.gms.internal.ads.zzaye r1 = r8.zzo     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00ba
            android.os.Handler r1 = r8.zze     // Catch:{ all -> 0x00c9 }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00c9 }
        L_0x00ba:
            monitor-enter(r33)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r1 = r8.zzx     // Catch:{ all -> 0x00c5 }
            int r1 = r1 + r10
            r8.zzx = r1     // Catch:{ all -> 0x00c5 }
            r33.notifyAll()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            return r10
        L_0x00c5:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            throw r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x00c9:
            r0 = move-exception
            r1 = r0
            monitor-enter(r33)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r8.zzx     // Catch:{ all -> 0x00d6 }
            int r2 = r2 + r10
            r8.zzx = r2     // Catch:{ all -> 0x00d6 }
            r33.notifyAll()     // Catch:{ all -> 0x00d6 }
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x00d6:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x00da:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x01b7
            r2 = r10
        L_0x00df:
            if (r1 == 0) goto L_0x01b7
            boolean r3 = r1.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 != 0) goto L_0x00e7
            goto L_0x01b7
        L_0x00e7:
            boolean r3 = r1.zze()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x01ab
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == r3) goto L_0x00f7
            r2 = r10
            goto L_0x00f8
        L_0x00f7:
            r2 = r9
        L_0x00f8:
            com.google.android.gms.internal.ads.zzasq r3 = r3.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            zzR(r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3.zzl = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzC = r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzD = r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            boolean[] r4 = new boolean[r7]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r5 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r11 = r5.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r2 = r3.zzb(r11, r2, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r5 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r11 = r5.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzasr r5 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r5.zzc = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzF(r2)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x011e:
            boolean[] r2 = new boolean[r7]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3 = r9
            r5 = r3
        L_0x0122:
            if (r3 >= r7) goto L_0x0169
            com.google.android.gms.internal.ads.zzatb[] r11 = r8.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r11 = r11[r3]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r12 = r11.zzb()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r12 == 0) goto L_0x0130
            r12 = r10
            goto L_0x0131
        L_0x0130:
            r12 = r9
        L_0x0131:
            r2[r3] = r12     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r13 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayo[] r13 = r13.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r13 = r13[r3]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r13 == 0) goto L_0x013d
            int r5 = r5 + 1
        L_0x013d:
            if (r12 == 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzayo r12 = r11.zzh()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r13 == r12) goto L_0x015d
            com.google.android.gms.internal.ads.zzatb r12 = r8.zzm     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r11 != r12) goto L_0x0156
            if (r13 != 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzban r12 = r8.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzbag r13 = r8.zzn     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r12.zzd(r13)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0152:
            r8.zzn = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzm = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0156:
            zzQ(r11)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r11.zzj()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0166
        L_0x015d:
            boolean r12 = r4[r3]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r12 == 0) goto L_0x0166
            long r12 = r8.zzB     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r11.zzu(r12)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0166:
            int r3 = r3 + 1
            goto L_0x0122
        L_0x0169:
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzazi r1 = r1.zzm     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzz(r2, r5)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x019f
        L_0x0178:
            r8.zzC = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x017e:
            if (r1 == 0) goto L_0x0186
            r1.zzc()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x017e
        L_0x0186:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.zzl = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            boolean r2 = r1.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x019f
            long r2 = r1.zzh     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r4 = r8.zzB     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r11 = r1.zzf     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r11 = r11 - r2
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r2, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3.zza(r1, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x019f:
            r33.zzB()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r33.zzN()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.sendEmptyMessage(r7)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x01b7
        L_0x01ab:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 != r3) goto L_0x01b1
            r3 = r9
            goto L_0x01b2
        L_0x01b1:
            r3 = r10
        L_0x01b2:
            r2 = r2 & r3
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x00df
        L_0x01b7:
            return r10
        L_0x01b8:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayc r1 = (com.google.android.gms.internal.ads.zzayc) r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x01c7
            com.google.android.gms.internal.ads.zzayc r2 = r2.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != r1) goto L_0x01c7
            r33.zzB()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x01c7:
            return r10
        L_0x01c8:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayc r1 = (com.google.android.gms.internal.ads.zzayc) r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x01f9
            com.google.android.gms.internal.ads.zzayc r3 = r2.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 == r1) goto L_0x01d5
            goto L_0x01f9
        L_0x01d5:
            r2.zzj = r10     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zze()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r3 = r2.zzh     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r3 = r2.zza(r3, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzh = r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 != 0) goto L_0x01f6
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzD = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r1 = r1.zzh     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzF(r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzI(r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x01f6:
            r33.zzB()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x01f9:
            return r10
        L_0x01fa:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r3 = r1.first     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r3 = (com.google.android.gms.internal.ads.zzath) r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzF = r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r1 = r1.second     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x0269
            int r3 = r8.zzz     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 <= 0) goto L_0x0239
            com.google.android.gms.internal.ads.zzass r3 = r8.zzA     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.util.Pair r3 = r8.zzy(r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r4 = r8.zzz     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzz = r9     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzA = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 != 0) goto L_0x0221
            r8.zzA(r1, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0358
        L_0x0221:
            com.google.android.gms.internal.ads.zzasr r7 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r11 = r3.first     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r11 = r11.intValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r3 = r3.second     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r14 = r3.longValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r7.<init>(r11, r14)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r7     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x026a
        L_0x0239:
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r3 = r3.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x0269
            com.google.android.gms.internal.ads.zzath r3 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            boolean r3 = r3.zzh()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x024e
            r8.zzA(r1, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0358
        L_0x024e:
            android.util.Pair r3 = r8.zzv(r9, r12)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r4 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r7 = r3.first     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r7 = r7.intValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r3 = r3.second     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r14 = r3.longValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r4.<init>(r7, r14)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r4     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0269:
            r4 = r9
        L_0x026a:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 != 0) goto L_0x0270
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0270:
            if (r3 != 0) goto L_0x0277
            r8.zzD(r1, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0358
        L_0x0277:
            com.google.android.gms.internal.ads.zzath r7 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r11 = r3.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r7 = r7.zza(r11)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r7 != r5) goto L_0x02da
            int r6 = r3.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r7 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r8.zzt(r6, r2, r7)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != r5) goto L_0x0290
            r8.zzA(r1, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0358
        L_0x0290:
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r6 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzd(r9, r6, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.util.Pair r2 = r8.zzv(r9, r12)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r6 = r2.first     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r6 = r6.intValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r2 = r2.second     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r11 = r2.longValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzd(r6, r7, r10)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r2 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r2 = r2.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3.zzg = r5     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x02b8:
            com.google.android.gms.internal.ads.zzasq r3 = r3.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x02ca
            java.lang.Object r7 = r3.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            boolean r7 = r7.equals(r2)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r10 == r7) goto L_0x02c6
            r7 = r5
            goto L_0x02c7
        L_0x02c6:
            r7 = r6
        L_0x02c7:
            r3.zzg = r7     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x02b8
        L_0x02ca:
            long r2 = r8.zzu(r6, r11)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r5 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r5.<init>(r6, r2)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r5     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzD(r1, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0358
        L_0x02da:
            boolean r2 = r8.zzO(r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3.zzg = r9     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3.zzi = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 != r2) goto L_0x02e8
            r2 = r10
            goto L_0x02e9
        L_0x02e8:
            r2 = r9
        L_0x02e9:
            com.google.android.gms.internal.ads.zzasr r11 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r12 = r11.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r12 == 0) goto L_0x0300
            com.google.android.gms.internal.ads.zzasr r12 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r13 = r11.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r12.<init>(r9, r13)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r13 = r11.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r12.zzc = r13     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r13 = r11.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r12.zzd = r13     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r12     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0300:
            com.google.android.gms.internal.ads.zzasq r11 = r3.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r11 == 0) goto L_0x0355
            com.google.android.gms.internal.ads.zzath r12 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r13 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r15 = r8.zzv     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r7 = r12.zzf(r7, r13, r14, r15)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r7 == r5) goto L_0x0336
            java.lang.Object r12 = r11.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r13 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r14 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r13 = r13.zzd(r7, r14, r10)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r13 = r13.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            boolean r12 = r12.equals(r13)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r12 == 0) goto L_0x0336
            boolean r3 = r8.zzO(r7)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r11.zzg = r7     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r11.zzi = r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r11 != r3) goto L_0x0332
            r3 = r10
            goto L_0x0333
        L_0x0332:
            r3 = r9
        L_0x0333:
            r2 = r2 | r3
            r3 = r11
            goto L_0x0300
        L_0x0336:
            if (r2 != 0) goto L_0x034c
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r5 = r3.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r5 = r8.zzu(r2, r5)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r3 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3.<init>(r2, r5)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0355
        L_0x034c:
            r8.zzC = r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzl = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            zzR(r11)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0355:
            r8.zzD(r1, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0358:
            return r10
        L_0x0359:
            r8.zzE(r10)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzcjv r1 = r8.zzL     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.zzb()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzJ(r10)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            monitor-enter(r33)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzq = r10     // Catch:{ all -> 0x036c }
            r33.notifyAll()     // Catch:{ all -> 0x036c }
            monitor-exit(r33)     // Catch:{ all -> 0x036c }
            return r10
        L_0x036c:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x036c }
            throw r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0370:
            r33.zzL()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            return r10
        L_0x0374:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzata r1 = (com.google.android.gms.internal.ads.zzata) r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzbag r2 = r8.zzn     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x0381
            com.google.android.gms.internal.ads.zzata r1 = r2.zzK(r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0386
        L_0x0381:
            com.google.android.gms.internal.ads.zzban r2 = r8.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzK(r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0386:
            r8.zzl = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            return r10
        L_0x0392:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzass r1 = (com.google.android.gms.internal.ads.zzass) r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x03a3
            int r2 = r8.zzz     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r2 + r10
            r8.zzz = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzA = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0423
        L_0x03a3:
            android.util.Pair r2 = r8.zzy(r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x03c9
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.<init>(r9, r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Handler r1 = r8.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r2 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Message r1 = r1.obtainMessage(r15, r10, r9, r2)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.<init>(r9, r12)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzJ(r15)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzE(r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0423
        L_0x03c9:
            long r3 = r1.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03d1
            r1 = r10
            goto L_0x03d2
        L_0x03d1:
            r1 = r9
        L_0x03d2:
            java.lang.Object r3 = r2.first     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r3 = r3.intValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r2 = r2.second     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r4 = r2.longValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r2 = r8.zzk     // Catch:{ all -> 0x0424 }
            int r6 = r2.zza     // Catch:{ all -> 0x0424 }
            if (r3 != r6) goto L_0x0407
            r16 = 1000(0x3e8, double:4.94E-321)
            long r6 = r4 / r16
            long r11 = r2.zzc     // Catch:{ all -> 0x0424 }
            long r11 = r11 / r16
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0407
            com.google.android.gms.internal.ads.zzasr r2 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.<init>(r3, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0403:
            r1.sendToTarget()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0423
        L_0x0407:
            long r6 = r8.zzu(r3, r4)     // Catch:{ all -> 0x0424 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0411
            r2 = r10
            goto L_0x0412
        L_0x0411:
            r2 = r9
        L_0x0412:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzasr r2 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.<init>(r3, r6)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0403
        L_0x0423:
            return r10
        L_0x0424:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzasr r6 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r6.<init>(r3, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r6     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r4 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            throw r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0439:
            r16 = 1000(0x3e8, double:4.94E-321)
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 != 0) goto L_0x044b
            com.google.android.gms.internal.ads.zzaye r1 = r8.zzo     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.zza()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r11 = r5
            goto L_0x068b
        L_0x044b:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 != 0) goto L_0x0454
            com.google.android.gms.internal.ads.zzasr r1 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r1 = r1.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0489
        L_0x0454:
            int r2 = r1.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            boolean r7 = r1.zzi     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r7 != 0) goto L_0x0565
            boolean r1 = r1.zzd()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0565
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r1 = r1.zzd(r2, r7, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r14 = r1.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0565
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x047d
            com.google.android.gms.internal.ads.zzasq r7 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r7 = r7.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r1 = r1.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r7 = r7 - r1
            r1 = 100
            if (r7 == r1) goto L_0x0565
        L_0x047d:
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r15 = r8.zzv     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r1 = r1.zzf(r2, r7, r14, r15)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0489:
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r2.zzb()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 < r2) goto L_0x0498
            com.google.android.gms.internal.ads.zzaye r1 = r8.zzo     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.zza()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0565
        L_0x0498:
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x04a3
            com.google.android.gms.internal.ads.zzasr r2 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r3 = r2.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x04a0:
            r11 = r5
            r15 = 2
            goto L_0x04f6
        L_0x04a3:
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzd(r1, r7, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatg r7 = r8.zzi     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzg(r9, r7, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x04b4
            goto L_0x04a0
        L_0x04b4:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r14 = r1.zzf     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r11 = r1.zzh     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r14 = r14 - r11
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r1 = r1.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r1 = r2.zzd(r1, r7, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r1 = r1.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r14 = r14 + r1
            long r1 = r8.zzB     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r14 = r14 - r1
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r7 = 0
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r13 = java.lang.Math.max(r3, r14)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1 = r33
            r3 = r7
            r6 = r5
            r4 = r11
            r11 = r6
            r15 = 2
            r6 = r13
            android.util.Pair r1 = r1.zzx(r2, r3, r4, r6)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0566
            java.lang.Object r2 = r1.first     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r2.intValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r1 = r1.second     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r3 = r1.longValue()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1 = r2
        L_0x04f6:
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x0501
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x04fe:
            r21 = r5
            goto L_0x0514
        L_0x0501:
            long r5 = r2.zzf     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r13 = r2.zzh     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r5 = r5 - r13
            com.google.android.gms.internal.ads.zzath r7 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r13 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r2 = r7.zzd(r2, r13, r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r13 = r2.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r5 = r5 + r13
            goto L_0x04fe
        L_0x0514:
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x051b
            r27 = r9
            goto L_0x0520
        L_0x051b:
            int r2 = r2.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r2 = r2 + r10
            r27 = r2
        L_0x0520:
            boolean r29 = r8.zzO(r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r5 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2.zzd(r1, r5, r10)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = new com.google.android.gms.internal.ads.zzasq     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatb[] r5 = r8.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatc[] r6 = r8.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzazh r7 = r8.zzc     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzcjv r13 = r8.zzL     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzaye r14 = r8.zzo     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r15 = r8.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            java.lang.Object r15 = r15.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r32 = 0
            r18 = r2
            r19 = r5
            r20 = r6
            r23 = r7
            r24 = r13
            r25 = r14
            r26 = r15
            r28 = r1
            r30 = r3
            r18.<init>(r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r32)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0558
            r1.zzl = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0558:
            r8.zzC = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayc r1 = r1.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.zzw(r8, r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzH(r10)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0566
        L_0x0565:
            r11 = r5
        L_0x0566:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x057d
            boolean r1 = r1.zzd()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0571
            goto L_0x057d
        L_0x0571:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0580
            boolean r1 = r8.zzt     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 != 0) goto L_0x0580
            r33.zzB()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0580
        L_0x057d:
            r8.zzH(r9)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x0580:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x068b
        L_0x0584:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == r2) goto L_0x05bb
            long r3 = r8.zzB     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r5 = r1.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r5 = r5.zzf     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x05bb
            r1.zzc()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzI(r1)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r3 = r2.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r4 = r2.zzh     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.<init>(r3, r4)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r33.zzN()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Handler r1 = r8.zzg     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2 = 5
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0584
        L_0x05bb:
            boolean r1 = r2.zzi     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x05e1
            r1 = r9
        L_0x05c0:
            r2 = 2
            if (r1 >= r2) goto L_0x068b
            com.google.android.gms.internal.ads.zzatb[] r2 = r8.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2 = r2[r1]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayo[] r3 = r3.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3 = r3[r1]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x05de
            com.google.android.gms.internal.ads.zzayo r4 = r2.zzh()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r4 != r3) goto L_0x05de
            boolean r3 = r2.zzA()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x05de
            r2.zzv()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
        L_0x05de:
            int r1 = r1 + 1
            goto L_0x05c0
        L_0x05e1:
            r1 = r9
        L_0x05e2:
            r2 = 2
            if (r1 >= r2) goto L_0x0600
            com.google.android.gms.internal.ads.zzatb[] r2 = r8.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2 = r2[r1]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayo[] r3 = r3.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r3 = r3[r1]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayo r4 = r2.zzh()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r4 != r3) goto L_0x068b
            if (r3 == 0) goto L_0x05fd
            boolean r2 = r2.zzA()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x068b
        L_0x05fd:
            int r1 = r1 + 1
            goto L_0x05e2
        L_0x0600:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r1.zzl     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x068b
            boolean r3 = r2.zzj     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x068b
            com.google.android.gms.internal.ads.zzazi r1 = r1.zzm     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r8.zzD = r2     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzazi r3 = r2.zzm     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayc r2 = r2.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r4 = r2.zzh()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r2 = r9
            r6 = 2
        L_0x061a:
            if (r2 >= r6) goto L_0x068b
            com.google.android.gms.internal.ads.zzatb[] r6 = r8.zza     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r6 = r6[r2]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzazf r7 = r1.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayx r7 = r7.zza(r2)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r7 != 0) goto L_0x062d
        L_0x0628:
            r19 = r3
            r20 = r4
            goto L_0x0681
        L_0x062d:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x063a
            r6.zzv()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            goto L_0x0628
        L_0x063a:
            boolean r7 = r6.zzB()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r7 != 0) goto L_0x0628
            com.google.android.gms.internal.ads.zzazf r7 = r3.zzb     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayx r7 = r7.zza(r2)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatd[] r13 = r1.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r13 = r13[r2]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatd[] r14 = r3.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r14 = r14[r2]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r7 == 0) goto L_0x067a
            boolean r13 = r14.equals(r13)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            if (r13 == 0) goto L_0x067a
            r7.zzb()     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasw[] r13 = new com.google.android.gms.internal.ads.zzasw[r10]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r14 = r9
        L_0x065c:
            if (r14 > 0) goto L_0x0667
            com.google.android.gms.internal.ads.zzasw r15 = r7.zzc(r14)     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r13[r14] = r15     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            int r14 = r14 + 1
            goto L_0x065c
        L_0x0667:
            com.google.android.gms.internal.ads.zzasq r7 = r8.zzD     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayo[] r14 = r7.zzd     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            r14 = r14[r2]     // Catch:{ zzasi -> 0x0827, IOException -> 0x0822, RuntimeException -> 0x08a4 }
            long r9 = r7.zzf     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r19 = r3
            r20 = r4
            long r3 = r7.zzh     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r9 = r9 - r3
            r6.zzt(r13, r14, r9)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x0681
        L_0x067a:
            r19 = r3
            r20 = r4
            r6.zzv()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x0681:
            int r2 = r2 + 1
            r3 = r19
            r4 = r20
            r6 = 2
            r9 = 0
            r10 = 1
            goto L_0x061a
        L_0x068b:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2 = 10
            if (r1 != 0) goto L_0x069a
            r33.zzC()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r8.zzG(r11, r2)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x0697:
            r1 = 1
            goto L_0x0821
        L_0x069a:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzbap.zza(r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r33.zzN()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzayc r1 = r1.zza     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r4 = r8.zzk     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r4 = r4.zzc     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r1.zzq(r4)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatb[] r1 = r8.zzp     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r4 = r1.length     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x06b3:
            if (r5 >= r4) goto L_0x06ea
            r9 = r1[r5]     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r13 = r8.zzB     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r2 = r8.zzy     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r9.zzD(r13, r2)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r7 == 0) goto L_0x06c8
            boolean r2 = r9.zzE()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x06c8
            r7 = 1
            goto L_0x06c9
        L_0x06c8:
            r7 = 0
        L_0x06c9:
            boolean r2 = r9.zzF()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x06d8
            boolean r2 = r9.zzE()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r2 == 0) goto L_0x06d6
            goto L_0x06d8
        L_0x06d6:
            r2 = 0
            goto L_0x06d9
        L_0x06d8:
            r2 = 1
        L_0x06d9:
            if (r2 != 0) goto L_0x06de
            r9.zzm()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x06de:
            if (r6 == 0) goto L_0x06e4
            if (r2 == 0) goto L_0x06e4
            r6 = 1
            goto L_0x06e5
        L_0x06e4:
            r6 = 0
        L_0x06e5:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x06b3
        L_0x06ea:
            if (r6 != 0) goto L_0x06ef
            r33.zzC()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x06ef:
            com.google.android.gms.internal.ads.zzbag r1 = r8.zzn     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0712
            com.google.android.gms.internal.ads.zzata r1 = r1.zzJ()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzata r2 = r8.zzl     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            boolean r2 = r1.equals(r2)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r2 != 0) goto L_0x0712
            r8.zzl = r1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzban r2 = r8.zzd     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzbag r3 = r8.zzn     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2.zzd(r3)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x0712:
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r3 = r8.zzj     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r4 = 0
            com.google.android.gms.internal.ads.zzatf r1 = r1.zzd(r2, r3, r4)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r1 = r1.zzc     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r7 == 0) goto L_0x0743
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0734
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r3 = r3.zzc     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0743
        L_0x0734:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            boolean r3 = r3.zzi     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x0743
            r3 = 4
            r8.zzJ(r3)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r33.zzM()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x07d4
        L_0x0743:
            int r3 = r8.zzu     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r4 = 2
            if (r3 != r4) goto L_0x07ba
            com.google.android.gms.internal.ads.zzatb[] r3 = r8.zzp     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r3 = r3.length     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r3 <= 0) goto L_0x07a8
            if (r6 == 0) goto L_0x07d4
            boolean r1 = r8.zzs     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            boolean r3 = r2.zzj     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r3 != 0) goto L_0x075a
            long r2 = r2.zzh     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x0760
        L_0x075a:
            com.google.android.gms.internal.ads.zzayc r2 = r2.zza     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r2 = r2.zzg()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x0760:
            r4 = -9223372036854775808
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x077a
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            boolean r3 = r2.zzi     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r3 == 0) goto L_0x076d
            goto L_0x07ae
        L_0x076d:
            com.google.android.gms.internal.ads.zzath r3 = r8.zzF     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzatf r4 = r8.zzj     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r5 = 0
            com.google.android.gms.internal.ads.zzatf r2 = r3.zzd(r2, r4, r5)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r2 = r2.zzc     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x077a:
            boolean r4 = r8.zzG     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r4 == 0) goto L_0x0794
            com.google.android.gms.internal.ads.zzcjv r2 = r8.zzL     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r3 = r3.zzd     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r5 = r8.zzC     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r6 = r8.zzB     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r9 = r5.zzf     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r13 = r5.zzh     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r3 = r3 - r6
            boolean r1 = r2.zzk(r3, r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x07a5
        L_0x0794:
            com.google.android.gms.internal.ads.zzcjv r4 = r8.zzL     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasq r5 = r8.zzC     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r6 = r8.zzB     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r9 = r5.zzf     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r13 = r5.zzh     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r2 = r2 - r6
            boolean r1 = r4.zzk(r2, r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x07a5:
            if (r1 == 0) goto L_0x07d4
            goto L_0x07ae
        L_0x07a8:
            boolean r1 = r8.zzP(r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x07d4
        L_0x07ae:
            r1 = 3
            r8.zzJ(r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            boolean r1 = r8.zzr     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x07d4
            r33.zzK()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x07d4
        L_0x07ba:
            r4 = 3
            if (r3 != r4) goto L_0x07d4
            com.google.android.gms.internal.ads.zzatb[] r3 = r8.zzp     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r3 = r3.length     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r3 <= 0) goto L_0x07c3
            goto L_0x07c7
        L_0x07c3:
            boolean r6 = r8.zzP(r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x07c7:
            if (r6 != 0) goto L_0x07d4
            boolean r1 = r8.zzr     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r8.zzs = r1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r1 = 2
            r8.zzJ(r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r33.zzM()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x07d4:
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2 = 2
            if (r1 != r2) goto L_0x07e7
            com.google.android.gms.internal.ads.zzatb[] r1 = r8.zzp     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r2 = r1.length     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r3 = 0
        L_0x07dd:
            if (r3 >= r2) goto L_0x07e7
            r4 = r1[r3]     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r4.zzm()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r3 = r3 + 1
            goto L_0x07dd
        L_0x07e7:
            boolean r1 = r8.zzr     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x07f0
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2 = 3
            if (r1 == r2) goto L_0x07f5
        L_0x07f0:
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2 = 2
            if (r1 != r2) goto L_0x0803
        L_0x07f5:
            int r1 = r8.zzJ     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 <= 0) goto L_0x07fd
            int r1 = r8.zzJ     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r2 = (long) r1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x07ff
        L_0x07fd:
            r2 = 10
        L_0x07ff:
            r8.zzG(r11, r2)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x081c
        L_0x0803:
            com.google.android.gms.internal.ads.zzatb[] r1 = r8.zzp     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r1 = r1.length     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0816
            int r1 = r8.zzK     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 <= 0) goto L_0x0810
            int r1 = r8.zzK     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            long r1 = (long) r1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x0812
        L_0x0810:
            r1 = r16
        L_0x0812:
            r8.zzG(r11, r1)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x081c
        L_0x0816:
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2 = 2
            r1.removeMessages(r2)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x081c:
            com.google.android.gms.internal.ads.zzbap.zzb()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x0697
        L_0x0821:
            return r1
        L_0x0822:
            r0 = move-exception
            r2 = r0
            r1 = r10
            goto L_0x089b
        L_0x0827:
            r0 = move-exception
            r2 = r0
            r1 = r10
            goto L_0x08a1
        L_0x082c:
            int r1 = r1.arg1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x0832
            r1 = 1
            goto L_0x0833
        L_0x0832:
            r1 = 0
        L_0x0833:
            r2 = 0
            r8.zzs = r2     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r8.zzr = r1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 != 0) goto L_0x0842
            r33.zzM()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r33.zzN()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x0840:
            r1 = 1
            goto L_0x085a
        L_0x0842:
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2 = 3
            if (r1 != r2) goto L_0x0851
            r33.zzK()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r2 = 2
            r1.sendEmptyMessage(r2)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x0840
        L_0x0851:
            r2 = 2
            if (r1 != r2) goto L_0x0840
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r1.sendEmptyMessage(r2)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            goto L_0x0840
        L_0x085a:
            return r1
        L_0x085b:
            java.lang.Object r2 = r1.obj     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzaye r2 = (com.google.android.gms.internal.ads.zzaye) r2     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            int r1 = r1.arg1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r4 = 0
            r3.sendEmptyMessage(r4)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r3 = 1
            r8.zzE(r3)     // Catch:{ zzasi -> 0x0894, IOException -> 0x0890, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzcjv r3 = r8.zzL     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r3.zza()     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            if (r1 == 0) goto L_0x087e
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r4, r5)     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
        L_0x087e:
            r8.zzo = r2     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            com.google.android.gms.internal.ads.zzasm r1 = r8.zzh     // Catch:{ zzasi -> 0x089e, IOException -> 0x0898, RuntimeException -> 0x08a4 }
            r3 = 1
            r2.zzb(r1, r3, r8)     // Catch:{ zzasi -> 0x0894, IOException -> 0x0890, RuntimeException -> 0x08a4 }
            r1 = 2
            r8.zzJ(r1)     // Catch:{ zzasi -> 0x0894, IOException -> 0x0890, RuntimeException -> 0x08a4 }
            android.os.Handler r2 = r8.zze     // Catch:{ zzasi -> 0x0894, IOException -> 0x0890, RuntimeException -> 0x08a4 }
            r2.sendEmptyMessage(r1)     // Catch:{ zzasi -> 0x0894, IOException -> 0x0890, RuntimeException -> 0x08a4 }
            return r3
        L_0x0890:
            r0 = move-exception
            r2 = r0
            r1 = r3
            goto L_0x089b
        L_0x0894:
            r0 = move-exception
            r2 = r0
            r1 = r3
            goto L_0x08a1
        L_0x0898:
            r0 = move-exception
            r2 = r0
            r1 = 1
        L_0x089b:
            r3 = 8
            goto L_0x08c6
        L_0x089e:
            r0 = move-exception
            r2 = r0
            r1 = 1
        L_0x08a1:
            r3 = 8
            goto L_0x08e3
        L_0x08a4:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.zzg
            com.google.android.gms.internal.ads.zzasi r1 = com.google.android.gms.internal.ads.zzasi.zzc(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r33.zzL()
            r1 = 1
            return r1
        L_0x08c1:
            r0 = move-exception
            r1 = r10
            r3 = 8
            r2 = r0
        L_0x08c6:
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r5 = "Source error."
            android.util.Log.e(r4, r5, r2)
            android.os.Handler r4 = r8.zzg
            com.google.android.gms.internal.ads.zzasi r2 = com.google.android.gms.internal.ads.zzasi.zzb(r2)
            android.os.Message r2 = r4.obtainMessage(r3, r2)
            r2.sendToTarget()
            r33.zzL()
            return r1
        L_0x08de:
            r0 = move-exception
            r1 = r10
            r3 = 8
            r2 = r0
        L_0x08e3:
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r5 = "Renderer error."
            android.util.Log.e(r4, r5, r2)
            android.os.Handler r4 = r8.zzg
            android.os.Message r2 = r4.obtainMessage(r3, r2)
            r2.sendToTarget()
            r33.zzL()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.handleMessage(android.os.Message):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzasl... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.zzw     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.zzw = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.zze     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.zzx     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zza(com.google.android.gms.internal.ads.zzasl[]):void");
    }

    public final void zzb() {
        this.zzG = true;
    }

    public final void zzc(int i) {
        this.zzI = i;
    }

    public final void zzd() {
        this.zzH = true;
    }

    public final /* bridge */ /* synthetic */ void zze(zzayq zzayq) {
        this.zze.obtainMessage(9, (zzayc) zzayq).sendToTarget();
    }

    public final void zzf(zzayc zzayc) {
        this.zze.obtainMessage(8, zzayc).sendToTarget();
    }

    public final void zzg(zzath zzath, Object obj) {
        this.zze.obtainMessage(7, Pair.create(zzath, (Object) null)).sendToTarget();
    }

    public final void zzh() {
        this.zze.sendEmptyMessage(10);
    }

    public final void zzi(zzaye zzaye, boolean z) {
        this.zze.obtainMessage(0, 1, 0, zzaye).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzj() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.zze     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzf     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zzj():void");
    }

    public final void zzk(zzath zzath, int i, long j) {
        this.zze.obtainMessage(3, new zzass(zzath, 0, j)).sendToTarget();
    }

    public final void zzl(zzasl... zzaslArr) {
        if (this.zzq) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzw++;
        this.zze.obtainMessage(11, zzaslArr).sendToTarget();
    }

    public final void zzm(int i) {
        this.zzK = i;
    }

    public final void zzn(int i) {
        this.zzJ = i;
    }

    public final void zzo(boolean z) {
        this.zze.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zzp() {
        this.zze.sendEmptyMessage(5);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq(com.google.android.gms.internal.ads.zzasl... r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzq     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x0008
            monitor-exit(r8)
            return r1
        L_0x0008:
            int r0 = r8.zzw     // Catch:{ all -> 0x0044 }
            int r2 = r0 + 1
            r8.zzw = r2     // Catch:{ all -> 0x0044 }
            android.os.Handler r2 = r8.zze     // Catch:{ all -> 0x0044 }
            r3 = 11
            android.os.Message r9 = r2.obtainMessage(r3, r9)     // Catch:{ all -> 0x0044 }
            r9.sendToTarget()     // Catch:{ all -> 0x0044 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0044 }
            int r9 = r8.zzI     // Catch:{ all -> 0x0044 }
            long r4 = (long) r9     // Catch:{ all -> 0x0044 }
            long r2 = r2 + r4
        L_0x0021:
            int r9 = r8.zzx     // Catch:{ all -> 0x0044 }
            if (r9 > r0) goto L_0x003d
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x003d
            r8.wait(r4)     // Catch:{ InterruptedException -> 0x002f }
            goto L_0x0036
        L_0x002f:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
            r9.interrupt()     // Catch:{ all -> 0x0044 }
        L_0x0036:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0044 }
            long r4 = r2 - r4
            goto L_0x0021
        L_0x003d:
            if (r0 >= r9) goto L_0x0041
            monitor-exit(r8)
            return r1
        L_0x0041:
            r9 = 0
            monitor-exit(r8)
            return r9
        L_0x0044:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zzq(com.google.android.gms.internal.ads.zzasl[]):boolean");
    }

    public final boolean zzr() {
        return this.zzH && this.zzI > 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|27|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x002b, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzs() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.zzq     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0008
            r0 = 1
            monitor-exit(r6)
            return r0
        L_0x0008:
            android.os.Handler r0 = r6.zze     // Catch:{ all -> 0x003b }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x003b }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x003b }
            int r2 = r6.zzI     // Catch:{ all -> 0x003b }
            long r2 = (long) r2     // Catch:{ all -> 0x003b }
            long r0 = r0 + r2
        L_0x0016:
            boolean r4 = r6.zzq     // Catch:{ all -> 0x003b }
            if (r4 != 0) goto L_0x0032
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0037
            r6.wait(r2)     // Catch:{ InterruptedException -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003b }
            r2.interrupt()     // Catch:{ all -> 0x003b }
        L_0x002b:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x003b }
            long r2 = r0 - r2
            goto L_0x0016
        L_0x0032:
            android.os.HandlerThread r0 = r6.zzf     // Catch:{ all -> 0x003b }
            r0.quit()     // Catch:{ all -> 0x003b }
        L_0x0037:
            boolean r0 = r6.zzq     // Catch:{ all -> 0x003b }
            monitor-exit(r6)
            return r0
        L_0x003b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zzs():boolean");
    }
}
