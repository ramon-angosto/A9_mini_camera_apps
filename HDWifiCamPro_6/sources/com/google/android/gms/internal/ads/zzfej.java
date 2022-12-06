package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfej {
    public static zzq zza(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfdl zzfdl = (zzfdl) it.next();
            if (zzfdl.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzfdl.zza, zzfdl.zzb));
            }
        }
        return new zzq(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzfdl zzb(List list, zzfdl zzfdl) {
        return (zzfdl) list.get(0);
    }

    public static zzfdl zzc(zzq zzq) {
        return zzq.zzi ? new zzfdl(-3, 0, true) : new zzfdl(zzq.zze, zzq.zzb, false);
    }
}
