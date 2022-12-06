package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public interface TelemetryLoggingClient extends HasApiKey<TelemetryLoggingOptions> {
    Task<Void> log(TelemetryData telemetryData);
}
