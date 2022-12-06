package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class BooleanResult implements Result {
    private final Status zaa;
    private final boolean zab;

    public BooleanResult(Status status, boolean z) {
        this.zaa = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.zab = z;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zaa.equals(booleanResult.zaa) && this.zab == booleanResult.zab;
    }

    public Status getStatus() {
        return this.zaa;
    }

    public boolean getValue() {
        return this.zab;
    }

    public final int hashCode() {
        return ((this.zaa.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (this.zab ? 1 : 0);
    }
}
