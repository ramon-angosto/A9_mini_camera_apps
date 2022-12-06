package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzevh {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfju zzd;
    private final zzdxq zze;

    public zzevh(Context context, Executor executor, Set set, zzfju zzfju, zzdxq zzdxq) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfju;
        this.zze = zzdxq;
    }

    public final zzfzp zza(Object obj) {
        zzfjj zza2 = zzfji.zza(this.zza, 8);
        zza2.zzf();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        for (zzeve zzeve : this.zzb) {
            zzfzp zzb2 = zzeve.zzb();
            zzb2.zzc(new zzevf(this, zzeve), zzchc.zzf);
            arrayList.add(zzb2);
        }
        zzfzp zza3 = zzfzg.zzc(arrayList).zza(new zzevg(arrayList, obj), this.zzc);
        if (zzfjw.zza()) {
            zzfjt.zza(zza3, this.zzd, zza2);
        }
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzeve zzeve) {
        long elapsedRealtime = zzt.zzB().elapsedRealtime() - zzt.zzB().elapsedRealtime();
        if (((Boolean) zzbkv.zza.zze()).booleanValue()) {
            String zzc2 = zzftm.zzc(zzeve.getClass().getCanonicalName());
            zze.zza("Signal runtime (ms) : " + zzc2 + " = " + elapsedRealtime);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbO)).booleanValue()) {
            zzdxp zza2 = this.zze.zza();
            zza2.zzb("action", "lat_ms");
            zza2.zzb("lat_grp", "sig_lat_grp");
            zza2.zzb("lat_id", String.valueOf(zzeve.zza()));
            zza2.zzb("clat_ms", String.valueOf(elapsedRealtime));
            zza2.zzh();
        }
    }
}
