package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzwr extends Handler implements Runnable {
    final /* synthetic */ zzww zza;
    private final zzws zzb;
    private final long zzc;
    private zzwo zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzwr(zzww zzww, Looper looper, zzws zzws, zzwo zzwo, int i, long j) {
        super(looper);
        this.zza = zzww;
        this.zzb = zzws;
        this.zzd = zzwo;
        this.zzc = j;
    }

    public final void handleMessage(Message message) {
        long j;
        if (!this.zzi) {
            if (message.what == 0) {
                zzd();
            } else if (message.what != 3) {
                this.zza.zzf = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime - this.zzc;
                zzwo zzwo = this.zzd;
                if (zzwo == null) {
                    throw null;
                } else if (this.zzh) {
                    zzwo.zzI(this.zzb, elapsedRealtime, j2, false);
                } else {
                    int i = message.what;
                    if (i == 1) {
                        try {
                            zzwo.zzJ(this.zzb, elapsedRealtime, j2);
                        } catch (RuntimeException e) {
                            zzdw.zzc("LoadTask", "Unexpected exception handling load completed", e);
                            this.zza.zzg = new zzwv(e);
                        }
                    } else if (i == 2) {
                        this.zze = (IOException) message.obj;
                        int i2 = this.zzf + 1;
                        this.zzf = i2;
                        zzwq zzt = zzwo.zzt(this.zzb, elapsedRealtime, j2, this.zze, i2);
                        if (zzt.zza == 3) {
                            this.zza.zzg = this.zze;
                        } else if (zzt.zza != 2) {
                            if (zzt.zza == 1) {
                                this.zzf = 1;
                            }
                            if (zzt.zzb != C.TIME_UNSET) {
                                j = zzt.zzb;
                            } else {
                                j = (long) Math.min((this.zzf - 1) * 1000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
                            }
                            zzc(j);
                        }
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z) {
                int i = zzen.zza;
                Trace.beginSection("load:" + this.zzb.getClass().getSimpleName());
                this.zzb.zzh();
                Trace.endSection();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(2, e).sendToTarget();
            }
        } catch (Exception e2) {
            if (!this.zzi) {
                zzdw.zzc("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new zzwv(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.zzi) {
                zzdw.zzc("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new zzwv(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.zzi) {
                zzdw.zzc("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzwo zzwo = this.zzd;
            if (zzwo != null) {
                zzwo.zzI(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
                this.zzd = null;
                return;
            }
            throw null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzdd.zzf(this.zza.zzf == null);
        this.zza.zzf = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }

    private final void zzd() {
        this.zze = null;
        zzww zzww = this.zza;
        ExecutorService zzd2 = zzww.zze;
        zzwr zzc2 = zzww.zzf;
        if (zzc2 != null) {
            zzd2.execute(zzc2);
            return;
        }
        throw null;
    }
}
