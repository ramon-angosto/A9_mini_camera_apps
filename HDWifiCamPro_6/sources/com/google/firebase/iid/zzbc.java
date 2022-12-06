package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzbc implements Runnable {
    private final zzbd zza;
    private final Intent zzb;

    zzbc(zzbd zzbd, Intent intent) {
        this.zza = zzbd;
        this.zzb = intent;
    }

    public final void run() {
        zzbd zzbd = this.zza;
        String action = this.zzb.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        zzbd.zza();
    }
}
