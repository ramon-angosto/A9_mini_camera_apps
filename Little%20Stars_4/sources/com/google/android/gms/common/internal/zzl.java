package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzl implements Handler.Callback {
    private final Handler mHandler;
    private final zza zzarI;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzarJ = new ArrayList<>();
    final ArrayList<GoogleApiClient.ConnectionCallbacks> zzarK = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzarL = new ArrayList<>();
    private volatile boolean zzarM = false;
    private final AtomicInteger zzarN = new AtomicInteger(0);
    private boolean zzarO = false;
    private final Object zzpp = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzqr();
    }

    public zzl(Looper looper, zza zza2) {
        this.zzarI = zza2;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.zzpp) {
                if (this.zzarM && this.zzarI.isConnected() && this.zzarJ.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzarI.zzqr());
                }
            }
            return true;
        }
        int i = message.what;
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzaa.zzz(connectionCallbacks);
        synchronized (this.zzpp) {
            contains = this.zzarJ.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzaa.zzz(onConnectionFailedListener);
        synchronized (this.zzpp) {
            contains = this.zzarL.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzaa.zzz(connectionCallbacks);
        synchronized (this.zzpp) {
            if (this.zzarJ.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.zzarJ.add(connectionCallbacks);
            }
        }
        if (this.zzarI.isConnected()) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzaa.zzz(onConnectionFailedListener);
        synchronized (this.zzpp) {
            if (this.zzarL.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.zzarL.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzaa.zzz(connectionCallbacks);
        synchronized (this.zzpp) {
            if (!this.zzarJ.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 52);
                sb.append("unregisterConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            } else if (this.zzarO) {
                this.zzarK.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzaa.zzz(onConnectionFailedListener);
        synchronized (this.zzpp) {
            if (!this.zzarL.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    public void zzcc(int i) {
        zzaa.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpp) {
            this.zzarO = true;
            ArrayList arrayList = new ArrayList(this.zzarJ);
            int i2 = this.zzarN.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzarM) {
                    break;
                } else if (this.zzarN.get() != i2) {
                    break;
                } else if (this.zzarJ.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzarK.clear();
            this.zzarO = false;
        }
    }

    public void zzm(Bundle bundle) {
        boolean z = true;
        zzaa.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzpp) {
            zzaa.zzai(!this.zzarO);
            this.mHandler.removeMessages(1);
            this.zzarO = true;
            if (this.zzarK.size() != 0) {
                z = false;
            }
            zzaa.zzai(z);
            ArrayList arrayList = new ArrayList(this.zzarJ);
            int i = this.zzarN.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzarM || !this.zzarI.isConnected()) {
                    break;
                } else if (this.zzarN.get() != i) {
                    break;
                } else if (!this.zzarK.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzarK.clear();
            this.zzarO = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzm(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r1 = r5.mHandler
            android.os.Looper r1 = r1.getLooper()
            r2 = 1
            if (r0 != r1) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.zzaa.zza((boolean) r0, (java.lang.Object) r1)
            android.os.Handler r0 = r5.mHandler
            r0.removeMessages(r2)
            java.lang.Object r0 = r5.zzpp
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0057 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r5.zzarL     // Catch:{ all -> 0x0057 }
            r1.<init>(r2)     // Catch:{ all -> 0x0057 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.zzarN     // Catch:{ all -> 0x0057 }
            int r2 = r2.get()     // Catch:{ all -> 0x0057 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0057 }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0055
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r3 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r3     // Catch:{ all -> 0x0057 }
            boolean r4 = r5.zzarM     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicInteger r4 = r5.zzarN     // Catch:{ all -> 0x0057 }
            int r4 = r4.get()     // Catch:{ all -> 0x0057 }
            if (r4 == r2) goto L_0x0047
            goto L_0x0053
        L_0x0047:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r4 = r5.zzarL     // Catch:{ all -> 0x0057 }
            boolean r4 = r4.contains(r3)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x002e
            r3.onConnectionFailed(r6)     // Catch:{ all -> 0x0057 }
            goto L_0x002e
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return
        L_0x0057:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            goto L_0x005b
        L_0x005a:
            throw r6
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzl.zzm(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zztI() {
        this.zzarM = false;
        this.zzarN.incrementAndGet();
    }

    public void zztJ() {
        this.zzarM = true;
    }
}
