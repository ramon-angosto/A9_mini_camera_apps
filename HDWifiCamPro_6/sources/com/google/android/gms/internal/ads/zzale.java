package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzale extends zzakr {
    public zzale() {
    }

    public zzale(zzald zzald, SSLSocketFactory sSLSocketFactory) {
    }

    static List zza(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzajv : (List) entry.getValue()) {
                    arrayList.add(new zzajv((String) entry.getKey(), zzajv));
                }
            }
        }
        return arrayList;
    }
}
