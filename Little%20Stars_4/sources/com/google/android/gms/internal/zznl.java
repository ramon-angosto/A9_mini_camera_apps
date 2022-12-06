package com.google.android.gms.internal;

import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zznt;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class zznl implements com.google.android.gms.clearcut.zzc {
    private static final Object zzajR = new Object();
    private static ScheduledExecutorService zzajS;
    /* access modifiers changed from: private */
    public static final zze zzajT = new zze();
    private static final long zzajU = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    /* access modifiers changed from: private */
    public GoogleApiClient zzaeN;
    private final zza zzajV;
    /* access modifiers changed from: private */
    public final Object zzajW;
    private long zzajX;
    private final long zzajY;
    private ScheduledFuture<?> zzajZ;
    private final Runnable zzaka;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.util.zze zzsd;

    public interface zza {
    }

    public static class zzb implements zza {
    }

    static abstract class zzc<R extends Result> extends zznt.zza<R, zznm> {
        public zzc(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zzb.zzaaz, googleApiClient);
        }
    }

    static final class zzd extends zzc<Status> {
        private final LogEventParcelable zzakf;

        zzd(LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzakf = logEventParcelable;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzd)) {
                return false;
            }
            return this.zzakf.equals(((zzd) obj).zzakf);
        }

        public String toString() {
            String valueOf = String.valueOf(this.zzakf);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 12);
            sb.append("MethodImpl(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public void zza(zznm zznm) throws RemoteException {
            AnonymousClass1 r0 = new zznn.zza() {
                public void zzu(Status status) {
                    zzd.this.zzb(status);
                }
            };
            try {
                zznl.zza(this.zzakf);
                zznm.zza(r0, this.zzakf);
            } catch (RuntimeException e) {
                Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageNanoProducer", e);
                zzx(new Status(10, "MessageProducer"));
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        public synchronized void zzqS() {
            this.mSize++;
        }

        public synchronized void zzqT() {
            if (this.mSize != 0) {
                this.mSize--;
                if (this.mSize == 0) {
                    notifyAll();
                }
            } else {
                throw new RuntimeException("too many decrements");
            }
        }
    }

    public zznl() {
        this(new zzh(), zzajU, new zzb());
    }

    public zznl(com.google.android.gms.common.util.zze zze2, long j, zza zza2) {
        this.zzajW = new Object();
        this.zzajX = 0;
        this.zzajZ = null;
        this.zzaeN = null;
        this.zzaka = new Runnable() {
            public void run() {
                synchronized (zznl.this.zzajW) {
                    if (zznl.zzb(zznl.this) <= zznl.this.zzsd.elapsedRealtime() && zznl.this.zzaeN != null) {
                        Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                        zznl.this.zzaeN.disconnect();
                        GoogleApiClient unused = zznl.this.zzaeN = null;
                    }
                }
            }
        };
        this.zzsd = zze2;
        this.zzajY = j;
        this.zzajV = zza2;
    }

    private PendingResult<Status> zza(final GoogleApiClient googleApiClient, final zzc<Status> zzc2) {
        zzqQ().execute(new Runnable() {
            public void run() {
                googleApiClient.zzc(zzc2);
            }
        });
        return zzc2;
    }

    /* access modifiers changed from: private */
    public static void zza(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.zzajP != null && logEventParcelable.zzajO.zzcaM.length == 0) {
            logEventParcelable.zzajO.zzcaM = logEventParcelable.zzajP.zzqP();
        }
        if (logEventParcelable.zzajQ != null && logEventParcelable.zzajO.zzcaT.length == 0) {
            logEventParcelable.zzajO.zzcaT = logEventParcelable.zzajQ.zzqP();
        }
        logEventParcelable.zzajM = zzamj.toByteArray(logEventParcelable.zzajO);
    }

    static /* synthetic */ long zzb(zznl zznl) {
        return 0;
    }

    private zzd zzb(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zzajT.zzqS();
        zzd zzd2 = new zzd(logEventParcelable, googleApiClient);
        zzd2.zza((PendingResult.zza) new PendingResult.zza() {
            public void zzt(Status status) {
                zznl.zzajT.zzqT();
            }
        });
        return zzd2;
    }

    private ScheduledExecutorService zzqQ() {
        synchronized (zzajR) {
            if (zzajS == null) {
                zzajS = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
                    public Thread newThread(final Runnable runnable) {
                        return new Thread(new Runnable() {
                            public void run() {
                                Process.setThreadPriority(10);
                                runnable.run();
                            }
                        }, "ClearcutLoggerApiImpl");
                    }
                });
            }
        }
        return zzajS;
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        return zza(googleApiClient, (zzc<Status>) zzb(googleApiClient, logEventParcelable));
    }
}
