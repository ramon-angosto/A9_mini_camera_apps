package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeqp implements zzfsm {
    public static final /* synthetic */ zzeqp zza = new zzeqp();

    private /* synthetic */ zzeqp() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzeqq(arrayList);
    }
}
