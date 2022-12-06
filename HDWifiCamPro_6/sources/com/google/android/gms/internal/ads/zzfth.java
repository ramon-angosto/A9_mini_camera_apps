package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzfth implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzftk zzb;

    zzfth(zzftk zzftk, CharSequence charSequence) {
        this.zzb = zzftk;
        this.zza = charSequence;
    }

    public final Iterator iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzfsn.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append(", ");
                    sb.append(zzfsn.zza(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
