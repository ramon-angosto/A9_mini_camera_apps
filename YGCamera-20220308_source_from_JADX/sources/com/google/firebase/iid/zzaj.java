package com.google.firebase.iid;

import android.os.Bundle;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzaj extends zzah<Bundle> {
    zzaj(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(RemoteMessageConst.DATA);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zza(bundle2);
    }
}
