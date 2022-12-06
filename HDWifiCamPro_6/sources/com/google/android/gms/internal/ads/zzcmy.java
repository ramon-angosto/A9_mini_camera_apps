package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcmy implements zzfym {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzape zzb;
    public final /* synthetic */ zzcgv zzc;
    public final /* synthetic */ zza zzd;
    public final /* synthetic */ String zze;

    public /* synthetic */ zzcmy(Context context, zzape zzape, zzcgv zzcgv, zza zza2, String str) {
        this.zza = context;
        this.zzb = zzape;
        this.zzc = zzcgv;
        this.zzd = zza2;
        this.zze = str;
    }

    public final zzfzp zza() {
        Context context = this.zza;
        zzape zzape = this.zzb;
        zzcgv zzcgv = this.zzc;
        zza zza2 = this.zzd;
        String str = this.zze;
        zzt.zzz();
        zzcmp zza3 = zzcnb.zza(context, zzcoe.zza(), "", false, false, zzape, (zzbkb) null, zzcgv, (zzbjr) null, (zzl) null, zza2, zzbep.zza(), (zzfdk) null, (zzfdn) null);
        zzchg zza4 = zzchg.zza(zza3);
        zza3.zzP().zzz(new zzcmz(zza4));
        zza3.loadUrl(str);
        return zza4;
    }
}
