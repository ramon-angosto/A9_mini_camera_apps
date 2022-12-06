package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdo implements Handler.Callback {
    public final /* synthetic */ zzdt zza;

    public /* synthetic */ zzdo(zzdt zzdt) {
        this.zza = zzdt;
    }

    public final boolean handleMessage(Message message) {
        zzdt.zzg(this.zza, message);
        return true;
    }
}
