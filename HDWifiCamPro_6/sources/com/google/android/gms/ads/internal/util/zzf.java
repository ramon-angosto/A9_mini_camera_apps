package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfpz;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzf extends zzfpz {
    public zzf(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzt.zzo().zzt(e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(Message message) {
        try {
            super.zza(message);
        } catch (Throwable th) {
            zzt.zzp();
            zzs.zzI(zzt.zzo().zzc(), th);
            throw th;
        }
    }
}
