package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzedc implements zzdfv {
    private final Context zza;
    private final zzceu zzb;

    zzedc(Context context, zzceu zzceu) {
        this.zza = context;
        this.zzb = zzceu;
    }

    public final void zzb(zzfdw zzfdw) {
        if (!TextUtils.isEmpty(zzfdw.zzb.zzb.zzd)) {
            this.zzb.zzp(this.zza, zzfdw.zza.zza.zzd);
            this.zzb.zzl(this.zza, zzfdw.zzb.zzb.zzd);
        }
    }

    public final void zzbE(zzcbc zzcbc) {
    }
}
