package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcgh;
import com.google.android.gms.internal.ads.zzfpz;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzk implements zzcgh {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzk(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final boolean zza(String str) {
        Context context = this.zza;
        String str2 = this.zzb;
        zzfpz zzfpz = zzs.zza;
        zzt.zzp();
        zzs.zzH(context, str2, str);
        return true;
    }
}
