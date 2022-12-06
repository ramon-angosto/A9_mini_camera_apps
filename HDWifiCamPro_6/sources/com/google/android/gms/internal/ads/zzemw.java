package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzemw {
    private final zzdmh zza;

    public zzemw(Context context, zzdmh zzdmh) {
        this.zza = zzdmh;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, View view, zzems zzems) {
        zzdlh zze = this.zza.zze(new zzczt(zzfdw, zzfdk, (String) null), new zzemu(this, zzemt.zza));
        zzems.zzd(new zzemv(this, zze));
        return zze.zzg();
    }
}
