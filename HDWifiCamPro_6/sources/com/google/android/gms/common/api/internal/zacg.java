package com.google.android.gms.common.api.internal;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final /* synthetic */ class zacg implements Runnable {
    public final /* synthetic */ NonGmsServiceBrokerClient zaa;
    public final /* synthetic */ IBinder zab;

    public /* synthetic */ zacg(NonGmsServiceBrokerClient nonGmsServiceBrokerClient, IBinder iBinder) {
        this.zaa = nonGmsServiceBrokerClient;
        this.zab = iBinder;
    }

    public final void run() {
        this.zaa.zaa(this.zab);
    }
}
