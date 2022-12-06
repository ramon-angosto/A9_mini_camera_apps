package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfwa extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzfsm zzb;

    zzfwa(List list, zzfsm zzfsm) {
        this.zza = list;
        this.zzb = zzfsm;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final ListIterator listIterator(int i) {
        return new zzfvz(this, this.zza.listIterator(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
