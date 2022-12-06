package sg.bigo.ads.common.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.g.f;

class e implements ServiceConnection, IBinder.DeathRecipient {
    private static volatile e c;
    private static final Object d = new Object();
    final BlockingQueue<IBinder> a = new LinkedBlockingQueue(1);
    boolean b = false;
    private final Context e;

    private e(Context context) {
        this.e = context;
    }

    public static e a(Context context) {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e(context);
                }
            }
        }
        return c;
    }

    private void a(IBinder iBinder) {
        try {
            synchronized (d) {
                this.a.clear();
                this.a.add(iBinder);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            synchronized (d) {
                this.a.clear();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final f a(long j, TimeUnit timeUnit) {
        try {
            IBinder poll = this.a.poll(j, timeUnit);
            if (poll == null) {
                return null;
            }
            a(poll);
            return f.a.a(poll);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final synchronized void a() {
        if (this.b) {
            try {
                this.b = false;
                b();
                this.e.unbindService(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void binderDied() {
        a();
    }

    public void onBindingDied(ComponentName componentName) {
        a();
    }

    public void onNullBinding(ComponentName componentName) {
        a();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        b();
    }
}
