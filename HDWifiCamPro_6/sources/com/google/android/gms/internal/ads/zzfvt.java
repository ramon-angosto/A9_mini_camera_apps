package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfvt {
    public static boolean zza(Iterable iterable, zzfsy zzfsy) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            if (zzfsy != null) {
                boolean z = false;
                while (it.hasNext()) {
                    if (zzfsy.zza(it.next())) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            throw null;
        }
        List list = (List) iterable;
        if (zzfsy != null) {
            return zzc(list, zzfsy);
        }
        throw null;
    }

    private static void zzb(List list, zzfsy zzfsy, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzfsy.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 >= i) {
                list.remove(i2);
            } else {
                return;
            }
        }
    }

    private static boolean zzc(List list, zzfsy zzfsy) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzfsy.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (UnsupportedOperationException unused) {
                        zzb(list, zzfsy, i2, i);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        zzb(list, zzfsy, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }
}
