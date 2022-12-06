package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzoa implements Releasable, Result {
    protected final Status zzaaO;
    protected final DataHolder zzamz;

    protected zzoa(DataHolder dataHolder, Status status) {
        this.zzaaO = status;
        this.zzamz = dataHolder;
    }

    public Status getStatus() {
        return this.zzaaO;
    }

    public void release() {
        DataHolder dataHolder = this.zzamz;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
