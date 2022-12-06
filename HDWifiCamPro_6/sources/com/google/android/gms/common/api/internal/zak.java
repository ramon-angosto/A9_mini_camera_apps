package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zak extends zap {
    private final SparseArray<zaj> zad = new SparseArray<>();

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = getFragment(lifecycleActivity);
        zak zak = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zak != null) {
            return zak;
        }
        return new zak(fragment);
    }

    private final zaj zai(int i) {
        if (this.zad.size() <= i) {
            return null;
        }
        SparseArray<zaj> sparseArray = this.zad;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zad.size(); i++) {
            zaj zai = zai(i);
            if (zai != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zai.zaa);
                printWriter.println(":");
                zai.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z = this.zaa;
        String valueOf = String.valueOf(this.zad);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.zab.get() == null) {
            for (int i = 0; i < this.zad.size(); i++) {
                zaj zai = zai(i);
                if (zai != null) {
                    zai.zab.connect();
                }
            }
        }
    }

    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.zad.size(); i++) {
            zaj zai = zai(i);
            if (zai != null) {
                zai.zab.disconnect();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zab(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zaj = this.zad.get(i);
        if (zaj != null) {
            zae(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaj.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zac() {
        for (int i = 0; i < this.zad.size(); i++) {
            zaj zai = zai(i);
            if (zai != null) {
                zai.zab.connect();
            }
        }
    }

    public final void zad(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.zad.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zam zam = (zam) this.zab.get();
        boolean z2 = this.zaa;
        String valueOf = String.valueOf(zam);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        zaj zaj = new zaj(this, i, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zaj);
        this.zad.put(i, zaj);
        if (this.zaa && zam == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.connect();
        }
    }

    public final void zae(int i) {
        zaj zaj = this.zad.get(i);
        this.zad.remove(i);
        if (zaj != null) {
            zaj.zab.unregisterConnectionFailedListener(zaj);
            zaj.zab.disconnect();
        }
    }
}
