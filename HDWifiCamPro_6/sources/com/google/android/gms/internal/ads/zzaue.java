package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkRequest;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaue {
    private Method zzA;
    private int zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private float zzM;
    private zzatl[] zzN;
    private ByteBuffer[] zzO;
    private ByteBuffer zzP;
    private ByteBuffer zzQ;
    private byte[] zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private final zzauf zza;
    private final zzaul zzb;
    private final zzatl[] zzc;
    private final zzaua zzd;
    /* access modifiers changed from: private */
    public final ConditionVariable zze = new ConditionVariable(true);
    private final long[] zzf;
    private final zzatw zzg;
    private final LinkedList zzh;
    private AudioTrack zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private int zzo;
    private long zzp;
    private zzata zzq;
    private zzata zzr;
    private long zzs;
    private long zzt;
    private int zzu;
    private int zzv;
    private long zzw;
    private long zzx;
    private boolean zzy;
    private long zzz;

    public zzaue(zzatj zzatj, zzatl[] zzatlArr, zzaua zzaua) {
        this.zzd = zzaua;
        if (zzbar.zza >= 18) {
            try {
                this.zzA = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzbar.zza >= 19) {
            this.zzg = new zzatx();
        } else {
            this.zzg = new zzatw((zzatv) null);
        }
        this.zza = new zzauf();
        this.zzb = new zzaul();
        this.zzc = new zzatl[3];
        zzatl[] zzatlArr2 = this.zzc;
        zzatlArr2[0] = new zzauj();
        zzatlArr2[1] = this.zza;
        System.arraycopy(zzatlArr, 0, zzatlArr2, 2, 0);
        this.zzc[2] = this.zzb;
        this.zzf = new long[10];
        this.zzM = 1.0f;
        this.zzI = 0;
        this.zzW = 0;
        this.zzr = zzata.zza;
        this.zzT = -1;
        this.zzN = new zzatl[0];
        this.zzO = new ByteBuffer[0];
        this.zzh = new LinkedList();
    }

    private final long zzp(long j) {
        return (j * ((long) this.zzj)) / 1000000;
    }

    private final long zzq(long j) {
        return (j * 1000000) / ((long) this.zzj);
    }

    private final long zzr() {
        return this.zzn ? this.zzG : this.zzF / ((long) this.zzE);
    }

    private final void zzs(long j) throws zzaud {
        ByteBuffer byteBuffer;
        int length = this.zzN.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzO[i - 1];
            } else {
                byteBuffer = this.zzP;
                if (byteBuffer == null) {
                    byteBuffer = zzatl.zza;
                }
            }
            if (i == length) {
                zzz(byteBuffer, j);
            } else {
                zzatl zzatl = this.zzN[i];
                zzatl.zzf(byteBuffer);
                ByteBuffer zzc2 = zzatl.zzc();
                this.zzO[i] = zzc2;
                if (zzc2.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private final void zzt() {
        ArrayList arrayList = new ArrayList();
        zzatl[] zzatlArr = this.zzc;
        for (int i = 0; i < 3; i++) {
            zzatl zzatl = zzatlArr[i];
            if (zzatl.zzi()) {
                arrayList.add(zzatl);
            } else {
                zzatl.zzd();
            }
        }
        int size = arrayList.size();
        this.zzN = (zzatl[]) arrayList.toArray(new zzatl[size]);
        this.zzO = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            zzatl zzatl2 = this.zzN[i2];
            zzatl2.zzd();
            this.zzO[i2] = zzatl2.zzc();
        }
    }

    private final void zzu() {
        this.zzw = 0;
        this.zzv = 0;
        this.zzu = 0;
        this.zzx = 0;
        this.zzy = false;
        this.zzz = 0;
    }

    private final void zzv() {
        if (zzx()) {
            if (zzbar.zza >= 21) {
                this.zzi.setVolume(this.zzM);
                return;
            }
            AudioTrack audioTrack = this.zzi;
            float f = this.zzM;
            audioTrack.setStereoVolume(f, f);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzw() throws com.google.android.gms.internal.ads.zzaud {
        /*
            r9 = this;
            int r0 = r9.zzT
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzn
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzatl[] r0 = r9.zzN
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = r3
        L_0x0010:
            r9.zzT = r0
        L_0x0012:
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r3
        L_0x0015:
            int r4 = r9.zzT
            com.google.android.gms.internal.ads.zzatl[] r5 = r9.zzN
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zze()
        L_0x0028:
            r9.zzs(r7)
            boolean r0 = r4.zzj()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzT
            int r0 = r0 + r2
            r9.zzT = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            r9.zzz(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzT = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaue.zzw():boolean");
    }

    private final boolean zzx() {
        return this.zzi != null;
    }

    private final boolean zzy() {
        if (zzbar.zza >= 23) {
            return false;
        }
        int i = this.zzm;
        if (i != 5) {
            return i == 6;
        }
        return true;
    }

    private final boolean zzz(ByteBuffer byteBuffer, long j) throws zzaud {
        int i;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.zzQ;
        if (byteBuffer2 != null) {
            zzbac.zzc(byteBuffer2 == byteBuffer);
        } else {
            this.zzQ = byteBuffer;
            if (zzbar.zza < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.zzR;
                if (bArr == null || bArr.length < remaining) {
                    this.zzR = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.zzR, 0, remaining);
                byteBuffer.position(position);
                this.zzS = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (zzbar.zza < 21) {
            int zza2 = this.zzo - ((int) (this.zzF - (this.zzg.zza() * ((long) this.zzE))));
            if (zza2 > 0) {
                int write = this.zzi.write(this.zzR, this.zzS, Math.min(remaining2, zza2));
                if (write > 0) {
                    this.zzS += write;
                    byteBuffer.position(byteBuffer.position() + write);
                }
                i = write;
            } else {
                i = 0;
            }
        } else {
            i = this.zzi.write(byteBuffer, remaining2, 1);
        }
        this.zzY = SystemClock.elapsedRealtime();
        if (i >= 0) {
            boolean z = this.zzn;
            if (!z) {
                this.zzF += (long) i;
            }
            if (i != remaining2) {
                return false;
            }
            if (z) {
                this.zzG += (long) this.zzH;
            }
            this.zzQ = null;
            return true;
        }
        throw new zzaud(i);
    }

    public final long zza(boolean z) {
        long j;
        long j2;
        if (!zzx() || this.zzI == 0) {
            return Long.MIN_VALUE;
        }
        if (this.zzi.getPlayState() == 3) {
            long zzb2 = this.zzg.zzb();
            if (zzb2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzx >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    long[] jArr = this.zzf;
                    int i = this.zzu;
                    jArr[i] = zzb2 - nanoTime;
                    this.zzu = (i + 1) % 10;
                    int i2 = this.zzv;
                    if (i2 < 10) {
                        this.zzv = i2 + 1;
                    }
                    this.zzx = nanoTime;
                    this.zzw = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzv;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzw += this.zzf[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzy() && nanoTime - this.zzz >= 500000) {
                    boolean zzh2 = this.zzg.zzh();
                    this.zzy = zzh2;
                    if (zzh2) {
                        long zzd2 = this.zzg.zzd() / 1000;
                        long zzc2 = this.zzg.zzc();
                        if (zzd2 < this.zzK) {
                            this.zzy = false;
                        } else if (Math.abs(zzd2 - nanoTime) > 5000000) {
                            Log.w("AudioTrack", "Spurious audio timestamp (system clock mismatch): " + zzc2 + ", " + zzd2 + ", " + nanoTime + ", " + zzb2);
                            this.zzy = false;
                        } else if (Math.abs(zzq(zzc2) - zzb2) > 5000000) {
                            Log.w("AudioTrack", "Spurious audio timestamp (frame position mismatch): " + zzc2 + ", " + zzd2 + ", " + nanoTime + ", " + zzb2);
                            this.zzy = false;
                        }
                    }
                    Method method = this.zzA;
                    if (method != null && !this.zzn) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzi, (Object[]) null)).intValue()) * 1000) - this.zzp;
                            this.zzL = intValue;
                            long max = Math.max(intValue, 0);
                            this.zzL = max;
                            if (max > 5000000) {
                                Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + max);
                                this.zzL = 0;
                            }
                        } catch (Exception unused) {
                            this.zzA = null;
                        }
                    }
                    this.zzz = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzy) {
            j = zzq(this.zzg.zzc() + zzp(nanoTime2 - (this.zzg.zzd() / 1000)));
        } else {
            j = this.zzv == 0 ? this.zzg.zzb() : nanoTime2 + this.zzw;
            if (!z) {
                j -= this.zzL;
            }
        }
        long j3 = this.zzJ;
        while (!this.zzh.isEmpty() && j >= ((zzauc) this.zzh.getFirst()).zzc) {
            zzauc zzauc = (zzauc) this.zzh.remove();
            this.zzr = zzauc.zza;
            this.zzt = zzauc.zzc;
            this.zzs = zzauc.zzb - this.zzJ;
        }
        if (this.zzr.zzb == 1.0f) {
            j2 = (j + this.zzs) - this.zzt;
        } else {
            if (this.zzh.isEmpty()) {
                zzaul zzaul = this.zzb;
                if (zzaul.zzn() >= 1024) {
                    j2 = zzbar.zzj(j - this.zzt, zzaul.zzm(), zzaul.zzn()) + this.zzs;
                }
            }
            j2 = ((long) (((double) this.zzr.zzb) * ((double) (j - this.zzt)))) + this.zzs;
        }
        return j3 + j2;
    }

    public final zzata zzc() {
        return this.zzr;
    }

    public final zzata zzd(zzata zzata) {
        if (this.zzn) {
            this.zzr = zzata.zza;
            return this.zzr;
        }
        float zzl2 = this.zzb.zzl(zzata.zzb);
        zzaul zzaul = this.zzb;
        float f = zzata.zzc;
        zzaul.zzk(1.0f);
        zzata zzata2 = new zzata(zzl2, 1.0f);
        zzata zzata3 = this.zzq;
        if (zzata3 == null) {
            if (!this.zzh.isEmpty()) {
                zzata3 = ((zzauc) this.zzh.getLast()).zza;
            } else {
                zzata3 = this.zzr;
            }
        }
        if (!zzata2.equals(zzata3)) {
            if (zzx()) {
                this.zzq = zzata2;
            } else {
                this.zzr = zzata2;
            }
        }
        return this.zzr;
    }

    public final void zzf() {
        if (this.zzI == 1) {
            this.zzI = 2;
        }
    }

    public final void zzg() {
        this.zzV = false;
        if (zzx()) {
            zzu();
            this.zzg.zzf();
        }
    }

    public final void zzh() {
        this.zzV = true;
        if (zzx()) {
            this.zzK = System.nanoTime() / 1000;
            this.zzi.play();
        }
    }

    public final void zzi() throws zzaud {
        if (!this.zzU && zzx() && zzw()) {
            this.zzg.zze(zzr());
            this.zzU = true;
        }
    }

    public final void zzj() {
        zzk();
        zzatl[] zzatlArr = this.zzc;
        for (int i = 0; i < 3; i++) {
            zzatlArr[i].zzg();
        }
        this.zzW = 0;
        this.zzV = false;
    }

    public final void zzl(float f) {
        if (this.zzM != f) {
            this.zzM = f;
            zzv();
        }
    }

    public final boolean zzm(ByteBuffer byteBuffer, long j) throws zzatz, zzaud {
        long j2;
        int i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j;
        ByteBuffer byteBuffer3 = this.zzP;
        zzbac.zzc(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!zzx()) {
            this.zze.block();
            int i2 = this.zzW;
            if (i2 == 0) {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1);
            } else {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1, i2);
            }
            int state = this.zzi.getState();
            if (state == 1) {
                int audioSessionId = this.zzi.getAudioSessionId();
                if (this.zzW != audioSessionId) {
                    this.zzW = audioSessionId;
                    ((zzauh) this.zzd).zza.zzb.zzb(audioSessionId);
                }
                this.zzg.zzg(this.zzi, zzy());
                zzv();
                this.zzX = false;
                if (this.zzV) {
                    zzh();
                }
            } else {
                try {
                    this.zzi.release();
                } catch (Exception unused) {
                } finally {
                    this.zzi = null;
                }
                throw new zzatz(state, this.zzj, this.zzk, this.zzo);
            }
        }
        if (zzy()) {
            if (this.zzi.getPlayState() == 2) {
                this.zzX = false;
                return false;
            } else if (this.zzi.getPlayState() == 1 && this.zzg.zza() != 0) {
                return false;
            }
        }
        boolean z = this.zzX;
        boolean zzn2 = zzn();
        this.zzX = zzn2;
        if (z && !zzn2 && this.zzi.getPlayState() != 1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j4 = this.zzY;
            zzaua zzaua = this.zzd;
            ((zzauh) zzaua).zza.zzb.zzc(this.zzo, zzash.zzb(this.zzp), elapsedRealtime - j4);
        }
        if (this.zzP == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzn && this.zzH == 0) {
                int i3 = this.zzm;
                if (i3 == 7 || i3 == 8) {
                    int position = byteBuffer.position();
                    i = ((((byteBuffer2.get(position + 5) & 252) >> 2) | ((byteBuffer2.get(position + 4) & 1) << 6)) + 1) * 32;
                } else if (i3 == 5) {
                    int i4 = zzati.zza;
                    i = 1536;
                } else if (i3 == 6) {
                    i = zzati.zza(byteBuffer);
                } else {
                    throw new IllegalStateException("Unexpected audio encoding: " + i3);
                }
                this.zzH = i;
            }
            if (this.zzq != null) {
                if (!zzw()) {
                    return false;
                }
                this.zzh.add(new zzauc(this.zzq, Math.max(0, j3), zzq(zzr()), (zzaub) null));
                this.zzq = null;
                zzt();
            }
            if (this.zzI == 0) {
                this.zzJ = Math.max(0, j3);
                this.zzI = 1;
            } else {
                long j5 = this.zzJ;
                if (this.zzn) {
                    j2 = this.zzD;
                } else {
                    j2 = this.zzC / ((long) this.zzB);
                }
                long zzq2 = j5 + zzq(j2);
                if (this.zzI == 1 && Math.abs(zzq2 - j3) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + zzq2 + ", got " + j3 + "]");
                    this.zzI = 2;
                }
                if (this.zzI == 2) {
                    this.zzJ += j3 - zzq2;
                    this.zzI = 1;
                    ((zzauh) this.zzd).zza.zzh = true;
                }
            }
            if (this.zzn) {
                this.zzD += (long) this.zzH;
            } else {
                this.zzC += (long) byteBuffer.remaining();
            }
            this.zzP = byteBuffer2;
        }
        if (this.zzn) {
            zzz(this.zzP, j3);
        } else {
            zzs(j3);
        }
        if (this.zzP.hasRemaining()) {
            return false;
        }
        this.zzP = null;
        return true;
    }

    public final boolean zzn() {
        if (!zzx()) {
            return false;
        }
        if (zzr() <= this.zzg.zza()) {
            return zzy() && this.zzi.getPlayState() == 2 && this.zzi.getPlaybackHeadPosition() == 0;
        }
        return true;
    }

    public final boolean zzo() {
        if (!zzx()) {
            return true;
        }
        if (this.zzU) {
            return !zzn();
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(java.lang.String r6, int r7, int r8, int r9, int r10, int[] r11) throws com.google.android.gms.internal.ads.zzaty {
        /*
            r5 = this;
            int r6 = com.google.android.gms.internal.ads.zzbar.zzi(r9, r7)
            r5.zzB = r6
            com.google.android.gms.internal.ads.zzauf r6 = r5.zza
            r6.zzk(r11)
            com.google.android.gms.internal.ads.zzatl[] r6 = r5.zzc
            r10 = 0
            r0 = r7
            r11 = r9
            r7 = r10
            r9 = r7
        L_0x0012:
            r1 = 3
            r2 = 2
            if (r7 >= r1) goto L_0x0036
            r1 = r6[r7]
            boolean r3 = r1.zzh(r8, r0, r11)     // Catch:{ zzatk -> 0x002f }
            r9 = r9 | r3
            boolean r3 = r1.zzi()
            if (r3 == 0) goto L_0x002c
            int r11 = r1.zza()
            r1.zzb()
            r0 = r11
            r11 = r2
        L_0x002c:
            int r7 = r7 + 1
            goto L_0x0012
        L_0x002f:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaty r7 = new com.google.android.gms.internal.ads.zzaty
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        L_0x0036:
            if (r9 == 0) goto L_0x003b
            r5.zzt()
        L_0x003b:
            r6 = 252(0xfc, float:3.53E-43)
            switch(r0) {
                case 1: goto L_0x006b;
                case 2: goto L_0x0068;
                case 3: goto L_0x0065;
                case 4: goto L_0x0062;
                case 5: goto L_0x005f;
                case 6: goto L_0x005d;
                case 7: goto L_0x005a;
                case 8: goto L_0x0057;
                default: goto L_0x0040;
            }
        L_0x0040:
            com.google.android.gms.internal.ads.zzaty r6 = new com.google.android.gms.internal.ads.zzaty
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unsupported channel count: "
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x0057:
            int r7 = com.google.android.gms.internal.ads.zzash.zza
            goto L_0x006c
        L_0x005a:
            r7 = 1276(0x4fc, float:1.788E-42)
            goto L_0x006c
        L_0x005d:
            r7 = r6
            goto L_0x006c
        L_0x005f:
            r7 = 220(0xdc, float:3.08E-43)
            goto L_0x006c
        L_0x0062:
            r7 = 204(0xcc, float:2.86E-43)
            goto L_0x006c
        L_0x0065:
            r7 = 28
            goto L_0x006c
        L_0x0068:
            r7 = 12
            goto L_0x006c
        L_0x006b:
            r7 = 4
        L_0x006c:
            int r3 = com.google.android.gms.internal.ads.zzbar.zza
            r4 = 23
            if (r3 > r4) goto L_0x0092
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbar.zzb
            java.lang.String r4 = "foster"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0092
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbar.zzc
            java.lang.String r4 = "NVIDIA"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0092
            if (r0 == r1) goto L_0x0093
            r1 = 5
            if (r0 == r1) goto L_0x0093
            r6 = 7
            if (r0 == r6) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            int r6 = com.google.android.gms.internal.ads.zzash.zza
            goto L_0x0093
        L_0x0092:
            r6 = r7
        L_0x0093:
            int r7 = com.google.android.gms.internal.ads.zzbar.zza
            r1 = 25
            if (r7 > r1) goto L_0x00a1
            java.lang.String r7 = com.google.android.gms.internal.ads.zzbar.zzb
            java.lang.String r1 = "fugu"
            boolean r7 = r1.equals(r7)
        L_0x00a1:
            if (r9 != 0) goto L_0x00b7
            boolean r7 = r5.zzx()
            if (r7 == 0) goto L_0x00b7
            int r7 = r5.zzl
            if (r7 != r11) goto L_0x00b7
            int r7 = r5.zzj
            if (r7 != r8) goto L_0x00b7
            int r7 = r5.zzk
            if (r7 == r6) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            return
        L_0x00b7:
            r5.zzk()
            r5.zzl = r11
            r5.zzn = r10
            r5.zzj = r8
            r5.zzk = r6
            r5.zzm = r2
            int r7 = com.google.android.gms.internal.ads.zzbar.zzi(r2, r0)
            r5.zzE = r7
            int r7 = r5.zzm
            int r6 = android.media.AudioTrack.getMinBufferSize(r8, r6, r7)
            r7 = -2
            if (r6 == r7) goto L_0x00d4
            r10 = 1
        L_0x00d4:
            com.google.android.gms.internal.ads.zzbac.zze(r10)
            int r7 = r6 * 4
            r8 = 250000(0x3d090, double:1.235164E-318)
            long r8 = r5.zzp(r8)
            int r10 = r5.zzE
            int r8 = (int) r8
            int r8 = r8 * r10
            long r0 = (long) r6
            r2 = 750000(0xb71b0, double:3.70549E-318)
            long r2 = r5.zzp(r2)
            long r9 = (long) r10
            long r2 = r2 * r9
            long r9 = java.lang.Math.max(r0, r2)
            int r6 = (int) r9
            if (r7 >= r8) goto L_0x00f7
            r6 = r8
            goto L_0x00fb
        L_0x00f7:
            if (r7 <= r6) goto L_0x00fa
            goto L_0x00fb
        L_0x00fa:
            r6 = r7
        L_0x00fb:
            r5.zzo = r6
            int r7 = r5.zzE
            int r6 = r6 / r7
            long r6 = (long) r6
            long r6 = r5.zzq(r6)
            r5.zzp = r6
            com.google.android.gms.internal.ads.zzata r6 = r5.zzr
            r5.zzd(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaue.zze(java.lang.String, int, int, int, int, int[]):void");
    }

    public final void zzk() {
        if (zzx()) {
            this.zzC = 0;
            this.zzD = 0;
            this.zzF = 0;
            this.zzG = 0;
            this.zzH = 0;
            zzata zzata = this.zzq;
            if (zzata != null) {
                this.zzr = zzata;
                this.zzq = null;
            } else if (!this.zzh.isEmpty()) {
                this.zzr = ((zzauc) this.zzh.getLast()).zza;
            }
            this.zzh.clear();
            this.zzs = 0;
            this.zzt = 0;
            this.zzP = null;
            this.zzQ = null;
            int i = 0;
            while (true) {
                zzatl[] zzatlArr = this.zzN;
                if (i >= zzatlArr.length) {
                    break;
                }
                zzatl zzatl = zzatlArr[i];
                zzatl.zzd();
                this.zzO[i] = zzatl.zzc();
                i++;
            }
            this.zzU = false;
            this.zzT = -1;
            this.zzI = 0;
            this.zzL = 0;
            zzu();
            if (this.zzi.getPlayState() == 3) {
                this.zzi.pause();
            }
            AudioTrack audioTrack = this.zzi;
            this.zzi = null;
            this.zzg.zzg((AudioTrack) null, false);
            this.zze.close();
            new zzatu(this, audioTrack).start();
        }
    }
}
