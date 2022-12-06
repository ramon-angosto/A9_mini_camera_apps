package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzoo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zznx implements zzoo {
    private final Context mContext;
    private final Looper zzakW;
    private final zzof zzamm;
    /* access modifiers changed from: private */
    public final zzoh zzamn;
    /* access modifiers changed from: private */
    public final zzoh zzamo;
    private final Map<Api.zzc<?>, zzoh> zzamp;
    private final Set<zzpa> zzamq = Collections.newSetFromMap(new WeakHashMap());
    private final Api.zze zzamr;
    private Bundle zzams;
    /* access modifiers changed from: private */
    public ConnectionResult zzamt = null;
    /* access modifiers changed from: private */
    public ConnectionResult zzamu = null;
    /* access modifiers changed from: private */
    public boolean zzamv = false;
    /* access modifiers changed from: private */
    public final Lock zzamw;
    private int zzamx = 0;

    private class zza implements zzoo.zza {
        private zza() {
        }

        public void zzc(int i, boolean z) {
            zznx.this.zzamw.lock();
            try {
                if (!zznx.this.zzamv && zznx.this.zzamu != null) {
                    if (zznx.this.zzamu.isSuccess()) {
                        boolean unused = zznx.this.zzamv = true;
                        zznx.this.zzamo.onConnectionSuspended(i);
                        zznx.this.zzamw.unlock();
                        return;
                    }
                }
                boolean unused2 = zznx.this.zzamv = false;
                zznx.this.zzb(i, z);
            } finally {
                zznx.this.zzamw.unlock();
            }
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            zznx.this.zzamw.lock();
            try {
                ConnectionResult unused = zznx.this.zzamt = connectionResult;
                zznx.this.zzrQ();
            } finally {
                zznx.this.zzamw.unlock();
            }
        }

        public void zzk(@Nullable Bundle bundle) {
            zznx.this.zzamw.lock();
            try {
                zznx.this.zzj(bundle);
                ConnectionResult unused = zznx.this.zzamt = ConnectionResult.zzakj;
                zznx.this.zzrQ();
            } finally {
                zznx.this.zzamw.unlock();
            }
        }
    }

    private class zzb implements zzoo.zza {
        private zzb() {
        }

        public void zzc(int i, boolean z) {
            zznx.this.zzamw.lock();
            try {
                if (zznx.this.zzamv) {
                    boolean unused = zznx.this.zzamv = false;
                    zznx.this.zzb(i, z);
                    return;
                }
                boolean unused2 = zznx.this.zzamv = true;
                zznx.this.zzamn.onConnectionSuspended(i);
                zznx.this.zzamw.unlock();
            } finally {
                zznx.this.zzamw.unlock();
            }
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            zznx.this.zzamw.lock();
            try {
                ConnectionResult unused = zznx.this.zzamu = connectionResult;
                zznx.this.zzrQ();
            } finally {
                zznx.this.zzamw.unlock();
            }
        }

        public void zzk(@Nullable Bundle bundle) {
            zznx.this.zzamw.lock();
            try {
                ConnectionResult unused = zznx.this.zzamu = ConnectionResult.zzakj;
                zznx.this.zzrQ();
            } finally {
                zznx.this.zzamw.unlock();
            }
        }
    }

    private zznx(Context context, zzof zzof, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zze> map, Map<Api.zzc<?>, Api.zze> map2, zzg zzg, Api.zza<? extends zztv, zztw> zza2, Api.zze zze, ArrayList<zznw> arrayList, ArrayList<zznw> arrayList2, Map<Api<?>, Integer> map3, Map<Api<?>, Integer> map4) {
        this.mContext = context;
        this.zzamm = zzof;
        this.zzamw = lock;
        this.zzakW = looper;
        this.zzamr = zze;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        zzc zzc2 = zzc;
        zzoh zzoh = r3;
        zzoh zzoh2 = new zzoh(context2, this.zzamm, lock2, looper2, zzc2, map2, (zzg) null, map4, (Api.zza<? extends zztv, zztw>) null, arrayList2, new zza());
        this.zzamn = zzoh;
        this.zzamo = new zzoh(context2, this.zzamm, lock2, looper2, zzc2, map, zzg, map3, zza2, arrayList, new zzb());
        ArrayMap arrayMap = new ArrayMap();
        for (Api.zzc<?> put : map2.keySet()) {
            arrayMap.put(put, this.zzamn);
        }
        for (Api.zzc<?> put2 : map.keySet()) {
            arrayMap.put(put2, this.zzamo);
        }
        this.zzamp = Collections.unmodifiableMap(arrayMap);
    }

    public static zznx zza(Context context, zzof zzof, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zze> map, zzg zzg, Map<Api<?>, Integer> map2, Api.zza<? extends zztv, zztw> zza2, ArrayList<zznw> arrayList) {
        Map<Api<?>, Integer> map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.zze zze = null;
        for (Map.Entry next : map.entrySet()) {
            Api.zze zze2 = (Api.zze) next.getValue();
            if (zze2.zzps()) {
                zze = zze2;
            }
            if (zze2.zzpd()) {
                arrayMap.put((Api.zzc) next.getKey(), zze2);
            } else {
                arrayMap2.put((Api.zzc) next.getKey(), zze2);
            }
        }
        zzaa.zza(!arrayMap.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.zzc<?> zzre = next2.zzre();
            if (arrayMap.containsKey(zzre)) {
                arrayMap3.put(next2, map3.get(next2));
            } else if (arrayMap2.containsKey(zzre)) {
                arrayMap4.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<zznw> it = arrayList.iterator();
        while (it.hasNext()) {
            zznw next3 = it.next();
            if (arrayMap3.containsKey(next3.zzakT)) {
                arrayList2.add(next3);
            } else if (arrayMap4.containsKey(next3.zzakT)) {
                arrayList3.add(next3);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new zznx(context, zzof, lock, looper, zzc, arrayMap, arrayMap2, zzg, zza2, zze, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.zzamm.zzc(i, z);
        this.zzamu = null;
        this.zzamt = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        int i = this.zzamx;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zzamx = 0;
            }
            this.zzamm.zzd(connectionResult);
        }
        zzrS();
        this.zzamx = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zze(zznt.zza<? extends Result, ? extends Api.zzb> zza2) {
        Api.zzc<? extends Api.zzb> zzre = zza2.zzre();
        zzaa.zzb(this.zzamp.containsKey(zzre), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzamp.get(zzre).equals(this.zzamo);
    }

    /* access modifiers changed from: private */
    public void zzj(Bundle bundle) {
        Bundle bundle2 = this.zzams;
        if (bundle2 == null) {
            this.zzams = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private void zzrP() {
        this.zzamu = null;
        this.zzamt = null;
        this.zzamn.connect();
        this.zzamo.connect();
    }

    /* access modifiers changed from: private */
    public void zzrQ() {
        ConnectionResult connectionResult;
        if (!zzc(this.zzamt)) {
            if (this.zzamt == null || !zzc(this.zzamu)) {
                connectionResult = this.zzamt;
                if (connectionResult != null && this.zzamu != null) {
                    if (this.zzamo.zzanF < this.zzamn.zzanF) {
                        connectionResult = this.zzamu;
                    }
                } else {
                    return;
                }
            } else {
                this.zzamo.disconnect();
                connectionResult = this.zzamt;
            }
            zzb(connectionResult);
        } else if (zzc(this.zzamu) || zzrT()) {
            zzrR();
        } else {
            ConnectionResult connectionResult2 = this.zzamu;
            if (connectionResult2 == null) {
                return;
            }
            if (this.zzamx == 1) {
                zzrS();
                return;
            }
            zzb(connectionResult2);
            this.zzamn.disconnect();
        }
    }

    private void zzrR() {
        int i = this.zzamx;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                this.zzamx = 0;
            }
            this.zzamm.zzk(this.zzams);
        }
        zzrS();
        this.zzamx = 0;
    }

    private void zzrS() {
        for (zzpa zzpr : this.zzamq) {
            zzpr.zzpr();
        }
        this.zzamq.clear();
    }

    private boolean zzrT() {
        ConnectionResult connectionResult = this.zzamu;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzrU() {
        if (this.zzamr == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.zzamm.getSessionId(), this.zzamr.zzpt(), 134217728);
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.zzamx = 2;
        this.zzamv = false;
        zzrP();
    }

    public void disconnect() {
        this.zzamu = null;
        this.zzamt = null;
        this.zzamx = 0;
        this.zzamn.disconnect();
        this.zzamo.disconnect();
        zzrS();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.zzamo.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.zzamn.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return this.zzamp.get(api.zzre()).equals(this.zzamo) ? zzrT() ? new ConnectionResult(4, zzrU()) : this.zzamo.getConnectionResult(api) : this.zzamn.getConnectionResult(api);
    }

    public boolean isConnected() {
        this.zzamw.lock();
        try {
            boolean z = true;
            if (!this.zzamn.isConnected() || (!zzrO() && !zzrT() && this.zzamx != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzamw.unlock();
        }
    }

    public boolean isConnecting() {
        this.zzamw.lock();
        try {
            return this.zzamx == 2;
        } finally {
            this.zzamw.unlock();
        }
    }

    public boolean zza(zzpa zzpa) {
        this.zzamw.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzrO()) {
                this.zzamq.add(zzpa);
                if (this.zzamx == 0) {
                    this.zzamx = 1;
                }
                this.zzamu = null;
                this.zzamo.connect();
                return true;
            }
            this.zzamw.unlock();
            return false;
        } finally {
            this.zzamw.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(@NonNull T t) {
        if (!zze((zznt.zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.zzamn.zzc(t);
        }
        if (!zzrT()) {
            return this.zzamo.zzc(t);
        }
        t.zzx(new Status(4, (String) null, zzrU()));
        return t;
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(@NonNull T t) {
        if (!zze((zznt.zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.zzamn.zzd(t);
        }
        if (!zzrT()) {
            return this.zzamo.zzd(t);
        }
        t.zzx(new Status(4, (String) null, zzrU()));
        return t;
    }

    public void zzrN() {
        this.zzamn.zzrN();
        this.zzamo.zzrN();
    }

    public boolean zzrO() {
        return this.zzamo.isConnected();
    }

    public void zzrr() {
        this.zzamw.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzamo.disconnect();
            this.zzamu = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzakW).post(new Runnable() {
                    public void run() {
                        zznx.this.zzamw.lock();
                        try {
                            zznx.this.zzrQ();
                        } finally {
                            zznx.this.zzamw.unlock();
                        }
                    }
                });
            } else {
                zzrS();
            }
        } finally {
            this.zzamw.unlock();
        }
    }
}
