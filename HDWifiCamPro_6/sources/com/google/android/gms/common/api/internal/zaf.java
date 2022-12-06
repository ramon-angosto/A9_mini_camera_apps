package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zaf extends zad<Void> {
    public final zaci zab;

    public zaf(zaci zaci, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zab = zaci;
    }

    public final boolean zaa(zabq<?> zabq) {
        return this.zab.zaa.zab();
    }

    public final Feature[] zab(zabq<?> zabq) {
        return this.zab.zaa.getRequiredFeatures();
    }

    public final void zac(zabq<?> zabq) throws RemoteException {
        this.zab.zaa.registerListener(zabq.zaf(), this.zaa);
        ListenerHolder.ListenerKey<?> listenerKey = this.zab.zaa.getListenerKey();
        if (listenerKey != null) {
            zabq.zah().put(listenerKey, this.zab);
        }
    }

    public final /* bridge */ /* synthetic */ void zag(zaad zaad, boolean z) {
    }
}
