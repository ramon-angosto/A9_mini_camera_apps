package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzus implements Comparator {
    public static final /* synthetic */ zzus zza = new zzus();

    private /* synthetic */ zzus() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((zzuz) Collections.max((List) obj)).compareTo((zzuz) Collections.max((List) obj2));
    }
}
