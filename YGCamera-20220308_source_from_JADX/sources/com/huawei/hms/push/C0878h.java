package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.h */
/* compiled from: RemoteService */
public class C0878h {

    /* renamed from: a */
    public ServiceConnection f880a;

    /* renamed from: b */
    public Messenger f881b = null;

    /* renamed from: a */
    public boolean mo14284a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f880a = new C0877g(this, bundle, applicationContext);
        HMSLog.m1379i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f880a, 1);
    }
}
