package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.service.bn */
class C2026bn implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ ServiceClient f3830a;

    C2026bn(ServiceClient serviceClient) {
        this.f3830a = serviceClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3830a) {
            Messenger unused = this.f3830a.f3589b = new Messenger(iBinder);
            boolean unused2 = this.f3830a.f3590b = false;
            for (Message send : ServiceClient.m4747a(this.f3830a)) {
                try {
                    ServiceClient.m4747a(this.f3830a).send(send);
                } catch (RemoteException e) {
                    C1524b.m2155a((Throwable) e);
                }
            }
            ServiceClient.m4747a(this.f3830a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Messenger unused = this.f3830a.f3589b = null;
        boolean unused2 = this.f3830a.f3590b = false;
    }
}
