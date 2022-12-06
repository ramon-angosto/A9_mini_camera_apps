package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zabv<O extends Api.ApiOptions> extends zaag {
    @NotOnlyInitialized
    private final GoogleApi<O> zaa;

    public zabv(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zaa = googleApi;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return this.zaa.doRead(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        return this.zaa.doWrite(t);
    }

    public final Context getContext() {
        return this.zaa.getApplicationContext();
    }

    public final Looper getLooper() {
        return this.zaa.getLooper();
    }

    public final void zao(zada zada) {
    }

    public final void zap(zada zada) {
    }
}
