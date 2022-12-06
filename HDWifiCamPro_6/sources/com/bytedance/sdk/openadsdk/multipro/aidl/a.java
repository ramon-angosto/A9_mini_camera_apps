package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.multipro.b;

/* compiled from: BinderPool */
public class a {
    private static final a c = new a();
    /* access modifiers changed from: private */
    public static b d;
    private final Context a = m.a().getApplicationContext();
    /* access modifiers changed from: private */
    public IBinderPool b;
    /* access modifiers changed from: private */
    public long e = 0;
    private final ServiceConnection f = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName componentName) {
            l.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }

        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            w.a(new g("onServiceConnected") {
                public void run() {
                    IBinderPool unused = a.this.b = IBinderPool.Stub.asInterface(iBinder);
                    try {
                        a.this.b.asBinder().linkToDeath(a.this.g, 0);
                    } catch (RemoteException e) {
                        l.c("MultiProcess", "onServiceConnected throws :", (Throwable) e);
                    }
                    l.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.e));
                    if (a.d != null) {
                        a.d.onServiceConnected();
                    }
                }
            }, 5);
        }
    };
    /* access modifiers changed from: private */
    public final IBinder.DeathRecipient g = new IBinder.DeathRecipient() {
        public void binderDied() {
            w.a(new g("binderDied") {
                public void run() {
                    l.d("MultiProcess", "binder died.");
                    a.this.b.asBinder().unlinkToDeath(a.this.g, 0);
                    IBinderPool unused = a.this.b = null;
                    a.this.c();
                }
            }, 5);
        }
    };

    private a() {
        c();
    }

    public static a a(Context context) {
        return c;
    }

    public void a() {
        try {
            this.a.bindService(new Intent(this.a, BinderPoolService.class), this.f, 1);
            this.e = System.currentTimeMillis();
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar) {
        d = bVar;
    }

    public IBinder a(int i) {
        try {
            if (b.c()) {
                try {
                    if (this.b != null) {
                        return this.b.queryBinder(i);
                    }
                    return null;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    y.h("queryBinder error");
                    return null;
                }
            } else if (i == 0) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.a.g.a();
            } else {
                if (i == 1) {
                    return e.a();
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
                return com.bytedance.sdk.openadsdk.multipro.aidl.a.b.a();
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (b.c()) {
            l.c("MultiProcess", "BinderPool......connectBinderPoolService");
            a();
        }
    }
}
