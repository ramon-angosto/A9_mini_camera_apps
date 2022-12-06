package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzqa extends Handler {
    final /* synthetic */ zzqc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzqa(zzqc zzqc, Looper looper) {
        super(looper);
        this.zza = zzqc;
    }

    public final void handleMessage(Message message) {
        zzqc.zza(this.zza, message);
    }
}
