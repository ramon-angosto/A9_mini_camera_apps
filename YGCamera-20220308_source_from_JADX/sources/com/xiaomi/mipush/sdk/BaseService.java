package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.lang.ref.WeakReference;

public abstract class BaseService extends Service {

    /* renamed from: a */
    private C1542a f1613a;

    /* renamed from: com.xiaomi.mipush.sdk.BaseService$a */
    public static class C1542a extends Handler {

        /* renamed from: a */
        private WeakReference<BaseService> f1614a;

        public C1542a(WeakReference<BaseService> weakReference) {
            this.f1614a = weakReference;
        }

        /* renamed from: a */
        public void mo17010a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000);
        }

        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what == 1001 && (weakReference = this.f1614a) != null && (baseService = (BaseService) weakReference.get()) != null) {
                C1524b.m2159c("TimeoutHandler " + baseService.toString() + " kill self");
                if (!baseService.mo17007a()) {
                    baseService.stopSelf();
                    return;
                }
                C1524b.m2159c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo17007a();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f1613a == null) {
            this.f1613a = new C1542a(new WeakReference(this));
        }
        this.f1613a.mo17010a();
    }
}
