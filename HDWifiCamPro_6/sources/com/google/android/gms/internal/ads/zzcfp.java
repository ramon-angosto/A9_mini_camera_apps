package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzaw;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcfp {
    public final zzfzp zza(Context context, int i) {
        zzchh zzchh = new zzchh();
        zzaw.zzb();
        if (zzcgi.zzs(context)) {
            zzchc.zza.execute(new zzcfo(this, context, zzchh));
        }
        return zzchh;
    }
}
