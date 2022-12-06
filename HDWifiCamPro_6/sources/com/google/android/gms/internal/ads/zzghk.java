package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghk {
    private HashMap zza = new HashMap();

    public final zzghm zza() {
        HashMap hashMap = this.zza;
        if (hashMap != null) {
            zzghm zzghm = new zzghm(Collections.unmodifiableMap(hashMap), (zzghl) null);
            this.zza = null;
            return zzghm;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
