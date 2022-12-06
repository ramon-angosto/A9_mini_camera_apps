package com.google.android.gms.internal.ads;

import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzftk {
    /* access modifiers changed from: private */
    public final zzfsj zza;
    private final zzftj zzb;

    private zzftk(zzftj zzftj) {
        zzfsi zzfsi = zzfsi.zza;
        this.zzb = zzftj;
        this.zza = zzfsi;
    }

    public static zzftk zzb(int i) {
        return new zzftk(new zzftg(PAGSdk.INIT_LOCAL_FAIL_CODE));
    }

    public static zzftk zzc(zzfsj zzfsj) {
        return new zzftk(new zzfte(zzfsj));
    }

    /* access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        if (charSequence != null) {
            return new zzfth(this, charSequence);
        }
        throw null;
    }

    public final List zzf(CharSequence charSequence) {
        Iterator zzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzg.hasNext()) {
            arrayList.add((String) zzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
