package com.google.android.gms.internal.measurement;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzit implements Comparator {
    zzit() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzjb zzjb = (zzjb) obj;
        zzjb zzjb2 = (zzjb) obj2;
        zzis zzis = new zzis(zzjb);
        zzis zzis2 = new zzis(zzjb2);
        while (zzis.hasNext() && zzis2.hasNext()) {
            int compareTo = Integer.valueOf(zzis.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(zzis2.zza() & UByte.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzjb.zzd()).compareTo(Integer.valueOf(zzjb2.zzd()));
    }
}
