package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.opendevice.h */
/* compiled from: RemoteService */
public class C0854h {

    /* renamed from: a */
    public ServiceConnection f792a;

    /* renamed from: b */
    public Messenger f793b = null;

    /* renamed from: a */
    public boolean mo14163a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f792a = new C0853g(this, bundle, applicationContext);
        HMSLog.m1379i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f792a, 1);
    }
}
