package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zznr extends zznu {
    private final SparseArray<zza> zzalH = new SparseArray<>();

    private class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzalI;
        public final GoogleApiClient zzalJ;
        public final GoogleApiClient.OnConnectionFailedListener zzalK;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzalI = i;
            this.zzalJ = googleApiClient;
            this.zzalK = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.zzalI);
            printWriter.println(":");
            this.zzalJ.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            zznr.this.zzb(connectionResult, this.zzalI);
        }

        public void zzrB() {
            this.zzalJ.unregisterConnectionFailedListener(this);
            this.zzalJ.disconnect();
        }
    }

    private zznr(zzor zzor) {
        super(zzor);
        this.zzaop.zza("AutoManageHelper", (zzoq) this);
    }

    public static zznr zza(zzop zzop) {
        zzor zzc = zzc(zzop);
        zznr zznr = (zznr) zzc.zza("AutoManageHelper", zznr.class);
        return zznr != null ? zznr : new zznr(zzc);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zzalH.size(); i++) {
            this.zzalH.valueAt(i).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.zzalH);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (!this.zzalQ) {
            for (int i = 0; i < this.zzalH.size(); i++) {
                this.zzalH.valueAt(i).zzalJ.connect();
            }
        }
    }

    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.zzalH.size(); i++) {
            this.zzalH.valueAt(i).zzalJ.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzaa.zzb(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        boolean z = this.zzalH.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        zzaa.zza(z, (Object) sb.toString());
        boolean z2 = this.mStarted;
        boolean z3 = this.zzalQ;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(z3);
        Log.d("AutoManageHelper", sb2.toString());
        this.zzalH.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && !this.zzalQ) {
            String valueOf = String.valueOf(googleApiClient);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf);
            Log.d("AutoManageHelper", sb3.toString());
            googleApiClient.connect();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza zza2 = this.zzalH.get(i);
        if (zza2 != null) {
            zzbG(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zza2.zzalK;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public void zzbG(int i) {
        zza zza2 = this.zzalH.get(i);
        this.zzalH.remove(i);
        if (zza2 != null) {
            zza2.zzrB();
        }
    }

    /* access modifiers changed from: protected */
    public void zzrA() {
        for (int i = 0; i < this.zzalH.size(); i++) {
            this.zzalH.valueAt(i).zzalJ.connect();
        }
    }
}
