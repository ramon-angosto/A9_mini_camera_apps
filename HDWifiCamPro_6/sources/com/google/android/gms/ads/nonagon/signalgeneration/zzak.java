package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcbc;
import com.google.android.gms.internal.ads.zzecf;
import com.google.android.gms.internal.ads.zzfyn;
import com.google.android.gms.internal.ads.zzfzg;
import com.google.android.gms.internal.ads.zzfzp;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzak implements zzfyn {
    private final Executor zza;
    private final zzecf zzb;

    public zzak(Executor executor, zzecf zzecf) {
        this.zza = executor;
        this.zzb = zzecf;
    }

    public final /* bridge */ /* synthetic */ zzfzp zza(Object obj) throws Exception {
        zzcbc zzcbc = (zzcbc) obj;
        return zzfzg.zzn(this.zzb.zzb(zzcbc), new zzaj(zzcbc), this.zza);
    }
}
