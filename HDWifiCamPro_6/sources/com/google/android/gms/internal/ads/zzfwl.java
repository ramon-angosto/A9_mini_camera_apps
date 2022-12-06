package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfwl extends zzfwp {
    final /* synthetic */ Comparator zza;

    zzfwl(Comparator comparator) {
        this.zza = comparator;
    }

    /* access modifiers changed from: package-private */
    public final Map zza() {
        return new TreeMap(this.zza);
    }
}
