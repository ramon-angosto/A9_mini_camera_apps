package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxq {
    /* access modifiers changed from: private */
    public final zzdxv zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map zzc;

    public zzdxq(zzdxv zzdxv, Executor executor) {
        this.zza = zzdxv;
        this.zzc = zzdxv.zza();
        this.zzb = executor;
    }

    public final zzdxp zza() {
        zzdxp zzdxp = new zzdxp(this);
        zzdxp unused = zzdxp.zzb.putAll(zzdxp.zza.zzc);
        return zzdxp;
    }
}
