package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zabx extends BroadcastReceiver {
    Context zaa;
    private final zabw zab;

    public zabx(zabw zabw) {
        this.zab = zabw;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.zab.zaa();
            zab();
        }
    }

    public final void zaa(Context context) {
        this.zaa = context;
    }

    public final synchronized void zab() {
        Context context = this.zaa;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.zaa = null;
    }
}
