package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzapy implements zzfow {
    private final zzfmz zza;
    private final zzfnq zzb;
    private final zzaql zzc;
    private final zzapx zzd;
    private final zzapi zze;
    private final zzaqn zzf;

    zzapy(zzfmz zzfmz, zzfnq zzfnq, zzaql zzaql, zzapx zzapx, zzapi zzapi, zzaqn zzaqn) {
        this.zza = zzfmz;
        this.zzb = zzfnq;
        this.zzc = zzaql;
        this.zzd = zzapx;
        this.zze = zzapi;
        this.zzf = zzaqn;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzana zzb2 = this.zzb.zzb();
        hashMap.put("v", this.zza.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb2.zzh());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    public final Map zza() {
        Map zze2 = zze();
        zze2.put("lts", Long.valueOf(this.zzc.zza()));
        return zze2;
    }

    public final Map zzb() {
        Map zze2 = zze();
        zzana zza2 = this.zzb.zza();
        zze2.put("gai", Boolean.valueOf(this.zza.zzd()));
        zze2.put("did", zza2.zzg());
        zze2.put("dst", Integer.valueOf(zza2.zzal() - 1));
        zze2.put("doo", Boolean.valueOf(zza2.zzai()));
        zzapi zzapi = this.zze;
        if (zzapi != null) {
            zze2.put("nt", Long.valueOf(zzapi.zza()));
        }
        zzaqn zzaqn = this.zzf;
        if (zzaqn != null) {
            zze2.put("vs", Long.valueOf(zzaqn.zzc()));
            zze2.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze2;
    }

    public final Map zzc() {
        return zze();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
