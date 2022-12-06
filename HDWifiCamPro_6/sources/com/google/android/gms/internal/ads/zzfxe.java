package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfxe extends zzfwv implements Serializable {
    final zzfwv zza;

    zzfxe(zzfwv zzfwv) {
        this.zza = zzfwv;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfxe) {
            return this.zza.equals(((zzfxe) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        zzfwv zzfwv = this.zza;
        sb.append(zzfwv);
        sb.append(".reverse()");
        return zzfwv.toString().concat(".reverse()");
    }

    public final zzfwv zza() {
        return this.zza;
    }
}
