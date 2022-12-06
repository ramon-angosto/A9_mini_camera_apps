package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final /* synthetic */ class zacu implements RemoteCall {
    public final /* synthetic */ BiConsumer zaa;

    public /* synthetic */ zacu(BiConsumer biConsumer) {
        this.zaa = biConsumer;
    }

    public final void accept(Object obj, Object obj2) {
        this.zaa.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
