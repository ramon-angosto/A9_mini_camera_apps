package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaf extends zad<Void> {
    private final RegisterListenerMethod<Api.AnyClient, ?> zacp;
    private final UnregisterListenerMethod<Api.AnyClient, ?> zacq;

    public zaf(zabw zabw, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zacp = zabw.zajx;
        this.zacq = zabw.zajy;
    }

    public final /* bridge */ /* synthetic */ void zaa(zaab zaab, boolean z) {
    }

    public final void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException {
        this.zacp.registerListener(zaa.zaab(), this.zacn);
        if (this.zacp.getListenerKey() != null) {
            zaa.zabk().put(this.zacp.getListenerKey(), new zabw(this.zacp, this.zacq));
        }
    }

    public final Feature[] zab(GoogleApiManager.zaa<?> zaa) {
        return this.zacp.getRequiredFeatures();
    }

    public final boolean zac(GoogleApiManager.zaa<?> zaa) {
        return this.zacp.shouldAutoResolveMissingFeatures();
    }

    public final /* bridge */ /* synthetic */ void zaa(RuntimeException runtimeException) {
        super.zaa(runtimeException);
    }

    public final /* bridge */ /* synthetic */ void zaa(Status status) {
        super.zaa(status);
    }
}
