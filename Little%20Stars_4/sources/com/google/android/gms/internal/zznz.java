package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzou;

public abstract class zznz<L> implements zzou.zzb<L> {
    private final DataHolder zzamz;

    protected zznz(DataHolder dataHolder) {
        this.zzamz = dataHolder;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(L l, DataHolder dataHolder);

    public void zzrV() {
        DataHolder dataHolder = this.zzamz;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public final void zzt(L l) {
        zza(l, this.zzamz);
    }
}
