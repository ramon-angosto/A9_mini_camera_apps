package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zad extends zaa {
    private final BaseImplementation.ResultHolder<Status> zaa;

    public zad(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zaa = resultHolder;
    }

    public final void zab(int i) throws RemoteException {
        this.zaa.setResult(new Status(i));
    }
}
