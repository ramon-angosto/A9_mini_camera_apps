package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzmp implements Iterator {
    final Iterator zza = this.zzb.zza.iterator();
    final /* synthetic */ zzmq zzb;

    zzmp(zzmq zzmq) {
        this.zzb = zzmq;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
