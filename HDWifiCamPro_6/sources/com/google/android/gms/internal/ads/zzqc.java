package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzqc {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf = new AtomicReference();
    private final zzdg zzg;
    private boolean zzh;

    public zzqc(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdg zzdg = new zzdg(zzde.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdg;
    }

    static /* bridge */ /* synthetic */ void zza(zzqc zzqc, Message message) {
        zzqb zzqb;
        int i = message.what;
        if (i == 0) {
            zzqb = (zzqb) message.obj;
            int i2 = zzqb.zza;
            int i3 = zzqb.zzb;
            try {
                zzqc.zzc.queueInputBuffer(i2, 0, zzqb.zzc, zzqb.zze, zzqb.zzf);
            } catch (RuntimeException e) {
                zzpz.zza(zzqc.zzf, (Object) null, e);
            }
        } else if (i != 1) {
            if (i != 2) {
                zzpz.zza(zzqc.zzf, (Object) null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                zzqc.zzg.zze();
            }
            zzqb = null;
        } else {
            zzqb = (zzqb) message.obj;
            int i4 = zzqb.zza;
            int i5 = zzqb.zzb;
            MediaCodec.CryptoInfo cryptoInfo = zzqb.zzd;
            long j = zzqb.zze;
            int i6 = zzqb.zzf;
            try {
                synchronized (zzb) {
                    zzqc.zzc.queueSecureInputBuffer(i4, 0, cryptoInfo, j, i6);
                }
            } catch (RuntimeException e2) {
                zzpz.zza(zzqc.zzf, (Object) null, e2);
            }
        }
        if (zzqb != null) {
            synchronized (zza) {
                zza.add(zzqb);
            }
        }
    }

    private static zzqb zzg() {
        synchronized (zza) {
            if (zza.isEmpty()) {
                zzqb zzqb = new zzqb();
                return zzqb;
            }
            zzqb zzqb2 = (zzqb) zza.removeFirst();
            return zzqb2;
        }
    }

    private final void zzh() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet((Object) null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                    this.zzg.zzc();
                    Handler handler2 = this.zze;
                    if (handler2 != null) {
                        handler2.obtainMessage(2).sendToTarget();
                        this.zzg.zza();
                        return;
                    }
                    throw null;
                }
                throw null;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void zzc(int i, int i2, int i3, long j, int i4) {
        zzh();
        zzqb zzg2 = zzg();
        zzg2.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        int i5 = zzen.zza;
        handler.obtainMessage(0, zzg2).sendToTarget();
    }

    public final void zzd(int i, int i2, zzgf zzgf, long j, int i3) {
        zzh();
        zzqb zzg2 = zzg();
        zzg2.zza(i, 0, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzg2.zzd;
        cryptoInfo.numSubSamples = zzgf.zzf;
        cryptoInfo.numBytesOfClearData = zzj(zzgf.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzj(zzgf.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] zzi = zzi(zzgf.zzb, cryptoInfo.key);
        if (zzi != null) {
            cryptoInfo.key = zzi;
            byte[] zzi2 = zzi(zzgf.zza, cryptoInfo.iv);
            if (zzi2 != null) {
                cryptoInfo.iv = zzi2;
                cryptoInfo.mode = zzgf.zzc;
                if (zzen.zza >= 24) {
                    cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzgf.zzg, zzgf.zzh));
                }
                this.zze.obtainMessage(1, zzg2).sendToTarget();
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void zze() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    public final void zzf() {
        if (!this.zzh) {
            this.zzd.start();
            this.zze = new zzqa(this, this.zzd.getLooper());
            this.zzh = true;
        }
    }

    private static byte[] zzi(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static int[] zzj(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }
}
