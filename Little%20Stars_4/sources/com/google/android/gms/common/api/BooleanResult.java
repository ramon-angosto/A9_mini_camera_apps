package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzaa;

public class BooleanResult implements Result {
    private final Status zzaaO;
    private final boolean zzakR;

    public BooleanResult(Status status, boolean z) {
        this.zzaaO = (Status) zzaa.zzb(status, (Object) "Status must not be null");
        this.zzakR = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zzaaO.equals(booleanResult.zzaaO) && this.zzakR == booleanResult.zzakR;
    }

    public Status getStatus() {
        return this.zzaaO;
    }

    public boolean getValue() {
        return this.zzakR;
    }

    public final int hashCode() {
        return ((this.zzaaO.hashCode() + 527) * 31) + (this.zzakR ? 1 : 0);
    }
}
