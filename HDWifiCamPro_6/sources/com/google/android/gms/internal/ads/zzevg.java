package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzevg implements Callable {
    public final /* synthetic */ List zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzevg(List list, Object obj) {
        this.zza = list;
        this.zzb = obj;
    }

    public final Object call() {
        List<zzfzp> list = this.zza;
        Object obj = this.zzb;
        for (zzfzp zzfzp : list) {
            zzevd zzevd = (zzevd) zzfzp.get();
            if (zzevd != null) {
                zzevd.zzf(obj);
            }
        }
        return obj;
    }
}
