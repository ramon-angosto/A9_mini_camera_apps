package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzazx extends Handler implements Runnable {
    public final int zza;
    final /* synthetic */ zzbaa zzb;
    private final zzazy zzc;
    private final zzazw zzd;
    private final long zze;
    private IOException zzf;
    private int zzg;
    private volatile Thread zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzazx(zzbaa zzbaa, Looper looper, zzazy zzazy, zzazw zzazw, int i, long j) {
        super(looper);
        this.zzb = zzbaa;
        this.zzc = zzazy;
        this.zzd = zzazw;
        this.zza = i;
        this.zze = j;
    }

    private final void zzd() {
        this.zzf = null;
        zzbaa zzbaa = this.zzb;
        zzbaa.zza.execute(zzbaa.zzb);
    }

    public final void handleMessage(Message message) {
        if (!this.zzi) {
            if (message.what == 0) {
                zzd();
            } else if (message.what != 4) {
                this.zzb.zzb = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zze;
                if (this.zzc.zze()) {
                    this.zzd.zzt(this.zzc, elapsedRealtime, j, false);
                    return;
                }
                int i = message.what;
                int i2 = 1;
                if (i == 1) {
                    this.zzd.zzt(this.zzc, elapsedRealtime, j, false);
                } else if (i == 2) {
                    this.zzd.zzu(this.zzc, elapsedRealtime, j);
                } else if (i == 3) {
                    this.zzf = (IOException) message.obj;
                    int zzd2 = this.zzd.zzd(this.zzc, elapsedRealtime, j, this.zzf);
                    if (zzd2 == 3) {
                        this.zzb.zzc = this.zzf;
                    } else if (zzd2 != 2) {
                        if (zzd2 != 1) {
                            i2 = 1 + this.zzg;
                        }
                        this.zzg = i2;
                        zzc((long) Math.min((i2 - 1) * 1000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        try {
            this.zzh = Thread.currentThread();
            if (!this.zzc.zze()) {
                String simpleName = this.zzc.getClass().getSimpleName();
                zzbap.zza("load:" + simpleName);
                this.zzc.zzc();
                zzbap.zzb();
            }
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzbac.zze(this.zzc.zze());
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.zzi) {
                obtainMessage(3, new zzazz(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.zzi) {
                obtainMessage(3, new zzazz(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzi) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzbap.zzb();
            throw th;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zzf = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
                return;
            }
        } else {
            this.zzc.zzb();
            if (this.zzh != null) {
                this.zzh.interrupt();
            }
            if (!z) {
                return;
            }
        }
        this.zzb.zzb = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzd.zzt(this.zzc, elapsedRealtime, elapsedRealtime - this.zze, true);
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zzf;
        if (iOException != null && this.zzg > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzbac.zze(this.zzb.zzb == null);
        this.zzb.zzb = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }
}
