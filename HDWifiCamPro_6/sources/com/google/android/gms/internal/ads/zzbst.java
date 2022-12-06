package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbst implements Predicate {
    public final /* synthetic */ zzbpu zza;

    public /* synthetic */ zzbst(zzbpu zzbpu) {
        this.zza = zzbpu;
    }

    public final boolean apply(Object obj) {
        zzbpu zzbpu = (zzbpu) obj;
        return (zzbpu instanceof zzbsy) && zzbsy.zzb((zzbsy) zzbpu).equals(this.zza);
    }
}
