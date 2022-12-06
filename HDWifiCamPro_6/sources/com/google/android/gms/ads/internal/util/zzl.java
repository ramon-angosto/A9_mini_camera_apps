package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfpz;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzl implements Callable {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzl(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        Uri uri = this.zza;
        zzfpz zzfpz = zzs.zza;
        zzt.zzp();
        return zzs.zzL(uri);
    }
}
