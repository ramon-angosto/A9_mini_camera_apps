package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsa extends zzgsc {
    private zzgsa() {
        super((zzgsb) null);
    }

    /* synthetic */ zzgsa(zzgrz zzgrz) {
        super((zzgsb) null);
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j) {
        zzgrn zzgrn = (zzgrn) zzgui.zzh(obj, j);
        if (zzgrn.zzc()) {
            return zzgrn;
        }
        int size = zzgrn.size();
        zzgrn zzd = zzgrn.zzd(size == 0 ? 10 : size + size);
        zzgui.zzv(obj, j, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzgrn) zzgui.zzh(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j) {
        zzgrn zzgrn = (zzgrn) zzgui.zzh(obj, j);
        zzgrn zzgrn2 = (zzgrn) zzgui.zzh(obj2, j);
        int size = zzgrn.size();
        int size2 = zzgrn2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgrn.zzc()) {
                zzgrn = zzgrn.zzd(size2 + size);
            }
            zzgrn.addAll(zzgrn2);
        }
        if (size > 0) {
            zzgrn2 = zzgrn;
        }
        zzgui.zzv(obj, j, zzgrn2);
    }
}
