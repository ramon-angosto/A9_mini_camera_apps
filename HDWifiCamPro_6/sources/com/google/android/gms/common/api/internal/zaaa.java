package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaaa implements zaca {
    private final Context zaa;
    private final zabe zab;
    private final Looper zac;
    /* access modifiers changed from: private */
    public final zabi zad;
    /* access modifiers changed from: private */
    public final zabi zae;
    private final Map<Api.AnyClientKey<?>, zabi> zaf;
    private final Set<SignInConnectionListener> zag = Collections.newSetFromMap(new WeakHashMap());
    private final Api.Client zah;
    private Bundle zai;
    /* access modifiers changed from: private */
    public ConnectionResult zaj = null;
    /* access modifiers changed from: private */
    public ConnectionResult zak = null;
    /* access modifiers changed from: private */
    public boolean zal = false;
    /* access modifiers changed from: private */
    public final Lock zam;
    private int zan = 0;

    private zaaa(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zat> arrayList, ArrayList<zat> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.zaa = context;
        this.zab = zabe;
        this.zam = lock;
        this.zac = looper;
        this.zah = client;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zabi zabi = r3;
        zabi zabi2 = new zabi(context2, this.zab, lock2, looper2, googleApiAvailabilityLight2, map2, (ClientSettings) null, map4, (Api.AbstractClientBuilder<? extends zae, SignInOptions>) null, arrayList2, new zax(this, (zaw) null));
        this.zad = zabi;
        this.zae = new zabi(context2, this.zab, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zaz(this, (zay) null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey<?> put : map2.keySet()) {
            arrayMap.put(put, this.zad);
        }
        for (Api.AnyClientKey<?> put2 : map.keySet()) {
            arrayMap.put(put2, this.zae);
        }
        this.zaf = Collections.unmodifiableMap(arrayMap);
    }

    private final void zaB() {
        for (SignInConnectionListener onComplete : this.zag) {
            onComplete.onComplete();
        }
        this.zag.clear();
    }

    private final boolean zaC() {
        ConnectionResult connectionResult = this.zak;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final boolean zaD(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        zabi zabi = this.zaf.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabi, "GoogleApiClient is not configured to use the API required for this call.");
        return zabi.equals(this.zae);
    }

    private static boolean zaE(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public static zaaa zag(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zat> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry next : map.entrySet()) {
            Api.Client client2 = (Api.Client) next.getValue();
            if (true == client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) next.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) next.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.AnyClientKey<?> zab2 = next2.zab();
            if (arrayMap.containsKey(zab2)) {
                arrayMap3.put(next2, map3.get(next2));
            } else if (arrayMap2.containsKey(zab2)) {
                arrayMap4.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zat zat = arrayList.get(i);
            if (arrayMap3.containsKey(zat.zaa)) {
                arrayList2.add(zat);
            } else if (arrayMap4.containsKey(zat.zaa)) {
                arrayList3.add(zat);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zaaa(context, zabe, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    static /* bridge */ /* synthetic */ void zan(zaaa zaaa, int i, boolean z) {
        zaaa.zab.zac(i, z);
        zaaa.zak = null;
        zaaa.zaj = null;
    }

    static /* bridge */ /* synthetic */ void zao(zaaa zaaa, Bundle bundle) {
        Bundle bundle2 = zaaa.zai;
        if (bundle2 == null) {
            zaaa.zai = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    static /* bridge */ /* synthetic */ void zap(zaaa zaaa) {
        ConnectionResult connectionResult;
        if (zaE(zaaa.zaj)) {
            if (zaE(zaaa.zak) || zaaa.zaC()) {
                int i = zaaa.zan;
                if (i != 1) {
                    if (i != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        zaaa.zan = 0;
                        return;
                    }
                    ((zabe) Preconditions.checkNotNull(zaaa.zab)).zab(zaaa.zai);
                }
                zaaa.zaB();
                zaaa.zan = 0;
                return;
            }
            ConnectionResult connectionResult2 = zaaa.zak;
            if (connectionResult2 == null) {
                return;
            }
            if (zaaa.zan == 1) {
                zaaa.zaB();
                return;
            }
            zaaa.zaA(connectionResult2);
            zaaa.zad.zar();
        } else if (zaaa.zaj == null || !zaE(zaaa.zak)) {
            ConnectionResult connectionResult3 = zaaa.zaj;
            if (connectionResult3 != null && (connectionResult = zaaa.zak) != null) {
                if (zaaa.zae.zaf < zaaa.zad.zaf) {
                    connectionResult3 = connectionResult;
                }
                zaaa.zaA(connectionResult3);
            }
        } else {
            zaaa.zae.zar();
            zaaa.zaA((ConnectionResult) Preconditions.checkNotNull(zaaa.zaj));
        }
    }

    private final PendingIntent zaz() {
        if (this.zah == null) {
            return null;
        }
        return zal.zaa(this.zaa, System.identityHashCode(this.zab), this.zah.getSignInIntent(), zal.zaa | 134217728);
    }

    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult zad(Api<?> api) {
        if (!Objects.equal(this.zaf.get(api.zab()), this.zae)) {
            return this.zad.zad(api);
        }
        if (zaC()) {
            return new ConnectionResult(4, zaz());
        }
        return this.zae.zad(api);
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zae(T t) {
        if (!zaD(t)) {
            this.zad.zae(t);
            return t;
        } else if (zaC()) {
            t.setFailedResult(new Status(4, (String) null, zaz()));
            return t;
        } else {
            this.zae.zae(t);
            return t;
        }
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaf(T t) {
        if (!zaD(t)) {
            return this.zad.zaf(t);
        }
        if (!zaC()) {
            return this.zae.zaf(t);
        }
        t.setFailedResult(new Status(4, (String) null, zaz()));
        return t;
    }

    public final void zaq() {
        this.zan = 2;
        this.zal = false;
        this.zak = null;
        this.zaj = null;
        this.zad.zaq();
        this.zae.zaq();
    }

    public final void zar() {
        this.zak = null;
        this.zaj = null;
        this.zan = 0;
        this.zad.zar();
        this.zae.zar();
        zaB();
    }

    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.zae.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.zad.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final void zat() {
        this.zad.zat();
        this.zae.zat();
    }

    public final void zau() {
        this.zam.lock();
        try {
            boolean zax = zax();
            this.zae.zar();
            this.zak = new ConnectionResult(4);
            if (zax) {
                new zaq(this.zac).post(new zav(this));
            } else {
                zaB();
            }
        } finally {
            this.zam.unlock();
        }
    }

    public final boolean zaw() {
        this.zam.lock();
        try {
            boolean z = true;
            if (!this.zad.zaw() || (!this.zae.zaw() && !zaC() && this.zan != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zam.unlock();
        }
    }

    public final boolean zax() {
        this.zam.lock();
        try {
            return this.zan == 2;
        } finally {
            this.zam.unlock();
        }
    }

    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        this.zam.lock();
        try {
            if ((zax() || zaw()) && !this.zae.zaw()) {
                this.zag.add(signInConnectionListener);
                if (this.zan == 0) {
                    this.zan = 1;
                }
                this.zak = null;
                this.zae.zaq();
                return true;
            }
            this.zam.unlock();
            return false;
        } finally {
            this.zam.unlock();
        }
    }

    private final void zaA(ConnectionResult connectionResult) {
        int i = this.zan;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zan = 0;
            }
            this.zab.zaa(connectionResult);
        }
        zaB();
        this.zan = 0;
    }
}
