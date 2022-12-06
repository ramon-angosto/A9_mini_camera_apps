package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzoc {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private final zzob zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private int zze;
    private zzoa zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private Method zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzoc(zzob zzob) {
        this.zza = zzob;
        int i = zzen.zza;
        try {
            this.zzn = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
    }

    private final long zzl(long j) {
        return (j * 1000000) / ((long) this.zzg);
    }

    private final long zzm() {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack == null) {
            throw null;
        } else if (this.zzx != C.TIME_UNSET) {
            return Math.min(this.zzA, this.zzz + ((((SystemClock.elapsedRealtime() * 1000) - this.zzx) * ((long) this.zzg)) / 1000000));
        } else {
            int playState = audioTrack.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
            if (this.zzh) {
                if (playState == 2) {
                    if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playState = 2;
                }
                playbackHeadPosition += this.zzu;
            }
            if (zzen.zza <= 29) {
                if (playbackHeadPosition == 0) {
                    if (this.zzs <= 0 || playState != 3) {
                        playbackHeadPosition = 0;
                    } else {
                        if (this.zzy == C.TIME_UNSET) {
                            this.zzy = SystemClock.elapsedRealtime();
                        }
                        return this.zzs;
                    }
                }
                this.zzy = C.TIME_UNSET;
            }
            if (this.zzs > playbackHeadPosition) {
                this.zzt++;
            }
            this.zzs = playbackHeadPosition;
            return playbackHeadPosition + (this.zzt << 32);
        }
    }

    private final void zzn() {
        this.zzl = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzm = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzk = false;
    }

    public final int zza(long j) {
        return this.zze - ((int) (j - (zzm() * ((long) this.zzd))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0243  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(boolean r25) {
        /*
            r24 = this;
            r0 = r24
            android.media.AudioTrack r1 = r0.zzc
            if (r1 == 0) goto L_0x0245
            int r1 = r1.getPlayState()
            r3 = 3
            r4 = 1
            r5 = 0
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r1 != r3) goto L_0x0192
            long r9 = r24.zzm()
            long r9 = r0.zzl(r9)
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0020
            goto L_0x0192
        L_0x0020:
            long r11 = java.lang.System.nanoTime()
            long r11 = r11 / r7
            long r13 = r0.zzm
            long r13 = r11 - r13
            r15 = 30000(0x7530, double:1.4822E-319)
            int r1 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x0060
            long[] r1 = r0.zzb
            int r13 = r0.zzv
            long r14 = r9 - r11
            r1[r13] = r14
            int r13 = r13 + r4
            r1 = 10
            int r13 = r13 % r1
            r0.zzv = r13
            int r13 = r0.zzw
            if (r13 >= r1) goto L_0x0044
            int r13 = r13 + r4
            r0.zzw = r13
        L_0x0044:
            r0.zzm = r11
            r0.zzl = r5
            r1 = 0
        L_0x0049:
            int r13 = r0.zzw
            if (r1 >= r13) goto L_0x0060
            long r14 = r0.zzl
            long[] r4 = r0.zzb
            r17 = r4[r1]
            long r5 = (long) r13
            long r17 = r17 / r5
            long r14 = r14 + r17
            r0.zzl = r14
            int r1 = r1 + 1
            r4 = 1
            r5 = 0
            goto L_0x0049
        L_0x0060:
            boolean r1 = r0.zzh
            if (r1 != 0) goto L_0x0192
            com.google.android.gms.internal.ads.zzoa r1 = r0.zzf
            if (r1 == 0) goto L_0x0190
            boolean r4 = r1.zzg(r11)
            java.lang.String r5 = "DefaultAudioSink"
            r13 = 5000000(0x4c4b40, double:2.470328E-317)
            if (r4 != 0) goto L_0x0075
            goto L_0x0130
        L_0x0075:
            long r7 = r1.zzb()
            long r2 = r1.zza()
            long r19 = r7 - r11
            long r19 = java.lang.Math.abs(r19)
            int r15 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            java.lang.String r4 = ", "
            if (r15 <= 0) goto L_0x00d4
            com.google.android.gms.internal.ads.zzob r15 = r0.zza
            com.google.android.gms.internal.ads.zzop r15 = (com.google.android.gms.internal.ads.zzop) r15
            com.google.android.gms.internal.ads.zzou r6 = r15.zza
            long r13 = r6.zzE()
            com.google.android.gms.internal.ads.zzou r6 = r15.zza
            r15 = r1
            long r0 = r6.zzF()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r23 = r15
            java.lang.String r15 = "Spurious audio timestamp (system clock mismatch): "
            r6.append(r15)
            r6.append(r2)
            r6.append(r4)
            r6.append(r7)
            r6.append(r4)
            r6.append(r11)
            r6.append(r4)
            r6.append(r9)
            r6.append(r4)
            r6.append(r13)
            r6.append(r4)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r5, r0)
            r23.zzd()
        L_0x00d1:
            r0 = r24
            goto L_0x0130
        L_0x00d4:
            r23 = r1
            long r13 = r0.zzl(r2)
            long r13 = r13 - r9
            long r13 = java.lang.Math.abs(r13)
            r21 = 5000000(0x4c4b40, double:2.470328E-317)
            int r1 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r1 <= 0) goto L_0x012c
            com.google.android.gms.internal.ads.zzob r1 = r0.zza
            com.google.android.gms.internal.ads.zzop r1 = (com.google.android.gms.internal.ads.zzop) r1
            com.google.android.gms.internal.ads.zzou r6 = r1.zza
            long r13 = r6.zzE()
            com.google.android.gms.internal.ads.zzou r1 = r1.zza
            long r0 = r1.zzF()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r15 = "Spurious audio timestamp (frame position mismatch): "
            r6.append(r15)
            r6.append(r2)
            r6.append(r4)
            r6.append(r7)
            r6.append(r4)
            r6.append(r11)
            r6.append(r4)
            r6.append(r9)
            r6.append(r4)
            r6.append(r13)
            r6.append(r4)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r5, r0)
            r23.zzd()
            goto L_0x00d1
        L_0x012c:
            r23.zzc()
            goto L_0x00d1
        L_0x0130:
            boolean r1 = r0.zzq
            if (r1 == 0) goto L_0x0192
            java.lang.reflect.Method r1 = r0.zzn
            if (r1 == 0) goto L_0x0192
            long r2 = r0.zzr
            long r2 = r11 - r2
            r6 = 500000(0x7a120, double:2.47033E-318)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0192
            android.media.AudioTrack r2 = r0.zzc     // Catch:{ Exception -> 0x018a }
            if (r2 == 0) goto L_0x0188
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x018a }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ Exception -> 0x018a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x018a }
            int r2 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x018a }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x018a }
            long r1 = (long) r1     // Catch:{ Exception -> 0x018a }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            long r3 = r0.zzi     // Catch:{ Exception -> 0x018a }
            long r1 = r1 - r3
            r0.zzo = r1     // Catch:{ Exception -> 0x018a }
            r3 = 0
            long r1 = java.lang.Math.max(r1, r3)     // Catch:{ Exception -> 0x018a }
            r0.zzo = r1     // Catch:{ Exception -> 0x018a }
            r3 = 5000000(0x4c4b40, double:2.470328E-317)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0186
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018a }
            r3.<init>()     // Catch:{ Exception -> 0x018a }
            java.lang.String r4 = "Ignoring impossibly large audio latency: "
            r3.append(r4)     // Catch:{ Exception -> 0x018a }
            r3.append(r1)     // Catch:{ Exception -> 0x018a }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzdw.zze(r5, r1)     // Catch:{ Exception -> 0x018a }
            r1 = 0
            r0.zzo = r1     // Catch:{ Exception -> 0x018a }
        L_0x0186:
            r1 = 0
            goto L_0x018d
        L_0x0188:
            r1 = 0
            throw r1     // Catch:{ Exception -> 0x018b }
        L_0x018a:
            r1 = 0
        L_0x018b:
            r0.zzn = r1
        L_0x018d:
            r0.zzr = r11
            goto L_0x0192
        L_0x0190:
            r1 = 0
            throw r1
        L_0x0192:
            long r1 = java.lang.System.nanoTime()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r5
            com.google.android.gms.internal.ads.zzoa r3 = r0.zzf
            if (r3 == 0) goto L_0x0243
            boolean r4 = r3.zzf()
            if (r4 == 0) goto L_0x01b9
            long r5 = r3.zza()
            long r5 = r0.zzl(r5)
            long r7 = r3.zzb()
            long r7 = r1 - r7
            float r3 = r0.zzj
            long r7 = com.google.android.gms.internal.ads.zzen.zzs(r7, r3)
            long r5 = r5 + r7
            goto L_0x01d4
        L_0x01b9:
            int r3 = r0.zzw
            if (r3 != 0) goto L_0x01c6
            long r5 = r24.zzm()
            long r5 = r0.zzl(r5)
            goto L_0x01c9
        L_0x01c6:
            long r5 = r0.zzl
            long r5 = r5 + r1
        L_0x01c9:
            if (r25 != 0) goto L_0x01d4
            long r7 = r0.zzo
            long r5 = r5 - r7
            r7 = 0
            long r5 = java.lang.Math.max(r7, r5)
        L_0x01d4:
            boolean r3 = r0.zzD
            if (r3 == r4) goto L_0x01e0
            long r7 = r0.zzC
            r0.zzF = r7
            long r7 = r0.zzB
            r0.zzE = r7
        L_0x01e0:
            long r7 = r0.zzF
            long r7 = r1 - r7
            r9 = 1000000(0xf4240, double:4.940656E-318)
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 >= 0) goto L_0x01ff
            r11 = 1000(0x3e8, double:4.94E-321)
            long r13 = r7 * r11
            long r13 = r13 / r9
            long r5 = r5 * r13
            long r9 = r11 - r13
            long r13 = r0.zzE
            float r3 = r0.zzj
            long r7 = com.google.android.gms.internal.ads.zzen.zzs(r7, r3)
            long r13 = r13 + r7
            long r9 = r9 * r13
            long r5 = r5 + r9
            long r5 = r5 / r11
        L_0x01ff:
            boolean r3 = r0.zzk
            if (r3 != 0) goto L_0x023c
            long r7 = r0.zzB
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x023c
            r3 = 1
            r0.zzk = r3
            long r7 = r5 - r7
            long r7 = com.google.android.gms.internal.ads.zzen.zzz(r7)
            float r3 = r0.zzj
            long r7 = com.google.android.gms.internal.ads.zzen.zzu(r7, r3)
            long r9 = java.lang.System.currentTimeMillis()
            long r7 = com.google.android.gms.internal.ads.zzen.zzz(r7)
            long r9 = r9 - r7
            com.google.android.gms.internal.ads.zzob r3 = r0.zza
            com.google.android.gms.internal.ads.zzop r3 = (com.google.android.gms.internal.ads.zzop) r3
            com.google.android.gms.internal.ads.zzou r3 = r3.zza
            com.google.android.gms.internal.ads.zznv r7 = r3.zzq
            if (r7 == 0) goto L_0x023c
            com.google.android.gms.internal.ads.zznv r3 = r3.zzq
            com.google.android.gms.internal.ads.zzoz r3 = (com.google.android.gms.internal.ads.zzoz) r3
            com.google.android.gms.internal.ads.zzpa r3 = r3.zza
            com.google.android.gms.internal.ads.zznr r3 = r3.zzc
            r3.zzr(r9)
        L_0x023c:
            r0.zzC = r1
            r0.zzB = r5
            r0.zzD = r4
            return r5
        L_0x0243:
            r1 = 0
            throw r1
        L_0x0245:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoc.zzb(boolean):long");
    }

    public final void zzc(long j) {
        this.zzz = zzm();
        this.zzx = SystemClock.elapsedRealtime() * 1000;
        this.zzA = j;
    }

    public final void zzd() {
        zzn();
        this.zzc = null;
        this.zzf = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(android.media.AudioTrack r4, boolean r5, int r6, int r7, int r8) {
        /*
            r3 = this;
            r3.zzc = r4
            r3.zzd = r7
            r3.zze = r8
            com.google.android.gms.internal.ads.zzoa r0 = new com.google.android.gms.internal.ads.zzoa
            r0.<init>(r4)
            r3.zzf = r0
            int r4 = r4.getSampleRate()
            r3.zzg = r4
            r4 = 6
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0025
            int r5 = com.google.android.gms.internal.ads.zzen.zza
            r2 = 23
            if (r5 >= r2) goto L_0x0025
            r5 = 5
            if (r6 == r5) goto L_0x0026
            if (r6 != r4) goto L_0x0025
            r6 = r4
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            r3.zzh = r0
            boolean r4 = com.google.android.gms.internal.ads.zzen.zzV(r6)
            r3.zzq = r4
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x003c
            int r8 = r8 / r7
            long r7 = (long) r8
            long r7 = r3.zzl(r7)
            goto L_0x003d
        L_0x003c:
            r7 = r5
        L_0x003d:
            r3.zzi = r7
            r7 = 0
            r3.zzs = r7
            r3.zzt = r7
            r3.zzu = r7
            r3.zzp = r1
            r3.zzx = r5
            r3.zzy = r5
            r3.zzr = r7
            r3.zzo = r7
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoc.zze(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final boolean zzg(long j) {
        if (j > zzm()) {
            return true;
        }
        if (!this.zzh) {
            return false;
        }
        AudioTrack audioTrack = this.zzc;
        if (audioTrack != null) {
            return audioTrack.getPlayState() == 2 && zzm() == 0;
        }
        throw null;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack != null) {
            return audioTrack.getPlayState() == 3;
        }
        throw null;
    }

    public final boolean zzi(long j) {
        return this.zzy != C.TIME_UNSET && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack != null) {
            int playState = audioTrack.getPlayState();
            if (this.zzh) {
                if (playState == 2) {
                    this.zzp = false;
                    return false;
                } else if (playState == 1) {
                    if (zzm() == 0) {
                        return false;
                    }
                    playState = 1;
                }
            }
            boolean z = this.zzp;
            boolean zzg2 = zzg(j);
            this.zzp = zzg2;
            if (z && !zzg2 && playState != 1) {
                zzob zzob = this.zza;
                int i = this.zze;
                long zzz2 = zzen.zzz(this.zzi);
                zzop zzop = (zzop) zzob;
                if (zzop.zza.zzq != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    zzou zzou = zzop.zza;
                    ((zzoz) zzou.zzq).zza.zzc.zzt(i, zzz2, elapsedRealtime - zzou.zzV);
                }
            }
            return true;
        }
        throw null;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx != C.TIME_UNSET) {
            return false;
        }
        zzoa zzoa = this.zzf;
        if (zzoa != null) {
            zzoa.zze();
            return true;
        }
        throw null;
    }

    public final void zzf() {
        zzoa zzoa = this.zzf;
        if (zzoa != null) {
            zzoa.zze();
            return;
        }
        throw null;
    }
}
