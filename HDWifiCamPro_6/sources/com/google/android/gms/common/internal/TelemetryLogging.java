package com.google.android.gms.common.internal;

import android.content.Context;
import com.google.android.gms.common.internal.service.zao;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class TelemetryLogging {
    private TelemetryLogging() {
    }

    public static TelemetryLoggingClient getClient(Context context) {
        return getClient(context, TelemetryLoggingOptions.zaa);
    }

    public static TelemetryLoggingClient getClient(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        return new zao(context, telemetryLoggingOptions);
    }
}
