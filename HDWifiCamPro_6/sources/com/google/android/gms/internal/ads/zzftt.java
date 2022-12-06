package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzftt extends zzfwe {
    final /* synthetic */ zzftv zza;

    zzftt(zzftv zzftv) {
        this.zza = zzftv;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return zzfuo.zza(this.zza.zza.entrySet(), obj);
    }

    public final Iterator iterator() {
        return new zzftu(this.zza);
    }

    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        zzfui.zzq(this.zza.zzb, entry.getKey());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Map zza() {
        return this.zza;
    }
}
