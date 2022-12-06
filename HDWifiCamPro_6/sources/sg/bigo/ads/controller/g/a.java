package sg.bigo.ads.controller.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.p.c;

public final class a extends BroadcastReceiver {
    private static volatile a a;
    private final List<C0131a> b = new ArrayList();

    /* renamed from: sg.bigo.ads.controller.g.a$a  reason: collision with other inner class name */
    public interface C0131a {
        void a(boolean z);
    }

    public static synchronized void a(Context context, C0131a aVar) {
        synchronized (a.class) {
            if (a == null) {
                a = new a();
                context.registerReceiver(a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            a.b.add(aVar);
        }
    }

    public final void onReceive(Context context, Intent intent) {
        boolean c = c.c(context);
        sg.bigo.ads.common.k.a.a(0, 3, "NetworkStateReceiver", "Network state changed, available: ".concat(String.valueOf(c)));
        for (C0131a a2 : this.b) {
            a2.a(c);
        }
    }
}
