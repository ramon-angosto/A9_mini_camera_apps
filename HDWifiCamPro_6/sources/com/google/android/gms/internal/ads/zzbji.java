package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbji {
    public static final void zza(zzbjh zzbjh, zzbjf zzbjf) {
        if (zzbjf.zza() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzbjf.zzb())) {
            zzbjh.zzd(zzbjf.zza(), zzbjf.zzb(), zzbjf.zzc(), zzbjf.zzd());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
