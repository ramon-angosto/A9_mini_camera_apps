package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
class zzfue implements Iterator {
    final Iterator zza;
    final Collection zzb = this.zzc.zzb;
    final /* synthetic */ zzfuf zzc;

    zzfue(zzfuf zzfuf) {
        Iterator it;
        this.zzc = zzfuf;
        Collection collection = zzfuf.zzb;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    zzfue(zzfuf zzfuf, Iterator it) {
        this.zzc = zzfuf;
        this.zza = it;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzfui.zze(this.zzc.zze);
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
