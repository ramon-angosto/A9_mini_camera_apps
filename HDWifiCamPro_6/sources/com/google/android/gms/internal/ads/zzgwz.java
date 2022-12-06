package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgwz extends AbstractList {
    private static final zzgxa zzc = zzgxa.zzb(zzgwz.class);
    final List zza;
    final Iterator zzb;

    public zzgwz(List list, Iterator it) {
        this.zza = list;
        this.zzb = it;
    }

    public final Object get(int i) {
        if (this.zza.size() > i) {
            return this.zza.get(i);
        }
        if (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final Iterator iterator() {
        return new zzgwy(this);
    }

    public final int size() {
        zzc.zza("potentially expensive size() call");
        zzc.zza("blowup running");
        while (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
        }
        return this.zza.size();
    }
}
