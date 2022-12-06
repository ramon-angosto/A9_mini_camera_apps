package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zag<ResultT> extends zac {
    private final TaskApiCall<Api.AnyClient, ResultT> zaa;
    private final TaskCompletionSource<ResultT> zab;
    private final StatusExceptionMapper zad;

    public zag(int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.zab = taskCompletionSource;
        this.zaa = taskApiCall;
        this.zad = statusExceptionMapper;
        if (i == 2 && taskApiCall.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final boolean zaa(zabq<?> zabq) {
        return this.zaa.shouldAutoResolveMissingFeatures();
    }

    public final Feature[] zab(zabq<?> zabq) {
        return this.zaa.zab();
    }

    public final void zad(Status status) {
        this.zab.trySetException(this.zad.getException(status));
    }

    public final void zae(Exception exc) {
        this.zab.trySetException(exc);
    }

    public final void zaf(zabq<?> zabq) throws DeadObjectException {
        try {
            this.zaa.doExecute(zabq.zaf(), this.zab);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zad(zai.zah(e2));
        } catch (RuntimeException e3) {
            this.zab.trySetException(e3);
        }
    }

    public final void zag(zaad zaad, boolean z) {
        zaad.zad(this.zab, z);
    }
}
