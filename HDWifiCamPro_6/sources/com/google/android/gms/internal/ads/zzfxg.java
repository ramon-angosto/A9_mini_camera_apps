package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfxg extends zzfxf implements SortedSet {
    zzfxg(SortedSet sortedSet, zzfsy zzfsy) {
        super(sortedSet, zzfsy);
    }

    @CheckForNull
    public final Comparator comparator() {
        return ((SortedSet) this.zza).comparator();
    }

    public final Object first() {
        Iterator it = this.zza.iterator();
        zzfsy zzfsy = this.zzb;
        if (it == null) {
            throw null;
        } else if (zzfsy != null) {
            while (it.hasNext()) {
                Object next = it.next();
                if (zzfsy.zza(next)) {
                    return next;
                }
            }
            throw new NoSuchElementException();
        } else {
            throw null;
        }
    }

    public final SortedSet headSet(Object obj) {
        return new zzfxg(((SortedSet) this.zza).headSet(obj), this.zzb);
    }

    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.zza;
        while (true) {
            Object last = sortedSet.last();
            if (this.zzb.zza(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzfxg(((SortedSet) this.zza).subSet(obj, obj2), this.zzb);
    }

    public final SortedSet tailSet(Object obj) {
        return new zzfxg(((SortedSet) this.zza).tailSet(obj), this.zzb);
    }
}
