package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdzb implements zzdyp {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzeon zzb;

    zzdzb(long j, Context context, zzdyu zzdyu, zzcom zzcom, String str) {
        this.zza = j;
        zzfbp zzt = zzcom.zzt();
        zzt.zzc(context);
        zzt.zza(new zzq());
        zzt.zzb(str);
        this.zzb = zzt.zzd().zza();
        this.zzb.zzD(new zzdza(this, zzdyu));
    }

    public final void zza() {
        this.zzb.zzx();
    }

    public final void zzb(zzl zzl) {
        this.zzb.zzaa(zzl);
    }

    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
