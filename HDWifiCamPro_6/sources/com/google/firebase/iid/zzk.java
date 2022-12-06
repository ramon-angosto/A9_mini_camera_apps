package com.google.firebase.iid;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzk implements EventHandler {
    private final FirebaseInstanceId.zza zza;

    zzk(FirebaseInstanceId.zza zza2) {
        this.zza = zza2;
    }

    public final void handle(Event event) {
        FirebaseInstanceId.zza zza2 = this.zza;
        synchronized (zza2) {
            if (zza2.zza()) {
                FirebaseInstanceId.this.zzj();
            }
        }
    }
}
