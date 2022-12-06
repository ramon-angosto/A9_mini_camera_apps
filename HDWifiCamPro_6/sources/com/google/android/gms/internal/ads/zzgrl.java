package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgrl extends AbstractList {
    private final List zza;
    private final zzgrk zzb;

    public zzgrl(List list, zzgrk zzgrk) {
        this.zza = list;
        this.zzb = zzgrk;
    }

    public final Object get(int i) {
        zzbfn zzb2 = zzbfn.zzb(((Integer) this.zza.get(i)).intValue());
        return zzb2 == null ? zzbfn.AD_FORMAT_TYPE_UNSPECIFIED : zzb2;
    }

    public final int size() {
        return this.zza.size();
    }
}
