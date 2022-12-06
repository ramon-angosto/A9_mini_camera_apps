package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfvu extends zzftq {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfsy zzb;

    zzfvu(Iterator it, zzfsy zzfsy) {
        this.zza = it;
        this.zzb = zzfsy;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final Object zza() {
        while (this.zza.hasNext()) {
            Object next = this.zza.next();
            if (this.zzb.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
