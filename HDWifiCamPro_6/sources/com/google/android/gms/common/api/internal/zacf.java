package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final /* synthetic */ class zacf implements Runnable {
    public final /* synthetic */ NonGmsServiceBrokerClient zaa;

    public /* synthetic */ zacf(NonGmsServiceBrokerClient nonGmsServiceBrokerClient) {
        this.zaa = nonGmsServiceBrokerClient;
    }

    public final void run() {
        this.zaa.zab();
    }
}
