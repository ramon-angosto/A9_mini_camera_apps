package sg.bigo.ads.common.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class a extends Handler {
    private String a;

    public a(String str, Looper looper) {
        super(looper);
        this.a = str;
    }

    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        return super.sendMessageAtTime(message, j);
    }

    public final String toString() {
        return "HandlerEx (" + this.a + ") {}";
    }
}
