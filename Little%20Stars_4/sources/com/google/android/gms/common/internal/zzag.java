package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public class zzag<T extends IInterface> extends zzk<T> {
    private final Api.zzg<T> zzasr;

    public zzag(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzg zzg, Api.zzg<T> zzg2) {
        super(context, looper, i, zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzasr = zzg2;
    }

    /* access modifiers changed from: protected */
    public T zzab(IBinder iBinder) {
        return this.zzasr.zzab(iBinder);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
        this.zzasr.zza(i, t);
    }

    /* access modifiers changed from: protected */
    public String zzhT() {
        return this.zzasr.zzhT();
    }

    /* access modifiers changed from: protected */
    public String zzhU() {
        return this.zzasr.zzhU();
    }

    public Api.zzg<T> zztX() {
        return this.zzasr;
    }
}
