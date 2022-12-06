package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfni {
    private final Context zza;
    private final Looper zzb;

    public zzfni(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfnw zza2 = zzfny.zza();
        zza2.zza(this.zza.getPackageName());
        zza2.zzc(2);
        zzfnt zza3 = zzfnu.zza();
        zza3.zza(str);
        zza3.zzb(2);
        zza2.zzb(zza3);
        new zzfnj(this.zza, this.zzb, (zzfny) zza2.zzam()).zza();
    }
}
