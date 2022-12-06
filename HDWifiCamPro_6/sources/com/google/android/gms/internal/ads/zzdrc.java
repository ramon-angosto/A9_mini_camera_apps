package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdrc implements Callable {
    public final /* synthetic */ zzdrd zza;
    public final /* synthetic */ zzfzp zzb;
    public final /* synthetic */ zzfzp zzc;
    public final /* synthetic */ zzfzp zzd;
    public final /* synthetic */ zzfzp zze;
    public final /* synthetic */ zzfzp zzf;
    public final /* synthetic */ JSONObject zzg;
    public final /* synthetic */ zzfzp zzh;
    public final /* synthetic */ zzfzp zzi;
    public final /* synthetic */ zzfzp zzj;
    public final /* synthetic */ zzfzp zzk;

    public /* synthetic */ zzdrc(zzdrd zzdrd, zzfzp zzfzp, zzfzp zzfzp2, zzfzp zzfzp3, zzfzp zzfzp4, zzfzp zzfzp5, JSONObject jSONObject, zzfzp zzfzp6, zzfzp zzfzp7, zzfzp zzfzp8, zzfzp zzfzp9) {
        this.zza = zzdrd;
        this.zzb = zzfzp;
        this.zzc = zzfzp2;
        this.zzd = zzfzp3;
        this.zze = zzfzp4;
        this.zzf = zzfzp5;
        this.zzg = jSONObject;
        this.zzh = zzfzp6;
        this.zzi = zzfzp7;
        this.zzj = zzfzp8;
        this.zzk = zzfzp9;
    }

    public final Object call() {
        zzfzp zzfzp = this.zzb;
        zzfzp zzfzp2 = this.zzc;
        zzfzp zzfzp3 = this.zzd;
        zzfzp zzfzp4 = this.zze;
        zzfzp zzfzp5 = this.zzf;
        JSONObject jSONObject = this.zzg;
        zzfzp zzfzp6 = this.zzh;
        zzfzp zzfzp7 = this.zzi;
        zzfzp zzfzp8 = this.zzj;
        zzfzp zzfzp9 = this.zzk;
        zzdoq zzdoq = (zzdoq) zzfzp.get();
        zzdoq.zzN((List) zzfzp2.get());
        zzdoq.zzK((zzbme) zzfzp3.get());
        zzdoq.zzO((zzbme) zzfzp4.get());
        zzdoq.zzH((zzblw) zzfzp5.get());
        zzdoq.zzQ(zzdrq.zzj(jSONObject));
        zzdoq.zzJ(zzdrq.zzi(jSONObject));
        zzcmp zzcmp = (zzcmp) zzfzp6.get();
        if (zzcmp != null) {
            zzdoq.zzY(zzcmp);
            zzdoq.zzX(zzcmp.zzH());
            zzdoq.zzW(zzcmp.zzs());
        }
        zzcmp zzcmp2 = (zzcmp) zzfzp7.get();
        if (zzcmp2 != null) {
            zzdoq.zzM(zzcmp2);
            zzdoq.zzZ(zzcmp2.zzH());
        }
        zzcmp zzcmp3 = (zzcmp) zzfzp8.get();
        if (zzcmp3 != null) {
            zzdoq.zzR(zzcmp3);
        }
        for (zzdru zzdru : (List) zzfzp9.get()) {
            if (zzdru.zza != 1) {
                zzdoq.zzL(zzdru.zzb, zzdru.zzd);
            } else {
                zzdoq.zzU(zzdru.zzb, zzdru.zzc);
            }
        }
        return zzdoq;
    }
}
