package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzou implements zzny {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private long zzA;
    private long zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private long zzF;
    private float zzG;
    private zzng[] zzH;
    private ByteBuffer[] zzI;
    private ByteBuffer zzJ;
    private int zzK;
    private ByteBuffer zzL;
    private byte[] zzM;
    private int zzN;
    private int zzO;
    private boolean zzP;
    private boolean zzQ;
    /* access modifiers changed from: private */
    public boolean zzR;
    private boolean zzS;
    private int zzT;
    private zzl zzU;
    /* access modifiers changed from: private */
    public long zzV;
    private boolean zzW;
    private boolean zzX;
    private final zzok zzY;
    private final zznd zzd;
    private final zzoe zze;
    private final zzpf zzf;
    private final zzng[] zzg;
    private final zzng[] zzh;
    private final zzdg zzi = new zzdg(zzde.zza);
    private final zzoc zzj;
    private final ArrayDeque zzk;
    private zzos zzl;
    private final zzon zzm;
    private final zzon zzn;
    private final zzoh zzo;
    private zznb zzp;
    /* access modifiers changed from: private */
    public zznv zzq;
    private zzoj zzr;
    private zzoj zzs;
    /* access modifiers changed from: private */
    public AudioTrack zzt;
    private zzk zzu;
    private zzom zzv;
    private zzom zzw;
    private final zzby zzx;
    private long zzy;
    private long zzz;

    /* synthetic */ zzou(zzoi zzoi, zzot zzot) {
        this.zzd = zzoi.zzb;
        this.zzY = zzoi.zzc;
        int i = zzen.zza;
        this.zzo = zzoi.zza;
        this.zzi.zze();
        this.zzj = new zzoc(new zzop(this, (zzoo) null));
        this.zze = new zzoe();
        this.zzf = new zzpf();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new zzod[]{new zzpb(), this.zze, this.zzf});
        Collections.addAll(arrayList, this.zzY.zze());
        this.zzg = (zzng[]) arrayList.toArray(new zzng[0]);
        this.zzh = new zzng[]{new zzox()};
        this.zzG = 1.0f;
        this.zzu = zzk.zza;
        this.zzT = 0;
        this.zzU = new zzl(0, 0.0f);
        this.zzw = new zzom(zzby.zza, false, 0, 0, (zzol) null);
        this.zzx = zzby.zza;
        this.zzO = -1;
        this.zzH = new zzng[0];
        this.zzI = new ByteBuffer[0];
        this.zzk = new ArrayDeque();
        this.zzm = new zzon(100);
        this.zzn = new zzon(100);
    }

    static /* synthetic */ void zzC(AudioTrack audioTrack, zzdg zzdg) {
        try {
            audioTrack.flush();
            audioTrack.release();
            zzdg.zze();
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            zzdg.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public final long zzE() {
        zzoj zzoj = this.zzs;
        return zzoj.zzc == 0 ? this.zzy / ((long) zzoj.zzb) : this.zzz;
    }

    /* access modifiers changed from: private */
    public final long zzF() {
        zzoj zzoj = this.zzs;
        return zzoj.zzc == 0 ? this.zzA / ((long) zzoj.zzd) : this.zzB;
    }

    private final AudioTrack zzG(zzoj zzoj) throws zznu {
        try {
            return zzoj.zzb(false, this.zzu, this.zzT);
        } catch (zznu e) {
            zznv zznv = this.zzq;
            if (zznv != null) {
                zznv.zza(e);
            }
            throw e;
        }
    }

    private final zzom zzH() {
        zzom zzom = this.zzv;
        if (zzom != null) {
            return zzom;
        }
        return !this.zzk.isEmpty() ? (zzom) this.zzk.getLast() : this.zzw;
    }

    private final void zzI(long j) {
        zzby zzby;
        boolean z;
        if (zzT()) {
            zzok zzok = this.zzY;
            zzby = zzH().zza;
            zzok.zzc(zzby);
        } else {
            zzby = zzby.zza;
        }
        zzby zzby2 = zzby;
        if (zzT()) {
            zzok zzok2 = this.zzY;
            boolean z2 = zzH().zzb;
            zzok2.zzd(z2);
            z = z2;
        } else {
            z = false;
        }
        this.zzk.add(new zzom(zzby2, z, Math.max(0, j), this.zzs.zza(zzF()), (zzol) null));
        zzng[] zzngArr = this.zzs.zzi;
        ArrayList arrayList = new ArrayList();
        for (zzng zzng : zzngArr) {
            if (zzng.zzg()) {
                arrayList.add(zzng);
            } else {
                zzng.zzc();
            }
        }
        int size = arrayList.size();
        this.zzH = (zzng[]) arrayList.toArray(new zzng[size]);
        this.zzI = new ByteBuffer[size];
        zzJ();
        zznv zznv = this.zzq;
        if (zznv != null) {
            ((zzoz) zznv).zza.zzc.zzs(z);
        }
    }

    private final void zzJ() {
        int i = 0;
        while (true) {
            zzng[] zzngArr = this.zzH;
            if (i < zzngArr.length) {
                zzng zzng = zzngArr[i];
                zzng.zzc();
                this.zzI[i] = zzng.zzb();
                i++;
            } else {
                return;
            }
        }
    }

    private final void zzK() {
        if (this.zzs.zzc()) {
            this.zzW = true;
        }
    }

    private final void zzL() {
        if (!this.zzQ) {
            this.zzQ = true;
            this.zzj.zzc(zzF());
            this.zzt.stop();
        }
    }

    private final void zzM(long j) throws zznx {
        ByteBuffer byteBuffer;
        int length = this.zzH.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzI[i - 1];
            } else {
                byteBuffer = this.zzJ;
                if (byteBuffer == null) {
                    byteBuffer = zzng.zza;
                }
            }
            if (i == length) {
                zzP(byteBuffer, j);
            } else {
                zzng zzng = this.zzH[i];
                if (i > this.zzO) {
                    zzng.zze(byteBuffer);
                }
                ByteBuffer zzb2 = zzng.zzb();
                this.zzI[i] = zzb2;
                if (zzb2.hasRemaining()) {
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

    private final void zzN(zzby zzby, boolean z) {
        zzom zzH2 = zzH();
        if (!zzby.equals(zzH2.zza) || z != zzH2.zzb) {
            zzom zzom = new zzom(zzby, z, C.TIME_UNSET, C.TIME_UNSET, (zzol) null);
            if (zzR()) {
                this.zzv = zzom;
            } else {
                this.zzw = zzom;
            }
        }
    }

    private final void zzO() {
        if (zzR()) {
            if (zzen.zza >= 21) {
                this.zzt.setVolume(this.zzG);
                return;
            }
            AudioTrack audioTrack = this.zzt;
            float f = this.zzG;
            audioTrack.setStereoVolume(f, f);
        }
    }

    private final void zzP(ByteBuffer byteBuffer, long j) throws zznx {
        int i;
        zznv zznv;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzL;
            boolean z = true;
            if (byteBuffer2 != null) {
                zzdd.zzd(byteBuffer2 == byteBuffer);
            } else {
                this.zzL = byteBuffer;
                if (zzen.zza < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.zzM;
                    if (bArr == null || bArr.length < remaining) {
                        this.zzM = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.zzM, 0, remaining);
                    byteBuffer.position(position);
                    this.zzN = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (zzen.zza < 21) {
                int zza2 = this.zzj.zza(this.zzA);
                if (zza2 > 0) {
                    i = this.zzt.write(this.zzM, this.zzN, Math.min(remaining2, zza2));
                    if (i > 0) {
                        this.zzN += i;
                        byteBuffer.position(byteBuffer.position() + i);
                    }
                } else {
                    i = 0;
                }
            } else {
                i = this.zzt.write(byteBuffer, remaining2, 1);
            }
            this.zzV = SystemClock.elapsedRealtime();
            if (i < 0) {
                if ((zzen.zza < 24 || i != -6) && i != -32) {
                    z = false;
                }
                if (z) {
                    zzK();
                }
                zznx zznx = new zznx(i, this.zzs.zza, z);
                zznv zznv2 = this.zzq;
                if (zznv2 != null) {
                    zznv2.zza(zznx);
                }
                if (!zznx.zzb) {
                    this.zzn.zzb(zznx);
                    return;
                }
                throw zznx;
            }
            this.zzn.zza();
            if (zzS(this.zzt)) {
                if (this.zzB > 0) {
                    this.zzX = false;
                }
                if (this.zzR && (zznv = this.zzq) != null && i < remaining2 && !this.zzX) {
                    zzpa zzpa = ((zzoz) zznv).zza;
                    if (zzpa.zzl != null) {
                        zzpa.zzl.zza();
                    }
                }
            }
            int i2 = this.zzs.zzc;
            if (i2 == 0) {
                this.zzA += (long) i;
            }
            if (i == remaining2) {
                if (i2 != 0) {
                    if (byteBuffer != this.zzJ) {
                        z = false;
                    }
                    zzdd.zzf(z);
                    this.zzB += ((long) this.zzC) * ((long) this.zzK);
                }
                this.zzL = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzQ() throws com.google.android.gms.internal.ads.zznx {
        /*
            r9 = this;
            int r0 = r9.zzO
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r9.zzO = r3
        L_0x0009:
            r0 = r2
            goto L_0x000c
        L_0x000b:
            r0 = r3
        L_0x000c:
            int r4 = r9.zzO
            com.google.android.gms.internal.ads.zzng[] r5 = r9.zzH
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.zzd()
        L_0x001f:
            r9.zzM(r7)
            boolean r0 = r4.zzh()
            if (r0 != 0) goto L_0x0029
            return r3
        L_0x0029:
            int r0 = r9.zzO
            int r0 = r0 + r2
            r9.zzO = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.zzL
            if (r0 == 0) goto L_0x003b
            r9.zzP(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzL
            if (r0 == 0) goto L_0x003b
            return r3
        L_0x003b:
            r9.zzO = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzou.zzQ():boolean");
    }

    private final boolean zzR() {
        return this.zzt != null;
    }

    private static boolean zzS(AudioTrack audioTrack) {
        return zzen.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzT() {
        if (!MimeTypes.AUDIO_RAW.equals(this.zzs.zza.zzm)) {
            return false;
        }
        int i = this.zzs.zza.zzB;
        return true;
    }

    public final int zza(zzaf zzaf) {
        if (!MimeTypes.AUDIO_RAW.equals(zzaf.zzm)) {
            if (!this.zzW) {
                int i = zzen.zza;
            }
            return this.zzd.zza(zzaf) != null ? 2 : 0;
        } else if (!zzen.zzV(zzaf.zzB)) {
            int i2 = zzaf.zzB;
            zzdw.zze("DefaultAudioSink", "Invalid PCM encoding: " + i2);
            return 0;
        } else if (zzaf.zzB != 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public final long zzb(boolean z) {
        long j;
        if (!zzR() || this.zzE) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzj.zzb(z), this.zzs.zza(zzF()));
        while (!this.zzk.isEmpty() && min >= ((zzom) this.zzk.getFirst()).zzd) {
            this.zzw = (zzom) this.zzk.remove();
        }
        zzom zzom = this.zzw;
        long j2 = min - zzom.zzd;
        if (zzom.zza.equals(zzby.zza)) {
            j = this.zzw.zzc + j2;
        } else if (this.zzk.isEmpty()) {
            j = this.zzY.zza(j2) + this.zzw.zzc;
        } else {
            zzom zzom2 = (zzom) this.zzk.getFirst();
            j = zzom2.zzc - zzen.zzs(zzom2.zzd - min, this.zzw.zza.zzc);
        }
        return j + this.zzs.zza(this.zzY.zzb());
    }

    public final zzby zzc() {
        return zzH().zza;
    }

    public final void zzd(zzaf zzaf, int i, int[] iArr) throws zznt {
        zzng[] zzngArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr2;
        zzaf zzaf2 = zzaf;
        if (MimeTypes.AUDIO_RAW.equals(zzaf2.zzm)) {
            zzdd.zzd(zzen.zzV(zzaf2.zzB));
            int zzo2 = zzen.zzo(zzaf2.zzB, zzaf2.zzz);
            int i9 = zzaf2.zzB;
            zzng[] zzngArr2 = this.zzg;
            this.zzf.zzq(zzaf2.zzC, zzaf2.zzD);
            if (zzen.zza < 21 && zzaf2.zzz == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i10 = 0; i10 < 6; i10++) {
                    iArr2[i10] = i10;
                }
            } else {
                iArr2 = iArr;
            }
            this.zze.zzo(iArr2);
            zzne zzne = new zzne(zzaf2.zzA, zzaf2.zzz, zzaf2.zzB);
            int length = zzngArr2.length;
            zzne zzne2 = zzne;
            int i11 = 0;
            while (i11 < length) {
                zzng zzng = zzngArr2[i11];
                try {
                    zzne zza2 = zzng.zza(zzne2);
                    if (true == zzng.zzg()) {
                        zzne2 = zza2;
                    }
                    i11++;
                } catch (zznf e) {
                    throw new zznt((Throwable) e, zzaf2);
                }
            }
            int i12 = zzne2.zzd;
            int i13 = zzne2.zzb;
            int i14 = zzne2.zzc;
            int zzj2 = zzen.zzj(i14);
            zzngArr = zzngArr2;
            i6 = zzen.zzo(i12, i14);
            i3 = 0;
            int i15 = zzj2;
            i2 = zzo2;
            i7 = i12;
            i5 = i13;
            i4 = i15;
        } else {
            zzng[] zzngArr3 = new zzng[0];
            int i16 = zzaf2.zzA;
            int i17 = zzen.zza;
            Pair zza3 = this.zzd.zza(zzaf2);
            if (zza3 != null) {
                i3 = 2;
                zzngArr = zzngArr3;
                i7 = ((Integer) zza3.first).intValue();
                i2 = -1;
                i4 = ((Integer) zza3.second).intValue();
                i5 = i16;
                i6 = -1;
            } else {
                throw new zznt("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzaf))), zzaf2);
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i5, i4, i7);
        zzdd.zzf(minBufferSize != -2);
        int i18 = 250000;
        if (i3 == 0) {
            int i19 = i6;
            i8 = zzen.zzf(minBufferSize * 4, zzow.zza(250000, i5, i6), zzow.zza(750000, i5, i6));
        } else if (i3 != 1) {
            int i20 = 5;
            if (i7 == 5) {
                i18 = 500000;
                i7 = 5;
            } else {
                i20 = i7;
            }
            i6 = i6;
            i8 = zzfxs.zza((((long) i18) * ((long) zzow.zzb(i7))) / 1000000);
            i7 = i20;
        } else {
            int i21 = i6;
            i8 = zzfxs.zza((((long) zzow.zzb(i7)) * 50000000) / 1000000);
        }
        int max = (((Math.max(minBufferSize, (int) ((double) i8)) + i6) - 1) / i6) * i6;
        if (i7 == 0) {
            throw new zznt("Invalid output encoding (mode=" + i3 + ") for: " + String.valueOf(zzaf), zzaf);
        } else if (i4 != 0) {
            this.zzW = false;
            zzoj zzoj = new zzoj(zzaf, i2, i3, i6, i5, i4, i7, max, zzngArr);
            if (zzR()) {
                this.zzr = zzoj;
            } else {
                this.zzs = zzoj;
            }
        } else {
            throw new zznt("Invalid output channel config (mode=" + i3 + ") for: " + String.valueOf(zzaf), zzaf);
        }
    }

    public final void zze() {
        if (zzR()) {
            this.zzy = 0;
            this.zzz = 0;
            this.zzA = 0;
            this.zzB = 0;
            this.zzX = false;
            this.zzC = 0;
            this.zzw = new zzom(zzH().zza, zzH().zzb, 0, 0, (zzol) null);
            this.zzF = 0;
            this.zzv = null;
            this.zzk.clear();
            this.zzJ = null;
            this.zzK = 0;
            this.zzL = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzO = -1;
            this.zzf.zzp();
            zzJ();
            if (this.zzj.zzh()) {
                this.zzt.pause();
            }
            if (zzS(this.zzt)) {
                zzos zzos = this.zzl;
                if (zzos != null) {
                    zzos.zzb(this.zzt);
                } else {
                    throw null;
                }
            }
            if (zzen.zza < 21 && !this.zzS) {
                this.zzT = 0;
            }
            zzoj zzoj = this.zzr;
            if (zzoj != null) {
                this.zzs = zzoj;
                this.zzr = null;
            }
            this.zzj.zzd();
            AudioTrack audioTrack = this.zzt;
            zzdg zzdg = this.zzi;
            zzdg.zzc();
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzen.zzQ("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new zzof(audioTrack, zzdg));
            }
            this.zzt = null;
        }
        this.zzn.zza();
        this.zzm.zza();
    }

    public final void zzf() {
        this.zzD = true;
    }

    public final void zzg() {
        this.zzR = false;
        if (zzR() && this.zzj.zzk()) {
            this.zzt.pause();
        }
    }

    public final void zzh() {
        this.zzR = true;
        if (zzR()) {
            this.zzj.zzf();
            this.zzt.play();
        }
    }

    public final void zzi() throws zznx {
        if (!this.zzP && zzR() && zzQ()) {
            zzL();
            this.zzP = true;
        }
    }

    public final void zzj() {
        zze();
        for (zzng zzf2 : this.zzg) {
            zzf2.zzf();
        }
        zzng[] zzngArr = this.zzh;
        int length = zzngArr.length;
        for (int i = 0; i <= 0; i++) {
            zzngArr[i].zzf();
        }
        this.zzR = false;
        this.zzW = false;
    }

    public final void zzk(zzk zzk2) {
        if (!this.zzu.equals(zzk2)) {
            this.zzu = zzk2;
            zze();
        }
    }

    public final void zzl(int i) {
        if (this.zzT != i) {
            this.zzT = i;
            this.zzS = i != 0;
            zze();
        }
    }

    public final void zzm(zzl zzl2) {
        if (!this.zzU.equals(zzl2)) {
            int i = zzl2.zza;
            float f = zzl2.zzb;
            if (this.zzt != null) {
                int i2 = this.zzU.zza;
            }
            this.zzU = zzl2;
        }
    }

    public final void zzn(zznv zznv) {
        this.zzq = zznv;
    }

    public final void zzo(zzby zzby) {
        zzN(new zzby(zzen.zza(zzby.zzc, 0.1f, 8.0f), zzen.zza(zzby.zzd, 0.1f, 8.0f)), zzH().zzb);
    }

    public final void zzp(zznb zznb) {
        this.zzp = zznb;
    }

    public final void zzq(boolean z) {
        zzN(zzH().zza, z);
    }

    public final void zzr(float f) {
        if (this.zzG != f) {
            this.zzG = f;
            zzO();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:42|43|44|45|(3:47|48|49)|72|73|74) */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0252, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02c3, code lost:
        r1.zzC = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02c5, code lost:
        if (r0 == 0) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02c8, code lost:
        return r10;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x014c */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x00d2=Splitter:B:50:0x00d2, B:72:0x014c=Splitter:B:72:0x014c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzs(java.nio.ByteBuffer r25, long r26, int r28) throws com.google.android.gms.internal.ads.zznu, com.google.android.gms.internal.ads.zznx {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r3 = r26
            r5 = r28
            java.nio.ByteBuffer r0 = r1.zzJ
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x0013
            if (r2 != r0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = r7
            goto L_0x0014
        L_0x0013:
            r0 = r6
        L_0x0014:
            com.google.android.gms.internal.ads.zzdd.zzd(r0)
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzr
            r8 = 0
            if (r0 == 0) goto L_0x007f
            boolean r0 = r24.zzQ()
            if (r0 != 0) goto L_0x0023
            return r7
        L_0x0023:
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzr
            com.google.android.gms.internal.ads.zzoj r9 = r1.zzs
            int r10 = r9.zzc
            int r11 = r0.zzc
            if (r10 != r11) goto L_0x006f
            int r10 = r9.zzg
            int r11 = r0.zzg
            if (r10 != r11) goto L_0x006f
            int r10 = r9.zze
            int r11 = r0.zze
            if (r10 != r11) goto L_0x006f
            int r10 = r9.zzf
            int r11 = r0.zzf
            if (r10 != r11) goto L_0x006f
            int r9 = r9.zzd
            int r10 = r0.zzd
            if (r9 != r10) goto L_0x006f
            r1.zzs = r0
            r1.zzr = r8
            android.media.AudioTrack r0 = r1.zzt
            boolean r0 = zzS(r0)
            if (r0 == 0) goto L_0x007c
            android.media.AudioTrack r0 = r1.zzt
            int r0 = r0.getPlayState()
            r9 = 3
            if (r0 != r9) goto L_0x005f
            android.media.AudioTrack r0 = r1.zzt
            r0.setOffloadEndOfStream()
        L_0x005f:
            android.media.AudioTrack r0 = r1.zzt
            com.google.android.gms.internal.ads.zzoj r9 = r1.zzs
            com.google.android.gms.internal.ads.zzaf r9 = r9.zza
            int r10 = r9.zzC
            int r9 = r9.zzD
            r0.setOffloadDelayPadding(r10, r9)
            r1.zzX = r6
            goto L_0x007c
        L_0x006f:
            r24.zzL()
            boolean r0 = r24.zzt()
            if (r0 == 0) goto L_0x0079
            return r7
        L_0x0079:
            r24.zze()
        L_0x007c:
            r1.zzI(r3)
        L_0x007f:
            boolean r0 = r24.zzR()
            r9 = 31
            if (r0 != 0) goto L_0x015d
            com.google.android.gms.internal.ads.zzdg r0 = r1.zzi     // Catch:{ zznu -> 0x0150 }
            boolean r0 = r0.zzd()     // Catch:{ zznu -> 0x0150 }
            if (r0 != 0) goto L_0x0090
            return r7
        L_0x0090:
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzs     // Catch:{ zznu -> 0x009a }
            if (r0 == 0) goto L_0x0099
            android.media.AudioTrack r0 = r1.zzG(r0)     // Catch:{ zznu -> 0x009a }
            goto L_0x00d2
        L_0x0099:
            throw r8     // Catch:{ zznu -> 0x009a }
        L_0x009a:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzs     // Catch:{ zznu -> 0x0150 }
            int r12 = r0.zzh     // Catch:{ zznu -> 0x0150 }
            r13 = 1000000(0xf4240, float:1.401298E-39)
            if (r12 <= r13) goto L_0x014c
            com.google.android.gms.internal.ads.zzoj r12 = new com.google.android.gms.internal.ads.zzoj     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzaf r15 = r0.zza     // Catch:{ zznu -> 0x0150 }
            int r13 = r0.zzb     // Catch:{ zznu -> 0x0150 }
            int r14 = r0.zzc     // Catch:{ zznu -> 0x0150 }
            int r8 = r0.zzd     // Catch:{ zznu -> 0x0150 }
            int r7 = r0.zze     // Catch:{ zznu -> 0x0150 }
            int r6 = r0.zzf     // Catch:{ zznu -> 0x0150 }
            int r10 = r0.zzg     // Catch:{ zznu -> 0x0150 }
            r22 = 1000000(0xf4240, float:1.401298E-39)
            com.google.android.gms.internal.ads.zzng[] r0 = r0.zzi     // Catch:{ zznu -> 0x0150 }
            r17 = r14
            r14 = r12
            r16 = r13
            r18 = r8
            r19 = r7
            r20 = r6
            r21 = r10
            r23 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ zznu -> 0x0150 }
            android.media.AudioTrack r0 = r1.zzG(r12)     // Catch:{ zznu -> 0x0133 }
            r1.zzs = r12     // Catch:{ zznu -> 0x0133 }
        L_0x00d2:
            r1.zzt = r0     // Catch:{ zznu -> 0x0150 }
            android.media.AudioTrack r0 = r1.zzt     // Catch:{ zznu -> 0x0150 }
            boolean r0 = zzS(r0)     // Catch:{ zznu -> 0x0150 }
            if (r0 == 0) goto L_0x00fb
            android.media.AudioTrack r0 = r1.zzt     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzos r6 = r1.zzl     // Catch:{ zznu -> 0x0150 }
            if (r6 != 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzos r6 = new com.google.android.gms.internal.ads.zzos     // Catch:{ zznu -> 0x0150 }
            r6.<init>(r1)     // Catch:{ zznu -> 0x0150 }
            r1.zzl = r6     // Catch:{ zznu -> 0x0150 }
        L_0x00e9:
            com.google.android.gms.internal.ads.zzos r6 = r1.zzl     // Catch:{ zznu -> 0x0150 }
            r6.zza(r0)     // Catch:{ zznu -> 0x0150 }
            android.media.AudioTrack r0 = r1.zzt     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzoj r6 = r1.zzs     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzaf r6 = r6.zza     // Catch:{ zznu -> 0x0150 }
            int r7 = r6.zzC     // Catch:{ zznu -> 0x0150 }
            int r6 = r6.zzD     // Catch:{ zznu -> 0x0150 }
            r0.setOffloadDelayPadding(r7, r6)     // Catch:{ zznu -> 0x0150 }
        L_0x00fb:
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ zznu -> 0x0150 }
            if (r0 < r9) goto L_0x0108
            com.google.android.gms.internal.ads.zznb r0 = r1.zzp     // Catch:{ zznu -> 0x0150 }
            if (r0 == 0) goto L_0x0108
            android.media.AudioTrack r6 = r1.zzt     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzog.zza(r6, r0)     // Catch:{ zznu -> 0x0150 }
        L_0x0108:
            android.media.AudioTrack r0 = r1.zzt     // Catch:{ zznu -> 0x0150 }
            int r0 = r0.getAudioSessionId()     // Catch:{ zznu -> 0x0150 }
            r1.zzT = r0     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzoc r10 = r1.zzj     // Catch:{ zznu -> 0x0150 }
            android.media.AudioTrack r11 = r1.zzt     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzs     // Catch:{ zznu -> 0x0150 }
            int r6 = r0.zzc     // Catch:{ zznu -> 0x0150 }
            r7 = 2
            if (r6 != r7) goto L_0x011d
            r12 = 1
            goto L_0x011e
        L_0x011d:
            r12 = 0
        L_0x011e:
            int r13 = r0.zzg     // Catch:{ zznu -> 0x0150 }
            int r14 = r0.zzd     // Catch:{ zznu -> 0x0150 }
            int r15 = r0.zzh     // Catch:{ zznu -> 0x0150 }
            r10.zze(r11, r12, r13, r14, r15)     // Catch:{ zznu -> 0x0150 }
            r24.zzO()     // Catch:{ zznu -> 0x0150 }
            com.google.android.gms.internal.ads.zzl r0 = r1.zzU     // Catch:{ zznu -> 0x0150 }
            int r0 = r0.zza     // Catch:{ zznu -> 0x0150 }
            r6 = 1
            r1.zzE = r6     // Catch:{ zznu -> 0x0150 }
            r6 = 0
            goto L_0x015e
        L_0x0133:
            r0 = move-exception
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x014c }
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            r4 = 0
            r3[r4] = r2     // Catch:{ Exception -> 0x014c }
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            java.lang.String r5 = "addSuppressed"
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r5, r3)     // Catch:{ Exception -> 0x014c }
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x014c }
            r3[r4] = r0     // Catch:{ Exception -> 0x014c }
            r2.invoke(r11, r3)     // Catch:{ Exception -> 0x014c }
        L_0x014c:
            r24.zzK()     // Catch:{ zznu -> 0x0150 }
            throw r11     // Catch:{ zznu -> 0x0150 }
        L_0x0150:
            r0 = move-exception
            boolean r2 = r0.zzb
            if (r2 != 0) goto L_0x015c
            com.google.android.gms.internal.ads.zzon r2 = r1.zzm
            r2.zzb(r0)
            r6 = 0
            return r6
        L_0x015c:
            throw r0
        L_0x015d:
            r6 = r7
        L_0x015e:
            com.google.android.gms.internal.ads.zzon r0 = r1.zzm
            r0.zza()
            boolean r0 = r1.zzE
            r7 = 0
            if (r0 == 0) goto L_0x017d
            long r10 = java.lang.Math.max(r7, r3)
            r1.zzF = r10
            r1.zzD = r6
            r1.zzE = r6
            r1.zzI(r3)
            boolean r0 = r1.zzR
            if (r0 == 0) goto L_0x017d
            r24.zzh()
        L_0x017d:
            com.google.android.gms.internal.ads.zzoc r0 = r1.zzj
            long r10 = r24.zzF()
            boolean r0 = r0.zzj(r10)
            if (r0 != 0) goto L_0x018b
            r6 = 0
            return r6
        L_0x018b:
            java.nio.ByteBuffer r0 = r1.zzJ
            if (r0 != 0) goto L_0x0359
            java.nio.ByteOrder r0 = r25.order()
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r6) goto L_0x0199
            r0 = 1
            goto L_0x019a
        L_0x0199:
            r0 = 0
        L_0x019a:
            com.google.android.gms.internal.ads.zzdd.zzd(r0)
            boolean r0 = r25.hasRemaining()
            if (r0 != 0) goto L_0x01a5
            r6 = 1
            return r6
        L_0x01a5:
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzs
            int r6 = r0.zzc
            if (r6 == 0) goto L_0x02c9
            int r6 = r1.zzC
            if (r6 != 0) goto L_0x02c9
            int r0 = r0.zzg
            r6 = 1024(0x400, float:1.435E-42)
            r10 = -2
            r11 = 16
            r12 = -1
            switch(r0) {
                case 5: goto L_0x02be;
                case 6: goto L_0x02be;
                case 7: goto L_0x025a;
                case 8: goto L_0x025a;
                case 9: goto L_0x0244;
                case 10: goto L_0x0242;
                case 11: goto L_0x023f;
                case 12: goto L_0x023f;
                case 13: goto L_0x01ba;
                case 14: goto L_0x01ef;
                case 15: goto L_0x01ec;
                case 16: goto L_0x0242;
                case 17: goto L_0x01d1;
                case 18: goto L_0x02be;
                default: goto L_0x01ba;
            }
        L_0x01ba:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected audio encoding: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01d1:
            int r0 = com.google.android.gms.internal.ads.zzym.zza
            byte[] r0 = new byte[r11]
            int r6 = r25.position()
            r2.get(r0)
            r2.position(r6)
            com.google.android.gms.internal.ads.zzee r6 = new com.google.android.gms.internal.ads.zzee
            r6.<init>(r0, r11)
            com.google.android.gms.internal.ads.zzyl r0 = com.google.android.gms.internal.ads.zzym.zza(r6)
            int r0 = r0.zzc
            goto L_0x0252
        L_0x01ec:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x0252
        L_0x01ef:
            int r0 = com.google.android.gms.internal.ads.zzyj.zza
            int r0 = r25.position()
            int r6 = r25.limit()
            int r6 = r6 + -10
            r9 = r0
        L_0x01fc:
            if (r9 > r6) goto L_0x0210
            int r13 = r9 + 4
            int r13 = com.google.android.gms.internal.ads.zzen.zzk(r2, r13)
            r13 = r13 & r10
            r14 = -126718022(0xfffffffff8726fba, float:-1.966878E34)
            if (r13 != r14) goto L_0x020d
            int r0 = r9 - r0
            goto L_0x0211
        L_0x020d:
            int r9 = r9 + 1
            goto L_0x01fc
        L_0x0210:
            r0 = r12
        L_0x0211:
            if (r0 != r12) goto L_0x0215
            r0 = 0
            goto L_0x0252
        L_0x0215:
            int r6 = r25.position()
            int r6 = r6 + r0
            int r6 = r6 + 7
            byte r6 = r2.get(r6)
            int r9 = r25.position()
            int r9 = r9 + r0
            r0 = r6 & 255(0xff, float:3.57E-43)
            r6 = 187(0xbb, float:2.62E-43)
            if (r0 != r6) goto L_0x022e
            r0 = 9
            goto L_0x0230
        L_0x022e:
            r0 = 8
        L_0x0230:
            r6 = 40
            int r9 = r9 + r0
            byte r0 = r2.get(r9)
            int r0 = r0 >> 4
            r0 = r0 & 7
            int r0 = r6 << r0
            int r0 = r0 * r11
            goto L_0x0252
        L_0x023f:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x0252
        L_0x0242:
            r0 = r6
            goto L_0x0252
        L_0x0244:
            int r0 = r25.position()
            int r0 = com.google.android.gms.internal.ads.zzen.zzk(r2, r0)
            int r0 = com.google.android.gms.internal.ads.zzaac.zzc(r0)
            if (r0 == r12) goto L_0x0254
        L_0x0252:
            r10 = 1
            goto L_0x02c3
        L_0x0254:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x025a:
            int r0 = com.google.android.gms.internal.ads.zzzf.zza
            int r0 = r25.position()
            byte r6 = r2.get(r0)
            if (r6 == r10) goto L_0x02a5
            if (r6 == r12) goto L_0x0292
            if (r6 == r9) goto L_0x0281
            int r6 = r0 + 4
            byte r6 = r2.get(r6)
            r9 = 1
            r6 = r6 & r9
            int r6 = r6 << 6
            int r0 = r0 + 5
            byte r0 = r2.get(r0)
            r0 = r0 & 252(0xfc, float:3.53E-43)
        L_0x027c:
            r9 = 2
            int r0 = r0 >> r9
            r0 = r0 | r6
            r10 = 1
            goto L_0x02ba
        L_0x0281:
            int r6 = r0 + 5
            byte r6 = r2.get(r6)
            r6 = r6 & 7
            int r6 = r6 << 4
            int r0 = r0 + 6
            byte r0 = r2.get(r0)
            goto L_0x02a2
        L_0x0292:
            int r6 = r0 + 4
            byte r6 = r2.get(r6)
            r6 = r6 & 7
            int r6 = r6 << 4
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
        L_0x02a2:
            r0 = r0 & 60
            goto L_0x027c
        L_0x02a5:
            r9 = 2
            int r6 = r0 + 5
            byte r6 = r2.get(r6)
            r10 = 1
            r6 = r6 & r10
            int r6 = r6 << 6
            int r0 = r0 + 4
            byte r0 = r2.get(r0)
            r0 = r0 & 252(0xfc, float:3.53E-43)
            int r0 = r0 >> r9
            r0 = r0 | r6
        L_0x02ba:
            int r0 = r0 + r10
            int r0 = r0 * 32
            goto L_0x02c3
        L_0x02be:
            r10 = 1
            int r0 = com.google.android.gms.internal.ads.zzyj.zza(r25)
        L_0x02c3:
            r1.zzC = r0
            if (r0 == 0) goto L_0x02c8
            goto L_0x02c9
        L_0x02c8:
            return r10
        L_0x02c9:
            com.google.android.gms.internal.ads.zzom r0 = r1.zzv
            if (r0 == 0) goto L_0x02db
            boolean r0 = r24.zzQ()
            if (r0 != 0) goto L_0x02d5
            r6 = 0
            return r6
        L_0x02d5:
            r1.zzI(r3)
            r6 = 0
            r1.zzv = r6
        L_0x02db:
            long r9 = r1.zzF
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzs
            long r11 = r24.zzE()
            com.google.android.gms.internal.ads.zzpf r6 = r1.zzf
            long r13 = r6.zzo()
            long r11 = r11 - r13
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r11 * r13
            com.google.android.gms.internal.ads.zzaf r0 = r0.zza
            int r0 = r0.zzA
            long r13 = (long) r0
            long r11 = r11 / r13
            long r9 = r9 + r11
            boolean r0 = r1.zzD
            if (r0 != 0) goto L_0x0313
            long r11 = r9 - r3
            long r11 = java.lang.Math.abs(r11)
            r13 = 200000(0x30d40, double:9.8813E-319)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0313
            com.google.android.gms.internal.ads.zznv r0 = r1.zzq
            com.google.android.gms.internal.ads.zznw r6 = new com.google.android.gms.internal.ads.zznw
            r6.<init>(r3, r9)
            r0.zza(r6)
            r6 = 1
            r1.zzD = r6
        L_0x0313:
            boolean r0 = r1.zzD
            if (r0 == 0) goto L_0x033a
            boolean r0 = r24.zzQ()
            r6 = 0
            if (r0 != 0) goto L_0x031f
            return r6
        L_0x031f:
            long r9 = r3 - r9
            long r11 = r1.zzF
            long r11 = r11 + r9
            r1.zzF = r11
            r1.zzD = r6
            r1.zzI(r3)
            com.google.android.gms.internal.ads.zznv r0 = r1.zzq
            if (r0 == 0) goto L_0x033a
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x033a
            com.google.android.gms.internal.ads.zzoz r0 = (com.google.android.gms.internal.ads.zzoz) r0
            com.google.android.gms.internal.ads.zzpa r0 = r0.zza
            r0.zzab()
        L_0x033a:
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzs
            int r0 = r0.zzc
            if (r0 != 0) goto L_0x034b
            long r6 = r1.zzy
            int r0 = r25.remaining()
            long r8 = (long) r0
            long r6 = r6 + r8
            r1.zzy = r6
            goto L_0x0355
        L_0x034b:
            long r6 = r1.zzz
            int r0 = r1.zzC
            long r8 = (long) r0
            long r10 = (long) r5
            long r8 = r8 * r10
            long r6 = r6 + r8
            r1.zzz = r6
        L_0x0355:
            r1.zzJ = r2
            r1.zzK = r5
        L_0x0359:
            r1.zzM(r3)
            java.nio.ByteBuffer r0 = r1.zzJ
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x036c
            r2 = 0
            r1.zzJ = r2
            r2 = 0
            r1.zzK = r2
            r3 = 1
            return r3
        L_0x036c:
            r2 = 0
            r3 = 1
            com.google.android.gms.internal.ads.zzoc r0 = r1.zzj
            long r4 = r24.zzF()
            boolean r0 = r0.zzi(r4)
            if (r0 == 0) goto L_0x0385
            java.lang.String r0 = "DefaultAudioSink"
            java.lang.String r2 = "Resetting stalled audio track"
            com.google.android.gms.internal.ads.zzdw.zze(r0, r2)
            r24.zze()
            return r3
        L_0x0385:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzou.zzs(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean zzt() {
        return zzR() && this.zzj.zzg(zzF());
    }

    public final boolean zzu() {
        if (!zzR()) {
            return true;
        }
        if (this.zzP) {
            return !zzt();
        }
        return false;
    }

    public final boolean zzv(zzaf zzaf) {
        return zza(zzaf) != 0;
    }
}
