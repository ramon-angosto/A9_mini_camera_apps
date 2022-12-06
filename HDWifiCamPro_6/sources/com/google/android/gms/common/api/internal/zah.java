package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zah extends zad<Boolean> {
    public final ListenerHolder.ListenerKey<?> zab;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    public final boolean zaa(zabq<?> zabq) {
        zaci zaci = zabq.zah().get(this.zab);
        return zaci != null && zaci.zaa.zab();
    }

    public final Feature[] zab(zabq<?> zabq) {
        zaci zaci = zabq.zah().get(this.zab);
        if (zaci == null) {
            return null;
        }
        return zaci.zaa.getRequiredFeatures();
    }

    public final void zac(zabq<?> zabq) throws RemoteException {
        zaci remove = zabq.zah().remove(this.zab);
        if (remove != null) {
            remove.zab.unregisterListener(zabq.zaf(), this.zaa);
            remove.zaa.clearListener();
            return;
        }
        this.zaa.trySetResult(false);
    }

    public final /* bridge */ /* synthetic */ void zag(zaad zaad, boolean z) {
    }
}
