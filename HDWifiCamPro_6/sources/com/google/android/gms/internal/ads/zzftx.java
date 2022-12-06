package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzftx implements Iterator {
    @CheckForNull
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzfty zzc;

    zzftx(zzfty zzfty, Iterator it) {
        this.zzc = zzfty;
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        this.zza = (Map.Entry) this.zzb.next();
        return this.zza.getKey();
    }

    public final void remove() {
        zzfsx.zzi(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzfui.zzg(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
