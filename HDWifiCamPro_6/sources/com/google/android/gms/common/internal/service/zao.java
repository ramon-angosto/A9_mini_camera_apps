package com.google.android.gms.common.internal.service;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zao extends GoogleApi<TelemetryLoggingOptions> implements TelemetryLoggingClient {
    public static final /* synthetic */ int zab = 0;
    private static final Api.ClientKey<zap> zac = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zap, TelemetryLoggingOptions> zad = new zan();
    private static final Api<TelemetryLoggingOptions> zae = new Api<>("ClientTelemetry.API", zad, zac);

    public zao(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, zae, telemetryLoggingOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<Void> log(TelemetryData telemetryData) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(zad.zaa);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new zam(telemetryData));
        return doBestEffortWrite(builder.build());
    }
}
