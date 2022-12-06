package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzod implements zzog {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Api.zza<? extends zztv, zztw> zzalo;
    /* access modifiers changed from: private */
    public final zzoh zzamB;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.zzc zzamE;
    private ConnectionResult zzamF;
    private int zzamG;
    private int zzamH = 0;
    private int zzamI;
    private final Bundle zzamJ = new Bundle();
    private final Set<Api.zzc> zzamK = new HashSet();
    /* access modifiers changed from: private */
    public zztv zzamL;
    private int zzamM;
    /* access modifiers changed from: private */
    public boolean zzamN;
    private boolean zzamO;
    /* access modifiers changed from: private */
    public zzq zzamP;
    private boolean zzamQ;
    private boolean zzamR;
    private final zzg zzamS;
    private final Map<Api<?>, Integer> zzamT;
    private ArrayList<Future<?>> zzamU = new ArrayList<>();
    /* access modifiers changed from: private */
    public final Lock zzamw;

    private static class zza implements zzd.zzf {
        private final Api<?> zzakT;
        private final WeakReference<zzod> zzamW;
        /* access modifiers changed from: private */
        public final int zzamk;

        public zza(zzod zzod, Api<?> api, int i) {
            this.zzamW = new WeakReference<>(zzod);
            this.zzakT = api;
            this.zzamk = i;
        }

        public void zzh(@NonNull ConnectionResult connectionResult) {
            zzod zzod = (zzod) this.zzamW.get();
            if (zzod != null) {
                zzaa.zza(Looper.myLooper() == zzod.zzamB.zzamm.getLooper(), (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zzod.zzamw.lock();
                try {
                    if (zzod.zzbH(0)) {
                        if (!connectionResult.isSuccess()) {
                            zzod.zzb(connectionResult, this.zzakT, this.zzamk);
                        }
                        if (zzod.zzrY()) {
                            zzod.zzrZ();
                        }
                        zzod.zzamw.unlock();
                    }
                } finally {
                    zzod.zzamw.unlock();
                }
            }
        }
    }

    private class zzb extends zzf {
        private final Map<Api.zze, zza> zzamX;

        public zzb(Map<Api.zze, zza> map) {
            super();
            this.zzamX = map;
        }

        @WorkerThread
        public void zzrX() {
            boolean z;
            Iterator<Api.zze> it = this.zzamX.keySet().iterator();
            boolean z2 = true;
            int i = 0;
            boolean z3 = false;
            boolean z4 = true;
            while (true) {
                if (!it.hasNext()) {
                    z2 = z3;
                    z = false;
                    break;
                }
                Api.zze next = it.next();
                if (!next.zzrg()) {
                    z4 = false;
                } else if (this.zzamX.get(next).zzamk == 0) {
                    z = true;
                    break;
                } else {
                    z3 = true;
                }
            }
            if (z2) {
                i = zzod.this.zzamE.isGooglePlayServicesAvailable(zzod.this.mContext);
            }
            if (i == 0 || (!z && !z4)) {
                if (zzod.this.zzamN) {
                    zzod.this.zzamL.connect();
                }
                for (Api.zze next2 : this.zzamX.keySet()) {
                    final zzd.zzf zzf = this.zzamX.get(next2);
                    if (!next2.zzrg() || i == 0) {
                        next2.zza(zzf);
                    } else {
                        zzod.this.zzamB.zza((zzoh.zza) new zzoh.zza(zzod.this) {
                            public void zzrX() {
                                zzf.zzh(new ConnectionResult(16, (PendingIntent) null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) null);
            zzod.this.zzamB.zza((zzoh.zza) new zzoh.zza(zzod.this) {
                public void zzrX() {
                    zzod.this.zzg(connectionResult);
                }
            });
        }
    }

    private class zzc extends zzf {
        private final ArrayList<Api.zze> zzanb;

        public zzc(ArrayList<Api.zze> arrayList) {
            super();
            this.zzanb = arrayList;
        }

        @WorkerThread
        public void zzrX() {
            zzod.this.zzamB.zzamm.zzano = zzod.this.zzse();
            Iterator<Api.zze> it = this.zzanb.iterator();
            while (it.hasNext()) {
                it.next().zza(zzod.this.zzamP, zzod.this.zzamB.zzamm.zzano);
            }
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzod> zzamW;

        zzd(zzod zzod) {
            this.zzamW = new WeakReference<>(zzod);
        }

        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzod zzod = (zzod) this.zzamW.get();
            if (zzod != null) {
                zzod.zzamB.zza((zzoh.zza) new zzoh.zza(zzod) {
                    public void zzrX() {
                        zzod.zza(signInResponse);
                    }
                });
            }
        }
    }

    private class zze implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zze() {
        }

        public void onConnected(Bundle bundle) {
            zzod.this.zzamL.zza(new zzd(zzod.this));
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzod.this.zzamw.lock();
            try {
                if (zzod.this.zzf(connectionResult)) {
                    zzod.this.zzsc();
                    zzod.this.zzrZ();
                } else {
                    zzod.this.zzg(connectionResult);
                }
            } finally {
                zzod.this.zzamw.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    private abstract class zzf implements Runnable {
        private zzf() {
        }

        @WorkerThread
        public void run() {
            zzod.this.zzamw.lock();
            try {
                if (Thread.interrupted()) {
                    zzod.this.zzamw.unlock();
                    return;
                }
                zzrX();
                zzod.this.zzamw.unlock();
            } catch (RuntimeException e) {
                zzod.this.zzamB.zza(e);
            } catch (Throwable th) {
                zzod.this.zzamw.unlock();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        @WorkerThread
        public abstract void zzrX();
    }

    public zzod(zzoh zzoh, zzg zzg, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc zzc2, Api.zza<? extends zztv, zztw> zza2, Lock lock, Context context) {
        this.zzamB = zzoh;
        this.zzamS = zzg;
        this.zzamT = map;
        this.zzamE = zzc2;
        this.zzalo = zza2;
        this.zzamw = lock;
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public void zza(SignInResponse signInResponse) {
        if (zzbH(0)) {
            ConnectionResult zztR = signInResponse.zztR();
            if (zztR.isSuccess()) {
                ResolveAccountResponse zzIY = signInResponse.zzIY();
                ConnectionResult zztR2 = zzIY.zztR();
                if (!zztR2.isSuccess()) {
                    String valueOf = String.valueOf(zztR2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    zzg(zztR2);
                    return;
                }
                this.zzamO = true;
                this.zzamP = zzIY.zztQ();
                this.zzamQ = zzIY.zztS();
                this.zzamR = zzIY.zztT();
            } else if (zzf(zztR)) {
                zzsc();
            } else {
                zzg(zztR);
                return;
            }
            zzrZ();
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zze(connectionResult)) {
            return this.zzamF == null || i < this.zzamG;
        }
        return false;
    }

    private void zzah(boolean z) {
        zztv zztv = this.zzamL;
        if (zztv != null) {
            if (zztv.isConnected() && z) {
                this.zzamL.zzIP();
            }
            this.zzamL.disconnect();
            this.zzamP = null;
        }
    }

    /* access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzrb().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.zzamF = connectionResult;
                this.zzamG = priority;
            }
        }
        this.zzamB.zzanC.put(api.zzre(), connectionResult);
    }

    /* access modifiers changed from: private */
    public boolean zzbH(int i) {
        if (this.zzamH == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.zzamB.zzamm.zzsl());
        String valueOf = String.valueOf(zzbI(this.zzamH));
        String valueOf2 = String.valueOf(zzbI(i));
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(valueOf2).length());
        sb.append("GoogleApiClient connecting is in step ");
        sb.append(valueOf);
        sb.append(" but received callback for step ");
        sb.append(valueOf2);
        Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
        zzg(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    private String zzbI(int i) {
        return i != 0 ? i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.zzamE.zzbB(connectionResult.getErrorCode()) != null;
    }

    /* access modifiers changed from: private */
    public boolean zzf(ConnectionResult connectionResult) {
        int i = this.zzamM;
        if (i != 2) {
            return i == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void zzg(ConnectionResult connectionResult) {
        zzsd();
        zzah(!connectionResult.hasResolution());
        this.zzamB.zzi(connectionResult);
        this.zzamB.zzanG.zzd(connectionResult);
    }

    /* access modifiers changed from: private */
    public boolean zzrY() {
        ConnectionResult connectionResult;
        this.zzamI--;
        int i = this.zzamI;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.i("GoogleApiClientConnecting", this.zzamB.zzamm.zzsl());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, (PendingIntent) null);
        } else {
            connectionResult = this.zzamF;
            if (connectionResult == null) {
                return true;
            }
            this.zzamB.zzanF = this.zzamG;
        }
        zzg(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    public void zzrZ() {
        if (this.zzamI == 0) {
            if (!this.zzamN || this.zzamO) {
                zzsa();
            }
        }
    }

    private void zzsa() {
        ArrayList arrayList = new ArrayList();
        this.zzamH = 1;
        this.zzamI = this.zzamB.zzann.size();
        for (Api.zzc next : this.zzamB.zzann.keySet()) {
            if (!this.zzamB.zzanC.containsKey(next)) {
                arrayList.add(this.zzamB.zzann.get(next));
            } else if (zzrY()) {
                zzsb();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzamU.add(zzoi.zzsp().submit(new zzc(arrayList)));
        }
    }

    private void zzsb() {
        this.zzamB.zzsn();
        zzoi.zzsp().execute(new Runnable() {
            public void run() {
                zzod.this.zzamE.zzag(zzod.this.mContext);
            }
        });
        zztv zztv = this.zzamL;
        if (zztv != null) {
            if (this.zzamQ) {
                zztv.zza(this.zzamP, this.zzamR);
            }
            zzah(false);
        }
        for (Api.zzc<?> zzc2 : this.zzamB.zzanC.keySet()) {
            this.zzamB.zzann.get(zzc2).disconnect();
        }
        this.zzamB.zzanG.zzk(this.zzamJ.isEmpty() ? null : this.zzamJ);
    }

    /* access modifiers changed from: private */
    public void zzsc() {
        this.zzamN = false;
        this.zzamB.zzamm.zzano = Collections.emptySet();
        for (Api.zzc next : this.zzamK) {
            if (!this.zzamB.zzanC.containsKey(next)) {
                this.zzamB.zzanC.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private void zzsd() {
        Iterator<Future<?>> it = this.zzamU.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.zzamU.clear();
    }

    /* access modifiers changed from: private */
    public Set<Scope> zzse() {
        zzg zzg = this.zzamS;
        if (zzg == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(zzg.zztv());
        Map<Api<?>, zzg.zza> zztx = this.zzamS.zztx();
        for (Api next : zztx.keySet()) {
            if (!this.zzamB.zzanC.containsKey(next.zzre())) {
                hashSet.addAll(zztx.get(next).zzacF);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.zzamB.zzanC.clear();
        this.zzamN = false;
        this.zzamF = null;
        this.zzamH = 0;
        this.zzamM = 2;
        this.zzamO = false;
        this.zzamQ = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.zzamT.keySet()) {
            Api.zze zze2 = this.zzamB.zzann.get(next.zzre());
            int intValue = this.zzamT.get(next).intValue();
            z |= next.zzrb().getPriority() == 1;
            if (zze2.zzpd()) {
                this.zzamN = true;
                if (intValue < this.zzamM) {
                    this.zzamM = intValue;
                }
                if (intValue != 0) {
                    this.zzamK.add(next.zzre());
                }
            }
            hashMap.put(zze2, new zza(this, next, intValue));
        }
        if (z) {
            this.zzamN = false;
        }
        if (this.zzamN) {
            this.zzamS.zzc(Integer.valueOf(this.zzamB.zzamm.getSessionId()));
            zze zze3 = new zze();
            Api.zza<? extends zztv, zztw> zza2 = this.zzalo;
            Context context = this.mContext;
            Looper looper = this.zzamB.zzamm.getLooper();
            zzg zzg = this.zzamS;
            this.zzamL = (zztv) zza2.zza(context, looper, zzg, zzg.zztB(), zze3, zze3);
        }
        this.zzamI = this.zzamB.zzann.size();
        this.zzamU.add(zzoi.zzsp().submit(new zzb(hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        zzsd();
        zzah(true);
        this.zzamB.zzi((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (zzbH(1)) {
            if (bundle != null) {
                this.zzamJ.putAll(bundle);
            }
            if (zzrY()) {
                zzsb();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        zzg(new ConnectionResult(8, (PendingIntent) null));
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzbH(1)) {
            zzb(connectionResult, api, i);
            if (zzrY()) {
                zzsb();
            }
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(T t) {
        this.zzamB.zzamm.zzanh.add(t);
        return t;
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
