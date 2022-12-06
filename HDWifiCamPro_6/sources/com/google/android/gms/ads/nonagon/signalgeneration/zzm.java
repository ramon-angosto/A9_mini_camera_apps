package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzfsm;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzm implements zzfsm {
    public final /* synthetic */ zzaa zza;
    public final /* synthetic */ Uri zzb;

    public /* synthetic */ zzm(zzaa zzaa, Uri uri) {
        this.zza = zzaa;
        this.zzb = uri;
    }

    public final Object apply(Object obj) {
        return zzaa.zzP(this.zzb, (String) obj);
    }
}
