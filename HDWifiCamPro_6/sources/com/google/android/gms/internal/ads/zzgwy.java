package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgwy implements Iterator {
    int zza = 0;
    final /* synthetic */ zzgwz zzb;

    zzgwy(zzgwz zzgwz) {
        this.zzb = zzgwz;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            List list = this.zzb.zza;
            int i = this.zza;
            this.zza = i + 1;
            return list.get(i);
        }
        zzgwz zzgwz = this.zzb;
        zzgwz.zza.add(zzgwz.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
