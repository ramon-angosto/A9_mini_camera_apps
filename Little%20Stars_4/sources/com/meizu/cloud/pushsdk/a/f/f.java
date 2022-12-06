package com.meizu.cloud.pushsdk.a.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meizu.cloud.pushsdk.a.e.o;
import com.meizu.cloud.pushsdk.a.g.a;
import java.lang.ref.WeakReference;

public class f extends Handler {
    private final WeakReference<o> a;

    public f(o oVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(oVar);
    }

    public void handleMessage(Message message) {
        o oVar = (o) this.a.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (oVar != null) {
            a aVar = (a) message.obj;
            oVar.a(aVar.a, aVar.b);
        }
    }
}
