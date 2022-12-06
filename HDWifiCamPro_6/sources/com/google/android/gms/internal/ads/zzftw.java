package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
class zzftw implements Iterator {
    final Iterator zza;
    @CheckForNull
    Object zzb = null;
    @CheckForNull
    Collection zzc = null;
    Iterator zzd = zzfvw.INSTANCE;
    final /* synthetic */ zzfui zze;

    zzftw(zzfui zzfui) {
        this.zze = zzfui;
        this.zza = zzfui.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzd.hasNext();
    }

    public final Object next() {
        if (!this.zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            this.zzb = entry.getKey();
            this.zzc = (Collection) entry.getValue();
            this.zzd = this.zzc.iterator();
        }
        return this.zzd.next();
    }

    public final void remove() {
        this.zzd.remove();
        Collection collection = this.zzc;
        collection.getClass();
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        zzfui.zze(this.zze);
    }
}
