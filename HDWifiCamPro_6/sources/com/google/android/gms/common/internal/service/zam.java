package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final /* synthetic */ class zam implements RemoteCall {
    public final /* synthetic */ TelemetryData zaa;

    public /* synthetic */ zam(TelemetryData telemetryData) {
        this.zaa = telemetryData;
    }

    public final void accept(Object obj, Object obj2) {
        TelemetryData telemetryData = this.zaa;
        int i = zao.zab;
        ((zai) ((zap) obj).getService()).zae(telemetryData);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
