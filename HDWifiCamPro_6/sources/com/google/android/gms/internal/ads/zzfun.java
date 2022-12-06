package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
class zzfun extends AbstractCollection {
    final Collection zza;
    final zzfsy zzb;

    zzfun(Collection collection, zzfsy zzfsy) {
        this.zza = collection;
        this.zzb = zzfsy;
    }

    public final boolean add(Object obj) {
        zzfsx.zze(this.zzb.zza(obj));
        return this.zza.add(obj);
    }

    public final boolean addAll(Collection collection) {
        for (Object zza2 : collection) {
            zzfsx.zze(this.zzb.zza(zza2));
        }
        return this.zza.addAll(collection);
    }

    public final void clear() {
        zzfvt.zza(this.zza, this.zzb);
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (zzfuo.zza(this.zza, obj)) {
            return this.zzb.zza(obj);
        }
        return false;
    }

    public final boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        Collection<Object> collection = this.zza;
        zzfsy zzfsy = this.zzb;
        zzfsx.zzc(zzfsy, "predicate");
        int i = 0;
        for (Object zza2 : collection) {
            if (!zzfsy.zza(zza2)) {
                i++;
            } else if (i != -1) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public final Iterator iterator() {
        Iterator it = this.zza.iterator();
        zzfsy zzfsy = this.zzb;
        if (it == null) {
            throw null;
        } else if (zzfsy != null) {
            return new zzfvu(it, zzfsy);
        } else {
            throw null;
        }
    }

    public final boolean remove(@CheckForNull Object obj) {
        return contains(obj) && this.zza.remove(obj);
    }

    public final boolean removeAll(Collection collection) {
        Iterator it = this.zza.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.zzb.zza(next) && collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public final boolean retainAll(Collection collection) {
        Iterator it = this.zza.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.zzb.zza(next) && !collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public final int size() {
        int i = 0;
        for (Object zza2 : this.zza) {
            if (this.zzb.zza(zza2)) {
                i++;
            }
        }
        return i;
    }

    public final Object[] toArray() {
        Iterator it = iterator();
        ArrayList arrayList = new ArrayList();
        zzfvx.zzc(arrayList, it);
        return arrayList.toArray();
    }

    public final Object[] toArray(Object[] objArr) {
        Iterator it = iterator();
        ArrayList arrayList = new ArrayList();
        zzfvx.zzc(arrayList, it);
        return arrayList.toArray(objArr);
    }
}
