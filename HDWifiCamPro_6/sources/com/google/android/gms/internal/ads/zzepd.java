package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzepd implements zzeve {
    private final Context zza;

    zzepd(Context context) {
        this.zza = context;
    }

    public final int zza() {
        return 2;
    }

    public final zzfzp zzb() {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzct)).booleanValue()) {
            return zzfzg.zzi((Object) null);
        }
        return zzfzg.zzi(new zzepe(ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
    }
}
