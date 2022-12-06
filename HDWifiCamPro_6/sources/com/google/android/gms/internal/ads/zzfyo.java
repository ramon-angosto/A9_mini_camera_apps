package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfyo extends zzfyq {
    zzfyo(zzfvi zzfvi, boolean z) {
        super(zzfvi, true);
        zzw();
    }

    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList zza = zzfwb.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfyp zzfyp = (zzfyp) it.next();
            zza.add(zzfyp != null ? zzfyp.zza : null);
        }
        return Collections.unmodifiableList(zza);
    }
}
