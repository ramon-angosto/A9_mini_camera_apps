package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbba extends zzawu {
    private int zzA;
    private final Context zzb;
    private final zzbbc zzc;
    private final zzbbk zzd;
    private final boolean zze;
    private final long[] zzf;
    private zzasw[] zzg;
    private zzbaz zzh;
    private Surface zzi;
    private Surface zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private float zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private float zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private float zzy;
    private long zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbba(Context context, zzaww zzaww, long j, Handler handler, zzbbl zzbbl, int i) {
        super(2, zzaww, (zzauw) null, false);
        boolean z = false;
        this.zzb = context.getApplicationContext();
        this.zzc = new zzbbc(context);
        this.zzd = new zzbbk(handler, zzbbl);
        if (zzbar.zza <= 22 && "foster".equals(zzbar.zzb) && "NVIDIA".equals(zzbar.zzc)) {
            z = true;
        }
        this.zze = z;
        this.zzf = new long[10];
        this.zzz = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzr = -1;
        this.zzs = -1;
        this.zzu = -1.0f;
        this.zzq = -1.0f;
        zzab();
    }

    private static int zzN(zzasw zzasw) {
        int i = zzasw.zzm;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private final void zzab() {
        this.zzv = -1;
        this.zzw = -1;
        this.zzy = -1.0f;
        this.zzx = -1;
    }

    private final void zzac() {
        if (this.zzn > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzd.zzd(this.zzn, elapsedRealtime - this.zzm);
            this.zzn = 0;
            this.zzm = elapsedRealtime;
        }
    }

    private final void zzad() {
        int i = this.zzv;
        int i2 = this.zzr;
        if (i != i2 || this.zzw != this.zzs || this.zzx != this.zzt || this.zzy != this.zzu) {
            this.zzd.zzh(i2, this.zzs, this.zzt, this.zzu);
            this.zzv = this.zzr;
            this.zzw = this.zzs;
            this.zzx = this.zzt;
            this.zzy = this.zzu;
        }
    }

    private final void zzae() {
        if (this.zzv != -1 || this.zzw != -1) {
            this.zzd.zzh(this.zzr, this.zzs, this.zzt, this.zzu);
        }
    }

    private static boolean zzaf(long j) {
        return j < -30000;
    }

    private final boolean zzag(boolean z) {
        if (zzbar.zza < 23) {
            return false;
        }
        if (z) {
            return zzbax.zzb(this.zzb);
        }
        return true;
    }

    public final boolean zzF() {
        Surface surface;
        if (super.zzF() && (this.zzk || (((surface = this.zzj) != null && this.zzi == surface) || zzU() == null))) {
            this.zzl = C.TIME_UNSET;
            return true;
        } else if (this.zzl == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzl) {
                return true;
            }
            this.zzl = C.TIME_UNSET;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzH(zzaww zzaww, zzasw zzasw) throws zzawz {
        boolean z;
        String str = zzasw.zzf;
        int i = 0;
        if (!zzbah.zzb(str)) {
            return 0;
        }
        zzauv zzauv = zzasw.zzi;
        if (zzauv != null) {
            z = false;
            for (int i2 = 0; i2 < zzauv.zza; i2++) {
                z |= zzauv.zza(i2).zzc;
            }
        } else {
            z = false;
        }
        zzaws zzc2 = zzaxe.zzc(str, z);
        if (zzc2 == null) {
            return 1;
        }
        boolean zze2 = zzc2.zze(zzasw.zzc);
        if (zze2 && zzasw.zzj > 0 && zzasw.zzk > 0) {
            if (zzbar.zza >= 21) {
                zze2 = zzc2.zzf(zzasw.zzj, zzasw.zzk, (double) zzasw.zzl);
            } else {
                zze2 = zzasw.zzj * zzasw.zzk <= zzaxe.zza();
                if (!zze2) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + zzasw.zzj + "x" + zzasw.zzk + "] [" + zzbar.zze + "]");
                }
            }
        }
        int i3 = true != zzc2.zzb ? 4 : 8;
        if (true == zzc2.zzc) {
            i = 16;
        }
        return (true != zze2 ? 2 : 3) | i3 | i;
    }

    /* access modifiers changed from: package-private */
    public final void zzI() {
        if (!this.zzk) {
            this.zzk = true;
            this.zzd.zzg(this.zzi);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzJ(MediaCodec mediaCodec, int i, long j) {
        zzad();
        zzbap.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzbap.zzb();
        this.zza.zzd++;
        this.zzo = 0;
        zzI();
    }

    /* access modifiers changed from: protected */
    public final void zzK(MediaCodec mediaCodec, int i, long j, long j2) {
        zzad();
        zzbap.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzbap.zzb();
        this.zza.zzd++;
        this.zzo = 0;
        zzI();
    }

    /* access modifiers changed from: protected */
    public final void zzL(MediaCodec mediaCodec, int i, long j) {
        zzbap.zza("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzbap.zzb();
        this.zza.zze++;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(com.google.android.gms.internal.ads.zzaws r12, android.media.MediaCodec r13, com.google.android.gms.internal.ads.zzasw r14, android.media.MediaCrypto r15) throws com.google.android.gms.internal.ads.zzawz {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzasw[] r15 = r11.zzg
            int r0 = r14.zzj
            int r1 = r14.zzk
            int r2 = r14.zzg
            r3 = 0
            r4 = -1
            if (r2 != r4) goto L_0x008f
            java.lang.String r2 = r14.zzf
            if (r0 == r4) goto L_0x008e
            if (r1 != r4) goto L_0x0014
            goto L_0x008e
        L_0x0014:
            int r5 = r2.hashCode()
            r6 = 5
            r7 = 1
            r8 = 4
            r9 = 3
            r10 = 2
            switch(r5) {
                case -1664118616: goto L_0x0053;
                case -1662541442: goto L_0x0049;
                case 1187890754: goto L_0x003f;
                case 1331836730: goto L_0x0035;
                case 1599127256: goto L_0x002b;
                case 1599127257: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x005d
        L_0x0021:
            java.lang.String r5 = "video/x-vnd.on2.vp9"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r6
            goto L_0x005e
        L_0x002b:
            java.lang.String r5 = "video/x-vnd.on2.vp8"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r9
            goto L_0x005e
        L_0x0035:
            java.lang.String r5 = "video/avc"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r10
            goto L_0x005e
        L_0x003f:
            java.lang.String r5 = "video/mp4v-es"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r7
            goto L_0x005e
        L_0x0049:
            java.lang.String r5 = "video/hevc"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r8
            goto L_0x005e
        L_0x0053:
            java.lang.String r5 = "video/3gpp"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r3
            goto L_0x005e
        L_0x005d:
            r2 = r4
        L_0x005e:
            if (r2 == 0) goto L_0x0088
            if (r2 == r7) goto L_0x0088
            if (r2 == r10) goto L_0x006f
            if (r2 == r9) goto L_0x0088
            if (r2 == r8) goto L_0x006b
            if (r2 == r6) goto L_0x006b
            goto L_0x008e
        L_0x006b:
            int r2 = r0 * r1
            r10 = r8
            goto L_0x008a
        L_0x006f:
            java.lang.String r2 = com.google.android.gms.internal.ads.zzbar.zzd
            java.lang.String r5 = "BRAVIA 4K 2015"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x007a
            goto L_0x008e
        L_0x007a:
            r2 = 16
            int r5 = com.google.android.gms.internal.ads.zzbar.zzd(r0, r2)
            int r2 = com.google.android.gms.internal.ads.zzbar.zzd(r1, r2)
            int r5 = r5 * r2
            int r2 = r5 * 256
            goto L_0x008a
        L_0x0088:
            int r2 = r0 * r1
        L_0x008a:
            int r2 = r2 * r9
            int r10 = r10 + r10
            int r2 = r2 / r10
            goto L_0x008f
        L_0x008e:
            r2 = r4
        L_0x008f:
            int r15 = r15.length
            com.google.android.gms.internal.ads.zzbaz r15 = new com.google.android.gms.internal.ads.zzbaz
            r15.<init>(r0, r1, r2)
            r11.zzh = r15
            com.google.android.gms.internal.ads.zzbaz r15 = r11.zzh
            boolean r0 = r11.zze
            android.media.MediaFormat r14 = r14.zzb()
            int r1 = r15.zza
            java.lang.String r2 = "max-width"
            r14.setInteger(r2, r1)
            int r1 = r15.zzb
            java.lang.String r2 = "max-height"
            r14.setInteger(r2, r1)
            int r15 = r15.zzc
            if (r15 == r4) goto L_0x00b6
            java.lang.String r1 = "max-input-size"
            r14.setInteger(r1, r15)
        L_0x00b6:
            if (r0 == 0) goto L_0x00bd
            java.lang.String r15 = "auto-frc"
            r14.setInteger(r15, r3)
        L_0x00bd:
            android.view.Surface r15 = r11.zzi
            if (r15 != 0) goto L_0x00dc
            boolean r15 = r12.zzd
            boolean r15 = r11.zzag(r15)
            com.google.android.gms.internal.ads.zzbac.zze(r15)
            android.view.Surface r15 = r11.zzj
            if (r15 != 0) goto L_0x00d8
            android.content.Context r15 = r11.zzb
            boolean r12 = r12.zzd
            com.google.android.gms.internal.ads.zzbax r12 = com.google.android.gms.internal.ads.zzbax.zza(r15, r12)
            r11.zzj = r12
        L_0x00d8:
            android.view.Surface r12 = r11.zzj
            r11.zzi = r12
        L_0x00dc:
            android.view.Surface r12 = r11.zzi
            r15 = 0
            r13.configure(r14, r12, r15, r3)
            int r12 = com.google.android.gms.internal.ads.zzbar.zza
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbba.zzO(com.google.android.gms.internal.ads.zzaws, android.media.MediaCodec, com.google.android.gms.internal.ads.zzasw, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public final void zzP(String str, long j, long j2) {
        this.zzd.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzQ(zzasw zzasw) throws zzasi {
        super.zzQ(zzasw);
        this.zzd.zzf(zzasw);
        float f = zzasw.zzn;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.zzq = f;
        this.zzp = zzN(zzasw);
    }

    /* access modifiers changed from: protected */
    public final void zzR(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = false;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z = true;
        }
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzr = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzs = i2;
        this.zzu = this.zzq;
        if (zzbar.zza >= 21) {
            int i3 = this.zzp;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzr;
                this.zzr = this.zzs;
                this.zzs = i4;
                this.zzu = 1.0f / this.zzu;
            }
        } else {
            this.zzt = this.zzp;
        }
        mediaCodec.setVideoScalingMode(1);
    }

    /* access modifiers changed from: protected */
    public final boolean zzT(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzA;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzf;
            long j5 = jArr[0];
            if (j4 < j5) {
                break;
            }
            this.zzz = j5;
            int i5 = i4 - 1;
            this.zzA = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j6 = j4 - this.zzz;
        if (z) {
            zzL(mediaCodec2, i3, j6);
            return true;
        }
        long j7 = j4 - j;
        if (this.zzi == this.zzj) {
            if (!zzaf(j7)) {
                return false;
            }
            zzL(mediaCodec2, i3, j6);
            return true;
        } else if (!this.zzk) {
            if (zzbar.zza >= 21) {
                zzK(mediaCodec, i, j6, System.nanoTime());
            } else {
                zzJ(mediaCodec2, i3, j6);
            }
            return true;
        } else if (zzb() != 2) {
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long nanoTime = System.nanoTime();
            long zza = this.zzc.zza(j4, ((j7 - ((elapsedRealtime * 1000) - j2)) * 1000) + nanoTime);
            long j8 = (zza - nanoTime) / 1000;
            if (zzaf(j8)) {
                zzbap.zza("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzbap.zzb();
                zzauq zzauq = this.zza;
                zzauq.zzf++;
                this.zzn++;
                int i6 = this.zzo + 1;
                this.zzo = i6;
                zzauq.zzg = Math.max(i6, zzauq.zzg);
                if (this.zzn == -1) {
                    zzac();
                }
                return true;
            }
            if (zzbar.zza >= 21) {
                if (j8 < 50000) {
                    zzK(mediaCodec, i, j6, zza);
                    return true;
                }
            } else if (j8 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                if (j8 > 11000) {
                    try {
                        Thread.sleep((j8 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzJ(mediaCodec2, i3, j6);
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzX(zzaur zzaur) {
        int i = zzbar.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzY() {
        try {
            super.zzY();
        } finally {
            Surface surface = this.zzj;
            if (surface != null) {
                if (this.zzi == surface) {
                    this.zzi = null;
                }
                surface.release();
                this.zzj = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzZ(MediaCodec mediaCodec, boolean z, zzasw zzasw, zzasw zzasw2) {
        if (!zzasw.zzf.equals(zzasw2.zzf) || zzN(zzasw) != zzN(zzasw2)) {
            return false;
        }
        if (!z && (zzasw.zzj != zzasw2.zzj || zzasw.zzk != zzasw2.zzk)) {
            return false;
        }
        int i = zzasw2.zzj;
        zzbaz zzbaz = this.zzh;
        return i <= zzbaz.zza && zzasw2.zzk <= zzbaz.zzb && zzasw2.zzg <= zzbaz.zzc;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaa(zzaws zzaws) {
        return this.zzi != null || zzag(zzaws.zzd);
    }

    public final void zzl(int i, Object obj) throws zzasi {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzj;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzaws zzV = zzV();
                    if (zzV != null && zzag(zzV.zzd)) {
                        this.zzj = zzbax.zza(this.zzb, zzV.zzd);
                        surface = this.zzj;
                    }
                }
            }
            if (this.zzi != surface) {
                this.zzi = surface;
                int zzb2 = zzb();
                if (zzb2 == 1 || zzb2 == 2) {
                    MediaCodec zzU = zzU();
                    if (zzbar.zza < 23 || zzU == null || surface == null) {
                        zzY();
                        zzW();
                    } else {
                        zzU.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzj) {
                    zzab();
                    this.zzk = false;
                    int i2 = zzbar.zza;
                    return;
                }
                zzae();
                this.zzk = false;
                int i3 = zzbar.zza;
                if (zzb2 == 2) {
                    this.zzl = C.TIME_UNSET;
                }
            } else if (surface != null && surface != this.zzj) {
                zzae();
                if (this.zzk) {
                    this.zzd.zzg(this.zzi);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn() {
        this.zzr = -1;
        this.zzs = -1;
        this.zzu = -1.0f;
        this.zzq = -1.0f;
        this.zzz = C.TIME_UNSET;
        this.zzA = 0;
        zzab();
        this.zzk = false;
        int i = zzbar.zza;
        this.zzc.zzb();
        try {
            super.zzn();
        } finally {
            this.zza.zza();
            this.zzd.zzc(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzo(boolean z) throws zzasi {
        super.zzo(z);
        int i = zzg().zzb;
        this.zzd.zze(this.zza);
        this.zzc.zzc();
    }

    /* access modifiers changed from: protected */
    public final void zzp(long j, boolean z) throws zzasi {
        super.zzp(j, z);
        this.zzk = false;
        int i = zzbar.zza;
        this.zzo = 0;
        int i2 = this.zzA;
        if (i2 != 0) {
            this.zzz = this.zzf[i2 - 1];
            this.zzA = 0;
        }
        this.zzl = C.TIME_UNSET;
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        this.zzn = 0;
        this.zzm = SystemClock.elapsedRealtime();
        this.zzl = C.TIME_UNSET;
    }

    /* access modifiers changed from: protected */
    public final void zzr() {
        zzac();
    }

    /* access modifiers changed from: protected */
    public final void zzs(zzasw[] zzaswArr, long j) throws zzasi {
        this.zzg = zzaswArr;
        if (this.zzz == C.TIME_UNSET) {
            this.zzz = j;
            return;
        }
        int i = this.zzA;
        if (i == 10) {
            long j2 = this.zzf[9];
            Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + j2);
        } else {
            this.zzA = i + 1;
        }
        this.zzf[this.zzA - 1] = j;
    }
}
