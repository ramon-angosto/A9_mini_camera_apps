package com.ironsource.sdk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.environment.a;
import com.ironsource.sdk.g.e;
import com.ironsource.sdk.h.c;
import com.ironsource.sdk.utils.Logger;

public final class a extends Handler {
    public c a;

    public a(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.a == null) {
            Logger.i("DownloadHandler", "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            if (message.what != 1016) {
                this.a.a((c) message.obj, new e(message.what, a.AnonymousClass1.a(message.what)));
                return;
            }
            this.a.a((c) message.obj);
        } catch (Throwable th) {
            Logger.i("DownloadHandler", "handleMessage | Got exception: " + th.getMessage());
            th.printStackTrace();
        }
    }
}
