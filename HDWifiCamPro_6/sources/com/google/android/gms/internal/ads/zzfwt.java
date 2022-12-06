package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfwt extends zzfwv implements Serializable {
    static final zzfwt zza = new zzfwt();

    private zzfwt() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        if (comparable == null) {
            throw null;
        } else if (comparable2 != null) {
            return comparable.compareTo(comparable2);
        } else {
            throw null;
        }
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    public final zzfwv zza() {
        return zzfxd.zza;
    }
}
