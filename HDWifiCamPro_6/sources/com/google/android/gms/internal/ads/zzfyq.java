package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfyq extends zzfyg {
    @CheckForNull
    private List zza;

    zzfyq(zzfvi zzfvi, boolean z) {
        super(zzfvi, true, true);
        List list;
        if (zzfvi.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = zzfwb.zza(zzfvi.size());
        }
        for (int i = 0; i < zzfvi.size(); i++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zzG(List list);

    /* access modifiers changed from: package-private */
    public final void zzg(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzfyp(obj));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        List list = this.zza;
        if (list != null) {
            zzd(zzG(list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(int i) {
        super.zzz(i);
        this.zza = null;
    }
}
