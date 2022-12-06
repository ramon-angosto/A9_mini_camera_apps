package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdzn implements Runnable {
    public final /* synthetic */ zzdzs zza;
    public final /* synthetic */ zzffa zzb;
    public final /* synthetic */ zzbru zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ String zze;

    public /* synthetic */ zzdzn(zzdzs zzdzs, zzffa zzffa, zzbru zzbru, List list, String str) {
        this.zza = zzdzs;
        this.zzb = zzffa;
        this.zzc = zzbru;
        this.zzd = list;
        this.zze = str;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
