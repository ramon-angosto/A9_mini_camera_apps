package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zaq;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zacz extends zaq {
    final /* synthetic */ zada zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacz(zada zada, Looper looper) {
        super(looper);
        this.zaa = zada;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.zaa.zae) {
                zada zada = (zada) Preconditions.checkNotNull(this.zaa.zab);
                if (pendingResult == null) {
                    zada.zaj(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zacp) {
                    zada.zaj(((zacp) pendingResult).zaa());
                } else {
                    zada.zai(pendingResult);
                }
            }
        } else if (i != 1) {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(70);
            sb.append("TransformationResultHandler received unknown message type: ");
            sb.append(i2);
            Log.e("TransformedResultImpl", sb.toString());
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
            throw runtimeException;
        }
    }
}
