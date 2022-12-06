package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzo implements Comparator {
    public static final /* synthetic */ zzo zza = new zzo();

    private /* synthetic */ zzo() {
    }

    public final int compare(Object obj, Object obj2) {
        return RequestConfiguration.zza.indexOf((String) obj) - RequestConfiguration.zza.indexOf((String) obj2);
    }
}
