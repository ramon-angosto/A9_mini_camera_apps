package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zznq;

public class zzb implements Result {
    private final Status zzaaO;
    private final ArrayMap<zznq<?>, ConnectionResult> zzakK;

    public zzb(Status status, ArrayMap<zznq<?>, ConnectionResult> arrayMap) {
        this.zzaaO = status;
        this.zzakK = arrayMap;
    }

    public Status getStatus() {
        return this.zzaaO;
    }
}
