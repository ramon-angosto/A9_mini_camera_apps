package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public abstract class zai {
    public final int zac;

    public zai(int i) {
        this.zac = i;
    }

    static /* bridge */ /* synthetic */ Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq<?> zabq) throws DeadObjectException;

    public abstract void zag(zaad zaad, boolean z);
}
