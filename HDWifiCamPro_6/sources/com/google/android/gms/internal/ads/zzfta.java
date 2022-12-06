package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzfta implements Serializable, zzfsy {
    private final List zza;

    /* synthetic */ zzfta(List list, zzfsz zzfsz) {
        this.zza = list;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzfta) {
            return this.zza.equals(((zzfta) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        List list = this.zza;
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append("and(");
        boolean z = true;
        for (Object next : list) {
            if (!z) {
                sb.append(',');
            }
            sb.append(next);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    public final boolean zza(Object obj) {
        for (int i = 0; i < this.zza.size(); i++) {
            if (!((zzfsy) this.zza.get(i)).zza(obj)) {
                return false;
            }
        }
        return true;
    }
}
