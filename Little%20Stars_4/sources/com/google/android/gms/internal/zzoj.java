package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class zzoj implements Handler.Callback {
    private static zzoj zzanL;
    /* access modifiers changed from: private */
    public static final Object zzrs = new Object();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public final GoogleApiAvailability zzaln;
    /* access modifiers changed from: private */
    public long zzanK;
    /* access modifiers changed from: private */
    public int zzanM;
    private final AtomicInteger zzanN;
    private final SparseArray<zzc<?>> zzanO;
    /* access modifiers changed from: private */
    public final Map<zznq<?>, zzc<?>> zzanP;
    private zzny zzanQ;
    /* access modifiers changed from: private */
    public final Set<zznq<?>> zzanR;
    private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> zzanS;
    /* access modifiers changed from: private */
    public final SparseArray<zza> zzanT;
    private zzb zzanU;
    /* access modifiers changed from: private */
    public long zzanj;
    /* access modifiers changed from: private */
    public long zzank;

    private final class zza extends PhantomReference<com.google.android.gms.common.api.zzc<?>> {
        /* access modifiers changed from: private */
        public final int zzalC;

        public zza(com.google.android.gms.common.api.zzc zzc, int i, ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue) {
            super(zzc, referenceQueue);
            this.zzalC = i;
        }

        public void zzst() {
            zzoj.this.mHandler.sendMessage(zzoj.this.mHandler.obtainMessage(2, this.zzalC, 2));
        }
    }

    private static final class zzb extends Thread {
        private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> zzanS;
        private final SparseArray<zza> zzanT;
        /* access modifiers changed from: private */
        public final AtomicBoolean zzanW = new AtomicBoolean();

        public zzb(ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue, SparseArray<zza> sparseArray) {
            super("GoogleApiCleanup");
            this.zzanS = referenceQueue;
            this.zzanT = sparseArray;
        }

        public void run() {
            this.zzanW.set(true);
            Process.setThreadPriority(10);
            while (this.zzanW.get()) {
                try {
                    zza zza = (zza) this.zzanS.remove();
                    this.zzanT.remove(zza.zzalC);
                    zza.zzst();
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    this.zzanW.set(false);
                    throw th;
                }
            }
            this.zzanW.set(false);
        }
    }

    private class zzc<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private final zznq<O> zzakV;
        private final Queue<zznp> zzanX = new LinkedList();
        private final Api.zze zzanY;
        private final Api.zzb zzanZ;
        private boolean zzani;
        private final SparseArray<zzpf> zzaoa = new SparseArray<>();
        private final Set<zzns> zzaob = new HashSet();
        private final SparseArray<Map<Object, zznt.zza>> zzaoc = new SparseArray<>();
        private ConnectionResult zzaod = null;

        @WorkerThread
        public zzc(com.google.android.gms.common.api.zzc<O> zzc) {
            this.zzanY = zzb((com.google.android.gms.common.api.zzc) zzc);
            Api.zzb zzb = this.zzanY;
            this.zzanZ = zzb instanceof zzag ? ((zzag) zzb).zztX() : zzb;
            this.zzakV = zzc.zzrn();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void connect() {
            if (!this.zzanY.isConnected() && !this.zzanY.isConnecting()) {
                if (this.zzanY.zzrg() && zzoj.this.zzanM != 0) {
                    zzoj zzoj = zzoj.this;
                    int unused = zzoj.zzanM = zzoj.zzaln.isGooglePlayServicesAvailable(zzoj.this.mContext);
                    if (zzoj.this.zzanM != 0) {
                        onConnectionFailed(new ConnectionResult(zzoj.this.zzanM, (PendingIntent) null));
                        return;
                    }
                }
                Api.zze zze = this.zzanY;
                zze.zza(new zzd(zze, this.zzakV));
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void resume() {
            if (this.zzani) {
                connect();
            }
        }

        @WorkerThread
        private Api.zze zzb(com.google.android.gms.common.api.zzc zzc) {
            Api zzrl = zzc.zzrl();
            if (!zzrl.zzrf()) {
                return zzc.zzrl().zzrc().zza(zzc.getApplicationContext(), zzoj.this.mHandler.getLooper(), zzg.zzau(zzc.getApplicationContext()), zzc.zzrm(), this, this);
            }
            Api.zzh zzrd = zzrl.zzrd();
            return new zzag(zzc.getApplicationContext(), zzoj.this.mHandler.getLooper(), zzrd.zzri(), this, this, zzg.zzau(zzc.getApplicationContext()), zzrd.zzr(zzc.zzrm()));
        }

        @WorkerThread
        private void zzc(zznp zznp) {
            zznp.zza(this.zzaoa);
            if (zznp.zzagd == 3) {
                try {
                    Map map = this.zzaoc.get(zznp.zzalC);
                    if (map == null) {
                        map = new ArrayMap(1);
                        this.zzaoc.put(zznp.zzalC, map);
                    }
                    zznt.zza<? extends Result, Api.zzb> zza = ((zznp.zza) zznp).zzalD;
                    map.put(((zzot) zza).zzsG(), zza);
                } catch (ClassCastException unused) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (zznp.zzagd == 4) {
                try {
                    Map map2 = this.zzaoc.get(zznp.zzalC);
                    zzot zzot = (zzot) ((zznp.zza) zznp).zzalD;
                    if (map2 != null) {
                        map2.remove(zzot.zzsG());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException unused2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                zznp.zzb(this.zzanZ);
            } catch (DeadObjectException unused3) {
                this.zzanY.disconnect();
                onConnectionSuspended(1);
            }
        }

        @WorkerThread
        private void zzj(ConnectionResult connectionResult) {
            for (zzns zza : this.zzaob) {
                zza.zza(this.zzakV, connectionResult);
            }
            this.zzaob.clear();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void zzsh() {
            if (this.zzani) {
                zzsx();
                zzz(zzoj.this.zzaln.isGooglePlayServicesAvailable(zzoj.this.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.zzanY.disconnect();
            }
        }

        @WorkerThread
        private void zzsx() {
            if (this.zzani) {
                zzoj.this.mHandler.removeMessages(9, this.zzakV);
                zzoj.this.mHandler.removeMessages(8, this.zzakV);
                this.zzani = false;
            }
        }

        private void zzsy() {
            zzoj.this.mHandler.removeMessages(10, this.zzakV);
            zzoj.this.mHandler.sendMessageDelayed(zzoj.this.mHandler.obtainMessage(10, this.zzakV), zzoj.this.zzanK);
        }

        /* access modifiers changed from: private */
        public void zzsz() {
            if (this.zzanY.isConnected() && this.zzaoc.size() == 0) {
                for (int i = 0; i < this.zzaoa.size(); i++) {
                    SparseArray<zzpf> sparseArray = this.zzaoa;
                    if (sparseArray.get(sparseArray.keyAt(i)).zzsM()) {
                        zzsy();
                        return;
                    }
                }
                this.zzanY.disconnect();
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void zzz(Status status) {
            for (zznp zzv : this.zzanX) {
                zzv.zzv(status);
            }
            this.zzanX.clear();
        }

        /* access modifiers changed from: package-private */
        public boolean isConnected() {
            return this.zzanY.isConnected();
        }

        @WorkerThread
        public void onConnected(@Nullable Bundle bundle) {
            zzsv();
            zzj(ConnectionResult.zzakj);
            zzsx();
            for (int i = 0; i < this.zzaoc.size(); i++) {
                SparseArray<Map<Object, zznt.zza>> sparseArray = this.zzaoc;
                for (zznt.zza zzb : sparseArray.get(sparseArray.keyAt(i)).values()) {
                    try {
                        zzb.zzb(this.zzanZ);
                    } catch (DeadObjectException unused) {
                        this.zzanY.disconnect();
                        onConnectionSuspended(1);
                    }
                }
            }
            zzsu();
            zzsy();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
            if (r4.zzanV.zzc(r5, r0) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
            if (r5.getErrorCode() != 18) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
            r4.zzani = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
            if (r4.zzani == false) goto L_0x007a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
            com.google.android.gms.internal.zzoj.zza(r4.zzanV).sendMessageDelayed(android.os.Message.obtain(com.google.android.gms.internal.zzoj.zza(r4.zzanV), 8, r4.zzakV), com.google.android.gms.internal.zzoj.zzb(r4.zzanV));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
            r1 = java.lang.String.valueOf(r4.zzakV.zzrz());
            r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r1).length() + 38);
            r2.append("API: ");
            r2.append(r1);
            r2.append(" is not available on this device.");
            zzz(new com.google.android.gms.common.api.Status(17, r2.toString()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        @android.support.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onConnectionFailed(@android.support.annotation.NonNull com.google.android.gms.common.ConnectionResult r5) {
            /*
                r4 = this;
                r4.zzsv()
                com.google.android.gms.internal.zzoj r0 = com.google.android.gms.internal.zzoj.this
                r1 = -1
                int unused = r0.zzanM = r1
                r4.zzj(r5)
                android.util.SparseArray<com.google.android.gms.internal.zzpf> r0 = r4.zzaoa
                r1 = 0
                int r0 = r0.keyAt(r1)
                java.util.Queue<com.google.android.gms.internal.zznp> r1 = r4.zzanX
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x001e
                r4.zzaod = r5
                return
            L_0x001e:
                java.lang.Object r1 = com.google.android.gms.internal.zzoj.zzrs
                monitor-enter(r1)
                com.google.android.gms.internal.zzoj r2 = com.google.android.gms.internal.zzoj.this     // Catch:{ all -> 0x00af }
                com.google.android.gms.internal.zzny r2 = com.google.android.gms.internal.zzoj.zzd(r2)     // Catch:{ all -> 0x00af }
                if (r2 == 0) goto L_0x0044
                com.google.android.gms.internal.zzoj r2 = com.google.android.gms.internal.zzoj.this     // Catch:{ all -> 0x00af }
                java.util.Set r2 = r2.zzanR     // Catch:{ all -> 0x00af }
                com.google.android.gms.internal.zznq<O> r3 = r4.zzakV     // Catch:{ all -> 0x00af }
                boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x00af }
                if (r2 == 0) goto L_0x0044
                com.google.android.gms.internal.zzoj r2 = com.google.android.gms.internal.zzoj.this     // Catch:{ all -> 0x00af }
                com.google.android.gms.internal.zzny r2 = com.google.android.gms.internal.zzoj.zzd(r2)     // Catch:{ all -> 0x00af }
                r2.zzb(r5, r0)     // Catch:{ all -> 0x00af }
                monitor-exit(r1)     // Catch:{ all -> 0x00af }
                return
            L_0x0044:
                monitor-exit(r1)     // Catch:{ all -> 0x00af }
                com.google.android.gms.internal.zzoj r1 = com.google.android.gms.internal.zzoj.this
                boolean r0 = r1.zzc(r5, r0)
                if (r0 != 0) goto L_0x00ae
                int r5 = r5.getErrorCode()
                r0 = 18
                if (r5 != r0) goto L_0x0058
                r5 = 1
                r4.zzani = r5
            L_0x0058:
                boolean r5 = r4.zzani
                if (r5 == 0) goto L_0x007a
                com.google.android.gms.internal.zzoj r5 = com.google.android.gms.internal.zzoj.this
                android.os.Handler r5 = r5.mHandler
                com.google.android.gms.internal.zzoj r0 = com.google.android.gms.internal.zzoj.this
                android.os.Handler r0 = r0.mHandler
                r1 = 8
                com.google.android.gms.internal.zznq<O> r2 = r4.zzakV
                android.os.Message r0 = android.os.Message.obtain(r0, r1, r2)
                com.google.android.gms.internal.zzoj r1 = com.google.android.gms.internal.zzoj.this
                long r1 = r1.zzank
                r5.sendMessageDelayed(r0, r1)
                goto L_0x00ae
            L_0x007a:
                com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status
                r0 = 17
                com.google.android.gms.internal.zznq<O> r1 = r4.zzakV
                java.lang.String r1 = r1.zzrz()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = java.lang.String.valueOf(r1)
                int r3 = r3.length()
                int r3 = r3 + 38
                r2.<init>(r3)
                java.lang.String r3 = "API: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = " is not available on this device."
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r5.<init>(r0, r1)
                r4.zzz(r5)
            L_0x00ae:
                return
            L_0x00af:
                r5 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00af }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoj.zzc.onConnectionFailed(com.google.android.gms.common.ConnectionResult):void");
        }

        @WorkerThread
        public void onConnectionSuspended(int i) {
            zzsv();
            this.zzani = true;
            zzoj.this.mHandler.sendMessageDelayed(Message.obtain(zzoj.this.mHandler, 8, this.zzakV), zzoj.this.zzank);
            zzoj.this.mHandler.sendMessageDelayed(Message.obtain(zzoj.this.mHandler, 9, this.zzakV), zzoj.this.zzanj);
            int unused = zzoj.this.zzanM = -1;
        }

        @WorkerThread
        public void zzb(zznp zznp) {
            if (this.zzanY.isConnected()) {
                zzc(zznp);
                zzsy();
                return;
            }
            this.zzanX.add(zznp);
            ConnectionResult connectionResult = this.zzaod;
            if (connectionResult == null || !connectionResult.hasResolution()) {
                connect();
            } else {
                onConnectionFailed(this.zzaod);
            }
        }

        @WorkerThread
        public void zzb(zzns zzns) {
            this.zzaob.add(zzns);
        }

        @WorkerThread
        public void zzbL(int i) {
            this.zzaoa.put(i, new zzpf(this.zzakV.zzre(), this.zzanY));
        }

        @WorkerThread
        public void zzf(int i, boolean z) {
            Iterator it = this.zzanX.iterator();
            while (it.hasNext()) {
                zznp zznp = (zznp) it.next();
                if (zznp.zzalC == i && zznp.zzagd != 1 && zznp.cancel()) {
                    it.remove();
                }
            }
            this.zzaoa.get(i).release();
            this.zzaoc.delete(i);
            if (!z) {
                this.zzaoa.remove(i);
                zzoj.this.zzanT.remove(i);
                if (this.zzaoa.size() == 0 && this.zzanX.isEmpty()) {
                    zzsx();
                    this.zzanY.disconnect();
                    zzoj.this.zzanP.remove(this.zzakV);
                    synchronized (zzoj.zzrs) {
                        zzoj.this.zzanR.remove(this.zzakV);
                    }
                }
            }
        }

        @WorkerThread
        public void zzsu() {
            while (this.zzanY.isConnected() && !this.zzanX.isEmpty()) {
                zzc(this.zzanX.remove());
            }
        }

        @WorkerThread
        public void zzsv() {
            this.zzaod = null;
        }

        /* access modifiers changed from: package-private */
        public ConnectionResult zzsw() {
            return this.zzaod;
        }
    }

    private class zzd implements zzd.zzf {
        private final zznq<?> zzakV;
        private final Api.zze zzanY;

        public zzd(Api.zze zze, zznq<?> zznq) {
            this.zzanY = zze;
            this.zzakV = zznq;
        }

        @WorkerThread
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.zzanY.zza((zzq) null, Collections.emptySet());
            } else {
                ((zzc) zzoj.this.zzanP.get(this.zzakV)).onConnectionFailed(connectionResult);
            }
        }
    }

    private zzoj(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    zzoj(Context context, GoogleApiAvailability googleApiAvailability) {
        this.zzank = 5000;
        this.zzanj = 120000;
        this.zzanK = 10000;
        this.zzanM = -1;
        this.zzanN = new AtomicInteger(1);
        this.zzanO = new SparseArray<>();
        this.zzanP = new ConcurrentHashMap(5, 0.75f, 1);
        this.zzanQ = null;
        this.zzanR = new com.google.android.gms.common.util.zza();
        this.zzanS = new ReferenceQueue<>();
        this.zzanT = new SparseArray<>();
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        this.zzaln = googleApiAvailability;
    }

    private int zza(com.google.android.gms.common.api.zzc<?> zzc2) {
        int andIncrement = this.zzanN.getAndIncrement();
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, andIncrement, 0, zzc2));
        return andIncrement;
    }

    public static Pair<zzoj, Integer> zza(Context context, com.google.android.gms.common.api.zzc<?> zzc2) {
        Pair<zzoj, Integer> create;
        synchronized (zzrs) {
            if (zzanL == null) {
                zzanL = new zzoj(context.getApplicationContext());
            }
            create = Pair.create(zzanL, Integer.valueOf(zzanL.zza(zzc2)));
        }
        return create;
    }

    @WorkerThread
    private void zza(com.google.android.gms.common.api.zzc<?> zzc2, int i) {
        zznq<?> zzrn = zzc2.zzrn();
        if (!this.zzanP.containsKey(zzrn)) {
            this.zzanP.put(zzrn, new zzc(zzc2));
        }
        zzc zzc3 = this.zzanP.get(zzrn);
        zzc3.zzbL(i);
        this.zzanO.put(i, zzc3);
        zzc3.connect();
        this.zzanT.put(i, new zza(zzc2, i, this.zzanS));
        zzb zzb2 = this.zzanU;
        if (zzb2 == null || !zzb2.zzanW.get()) {
            this.zzanU = new zzb(this.zzanS, this.zzanT);
            this.zzanU.start();
        }
    }

    @WorkerThread
    private void zza(zznp zznp) {
        this.zzanO.get(zznp.zzalC).zzb(zznp);
    }

    static /* synthetic */ zzny zzd(zzoj zzoj) {
        return null;
    }

    @WorkerThread
    private void zze(int i, boolean z) {
        zzc zzc2 = this.zzanO.get(i);
        if (zzc2 != null) {
            if (!z) {
                this.zzanO.delete(i);
            }
            zzc2.zzf(i, z);
            return;
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("onRelease received for unknown instance: ");
        sb.append(i);
        Log.wtf("GoogleApiManager", sb.toString(), new Exception());
    }

    public static zzoj zzsq() {
        zzoj zzoj;
        synchronized (zzrs) {
            zzoj = zzanL;
        }
        return zzoj;
    }

    @WorkerThread
    private void zzsr() {
        for (zzc next : this.zzanP.values()) {
            next.zzsv();
            next.connect();
        }
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                zza((zzns) message.obj);
                break;
            case 2:
            case 7:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                zze(i, z);
                break;
            case 3:
                zzsr();
                break;
            case 4:
                zza((zznp) message.obj);
                break;
            case 5:
                if (this.zzanO.get(message.arg1) != null) {
                    this.zzanO.get(message.arg1).zzz(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                zza((com.google.android.gms.common.api.zzc<?>) (com.google.android.gms.common.api.zzc) message.obj, message.arg1);
                break;
            case 8:
                if (this.zzanP.containsKey(message.obj)) {
                    this.zzanP.get(message.obj).resume();
                    break;
                }
                break;
            case 9:
                if (this.zzanP.containsKey(message.obj)) {
                    this.zzanP.get(message.obj).zzsh();
                    break;
                }
                break;
            case 10:
                if (this.zzanP.containsKey(message.obj)) {
                    this.zzanP.get(message.obj).zzsz();
                    break;
                }
                break;
            default:
                int i2 = message.what;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Unknown message id: ");
                sb.append(i2);
                Log.w("GoogleApiManager", sb.toString());
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(5, i, 0));
        }
    }

    public <O extends Api.ApiOptions> void zza(com.google.android.gms.common.api.zzc<O> zzc2, int i, zznt.zza<? extends Result, Api.zzb> zza2) {
        zznp.zza zza3 = new zznp.zza(zzc2.getInstanceId(), i, zza2);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, zza3));
    }

    public <O extends Api.ApiOptions, TResult> void zza(com.google.android.gms.common.api.zzc<O> zzc2, int i, zzpd<Api.zzb, TResult> zzpd, TaskCompletionSource<TResult> taskCompletionSource) {
        zznp.zzb zzb2 = new zznp.zzb(zzc2.getInstanceId(), i, zzpd, taskCompletionSource);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, zzb2));
    }

    @WorkerThread
    public void zza(zzns zzns) {
        ConnectionResult zzsw;
        for (zznq next : zzns.zzrC()) {
            zzc zzc2 = this.zzanP.get(next);
            if (zzc2 == null) {
                zzns.cancel();
                return;
            }
            if (zzc2.isConnected()) {
                zzsw = ConnectionResult.zzakj;
            } else if (zzc2.zzsw() != null) {
                zzsw = zzc2.zzsw();
            } else {
                zzc2.zzb(zzns);
            }
            zzns.zza(next, zzsw);
        }
    }

    public void zza(zzny zzny) {
        synchronized (zzrs) {
            if (zzny == null) {
                this.zzanQ = null;
                this.zzanR.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(ConnectionResult connectionResult, int i) {
        if (!connectionResult.hasResolution() && !this.zzaln.isUserResolvableError(connectionResult.getErrorCode())) {
            return false;
        }
        this.zzaln.zza(this.mContext, connectionResult, i);
        return true;
    }

    public void zzd(int i, boolean z) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, i, z ? 1 : 2));
    }

    public void zzrA() {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3));
    }
}
