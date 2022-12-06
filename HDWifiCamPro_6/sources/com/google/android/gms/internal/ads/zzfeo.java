package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfeo {
    private final zzfdk zza;
    private final zzfdn zzb;
    private final zzego zzc;
    private final zzfkm zzd;
    private final zzfju zze;

    public zzfeo(zzego zzego, zzfkm zzfkm, zzfdk zzfdk, zzfdn zzfdn, zzfju zzfju) {
        this.zza = zzfdk;
        this.zzb = zzfdn;
        this.zzc = zzego;
        this.zzd = zzfkm;
        this.zze = zzfju;
    }

    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), 2);
        }
    }

    public final void zzb(String str, int i) {
        if (!this.zza.zzak) {
            this.zzd.zzc(str, this.zze);
            return;
        }
        this.zzc.zzd(new zzegq(zzt.zzB().currentTimeMillis(), this.zzb.zzb, str, i));
    }

    public final void zzc(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), i);
        }
    }
}
