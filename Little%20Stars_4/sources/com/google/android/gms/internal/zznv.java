package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zznv<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zzalX = new ThreadLocal<Boolean>() {
        /* access modifiers changed from: protected */
        /* renamed from: zzrK */
        public Boolean initialValue() {
            return false;
        }
    };
    private boolean zzK;
    private final Object zzalY;
    protected final zza<R> zzalZ;
    /* access modifiers changed from: private */
    public R zzals;
    protected final WeakReference<GoogleApiClient> zzama;
    private final ArrayList<PendingResult.zza> zzamb;
    private ResultCallback<? super R> zzamc;
    private zzb zzamd;
    private volatile boolean zzame;
    private boolean zzamf;
    private zzr zzamg;
    private volatile zzpe<R> zzamh;
    private boolean zzami;
    private final CountDownLatch zzqF;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                zzb((ResultCallback) pair.first, (Result) pair.second);
            } else if (i != 2) {
                int i2 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((zznv) message.obj).zzy(Status.zzalz);
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zznv<R> zznv, long j) {
            sendMessageDelayed(obtainMessage(2, zznv), j);
        }

        /* access modifiers changed from: protected */
        public void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zznv.zzd(r);
                throw e;
            }
        }

        public void zzrL() {
            removeMessages(2);
        }
    }

    private final class zzb {
        private zzb() {
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            zznv.zzd(zznv.this.zzals);
            super.finalize();
        }
    }

    @Deprecated
    zznv() {
        this.zzalY = new Object();
        this.zzqF = new CountDownLatch(1);
        this.zzamb = new ArrayList<>();
        this.zzami = false;
        this.zzalZ = new zza<>(Looper.getMainLooper());
        this.zzama = new WeakReference<>((Object) null);
    }

    @Deprecated
    protected zznv(Looper looper) {
        this.zzalY = new Object();
        this.zzqF = new CountDownLatch(1);
        this.zzamb = new ArrayList<>();
        this.zzami = false;
        this.zzalZ = new zza<>(looper);
        this.zzama = new WeakReference<>((Object) null);
    }

    protected zznv(GoogleApiClient googleApiClient) {
        this.zzalY = new Object();
        this.zzqF = new CountDownLatch(1);
        this.zzamb = new ArrayList<>();
        this.zzami = false;
        this.zzalZ = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzama = new WeakReference<>(googleApiClient);
    }

    private R get() {
        R r;
        synchronized (this.zzalY) {
            zzaa.zza(!this.zzame, (Object) "Result has already been consumed.");
            zzaa.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzals;
            this.zzals = null;
            this.zzamc = null;
            this.zzame = true;
        }
        zzrE();
        return r;
    }

    private void zzc(R r) {
        this.zzals = r;
        this.zzamg = null;
        this.zzqF.countDown();
        Status status = this.zzals.getStatus();
        if (this.zzK) {
            this.zzamc = null;
        } else if (this.zzamc != null) {
            this.zzalZ.zzrL();
            this.zzalZ.zza(this.zzamc, get());
        } else if (this.zzals instanceof Releasable) {
            this.zzamd = new zzb();
        }
        Iterator<PendingResult.zza> it = this.zzamb.iterator();
        while (it.hasNext()) {
            it.next().zzt(status);
        }
        this.zzamb.clear();
    }

    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    public final R await() {
        boolean z = false;
        zzaa.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzaa.zza(!this.zzame, (Object) "Result has already been consumed");
        if (this.zzamh == null) {
            z = true;
        }
        zzaa.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzqF.await();
        } catch (InterruptedException unused) {
            zzy(Status.zzalx);
        }
        zzaa.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long j, TimeUnit timeUnit) {
        boolean z = false;
        zzaa.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzaa.zza(!this.zzame, (Object) "Result has already been consumed.");
        if (this.zzamh == null) {
            z = true;
        }
        zzaa.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzqF.await(j, timeUnit)) {
                zzy(Status.zzalz);
            }
        } catch (InterruptedException unused) {
            zzy(Status.zzalx);
        }
        zzaa.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|(2:10|11)|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zzalY
            monitor-enter(r0)
            boolean r1 = r2.zzK     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0028
            boolean r1 = r2.zzame     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x000c
            goto L_0x0028
        L_0x000c:
            com.google.android.gms.common.internal.zzr r1 = r2.zzamg     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.common.internal.zzr r1 = r2.zzamg     // Catch:{ RemoteException -> 0x0015 }
            r1.cancel()     // Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            R r1 = r2.zzals     // Catch:{ all -> 0x002a }
            zzd(r1)     // Catch:{ all -> 0x002a }
            r1 = 1
            r2.zzK = r1     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.zzalA     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.Result r1 = r2.zzc((com.google.android.gms.common.api.Status) r1)     // Catch:{ all -> 0x002a }
            r2.zzc(r1)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznv.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzalY) {
            z = this.zzK;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzqF.getCount() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zzalY
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000a
            r6 = 0
            r5.zzamc = r6     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x000a:
            boolean r1 = r5.zzame     // Catch:{ all -> 0x003f }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzaa.zza((boolean) r1, (java.lang.Object) r4)     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.zzpe<R> r1 = r5.zzamh     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzaa.zza((boolean) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x003f }
            boolean r1 = r5.isCanceled()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x002b:
            boolean r1 = r5.isReady()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.internal.zznv$zza<R> r1 = r5.zzalZ     // Catch:{ all -> 0x003f }
            com.google.android.gms.common.api.Result r2 = r5.get()     // Catch:{ all -> 0x003f }
            r1.zza(r6, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x003b:
            r5.zzamc = r6     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznv.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r6, long r7, java.util.concurrent.TimeUnit r9) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zzalY
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000a
            r6 = 0
            r5.zzamc = r6     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000a:
            boolean r1 = r5.zzame     // Catch:{ all -> 0x0048 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzaa.zza((boolean) r1, (java.lang.Object) r4)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.zzpe<R> r1 = r5.zzamh     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzaa.zza((boolean) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x0048 }
            boolean r1 = r5.isCanceled()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x002b:
            boolean r1 = r5.isReady()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.internal.zznv$zza<R> r7 = r5.zzalZ     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.api.Result r8 = r5.get()     // Catch:{ all -> 0x0048 }
            r7.zza(r6, r8)     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x003b:
            r5.zzamc = r6     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.zznv$zza<R> r6 = r5.zzalZ     // Catch:{ all -> 0x0048 }
            long r7 = r9.toMillis(r7)     // Catch:{ all -> 0x0048 }
            r6.zza(r5, (long) r7)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznv.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        zzaa.zza(!this.zzame, (Object) "Result has already been consumed.");
        synchronized (this.zzalY) {
            boolean z = false;
            zzaa.zza(this.zzamh == null, (Object) "Cannot call then() twice.");
            if (this.zzamc == null) {
                z = true;
            }
            zzaa.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.zzami = true;
            this.zzamh = new zzpe<>(this.zzama);
            then = this.zzamh.then(resultTransform);
            if (isReady()) {
                this.zzalZ.zza(this.zzamh, get());
            } else {
                this.zzamc = this.zzamh;
            }
        }
        return then;
    }

    public final void zza(PendingResult.zza zza2) {
        boolean z = true;
        zzaa.zza(!this.zzame, (Object) "Result has already been consumed.");
        if (zza2 == null) {
            z = false;
        }
        zzaa.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.zzalY) {
            if (isReady()) {
                zza2.zzt(this.zzals.getStatus());
            } else {
                this.zzamb.add(zza2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzr zzr) {
        synchronized (this.zzalY) {
            this.zzamg = zzr;
        }
    }

    public final void zzb(R r) {
        synchronized (this.zzalY) {
            if (!this.zzamf && !this.zzK) {
                if (!isReady() || !zzrJ()) {
                    boolean z = true;
                    zzaa.zza(!isReady(), (Object) "Results have already been set");
                    if (this.zzame) {
                        z = false;
                    }
                    zzaa.zza(z, (Object) "Result has already been consumed");
                    zzc(r);
                    return;
                }
            }
            zzd(r);
        }
    }

    /* access modifiers changed from: protected */
    public abstract R zzc(Status status);

    /* access modifiers changed from: protected */
    public void zzrE() {
    }

    public boolean zzrH() {
        boolean isCanceled;
        synchronized (this.zzalY) {
            if (((GoogleApiClient) this.zzama.get()) == null || !this.zzami) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public void zzrI() {
        this.zzami = this.zzami || zzalX.get().booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean zzrJ() {
        return false;
    }

    public Integer zzrv() {
        return null;
    }

    public final void zzy(Status status) {
        synchronized (this.zzalY) {
            if (!isReady()) {
                zzb(zzc(status));
                this.zzamf = true;
            }
        }
    }
}
