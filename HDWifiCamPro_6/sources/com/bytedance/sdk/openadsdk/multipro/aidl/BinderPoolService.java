package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.b;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.g;

public class BinderPoolService extends Service {
    private Binder a = new a();

    public void onCreate() {
        super.onCreate();
        l.b("MultiProcess", "BinderPoolService has been created ! ");
    }

    public IBinder onBind(Intent intent) {
        l.b("MultiProcess", "BinderPoolService onBind ! ");
        return this.a;
    }

    public void onDestroy() {
        super.onDestroy();
        l.b("MultiProcess", "BinderPoolService is destroy ! ");
    }

    public static class a extends IBinderPool.Stub {
        public IBinder queryBinder(int i) throws RemoteException {
            l.c("MultiProcess", "queryBinder...........binderCode=" + i);
            if (i == 0) {
                return g.a();
            }
            if (i == 1) {
                return e.a();
            }
            if (i == 4) {
                return c.a();
            }
            if (i == 5) {
                return f.b();
            }
            if (i == 6) {
                return d.a();
            }
            if (i != 7) {
                return null;
            }
            return b.a();
        }
    }
}
