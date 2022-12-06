package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfuw extends AbstractCollection {
    final /* synthetic */ zzfux zza;

    zzfuw(zzfux zzfux) {
        this.zza = zzfux;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzfux zzfux = this.zza;
        Map zzl = zzfux.zzl();
        if (zzl != null) {
            return zzl.values().iterator();
        }
        return new zzfur(zzfux);
    }

    public final int size() {
        return this.zza.size();
    }
}
