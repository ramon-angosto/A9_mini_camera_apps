package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzz;

public final class zznq<O extends Api.ApiOptions> {
    private final Api<O> zzakT;
    private final O zzakU;

    public zznq(Api<O> api, O o) {
        this.zzakT = api;
        this.zzakU = o;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zznq)) {
            return false;
        }
        zznq zznq = (zznq) obj;
        return zzz.equal(this.zzakT, zznq.zzakT) && zzz.equal(this.zzakU, zznq.zzakU);
    }

    public int hashCode() {
        return zzz.hashCode(this.zzakT, this.zzakU);
    }

    public Api.zzc<?> zzre() {
        return this.zzakT.zzre();
    }

    public String zzrz() {
        return this.zzakT.getName();
    }
}
