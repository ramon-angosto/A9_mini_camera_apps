package com.bytedance.sdk.component.f.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler */
public class g extends Handler {
    private final WeakReference<a> a;

    /* compiled from: WeakHandler */
    public interface a {
        void a(Message message);
    }

    public g(Looper looper, a aVar) {
        super(looper);
        this.a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        a aVar = (a) this.a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
