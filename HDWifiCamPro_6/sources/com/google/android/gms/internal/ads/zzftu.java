package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzftu implements Iterator {
    final Iterator zza = this.zzc.zza.entrySet().iterator();
    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzftv zzc;

    zzftu(zzftv zzftv) {
        this.zzc = zzftv;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zza(entry);
    }

    public final void remove() {
        zzfsx.zzi(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfui.zzg(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
