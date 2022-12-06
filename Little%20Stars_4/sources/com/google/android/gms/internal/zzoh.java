package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzoo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzoh implements zzoo {
    private final Context mContext;
    final Api.zza<? extends zztv, zztw> zzalo;
    private final zzc zzamE;
    final zzg zzamS;
    final Map<Api<?>, Integer> zzamT;
    final zzof zzamm;
    /* access modifiers changed from: private */
    public final Lock zzamw;
    private final Condition zzanA;
    private final zzb zzanB;
    final Map<Api.zzc<?>, ConnectionResult> zzanC = new HashMap();
    /* access modifiers changed from: private */
    public volatile zzog zzanD;
    private ConnectionResult zzanE = null;
    int zzanF;
    final zzoo.zza zzanG;
    final Map<Api.zzc<?>, Api.zze> zzann;

    static abstract class zza {
        private final zzog zzanH;

        protected zza(zzog zzog) {
            this.zzanH = zzog;
        }

        public final void zzd(zzoh zzoh) {
            zzoh.zzamw.lock();
            try {
                if (zzoh.zzanD == this.zzanH) {
                    zzrX();
                    zzoh.zzamw.unlock();
                }
            } finally {
                zzoh.zzamw.unlock();
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzrX();
    }

    final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((zza) message.obj).zzd(zzoh.this);
            } else if (i != 2) {
                int i2 = message.what;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Unknown message id: ");
                sb.append(i2);
                Log.w("GACStateManager", sb.toString());
            } else {
                throw ((RuntimeException) message.obj);
            }
        }
    }

    public zzoh(Context context, zzof zzof, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zze> map, zzg zzg, Map<Api<?>, Integer> map2, Api.zza<? extends zztv, zztw> zza2, ArrayList<zznw> arrayList, zzoo.zza zza3) {
        this.mContext = context;
        this.zzamw = lock;
        this.zzamE = zzc;
        this.zzann = map;
        this.zzamS = zzg;
        this.zzamT = map2;
        this.zzalo = zza2;
        this.zzamm = zzof;
        this.zzanG = zza3;
        Iterator<zznw> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.zzanB = new zzb(looper);
        this.zzanA = lock.newCondition();
        this.zzanD = new zzoe(this);
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzanA.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.zzakj;
        }
        ConnectionResult connectionResult = this.zzanE;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zzanA.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            return ConnectionResult.zzakj;
        }
        ConnectionResult connectionResult = this.zzanE;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    public void connect() {
        this.zzanD.connect();
    }

    public void disconnect() {
        if (this.zzanD.disconnect()) {
            this.zzanC.clear();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        for (Api next : this.zzamT.keySet()) {
            printWriter.append(str).append(next.getName()).println(":");
            this.zzann.get(next.zzre()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.zzc<?> zzre = api.zzre();
        if (!this.zzann.containsKey(zzre)) {
            return null;
        }
        if (this.zzann.get(zzre).isConnected()) {
            return ConnectionResult.zzakj;
        }
        if (this.zzanC.containsKey(zzre)) {
            return this.zzanC.get(zzre);
        }
        return null;
    }

    public boolean isConnected() {
        return this.zzanD instanceof zzoc;
    }

    public boolean isConnecting() {
        return this.zzanD instanceof zzod;
    }

    public void onConnected(@Nullable Bundle bundle) {
        this.zzamw.lock();
        try {
            this.zzanD.onConnected(bundle);
        } finally {
            this.zzamw.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.zzamw.lock();
        try {
            this.zzanD.onConnectionSuspended(i);
        } finally {
            this.zzamw.unlock();
        }
    }

    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        this.zzamw.lock();
        try {
            this.zzanD.zza(connectionResult, api, i);
        } finally {
            this.zzamw.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        this.zzanB.sendMessage(this.zzanB.obtainMessage(1, zza2));
    }

    /* access modifiers changed from: package-private */
    public void zza(RuntimeException runtimeException) {
        this.zzanB.sendMessage(this.zzanB.obtainMessage(2, runtimeException));
    }

    public boolean zza(zzpa zzpa) {
        return false;
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(@NonNull T t) {
        t.zzrI();
        return this.zzanD.zzc(t);
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(@NonNull T t) {
        t.zzrI();
        return this.zzanD.zzd(t);
    }

    /* access modifiers changed from: package-private */
    public void zzi(ConnectionResult connectionResult) {
        this.zzamw.lock();
        try {
            this.zzanE = connectionResult;
            this.zzanD = new zzoe(this);
            this.zzanD.begin();
            this.zzanA.signalAll();
        } finally {
            this.zzamw.unlock();
        }
    }

    public void zzrN() {
        if (isConnected()) {
            ((zzoc) this.zzanD).zzrW();
        }
    }

    public void zzrr() {
    }

    /* access modifiers changed from: package-private */
    public void zzsm() {
        this.zzamw.lock();
        try {
            this.zzanD = new zzod(this, this.zzamS, this.zzamT, this.zzamE, this.zzalo, this.zzamw, this.mContext);
            this.zzanD.begin();
            this.zzanA.signalAll();
        } finally {
            this.zzamw.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzsn() {
        this.zzamw.lock();
        try {
            this.zzamm.zzsj();
            this.zzanD = new zzoc(this);
            this.zzanD.begin();
            this.zzanA.signalAll();
        } finally {
            this.zzamw.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzso() {
        for (Api.zze disconnect : this.zzann.values()) {
            disconnect.disconnect();
        }
    }
}
