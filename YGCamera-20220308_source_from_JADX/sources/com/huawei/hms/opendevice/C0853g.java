package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.opendevice.g */
/* compiled from: RemoteService */
class C0853g implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ Bundle f789a;

    /* renamed from: b */
    public final /* synthetic */ Context f790b;

    /* renamed from: c */
    public final /* synthetic */ C0854h f791c;

    public C0853g(C0854h hVar, Bundle bundle, Context context) {
        this.f791c = hVar;
        this.f789a = bundle;
        this.f790b = context;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m1379i("RemoteService", "remote service onConnected");
        Messenger unused = this.f791c.f793b = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.f789a);
        try {
            this.f791c.f793b.send(obtain);
        } catch (RemoteException unused2) {
            HMSLog.m1379i("RemoteService", "remote service message send failed");
        }
        HMSLog.m1379i("RemoteService", "remote service unbindservice");
        this.f790b.unbindService(this.f791c.f792a);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m1379i("RemoteService", "remote service onDisconnected");
        Messenger unused = this.f791c.f793b = null;
    }
}
