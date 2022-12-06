package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.mipush.sdk.as */
class C1573as implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C1568ao f1683a;

    C1573as(C1568ao aoVar) {
        this.f1683a = aoVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1683a) {
            Messenger unused = this.f1683a.f1671a = new Messenger(iBinder);
            boolean unused2 = this.f1683a.f1676c = false;
            for (Message send : C1568ao.m2312a(this.f1683a)) {
                try {
                    C1568ao.m2312a(this.f1683a).send(send);
                } catch (RemoteException e) {
                    C1524b.m2155a((Throwable) e);
                }
            }
            C1568ao.m2312a(this.f1683a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Messenger unused = this.f1683a.f1671a = null;
        boolean unused2 = this.f1683a.f1676c = false;
    }
}
