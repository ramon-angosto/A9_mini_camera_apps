package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaso extends Handler {
    final /* synthetic */ zzasp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaso(zzasp zzasp, Looper looper) {
        super(looper);
        this.zza = zzasp;
    }

    public final void handleMessage(Message message) {
        this.zza.zzt(message);
    }
}
