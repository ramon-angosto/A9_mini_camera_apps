package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class ApiKey<O extends Api.ApiOptions> {
    private final int zaa = Objects.hashCode(this.zab, this.zac, this.zad);
    private final Api<O> zab;
    private final O zac;
    private final String zad;

    private ApiKey(Api<O> api, O o, String str) {
        this.zab = api;
        this.zac = o;
        this.zad = str;
    }

    public static <O extends Api.ApiOptions> ApiKey<O> zaa(Api<O> api, O o, String str) {
        return new ApiKey<>(api, o, str);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return Objects.equal(this.zab, apiKey.zab) && Objects.equal(this.zac, apiKey.zac) && Objects.equal(this.zad, apiKey.zad);
    }

    public final int hashCode() {
        return this.zaa;
    }

    public final String zab() {
        return this.zab.zad();
    }
}
