package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfwz extends zzfvs {
    private final transient zzfvq zza;
    private final transient zzfvn zzb;

    zzfwz(zzfvq zzfvq, zzfvn zzfvn) {
        this.zza = zzfvq;
        this.zzb = zzfvn;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, i);
    }

    public final zzfvn zzd() {
        return this.zzb;
    }

    public final zzfxm zze() {
        return this.zzb.listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }
}
