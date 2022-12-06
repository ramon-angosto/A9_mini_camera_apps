package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfxk implements Iterator {
    final Iterator zzb;

    zzfxk(Iterator it) {
        if (it != null) {
            this.zzb = it;
            return;
        }
        throw null;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(Object obj);
}
