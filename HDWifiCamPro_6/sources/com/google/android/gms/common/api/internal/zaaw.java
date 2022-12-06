package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zaaw implements zabf {
    /* access modifiers changed from: private */
    public final zabi zaa;
    /* access modifiers changed from: private */
    public final Lock zab;
    /* access modifiers changed from: private */
    public final Context zac;
    /* access modifiers changed from: private */
    public final GoogleApiAvailabilityLight zad;
    private ConnectionResult zae;
    private int zaf;
    private int zag = 0;
    private int zah;
    private final Bundle zai = new Bundle();
    private final Set<Api.AnyClientKey> zaj = new HashSet();
    /* access modifiers changed from: private */
    public zae zak;
    private boolean zal;
    /* access modifiers changed from: private */
    public boolean zam;
    private boolean zan;
    /* access modifiers changed from: private */
    public IAccountAccessor zao;
    private boolean zap;
    private boolean zaq;
    /* access modifiers changed from: private */
    public final ClientSettings zar;
    private final Map<Api<?>, Boolean> zas;
    private final Api.AbstractClientBuilder<? extends zae, SignInOptions> zat;
    private final ArrayList<Future<?>> zau = new ArrayList<>();

    public zaaw(zabi zabi, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zabi;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    /* access modifiers changed from: private */
    public final void zaA() {
        this.zam = false;
        this.zaa.zag.zad = Collections.emptySet();
        for (Api.AnyClientKey next : this.zaj) {
            if (!this.zaa.zab.containsKey(next)) {
                this.zaa.zab.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private final void zaB(boolean z) {
        zae zae2 = this.zak;
        if (zae2 != null) {
            if (zae2.isConnected() && z) {
                zae2.zaa();
            }
            zae2.disconnect();
            ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(this.zar);
            this.zao = null;
        }
    }

    private final void zaC() {
        Bundle bundle;
        this.zaa.zai();
        zabj.zaa().execute(new zaak(this));
        zae zae2 = this.zak;
        if (zae2 != null) {
            if (this.zap) {
                zae2.zac((IAccountAccessor) Preconditions.checkNotNull(this.zao), this.zaq);
            }
            zaB(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zaa.zab.keySet()) {
            ((Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(anyClientKey))).disconnect();
        }
        if (this.zai.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.zai;
        }
        this.zaa.zah.zab(bundle);
    }

    /* access modifiers changed from: private */
    public final void zaD(ConnectionResult connectionResult) {
        zaz();
        zaB(!connectionResult.hasResolution());
        this.zaa.zak(connectionResult);
        this.zaa.zah.zaa(connectionResult);
    }

    /* access modifiers changed from: private */
    public final void zaE(ConnectionResult connectionResult, Api<?> api, boolean z) {
        int priority = api.zac().getPriority();
        if ((!z || connectionResult.hasResolution() || this.zad.getErrorResolutionIntent(connectionResult.getErrorCode()) != null) && (this.zae == null || priority < this.zaf)) {
            this.zae = connectionResult;
            this.zaf = priority;
        }
        this.zaa.zab.put(api.zab(), connectionResult);
    }

    /* access modifiers changed from: private */
    public final void zaF() {
        if (this.zah == 0) {
            if (!this.zam || this.zan) {
                ArrayList arrayList = new ArrayList();
                this.zag = 1;
                this.zah = this.zaa.zaa.size();
                for (Api.AnyClientKey next : this.zaa.zaa.keySet()) {
                    if (!this.zaa.zab.containsKey(next)) {
                        arrayList.add(this.zaa.zaa.get(next));
                    } else if (zaH()) {
                        zaC();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zau.add(zabj.zaa().submit(new zaap(this, arrayList)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zaG(int i) {
        if (this.zag == i) {
            return true;
        }
        Log.w("GACConnecting", this.zaa.zag.zaf());
        Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
        int i2 = this.zah;
        StringBuilder sb = new StringBuilder(33);
        sb.append("mRemainingConnections=");
        sb.append(i2);
        Log.w("GACConnecting", sb.toString());
        String zaJ = zaJ(this.zag);
        String zaJ2 = zaJ(i);
        StringBuilder sb2 = new StringBuilder(zaJ.length() + 70 + zaJ2.length());
        sb2.append("GoogleApiClient connecting is in step ");
        sb2.append(zaJ);
        sb2.append(" but received callback for step ");
        sb2.append(zaJ2);
        Log.e("GACConnecting", sb2.toString(), new Exception());
        zaD(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean zaH() {
        int i = this.zah - 1;
        this.zah = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GACConnecting", this.zaa.zag.zaf());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zaD(new ConnectionResult(8, (PendingIntent) null));
            return false;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult == null) {
            return true;
        }
        this.zaa.zaf = this.zaf;
        zaD(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean zaI(ConnectionResult connectionResult) {
        return this.zal && !connectionResult.hasResolution();
    }

    private static final String zaJ(int i) {
        return i != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    static /* bridge */ /* synthetic */ Set zao(zaaw zaaw) {
        ClientSettings clientSettings = zaaw.zar;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map<Api<?>, zab> zad2 = zaaw.zar.zad();
        for (Api next : zad2.keySet()) {
            if (!zaaw.zaa.zab.containsKey(next.zab())) {
                hashSet.addAll(zad2.get(next).zaa);
            }
        }
        return hashSet;
    }

    static /* bridge */ /* synthetic */ void zar(zaaw zaaw, zak zak2) {
        if (zaaw.zaG(0)) {
            ConnectionResult zaa2 = zak2.zaa();
            if (zaa2.isSuccess()) {
                zav zav = (zav) Preconditions.checkNotNull(zak2.zab());
                ConnectionResult zaa3 = zav.zaa();
                if (!zaa3.isSuccess()) {
                    String valueOf = String.valueOf(zaa3);
                    String.valueOf(valueOf).length();
                    Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(valueOf)), new Exception());
                    zaaw.zaD(zaa3);
                    return;
                }
                zaaw.zan = true;
                zaaw.zao = (IAccountAccessor) Preconditions.checkNotNull(zav.zab());
                zaaw.zap = zav.zac();
                zaaw.zaq = zav.zad();
                zaaw.zaF();
            } else if (zaaw.zaI(zaa2)) {
                zaaw.zaA();
                zaaw.zaF();
            } else {
                zaaw.zaD(zaa2);
            }
        }
    }

    private final void zaz() {
        ArrayList<Future<?>> arrayList = this.zau;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).cancel(true);
        }
        this.zau.clear();
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t) {
        this.zaa.zag.zaa.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    public final void zad() {
        this.zaa.zab.clear();
        this.zam = false;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.zas.keySet()) {
            Api.Client client = (Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(next.zab()));
            z |= next.zac().getPriority() == 1;
            boolean booleanValue = this.zas.get(next).booleanValue();
            if (client.requiresSignIn()) {
                this.zam = true;
                if (booleanValue) {
                    this.zaj.add(next.zab());
                } else {
                    this.zal = false;
                }
            }
            hashMap.put(client, new zaal(this, next, booleanValue));
        }
        if (z) {
            this.zam = false;
        }
        if (this.zam) {
            Preconditions.checkNotNull(this.zar);
            Preconditions.checkNotNull(this.zat);
            this.zar.zae(Integer.valueOf(System.identityHashCode(this.zaa.zag)));
            zaat zaat = new zaat(this, (zaas) null);
            Api.AbstractClientBuilder abstractClientBuilder = this.zat;
            Context context = this.zac;
            Looper looper = this.zaa.zag.getLooper();
            ClientSettings clientSettings = this.zar;
            this.zak = abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) zaat, (GoogleApiClient.OnConnectionFailedListener) zaat);
        }
        this.zah = this.zaa.zaa.size();
        this.zau.add(zabj.zaa().submit(new zaao(this, hashMap)));
    }

    public final void zae() {
    }

    public final void zag(Bundle bundle) {
        if (zaG(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zaH()) {
                zaC();
            }
        }
    }

    public final void zah(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zaG(1)) {
            zaE(connectionResult, api, z);
            if (zaH()) {
                zaC();
            }
        }
    }

    public final void zai(int i) {
        zaD(new ConnectionResult(8, (PendingIntent) null));
    }

    public final boolean zaj() {
        zaz();
        zaB(true);
        this.zaa.zak((ConnectionResult) null);
        return true;
    }
}
