package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zabc extends zaq {
    final /* synthetic */ zabe zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zabc(zabe zabe, Looper looper) {
        super(looper);
        this.zaa = zabe;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            zabe.zaj(this.zaa);
        } else if (i != 2) {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GoogleApiClientImpl", sb.toString());
        } else {
            zabe.zai(this.zaa);
        }
    }
}
