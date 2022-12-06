package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzei implements zzdm {
    private Message zza;
    private zzej zzb;

    private zzei() {
    }

    /* synthetic */ zzei(zzeh zzeh) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzej.zzk(this);
    }

    public final zzei zzb(Message message, zzej zzej) {
        this.zza = message;
        this.zzb = zzej;
        return this;
    }

    public final void zza() {
        Message message = this.zza;
        if (message != null) {
            message.sendToTarget();
            zzd();
            return;
        }
        throw null;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        if (message != null) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
            zzd();
            return sendMessageAtFrontOfQueue;
        }
        throw null;
    }
}
