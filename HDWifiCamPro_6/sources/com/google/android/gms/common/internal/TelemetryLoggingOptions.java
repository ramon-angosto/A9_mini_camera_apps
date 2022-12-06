package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class TelemetryLoggingOptions implements Api.ApiOptions.Optional {
    public static final TelemetryLoggingOptions zaa = builder().build();
    private final String zab;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
    public static class Builder {
        private String zaa;

        private Builder() {
        }

        /* synthetic */ Builder(zaac zaac) {
        }

        public TelemetryLoggingOptions build() {
            return new TelemetryLoggingOptions(this.zaa, (zaad) null);
        }

        public Builder setApi(String str) {
            this.zaa = str;
            return this;
        }
    }

    /* synthetic */ TelemetryLoggingOptions(String str, zaad zaad) {
        this.zab = str;
    }

    public static Builder builder() {
        return new Builder((zaac) null);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelemetryLoggingOptions)) {
            return false;
        }
        return Objects.equal(this.zab, ((TelemetryLoggingOptions) obj).zab);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zab);
    }

    public final Bundle zaa() {
        Bundle bundle = new Bundle();
        String str = this.zab;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }
}
