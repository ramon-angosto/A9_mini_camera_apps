package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaim {
    public final int zza;
    public final String zzb;
    public final List zzc;
    public final byte[] zzd;

    public zzaim(int i, String str, List list, byte[] bArr) {
        List list2;
        this.zza = i;
        this.zzb = str;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zzc = list2;
        this.zzd = bArr;
    }
}
