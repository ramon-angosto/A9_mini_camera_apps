package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzuu implements Comparator {
    public static final /* synthetic */ zzuu zza = new zzuu();

    private /* synthetic */ zzuu() {
    }

    public final int compare(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        return zzfvc.zzj().zzc((zzvq) Collections.max(list, zzvo.zza), (zzvq) Collections.max(list2, zzvo.zza), zzvo.zza).zzb(list.size(), list2.size()).zzc((zzvq) Collections.max(list, zzvp.zza), (zzvq) Collections.max(list2, zzvp.zza), zzvp.zza).zza();
    }
}
