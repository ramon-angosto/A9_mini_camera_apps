package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zztu;
import com.google.android.gms.internal.zztv;
import com.google.android.gms.internal.zztw;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    /* access modifiers changed from: private */
    public static final Set<GoogleApiClient> zzalc = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Account zzZB;
        private String zzaaN;
        private Looper zzakW;
        private final Set<Scope> zzald;
        private final Set<Scope> zzale;
        private int zzalf;
        private View zzalg;
        private String zzalh;
        private final Map<Api<?>, zzg.zza> zzali;
        private final Map<Api<?>, Api.ApiOptions> zzalj;
        private zzop zzalk;
        private int zzall;
        private OnConnectionFailedListener zzalm;
        private GoogleApiAvailability zzaln;
        private Api.zza<? extends zztv, zztw> zzalo;
        private final ArrayList<ConnectionCallbacks> zzalp;
        private final ArrayList<OnConnectionFailedListener> zzalq;

        public Builder(@NonNull Context context) {
            this.zzald = new HashSet();
            this.zzale = new HashSet();
            this.zzali = new ArrayMap();
            this.zzalj = new ArrayMap();
            this.zzall = -1;
            this.zzaln = GoogleApiAvailability.getInstance();
            this.zzalo = zztu.zzaaA;
            this.zzalp = new ArrayList<>();
            this.zzalq = new ArrayList<>();
            this.mContext = context;
            this.zzakW = context.getMainLooper();
            this.zzaaN = context.getPackageName();
            this.zzalh = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzaa.zzb(connectionCallbacks, (Object) "Must provide a connected listener");
            this.zzalp.add(connectionCallbacks);
            zzaa.zzb(onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zzalq.add(onConnectionFailedListener);
        }

        private static <C extends Api.zze, O> C zza(Api.zza<C, O> zza, Object obj, Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zza.zza(context, looper, zzg, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private Builder zza(@NonNull zzop zzop, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            zzaa.zzb(i >= 0, (Object) "clientId must be non-negative");
            this.zzall = i;
            this.zzalm = onConnectionFailedListener;
            this.zzalk = zzop;
            return this;
        }

        private static <C extends Api.zzg, O> zzag zza(Api.zzh<C, O> zzh, Object obj, Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzag(context, looper, zzh.zzri(), connectionCallbacks, onConnectionFailedListener, zzg, zzh.zzr(obj));
        }

        private <O extends Api.ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    StringBuilder sb = new StringBuilder(90);
                    sb.append("Invalid resolution mode: '");
                    sb.append(i);
                    sb.append("', use a constant from GoogleApiClient.ResolutionMode");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            HashSet hashSet = new HashSet(api.zzrb().zzp(o));
            for (Scope add : scopeArr) {
                hashSet.add(add);
            }
            this.zzali.put(api, new zzg.zza(hashSet, z));
        }

        private void zze(GoogleApiClient googleApiClient) {
            zznr.zza(this.zzalk).zza(this.zzall, googleApiClient, this.zzalm);
        }

        private GoogleApiClient zzru() {
            Api api;
            Api api2;
            Api.zze zze;
            zzg zzrt = zzrt();
            Map<Api<?>, zzg.zza> zztx = zzrt.zztx();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Iterator<Api<?>> it = this.zzalj.keySet().iterator();
            Api api3 = null;
            Api api4 = null;
            while (true) {
                int i = 0;
                if (it.hasNext()) {
                    Api next = it.next();
                    Api.ApiOptions apiOptions = this.zzalj.get(next);
                    if (zztx.get(next) != null) {
                        i = zztx.get(next).zzars ? 1 : 2;
                    }
                    arrayMap.put(next, Integer.valueOf(i));
                    zznw zznw = new zznw(next, i);
                    arrayList.add(zznw);
                    if (next.zzrf()) {
                        Api.zzh zzrd = next.zzrd();
                        api2 = zzrd.getPriority() == 1 ? next : api3;
                        api = next;
                        zze = zza(zzrd, (Object) apiOptions, this.mContext, this.zzakW, zzrt, (ConnectionCallbacks) zznw, (OnConnectionFailedListener) zznw);
                    } else {
                        zznw zznw2 = zznw;
                        api = next;
                        Api.zza zzrc = api.zzrc();
                        api2 = zzrc.getPriority() == 1 ? api : api3;
                        zze = zza(zzrc, (Object) apiOptions, this.mContext, this.zzakW, zzrt, (ConnectionCallbacks) zznw2, (OnConnectionFailedListener) zznw2);
                    }
                    arrayMap2.put(api.zzre(), zze);
                    if (zze.zzps()) {
                        if (api4 == null) {
                            api4 = api;
                        } else {
                            String valueOf = String.valueOf(api.getName());
                            String valueOf2 = String.valueOf(api4.getName());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(valueOf2).length());
                            sb.append(valueOf);
                            sb.append(" cannot be used with ");
                            sb.append(valueOf2);
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    api3 = api2;
                } else {
                    if (api4 != null) {
                        if (api3 == null) {
                            zzaa.zza(this.zzZB == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api4.getName());
                            zzaa.zza(this.zzald.equals(this.zzale), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api4.getName());
                        } else {
                            String valueOf3 = String.valueOf(api4.getName());
                            String valueOf4 = String.valueOf(api3.getName());
                            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 21 + String.valueOf(valueOf4).length());
                            sb2.append(valueOf3);
                            sb2.append(" cannot be used with ");
                            sb2.append(valueOf4);
                            throw new IllegalStateException(sb2.toString());
                        }
                    }
                    return new zzof(this.mContext, new ReentrantLock(), this.zzakW, zzrt, this.zzaln, this.zzalo, arrayMap, this.zzalp, this.zzalq, arrayMap2, this.zzall, zzof.zza(arrayMap2.values(), true), arrayList);
                }
            }
        }

        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzaa.zzb(api, (Object) "Api must not be null");
            this.zzalj.put(api, (Object) null);
            List<Scope> zzp = api.zzrb().zzp(null);
            this.zzale.addAll(zzp);
            this.zzald.addAll(zzp);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            zzaa.zzb(api, (Object) "Api must not be null");
            zzaa.zzb(o, (Object) "Null options are not permitted for this Api");
            this.zzalj.put(api, o);
            List<Scope> zzp = api.zzrb().zzp(o);
            this.zzale.addAll(zzp);
            this.zzald.addAll(zzp);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, Scope... scopeArr) {
            zzaa.zzb(api, (Object) "Api must not be null");
            zzaa.zzb(o, (Object) "Null options are not permitted for this Api");
            this.zzalj.put(api, o);
            zza(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            zzaa.zzb(api, (Object) "Api must not be null");
            this.zzalj.put(api, (Object) null);
            zza(api, (Api.ApiOptions) null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            zzaa.zzb(connectionCallbacks, (Object) "Listener must not be null");
            this.zzalp.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            zzaa.zzb(onConnectionFailedListener, (Object) "Listener must not be null");
            this.zzalq.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzaa.zzb(scope, (Object) "Scope must not be null");
            this.zzald.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzaa.zzb(!this.zzalj.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient zzru = zzru();
            synchronized (GoogleApiClient.zzalc) {
                GoogleApiClient.zzalc.add(zzru);
            }
            if (this.zzall >= 0) {
                zze(zzru);
            }
            return zzru;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return zza(new zzop(fragmentActivity), i, onConnectionFailedListener);
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.zzZB = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.zzalf = i;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzaa.zzb(handler, (Object) "Handler must not be null");
            this.zzakW = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View view) {
            zzaa.zzb(view, (Object) "View must not be null");
            this.zzalg = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzg zzrt() {
            zztw zztw = zztw.zzbnf;
            if (this.zzalj.containsKey(zztu.API)) {
                zztw = (zztw) this.zzalj.get(zztu.API);
            }
            return new zzg(this.zzZB, this.zzald, this.zzali, this.zzalf, this.zzalg, this.zzaaN, this.zzalh, zztw);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (zzalc) {
            int i = 0;
            String concat = String.valueOf(str).concat("  ");
            for (GoogleApiClient dump : zzalc) {
                printWriter.append(str).append("GoogleApiClient#").println(i);
                dump.dump(concat, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzrq() {
        Set<GoogleApiClient> set;
        synchronized (zzalc) {
            set = zzalc;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends Api.zze> C zza(@NonNull Api.zzc<C> zzc) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzpe zzpe) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzpa zzpa) {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzpe zzpe) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void zzrr() {
        throw new UnsupportedOperationException();
    }

    public <L> zzou<L> zzs(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}
