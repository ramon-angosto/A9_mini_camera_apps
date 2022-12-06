package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.g */
/* compiled from: RemoteService */
class C0877g implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ Bundle f877a;

    /* renamed from: b */
    public final /* synthetic */ Context f878b;

    /* renamed from: c */
    public final /* synthetic */ C0878h f879c;

    public C0877g(C0878h hVar, Bundle bundle, Context context) {
        this.f879c = hVar;
        this.f877a = bundle;
        this.f878b = context;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m1379i("RemoteService", "remote service onConnected");
        Messenger unused = this.f879c.f881b = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.f877a);
        try {
            this.f879c.f881b.send(obtain);
        } catch (RemoteException unused2) {
            HMSLog.m1379i("RemoteService", "remote service message send failed");
        }
        HMSLog.m1379i("RemoteService", "remote service unbindservice");
        this.f878b.unbindService(this.f879c.f880a);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m1379i("RemoteService", "remote service onDisconnected");
        Messenger unused = this.f879c.f881b = null;
    }
}
