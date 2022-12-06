package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxt implements zzgxi {
    private static final zzgxi zza = zzgxj.zza(Collections.emptySet());
    private final List zzb;
    private final List zzc;

    /* synthetic */ zzgxt(List list, List list2, zzgxr zzgxr) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static zzgxs zza(int i, int i2) {
        return new zzgxs(i, i2, (zzgxr) null);
    }

    /* renamed from: zzc */
    public final Set zzb() {
        int size = this.zzb.size();
        ArrayList arrayList = new ArrayList(this.zzc.size());
        int size2 = this.zzc.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) ((zzgxv) this.zzc.get(i2)).zzb();
            i += collection.size();
            arrayList.add(collection);
        }
        HashSet zza2 = zzgxf.zza(i);
        int size3 = this.zzb.size();
        int i3 = 0;
        while (i3 < size3) {
            Object zzb2 = ((zzgxv) this.zzb.get(i3)).zzb();
            if (zzb2 != null) {
                zza2.add(zzb2);
                i3++;
            } else {
                throw null;
            }
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object next : (Collection) arrayList.get(i4)) {
                if (next != null) {
                    zza2.add(next);
                } else {
                    throw null;
                }
            }
        }
        return Collections.unmodifiableSet(zza2);
    }
}
