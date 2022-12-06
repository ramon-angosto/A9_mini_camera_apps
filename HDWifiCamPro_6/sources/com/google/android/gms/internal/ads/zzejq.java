package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzejq implements Callable {
    public final /* synthetic */ zzejv zza;
    public final /* synthetic */ zzfzp zzb;
    public final /* synthetic */ zzfzp zzc;
    public final /* synthetic */ zzfdw zzd;
    public final /* synthetic */ zzfdk zze;
    public final /* synthetic */ JSONObject zzf;

    public /* synthetic */ zzejq(zzejv zzejv, zzfzp zzfzp, zzfzp zzfzp2, zzfdw zzfdw, zzfdk zzfdk, JSONObject jSONObject) {
        this.zza = zzejv;
        this.zzb = zzfzp;
        this.zzc = zzfzp2;
        this.zzd = zzfdw;
        this.zze = zzfdk;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
