package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcmx implements zzftn {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcoe zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzape zzf;
    public final /* synthetic */ zzbkb zzg;
    public final /* synthetic */ zzcgv zzh;
    public final /* synthetic */ zzl zzi;
    public final /* synthetic */ zza zzj;
    public final /* synthetic */ zzbep zzk;
    public final /* synthetic */ zzfdk zzl;
    public final /* synthetic */ zzfdn zzm;

    public /* synthetic */ zzcmx(Context context, zzcoe zzcoe, String str, boolean z, boolean z2, zzape zzape, zzbkb zzbkb, zzcgv zzcgv, zzbjr zzbjr, zzl zzl2, zza zza2, zzbep zzbep, zzfdk zzfdk, zzfdn zzfdn) {
        this.zza = context;
        this.zzb = zzcoe;
        this.zzc = str;
        this.zzd = z;
        this.zze = z2;
        this.zzf = zzape;
        this.zzg = zzbkb;
        this.zzh = zzcgv;
        this.zzi = zzl2;
        this.zzj = zza2;
        this.zzk = zzbep;
        this.zzl = zzfdk;
        this.zzm = zzfdn;
    }

    public final Object zza() {
        Context context = this.zza;
        zzcoe zzcoe = this.zzb;
        String str = this.zzc;
        boolean z = this.zzd;
        boolean z2 = this.zze;
        zzape zzape = this.zzf;
        zzbkb zzbkb = this.zzg;
        zzcgv zzcgv = this.zzh;
        zzl zzl2 = this.zzi;
        zza zza2 = this.zzj;
        zzbep zzbep = this.zzk;
        zzfdk zzfdk = this.zzl;
        zzfdn zzfdn = this.zzm;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = zzcni.zza;
            zzcne zzcne = new zzcne(new zzcni(new zzcod(context), zzcoe, str, z, z2, zzape, zzbkb, zzcgv, (zzbjr) null, zzl2, zza2, zzbep, zzfdk, zzfdn));
            zzcne.setWebViewClient(zzt.zzq().zzd(zzcne, zzbep, z2));
            zzcne.setWebChromeClient(new zzcmo(zzcne));
            return zzcne;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
