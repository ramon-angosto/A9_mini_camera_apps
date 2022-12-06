package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcek implements zzcet {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzcek(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final void zza(zzcog zzcog) {
        Context context = this.zza;
        zzcog.zzs(ObjectWrapper.wrap(context), this.zzb, context.getPackageName());
    }
}
