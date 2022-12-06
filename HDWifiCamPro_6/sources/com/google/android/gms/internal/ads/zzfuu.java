package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfuu extends AbstractSet {
    final /* synthetic */ zzfux zza;

    zzfuu(zzfux zzfux) {
        this.zza = zzfux;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzfux zzfux = this.zza;
        Map zzl = zzfux.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzfup(zzfux);
    }

    public final boolean remove(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        return this.zza.zzx(obj) != zzfux.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
