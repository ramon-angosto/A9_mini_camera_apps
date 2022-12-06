package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfxi {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [java.util.Collection, java.util.Set] */
    public static Set zzb(Set set, zzfsy zzfsy) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (sortedSet instanceof zzfxf) {
                zzfxf zzfxf = (zzfxf) sortedSet;
                return new zzfxg((SortedSet) zzfxf.zza, zzftb.zza(zzfxf.zzb, zzfsy));
            } else if (sortedSet == null) {
                throw null;
            } else if (zzfsy != null) {
                return new zzfxg(sortedSet, zzfsy);
            } else {
                throw null;
            }
        } else if (set instanceof zzfxf) {
            zzfxf zzfxf2 = (zzfxf) set;
            return new zzfxf(zzfxf2.zza, zzftb.zza(zzfxf2.zzb, zzfsy));
        } else if (set == null) {
            throw null;
        } else if (zzfsy != null) {
            return new zzfxf(set, zzfsy);
        } else {
            throw null;
        }
    }

    static boolean zzc(Set set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    static boolean zzd(Set set, Collection collection) {
        if (collection != null) {
            if (collection instanceof zzfws) {
                collection = ((zzfws) collection).zza();
            }
            if (!(collection instanceof Set) || collection.size() <= set.size()) {
                return zze(set, collection.iterator());
            }
            Iterator it = set.iterator();
            if (collection != null) {
                boolean z = false;
                while (it.hasNext()) {
                    if (collection.contains(it.next())) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            throw null;
        }
        throw null;
    }

    static boolean zze(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }
}
