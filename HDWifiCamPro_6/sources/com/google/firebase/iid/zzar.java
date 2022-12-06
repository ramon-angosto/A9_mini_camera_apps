package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzar extends zze {
    private final /* synthetic */ zzao zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzao zzao, Looper looper) {
        super(looper);
        this.zza = zzao;
    }

    public final void handleMessage(Message message) {
        this.zza.zza(message);
    }
}
