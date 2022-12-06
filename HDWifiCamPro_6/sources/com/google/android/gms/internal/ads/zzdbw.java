package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzas;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdbw implements zzfsm {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcgv zzb;
    public final /* synthetic */ zzfef zzc;

    public /* synthetic */ zzdbw(Context context, zzcgv zzcgv, zzfef zzfef) {
        this.zza = context;
        this.zzb = zzcgv;
        this.zzc = zzfef;
    }

    public final Object apply(Object obj) {
        Context context = this.zza;
        zzcgv zzcgv = this.zzb;
        zzfef zzfef = this.zzc;
        zzfdk zzfdk = (zzfdk) obj;
        zzas zzas = new zzas(context);
        zzas.zzp(zzfdk.zzC);
        zzas.zzq(zzfdk.zzD.toString());
        zzas.zzo(zzcgv.zza);
        zzas.zzn(zzfef.zzf);
        return zzas;
    }
}
