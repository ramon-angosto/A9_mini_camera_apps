package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    public final void onResult(R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            onSuccess(r);
            return;
        }
        onFailure(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(r);
                String.valueOf(valueOf).length();
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(valueOf)), e);
            }
        }
    }

    public abstract void onSuccess(R r);
}
