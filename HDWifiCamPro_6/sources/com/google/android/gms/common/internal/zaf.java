package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaf extends zag {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ LifecycleFragment zab;

    zaf(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.zaa = intent;
        this.zab = lifecycleFragment;
    }

    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, 2);
        }
    }
}
