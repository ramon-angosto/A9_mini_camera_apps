package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxt implements zzfii {
    private final Map zza = new HashMap();
    private final zzdxl zzb;
    private final Clock zzc;
    private final Map zzd = new HashMap();

    public zzdxt(zzdxl zzdxl, Set set, Clock clock) {
        this.zzb = zzdxl;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdxs zzdxs = (zzdxs) it.next();
            this.zzd.put(zzdxs.zzc, zzdxs);
        }
        this.zzc = clock;
    }

    private final void zze(zzfib zzfib, boolean z) {
        zzfib zzb2 = ((zzdxs) this.zzd.get(zzfib)).zzb;
        String str = true != z ? "f." : "s.";
        if (this.zza.containsKey(zzb2)) {
            this.zzb.zza().put("label.".concat(((zzdxs) this.zzd.get(zzfib)).zza), str.concat(String.valueOf(Long.toString(this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzb2)).longValue()))));
        }
    }

    public final void zzbF(zzfib zzfib, String str) {
    }

    public final void zzbG(zzfib zzfib, String str, Throwable th) {
        if (this.zza.containsKey(zzfib)) {
            this.zzb.zza().put("task.".concat(String.valueOf(str)), "f.".concat(String.valueOf(Long.toString(this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfib)).longValue()))));
        }
        if (this.zzd.containsKey(zzfib)) {
            zze(zzfib, false);
        }
    }

    public final void zzc(zzfib zzfib, String str) {
        this.zza.put(zzfib, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    public final void zzd(zzfib zzfib, String str) {
        if (this.zza.containsKey(zzfib)) {
            this.zzb.zza().put("task.".concat(String.valueOf(str)), "s.".concat(String.valueOf(Long.toString(this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfib)).longValue()))));
        }
        if (this.zzd.containsKey(zzfib)) {
            zze(zzfib, true);
        }
    }
}
